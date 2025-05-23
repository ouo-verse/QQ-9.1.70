package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cu {
    public static String a(String str, String str2) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains(str2) && (lastIndexOf = str.lastIndexOf(str2) + 1) < str.length()) {
            return str.substring(lastIndexOf);
        }
        return str;
    }

    public static String b(List<? extends Object> list, String str) {
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < list.size(); i3++) {
                stringBuffer.append(list.get(i3).toString());
                stringBuffer.append(str);
            }
            stringBuffer.delete(stringBuffer.lastIndexOf(str), stringBuffer.length());
            return stringBuffer.toString();
        }
        return "";
    }

    public static int c(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static long d(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j3;
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace(System.lineSeparator(), " ").replace(RedTouch.NEWLINE_CHAR, " ");
    }

    public static String[] f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return new String[]{""};
        }
        return str.split(str2);
    }
}
