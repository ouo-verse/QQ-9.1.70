package com.tencent.soter.core.model;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SReporter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.SReporter";
    private static ISoterReporter reporter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16597);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            reporter = null;
        }
    }

    public SReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportError(int i3, String str) {
        if (reporter != null) {
            SLogger.i(TAG, "reporter errCode:%s errMsg:%s", Integer.valueOf(i3), str);
            reporter.reportError(i3, str);
        }
    }

    public static void setReporterImp(ISoterReporter iSoterReporter) {
        if (iSoterReporter != null) {
            reporter = iSoterReporter;
            return;
        }
        throw new RuntimeException("logInstance can not be null");
    }

    public static void reportError(int i3, String str, Exception exc) {
        if (reporter != null) {
            SLogger.i(TAG, "reporter errCode:%s errMsg:%s exception:%s", Integer.valueOf(i3), str, exc.getMessage());
            reporter.reportError(i3, str + " Exception: " + Log.getStackTraceString(exc));
        }
    }
}
