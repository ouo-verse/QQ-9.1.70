package com.tencent.upgrade.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static boolean a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public static String b(String str, int i3, int i16) {
        return str + "_" + i3 + "_" + i16;
    }

    public static boolean c(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }
}
