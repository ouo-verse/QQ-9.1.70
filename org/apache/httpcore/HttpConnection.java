package org.apache.httpcore;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpConnection extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i3);

    void shutdown() throws IOException;
}
