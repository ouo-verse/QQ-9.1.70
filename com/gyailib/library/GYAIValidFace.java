package com.gyailib.library;

import android.graphics.Bitmap;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAIValidFace {
    public HashMap<String, Float> faceMap;
    private long nativePtr;

    public native int cleanupModelData();

    public native Bitmap falignImageWithPoints(Bitmap bitmap, float[] fArr, int i3);

    public native int fittingAvatarExpresssionWeights(Bitmap bitmap, float[] fArr, float f16, HashMap hashMap, int i3);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public void setValidFaceMap(String str, float f16) {
        this.faceMap.put(str, Float.valueOf(f16));
    }

    public native int setupWithModel(SDKModelConfig sDKModelConfig);

    public native int validatePhotoQuality(Bitmap bitmap, float[] fArr, ValidFacePhotoQuality validFacePhotoQuality, int i3);
}
