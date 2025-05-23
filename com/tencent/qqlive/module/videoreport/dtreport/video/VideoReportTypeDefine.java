package com.tencent.qqlive.module.videoreport.dtreport.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoReportTypeDefine {
    public static final int CONTINUE_PLAY_DELTA_TIME = 2000;
    public static final int INVALID_EVENT_VALUE = -1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface PlayerEventId {
        public static final int BUFFER_END = 2;
        public static final int BUFFER_START = 1;
        public static final int LOOP_END = 6;
        public static final int LOOP_START = 5;
        public static final int PARAM_TYPE_LONG = 4;
        public static final int SET_START_POSITION = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface PlayerStateMachine {
        public static final int INIT = -1;
        public static final int PAUSED = 3;
        public static final int PREPARED = 1;
        public static final int STARTED = 2;
        public static final int STOPPED = 4;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface VideoEndReason {
        public static final int VIDEO_PLAY_END_BY_COMPLETE = 2;
        public static final int VIDEO_PLAY_END_BY_ERROR = 1;
        public static final int VIDEO_PLAY_END_BY_PAUSE = 3;
        public static final int VIDEO_PLAY_END_BY_STAGING = 4;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface VideoStartReason {
        public static final int VIDEO_CHANGE_PAGE_RESUME_PLAY = 3;
        public static final int VIDEO_CURRENT_PAGE_RESUME_PLAY = 2;
        public static final int VIDEO_NORMAL_PLAY = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface VideoStartType {
        public static final int VIDEO_FIRST_PLAY = 1;
        public static final int VIDEO_REPLAY = 2;
    }
}
