package com.tencent.qqmini.sdk.launcher.core.proxy;

import com.tencent.qqmini.sdk.launcher.core.model.SongInfo;

/* loaded from: classes23.dex */
public interface MusicPlayerProxy {
    public static final int PLAY_MODE_LIST = 102;
    public static final int PLAY_MODE_LIST_REPEAT = 103;
    public static final int PLAY_MODE_LIST_SHUFFLE_REPEAT = 105;
    public static final int PLAY_MODE_ONESHOT = 100;
    public static final int PLAY_MODE_ONESHOT_REPEAT = 101;
    public static final int PLAY_STATE_BUFFERING = 1;
    public static final int PLAY_STATE_COMPLETETION = 8;
    public static final int PLAY_STATE_ERROR_INTERNAL = 5;
    public static final int PLAY_STATE_ERROR_SERVER = 7;
    public static final int PLAY_STATE_IDLE = 0;
    public static final int PLAY_STATE_NETWORK_INTERRUPT = 6;
    public static final int PLAY_STATE_PAUSE = 3;
    public static final int PLAY_STATE_PLAYING = 2;
    public static final int PLAY_STATE_STOP = 4;
    public static final int PLAY_STATE_URL_NEED_TO_BE_UPDATED = 10;

    /* loaded from: classes23.dex */
    public interface MusicPlayerListener {
        void onPlaySongChanged(SongInfo songInfo);

        void onPlayStateChanged(int i3);
    }

    SongInfo getCurrentSong();

    int getCurrentSongPosition();

    int getDuration();

    void init(MusicPlayerListener musicPlayerListener, String str, String str2);

    boolean isInit();

    boolean isPlaying();

    void pause();

    void resume();

    void seekTo(int i3);

    void setPlayMode(int i3);

    void startPlay(SongInfo[] songInfoArr, int i3);

    void stop();

    void unInit();
}
