package com.tencent.mobileqq.qqlive.sail.room;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0004H&J\b\u0010\u0013\u001a\u00020\u0004H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0016\u001a\u00020\u0004H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH&J\b\u0010 \u001a\u00020\u0004H&J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H&J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H&J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020!2\u0006\u0010'\u001a\u00020\u000fH&J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/i;", "", "Landroid/graphics/Bitmap;", "bmp", "", "g", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "params", "setVideoQuality", "getVideoQuality", "Lcom/tencent/mobileqq/qqlive/trtc/video/videoprocess/a;", "process", "l", "Lcom/tencent/mobileqq/qqlive/data/trtc/RTCCameraDefine$RTCMirrorType;", "type", "", "mirror", "setCameraMirror", "openMic", "closeMic", "Landroid/view/ViewGroup;", "getDisplayView", "switchCamera", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioVolume", "Lcom/tencent/mobileqq/qqlive/api/audio/audioeffect/IRTCMusicAccompany;", "createMusicAccompany", "", "roomId", "userId", "connectRemote", "disconnectRemote", "", "uid", "Landroid/widget/FrameLayout;", "videoView", "startRemoteView", "stopRemoteView", "mute", "muteRemoteAudio", "Lcom/tencent/mobileqq/qqlive/trtc/encoder/a;", "qosParam", "c", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface i {
    void c(@NotNull com.tencent.mobileqq.qqlive.trtc.encoder.a qosParam);

    void closeMic();

    void connectRemote(long roomId, long userId);

    @Nullable
    IRTCMusicAccompany createMusicAccompany();

    void disconnectRemote();

    void g(@Nullable Bitmap bmp);

    @Nullable
    ViewGroup getDisplayView();

    @Nullable
    TRTCVideoQualityParams getVideoQuality();

    void l(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a process);

    void muteRemoteAudio(@NotNull String userId, boolean mute);

    void openMic();

    void setAudioVolume(int volume);

    void setCameraMirror(@NotNull RTCCameraDefine.RTCMirrorType type, boolean mirror);

    void setVideoQuality(@NotNull TRTCVideoQualityParams params);

    void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView);

    void stopRemoteView(@NotNull String uid);

    void switchCamera();
}
