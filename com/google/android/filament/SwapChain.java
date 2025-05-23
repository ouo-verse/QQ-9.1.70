package com.google.android.filament;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SwapChain {
    public static final long CONFIG_DEFAULT = 0;
    public static final long CONFIG_ENABLE_XCB = 4;
    public static final long CONFIG_READABLE = 2;
    public static final long CONFIG_TRANSPARENT = 1;
    private long mNativeObject;
    private final Object mSurface;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SwapChain(long j3, Object obj) {
        this.mNativeObject = j3;
        this.mSurface = obj;
    }

    private static native void nSetFrameCompletedCallback(long j3, Object obj, Runnable runnable);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed SwapChain");
    }

    public Object getNativeWindow() {
        return this.mSurface;
    }

    public void setFrameCompletedCallback(@NonNull Object obj, @NonNull Runnable runnable) {
        nSetFrameCompletedCallback(getNativeObject(), obj, runnable);
    }
}
