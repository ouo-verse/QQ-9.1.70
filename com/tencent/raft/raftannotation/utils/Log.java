package com.tencent.raft.raftannotation.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Log {
    static IPatchRedirector $redirector_;
    private static LogPrinter logPrinter;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class LogPrinter {
        static IPatchRedirector $redirector_;

        public LogPrinter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            System.out.println("[" + str + "]" + str2);
        }

        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
                return;
            }
            System.out.println("[" + str + "]" + str2);
        }

        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
                return;
            }
            System.out.println("[" + str + "]" + str2);
        }

        public void v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
                return;
            }
            System.out.println("[" + str + "]" + str2);
        }

        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
                return;
            }
            System.out.println("[" + str + "]" + str2);
        }

        public void e(String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) th5);
                return;
            }
            System.out.println("[" + str + "]" + th5.toString());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            logPrinter = new LogPrinter();
        }
    }

    public Log() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        logPrinter.d(str, str2);
    }

    public static void e(String str, String str2) {
        logPrinter.e(str, str2);
    }

    public static void i(String str, String str2) {
        logPrinter.i(str, str2);
    }

    static void setLogPrinter(LogPrinter logPrinter2) {
        if (logPrinter2 != null) {
            logPrinter = logPrinter2;
        }
    }

    public static void v(String str, String str2) {
        logPrinter.v(str, str2);
    }

    public static void w(String str, String str2) {
        logPrinter.w(str, str2);
    }

    public static void e(String str, Throwable th5) {
        logPrinter.e(str, th5);
    }
}
