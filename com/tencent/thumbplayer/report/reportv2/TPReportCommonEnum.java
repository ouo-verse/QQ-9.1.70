package com.tencent.thumbplayer.report.reportv2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPReportCommonEnum {
    public static final int TP_REPORT_DRM_TYPE_CHACHA20 = 8;
    public static final int TP_REPORT_DRM_TYPE_CHINA_DRM = 64;
    public static final int TP_REPORT_DRM_TYPE_COMMON = 2;
    public static final int TP_REPORT_DRM_TYPE_FAIRPLAY = 16;
    public static final int TP_REPORT_DRM_TYPE_NONE = 0;
    public static final int TP_REPORT_DRM_TYPE_PLAYDRM = 128;
    public static final int TP_REPORT_DRM_TYPE_UNITEND = 4;
    public static final int TP_REPORT_DRM_TYPE_UNKNOWN = -1;
    public static final int TP_REPORT_DRM_TYPE_WIDEVINE = 32;
    public static final int TP_REPORT_PLAYER_TYPE_AVPLAYER = 1;
    public static final int TP_REPORT_PLAYER_TYPE_AVQUEQUEPLAYER = 2;
    public static final int TP_REPORT_PLAYER_TYPE_EXOPLAYER = 4;
    public static final int TP_REPORT_PLAYER_TYPE_MEDIAPLAYER = 0;
    public static final int TP_REPORT_PLAYER_TYPE_THUMBPLAYER = 3;
    public static final int TP_REPORT_PLAYER_TYPE_UNKNOWN = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPReportDrmType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPReportPlayerType {
    }
}
