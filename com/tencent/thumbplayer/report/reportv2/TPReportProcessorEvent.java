package com.tencent.thumbplayer.report.reportv2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPReportProcessorEvent {
    public static final int REPORT_PROCESSOR_EVENT_APP_BACKGROUND = 1002;
    public static final int REPORT_PROCESSOR_EVENT_APP_FOREGROUND = 1001;
    public static final int REPORT_PROCESSOR_EVENT_BUFFER_END = 10;
    public static final int REPORT_PROCESSOR_EVENT_BUFFER_START = 9;
    public static final int REPORT_PROCESSOR_EVENT_CDN_URL_UPDATE = 101;
    public static final int REPORT_PROCESSOR_EVENT_CONTROLLER_RELEASE = 1000;
    public static final int REPORT_PROCESSOR_EVENT_DOWNLOAD_PROGRESS_UPDATE = 100;
    public static final int REPORT_PROCESSOR_EVENT_DRM_INFO = 14;
    public static final int REPORT_PROCESSOR_EVENT_GET_CONVERTED_DATA_SOURCE = 103;
    public static final int REPORT_PROCESSOR_EVENT_PLAYER_END = 5;
    public static final int REPORT_PROCESSOR_EVENT_PLAYER_ERROR = 6;
    public static final int REPORT_PROCESSOR_EVENT_PLAYER_PAUSE = 4;
    public static final int REPORT_PROCESSOR_EVENT_PLAYER_START = 3;
    public static final int REPORT_PROCESSOR_EVENT_PREPARE_END = 2;
    public static final int REPORT_PROCESSOR_EVENT_PREPARE_START = 1;
    public static final int REPORT_PROCESSOR_EVENT_PROTOCOL_UPDATE = 102;
    public static final int REPORT_PROCESSOR_EVENT_SEEK_END = 8;
    public static final int REPORT_PROCESSOR_EVENT_SEEK_START = 7;
    public static final int REPORT_PROCESSOR_EVENT_SELECT_TRACK_END = 12;
    public static final int REPORT_PROCESSOR_EVENT_SELECT_TRACK_START = 11;
    public static final int REPORT_PROCESSOR_EVENT_SET_DATA_SOURCE = 0;
    public static final int REPORT_PROCESSOR_EVENT_SET_PLAY_SPEED = 13;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface EventId {
    }
}
