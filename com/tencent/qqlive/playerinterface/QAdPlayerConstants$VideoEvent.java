package com.tencent.qqlive.playerinterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes22.dex */
public @interface QAdPlayerConstants$VideoEvent {
    public static final int PLAYER_STATE_END_BUFFERING = 14;
    public static final int PLAYER_STATE_GETVINFO_REQUEST = 13;
    public static final int PLAYER_STATE_GETVINFO_RESPONSE = 11;
    public static final int PLAYER_STATE_PAUSE = 2;
    public static final int PLAYER_STATE_PLAYER_ERROR = 6;
    public static final int PLAYER_STATE_PLAYER_LOADING = 8;
    public static final int PLAYER_STATE_PLAYER_ON_PREPARED = 17;
    public static final int PLAYER_STATE_PLAYER_OPEN = 16;
    public static final int PLAYER_STATE_PLAY_COMPLETE = 5;
    public static final int PLAYER_STATE_POSITION_UPDATE = 12;
    public static final int PLAYER_STATE_PRIVATE_HLS_M3U8_TAG = 10;
    public static final int PLAYER_STATE_RESUME = 3;
    public static final int PLAYER_STATE_SEEK_COMPLETE = 15;
    public static final int PLAYER_STATE_START_PLAY = 1;
    public static final int PLAYER_STATE_START_SEEK = 7;
    public static final int PLAYER_STATE_STOP = 4;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int PLAYER_STATE_USER_PAUSE = 9;
}
