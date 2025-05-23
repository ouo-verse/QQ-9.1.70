package com.gyailib.library;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIEmotionScore {
    private long nativePtr;

    public native int cleanupModelData();

    public native int forwardDetect(Bitmap bitmap, Rect rect, float[] fArr, GYDetectCommonResultStruct gYDetectCommonResultStruct, int i3);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public native int setupWithModel(SDKModelConfig sDKModelConfig);
}
