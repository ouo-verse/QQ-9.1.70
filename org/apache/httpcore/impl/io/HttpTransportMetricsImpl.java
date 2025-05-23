package org.apache.httpcore.impl.io;

import org.apache.httpcore.io.HttpTransportMetrics;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred = 0;

    @Override // org.apache.httpcore.io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void incrementBytesTransferred(long j3) {
        this.bytesTransferred += j3;
    }

    @Override // org.apache.httpcore.io.HttpTransportMetrics
    public void reset() {
        this.bytesTransferred = 0L;
    }

    public void setBytesTransferred(long j3) {
        this.bytesTransferred = j3;
    }
}
