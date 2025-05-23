package com.tencent.rfix.lib.atta;

import android.os.Build;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.loader.log.RFixLog;

/* compiled from: P */
@Keep
/* loaded from: classes25.dex */
public class RFixATTASwitch {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RFix.RFixATTASwitch";
    private static volatile boolean sDisableBelowM;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sDisableBelowM = false;
        }
    }

    public RFixATTASwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void disableBelowM() {
        RFixLog.d(TAG, "disableBelowM");
        sDisableBelowM = true;
    }

    public static boolean isATTAReportEnable() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return !sDisableBelowM;
    }
}
