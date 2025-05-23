package com.tencent.oskplayer.model;

import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public abstract class PlayerCallBack {
    public static int EVENT_CONTROLLER_HIDE;
    public static int EVENT_CONTROLLER_SHOWN;
    public static int EVENT_MAX;
    public static int EVENT_MIN;
    public static int EVENT_PLAY_COMPLETE;
    public static int EVENT_PLAY_ERROR;
    public static int EVENT_PLAY_EXIT;
    public static int EVENT_PLAY_PAUSE;
    public static int EVENT_PLAY_POSITION_OUT_OF_BOUND;
    public static int EVENT_PLAY_PREPARE;
    public static int EVENT_PLAY_PREPARE_TIMEOUT;
    public static int EVENT_PLAY_RESUME;
    public static int EVENT_PLAY_START;
    public static int EVENT_PLAY_STOP;
    public static int EVENT_SEEK_BAR_ON_SEEK;
    public static int EVENT_SEEK_BAR_START_SEEK;
    public static int EVENT_SEEK_BAR_STOP_SEEK;
    private static int eventId;

    static {
        int i3 = eventId;
        int i16 = i3 + 1;
        EVENT_MIN = i3;
        int i17 = i16 + 1;
        EVENT_PLAY_PREPARE = i16;
        int i18 = i17 + 1;
        EVENT_PLAY_START = i17;
        int i19 = i18 + 1;
        EVENT_PLAY_STOP = i18;
        int i26 = i19 + 1;
        EVENT_PLAY_COMPLETE = i19;
        int i27 = i26 + 1;
        EVENT_PLAY_PAUSE = i26;
        int i28 = i27 + 1;
        EVENT_PLAY_RESUME = i27;
        int i29 = i28 + 1;
        EVENT_PLAY_ERROR = i28;
        int i36 = i29 + 1;
        EVENT_PLAY_EXIT = i29;
        int i37 = i36 + 1;
        EVENT_PLAY_POSITION_OUT_OF_BOUND = i36;
        int i38 = i37 + 1;
        EVENT_PLAY_PREPARE_TIMEOUT = i37;
        int i39 = i38 + 1;
        EVENT_SEEK_BAR_START_SEEK = i38;
        int i46 = i39 + 1;
        EVENT_SEEK_BAR_ON_SEEK = i39;
        int i47 = i46 + 1;
        EVENT_SEEK_BAR_STOP_SEEK = i46;
        int i48 = i47 + 1;
        EVENT_CONTROLLER_SHOWN = i47;
        int i49 = i48 + 1;
        eventId = i49;
        EVENT_CONTROLLER_HIDE = i48;
        EVENT_MAX = i49;
    }

    public abstract void onCacheRead(PlayerCallBack playerCallBack, long j3, long j16);

    public abstract void onHttpDownloadError(PlayerCallBack playerCallBack, String str, String str2, int i3, String str3, Map<String, List<String>> map, int i16, long j3, long j16);

    public abstract void onMediaEvent(PlayerCallBack playerCallBack, int i3, String str, VideoInfo videoInfo);
}
