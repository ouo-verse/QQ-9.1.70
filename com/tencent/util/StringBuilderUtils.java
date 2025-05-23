package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StringBuilderUtils {
    static IPatchRedirector $redirector_;
    private static ThreadLocal<StringBuilder> builder;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            builder = new ThreadLocal<>();
        }
    }

    public StringBuilderUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static StringBuilder obtain() {
        StringBuilder sb5 = builder.get();
        if (sb5 == null) {
            StringBuilder sb6 = new StringBuilder();
            builder.set(sb6);
            return sb6;
        }
        sb5.setLength(0);
        return sb5;
    }
}
