package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.funnelconstants;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VideoFunnelConstant {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f303666a = {"pgid", "ztid", QAdVrReportParams.ParamKey.PG_VID, QAdVrReportParams.ParamKey.PG_CID, QAdVrReportParams.ParamKey.PG_LID, QAdVrReportParams.ParamKey.PG_TYPE, QAdVrReportParams.ParamKey.PG_TYPE_ID, "cre_pg", "ref_pg", QAdVrReportParams.ParamKey.PLAYBOX_TYPE};

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface AnchorRequestType {
        public static final int NORMAL_REQUEST = 1;
        public static final int REPLACE_ORDER_REQUEST = 2;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ExposeFailReason {
        public static final int BUFFER_FAIL = 4;
        public static final int PLAY_ERROR = 3;
        public static final int USER_LOG_VIP = 2;
        public static final int USER_RETURN = 1;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface MidAdShowType {
        public static final int DYNAMIC_ANCHOR_SHOW = 2;
        public static final int FIX_ANCHOR_SHOW = 1;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface MidReportEvent {
        public static final String AD_MID_CALL_SDK = "adfunnel_playbox_terminal_requestSDK_midpost";
        public static final String AD_MID_EMPTY_EXPOSURE = "adfunnel_playbox_terminal_blankad_exposure_midpost";
        public static final String AD_MID_REAL_ORDER_EXPOSURE_FAIL = "adfunnel_playbox_terminal_fail_exposure_midpost";
        public static final String AD_MID_RECEIVE_SSP = "adfunnel_playbox_terminalSDK_receiverqst_ssp_midpost";
        public static final String AD_MID_SEND_SSP = "adfunnel_playbox_terminal_sendrqst_ssp_midpost";
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface PlaySource {
        public static final int LINE_AD = 1;
        public static final int OFFLINE_AD = 2;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ReceivedFailReason {
        public static final int CLIENT_ERROR = 1;
        public static final int PANGLE_ERROR = 5;
        public static final int SDK_NET_REQUEST_TIME_OUT = 3;
        public static final int SDK_REQUEST_BUSINESS_TIME_OUT = 4;
        public static final int SERVER_ERROR = 2;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ReportFstValue {
        public static final int AD_MID_FST = 5;
        public static final int AD_PAUSE_FST = 7;
        public static final int AD_POST_FST = 6;
        public static final int AD_PRE_FST = 3;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ReportScdValue {
        public static final int AD_MID_SCD = 12;
        public static final int AD_PAUSE_SCD = 14;
        public static final int AD_POST_SCD = 13;
        public static final int AD_PRE_SCD = 10;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ReportStatus {
        public static final int EMPTY_ORDER_EXPOSE = 9;
        public static final int LOSS_BY_NETWORK_WHEN_SENDING = 3;
        public static final int REAL_ORDER_EFFECT_EXPOSURE_FAIL = 8;
        public static final int REAL_ORDER_ORIGIN_EXPOSURE_FAIL = 7;
        public static final int RECEIVED_ERROR = 6;
        public static final int SCENE_FILTER_LOSS_WHEN_RESPONSE = 5;
        public static final int SCENE_FILTER_LOSS_WHEN_SENDING = 2;
        public static final int SUCCESS_RECEIVED_SSP = 4;
        public static final int SUCCESS_RECEIVED_SSP_BUT_AMS_EMPTY = 11;
        public static final int SUCCESS_RECEIVED_SSP_BUT_NOT_BIDDING = 10;
        public static final int SUCCESS_SEND_SSP = 1;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface RequestFailReason {
        public static final int AD_MID_COUNTING = 22;
        public static final int AUDIO_PLAY = 18;
        public static final int CLOSE_AD = 4;
        public static final int CRASH = 21;
        public static final int DLNA = 6;
        public static final int FEED_NO_AD = 19;
        public static final int HOT_SPOT = 8;
        public static final int MULTI_CAMERA_VIDEO = 12;
        public static final int SAME_AD = 20;
        public static final int VERTICAL_VIDEO = 15;
        public static final int WHY_ME = 10;
        public static final int WHY_ME_TAB = 11;
    }
}
