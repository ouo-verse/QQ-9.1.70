package com.tencent.mobileqq.qqlive.trtc.audio;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface b extends a {
    void d();

    void e(boolean z16) throws IllegalStateException;

    void enableAudioVolumeEvaluation(int i3);

    void g(int i3) throws IllegalStateException;

    boolean isMicEnable();

    boolean isMicMuteEnable();

    void setAudioCaptureVolume(int i3) throws IllegalStateException;
}
