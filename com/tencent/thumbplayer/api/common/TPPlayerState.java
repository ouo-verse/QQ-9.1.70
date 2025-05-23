package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPPlayerState {
    public static final int TP_PLAYER_STATE_COMPLETE = 6;
    public static final int TP_PLAYER_STATE_ERROR = 9;
    public static final int TP_PLAYER_STATE_IDLE = 0;
    public static final int TP_PLAYER_STATE_INITIALIZED = 1;
    public static final int TP_PLAYER_STATE_PAUSED = 5;
    public static final int TP_PLAYER_STATE_PREPARED = 3;
    public static final int TP_PLAYER_STATE_PREPARING = 2;
    public static final int TP_PLAYER_STATE_RELEASED = 10;
    public static final int TP_PLAYER_STATE_STARTED = 4;
    public static final int TP_PLAYER_STATE_STOPPED = 8;
    public static final int TP_PLAYER_STATE_STOPPING = 7;
}
