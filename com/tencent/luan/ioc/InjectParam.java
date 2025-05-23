package com.tencent.luan.ioc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class InjectParam {
    static IPatchRedirector $redirector_;
    public final String name;
    public final Class<?> type;

    public InjectParam(Class<?> cls, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, (Object) str);
        } else {
            this.type = cls;
            this.name = str;
        }
    }
}
