package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

/* loaded from: classes22.dex */
public class PlayParamConst {

    /* loaded from: classes22.dex */
    interface ParamKey {
        public static final String IS_VERTICAL = "is_vertical";
        public static final String PLAY_END_TIME = "play_end_time";
        public static final String PLAY_LOOP_TYPE = "play_loop_type";
        public static final String PLAY_LVTM = "play_lvtm";
        public static final String PLAY_PER = "play_per";
        public static final String PLAY_SESSION_ID = "play_sessionid";
        public static final String PLAY_START_TIME = "play_start_time";
        public static final String PLAY_TYPE = "play_type";
        public static final String VIDEO_CONTENT_ID = "video_contentid";
        public static final String VIDEO_ERROR_CODE = "video_error_code";
        public static final String VIDEO_HEIGHT = "video_height";
        public static final String VIDEO_STATIC_DURATION = "video_static_duration";
        public static final String VIDEO_WIDTH = "video_width";
    }

    /* loaded from: classes22.dex */
    public enum PlayLoopType {
        NO_LOOP(1),
        AUTO_LOOP(2),
        OTHER_LOOP(3);

        public final int value;

        PlayLoopType(int i3) {
            this.value = i3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    /* loaded from: classes22.dex */
    public enum PlayType {
        AUTO(1),
        MANUAL(2);

        public final int value;

        PlayType(int i3) {
            this.value = i3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.value);
        }
    }
}
