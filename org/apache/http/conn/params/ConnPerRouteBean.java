package org.apache.http.conn.params;

import java.util.Map;
import org.apache.http.conn.routing.HttpRoute;

@Deprecated
/* loaded from: classes29.dex */
public final class ConnPerRouteBean implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;

    public ConnPerRouteBean(int i3) {
        throw new RuntimeException("Stub!");
    }

    public int getDefaultMax() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.params.ConnPerRoute
    public int getMaxForRoute(HttpRoute httpRoute) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultMaxPerRoute(int i3) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i3) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxForRoutes(Map<HttpRoute, Integer> map) {
        throw new RuntimeException("Stub!");
    }

    public ConnPerRouteBean() {
        throw new RuntimeException("Stub!");
    }
}
