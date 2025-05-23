package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class q extends com.tencent.mobileqq.earlydownload.inject.a {
    static IPatchRedirector $redirector_;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.inject.a
    public com.tencent.mobileqq.earlydownload.handler.b a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.earlydownload.handler.b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
        return new com.tencent.mobileqq.earlydownload.handler.k((QQAppInterface) appRuntime);
    }

    @Override // com.tencent.mobileqq.earlydownload.inject.a
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "qq.android.qav.muteaudio";
    }
}
