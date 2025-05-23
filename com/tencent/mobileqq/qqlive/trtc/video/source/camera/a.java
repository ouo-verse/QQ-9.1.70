package com.tencent.mobileqq.qqlive.trtc.video.source.camera;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface a extends com.tencent.mobileqq.qqlive.trtc.video.source.a {
    void d(RTCCameraDefine.RTCMirrorType rTCMirrorType, boolean z16);

    int getCameraId() throws IllegalStateException;

    boolean l(RTCCameraDefine.RTCMirrorType rTCMirrorType);

    boolean n();

    boolean o();

    void p(@NonNull com.tencent.mobileqq.qqlive.trtc.render.a aVar) throws IllegalStateException;

    void setMirror(boolean z16);

    void stopCapture() throws IllegalStateException;

    void switchCamera() throws IllegalStateException;
}
