package com.tencent.mobileqq.mqq.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AccountRuntimeImpl implements IAccountRuntime {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "AccountRuntimeImpl";

    public AccountRuntimeImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.mqq.api.IAccountRuntime
    public String getAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && !TextUtils.isEmpty(peekAppRuntime.getAccount())) {
            return peekAppRuntime.getAccount();
        }
        QLog.d(TAG, 1, "getAccount is null");
        return "";
    }

    @Override // com.tencent.mobileqq.mqq.api.IAccountRuntime
    public Context getApplicationContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MobileQQ.sMobileQQ.getApplicationContext();
    }
}
