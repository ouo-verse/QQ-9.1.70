package com.tencent.qqlive.playerinterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes22.dex */
public @interface QAdPlayerConstants$QAdMediaPlayerEvent {
    public static final int CURRENT_LOOP_END = 7;
    public static final int FIRST_VIDEO_FRAME_RENDERED = 6;
    public static final int PLAYER_BUFFERING_END = 9;
    public static final int PLAYER_BUFFERING_START = 8;
    public static final int PLAYER_COMPLETE = 0;
    public static final int PLAYER_DETAIL_INFO = 11;
    public static final int PLAYER_DETAIL_INFO_TRACKING_FIRST_START = 10;
    public static final int PLAYER_ERROR_FAIL = 3;
    public static final int PLAYER_ERROR_STUCK = 2;
    public static final int PLAYER_PREPARED = 1;
    public static final int PLAYER_SIZE_CHANGE = 5;
    public static final int PLAYER_VIDEO_DOWNLOADED = 4;
}
