package com.tencent.biz.richframework.video.rfw.player.status;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface RFWTVKPlayerStatus {
    public static final int PLAYER_STATE_AD_COMPLETE = 14;
    public static final int PLAYER_STATE_AD_ERROR = 15;
    public static final int PLAYER_STATE_AD_PAUSED = 12;
    public static final int PLAYER_STATE_AD_PLAYING = 11;
    public static final int PLAYER_STATE_AD_PREPARED = 10;
    public static final int PLAYER_STATE_AD_STOP = 13;
    public static final int PLAYER_STATE_FIRST_VIDEO_FRAME_RENDERED = 3;
    public static final int PLAYER_STATE_PERMISSION_OUT = 9;
    public static final int PLAYER_STATE_UNKNOWN = -1;
    public static final int PLAYER_STATE_VIDEO_COMPLETE = 7;
    public static final int PLAYER_STATE_VIDEO_ERROR = 8;
    public static final int PLAYER_STATE_VIDEO_OPEN_MEDIA = 1;
    public static final int PLAYER_STATE_VIDEO_PAUSED = 5;
    public static final int PLAYER_STATE_VIDEO_PLAYING = 4;
    public static final int PLAYER_STATE_VIDEO_PREPARED = 2;
    public static final int PLAYER_STATE_VIDEO_STOP = 6;
}
