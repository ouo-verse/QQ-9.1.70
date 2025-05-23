package com.tencent.halley.downloader.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.oskplayer.cache.FileDataSink;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f113578a;

    /* renamed from: b, reason: collision with root package name */
    public static String f113579b;

    /* renamed from: c, reason: collision with root package name */
    public static String f113580c;

    /* renamed from: d, reason: collision with root package name */
    public static int f113581d;

    /* renamed from: e, reason: collision with root package name */
    private static String f113582e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f113583f;

    /* renamed from: g, reason: collision with root package name */
    private static int f113584g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12722);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113578a = "";
        f113579b = "";
        f113580c = "";
        f113581d = 50;
        f113582e = FileDataSink.TEMP_FILE;
        f113583f = 500;
        f113584g = 6000;
    }

    public static int a() {
        return h.a("down_conn_timeout", 5000, 60000, 20000);
    }

    public static int b() {
        return h.a("down_read_timeout", 5000, 60000, 20000);
    }

    public static int c() {
        int h16 = com.tencent.halley.common.a.c.h();
        if (h16 == 2 || h16 != 3) {
            return 1048576;
        }
        return 524288;
    }

    public static int d() {
        return 524288;
    }

    public static String e() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + j.g() + "/HalleyDownload";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.halley.common.a.a().getFilesDir().toString();
        }
        sb5.append(str);
        return sb5.toString();
    }

    public static int f() {
        return f113583f;
    }

    public static int g() {
        return 60000;
    }

    public static int h() {
        return 20000;
    }

    public static int i() {
        return 3000;
    }

    public static int j() {
        return 300;
    }

    public static int k() {
        return f113584g;
    }

    public static void a(int i3) {
        f113583f = Math.min(Math.max(i3, 200), 1000);
    }

    public static void b(int i3) {
        f113584g = Math.min(Math.max(i3, 5000), 30000);
    }

    public static String e(String str) {
        return str + ".bdcfg";
    }

    public static String f(String str) {
        return str + f113582e;
    }

    public static boolean g(String str) {
        return !j.a(str);
    }
}
