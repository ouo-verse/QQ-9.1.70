package com.tencent.mobileqq.qipc.api;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public abstract class QIPCApiModule {
    static IPatchRedirector $redirector_;
    public String name;

    public QIPCApiModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.name = str;
        }
    }

    public abstract QIPCApiResult onCall(String str, Bundle bundle, int i3);
}
