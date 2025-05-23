package com.qzone.util;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f59842a;

    public static String c(String str) {
        if (f59842a == null) {
            f59842a = Pattern.compile("(@\\{uin:\\d+,nick:\\w+\\})");
        }
        if (str != null && str.length() != 0) {
            Matcher matcher = f59842a.matcher(str);
            if (matcher == null) {
                return str;
            }
            while (matcher.find()) {
                String group = matcher.group();
                if (group != null) {
                    try {
                        String b16 = b(group);
                        if (b16 != null) {
                            str = str.replace(group, "@{uin:" + b16 + ",nick:" + b16 + "}");
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return str;
    }

    public static String d(String str, int i3) {
        if (str == null || str.equals("") || i3 < 1) {
            return "";
        }
        if (str.length() <= i3) {
            return str;
        }
        String k3 = am.k(str, i3);
        if (k3.length() >= str.length()) {
            return str;
        }
        return k3 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public static String a(long j3, String str) {
        return "@{uin:" + j3 + ",nick:" + am.c(d(str, 10)) + ",who:1,auto:1}";
    }

    private static String b(String str) {
        int indexOf;
        if (str == null || str.length() == 0 || (indexOf = str.indexOf(",nick:")) == -1) {
            return null;
        }
        return str.substring(6, indexOf);
    }
}
