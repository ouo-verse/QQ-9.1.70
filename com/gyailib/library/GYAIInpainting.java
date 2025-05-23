package com.gyailib.library;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIInpainting {
    private long nativePtr;

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native Bitmap inpainting(Bitmap bitmap, Bitmap bitmap2);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }
}
