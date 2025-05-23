package com.tencent.mobileqq.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.IGuideChangeSecretPhoneApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.am;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes15.dex */
public class GuideChangeSecretPhoneApiImpl implements IGuideChangeSecretPhoneApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GuideChangeSecretPhoneApiImpl";

    public GuideChangeSecretPhoneApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.IGuideChangeSecretPhoneApi
    public void sendReq(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        QLog.d(TAG, 1, "prepare sendReq");
        if (appInterface == null) {
            QLog.e(TAG, 1, "appInterface is null!");
        } else if (am.u(appInterface)) {
            am.p(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.IGuideChangeSecretPhoneApi
    public void showGuideDialog(AppRuntime appRuntime, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) context);
            return;
        }
        QLog.d(TAG, 1, "prepare showGuideDialog");
        if (am.v()) {
            am.w(appRuntime, context);
        }
    }
}
