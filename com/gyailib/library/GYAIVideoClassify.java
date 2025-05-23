package com.gyailib.library;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIVideoClassify {
    private long nativePtr;

    public native int cleanupModelData();

    public native int forwardDetect(Bitmap bitmap, GYVideoClassifyResult gYVideoClassifyResult, int i3);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int getResult(GYVideoClassifyResult gYVideoClassifyResult);

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public native int setupWithModel(SDKModelConfig sDKModelConfig);
}
