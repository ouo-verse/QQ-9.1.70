package com.tencent.biz.pubaccount.weishi.config.experiment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.recommend.data.g;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private d f80647a = WSExpPolicyManager.o().n();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f80648a = new b();
    }

    b() {
    }

    public static b h() {
        return a.f80648a;
    }

    private String p(String str, String str2) {
        return f.c(this.f80647a, str, str2);
    }

    public Map<String, String> A() {
        return f.b(this.f80647a, "exp_wesee_mqq_video_hevc_new");
    }

    public int B() {
        return bb.Y(p("QQFeedScaleType", "type"), 0);
    }

    public int C() {
        return bb.Y(p("StickWSAioEntrance", "threshold_index"), 9);
    }

    public boolean D() {
        return TextUtils.equals(p("AioForwardScene", "scene"), "2");
    }

    public boolean E() {
        return "1".equals(p("DramaCleanMode", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE));
    }

    public boolean F() {
        ArrayList<a20.c> arrayList;
        g c16 = a20.a.c(h().t());
        return (c16 == null || (arrayList = c16.f81431a) == null || arrayList.size() == 0) ? false : true;
    }

    public boolean G() {
        return "1".equals(p("AppPullOptimization", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public boolean H() {
        return TextUtils.equals(p("FeedLoopPlay", "loop_play_type"), "1");
    }

    public boolean I() {
        return TextUtils.equals(p("QQFollowPageMute", "show"), "1");
    }

    public boolean J() {
        return "1".equals(p("exp_wesee_mqq_first_detail", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public boolean K() {
        return "1".equals(p("ShowDramaPage", "follow_show"));
    }

    public boolean L() {
        return "1".equals(p("exp_wesee_mqq_anim_optimize", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public boolean M() {
        return "1".equals(p("exp_wesee_mqq_video_request_prepose", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public boolean N() {
        return "1".equals(p("StickWSAioEntrance", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public boolean O() {
        return TextUtils.equals(b(), "1");
    }

    public void P() {
        this.f80647a = WSExpPolicyManager.o().n();
        com.tencent.biz.pubaccount.weishi.report.f.c();
        x.f("WSExpABTestManager", "[WSExpABTestManager.java][init] expPolicyEntities:" + this.f80647a.toString());
    }

    public boolean a() {
        return TextUtils.equals(p("QQFeedPlayerType", "enable_codec_reuse"), "1");
    }

    public String b() {
        return p("AioForwardScene", "scene");
    }

    public Map<String, String> c() {
        return f.b(this.f80647a, "exp_wesee_mqq_combo");
    }

    public Map<String, String> d() {
        return f.b(this.f80647a, "exp_wesee_mqq_comment_at");
    }

    public Map<String, String> e() {
        return f.b(this.f80647a, "exp_wesee_mqq_video_comment_scroll_new");
    }

    public String f() {
        d dVar = this.f80647a;
        if (dVar != null) {
            return dVar.b();
        }
        return "";
    }

    public Map<String, String> g() {
        return f.b(this.f80647a, "exp_wesee_float_window_guide");
    }

    public Map<String, String> i() {
        return f.b(this.f80647a, "exp_wesee_interactive_button");
    }

    public int j() {
        return bb.Y(p("LoadMoreCount", "count_load_more_common"), 12);
    }

    public int k() {
        return bb.Y(p("LoadMoreCount", "count_load_more_first"), 12);
    }

    public int l() {
        return bb.Y(p("exp_wesee_mqq_app_loadmorecount_verticalpage", "count"), 3);
    }

    public Map<String, String> m() {
        return f.b(this.f80647a, "OneMoreFeedAvoidAD");
    }

    public q00.b n() {
        q00.b bVar = new q00.b();
        bVar.k(p("AppPullOptimization", "image"));
        bVar.n(p("AppPullOptimization", "title"));
        bVar.j(p("AppPullOptimization", "desc"));
        bVar.h(p("AppPullOptimization", "buttonText"));
        String p16 = p("AppPullOptimization", "openTime");
        String p17 = p("AppPullOptimization", "closeTime");
        bVar.l(bb.Y(p16, 0));
        bVar.i(bb.Y(p17, 0));
        return bVar;
    }

    public Map<String, String> o() {
        return f.b(this.f80647a, "exp_wesee_mqq_play_speed");
    }

    public Map<String, String> q() {
        return f.b(this.f80647a, "exp_wesee_mqq_request_retry");
    }

    public Map<String, String> r() {
        return f.b(this.f80647a, "exp_wesee_mqq_request_retry_time_out");
    }

    public Map<String, String> s() {
        return f.b(this.f80647a, "exp_wesee_share_alienation");
    }

    public String t() {
        return p("RecommendSubTab", "tabData");
    }

    public Map<String, String> u() {
        return f.b(this.f80647a, "exp_wesee_teenage_window");
    }

    public String v() {
        d dVar = this.f80647a;
        if (dVar != null) {
            return dVar.e();
        }
        return "";
    }

    public Map<String, String> w() {
        return f.b(this.f80647a, "exp_wesee_mqq_top_triple_bar");
    }

    public String x() {
        return p("TrendsEntrance", "jump_type");
    }

    public String y() {
        d dVar = this.f80647a;
        if (dVar != null) {
            return dVar.g();
        }
        return "";
    }

    public Map<String, String> z() {
        return f.b(this.f80647a, "exp_wesee_video_buffer_strategy_new");
    }
}
