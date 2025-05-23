package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallItemStrategy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final g f81447a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.biz.pubaccount.weishi.t f81448b;

    public h(g gVar) {
        this.f81447a = gVar;
        this.f81448b = gVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, int i3, stSimpleMetaFeed stsimplemetafeed) {
        stH5OpInfo sth5opinfo;
        if (stsimplemetafeed.video == null || (sth5opinfo = stsimplemetafeed.h5_op_info) == null || TextUtils.isEmpty(sth5opinfo.h5Url)) {
            return;
        }
        ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToUrl(context, sth5opinfo.h5Url);
        WSReportDc00898.u(140, sth5opinfo.type, i3, stsimplemetafeed.h5_op_info.f25120id);
        com.tencent.biz.pubaccount.weishi.recommend.a.q("gzh_click", 1000004, stsimplemetafeed, this.f81448b.F);
        i00.a.f406985a.a(sth5opinfo.scheme_url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context, int i3, String str, stSimpleMetaFeed stsimplemetafeed, int i16) {
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = i(stsimplemetafeed);
        }
        try {
            int j3 = j();
            com.tencent.biz.pubaccount.weishi.util.x.f("WSGridCardPresenterLog", "open weishi scheme = " + str + ", weishi_jump_url = " + stsimplemetafeed.weishi_jump_url);
            ao.f(context.getApplicationContext(), "biz_src_jc_gzh_weishi", str, 1, j3, i16);
            com.tencent.biz.pubaccount.weishi.report.a.j(1, 114, i3, stsimplemetafeed, null);
        } catch (Exception e16) {
            e16.printStackTrace();
            com.tencent.biz.pubaccount.weishi.util.x.f("WSGridCardPresenterLog", "open weishi error scheme = " + str);
        }
    }

    private int j() {
        return iz.a.g().q(1);
    }

    private void m(stSimpleMetaFeed stsimplemetafeed) {
        String str;
        com.tencent.biz.pubaccount.weishi.cache.e.b(stsimplemetafeed);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSGridCardPresenter.java][preloadFeedVideo] title:");
        if (stsimplemetafeed != null) {
            str = stsimplemetafeed.feed_desc;
        } else {
            str = "feedNull!";
        }
        sb5.append(str);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSGridCardPresenterLog", sb5.toString());
    }

    public void g(Context context, stSimpleMetaFeed stsimplemetafeed, int i3) {
        stH5OpInfo sth5opinfo = stsimplemetafeed.h5_op_info;
        if (sth5opinfo != null) {
            WSReportDc00898.u(112, sth5opinfo.type, i3, sth5opinfo.f25120id);
            stH5OpInfo sth5opinfo2 = stsimplemetafeed.h5_op_info;
            String str = sth5opinfo2.h5Url;
            String str2 = sth5opinfo2.scheme_url;
            if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(str2) && !str2.startsWith("weishi://"))) {
                str2 = h(stsimplemetafeed);
            }
            bb.e(context, str2, str, "", stsimplemetafeed.h5_op_info.type, new a(context, i3, stsimplemetafeed));
        }
    }

    public void l(Context context, int i3, stSimpleMetaFeed stsimplemetafeed, boolean z16, boolean z17, View view) {
        m(stsimplemetafeed);
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
        ArrayList arrayList = new ArrayList();
        arrayList.add(stsimplemetafeed);
        this.f81447a.a().f81595i = i3 + 0;
        com.tencent.biz.pubaccount.weishi.verticalvideo.k S = new com.tencent.biz.pubaccount.weishi.verticalvideo.k(context, "recommend_tab", "feeds").L(z16).U(this.f81448b.F).J(arrayList).M(0).B(false).H(i3).G(stsimplemetafeed.f25129id).P(String.valueOf(System.currentTimeMillis())).N(z17).C(view).S(4098);
        a.b.e(S);
        q10.a.f428181a.a(S);
        if (i3 == 0 && stsimplemetafeed.video_type == 7) {
            WSReportDc00898.o(141, stsimplemetafeed.f25129id);
        } else {
            WSReportDc00898.o(112, 2);
        }
    }

    public void k(Context context, int i3, stSimpleMetaFeed stsimplemetafeed) {
        WSReportDc00898.s(true);
        if (context instanceof BaseActivity) {
            ax c16 = bi.c(((BaseActivity) context).app, context, stsimplemetafeed.video_url + "&click_index=" + (i3 + 1));
            if (c16 != null) {
                c16.b();
            }
            com.tencent.mobileqq.intervideo.now.dynamic.e.f238380a = stsimplemetafeed.f25129id;
            com.tencent.mobileqq.intervideo.now.dynamic.e.f238381b = stsimplemetafeed.feed_desc;
            com.tencent.mobileqq.intervideo.now.dynamic.e.f238382c = i3;
        }
    }

    private String h(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed != null && !TextUtils.isEmpty(stsimplemetafeed.f25129id)) {
            return "weishi://feed?feed_id=" + stsimplemetafeed.f25129id + "&logsour=2020020032";
        }
        return "";
    }

    private String i(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed == null) {
            return null;
        }
        return !TextUtils.isEmpty(stsimplemetafeed.weishi_jump_url) ? stsimplemetafeed.weishi_jump_url : "weishi://feed?feed_id=" + stsimplemetafeed.f25129id;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(Context context, int i3, stSimpleMetaFeed stsimplemetafeed, View view) {
        if (j() == 2) {
            stWaterFallItemStrategy stwaterfallitemstrategy = stsimplemetafeed.waterFallItemStrategy;
            boolean z16 = stwaterfallitemstrategy != null && stwaterfallitemstrategy.isCallWeishi;
            int c16 = iz.a.g().c(1);
            if (com.tencent.biz.qqstory.utils.l.c(BaseApplicationImpl.getApplication())) {
                boolean w3 = iz.a.g().w(1);
                com.tencent.biz.pubaccount.weishi.util.x.f("WSGridCardPresenterLog", "openCallWeishi = " + z16 + ", isOpenVideoPage = " + w3 + ", callCount = " + c16 + ", openCallWSCount = " + this.f81448b.f81594h);
                if (z16 && this.f81448b.f81594h < c16) {
                    WSReportDc00898.o(112, 114);
                    com.tencent.biz.pubaccount.weishi.recommend.a.c("gzh_click", stsimplemetafeed, com.tencent.biz.pubaccount.weishi.report.a.b(stsimplemetafeed, i3), 1000003, this.f81448b.F);
                    this.f81448b.f81594h++;
                    int i16 = c16 < 10000 ? 104 : 100;
                    boolean G = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().G();
                    if (w3) {
                        l(context, i3, stsimplemetafeed, false, G, view);
                    } else if (G) {
                        q00.b n3 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().n();
                        n3.m(stsimplemetafeed.weishi_jump_url);
                        p00.b.c(context, n3, p00.c.b(stsimplemetafeed, WSPublicAccReport.SOP_NAME_VIDEO_PLAY, this.f81448b.F, "feeds"));
                        if (!G) {
                            e(context, i3, stsimplemetafeed.weishi_jump_url, stsimplemetafeed, i16);
                        }
                        return true;
                    }
                    if (!G) {
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements bb.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f81449a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f81450b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f81451c;

        a(Context context, int i3, stSimpleMetaFeed stsimplemetafeed) {
            this.f81449a = context;
            this.f81450b = i3;
            this.f81451c = stsimplemetafeed;
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void b(Activity activity) {
            com.tencent.biz.pubaccount.weishi.util.a.b(activity);
            com.tencent.biz.pubaccount.weishi.recommend.a.q("gzh_click", 1000009, this.f81451c, h.this.f81448b.F);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void c(String str, int i3) {
            h.this.e(this.f81449a, this.f81450b, str, this.f81451c, 501);
            stH5OpInfo sth5opinfo = this.f81451c.h5_op_info;
            WSReportDc00898.u(114, sth5opinfo.type, this.f81450b, sth5opinfo.f25120id);
            com.tencent.biz.pubaccount.weishi.recommend.a.q("gzh_click", 1000003, this.f81451c, h.this.f81448b.F);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void d(String str, int i3) {
            h.this.d(this.f81449a, this.f81450b, this.f81451c);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void a(String str, int i3) {
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.bb.c
        public void e(String str, int i3) {
        }
    }
}
