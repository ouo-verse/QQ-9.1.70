package com.tencent.mobileqq.imcore.proxy.basic;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class CaughtExceptionReportProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        void e(@NonNull Throwable th5, @NonNull String str);
    }

    public CaughtExceptionReportProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void e(@NonNull Throwable th5, @NonNull String str) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            proxy2.e(th5, str);
        }
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }
}
