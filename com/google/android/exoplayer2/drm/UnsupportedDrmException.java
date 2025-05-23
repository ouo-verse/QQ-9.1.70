package com.google.android.exoplayer2.drm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class UnsupportedDrmException extends Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Reason {
    }

    public UnsupportedDrmException(int i3) {
        this.reason = i3;
    }

    public UnsupportedDrmException(int i3, Exception exc) {
        super(exc);
        this.reason = i3;
    }
}
