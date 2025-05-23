package com.tencent.mobileqq.logintempapi.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.login.bq;
import com.tencent.mobileqq.logintempapi.IPwdSetUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes15.dex */
public class PwdSetUtilApiImpl implements IPwdSetUtilApi {
    static IPatchRedirector $redirector_;

    public PwdSetUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.logintempapi.IPwdSetUtilApi
    public boolean checkHasNotSetPwd(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return bq.a((AppInterface) peekAppRuntime, activity);
        }
        return false;
    }
}
