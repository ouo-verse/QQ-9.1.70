package com.tencent.mobileqq.uftransfer.depend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(String str, int i3, String str2) {
        QLog.d(str, i3, str2);
    }

    public static void b(String str, int i3, String str2) {
        QLog.e(str, i3, str2);
    }

    public static void c(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
    }

    public static boolean d() {
        return QLog.isDevelopLevel();
    }

    public static void e(String str, int i3, String str2) {
        QLog.w(str, i3, str2);
    }
}
