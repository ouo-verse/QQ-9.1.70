package com.tencent.mobileqq.loginregister.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.accountbinding.fragment.AccountBindingFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.IAccountBindingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AccountBindingApiImpl implements IAccountBindingApi {
    static IPatchRedirector $redirector_;

    public AccountBindingApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.IAccountBindingApi
    public void bindWechatIfNeed(QBaseActivity qBaseActivity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qBaseActivity, Boolean.valueOf(z16));
        } else {
            com.tencent.mobileqq.accountbinding.d.e(qBaseActivity, z16);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.IAccountBindingApi
    public void startAccountBindFragment(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
        } else {
            AccountBindingFragment.yh(context, false, intent);
        }
    }
}
