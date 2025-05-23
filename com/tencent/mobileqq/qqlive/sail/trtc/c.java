package com.tencent.mobileqq.qqlive.sail.trtc;

import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/c;", "", "", "f", "k", "switchCamera", "", "mirror", "setMirror", "Lcom/tencent/mobileqq/qqlive/data/trtc/RTCCameraDefine$RTCMirrorType;", "type", "d", "Landroid/view/ViewGroup;", "viewGroup", "g", "Lcom/tencent/mobileqq/qqlive/trtc/video/videoprocess/a;", "process", "i", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "videoQuality", "setVideoQuality", "getVideoQuality", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface c {
    void d(@NotNull RTCCameraDefine.RTCMirrorType type, boolean mirror);

    void f();

    void g(@Nullable ViewGroup viewGroup);

    @Nullable
    TRTCVideoQualityParams getVideoQuality();

    void i(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a process);

    void k();

    void setMirror(boolean mirror);

    void setVideoQuality(@NotNull TRTCVideoQualityParams videoQuality);

    void switchCamera();
}
