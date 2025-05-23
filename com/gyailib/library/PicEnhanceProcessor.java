package com.gyailib.library;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class PicEnhanceProcessor {
    private long nativePtr;

    public native int cleanupModelData();

    public native Bitmap forward(Bitmap bitmap, PicEnhanceOptions picEnhanceOptions, double d16, int i3);

    public native int forwardTex(int i3, int i16, PicEnhanceOptions picEnhanceOptions, int i17);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public native int setupWithModel(SDKModelConfig sDKModelConfig);
}
