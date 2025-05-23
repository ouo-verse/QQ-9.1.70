package com.tencent.mobileqq.qqlive.trtc.video.source.screen;

import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface c extends com.tencent.mobileqq.qqlive.trtc.video.source.a {
    void e(TRTCVideoQualityParams tRTCVideoQualityParams, QQLiveScreenCaptureParams qQLiveScreenCaptureParams) throws IllegalStateException;

    void g(a aVar);

    void stopScreenCapture() throws IllegalStateException;
}
