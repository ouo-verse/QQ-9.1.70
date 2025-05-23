package com.tencent.component.network.utils.http;

import com.tencent.component.network.utils.http.pool.ConnPoolControl;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import com.tencent.component.network.utils.http.pool.PoolStats;
import com.tencent.component.network.utils.http.pool.QzoneClientConnectionOperator;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;

/* loaded from: classes5.dex */
public class PoolingClientConnectionManager implements ClientConnectionManager, ConnPoolControl<HttpRoute> {
    private final CustomDnsResolve customDnsResolve;
    private final DnsResolver dnsResolver;
    private final ClientConnectionOperator operator;
    private final HttpConnPool pool;
    private final SchemeRegistry schemeRegistry;

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS);
    }

    private String format(HttpRoute httpRoute, Object obj) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[route: ");
        sb5.append(httpRoute);
        sb5.append("]");
        if (obj != null) {
            sb5.append("[state: ");
            sb5.append(obj);
            sb5.append("]");
        }
        return sb5.toString();
    }

    private String formatStats(HttpRoute httpRoute) {
        StringBuilder sb5 = new StringBuilder();
        PoolStats totalStats = this.pool.getTotalStats();
        PoolStats stats = this.pool.getStats(httpRoute);
        sb5.append("[total kept alive: ");
        sb5.append(totalStats.getAvailable());
        sb5.append("; ");
        sb5.append("route allocated: ");
        sb5.append(stats.getLeased() + stats.getAvailable());
        sb5.append(" of ");
        sb5.append(stats.getMax());
        sb5.append("; ");
        sb5.append("total allocated: ");
        sb5.append(totalStats.getLeased() + totalStats.getAvailable());
        sb5.append(" of ");
        sb5.append(totalStats.getMax());
        sb5.append("]");
        return sb5.toString();
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        this.pool.closeExpired();
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void closeIdleConnections(long j3, TimeUnit timeUnit) {
        this.pool.closeIdle(j3, timeUnit);
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new QzoneClientConnectionOperator(schemeRegistry, this.customDnsResolve);
    }

    protected void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    ManagedClientConnection leaseConnection(Future<HttpPoolEntry> future, long j3, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
        try {
            HttpPoolEntry httpPoolEntry = future.get(j3, timeUnit);
            if (httpPoolEntry != null && !future.isCancelled()) {
                if (httpPoolEntry.getConnection() != null) {
                    return new ManagedClientConnectionImpl(this, this.operator, httpPoolEntry);
                }
                throw new IllegalStateException("Pool entry with no connection");
            }
            throw new InterruptedException();
        } catch (ExecutionException e16) {
            e16.getCause();
            throw new InterruptedException();
        } catch (TimeoutException unused) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection managedClientConnection, long j3, TimeUnit timeUnit) {
        if (managedClientConnection instanceof ManagedClientConnectionImpl) {
            ManagedClientConnectionImpl managedClientConnectionImpl = (ManagedClientConnectionImpl) managedClientConnection;
            if (managedClientConnectionImpl.getManager() == this) {
                synchronized (managedClientConnectionImpl) {
                    HttpPoolEntry detach = managedClientConnectionImpl.detach();
                    if (detach == null) {
                        return;
                    }
                    try {
                        if (managedClientConnectionImpl.isOpen() && !managedClientConnectionImpl.isMarkedReusable()) {
                            try {
                                managedClientConnectionImpl.shutdown();
                            } catch (IOException unused) {
                            }
                        }
                        if (managedClientConnectionImpl.isMarkedReusable()) {
                            if (timeUnit == null) {
                                timeUnit = TimeUnit.MILLISECONDS;
                            }
                            detach.updateExpiry(j3, timeUnit);
                        }
                        return;
                    } finally {
                        this.pool.release((HttpConnPool) detach, managedClientConnectionImpl.isMarkedReusable());
                    }
                }
            }
            throw new IllegalStateException("Connection not obtained from this manager.");
        }
        throw new IllegalArgumentException("Connection class mismatch, connection not obtained from this manager.");
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        if (httpRoute != null) {
            final Future<HttpPoolEntry> lease = this.pool.lease(httpRoute, obj);
            return new ClientConnectionRequest() { // from class: com.tencent.component.network.utils.http.PoolingClientConnectionManager.1
                @Override // org.apache.http.conn.ClientConnectionRequest
                public void abortRequest() {
                    lease.cancel(true);
                }

                @Override // org.apache.http.conn.ClientConnectionRequest
                public ManagedClientConnection getConnection(long j3, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                    return PoolingClientConnectionManager.this.leaseConnection(lease, j3, timeUnit);
                }
            };
        }
        throw new IllegalArgumentException("HTTP route may not be null");
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i3) {
        this.pool.setDefaultMaxPerRoute(i3);
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public void setMaxTotal(int i3) {
        this.pool.setMaxTotal(i3);
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void shutdown() {
        try {
            this.pool.shutdown();
        } catch (IOException unused) {
        }
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS, dnsResolver, null);
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public int getMaxPerRoute(HttpRoute httpRoute) {
        return this.pool.getMaxPerRoute(httpRoute);
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public PoolStats getStats(HttpRoute httpRoute) {
        return this.pool.getStats(httpRoute);
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public void setMaxPerRoute(HttpRoute httpRoute, int i3) {
        this.pool.setMaxPerRoute(httpRoute, i3);
    }

    public PoolingClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j3, TimeUnit timeUnit) {
        this(schemeRegistry, j3, timeUnit, new SystemDefaultDnsResolver(), null);
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j3, TimeUnit timeUnit, DnsResolver dnsResolver, CustomDnsResolve customDnsResolve) {
        if (schemeRegistry == null) {
            throw new IllegalArgumentException("Scheme registry may not be null");
        }
        if (dnsResolver != null) {
            this.schemeRegistry = schemeRegistry;
            this.dnsResolver = dnsResolver;
            this.customDnsResolve = customDnsResolve;
            this.operator = createConnectionOperator(schemeRegistry);
            this.pool = new HttpConnPool(null, 2, 20, j3, timeUnit);
            return;
        }
        throw new IllegalArgumentException("DNS resolver may not be null");
    }

    private String format(HttpPoolEntry httpPoolEntry) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[id: ");
        sb5.append(httpPoolEntry.getId());
        sb5.append("]");
        sb5.append("[route: ");
        sb5.append(httpPoolEntry.getRoute());
        sb5.append("]");
        Object state = httpPoolEntry.getState();
        if (state != null) {
            sb5.append("[state: ");
            sb5.append(state);
            sb5.append("]");
        }
        return sb5.toString();
    }
}
