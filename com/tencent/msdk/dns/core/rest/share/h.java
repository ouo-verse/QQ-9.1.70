package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class h {
    public static String a(String str, String str2) {
        return d(str, str2, false);
    }

    public static String b(String str, String str2, String str3) {
        return c(str, str2, str3, false);
    }

    private static String c(String str, String str2, String str3, boolean z16) {
        String str4;
        if (!TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str3)) {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                Locale locale = Locale.US;
                if (z16) {
                    str4 = "dn=%s&clientip=1&ttl=1&id=%s&token=%s";
                } else {
                    str4 = "dn=%s&clientip=1&ttl=1&id=%s&token=%s&type=aaaa";
                }
                return String.format(locale, str4, str, str2, str3);
            }
            throw new IllegalArgumentException("token".concat(" can not be empty"));
        }
        throw new IllegalArgumentException("bizId".concat(" can not be empty"));
    }

    private static String d(String str, String str2, boolean z16) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Locale locale = Locale.US;
            if (z16) {
                str3 = "dn=%s&clientip=1&ttl=1&id=%s";
            } else {
                str3 = "dn=%s&clientip=1&ttl=1&id=%s&type=aaaa";
            }
            return String.format(locale, str3, str, str2);
        }
        throw new IllegalArgumentException("bizId".concat(" can not be empty"));
    }

    public static String e(String str, String str2) {
        return d(str, str2, true);
    }

    public static String f(String str, String str2, String str3) {
        return c(str, str2, str3, true);
    }
}
