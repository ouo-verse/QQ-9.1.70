package com.tencent.mobileqq.webview.swift.cookie;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(StringBuilder sb5, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            h(sb5);
            sb5.append(str2);
            sb5.append(str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CookieUtils", 2, str2 + "is empty");
        }
        if (!TextUtils.isEmpty(str3)) {
            h(sb5);
            sb5.append(str2);
            sb5.append(str3);
        }
    }

    public static String b(String str, String str2, String str3, boolean z16) {
        if (!z16) {
            return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", str, str2, str3);
        }
        return String.format("%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure; HttpOnly;", str, str2, str3);
    }

    public static String c(String str, String str2, String str3) {
        return String.format("%s=%s; PATH=/; DOMAIN=.%s;  Max-Age=21600; Secure;", str, str2, str3);
    }

    public static String d(String str, boolean z16) {
        if (z16) {
            return String.format("http://%s/", str);
        }
        return String.format("https://%s/", str);
    }

    public static String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() < 10) {
                StringBuilder sb5 = new StringBuilder("o");
                for (int length = str.length(); length < 10; length++) {
                    sb5.append("0");
                }
                sb5.append(str);
                return sb5.toString();
            }
            return "o" + str;
        }
        return str;
    }

    public static String f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                if (("http".equals(scheme) || "https".equals(scheme)) && parse.isHierarchical()) {
                    return d(parse.getHost(), "http".equals(scheme));
                }
                return null;
            } catch (Exception e16) {
                QLog.e("CookieUtils", 1, "getCookieHost[" + str + "] error:" + e16.toString());
                return null;
            }
        }
        return null;
    }

    public static boolean g(AppRuntime appRuntime) {
        boolean z16 = false;
        if (appRuntime != null && appRuntime.isLogin()) {
            z16 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("ptlogin_flag" + appRuntime.getAccount(), false);
            if (QLog.isColorLevel()) {
                QLog.d("CookieUtils", 2, "account: " + appRuntime.getAccount() + ", mPtloginFlag: " + z16);
            }
        }
        return z16;
    }

    public static void h(StringBuilder sb5) {
        if (sb5 != null && sb5.length() > 0) {
            if (sb5.toString().endsWith(";")) {
                sb5.append(" ");
            } else if (!sb5.toString().endsWith("; ")) {
                sb5.append("; ");
            }
        }
    }
}
