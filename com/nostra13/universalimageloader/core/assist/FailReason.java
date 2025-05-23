package com.nostra13.universalimageloader.core.assist;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FailReason {
    private final Throwable cause;
    private final FailType type;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th5) {
        this.type = failType;
        this.cause = th5;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public FailType getType() {
        return this.type;
    }
}
