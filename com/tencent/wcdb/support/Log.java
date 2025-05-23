package com.tencent.wcdb.support;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Log {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static LogCallback f384441a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface LogCallback {
        void println(int i3, String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f384441a = null;
        }
    }

    Log() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(String str, String str2) {
        e(6, str, str2);
    }

    public static void b(String str, String str2, Object... objArr) {
        e(6, str, String.format(str2, objArr));
    }

    public static void c(String str, String str2) {
        e(4, str, str2);
    }

    public static void d(String str, String str2, Object... objArr) {
        e(4, str, String.format(str2, objArr));
    }

    public static void e(int i3, String str, String str2) {
        LogCallback logCallback = f384441a;
        if (logCallback != null) {
            logCallback.println(i3, str, str2);
        } else {
            nativePrintLn(i3, str, str2);
        }
    }

    public static void f(LogCallback logCallback) {
        f384441a = logCallback;
        nativeSetLogger(-1, logCallback);
    }

    public static void g(String str, String str2) {
        e(5, str, str2);
    }

    public static void h(String str, String str2, Object... objArr) {
        e(5, str, String.format(str2, objArr));
    }

    private static native void nativePrintLn(int i3, String str, String str2);

    private static native void nativeSetLogger(int i3, LogCallback logCallback);
}
