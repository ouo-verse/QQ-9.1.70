package com.gyailib.library;

import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class GYAIKeyPoints {
    public static final int TYPE_CAT = 1;
    public static final int TYPE_FULL_BODY = 2;
    private long nativePtr;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface KeyPointsType {
    }

    public native int cleanupModelData();

    public native int forwardDetect(Bitmap bitmap, GYDetectCommonResultStruct gYDetectCommonResultStruct, int i3);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    public int initInstance(SDKDeviceConfig sDKDeviceConfig, int i3) {
        if (i3 == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put("type_full_body", "true");
            sDKDeviceConfig.setInfos(hashMap);
        }
        return initInstance(sDKDeviceConfig);
    }

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public native int setupWithModel(SDKModelConfig sDKModelConfig);
}
