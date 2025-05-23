package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class InitLoginResult extends g {
    static IPatchRedirector $redirector_;

    public InitLoginResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public boolean a(AppRuntime appRuntime, Activity activity, String str) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, activity, str)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.e("InitLoginResult", 1, "onLoginSuccess error, appInterface is null");
            return false;
        }
        ThreadManagerV2.postImmediately(new Runnable(qQAppInterface, str) { // from class: com.tencent.mobileqq.loginregister.InitLoginResult.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f242794d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f242795e;

            {
                this.f242794d = qQAppInterface;
                this.f242795e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, InitLoginResult.this, qQAppInterface, str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BusinessUtils.Z(this.f242794d, this.f242795e);
                    ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).reportForQuestionnaire();
                }
            }
        }, null, false);
        return true;
    }
}
