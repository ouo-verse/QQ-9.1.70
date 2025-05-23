package com.tencent.mobileqq.zplan.cc.camera;

/* compiled from: P */
/* loaded from: classes35.dex */
public enum CameraIndex {
    FRONT_CAMERA(0),
    BACK_CAMERA(1);

    public final int value;

    CameraIndex(int i3) {
        this.value = i3;
    }

    public static CameraIndex switchCamera(CameraIndex cameraIndex) {
        CameraIndex cameraIndex2 = FRONT_CAMERA;
        return cameraIndex == cameraIndex2 ? BACK_CAMERA : cameraIndex2;
    }

    public int getValue() {
        return this.value;
    }
}
