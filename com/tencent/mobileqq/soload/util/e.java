package com.tencent.mobileqq.soload.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f288691a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288691a = null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    public static String c(Throwable th5) {
        if (th5 != null) {
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append(th5.toString());
            if (th5.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th5.getStackTrace();
                for (int i3 = 0; i3 < stackTrace.length && i3 < 16; i3++) {
                    sb5.append("\n ");
                    sb5.append(stackTrace[i3].toString());
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public static boolean d() {
        if (f288691a == null) {
            f288691a = Boolean.TRUE;
        }
        return f288691a.booleanValue();
    }

    public static int e(String str) {
        try {
            if (!new File(str).exists()) {
                return 1;
            }
            return 2;
        } catch (Throwable th5) {
            QLog.e("getFileExistStatus", 1, th5, new Object[0]);
            return 3;
        }
    }

    public static boolean f(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 == null) {
            return false;
        }
        if (str == null && str2 != null) {
            return false;
        }
        return str.equals(str2);
    }
}
