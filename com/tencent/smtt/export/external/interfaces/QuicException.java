package com.tencent.smtt.export.external.interfaces;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class QuicException extends NetworkException {
    protected QuicException(String str, Throwable th5) {
        super(str, th5);
    }

    public abstract int getQuicDetailedErrorCode();
}
