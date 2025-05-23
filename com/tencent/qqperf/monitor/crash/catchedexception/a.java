package com.tencent.qqperf.monitor.crash.catchedexception;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC9710a f363192a;

    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.monitor.crash.catchedexception.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC9710a {
        boolean a(Throwable th5);

        boolean b();

        boolean c(Throwable th5);
    }

    private static boolean a(Throwable th5) {
        InterfaceC9710a interfaceC9710a = f363192a;
        if (interfaceC9710a == null) {
            QLog.e("CaughtExceptionReport", 1, "checkErrorNeedDumpAllThread whiteListChecker is null");
            return false;
        }
        return interfaceC9710a.a(th5);
    }

    public static void b(@NonNull Throwable th5) {
        c(th5, "This is CaughtException");
    }

    public static void c(@NonNull Throwable th5, @NonNull String str) {
        d(th5, str, Thread.currentThread());
    }

    public static void d(@NonNull Throwable th5, @NonNull String str, Thread thread) {
        Throwable th6;
        if (th5 != null && str != null) {
            if (!e(th5)) {
                Log.e("CaughtExceptionReport", "this report is not permitted. ", th5);
                return;
            }
            if (!f()) {
                Log.e("CaughtExceptionReport", "this report won't report due to sample. ", th5);
                return;
            }
            if (!(th5 instanceof CaughtException)) {
                th6 = new CaughtException("Caught: " + th5.getMessage(), th5);
            } else {
                th6 = th5;
            }
            if (QLog.isColorLevel()) {
                QLog.e("CaughtExceptionReport-eup", 2, "rqd\u5c06\u4e0a\u62a5\u4fe1\u606f\u5230rdm\u7f51\u7ad9\uff0c\u4e0a\u62a5\u4e0d\u4f1a\u5bfc\u81f4\u5ba2\u6237\u7aef\u95ea\u9000\uff0c\u4ec5\u7528\u4f5c\u6570\u636e\u7edf\u8ba1");
            }
            CrashReport.handleCatchException(thread, th6, "ExtraMessage: " + str, null, a(th5));
        }
    }

    private static boolean e(Throwable th5) {
        InterfaceC9710a interfaceC9710a = f363192a;
        if (interfaceC9710a == null) {
            QLog.e("CaughtExceptionReport", 1, "exceptionPermitted whiteListChecker is null");
            return false;
        }
        return interfaceC9710a.c(th5);
    }

    private static boolean f() {
        InterfaceC9710a interfaceC9710a = f363192a;
        if (interfaceC9710a == null) {
            QLog.e("CaughtExceptionReport", 1, "exceptionPermitted whiteListChecker is null");
            return false;
        }
        return interfaceC9710a.b();
    }

    public static void g(InterfaceC9710a interfaceC9710a) {
        f363192a = interfaceC9710a;
    }
}
