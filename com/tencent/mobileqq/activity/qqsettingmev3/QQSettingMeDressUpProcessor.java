package com.tencent.mobileqq.activity.qqsettingmev3;

import MQQ.MenumItem;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.activity.qqsettingme.q;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.o;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class QQSettingMeDressUpProcessor extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public final MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.b> f185039i;

    public QQSettingMeDressUpProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185039i = new MutableLiveData<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t() {
        String str;
        MenumItem c16 = o.a().c((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), "key_svip_item_makup_");
        if (c16 != null) {
            str = c16.user_group + "";
        } else {
            str = "0";
        }
        MobileReportManager.getInstance().qqSetingMeReport(6, 101, str);
    }

    private void u(String str) {
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity != null && !VasUtils.b()) {
            VasWebviewUtil.openIndividuationIndex(qBaseActivity, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.d(aVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SharedPreferences sharedPreferences = peekAppRuntime.getApplication().getSharedPreferences(peekAppRuntime.getCurrentAccountUin(), 0);
        if (appInfo != null && appInfo.iNewFlag.get() == 1) {
            sharedPreferences.edit().putBoolean(VasWebviewUtil.IS_FORCE_PULL_JSON_SP_KEY, true).commit();
        } else {
            sharedPreferences.edit().putBoolean(VasWebviewUtil.IS_FORCE_PULL_JSON_SP_KEY, false).commit();
        }
        if (this.f259745f) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingmev3.QQSettingMeDressUpProcessor.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f185041d;

                {
                    this.f185041d = peekAppRuntime;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeDressUpProcessor.this, (Object) peekAppRuntime);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IWebProcessManagerService iWebProcessManagerService;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (this.f185041d != null && QQSettingMeDressUpProcessor.this.f185016h.getValue() != null && QQSettingMeDressUpProcessor.this.f185016h.getValue().iNewFlag.get() == 1 && (iWebProcessManagerService = (IWebProcessManagerService) this.f185041d.getRuntimeService(IWebProcessManagerService.class, "")) != null) {
                        iWebProcessManagerService.startWebProcess(23, null);
                    }
                }
            });
        }
        super.j(appInfo, z16);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingmev3.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeDressUpProcessor.t();
                }
            }, 16, null, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ab  */
    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(View view) {
        boolean z16;
        boolean z17;
        MenumItem c16;
        String str;
        int i3;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(100005));
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("QQSettingMeBaseProcessor", 1, "appinfo is :" + appInfoByPath + ", hasRedTouch:" + z16);
            iRedTouchManager.reportLevelOneRedInfo(100005, 31);
        }
        if (z16) {
            String str2 = appInfoByPath.buffer.get();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("ad_id");
                    String string2 = jSONObject.getString(SsoReporter.POS_ID_KEY);
                    JSONObject jSONObject2 = new JSONObject(new JSONObject(jSONObject.optString("msg")).optString(jSONObject.optString("_show_mission")));
                    if (jSONObject2.optString("src").equals("vipActPopupsAds")) {
                        String optString = jSONObject2.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                        if (!optString.isEmpty()) {
                            try {
                                String newReportInfo = MobileReportManager.getNewReportInfo(appInfoByPath);
                                QLog.i("QQSettingMeBaseProcessor", 1, "appinfo is :" + appInfoByPath + ", hasRedTouch:" + z16 + ", stringReport2H5:" + newReportInfo);
                                u(newReportInfo);
                                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(view.getContext(), ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(optString, new IVipTraceDetailReport.b("vab_red", string2, string, "5"), true));
                                z19 = true;
                            } catch (Exception e16) {
                                e = e16;
                                i3 = 0;
                                z18 = true;
                                QLog.e("QQSettingMeBaseProcessor", 1, e, new Object[i3]);
                                z19 = z18;
                                if (!z19) {
                                }
                                z17 = true;
                                ThreadManagerV2.post(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingmev3.QQSettingMeDressUpProcessor.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ AppRuntime f185040d;

                                    {
                                        this.f185040d = peekAppRuntime;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeDressUpProcessor.this, (Object) peekAppRuntime);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        AppRuntime appRuntime = this.f185040d;
                                        if (appRuntime != null) {
                                            String currentAccountUin = appRuntime.getCurrentAccountUin();
                                            if (!TextUtils.isEmpty(currentAccountUin)) {
                                                ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).setBusinessClickTimeMills(currentAccountUin, IndividuationPlugin.BusinessName);
                                            }
                                            this.f185040d.getApplication().getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + this.f185040d.getCurrentAccountUin(), 0).edit().putLong(IEmoticonMainPanel.SP_KEY_MARKET_OPEN_TIME, System.currentTimeMillis()).commit();
                                        }
                                    }
                                }, 5, null, z17);
                                c16 = o.a().c((QQAppInterface) peekAppRuntime, "key_svip_item_makup_");
                                if (c16 == null) {
                                }
                                MobileReportManager.getInstance().qqSetingMeReport(6, 102, str);
                                ReportController.o(peekAppRuntime, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
                                DrawerFrame.f185113z0 = com.tencent.mobileqq.qqsettingme.a.f274434i;
                            }
                        }
                    }
                    z19 = false;
                } catch (Exception e17) {
                    e = e17;
                    i3 = 0;
                    z18 = false;
                }
            } else {
                z19 = false;
            }
            if (!z19) {
                String newReportInfo2 = MobileReportManager.getNewReportInfo(appInfoByPath);
                QLog.i("QQSettingMeBaseProcessor", 1, "appinfo is :" + appInfoByPath + ", hasRedTouch:" + z16 + ", stringReport2H5:" + newReportInfo2);
                u(newReportInfo2);
            }
            z17 = true;
        } else {
            String newDefaultReportInfo = MobileReportManager.getNewDefaultReportInfo(VasWebConstants.REPORT_ORIGIN, "3");
            z17 = true;
            QLog.i("QQSettingMeBaseProcessor", 1, "appinfo is :" + appInfoByPath + ", hasRedTouch:" + z16 + ", stringReport2H5:" + newDefaultReportInfo);
            u(newDefaultReportInfo);
        }
        ThreadManagerV2.post(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingmev3.QQSettingMeDressUpProcessor.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f185040d;

            {
                this.f185040d = peekAppRuntime;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeDressUpProcessor.this, (Object) peekAppRuntime);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime appRuntime = this.f185040d;
                if (appRuntime != null) {
                    String currentAccountUin = appRuntime.getCurrentAccountUin();
                    if (!TextUtils.isEmpty(currentAccountUin)) {
                        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).setBusinessClickTimeMills(currentAccountUin, IndividuationPlugin.BusinessName);
                    }
                    this.f185040d.getApplication().getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + this.f185040d.getCurrentAccountUin(), 0).edit().putLong(IEmoticonMainPanel.SP_KEY_MARKET_OPEN_TIME, System.currentTimeMillis()).commit();
                }
            }
        }, 5, null, z17);
        c16 = o.a().c((QQAppInterface) peekAppRuntime, "key_svip_item_makup_");
        if (c16 == null) {
            str = c16.user_group + "";
        } else {
            str = "0";
        }
        MobileReportManager.getInstance().qqSetingMeReport(6, 102, str);
        ReportController.o(peekAppRuntime, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
        DrawerFrame.f185113z0 = com.tencent.mobileqq.qqsettingme.a.f274434i;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_decoration";
    }
}
