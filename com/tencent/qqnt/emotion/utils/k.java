package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class k {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (str != null && str.length() != 0) {
            return str.charAt(0) + "|" + str.length();
        }
        return "0|0";
    }
}
