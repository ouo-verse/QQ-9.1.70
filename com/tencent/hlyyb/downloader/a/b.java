package com.tencent.hlyyb.downloader.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f114393a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f114394b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f114395c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f114396d = ".temp";

    /* renamed from: e, reason: collision with root package name */
    public static volatile int f114397e = 500;

    /* renamed from: f, reason: collision with root package name */
    public static int f114398f = 50;

    /* renamed from: g, reason: collision with root package name */
    public static int f114399g = 6000;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static int a() {
        int f16 = com.tencent.hlyyb.common.a.a.f();
        return (f16 == 2 || f16 != 3) ? 1048576 : 524288;
    }

    public static String b() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + com.tencent.hlyyb.common.b.b.d() + "/HalleyDownload";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.hlyyb.common.a.a().getFilesDir().toString();
        }
        sb5.append(str);
        return sb5.toString();
    }

    public static int c() {
        return f114397e;
    }

    public static int d() {
        return f114399g;
    }

    public static String e(String str) {
        return str + ".bdcfg";
    }

    public static String f(String str) {
        return str + f114396d;
    }

    public static boolean g(String str) {
        if (com.tencent.hlyyb.common.b.b.a(str)) {
            return false;
        }
        return true;
    }

    public static void a(int i3) {
        f114397e = Math.min(Math.max(i3, 200), 1000);
    }

    public static void b(int i3) {
        f114399g = Math.min(Math.max(i3, 5000), 30000);
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        f114395c = str;
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f114396d = str;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        f114393a = str;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        f114394b = str;
    }
}
