package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface ClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long j3, TimeUnit timeUnit);

    SchemeRegistry getSchemeRegistry();

    void releaseConnection(ManagedClientConnection managedClientConnection, long j3, TimeUnit timeUnit);

    ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj);

    void shutdown();
}
