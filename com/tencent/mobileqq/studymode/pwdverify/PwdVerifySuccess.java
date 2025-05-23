package com.tencent.mobileqq.studymode.pwdverify;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes18.dex */
public class PwdVerifySuccess extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    public PwdVerifySuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
