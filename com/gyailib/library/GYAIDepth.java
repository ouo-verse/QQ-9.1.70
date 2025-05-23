package com.gyailib.library;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIDepth {
    private long nativePtr;

    public native int cleanupModelData();

    public native Bitmap forwardSeg(Bitmap bitmap, int i3);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public native int setupSmootherWithConfig(SegmentSmoothConfig segmentSmoothConfig);

    public native int setupWithModel(SDKModelConfig sDKModelConfig);
}
