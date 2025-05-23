package com.tencent.mobileqq.qqlive.trtc;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.engine.c;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.d;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface a {
    void a();

    com.tencent.mobileqq.qqlive.trtc.render.a b();

    void c(com.tencent.mobileqq.qqlive.trtc.audio.a aVar);

    void closeMixTranscoding();

    void connectRemote(long j3, long j16);

    IRTCMusicAccompany createMusicAccompany();

    c d();

    void disconnectRemote();

    void e(String str, TXCloudVideoView tXCloudVideoView);

    void enableCustomVideoCapture(boolean z16);

    void f(ITRTCRemoteListener iTRTCRemoteListener);

    <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T g(@NonNull Class<T> cls);

    int getAudioPlayOutVolume();

    int getEngineState();

    void h(d dVar);

    <T extends com.tencent.mobileqq.qqlive.trtc.audio.a> T i(@NonNull Class<T> cls);

    void initEngine(@NonNull Context context, @NonNull String str, TRTCInitCallback tRTCInitCallback);

    <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T j(@NonNull Class<T> cls);

    <T extends com.tencent.mobileqq.qqlive.trtc.audio.a> T k(@NonNull Class<T> cls);

    void l(@Nullable com.tencent.mobileqq.qqlive.trtc.video.source.a aVar);

    com.tencent.mobileqq.qqlive.trtc.room.a m();

    void muteAllRemoteAudio(boolean z16);

    void muteRemoteAudio(String str, boolean z16);

    void openMixTranscoding(@NonNull @NotNull QQLiveTranscodingConfig qQLiveTranscodingConfig);

    void setAudioPlayOutVolume(int i3);

    void setNetworkQosPreferenceParam(com.tencent.mobileqq.qqlive.trtc.encoder.a aVar);

    void setRemoteAudioVolume(String str, int i3);

    void setVideoPreProcess(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar);

    void stopRemoteView(String str);

    void switchRole(int i3);
}
