package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {
    private static void a(Throwable th5) {
        try {
            for (Field field : Class.forName("java.lang.Throwable").getDeclaredFields()) {
                if (field.getName().equals("detailMessage")) {
                    field.setAccessible(true);
                    field.set(th5, "huayangCatchedException:" + th5.getMessage());
                    Throwable cause = th5.getCause();
                    for (int i3 = 0; cause != null && i3 <= 10; i3++) {
                        field.set(cause, "huayangCatchedException:" + cause.getMessage());
                        cause = cause.getCause();
                    }
                    return;
                }
            }
        } catch (Throwable th6) {
            if (QLog.isColorLevel()) {
                QLog.e("HuayangCrashReport", 2, "addStackTag failed", th6);
            }
        }
    }

    public static void b(Throwable th5) {
        a(th5);
        try {
            StackTraceElement[] stackTrace = th5.getStackTrace();
            Throwable th6 = th5;
            while (true) {
                if (th6 == null) {
                    break;
                }
                if (d(th6)) {
                    RuntimeException runtimeException = new RuntimeException("huayangCatchedException:" + th5.getMessage());
                    runtimeException.setStackTrace(stackTrace);
                    th5 = runtimeException;
                    break;
                }
                th6 = th6.getCause();
            }
            CrashReport.handleCatchException(Thread.currentThread(), th5, ThrowablesUtils.getStackTraceAsString(th5), null);
            CrashReport.doUploadExceptionDatas();
        } catch (Throwable unused) {
        }
    }

    public static void c(Throwable th5) {
        Monitor.d("2490056");
        com.tencent.qqperf.monitor.crash.catchedexception.a.b(th5);
    }

    private static boolean d(Throwable th5) {
        return th5 != null && (th5.getClass().getCanonicalName().contains("android.system.") || th5.getClass().getCanonicalName().contains("libcore.io."));
    }
}
