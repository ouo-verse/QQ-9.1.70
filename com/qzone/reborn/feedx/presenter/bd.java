package com.qzone.reborn.feedx.presenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.lifecycle.Observer;
import com.qzone.business.plusunion.business.model.AppInfo;
import com.qzone.business.plusunion.ui.QZoneAppIntroActivity;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLbsInfo;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellRemarkInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.ShootInfo;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.report.QZonePerfReporter;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.CellColorfulTail;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bd extends vg.a implements Observer<af.d> {
    private static final int X = ImmersiveUtils.getScreenWidth() - ImmersiveUtils.dpToPx(178.0f);
    private View F;
    private View G;
    private View H;
    private View I;
    private Space J;
    private ImageView K;
    private QZoneRichTextView L;
    private Space M;
    private ImageView N;
    private QZoneRichTextView P;
    private Space Q;
    private ImageView R;
    private QZoneRichTextView S;
    private Space T;
    private ImageView U;
    private QZoneRichTextView V;
    private View W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends AnimationDrawableLoadedListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNewLoadSuccess$0(com.tencent.mobileqq.vas.ui.c cVar) {
            if (bd.this.K != null) {
                bd.this.K.setImageDrawable(cVar.getDrawable());
            }
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            bd.this.j0(animationDrawable);
            super.onLoadedSuccess(animationDrawable);
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onNewLoadSuccess(final com.tencent.mobileqq.vas.ui.c cVar) {
            if (bd.this.K != null) {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.bc
                    @Override // java.lang.Runnable
                    public final void run() {
                        bd.a.this.lambda$onNewLoadSuccess$0(cVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellReferInfo f55561d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f55562e;

        b(CellReferInfo cellReferInfo, BusinessFeedData businessFeedData) {
            this.f55561d = cellReferInfo;
            this.f55562e = businessFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CellReferInfo cellReferInfo = this.f55561d;
            if (cellReferInfo != null) {
                int i3 = cellReferInfo.actionType;
                if (i3 != 17 && i3 != 2) {
                    bd.this.X(view, cellReferInfo, this.f55562e);
                } else {
                    com.qzone.proxy.feedcomponent.model.e eVar = new com.qzone.proxy.feedcomponent.model.e(cellReferInfo.actionUrl, "", 0);
                    eVar.d(12);
                    gh.c.c(com.qzone.reborn.feedx.widget.i.c(bd.this.S), this.f55562e, eVar);
                }
                if (((vg.a) bd.this).f441565h != null && ((vg.a) bd.this).f441565h.isNewHandBlogFeed()) {
                    com.qzone.adapter.feedcomponent.i.H().f(302, 100, 0);
                }
                com.qzone.util.ap.f59791b.e(218, 1, ((vg.a) bd.this).f441567m, ((vg.a) bd.this).f441565h);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellBottomRecomm f55564d;

        c(CellBottomRecomm cellBottomRecomm) {
            this.f55564d = cellBottomRecomm;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            yo.d.d(this.f55564d.actionurl, view.getContext(), null);
            com.qzone.util.ap.f59791b.e(211, 1, ((vg.a) bd.this).f441567m, ((vg.a) bd.this).f441565h);
            if (bd.this.P != null) {
                QZonePerfReporter.f59697a.j("custom", "small_tail_click_recom_" + bd.this.P.getText());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void V() {
        final String a16 = ef.b.a(this.f441565h);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.presenter.ay
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                bd.this.Y(a16, (gf.e) obj);
            }
        }).run();
    }

    private void W(final BusinessFeedData businessFeedData) {
        this.F.setVisibility(0);
        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bd.this.Z(businessFeedData, view);
            }
        });
        i0(businessFeedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(String str, gf.e eVar) {
        HashMap hashMap = new HashMap();
        QZoneRichTextView qZoneRichTextView = this.P;
        if (qZoneRichTextView != null) {
            hashMap.put("tail_text", qZoneRichTextView.getText());
        }
        eVar.f9(this.G, "em_qz_small_tail", str, hashMap, this.f441565h);
        eVar.f9(this.S, "em_qz_small_tail", str, hashMap, this.f441565h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QZoneFeedUtil.O(businessFeedData) || QZoneConfigHelper.s()) {
            vo.c.S(this.C, businessFeedData, false);
            g0(businessFeedData);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(AnimationDrawable animationDrawable) {
        ImageView imageView = this.K;
        if (imageView != null) {
            imageView.setImageDrawable(animationDrawable);
            this.K.setScaleType(ImageView.ScaleType.FIT_XY);
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.G.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void c0(String str) {
        com.tencent.mobileqq.qzone.picload.c.a().j(this.R, new c.C8489c().h(str).f("").e(R.color.qui_common_text_secondary));
    }

    private void f0(CellReferInfo cellReferInfo) {
        String str;
        long j3;
        String str2;
        LpReportInfo_dc03950 lpReportInfo_dc03950;
        CellUserInfo cellUserInfo;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null) {
            this.S.setTag(businessFeedData.getFeedCommInfoV2().feedskey);
            if (this.f441565h.isNewHandBlogFeed()) {
                com.qzone.adapter.feedcomponent.i.H().f(302, 101, 0);
            }
        }
        if (cellReferInfo == null || (str = cellReferInfo.actionUrl) == null || !str.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP)) {
            return;
        }
        BusinessFeedData businessFeedData2 = this.f441565h;
        if (businessFeedData2 != null) {
            j3 = businessFeedData2.owner_uin;
            if (j3 == 0 && (cellUserInfo = businessFeedData2.getCellUserInfo()) != null && cellUserInfo.getUserV2() != null) {
                j3 = cellUserInfo.getUserV2().uin;
            }
        } else {
            j3 = 0;
        }
        if (j3 > 0 && j3 == com.qzone.adapter.feedcomponent.i.H().j0()) {
            str2 = "5";
        } else {
            str2 = "9";
        }
        String str3 = str2;
        String l06 = com.qzone.adapter.feedcomponent.i.H().l0(com.qzone.adapter.feedcomponent.i.H().j0());
        if (!TextUtils.isEmpty(l06)) {
            lpReportInfo_dc03950 = new LpReportInfo_dc03950("25", str3, "1", "1", l06);
        } else {
            lpReportInfo_dc03950 = new LpReportInfo_dc03950("25", str3, "1", "1");
        }
        LpReportInfo_dc03950.report(lpReportInfo_dc03950);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(final AnimationDrawable animationDrawable) {
        if (this.K != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.bb
                @Override // java.lang.Runnable
                public final void run() {
                    bd.this.a0(animationDrawable);
                }
            });
        }
    }

    private void k0(View view, Space space) {
        space.getLayoutParams().width = (int) this.f441562d.getResources().getDimension(R.dimen.f9770_);
        if (view.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            View view2 = this.W;
            if (view2 != null && view2 != view) {
                layoutParams.topMargin = com.qzone.util.ar.d(3.0f);
            } else {
                layoutParams.topMargin = 0;
                this.W = view;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private void m0(CellLbsInfo cellLbsInfo, CellRemarkInfo cellRemarkInfo) {
        String str;
        ShootInfo shootInfo;
        if (cellLbsInfo == null) {
            str = "";
        } else {
            str = cellLbsInfo.getLBSString();
        }
        if (TextUtils.isEmpty(str) && cellRemarkInfo != null && (shootInfo = cellRemarkInfo.shoot_info) != null) {
            str = shootInfo.shoot_location;
        }
        if (TextUtils.isEmpty(str)) {
            this.I.setVisibility(8);
            return;
        }
        this.I.setVisibility(0);
        com.tencent.mobileqq.qzone.picload.c.a().j(this.U, new c.C8489c().h("position").f("").e(R.color.qui_common_text_secondary));
        this.V.setVisibility(0);
        this.V.setRichText(str);
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            this.V.setContentDescription(com.qzone.adapter.feedcomponent.d.t(com.qzone.adapter.feedcomponent.d.r(str)));
        }
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null) {
            this.V.setTag(businessFeedData.getFeedCommInfoV2().feedskey);
        }
        k0(this.I, this.T);
    }

    private void o0(CellBottomRecomm cellBottomRecomm, CellRemarkInfo cellRemarkInfo, CellColorfulTail cellColorfulTail) {
        PictureUrl pictureUrl;
        int o16 = o();
        boolean z16 = o16 == 9 || o16 == 10;
        if (cellBottomRecomm != null && !TextUtils.isEmpty(cellBottomRecomm.title) && !z16 && d0(cellColorfulTail, cellBottomRecomm)) {
            this.G.setVisibility(0);
            this.P.setRichText(cellBottomRecomm.title);
            QZonePerfReporter.f59697a.j("custom", "small_tail_exp_recom_" + this.P.getText());
            k0(this.G, this.M);
            c.C8489c e16 = new c.C8489c().h(cellBottomRecomm.iconToken).e(R.color.qui_common_text_secondary);
            PictureItem pictureItem = cellBottomRecomm.picinfo;
            if (pictureItem != null && (pictureUrl = pictureItem.currentUrl) != null) {
                e16.f(pictureUrl.url);
            }
            com.tencent.mobileqq.qzone.picload.c.a().j(this.N, e16);
            this.G.setOnClickListener(new c(cellBottomRecomm));
            this.P.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.az
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bd.this.b0(view);
                }
            });
            return;
        }
        if (cellRemarkInfo != null && !TextUtils.isEmpty(cellRemarkInfo.getRemarkDisplayStr()) && !z16) {
            this.G.setVisibility(0);
            this.P.setRichText(cellRemarkInfo.getRemarkDisplayStr());
            k0(this.G, this.M);
            BusinessFeedData businessFeedData = this.f441565h;
            if (businessFeedData != null) {
                this.P.setTag(businessFeedData.getFeedCommInfoV2().feedskey);
            }
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                this.P.setContentDescription(com.qzone.adapter.feedcomponent.d.t(com.qzone.adapter.feedcomponent.d.r(cellRemarkInfo.getRemarkDisplayStr())));
                return;
            }
            return;
        }
        this.G.setVisibility(8);
    }

    private void q0(BusinessFeedData businessFeedData) {
        CellDecorateInfo.CellPrdData cellPrdData = businessFeedData.cellDecorateInfo.cellPrdData;
        if (cellPrdData.iType == 0) {
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(cellPrdData.strResUrl).setTargetView(this.K));
        } else {
            QzoneZipAnimateUtil.j(cellPrdData.strResUrl, "feed_visitor", cellPrdData.strResUrl.hashCode() + "", ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f), 100, new a());
        }
        this.L.setText(businessFeedData.getVisitorInfo().visitorDecoDisplayStr);
        s0(cellPrdData);
        W(businessFeedData);
    }

    private void r0(BusinessFeedData businessFeedData) {
        this.L.setText(businessFeedData.getVisitorInfo().displayStr);
        com.tencent.mobileqq.qzone.picload.c.a().j(this.K, new c.C8489c().h("qui_eye_on").e(R.color.qui_common_text_secondary));
        if (this.L.getPaint() != null) {
            this.L.getPaint().setShader(null);
        }
        W(businessFeedData);
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedTailPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneRichTextView qZoneRichTextView = this.L;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setAnimation(null);
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.noe;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        this.W = null;
        CellRemarkInfo remarkInfoV2 = businessFeedData.getRemarkInfoV2();
        CellReferInfo referInfoV2 = businessFeedData.getReferInfoV2();
        CellLbsInfo lbsInfoV2 = businessFeedData.getLbsInfoV2();
        CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
        CellColorfulTail cellColorfulTail = businessFeedData.getCellColorfulTail();
        p0(businessFeedData);
        o0(cellBottomRecomm, remarkInfoV2, cellColorfulTail);
        n0(businessFeedData, referInfoV2);
        m0(lbsInfoV2, remarkInfoV2);
        V();
        if (TextUtils.isEmpty(ef.b.a(businessFeedData))) {
            return;
        }
        ze.a.a().observerGlobalState(new af.d(ef.b.a(businessFeedData), businessFeedData.getVisitorInfo()), this);
    }

    private boolean d0(CellColorfulTail cellColorfulTail, CellBottomRecomm cellBottomRecomm) {
        if (cellColorfulTail != null) {
            int i3 = cellColorfulTail.type;
            int i16 = CellBottomRecomm.TYPE_EVENT_TAG;
            if (i3 == i16 && cellBottomRecomm != null && cellBottomRecomm.anonymity == i16) {
                return false;
            }
        }
        return true;
    }

    private boolean l0(BusinessFeedData businessFeedData) {
        CellDecorateInfo cellDecorateInfo;
        CellDecorateInfo.CellPrdData cellPrdData;
        return (businessFeedData == null || (cellDecorateInfo = businessFeedData.cellDecorateInfo) == null || (cellPrdData = cellDecorateInfo.cellPrdData) == null || TextUtils.isEmpty(cellPrdData.strResUrl) || businessFeedData.getVisitorInfo() == null || businessFeedData.getVisitorInfo().viewCount <= 0 || !com.qzone.personalize.business.b.n().d()) ? false : true;
    }

    private void s0(CellDecorateInfo.CellPrdData cellPrdData) {
        if (cellPrdData == null || TextUtils.isEmpty(cellPrdData.strColorBegin) || TextUtils.isEmpty(cellPrdData.strColorEnd)) {
            return;
        }
        try {
            this.L.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, com.qzone.util.ar.e(20.0f), new int[]{Color.parseColor(cellPrdData.strColorBegin), Color.parseColor(cellPrdData.strColorEnd)}, (float[]) null, Shader.TileMode.CLAMP));
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.c("QZoneFeedTailPresenter", e16.toString());
        }
    }

    private void t0(CellReferInfo cellReferInfo) {
        String str;
        if (cellReferInfo == null || !com.tencent.mobileqq.service.qzone.e.f286406a.e()) {
            return;
        }
        if (QQTheme.isNowThemeIsNightForQzone()) {
            str = cellReferInfo.nightTextColor;
        } else {
            str = cellReferInfo.textColor;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.S.setTextColor(Color.parseColor(str));
        } catch (Exception e16) {
            QLog.e("QZoneFeedTailPresenter", 1, "updateAttachReferTextColor  e = " + e16);
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.d dVar) {
        if (dVar == null || !TextUtils.equals(dVar.a(), ef.b.a(this.f441565h))) {
            return;
        }
        this.f441565h.setVisitorInfo(dVar.b());
        p0(this.f441565h);
    }

    private void g0(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getUser() != null && LoginData.getInstance().getUin() == businessFeedData.getUser().uin) {
            str = "1";
        } else {
            str = "0";
        }
        LpReportInfo_pf00064.allReport(201, 5, 2, "", businessFeedData.getFeedCommInfoV2() == null ? null : businessFeedData.getFeedCommInfoV2().feedskey, str);
        FeedActionRecorder.getInstance().addAction(businessFeedData, this.f441567m, System.currentTimeMillis(), 37, 1);
    }

    private void i0(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getUser() != null && LoginData.getInstance().getUin() == businessFeedData.getUser().uin) {
            str = "1";
        } else {
            str = "0";
        }
        com.qzone.adapter.feedcomponent.i.H().g(201, 5, 1, "", businessFeedData.getFeedCommInfoV2() == null ? null : this.f441565h.getFeedCommInfoV2().feedskey, str);
    }

    @Override // vg.a
    protected void C(View view) {
        View findViewById = view.findViewById(R.id.n1k);
        this.F = findViewById;
        this.J = (Space) findViewById.findViewById(R.id.nbe);
        this.L = (QZoneRichTextView) this.F.findViewById(R.id.nbd);
        this.K = (ImageView) this.F.findViewById(R.id.nbc);
        QZoneRichTextView qZoneRichTextView = this.L;
        int i3 = X;
        qZoneRichTextView.setMaxWidth(i3);
        View findViewById2 = view.findViewById(R.id.n1l);
        this.G = findViewById2;
        this.M = (Space) findViewById2.findViewById(R.id.nbe);
        this.P = (QZoneRichTextView) this.G.findViewById(R.id.nbd);
        this.N = (ImageView) this.G.findViewById(R.id.nbc);
        this.P.setMaxWidth(i3);
        View findViewById3 = view.findViewById(R.id.n1m);
        this.H = findViewById3;
        this.Q = (Space) findViewById3.findViewById(R.id.nbe);
        this.S = (QZoneRichTextView) this.H.findViewById(R.id.nbd);
        this.R = (ImageView) this.H.findViewById(R.id.nbc);
        this.S.setMaxWidth(i3);
        View findViewById4 = view.findViewById(R.id.n1n);
        this.I = findViewById4;
        this.T = (Space) findViewById4.findViewById(R.id.nbe);
        this.V = (QZoneRichTextView) this.I.findViewById(R.id.nbd);
        this.U = (ImageView) this.I.findViewById(R.id.nbc);
        this.V.setMaxWidth(i3);
    }

    private void p0(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getVisitorInfo() != null && businessFeedData.getVisitorInfo().viewCount > 0) {
            if (l0(businessFeedData)) {
                q0(businessFeedData);
            } else if (!TextUtils.isEmpty(businessFeedData.getVisitorInfo().displayStr)) {
                r0(businessFeedData);
            } else {
                this.F.setVisibility(8);
            }
            k0(this.F, this.J);
            return;
        }
        this.F.setVisibility(8);
    }

    private void n0(BusinessFeedData businessFeedData, CellReferInfo cellReferInfo) {
        String str = cellReferInfo == null ? null : cellReferInfo.appName;
        CellFeedCommInfo feedCommInfoV2 = businessFeedData != null ? businessFeedData.getFeedCommInfoV2() : null;
        if (TextUtils.isEmpty(str) && feedCommInfoV2 != null) {
            str = feedCommInfoV2.refer;
        }
        if (TextUtils.isEmpty(str)) {
            this.H.setVisibility(8);
            return;
        }
        this.H.setVisibility(0);
        this.R.setVisibility(0);
        if (cellReferInfo != null && !TextUtils.isEmpty(cellReferInfo.iconToken)) {
            c0(cellReferInfo.iconToken);
        } else if (cellReferInfo != null && !TextUtils.isEmpty(cellReferInfo.icon)) {
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(com.tencent.mobileqq.service.qzone.e.f286406a.a(cellReferInfo.icon)).setTargetView(this.R));
        } else if (feedCommInfoV2 != null && !TextUtils.isEmpty(feedCommInfoV2.iconToken)) {
            c0(feedCommInfoV2.iconToken);
        } else {
            this.R.setVisibility(8);
        }
        this.S.setVisibility(0);
        this.S.setOnClickListener(new b(cellReferInfo, businessFeedData));
        this.S.setRichText(str);
        QZoneRichTextView qZoneRichTextView = this.S;
        qZoneRichTextView.setTextColor(qZoneRichTextView.getContext().getColor(R.color.qui_common_text_secondary));
        t0(cellReferInfo);
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            this.S.setContentDescription(com.qzone.adapter.feedcomponent.d.t(com.qzone.adapter.feedcomponent.d.r(str)));
        }
        f0(cellReferInfo);
        k0(this.H, this.Q);
    }

    public void X(View view, CellReferInfo cellReferInfo, BusinessFeedData businessFeedData) {
        AppInfo appInfo;
        if (cellReferInfo == null || view == null) {
            return;
        }
        Activity c16 = com.qzone.reborn.feedx.widget.i.c(view);
        try {
            appInfo = com.qzone.business.plusunion.business.a.h().e(Integer.parseInt(cellReferInfo.appid));
        } catch (Exception unused) {
            QLog.e("QZoneFeedTailPresenter", 1, "parseAppId error:" + ((Object) null), null);
            appInfo = null;
        }
        if (appInfo == null && !TextUtils.isEmpty(cellReferInfo.actionUrl)) {
            yo.d.d(cellReferInfo.actionUrl, this.C, null);
            return;
        }
        if (com.qzone.business.plusunion.business.a.h().b(appInfo)) {
            com.qzone.business.plusunion.business.a.h().u(c16, appInfo);
            return;
        }
        try {
            Integer.valueOf(cellReferInfo.appid);
            Intent c17 = com.qzone.common.activities.base.ak.c(c16);
            c17.putExtra(QZoneAppIntroActivity.H, cellReferInfo.appid);
            c16.startActivityForResult(c17, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED);
        } catch (Exception unused2) {
        }
    }
}
