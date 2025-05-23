package com.tencent.could.huiyansdk.fragments;

import com.tencent.could.aicamare.callback.CameraLoggerCallBack;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements CameraLoggerCallBack {
    static IPatchRedirector $redirector_;

    public c(AuthingFragment authingFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    @Override // com.tencent.could.aicamare.callback.CameraLoggerCallBack
    public void logger(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            k.a.f100197a.a(1, str, str2);
        }
    }
}
