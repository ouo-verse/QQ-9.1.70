package com.tencent.luan.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LuanLog {
    static IPatchRedirector $redirector_;
    private static final AtomicBoolean INIT;
    private static volatile LuanLogInterface sLogInf;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface LuanLogInterface {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th5);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th5);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INIT = new AtomicBoolean(false);
        }
    }

    public LuanLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        if (sLogInf != null) {
            sLogInf.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (sLogInf != null) {
            sLogInf.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (sLogInf != null) {
            sLogInf.i(str, str2);
        }
    }

    public static void init(LuanLogInterface luanLogInterface) {
        if (luanLogInterface != null && INIT.compareAndSet(false, true)) {
            sLogInf = luanLogInterface;
        }
    }

    public static void v(String str, String str2) {
        if (sLogInf != null) {
            sLogInf.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (sLogInf != null) {
            sLogInf.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (sLogInf != null) {
            sLogInf.e(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (sLogInf != null) {
            sLogInf.w(str, str2, th5);
        }
    }
}
