package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class HttpInterfaceForTVK {
    static IPatchRedirector $redirector_;

    public HttpInterfaceForTVK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int downLoadFileSync(String str, String str2) {
        return new HttpInterfaceForTVKImp().downLoadSync(str, str2);
    }
}
