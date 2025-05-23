package com.tencent.mobileqq.dt.app.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (str.isEmpty()) {
            return "";
        }
        try {
            return str.replaceAll("^:|:$", "").replace(",", "||").replace("\uff0c", "||");
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String b(String str) {
        try {
            if (str.isEmpty()) {
                return "";
            }
            return str.replaceAll("[,:\uff0c]", "");
        } catch (Throwable unused) {
            return str;
        }
    }
}
