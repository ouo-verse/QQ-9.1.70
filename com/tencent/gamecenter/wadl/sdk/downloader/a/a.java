package com.tencent.gamecenter.wadl.sdk.downloader.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.g;
import com.tencent.mobileqq.pluginsdk.PluginUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f107276a = ".t";

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f107277b = 500;

    /* renamed from: c, reason: collision with root package name */
    public static int f107278c = 50;

    /* renamed from: d, reason: collision with root package name */
    private static int f107279d = 6000;

    public static int a() {
        return g.a("down_conn_timeout", 5000, 60000, 20000);
    }

    public static String b() {
        StringBuilder sb5 = new StringBuilder();
        String k3 = k();
        if (TextUtils.isEmpty(k3)) {
            k3 = e();
        }
        sb5.append(k3);
        return sb5.toString();
    }

    public static int c() {
        return 10000;
    }

    public static int d() {
        return f107279d;
    }

    public static String e() {
        return com.tencent.gamecenter.wadl.sdk.common.a.b().getFilesDir().toString();
    }

    public static int f() {
        return f107277b;
    }

    public static int g() {
        return 524288;
    }

    public static int h() {
        return g.a("down_read_timeout", 5000, 60000, 20000);
    }

    public static int i() {
        return 20000;
    }

    public static int j() {
        return 60000;
    }

    public static String k() {
        if (c.a()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + com.tencent.gamecenter.wadl.sdk.common.e.g.b() + "/WadlDownload";
        }
        return "";
    }

    public static int l() {
        int d16 = com.tencent.gamecenter.wadl.sdk.common.b.c.d();
        if (d16 != 2 && d16 == 3) {
            return 524288;
        }
        return 1048576;
    }

    public static String a(String str) {
        return str + PluginUtils.CONFIG_FILE_EXTEND_NAME;
    }

    public static String b(String str) {
        return str + f107276a;
    }

    public static void c(String str) {
        TextUtils.isEmpty(str);
    }

    public static void d(String str) {
        TextUtils.isEmpty(str);
    }

    public static void e(String str) {
        TextUtils.isEmpty(str);
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f107276a = str;
    }

    public static void a(int i3) {
        f107279d = Math.min(Math.max(i3, 5000), 30000);
    }

    public static void b(int i3) {
        f107277b = Math.min(Math.max(i3, 200), 1000);
    }
}
