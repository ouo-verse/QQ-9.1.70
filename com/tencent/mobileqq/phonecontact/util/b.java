package com.tencent.mobileqq.phonecontact.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 3) {
            return str.substring(str.length() - 3);
        }
        return "invalid phone num";
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 3) {
            return str.substring(0, 3);
        }
        return "invalid uin";
    }

    public static String c(String str) {
        if (str != null && str.length() > 4) {
            StringBuilder sb5 = new StringBuilder();
            int length = str.length() - 4;
            for (int i3 = 0; i3 < length; i3++) {
                sb5.append("*");
            }
            sb5.append(str.substring(length));
            return sb5.toString();
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
