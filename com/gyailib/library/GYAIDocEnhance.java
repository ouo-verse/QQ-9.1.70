package com.gyailib.library;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIDocEnhance {
    private long nativePtr;

    public native int documentCornerValid(float[] fArr);

    public native Bitmap documentDeshadow(Bitmap bitmap);

    public native float[] documentDetect(Bitmap bitmap);

    public native Bitmap documentEnhance(Bitmap bitmap);

    public native Bitmap documentWarp(Bitmap bitmap, float[] fArr);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }
}
