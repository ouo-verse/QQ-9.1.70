package com.github.luben.zstd;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdException extends RuntimeException {
    private long code;

    public ZstdException(long j3) {
        this(Zstd.getErrorCode(j3), Zstd.getErrorName(j3));
    }

    public long getErrorCode() {
        return this.code;
    }

    public ZstdException(long j3, String str) {
        super(str);
        this.code = j3;
    }
}
