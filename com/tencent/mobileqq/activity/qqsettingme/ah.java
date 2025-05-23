package com.tencent.mobileqq.activity.qqsettingme;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ah extends q {
    static IPatchRedirector $redirector_;

    public ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        if (this.f259745f) {
            ((QzoneAlbumRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH)).e(appInfo);
        }
        super.j(appInfo, z16);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    public void q(View view) {
        boolean z16;
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_MY_PHOTO));
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (z17) {
            iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_MY_PHOTO, 31);
        }
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.setActionType("443");
        reportInfo.setSubactionType("3");
        reportInfo.setToUin(peekAppRuntime.getLongAccountUin());
        if (z17) {
            str = "1";
        } else {
            str = "2";
        }
        reportInfo.setReserves(str);
        QZoneClickReport.startReportImediately(peekAppRuntime.getCurrentAccountUin(), reportInfo);
        LpReportInfo_pf00064.report(326, 30, 2);
        try {
            j3 = Long.valueOf(peekAppRuntime.getCurrentAccountUin()).longValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = String.valueOf(j3);
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String currentNickname = qQAppInterface.getCurrentNickname();
        if (TextUtils.isEmpty(currentNickname)) {
            currentNickname = com.tencent.mobileqq.utils.ac.f(qQAppInterface, peekAppRuntime.getCurrentAccountUin());
        }
        userInfo.nickname = currentNickname;
        QZoneHelper.forwardFromQQSettingToPersonalAlbum(qBaseActivity, userInfo, Long.valueOf(j3), 0, z17, -1);
        QZoneClickReport.ReportInfo reportInfo2 = new QZoneClickReport.ReportInfo();
        reportInfo2.actionType = "1";
        reportInfo2.subactionType = "0";
        reportInfo2.tabletype = 4;
        reportInfo2.sourceType = "3";
        reportInfo2.sourceFrom = QZoneClickReport.ClickReportConfig.SOURCE_FROM_DRAWER;
        reportInfo2.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_PHOTOLIST;
        QZoneClickReport.startReportImediately(peekAppRuntime.getAccount(), reportInfo2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "3");
        hashMap.put("source_from", QZoneClickReport.ClickReportConfig.SOURCE_FROM_DRAWER);
        hashMap.put("source_to", QZoneClickReport.ClickReportConfig.SOURCE_TO_PHOTOLIST);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(peekAppRuntime.getAccount(), StatisticCollector.QZONE_SOURCE_DATA_REPORT, true, 0L, 0L, hashMap, null);
        ReportController.o(peekAppRuntime, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
        DrawerFrame.f185113z0 = com.tencent.mobileqq.qqsettingme.a.f274434i;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    protected void r(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_album", Boolean.FALSE);
        if (i3 != null && i3.getVisibility() == 0) {
            LpReportInfo_pf00064.report(326, 30, 1);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_album";
    }
}
