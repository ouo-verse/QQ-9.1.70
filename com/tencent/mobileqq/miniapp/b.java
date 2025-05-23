package com.tencent.mobileqq.miniapp;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int b(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("ak:")) {
            return 1;
        }
        return 0;
    }

    public abstract void a(String str, String str2, Object obj);
}
