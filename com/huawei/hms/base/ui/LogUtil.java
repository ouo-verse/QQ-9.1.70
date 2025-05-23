package com.huawei.hms.base.ui;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LogUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f36780a = Pattern.compile("[0-9]*[a-z|A-Z]*[\u4e00-\u9fa5]*");

    private static String a(String str, boolean z16) {
        StringBuilder sb5 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z16) {
                sb5.append(a(str));
            } else {
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    public static void e(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, z16));
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Log.e(str, a(str2, false));
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i3 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb5 = new StringBuilder(length);
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (f36780a.matcher(String.valueOf(charAt)).matches()) {
                if (i3 % 2 == 0) {
                    charAt = '*';
                }
                i3++;
            }
            sb5.append(charAt);
        }
        return sb5.toString();
    }
}
