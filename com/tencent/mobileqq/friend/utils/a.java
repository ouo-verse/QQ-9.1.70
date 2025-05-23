package com.tencent.mobileqq.friend.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(int i3, int i16, boolean z16) {
        if (i3 == 0 || i3 != 100 || z16) {
            return false;
        }
        return true;
    }

    public static void b(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement.toString());
        }
        QLog.i(str, 2, "current thread stack = " + sb5.toString());
    }
}
