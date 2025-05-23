package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SignResult {
    static IPatchRedirector $redirector_;
    public long code;
    public String signMsg;

    public SignResult(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str);
        } else {
            this.code = j3;
            this.signMsg = str;
        }
    }
}
