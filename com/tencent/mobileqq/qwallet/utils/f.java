package com.tencent.mobileqq.qwallet.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f279261a = Pattern.compile("[\u4e00-\u9fa5]");

    public static void a(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "base64: " + e(str2));
        }
    }

    public static void b(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, "base64: " + e(str2));
        }
    }

    public static void c(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.w(str, 2, "base64: " + e(str2));
        }
    }

    public static void d(String str, String str2, Exception exc) {
        if (QLog.isColorLevel()) {
            QLog.w(str, 2, "base64: " + e(str2));
        }
    }

    public static String e(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    return f279261a.matcher(str).replaceAll("*");
                }
                return str;
            } catch (Exception unused) {
                return "replaceChineseWithStar fail: size=" + str.length();
            }
        }
        return str;
    }
}
