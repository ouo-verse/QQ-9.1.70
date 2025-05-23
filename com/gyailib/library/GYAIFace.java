package com.gyailib.library;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIFace {
    private long nativePtr;

    public native int cleanupModelData();

    public native int clearCachedData();

    public native int forwardDetect(Bitmap bitmap, FaceDetector faceDetector, int i3);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    @Deprecated
    public native int registerFaceLicense(String str);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public native int setupWithModel(SDKModelConfig sDKModelConfig);
}
