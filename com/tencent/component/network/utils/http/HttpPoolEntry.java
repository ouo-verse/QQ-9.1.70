package com.tencent.component.network.utils.http;

import com.tencent.component.network.utils.http.pool.PoolEntry;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;

/* loaded from: classes5.dex */
class HttpPoolEntry extends PoolEntry<HttpRoute, OperatedClientConnection> {
    HttpRoute route;
    private RouteTracker tracker;

    public HttpPoolEntry(Log log, String str, HttpRoute httpRoute, OperatedClientConnection operatedClientConnection, long j3, TimeUnit timeUnit) {
        super(str, httpRoute, operatedClientConnection, j3, timeUnit);
        this.route = httpRoute;
        this.tracker = new RouteTracker(httpRoute);
    }

    @Override // com.tencent.component.network.utils.http.pool.PoolEntry
    public void close() {
        try {
            getConnection().close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRoute getEffectiveRoute() {
        return this.tracker.toRoute();
    }

    HttpRoute getPlannedRoute() {
        return getRoute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteTracker getTracker() {
        return this.tracker;
    }

    @Override // com.tencent.component.network.utils.http.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }

    @Override // com.tencent.component.network.utils.http.pool.PoolEntry
    public boolean isExpired(long j3) {
        return super.isExpired(j3);
    }

    public void resetTracker() {
        this.tracker = new RouteTracker(this.route);
    }
}
