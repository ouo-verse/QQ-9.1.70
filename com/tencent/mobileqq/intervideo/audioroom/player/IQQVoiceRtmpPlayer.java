package com.tencent.mobileqq.intervideo.audioroom.player;

/* loaded from: classes15.dex */
public interface IQQVoiceRtmpPlayer {
    void init();

    boolean isDestroy();

    boolean isPlayerReady();

    boolean isPlaying();

    void play(String str);

    void release();

    void setPlayAudioListener(IQQVoiceAudioListener iQQVoiceAudioListener);
}
