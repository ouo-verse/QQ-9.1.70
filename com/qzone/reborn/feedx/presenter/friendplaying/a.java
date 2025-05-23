package com.qzone.reborn.feedx.presenter.friendplaying;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.component.banner.general.builder.bigcard.GeneralBigCardView;
import com.qzone.component.banner.general.view.GameCenterGameBottom;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.k;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import gf.r;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends vg.a implements r, View.OnClickListener, i6.d {
    public GeneralBigCardView F;
    public ViewGroup G;
    public GameCenterGameBottom H;
    private String I = null;

    private void H() {
        int i3;
        EventCenter.getInstance().post("Feed", 27);
        EventCenter.getInstance().post("WriteOperation", 38, this.f441565h.getFeedCommInfo().feedskey);
        Iterator<s_droplist_option> it = this.f441565h.getFeedCommInfo().customDroplist.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = 81;
                break;
            }
            s_droplist_option next = it.next();
            if (next.actiontype == 42) {
                i3 = next.reporttype;
                break;
            }
        }
        QZoneWriteOperationService.v0().O(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getHandler(), this.f441565h.getUser().uin, i3, this.f441565h.getOperationInfo().droplist_cookie, null);
    }

    private boolean J() {
        k kVar;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null || (kVar = businessFeedData.cellGameRecommend) == null || l6.d.f(kVar.f50338d, "app_type") != 1 || l6.d.f(this.f441565h.cellGameRecommend.f50338d, "game_status") != 3) {
            return false;
        }
        return ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).hasGameInstall(l6.d.g(this.f441565h.cellGameRecommend.f50338d, "package_name"));
    }

    private void K(boolean z16) {
        GeneralBigCardView generalBigCardView = this.F;
        if (generalBigCardView == null) {
            return;
        }
        generalBigCardView.G(z16);
    }

    private void L(String str) {
        if (l6.d.f(this.f441565h.cellGameRecommend.f50338d, "app_type") != 4) {
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQzoneFeed(this.f441565h.cellGameRecommend.f50338d.g(), "2009", "2009_22", null, "page_view", str, "qzone_3th_feeds_video", this.f441565h.cellGameRecommend.f50337c);
    }

    private void M(String str) {
        k kVar;
        i6.a aVar;
        String str2;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null || (kVar = businessFeedData.cellGameRecommend) == null || (aVar = kVar.f50338d) == null) {
            return;
        }
        if (str == "914337") {
            l6.d.k(aVar.d(), 101, "tianshu.81");
        } else if (str != "914339" && str != "914338") {
            if (str == "914345") {
                l6.d.k(aVar.d(), 122, "tianshu.81");
            }
        } else {
            l6.d.k(aVar.d(), 102, "tianshu.81");
        }
        int f16 = l6.d.f(aVar, "app_type");
        if (str == "914337") {
            str2 = "8";
        } else {
            str2 = "20";
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087);
        wadlReportBuilder.setBussinessId("5").setPageId("1092").setOperModule("9404").setModuleType("940402");
        if ("205992".equals(str)) {
            wadlReportBuilder.setExtSubModule("940402");
        }
        wadlReportBuilder.setGameAppId(aVar.g()).setOperId(str);
        wadlReportBuilder.setExt(4, str2).setExt(6, String.valueOf(f16)).setExt(9, aVar.e()).setExt(25, String.valueOf(aVar.c())).setExt(45, l6.d.a(f16));
        wadlReportBuilder.report();
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        i6.a aVar;
        if (businessFeedData != null && this.F != null) {
            k kVar = businessFeedData.cellGameRecommend;
            if (kVar != null && (aVar = kVar.f50338d) != null) {
                QLog.e("QZoneFriendPlayingBigCardFeedContentPresenter", 1, "[setData] bind feed data:", aVar);
                this.I = businessFeedData.cellGameRecommend.f50338d.n();
                this.F.j(businessFeedData.cellGameRecommend.f50338d);
                if (this.H != null) {
                    this.F.G.setVisibility(8);
                    this.F.F.setVisibility(8);
                    this.H.n(businessFeedData.cellGameRecommend.f50338d);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.F.I.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.leftMargin = 0;
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e("QZoneFriendPlayingBigCardFeedContentPresenter", 1, "[setData] bigGardFeedData is null");
            return;
        }
        QLog.e("QZoneFriendPlayingBigCardFeedContentPresenter", 1, "[setData] feedData is null");
    }

    @Override // vg.a
    protected void C(View view) {
        if (view instanceof GeneralBigCardView) {
            GeneralBigCardView generalBigCardView = (GeneralBigCardView) view;
            this.F = generalBigCardView;
            generalBigCardView.i(null);
            I(this.F);
            this.F.setActionCallback(this);
            this.F.findViewById(R.id.mqt).setOnClickListener(this);
            this.F.D.setOnClickListener(this);
            ImageView imageView = (ImageView) this.F.D.findViewById(R.id.l2y);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.f15538f);
                imageView.setOnClickListener(this);
            }
        }
    }

    @Override // gf.r
    public void a() {
        GeneralBigCardView generalBigCardView = this.F;
        if (generalBigCardView == null) {
            return;
        }
        generalBigCardView.a();
    }

    @Override // vg.a, vg.c
    public void c() {
        super.c();
        GameCenterGameBottom gameCenterGameBottom = this.H;
        if (gameCenterGameBottom != null) {
            gameCenterGameBottom.q();
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        if (this.F == null) {
            return null;
        }
        QLog.d("QZoneFriendPlayingBigCardFeedContentPresenter", 1, "getVideoItemView   | feedPos = " + this.f441567m + " | view = " + this.F);
        return this.F.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendPlayingBigCardFeedContentPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            switch (view.getId()) {
                case R.id.f195762 /* 1745223782 */:
                    this.H.f();
                    if (J()) {
                        M("205992");
                    }
                    LpReportInfo_pf00064.allReport(619, 18, 3, "", "2");
                    L("pg_click");
                    M("914339");
                    break;
                case R.id.l2y /* 1745224100 */:
                    GeneralBigCardView generalBigCardView = this.F;
                    if (generalBigCardView != null && generalBigCardView.D != null) {
                        QLog.d("QZoneFriendPlayingBigCardFeedContentPresenter", 1, "[onclick] video play icon");
                        K(true);
                        break;
                    }
                    break;
                case R.id.mqt /* 1745224597 */:
                case R.id.f162969nl4 /* 1745225753 */:
                    if (!TextUtils.isEmpty(this.I)) {
                        QLog.d("QZoneFriendPlayingBigCardFeedContentPresenter", 1, "[onclick] card jump url:", this.I);
                        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, this.I);
                    }
                    LpReportInfo_pf00064.allReport(619, 18, 2, "", "2");
                    L("pg_click");
                    M("914338");
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // gf.r
    public void pause() {
        GeneralBigCardView generalBigCardView = this.F;
        if (generalBigCardView == null) {
            return;
        }
        generalBigCardView.pause();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nlj;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        super.z();
        LpReportInfo_pf00064.allReport(619, 18, 1, "", "2");
        L("expo");
        M("914337");
    }

    @Override // i6.d
    public void b() {
        QLog.i("QZoneFriendPlayingBigCardFeedContentPresenter", 1, "closeAd");
        H();
        LpReportInfo_pf00064.allReport(619, 18, 4, "", "2");
        M("914345");
    }

    @Override // gf.r
    public void play() {
        K(false);
    }

    private void I(GeneralBigCardView generalBigCardView) {
        ViewStub viewStub;
        if (generalBigCardView == null || (viewStub = (ViewStub) generalBigCardView.findViewById(R.id.f192658)) == null) {
            return;
        }
        GameCenterGameBottom gameCenterGameBottom = new GameCenterGameBottom(generalBigCardView.getContext());
        this.H = gameCenterGameBottom;
        gameCenterGameBottom.findViewById(R.id.f195762).setOnClickListener(this);
        ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
        this.G = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.G.addView(this.H);
        }
    }
}
