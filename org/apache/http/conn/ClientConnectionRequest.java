package org.apache.http.conn;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j3, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
