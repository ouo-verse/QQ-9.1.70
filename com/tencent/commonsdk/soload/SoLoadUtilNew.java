package com.tencent.commonsdk.soload;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SoLoadUtilNew {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SoLoadUtilNew";
    static SoLoadReport sReport;

    public SoLoadUtilNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean getLoadResult(int i3) {
        if ((i3 & 2) == 2 || (i3 & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    public static boolean loadSoByName(Context context, String str) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int loadSo = SoLoadCore.loadSo(context, str);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        SoLoadReport soLoadReport = sReport;
        if (soLoadReport != null) {
            soLoadReport.report(loadSo, str, uptimeMillis2);
        }
        QLog.d(TAG, 1, "loadSoByName[" + str + "], loadRes[" + getLoadResult(loadSo) + "], resultCode[" + loadSo + "]");
        return getLoadResult(loadSo);
    }

    public static void setReport(SoLoadReport soLoadReport) {
        sReport = soLoadReport;
    }
}
