package com.tencent.ams.dsdk.utils;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class DKSystemUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKSystemUtils";

    public DKSystemUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean vibrate(Context context, long j3) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.VIBRATE") != 0) {
                DLog.e(TAG, "[vibrate] error, without permission");
                return false;
            }
            ((Vibrator) context.getSystemService("vibrator")).vibrate(j3);
            return true;
        } catch (Throwable th5) {
            DLog.e(TAG, "[vibrate]", th5);
            return false;
        }
    }
}
