package com.tencent.component.network.utils.http;

import com.tencent.component.network.module.base.QDLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes5.dex */
class ManagedClientConnectionImpl implements ManagedClientConnection {
    private volatile long duration;
    private final ClientConnectionManager manager;
    private final ClientConnectionOperator operator;
    private volatile HttpPoolEntry poolEntry;
    private volatile boolean reusable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedClientConnectionImpl(ClientConnectionManager clientConnectionManager, ClientConnectionOperator clientConnectionOperator, HttpPoolEntry httpPoolEntry) {
        if (clientConnectionManager != null) {
            if (clientConnectionOperator != null) {
                if (httpPoolEntry != null) {
                    this.manager = clientConnectionManager;
                    this.operator = clientConnectionOperator;
                    this.poolEntry = httpPoolEntry;
                    this.reusable = false;
                    this.duration = Long.MAX_VALUE;
                    return;
                }
                throw new IllegalArgumentException("HTTP pool entry may not be null");
            }
            throw new IllegalArgumentException("Connection operator may not be null");
        }
        throw new IllegalArgumentException("Connection manager may not be null");
    }

    private OperatedClientConnection ensureConnection() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            return httpPoolEntry.getConnection();
        }
        throw new ConnectionShutdownException();
    }

    private HttpPoolEntry ensurePoolEntry() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            return httpPoolEntry;
        }
        throw new ConnectionShutdownException();
    }

    private OperatedClientConnection getConnection() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry == null) {
            return null;
        }
        return httpPoolEntry.getConnection();
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        synchronized (this) {
            if (this.poolEntry == null) {
                return;
            }
            this.reusable = false;
            try {
                this.poolEntry.getConnection().shutdown();
            } catch (IOException unused) {
            }
            this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
            this.poolEntry = null;
        }
    }

    @Override // org.apache.http.HttpConnection
    public void close() throws IOException {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            OperatedClientConnection connection = httpPoolEntry.getConnection();
            httpPoolEntry.resetTracker();
            connection.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpPoolEntry detach() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        this.poolEntry = null;
        return httpPoolEntry;
    }

    @Override // org.apache.http.HttpClientConnection
    public void flush() throws IOException {
        ensureConnection().flush();
    }

    public Object getAttribute(String str) {
        OperatedClientConnection ensureConnection = ensureConnection();
        if (ensureConnection instanceof HttpContext) {
            return ((HttpContext) ensureConnection).getAttribute(str);
        }
        return null;
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        return ensureConnection().getLocalAddress();
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        return ensureConnection().getLocalPort();
    }

    public ClientConnectionManager getManager() {
        return this.manager;
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return ensureConnection().getMetrics();
    }

    HttpPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        return ensureConnection().getRemoteAddress();
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        return ensureConnection().getRemotePort();
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public HttpRoute getRoute() {
        return ensurePoolEntry().getEffectiveRoute();
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public SSLSession getSSLSession() {
        Socket socket = ensureConnection().getSocket();
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getSession();
        }
        return null;
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        return ensureConnection().getSocketTimeout();
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public Object getState() {
        return ensurePoolEntry().getState();
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public boolean isMarkedReusable() {
        return this.reusable;
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        OperatedClientConnection connection = getConnection();
        if (connection != null) {
            return connection.isOpen();
        }
        return false;
    }

    @Override // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int i3) throws IOException {
        return ensureConnection().isResponseAvailable(i3);
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public boolean isSecure() {
        return ensureConnection().isSecure();
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        OperatedClientConnection connection = getConnection();
        if (connection != null) {
            return connection.isStale();
        }
        return true;
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void layerProtocol(HttpContext httpContext, HttpParams httpParams) throws IOException {
        HttpHost targetHost;
        OperatedClientConnection connection;
        if (httpParams != null) {
            synchronized (this) {
                if (this.poolEntry != null) {
                    RouteTracker tracker = this.poolEntry.getTracker();
                    if (tracker.isConnected()) {
                        if (tracker.isTunnelled()) {
                            if (!tracker.isLayered()) {
                                targetHost = tracker.getTargetHost();
                                connection = this.poolEntry.getConnection();
                            } else {
                                throw new IllegalStateException("Multiple protocol layering not supported");
                            }
                        } else {
                            throw new IllegalStateException("Protocol layering without a tunnel not supported");
                        }
                    } else {
                        throw new IllegalStateException("Connection not open");
                    }
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.operator.updateSecureConnection(connection, targetHost, httpContext, httpParams);
            synchronized (this) {
                if (this.poolEntry != null) {
                    this.poolEntry.getTracker().layerProtocol(connection.isSecure());
                } else {
                    throw new InterruptedIOException();
                }
            }
            return;
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void markReusable() {
        this.reusable = true;
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) throws IOException {
        OperatedClientConnection connection;
        HttpHost targetHost;
        if (httpRoute != null) {
            if (httpParams != null) {
                synchronized (this) {
                    if (this.poolEntry != null) {
                        if (!this.poolEntry.getTracker().isConnected()) {
                            connection = this.poolEntry.getConnection();
                            if (QDLog.isInfoEnable()) {
                                QDLog.i("http", "host:" + connection.getTargetHost() + "   " + connection.getLocalAddress() + ":" + connection.getLocalPort() + "   " + connection.getRemoteAddress() + ":" + connection.getRemotePort());
                            }
                        } else {
                            throw new IllegalStateException("Connection already open");
                        }
                    } else {
                        throw new ConnectionShutdownException();
                    }
                }
                HttpHost proxyHost = httpRoute.getProxyHost();
                try {
                    ClientConnectionOperator clientConnectionOperator = this.operator;
                    if (proxyHost != null) {
                        targetHost = proxyHost;
                    } else {
                        targetHost = httpRoute.getTargetHost();
                    }
                    clientConnectionOperator.openConnection(connection, targetHost, httpRoute.getLocalAddress(), httpContext, httpParams);
                } catch (Exception e16) {
                    QDLog.e("ManagedClientConnectionImpl", "open " + e16.getMessage());
                }
                synchronized (this) {
                    if (this.poolEntry != null) {
                        RouteTracker tracker = this.poolEntry.getTracker();
                        if (proxyHost == null) {
                            tracker.connectTarget(connection.isSecure());
                        } else {
                            tracker.connectProxy(proxyHost, connection.isSecure());
                        }
                    } else {
                        throw new InterruptedIOException();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        throw new IllegalArgumentException("Route may not be null");
    }

    @Override // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        ensureConnection().receiveResponseEntity(httpResponse);
    }

    @Override // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        return ensureConnection().receiveResponseHeader();
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        synchronized (this) {
            if (this.poolEntry == null) {
                return;
            }
            this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
            this.poolEntry = null;
        }
    }

    public Object removeAttribute(String str) {
        OperatedClientConnection ensureConnection = ensureConnection();
        if (ensureConnection instanceof HttpContext) {
            return ((HttpContext) ensureConnection).removeAttribute(str);
        }
        return null;
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        ensureConnection().sendRequestEntity(httpEntityEnclosingRequest);
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        ensureConnection().sendRequestHeader(httpRequest);
    }

    public void setAttribute(String str, Object obj) {
        OperatedClientConnection ensureConnection = ensureConnection();
        if (ensureConnection instanceof HttpContext) {
            ((HttpContext) ensureConnection).setAttribute(str, obj);
        }
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void setIdleDuration(long j3, TimeUnit timeUnit) {
        if (j3 > 0) {
            this.duration = timeUnit.toMillis(j3);
        } else {
            this.duration = -1L;
        }
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i3) {
        ensureConnection().setSocketTimeout(i3);
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void setState(Object obj) {
        ensurePoolEntry().setState(obj);
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            OperatedClientConnection connection = httpPoolEntry.getConnection();
            httpPoolEntry.resetTracker();
            connection.shutdown();
        }
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void tunnelProxy(HttpHost httpHost, boolean z16, HttpParams httpParams) throws IOException {
        OperatedClientConnection connection;
        if (httpHost != null) {
            if (httpParams != null) {
                synchronized (this) {
                    if (this.poolEntry != null) {
                        if (this.poolEntry.getTracker().isConnected()) {
                            connection = this.poolEntry.getConnection();
                        } else {
                            throw new IllegalStateException("Connection not open");
                        }
                    } else {
                        throw new ConnectionShutdownException();
                    }
                }
                connection.update(null, httpHost, z16, httpParams);
                synchronized (this) {
                    if (this.poolEntry != null) {
                        this.poolEntry.getTracker().tunnelProxy(httpHost, z16);
                    } else {
                        throw new InterruptedIOException();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        throw new IllegalArgumentException("Next proxy amy not be null");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void tunnelTarget(boolean z16, HttpParams httpParams) throws IOException {
        HttpHost targetHost;
        OperatedClientConnection connection;
        if (httpParams != null) {
            synchronized (this) {
                if (this.poolEntry != null) {
                    RouteTracker tracker = this.poolEntry.getTracker();
                    if (tracker.isConnected()) {
                        if (!tracker.isTunnelled()) {
                            targetHost = tracker.getTargetHost();
                            connection = this.poolEntry.getConnection();
                        } else {
                            throw new IllegalStateException("Connection is already tunnelled");
                        }
                    } else {
                        throw new IllegalStateException("Connection not open");
                    }
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            connection.update(null, targetHost, z16, httpParams);
            synchronized (this) {
                if (this.poolEntry != null) {
                    this.poolEntry.getTracker().tunnelTarget(z16);
                } else {
                    throw new InterruptedIOException();
                }
            }
            return;
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void unmarkReusable() {
        this.reusable = false;
    }
}
