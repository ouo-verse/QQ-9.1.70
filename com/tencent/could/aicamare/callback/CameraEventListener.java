package com.tencent.could.aicamare.callback;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface CameraEventListener {
    void onAutoFocusSucceed();

    void onCameraClosed();

    void onCameraSucceed();

    void onDataFrameCallBack(byte[] bArr);

    void onEventError(int i3, String str);

    void onPreviewSucceed();
}
