package com.tencent.mobileqq.ark.base;

import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkAppLifeEvent;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkQualityReport;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DefaultApplicationCallback implements ark.ApplicationCallback {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.base.DefaultApplicationCallback$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f199177d;

        @Override // java.lang.Runnable
        public void run() {
            BaseApplication context = BaseApplication.getContext();
            if (context == null) {
                return;
            }
            QQToast.makeText(context, this.f199177d, 2000).show();
        }
    }

    protected static void d() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return;
        }
        c(context.getString(R.string.z6c));
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void AppCreate(ark.Application application) {
        ((IArkAppLifeEvent) QRoute.api(IArkAppLifeEvent.class)).doAction(0, application.GetSpecific("appName"), null);
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void AppDestroy(ark.Application application) {
        String GetSpecific = application.GetSpecific("appName");
        ((IArkAppLifeEvent) QRoute.api(IArkAppLifeEvent.class)).doAction(1, GetSpecific, null);
        ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportAccumulatedValidURL(GetSpecific);
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public boolean CheckUrlLegalityCallback(ark.Application application, String str) {
        String GetSpecific = application.GetSpecific("appName");
        int a16 = a(GetSpecific, application.GetSpecific(ark.APP_SPECIFIC_BIZSRC), str);
        if (a16 == 0) {
            QLog.i("ArkApp.ApplicationCallback", 1, "CheckURL, valid. appName=" + GetSpecific + JefsClass.INDEX_URL + k.f(str, new String[0]));
            ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportResourceURLAccess(GetSpecific, str, a16, 0, "");
            return true;
        }
        if (!b(GetSpecific)) {
            QLog.i("ArkApp.ApplicationCallback", 1, "CheckURL, check. appName=" + GetSpecific + JefsClass.INDEX_URL + k.f(str, new String[0]));
            ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportResourceURLAccess(GetSpecific, str, a16, 2, "");
            return true;
        }
        QLog.i("ArkApp.ApplicationCallback", 1, "CheckURL, blocked. appName=" + GetSpecific + JefsClass.INDEX_URL + k.f(str, new String[0]));
        ((IArkSecureReport) QRoute.api(IArkSecureReport.class)).reportResourceURLAccess(GetSpecific, str, a16, 1, "");
        d();
        return false;
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void OutputScriptError(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ApplicationCallback", 1, String.format("%s.script error:\n%s", str, str2));
        }
        ((IArkQualityReport) QRoute.api(IArkQualityReport.class)).reportScriptError(MobileQQ.sMobileQQ.waitAppRuntime(null), str, str2);
    }

    @Override // com.tencent.ark.ark.ApplicationCallback
    public void RegisterModules(ark.ModuleRegister moduleRegister, ark.Application application) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerModules(moduleRegister, application);
    }

    protected final int a(String str, String str2, String str3) {
        ArkAppUrlChecker urlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(str, str2);
        if (urlChecker == null) {
            return 0;
        }
        return urlChecker.checkUrlIsValidByAppResouceList(str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(String str) {
        if (!ArkAppConfigMgr.getInstance().isUrlCheckEnable(str) || ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isDebugMode()) {
            return false;
        }
        return true;
    }

    protected static void c(String str) {
    }
}
