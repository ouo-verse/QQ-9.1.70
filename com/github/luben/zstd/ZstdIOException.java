package com.github.luben.zstd;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdIOException extends IOException {
    private long code;

    public ZstdIOException(long j3) {
        this(Zstd.getErrorCode(j3), Zstd.getErrorName(j3));
    }

    public long getErrorCode() {
        return this.code;
    }

    public ZstdIOException(long j3, String str) {
        super(str);
        this.code = j3;
    }
}
