package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class ExchangeFinder {

    @NotNull
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(@NotNull RealConnectionPool connectionPool, @NotNull Address address, @NotNull RealCall call, @NotNull EventListener eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final RealConnection findConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled) throws IOException {
        List<Route> routes;
        Socket releaseConnectionNoEvents$okhttp;
        if (!this.call.getCanceled()) {
            RealConnection connection = this.call.getConnection();
            boolean z16 = true;
            if (connection != null) {
                synchronized (connection) {
                    if (!connection.getNoNewExchanges() && sameHostAndPort(connection.getRoute().address().url())) {
                        releaseConnectionNoEvents$okhttp = null;
                        Unit unit = Unit.INSTANCE;
                    }
                    releaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
                    Unit unit2 = Unit.INSTANCE;
                }
                if (this.call.getConnection() != null) {
                    if (releaseConnectionNoEvents$okhttp != null) {
                        z16 = false;
                    }
                    if (z16) {
                        return connection;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (releaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this.call, connection);
            }
            this.refusedStreamCount = 0;
            this.connectionShutdownCount = 0;
            this.otherFailureCount = 0;
            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                RealConnection connection2 = this.call.getConnection();
                Intrinsics.checkNotNull(connection2);
                this.eventListener.connectionAcquired(this.call, connection2);
                return connection2;
            }
            Route route = this.nextRouteToTry;
            try {
                if (route != null) {
                    Intrinsics.checkNotNull(route);
                    this.nextRouteToTry = null;
                } else {
                    RouteSelector.Selection selection = this.routeSelection;
                    if (selection != null) {
                        Intrinsics.checkNotNull(selection);
                        if (selection.hasNext()) {
                            RouteSelector.Selection selection2 = this.routeSelection;
                            Intrinsics.checkNotNull(selection2);
                            route = selection2.next();
                        }
                    }
                    RouteSelector routeSelector = this.routeSelector;
                    if (routeSelector == null) {
                        routeSelector = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                        this.routeSelector = routeSelector;
                    }
                    RouteSelector.Selection next = routeSelector.next();
                    this.routeSelection = next;
                    routes = next.getRoutes();
                    if (!this.call.getCanceled()) {
                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, false)) {
                            RealConnection connection3 = this.call.getConnection();
                            Intrinsics.checkNotNull(connection3);
                            this.eventListener.connectionAcquired(this.call, connection3);
                            return connection3;
                        }
                        route = next.next();
                        RealConnection realConnection = new RealConnection(this.connectionPool, route);
                        this.call.setConnectionToCancel(realConnection);
                        realConnection.connect(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
                        this.call.setConnectionToCancel(null);
                        this.call.getClient().getRouteDatabase().connected(realConnection.getRoute());
                        if (!this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                            RealConnection connection4 = this.call.getConnection();
                            Intrinsics.checkNotNull(connection4);
                            this.nextRouteToTry = route;
                            Util.closeQuietly(realConnection.socket());
                            this.eventListener.connectionAcquired(this.call, connection4);
                            return connection4;
                        }
                        synchronized (realConnection) {
                            this.connectionPool.put(realConnection);
                            this.call.acquireConnectionNoEvents(realConnection);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        this.eventListener.connectionAcquired(this.call, realConnection);
                        return realConnection;
                    }
                    throw new IOException("Canceled");
                }
                realConnection.connect(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
                this.call.setConnectionToCancel(null);
                this.call.getClient().getRouteDatabase().connected(realConnection.getRoute());
                if (!this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                }
            } catch (Throwable th5) {
                this.call.setConnectionToCancel(null);
                throw th5;
            }
            routes = null;
            RealConnection realConnection2 = new RealConnection(this.connectionPool, route);
            this.call.setConnectionToCancel(realConnection2);
        } else {
            throw new IOException("Canceled");
        }
    }

    private final RealConnection findHealthyConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, boolean doExtensiveHealthChecks) throws IOException {
        boolean z16;
        while (true) {
            RealConnection findConnection = findConnection(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled);
            if (findConnection.isHealthy(doExtensiveHealthChecks)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                boolean z17 = true;
                if (selection != null) {
                    z16 = selection.hasNext();
                } else {
                    z16 = true;
                }
                if (z16) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.routeSelector;
                    if (routeSelector != null) {
                        z17 = routeSelector.hasNext();
                    }
                    if (!z17) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.getRoute().address().url(), this.address.url())) {
                return null;
            }
            return connection.getRoute();
        }
    }

    @NotNull
    public final ExchangeCodec find(@NotNull OkHttpClient client, @NotNull RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            return findHealthyConnection(chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis(), chain.getWriteTimeoutMillis(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !Intrinsics.areEqual(chain.getRequest().method(), "GET")).newCodec$okhttp(client, chain);
        } catch (IOException e16) {
            trackFailure(e16);
            throw new RouteException(e16);
        } catch (RouteException e17) {
            trackFailure(e17.getLastConnectException());
            throw e17;
        }
    }

    @NotNull
    /* renamed from: getAddress$okhttp, reason: from getter */
    public final Address getAddress() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection != null && selection.hasNext()) || (routeSelector = this.routeSelector) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    public final boolean sameHostAndPort(@NotNull HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl url2 = this.address.url();
        if (url.port() == url2.port() && Intrinsics.areEqual(url.host(), url2.host())) {
            return true;
        }
        return false;
    }

    public final void trackFailure(@NotNull IOException e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        this.nextRouteToTry = null;
        if ((e16 instanceof StreamResetException) && ((StreamResetException) e16).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (e16 instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
