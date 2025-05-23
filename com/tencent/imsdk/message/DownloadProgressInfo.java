package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class DownloadProgressInfo implements Serializable {
    private long currentSize;
    private long totalSize;

    public DownloadProgressInfo(long j3, long j16) {
        this.currentSize = j3;
        this.totalSize = j16;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    public long getTotalSize() {
        return this.totalSize;
    }
}
