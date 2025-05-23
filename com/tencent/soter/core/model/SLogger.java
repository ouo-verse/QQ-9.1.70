package com.tencent.soter.core.model;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SLogger {
    static IPatchRedirector $redirector_;
    private static ISoterLogger mLoggerImp;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class DefaultSoterLogger implements ISoterLogger {
        static IPatchRedirector $redirector_;

        DefaultSoterLogger() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void d(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, objArr);
                return;
            }
            try {
                Log.d(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void e(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, objArr);
                return;
            }
            try {
                Log.e(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void i(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, str2, objArr);
                return;
            }
            try {
                Log.i(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void printErrStackTrace(String str, Throwable th5, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, th5, str2);
            } else {
                th5.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void v(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, objArr);
                return;
            }
            try {
                Log.v(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.soter.core.model.ISoterLogger
        public void w(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, str2, objArr);
                return;
            }
            try {
                Log.w(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* synthetic */ DefaultSoterLogger(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16594);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mLoggerImp = new DefaultSoterLogger(null);
        }
    }

    public SLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        mLoggerImp.d(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        mLoggerImp.e(str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        mLoggerImp.i(str, str2, objArr);
    }

    public static void printErrStackTrace(String str, Throwable th5, String str2) {
        mLoggerImp.printErrStackTrace(str, th5, str2);
    }

    public static void setLogImp(ISoterLogger iSoterLogger) {
        if (iSoterLogger != null) {
            mLoggerImp = iSoterLogger;
            return;
        }
        throw new RuntimeException("logInstance can not be null");
    }

    public static void v(String str, String str2, Object... objArr) {
        mLoggerImp.v(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        mLoggerImp.w(str, str2, objArr);
    }
}
