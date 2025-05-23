package com.tencent.qqlive.module.videoreport.dtreport.audio;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IAudioSessionListener {
    void onAudioEnd();

    void onAudioPause();

    void onAudioResume();

    void onAudioStart();

    void onBufferingEnd();

    void onBufferingStart();
}
