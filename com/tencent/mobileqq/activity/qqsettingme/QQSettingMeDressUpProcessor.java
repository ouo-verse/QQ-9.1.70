package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
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
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
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
    public final MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.b> f184665i;

    /* loaded from: classes10.dex */
    class a implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184668d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184668d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeDressUpProcessor.this, (Object) aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(com.tencent.mobileqq.qqsettingme.a aVar, com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
            aVar.k().K.setValue(bVar);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onChanged(final com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQSettingMeDressUpProcessor.x(bVar.f184876b);
                this.f184668d.z(bVar);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final com.tencent.mobileqq.qqsettingme.a aVar = this.f184668d;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeDressUpProcessor.a.b(com.tencent.mobileqq.qqsettingme.a.this, bVar);
                    }
                });
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        }
    }

    public QQSettingMeDressUpProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184665i = new MutableLiveData<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        String str;
        MenumItem c16 = com.tencent.mobileqq.vip.o.a().c((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), "key_svip_item_makup_");
        if (c16 != null) {
            str = c16.user_group + "";
        } else {
            str = "0";
        }
        MobileReportManager.getInstance().qqSetingMeReport(6, 101, str);
        y();
    }

    private void v(String str) {
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity != null && !VasUtils.b()) {
            VasWebviewUtil.openIndividuationIndex(qBaseActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(CharSequence charSequence) {
        QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c("d_decoration");
        if (c16 != null && !TextUtils.isEmpty(charSequence)) {
            c16.x(charSequence);
        }
    }

    private void y() {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeDressUpProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MenumItem menumItem = com.tencent.mobileqq.vip.o.a().d((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).get(3);
                if (menumItem == null) {
                    return;
                }
                com.tencent.mobileqq.activity.qqsettingme.bean.b bVar = new com.tencent.mobileqq.activity.qqsettingme.bean.b();
                bVar.f184875a = com.tencent.mobileqq.vip.o.a().f(3);
                if (!TextUtils.isEmpty(menumItem.title)) {
                    bVar.f184876b = com.tencent.av.chatroom.c.c(menumItem.title, 16);
                }
                if (!TextUtils.isEmpty(menumItem.icon)) {
                    bVar.f184877c = VasApngUtil.getApngURLDrawable(menumItem.icon, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null);
                }
                QQSettingMeDressUpProcessor.this.f184665i.postValue(bVar);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread() && com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-04-15", "vas_bug_122960667").isEnable(true)) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.d(aVar);
            this.f184665i.observe(this.f259743d, new a(aVar));
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appInfo, Boolean.valueOf(z16));
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
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f184667d;

                {
                    this.f184667d = peekAppRuntime;
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
                    } else if (this.f184667d != null && QQSettingMeDressUpProcessor.this.f185016h.getValue() != null && QQSettingMeDressUpProcessor.this.f185016h.getValue().iNewFlag.get() == 1 && (iWebProcessManagerService = (IWebProcessManagerService) this.f184667d.getRuntimeService(IWebProcessManagerService.class, "")) != null) {
                        iWebProcessManagerService.startWebProcess(23, null);
                    }
                }
            });
        }
        super.j(appInfo, z16);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            y();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onResume();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.w
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeDressUpProcessor.this.u();
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            y();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
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
                                v(newReportInfo);
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
                                ThreadManagerV2.post(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor.2
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ AppRuntime f184666d;

                                    {
                                        this.f184666d = peekAppRuntime;
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
                                        AppRuntime appRuntime = this.f184666d;
                                        if (appRuntime != null) {
                                            String currentAccountUin = appRuntime.getCurrentAccountUin();
                                            if (!TextUtils.isEmpty(currentAccountUin)) {
                                                ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).setBusinessClickTimeMills(currentAccountUin, IndividuationPlugin.BusinessName);
                                            }
                                            this.f184666d.getApplication().getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + this.f184666d.getCurrentAccountUin(), 0).edit().putLong(IEmoticonMainPanel.SP_KEY_MARKET_OPEN_TIME, System.currentTimeMillis()).commit();
                                        }
                                    }
                                }, 5, null, z17);
                                c16 = com.tencent.mobileqq.vip.o.a().c((QQAppInterface) peekAppRuntime, "key_svip_item_makup_");
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
                v(newReportInfo2);
            }
            z17 = true;
        } else {
            String newDefaultReportInfo = MobileReportManager.getNewDefaultReportInfo(VasWebConstants.REPORT_ORIGIN, "3");
            z17 = true;
            QLog.i("QQSettingMeBaseProcessor", 1, "appinfo is :" + appInfoByPath + ", hasRedTouch:" + z16 + ", stringReport2H5:" + newDefaultReportInfo);
            v(newDefaultReportInfo);
        }
        ThreadManagerV2.post(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f184666d;

            {
                this.f184666d = peekAppRuntime;
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
                AppRuntime appRuntime = this.f184666d;
                if (appRuntime != null) {
                    String currentAccountUin = appRuntime.getCurrentAccountUin();
                    if (!TextUtils.isEmpty(currentAccountUin)) {
                        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).setBusinessClickTimeMills(currentAccountUin, IndividuationPlugin.BusinessName);
                    }
                    this.f184666d.getApplication().getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + this.f184666d.getCurrentAccountUin(), 0).edit().putLong(IEmoticonMainPanel.SP_KEY_MARKET_OPEN_TIME, System.currentTimeMillis()).commit();
                }
            }
        }, 5, null, z17);
        c16 = com.tencent.mobileqq.vip.o.a().c((QQAppInterface) peekAppRuntime, "key_svip_item_makup_");
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
