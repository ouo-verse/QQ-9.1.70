package com.tencent.mobileqq.qqlive.api.anchor.camera;

import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveModuleCamera {
    boolean isCameraMirror();

    boolean isCameraMirror(RTCCameraDefine.RTCMirrorType rTCMirrorType);

    void setCameraMirror(RTCCameraDefine.RTCMirrorType rTCMirrorType, boolean z16);

    void setCameraMirror(boolean z16);

    void switchAnchorCamera();
}
