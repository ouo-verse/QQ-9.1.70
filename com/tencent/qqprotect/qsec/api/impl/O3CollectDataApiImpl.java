package com.tencent.qqprotect.qsec.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.a;
import com.tencent.qqprotect.qsec.api.IO3CollectDataApi;
import com.tencent.qqprotect.qsec.b;
import com.tencent.qqprotect.qsec.c;
import com.tencent.qqprotect.qsec.d;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class O3CollectDataApiImpl implements IO3CollectDataApi {
    static IPatchRedirector $redirector_;

    public O3CollectDataApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3CollectDataApi
    public String collectInfo() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            if (((IQSecChannel) QRoute.api(IQSecChannel.class)).reportEnable() && (appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null && appInterface.getApplicationContext() != null) {
                return a.e(appInterface.getApplicationContext(), null, null, null);
            }
            return "";
        } catch (Throwable th5) {
            QLog.e("O3CollectDataApiImpl", 1, "exception:" + th5);
        }
        return "";
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3CollectDataApi
    public void sampling(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2);
            return;
        }
        try {
            if (((IQSecChannel) QRoute.api(IQSecChannel.class)).reportEnable()) {
                a.H(context, str, str2);
            }
        } catch (Throwable th5) {
            QLog.e("O3CollectDataApiImpl", 1, "exception:" + th5);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3CollectDataApi
    public void startCollectInfo() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            if (((IQSecChannel) QRoute.api(IQSecChannel.class)).reportEnable() && (appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null && appInterface.getApplicationContext() != null) {
                d.a().c(appInterface.getApplicationContext());
                b.a().c(appInterface.getApplicationContext());
                c.a().c(appInterface.getApplicationContext());
            }
        } catch (Throwable th5) {
            QLog.e("O3CollectDataApiImpl", 1, "exception:" + th5);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3CollectDataApi
    public void stopCollectInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            if (((IQSecChannel) QRoute.api(IQSecChannel.class)).reportEnable()) {
                d.a().d();
                b.a().d();
                c.a().d();
            }
        } catch (Throwable th5) {
            QLog.e("O3CollectDataApiImpl", 1, "exception:" + th5);
        }
    }
}
