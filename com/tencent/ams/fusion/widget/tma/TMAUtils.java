package com.tencent.ams.fusion.widget.tma;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TMAUtils {
    static IPatchRedirector $redirector_;

    public TMAUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkPermission(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getApplicationContext() == null) {
                return false;
            }
            if (context.getApplicationContext().checkCallingOrSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
