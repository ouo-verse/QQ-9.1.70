package com.tencent.mobileqq.loginregister;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.at;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ci;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class af extends f {
    static IPatchRedirector $redirector_;

    public af() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(AppRuntime appRuntime, String str) {
        try {
            String uid = ((IUidService) QRoute.api(IUidService.class)).getUid(str);
            if (!TextUtils.isEmpty(uid)) {
                ci.k().ClearMoblieQQAccountData(uid);
            }
        } catch (Exception e16) {
            QLog.e("MessageLoginAction", 1, "clear nt data error:", e16);
        }
        new com.tencent.mobileqq.managers.c().a(str);
        d(str);
    }

    private void c(AppRuntime appRuntime, String str) {
        appRuntime.stopPCActivePolling("deleteAccount");
        ((ILoginServletService) appRuntime.getRuntimeService(ILoginServletService.class, "all")).deleteAccount(str, str, null);
        at.a(str);
    }

    private void d(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MessageLoginAction", 2, "----clear_sp----deleteDataFromSP: uin:" + str);
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences(str, 0).edit();
        edit.clear();
        edit.commit();
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public void h(QBaseActivity qBaseActivity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, str, Boolean.valueOf(z16));
            return;
        }
        if (qBaseActivity != null && qBaseActivity.getAppRuntime() != null) {
            AppRuntime appRuntime = qBaseActivity.getAppRuntime();
            c(appRuntime, str);
            if (z16) {
                a(appRuntime, str);
                return;
            }
            return;
        }
        QLog.e("MessageLoginAction", 1, "onDeleteAccount, context or app runtime illegal");
    }
}
