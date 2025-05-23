package com.gyailib.library;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GYAISceneChain {
    private long nativePtr;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("TNN");
            System.loadLibrary("light_ai_base");
            System.loadLibrary("light_detect_base");
            System.loadLibrary("light_detect_face");
            System.loadLibrary("light_detect_gender");
            System.loadLibrary("light_detect_scene_chain");
        } catch (Error e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public static native int getVersion();

    public native int cleanupModelData();

    public native int forwardDetect(Bitmap bitmap, GYDetectCommonResultStruct gYDetectCommonResultStruct, int i3);

    public long getNativePtr() {
        return this.nativePtr;
    }

    public native int initInstance(SDKDeviceConfig sDKDeviceConfig);

    public void setNativePtr(long j3) {
        this.nativePtr = j3;
    }

    public native int setupWithModel(SDKModelConfig sDKModelConfig);
}
