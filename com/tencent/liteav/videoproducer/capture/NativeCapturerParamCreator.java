package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class NativeCapturerParamCreator {
    public static Boolean createBooleanWithValue(boolean z16) {
        return Boolean.valueOf(z16);
    }

    public static CameraCaptureParams createCameraParams(Boolean bool, int i3, int i16, int i17) {
        CameraCaptureParams cameraCaptureParams = new CameraCaptureParams();
        cameraCaptureParams.f119574a = bool;
        cameraCaptureParams.f119580b = i3;
        cameraCaptureParams.f119581c = i16;
        cameraCaptureParams.f119582d = i17;
        return cameraCaptureParams;
    }
}
