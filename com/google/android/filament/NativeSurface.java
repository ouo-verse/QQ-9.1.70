package com.google.android.filament;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NativeSurface {
    private final int mHeight;
    private final long mNativeObject;
    private final int mWidth;

    public NativeSurface(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
        this.mNativeObject = nCreateSurface(i3, i16);
    }

    private static native long nCreateSurface(int i3, int i16);

    private static native void nDestroySurface(long j3);

    public void dispose() {
        nDestroySurface(this.mNativeObject);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
