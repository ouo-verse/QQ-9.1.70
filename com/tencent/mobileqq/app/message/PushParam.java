package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class PushParam {
    static IPatchRedirector $redirector_;
    public long gagLength;
    public String uin;

    public PushParam(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
        } else {
            this.uin = str;
            this.gagLength = j3;
        }
    }
}
