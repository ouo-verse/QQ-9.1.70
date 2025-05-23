package com.qzone.reborn.feedx.presenter.friendplaying;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends vg.a implements View.OnClickListener {
    private TextView F;
    private TextView G;
    private ImageView H;
    private String I;

    private void H() {
        if (this.H == null) {
            return;
        }
        if (this.C == null) {
            QLog.e("QZoneFriendPlayingFeedTitlePresenter", 1, "mActivity is null");
            return;
        }
        if (!TextUtils.isEmpty(this.I)) {
            QLog.e("QZoneFriendPlayingFeedTitlePresenter", 1, "jump url:", this.I);
            gh.c.c(this.C, this.f441565h, new com.qzone.proxy.feedcomponent.model.e(this.I, "", this.f441567m));
        }
        I("em_click");
    }

    private void I(String str) {
        String str2;
        String str3;
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportByQzoneFeed(null, null, null, "qzone_friends", "page_view", str, "qzone_friends_playing", null);
        if (str == "em_click") {
            str2 = "914343";
        } else {
            str2 = "914340";
        }
        if (str == "em_click") {
            str3 = "20";
        } else {
            str3 = "8";
        }
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087);
        wadlReportBuilder.setBussinessId("5").setPageId("1092").setOperModule("9404").setModuleType("940403");
        wadlReportBuilder.setOperId(str2);
        wadlReportBuilder.setExt(4, str3);
        wadlReportBuilder.report();
        LpReportInfo_pf00064.allReport(619, 19, str != "em_click" ? 1 : 4, (String) null, "2");
    }

    private void J() {
        this.F.setText(HardCodeUtil.qqStr(R.string.jmp));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendPlayingFeedTitlePresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && (view.getId() == R.id.n1w || view.getId() == R.id.n1x)) {
            H();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nlk;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        super.z();
        I("em_expo");
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            QLog.e("QZoneFriendPlayingFeedTitlePresenter", 1, "[setData] feedData is null");
            return;
        }
        k kVar = businessFeedData.cellGameRecommend;
        if (kVar != null) {
            this.I = kVar.f50336b;
        }
        J();
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (TextView) view.findViewById(R.id.n1y);
        this.G = (TextView) view.findViewById(R.id.n1x);
        ImageView imageView = (ImageView) view.findViewById(R.id.n1w);
        this.H = imageView;
        imageView.setOnClickListener(this);
        this.G.setOnClickListener(this);
    }
}
