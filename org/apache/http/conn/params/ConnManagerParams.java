package org.apache.http.conn.params;

import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes29.dex */
public final class ConnManagerParams implements ConnManagerPNames {
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;

    public ConnManagerParams() {
        throw new RuntimeException("Stub!");
    }

    public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public static int getMaxTotalConnections(HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public static long getTimeout(HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public static void setMaxConnectionsPerRoute(HttpParams httpParams, ConnPerRoute connPerRoute) {
        throw new RuntimeException("Stub!");
    }

    public static void setMaxTotalConnections(HttpParams httpParams, int i3) {
        throw new RuntimeException("Stub!");
    }

    public static void setTimeout(HttpParams httpParams, long j3) {
        throw new RuntimeException("Stub!");
    }
}
