package com.tencent.mobileqq.transfile;

import android.app.Application;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class InjectHelper implements IInject {
    static IPatchRedirector $redirector_;

    public InjectHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.highway.IInject
    public Application getApplication() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Application) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return BaseApplication.getContext();
    }

    @Override // com.tencent.mobileqq.highway.IInject
    public AppRuntime getRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }
}
