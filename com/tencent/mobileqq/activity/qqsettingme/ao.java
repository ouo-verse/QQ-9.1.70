package com.tencent.mobileqq.activity.qqsettingme;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ao extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.m> f184823h;

    /* renamed from: i, reason: collision with root package name */
    private UpgradeDetailWrapper f184824i;

    /* renamed from: j, reason: collision with root package name */
    private final com.tencent.mobileqq.app.h f184825j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f184826k;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.app.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ao.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.h
        public void i(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                super.i(z16);
                ao.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.h
        public void p(boolean z16, UpgradeDetailWrapper upgradeDetailWrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ao.this.f184824i = upgradeDetailWrapper;
                ao.this.e();
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), upgradeDetailWrapper);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.m> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184828d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184828d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ao.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.m mVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mVar);
                return;
            }
            this.f184828d.O(mVar);
            QQSettingMeViewModel k3 = this.f184828d.k();
            if (k3 != null) {
                k3.U.postValue(mVar);
            }
        }
    }

    public ao() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184823h = new MutableLiveData<>();
            this.f184825j = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(AppRuntime appRuntime, BusinessInfoCheckUpdate.AppInfo appInfo, com.tencent.mobileqq.activity.qqsettingme.bean.m mVar) {
        am.a(appRuntime, appInfo, this.f259744e);
        this.f184823h.setValue(mVar);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        AppRuntime appRuntime2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        WeakReference<AppRuntime> weakReference = this.f259740a;
        if (weakReference == null) {
            appRuntime2 = null;
        } else {
            appRuntime2 = weakReference.get();
        }
        if (this.f184826k) {
            if (appRuntime2 != null) {
                ((QQAppInterface) appRuntime2).removeObserver(this.f184825j);
            } else {
                QLog.e("QQSettingMeBaseProcessor", 1, "fillData appRef.get is null");
            }
            ((QQAppInterface) appRuntime).addObserver(this.f184825j, false);
        }
        this.f259740a = new WeakReference<>(appRuntime);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f184826k = false;
            this.f184823h.observe(this.f259743d, new b(aVar));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SETTING));
        com.tencent.mobileqq.activity.qqsettingme.bean.m mVar = new com.tencent.mobileqq.activity.qqsettingme.bean.m();
        mVar.f184924a = appInfoByPath;
        mVar.f184925b = com.tencent.mobileqq.upgrade.n.i();
        mVar.f184926c = PrivacyPolicyHelper.needShowPrivacyPolicyOrUserAgreement(1);
        mVar.f184927d = ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).isShowWechatGuildSettingItemRedDot();
        this.f184823h.postValue(mVar);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SETTING));
        if (this.f259745f) {
            final com.tencent.mobileqq.activity.qqsettingme.bean.m mVar = new com.tencent.mobileqq.activity.qqsettingme.bean.m();
            mVar.f184924a = appInfoByPath;
            mVar.f184925b = com.tencent.mobileqq.upgrade.n.i();
            mVar.f184926c = PrivacyPolicyHelper.needShowPrivacyPolicyOrUserAgreement(1);
            mVar.f184927d = ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).isShowWechatGuildSettingItemRedDot();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.an
                @Override // java.lang.Runnable
                public final void run() {
                    ao.this.o(peekAppRuntime, appInfoByPath, mVar);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        UpgradeInfo upgradeInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        if (AppSetting.t(qBaseActivity)) {
            com.tencent.mobileqq.pad.b h16 = new com.tencent.mobileqq.pad.b().h(LaunchMode.singleTop);
            Class<? extends Fragment> settingFragmentClass = ((ISettingApi) QRoute.api(ISettingApi.class)).getSettingFragmentClass();
            Bundle bundle = new Bundle();
            bundle.putBoolean("main_setting_split_view_mode", true);
            com.tencent.mobileqq.pad.i.e(qBaseActivity, bundle, settingFragmentClass, h16.a());
        } else {
            ((ISettingApi) QRoute.api(ISettingApi.class)).startMainSettingPage(qBaseActivity, null);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (com.tencent.mobileqq.upgrade.n.i()) {
            ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", com.tencent.mobileqq.upgrade.k.g(), "");
        }
        UpgradeDetailWrapper upgradeDetailWrapper = this.f184824i;
        if (upgradeDetailWrapper != null && (upgradeInfo = upgradeDetailWrapper.f306170d) != null && upgradeInfo.iUpgradeType > 0) {
            com.tencent.mobileqq.upgrade.n.h(upgradeInfo.iNewTimeStamp);
        }
        ReportController.o(peekAppRuntime, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SETTING));
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0) {
            iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_SETTING, 31);
        }
        if (!((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3()) {
            VideoReport.reportEvent("clck", view, null);
        }
        DrawerFrame.f185113z0 = com.tencent.mobileqq.qqsettingme.a.f274434i;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.f184826k) {
            ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).removeObserver(this.f184825j);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!this.f184826k && peekAppRuntime != null) {
            ((QQAppInterface) peekAppRuntime).addObserver(this.f184825j, false);
            this.f184826k = true;
        }
        this.f184824i = com.tencent.mobileqq.upgrade.k.i().j();
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_setting";
    }
}
