package com.tencent.mobileqq.perf.log;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("PERF_LOG", 2, str + "." + str2);
        }
    }

    public static void b(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.d("PERF_LOG", 4, str + "." + str2);
        }
    }

    public static void c(String str, String str2) {
        QLog.i("PERF_LOG", 1, str + "." + str2);
    }

    public static void d(String str, String str2) {
        QLog.w("PERF_LOG", 1, str + "." + str2);
    }
}
