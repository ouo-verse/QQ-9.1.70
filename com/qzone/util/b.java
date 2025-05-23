package com.qzone.util;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f59798a = new HashMap<>();

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 2) {
            return str;
        }
        String str2 = f59798a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        int length = str.length();
        String substring = str.substring(0, 2);
        StringBuffer stringBuffer = new StringBuffer("[");
        stringBuffer.append(substring);
        stringBuffer.append("***");
        stringBuffer.append(str.substring(length - 2));
        stringBuffer.append("]");
        String stringBuffer2 = stringBuffer.toString();
        f59798a.put(str, stringBuffer2);
        return stringBuffer2;
    }

    public static String a(long j3) {
        if (j3 <= 10000) {
            return j3 + "";
        }
        return b(String.valueOf(j3));
    }
}
