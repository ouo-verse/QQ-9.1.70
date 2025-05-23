package com.tencent.beacon.base.net.b;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f77720a = "https://otheve.beacon.qq.com/analytics/v2_upload";

    /* renamed from: b, reason: collision with root package name */
    public static String f77721b = "https://othstr.beacon.qq.com/analytics/v2_upload";

    /* renamed from: c, reason: collision with root package name */
    public static String f77722c = "oth.eve.mdt.qq.com";

    /* renamed from: d, reason: collision with root package name */
    public static String f77723d = "oth.str.mdt.qq.com";

    /* renamed from: e, reason: collision with root package name */
    private static boolean f77724e = false;

    public static String a(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        String str2 = str.contains("https") ? "https://" : "http://";
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        String substring = str.substring(indexOf + str2.length(), str.indexOf("/", str2.length()));
        int indexOf2 = substring.indexOf(":");
        return indexOf2 != -1 ? substring.substring(0, indexOf2) : substring;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str) || f77724e) {
            return;
        }
        f77722c = str;
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str) && !f77724e) {
            f77720a = str;
        }
    }

    public static void d(String str) {
        if (!TextUtils.isEmpty(str) && !f77724e) {
            f77723d = str;
        }
    }

    public static void e(String str) {
        if (!TextUtils.isEmpty(str) && !f77724e) {
            f77721b = str;
        }
    }

    public static String b(boolean z16) {
        return z16 ? f77723d : f77721b;
    }

    public static void b(String str, String str2) {
        Pattern compile = Pattern.compile("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}");
        Matcher matcher = compile.matcher(str);
        Matcher matcher2 = compile.matcher(str2);
        if (matcher.matches() && matcher2.matches()) {
            f77723d = str;
            f77721b = f77721b.replace("othstr.beacon.qq.com", str);
            f77722c = str2;
            String replace = f77720a.replace("otheve.beacon.qq.com", str2);
            f77720a = replace;
            com.tencent.beacon.base.util.c.a("[event url] ip modified by api, socketStrategyHost: %s, httpsStrategyUrl: %s, socketLogHost: %s ,httpsLogUrl: %s", f77723d, f77721b, f77722c, replace);
            return;
        }
        com.tencent.beacon.base.util.e.a("[event url] set report ip is not valid IP address!");
    }

    public static String a(boolean z16) {
        return z16 ? f77722c : f77720a;
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f77723d = str;
            f77721b = f77721b.replace("othstr.beacon.qq.com", str);
            f77724e = true;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f77722c = str2;
        f77720a = f77720a.replace("otheve.beacon.qq.com", str2);
        f77724e = true;
    }
}
