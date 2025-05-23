package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import hw2.f;
import java.util.HashMap;
import java.util.Map;
import pw2.w;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdVrReport {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ElementID {
        public static final String AD_ACTION_BTN = "ad_action";
        public static final String AD_AUTO_OPEN = "ad_auto_open";
        public static final String AD_BACK = "back";
        public static final String AD_FLOAT = "ad_float";
        public static final String AD_HEAD = "ad_head";
        public static final String AD_INFO = "ad_info";
        public static final String AD_MASK = "ad_mask";
        public static final String AD_MORE = "ad_more";
        public static final String AD_NAME = "ad_name";
        public static final String AD_NEGATIVE_FEEDBACK = "ad_nfb_uni";
        public static final String AD_NEGATIVE_FEEDBACK_CANCEL = "ad_nfb_cncl";
        public static final String AD_NEGATIVE_FEEDBACK_ENTRY = "ad_nfb";
        public static final String AD_PLAY_ICON = "play_icon";
        public static final String AD_POPUP = "ad_popup";
        public static final String AD_POPUP_CLOSE = "ad_popup_close";
        public static final String AD_POPUP_CONTINUE = "ad_popup_continue";
        public static final String AD_POPUP_REWARD_BANNER = "ad_popup_reward_banner";
        public static final String AD_POSTER = "poster";
        public static final String AD_POSTER_BG = "poster_bg";
        public static final String AD_POSTER_RELATIVE = "poster_rlt";
        public static final String AD_REPLAY = "ad_replay";
        public static final String AD_REWARD_BANNER = "ad_reward_banner";
        public static final String AD_SOUND = "ad_sound";
        public static final String AD_TITLE = "ad_title";
        public static final String AD_TURN = "ad_turn";
        public static final String AD_WATCH = "ad_watch";
        public static final String CLOSE = "close";
        public static final String SKIP_BUTTON = "ad_skip";
        public static final String WHOLE_AD = "whole_ad";
        public static final String WHOLE_PLAYBOX_AD = "whole_playbox_ad";
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ReportEvent {
        public static final String AD_REWARD_PLAY_CROSS_THRESHOLD = "ad_reward_play_cross_threshold";
        public static final String AD_RW_TERMINAL_RECEIVE_VSSP = "ad_rw_terminal_receive_vssp";
        public static final String AD_RW_TERMINAL_SENDRQST_SSP_REQUEST = "ad_rw_terminal_sendrqst_ssp_request";
        public static final String EVENT_EFFECT_EXPOSURE = "effectiveexposure";
        public static final String EVENT_FINISH_PLAY = "videofinish_ad";
        public static final String EVENT_ORIGIN_EXPOSURE = "originalexposure";
        public static final String EVENT_PAGE_LANDING_LOADING = "page_landing_loading";
        public static final String EVENT_PAUSE_PLAY = "videopause_ad";
        public static final String EVENT_START_PLAY = "videostart_ad";
        public static final String PAGE_AD_REWARD = "page_ad_reward";
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ReportPolicy {
        public static final int POLICY_ALL = 3;
        public static final int POLICY_CLICK = 1;
        public static final int POLICY_EXPOSURE = 2;
        public static final int POLICY_NONE = 0;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface RewardSwitchType {
        public static final int SWITCH_LEFT_TOP_BANNER = 10;
        public static final int SWITCH_POPUP_BANNER = 11;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface ScreenStatus {
        public static final int SCREEN_STATUS_HORIZONTAL = 1;
        public static final int SCREEN_STATUS_VERTICAL = 0;
    }

    public static void a(@ReportPolicy int i3, Object obj, @ElementID String str, Map<String, ?> map) {
        w.l(obj, str, map);
        w.n(obj, i3);
    }

    public static Map<String, String> b(AdOrderItem adOrderItem) {
        return f.a(adOrderItem).a(9);
    }

    public static Map<String, String> c(AdOrderItem adOrderItem) {
        return f.a(adOrderItem).a(5);
    }

    public static Map<String, ?> d(View view) {
        if (view == null) {
            return null;
        }
        return w.g(view);
    }

    public static boolean e(Map<String, ?> map) {
        if (map != null && map.containsKey("cur_pg") && ((Map) map.get("cur_pg")).isEmpty()) {
            return true;
        }
        return false;
    }

    public static void f(View view, Map<String, Object> map) {
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Map<String, Object> g16 = w.g(view);
        if (g16 != null) {
            hashMap.putAll(g16);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        w.i("clck", hashMap);
    }

    public static void g(View view, QAdVrReportParams qAdVrReportParams, String str) {
        i(view, qAdVrReportParams, null, str);
    }

    public static void h(View view, QAdVrReportParams qAdVrReportParams, Map<String, Object> map) {
        i(view, qAdVrReportParams, map, ElementID.WHOLE_AD);
    }

    public static void i(View view, QAdVrReportParams qAdVrReportParams, Map<String, Object> map, String str) {
        if (view == null) {
            return;
        }
        w.l(view, str, null);
        w.n(view, 0);
        Map<String, ?> d16 = d(view);
        QAdVrReportParams.a f16 = new QAdVrReportParams.a().h(d16).g(qAdVrReportParams).f("eid", str);
        if (e(d16)) {
            f16.f("cur_pg", map);
        }
        w.i(ReportEvent.EVENT_EFFECT_EXPOSURE, f16.i().h());
    }

    public static void m(View view, QAdVrReportParams qAdVrReportParams, String str) {
        o(view, qAdVrReportParams, null, str);
    }

    public static void n(View view, QAdVrReportParams qAdVrReportParams, Map<String, Object> map) {
        o(view, qAdVrReportParams, map, ElementID.WHOLE_AD);
    }

    public static void o(View view, QAdVrReportParams qAdVrReportParams, Map<String, Object> map, String str) {
        if (view != null && qAdVrReportParams != null) {
            w.l(view, str, null);
            w.n(view, 0);
            Map<String, ?> d16 = d(view);
            QAdVrReportParams.a f16 = new QAdVrReportParams.a().h(d16).g(qAdVrReportParams).f("eid", str);
            if (e(d16)) {
                f16.f("cur_pg", map);
            }
            w.i(ReportEvent.EVENT_ORIGIN_EXPOSURE, f16.i().h());
        }
    }

    public static void j(boolean z16, String str) {
    }

    public static void k(VideoReportInfo videoReportInfo, boolean z16, String str, int i3) {
    }

    public static void l(String str, boolean z16, String str2, int i3) {
    }
}
