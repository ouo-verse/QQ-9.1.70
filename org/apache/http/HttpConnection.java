package org.apache.http;

import java.io.IOException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpConnection {
    void close() throws IOException;

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i3);

    void shutdown() throws IOException;
}
