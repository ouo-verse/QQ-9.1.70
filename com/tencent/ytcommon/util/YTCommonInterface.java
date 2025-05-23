package com.tencent.ytcommon.util;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ytcommon.auth.Auth;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTCommonInterface {
    static IPatchRedirector $redirector_;

    public YTCommonInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getAuthResult() {
        return Auth.getAuthResult();
    }

    public static long getEndTime() {
        return Auth.getEndTime();
    }

    public static String getFailedReason(int i3) {
        return Auth.getFailedReason(i3);
    }

    public static String getLicensePath() {
        return Auth.getLicensePath();
    }

    public static int getVersion() {
        return Auth.getVersion();
    }

    public static int initAuth(Context context, String str, int i3) {
        if (context == null || str == null) {
            return -1;
        }
        return Auth.init(context, str, i3);
    }

    public static int initAuthForQQ(Context context) {
        if (context == null) {
            return -1;
        }
        return Auth.initAuthForQQ(context);
    }

    public static void setLicensePath(String str) {
        if (str == null) {
            return;
        }
        Auth.setLicensePath(str);
    }

    public static int initAuth(Context context, String str, String str2, String str3, boolean z16) {
        if (context == null || str == null || str2 == null || str3 == null) {
            return -1;
        }
        return Auth.init(context, str, str2, 0, str3);
    }
}
