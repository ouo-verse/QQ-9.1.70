package com.qzone.proxy.feedcomponent.util;

import android.text.TextUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h {
    public static String b(long j3, String str, boolean z16) {
        String str2;
        String a16 = k.a(str);
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            str2 = "@";
        } else {
            str2 = "";
        }
        sb5.append(str2);
        sb5.append("{uin:");
        sb5.append(j3);
        sb5.append(",nick:");
        sb5.append(a16);
        sb5.append("}");
        return sb5.toString();
    }

    public static String c(long j3, String str, int i3) {
        return d(j3, g(str, i3));
    }

    public static String e(long j3, String str, int i3) {
        String f16 = f(str, i3);
        try {
            f16 = URLEncoder.encode(f16, "UTF-8");
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d("NickUtil", "build nickname partially failed", e16);
        }
        return "<uin:" + j3 + ",nickname:" + f16 + ">";
    }

    public static String g(String str, int i3) {
        int i16;
        if (TextUtils.isEmpty(str) || str.length() <= i3) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(i3);
        int length = str.length();
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i17 >= length) {
                break;
            }
            char charAt = str.charAt(i17);
            i18 += charAt < '\u0080' ? 1 : 2;
            sb5.append(charAt);
            if (i18 < i3) {
                i17++;
            } else if (Character.isHighSurrogate(charAt) && (i16 = i17 + 1) < length) {
                sb5.append(str.charAt(i16));
            }
        }
        return sb5.toString();
    }

    public static String f(String str, int i3) {
        if (str == null || str.length() <= i3 || i3 <= 0) {
            return str;
        }
        if (Character.isHighSurrogate(str.charAt(i3 - 1))) {
            i3++;
        }
        if (i3 > str.length()) {
            i3 = str.length();
        }
        return str.substring(0, i3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public static String a(String str, String str2) {
        return "{url:" + str + ",text:" + f(str2, Integer.MAX_VALUE) + "}";
    }

    public static String d(long j3, String str) {
        return e(j3, str, Integer.MAX_VALUE);
    }
}
