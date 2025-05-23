package com.qzone.component.banner;

import android.content.Context;
import com.qzone.common.account.LoginData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import ho.i;

/* loaded from: classes39.dex */
public class PassiveFeedBubbleBanner extends BaseBubbleBanner {
    public PassiveFeedBubbleBanner(Context context) {
        super(context);
        BaseBubbleBanner.S = "PassiveFeedBubbleBanner";
    }

    @Override // com.qzone.component.banner.BaseBubbleBanner
    public void C() {
        super.C();
        i.u().a(getContext(), "getActiveFeeds", 1);
        g();
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.toUin = LoginData.getInstance().getUin();
        lpReportInfo_pf00064.toUin = LoginData.getInstance().getUin();
        lpReportInfo_pf00064.appId = String.valueOf(1);
        lpReportInfo_pf00064.referId = "getActiveFeeds";
        lpReportInfo_pf00064.actionType = 302;
        lpReportInfo_pf00064.subactionType = 32;
        lpReportInfo_pf00064.reserves = 6;
        lpReportInfo_pf00064.readSource = "2";
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.component.banner.BaseBubbleBanner
    public void F() {
        super.F();
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.toUin = LoginData.getInstance().getUin();
        lpReportInfo_pf00064.toUin = LoginData.getInstance().getUin();
        lpReportInfo_pf00064.appId = String.valueOf(1);
        lpReportInfo_pf00064.referId = "getActiveFeeds";
        lpReportInfo_pf00064.actionType = 302;
        lpReportInfo_pf00064.subactionType = 32;
        lpReportInfo_pf00064.reserves = 7;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064);
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 0;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 17;
    }
}
