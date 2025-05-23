package com.tencent.mobileqq.qqlive.data.user;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LimitUserInfo extends LiveUserInfo {
    static IPatchRedirector $redirector_;
    public long opTime;

    public LimitUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.opTime = 0L;
        }
    }
}
