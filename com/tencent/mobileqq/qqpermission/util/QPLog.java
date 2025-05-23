package com.tencent.mobileqq.qqpermission.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes17.dex */
public class QPLog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG_PREFIX = "QQPermission.";

    public QPLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void c(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG_PREFIX + str, 2, str2);
        }
    }

    public static void d(String str, Object... objArr) {
        QLog.d(TAG_PREFIX + str, 1, objArr);
    }

    public static void e(String str, Object... objArr) {
        QLog.e(TAG_PREFIX + str, 1, objArr);
    }

    public static void i(String str, String str2) {
        QLog.i(TAG_PREFIX + str, 1, str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        QLog.d(TAG_PREFIX + str, 1, str2, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        QLog.e(TAG_PREFIX + str, 1, str2, th5);
    }

    public static void i(String str, String str2, Throwable th5) {
        QLog.i(TAG_PREFIX + str, 1, str2, th5);
    }
}
