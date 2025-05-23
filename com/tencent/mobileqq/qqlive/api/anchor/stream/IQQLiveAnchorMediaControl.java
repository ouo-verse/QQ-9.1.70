package com.tencent.mobileqq.qqlive.api.anchor.stream;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveAnchorMediaControl {
    IRTCMusicAccompany createMusicAccompany();

    void enableAudioVolumeEvaluation(int i3);

    boolean isMicEnable();

    boolean isMicMuteEnable();

    void muteLocalAudio(boolean z16);

    void setAudioVolume(int i3);

    void setVideoPreProcess(@NonNull a aVar);

    void startAudioRecord();

    void startCameraPreview();

    void startScreenCapturePreview();

    void stopAudioRecord();

    void stopCameraPreview();

    void stopScreenCapturePreview();
}
