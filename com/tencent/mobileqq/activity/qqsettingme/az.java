package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletHomeApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.util.QQSettingUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class az extends q {
    static IPatchRedirector $redirector_;

    public az() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int J2 = VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), false);
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A8C4", "0X800A8C4", J2, 0, String.valueOf(J2), "", "", "");
        BusinessInfoCheckUpdate.AppInfo appInfo = ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(100007));
        if (appInfo != null && appInfo.iNewFlag.get() == 1) {
            str = "1";
        } else {
            str = "2";
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        ReportController.o(peekAppRuntime, "P_CliOper", "Vip_pay_mywallet", currentUin, QCircleDaTongConstant.ElementParamValue.WALLET, "wallet.entrance.show", 0, 0, str, NetConnInfoCenter.getServerTimeMillis() + "", "", AppSetting.f99551k);
        ((IQWalletHomeApi) QRoute.api(IQWalletHomeApi.class)).checkRedPointResReady(appInfo);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        int numRedNumByAppIdAndMsgType = iRedTouchManager.getNumRedNumByAppIdAndMsgType(100007, 100);
        if (numRedNumByAppIdAndMsgType > 0) {
            appInfo = iRedTouchManager.createNumAppInfo(1, 100007, "100007", numRedNumByAppIdAndMsgType, false);
        }
        super.j(appInfo, z16);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onResume();
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_qqwallet", Boolean.FALSE);
        if (i3 != null && i3.getVisibility() == 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.ay
                @Override // java.lang.Runnable
                public final void run() {
                    az.t();
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    public void q(View view) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        if (!((IQWalletHelper) QRoute.api(IQWalletHelper.class)).isValidToLaunchQWallet(System.currentTimeMillis())) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).launchQWalletAct(qBaseActivity, peekAppRuntime, true, 1);
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        QQSettingUtil.h(qQAppInterface);
        if (com.tencent.mobileqq.qqsettingme.a.g("d_qqwallet") == null) {
            return;
        }
        boolean hasRedTouch = com.tencent.mobileqq.qqsettingme.a.g("d_qqwallet").hasRedTouch();
        if (this.f185016h.getValue() != null && this.f185016h.getValue().iNewFlag.get() != 0) {
            ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(100007, 31);
        }
        int J2 = VipInfoHandler.J2(qQAppInterface, peekAppRuntime.getCurrentUin(), hasRedTouch);
        String currentUin = peekAppRuntime.getCurrentUin();
        if (hasRedTouch) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(peekAppRuntime, "P_CliOper", "Vip_pay_mywallet", currentUin, QCircleDaTongConstant.ElementParamValue.WALLET, "wallet.entrance.click", 0, 0, str, NetConnInfoCenter.getServerTimeMillis() + "", "", AppSetting.f99551k);
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A8BF", "0X800A8BF", J2, 0, String.valueOf(J2), "", "", "");
        int i3 = com.tencent.mobileqq.qqsettingme.a.f274434i;
        if (i3 > 0) {
            DrawerFrame.f185113z0 = 2;
        } else {
            DrawerFrame.f185113z0 = i3;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_qqwallet";
    }
}
