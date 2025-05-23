package com.tencent.mobileqq.statistics;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r {
    static IPatchRedirector $redirector_;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Exception exc = new Exception(str);
        if (str2 == null) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.b(exc);
        } else {
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(exc, str2);
        }
    }
}
