package com.tencent.mobileqq.mvvm.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.mvvm.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LifeCycleFragmentInjectApiImpl implements ILifeCycleFragmentInjectApi {
    static IPatchRedirector $redirector_;

    public LifeCycleFragmentInjectApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi
    public d checkAndAddLifeCycleFragment(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        }
        if (activity instanceof QBaseActivity) {
            return LifeCycleFragment.ph((QBaseActivity) activity);
        }
        return null;
    }
}
