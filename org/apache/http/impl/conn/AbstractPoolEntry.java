package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
/* loaded from: classes29.dex */
public abstract class AbstractPoolEntry {
    protected final ClientConnectionOperator connOperator;
    protected final OperatedClientConnection connection;
    protected volatile HttpRoute route;
    protected volatile Object state;
    protected volatile RouteTracker tracker;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute) {
        throw new RuntimeException("Stub!");
    }

    public Object getState() {
        throw new RuntimeException("Stub!");
    }

    public void layerProtocol(HttpContext httpContext, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void setState(Object obj) {
        throw new RuntimeException("Stub!");
    }

    protected void shutdownEntry() {
        throw new RuntimeException("Stub!");
    }

    public void tunnelProxy(HttpHost httpHost, boolean z16, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void tunnelTarget(boolean z16, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
