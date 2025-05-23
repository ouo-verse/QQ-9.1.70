package com.tencent.dbfix;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DBFixLog {
    static IPatchRedirector $redirector_ = null;
    public static final int USR = 1;

    public DBFixLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, Object... objArr) {
        StringBuilder sb5 = new StringBuilder(objArr.length * 30);
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        Log.d(str, sb5.toString());
    }

    public static void e(String str, Object... objArr) {
        StringBuilder sb5 = new StringBuilder(objArr.length * 30);
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        Log.e(str, sb5.toString());
    }
}
