package com.tencent.thumbplayer.report.reportv2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPReportEventId {
    public static final String TP_REPORT_EVENT_LIVE_END = "live_end";
    public static final String TP_REPORT_EVENT_LIVE_FIRST_LOAD = "live_first_load";
    public static final String TP_REPORT_EVENT_LIVE_FLOW = "live_flow";
    public static final String TP_REPORT_EVENT_LIVE_PERIOD = "live_period_report";
    public static final String TP_REPORT_EVENT_PREPARE_FAIL = "prepare_fail";
    public static final String TP_REPORT_EVENT_VOD_BUFFERING = "vod_second_buffering";
    public static final String TP_REPORT_EVENT_VOD_DRM = "vod_drm_authentication";
    public static final String TP_REPORT_EVENT_VOD_END = "vod_end";
    public static final String TP_REPORT_EVENT_VOD_FIRST_LOAD = "vod_first_load";
    public static final String TP_REPORT_EVENT_VOD_FLOW = "vod_flow";
    public static final String TP_REPORT_EVENT_VOD_SELECT_TRACK = "vod_select_track";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface ReportEventId {
    }
}
