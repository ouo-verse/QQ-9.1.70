package com.tencent.mobileqq.tianshu.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes18.dex */
public class RedPointHolder {
    static IPatchRedirector $redirector_;
    public int appid;
    public long uiResId;

    public RedPointHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
