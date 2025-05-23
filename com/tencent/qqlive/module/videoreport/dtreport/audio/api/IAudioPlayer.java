package com.tencent.qqlive.module.videoreport.dtreport.audio.api;

/* loaded from: classes22.dex */
public interface IAudioPlayer {

    /* loaded from: classes22.dex */
    public @interface PlayerType {
        public static final int AUDIO_TRACK = 101;
        public static final int MEDIA_PLAYER = 100;
    }

    int getCurrentPosition__();

    int getDuration__();

    String getPlayerId__();

    @PlayerType
    int getPlayerType__();

    boolean isAudioPlayer__();
}
