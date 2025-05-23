package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static String a(Thread thread) {
        try {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace != null) {
                return b(stackTrace, 0, 2);
            }
            return null;
        } catch (Throwable th5) {
            QLog.e("ThreadPoolMonitorThreadDumpUtil", 1, "getStackTraceStr error.", th5);
            return null;
        }
    }

    private static String b(StackTraceElement[] stackTraceElementArr, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        for (int i17 = i3; i17 < stackTraceElementArr.length && i17 < i3 + i16; i17++) {
            sb5.append(stackTraceElementArr[i17]);
            sb5.append("\n");
        }
        return sb5.toString();
    }
}
