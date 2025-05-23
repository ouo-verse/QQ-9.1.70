package com.tencent.opentelemetry.api.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TemporaryBuffers {
    static IPatchRedirector $redirector_;
    private static final ThreadLocal<char[]> CHAR_ARRAY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16088);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            CHAR_ARRAY = new ThreadLocal<>();
        }
    }

    TemporaryBuffers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static char[] chars(int i3) {
        ThreadLocal<char[]> threadLocal = CHAR_ARRAY;
        char[] cArr = threadLocal.get();
        if (cArr == null) {
            char[] cArr2 = new char[i3];
            threadLocal.set(cArr2);
            return cArr2;
        }
        if (cArr.length < i3) {
            char[] cArr3 = new char[i3];
            threadLocal.set(cArr3);
            return cArr3;
        }
        return cArr;
    }

    static void clearChars() {
        CHAR_ARRAY.set(null);
    }
}
