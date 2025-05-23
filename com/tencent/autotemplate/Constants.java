package com.tencent.autotemplate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Constants {
    static IPatchRedirector $redirector_ = null;
    public static final long EFFECT_OFFSET_DEFAULT_VALUE = -1;

    public Constants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
