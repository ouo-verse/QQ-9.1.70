package com.tencent.mobileqq.webview.swift;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class v {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f314805a;

    /* renamed from: b, reason: collision with root package name */
    public static int f314806b;

    /* renamed from: c, reason: collision with root package name */
    public static int f314807c;

    /* renamed from: d, reason: collision with root package name */
    public static int f314808d;

    /* renamed from: e, reason: collision with root package name */
    public static int f314809e;

    /* renamed from: f, reason: collision with root package name */
    public static int f314810f;

    /* renamed from: g, reason: collision with root package name */
    public static int f314811g;

    /* renamed from: h, reason: collision with root package name */
    public static int f314812h;

    /* renamed from: i, reason: collision with root package name */
    public static int f314813i;

    /* renamed from: j, reason: collision with root package name */
    public static int f314814j;

    /* renamed from: k, reason: collision with root package name */
    public static int f314815k;

    /* renamed from: l, reason: collision with root package name */
    public static int f314816l;

    /* renamed from: m, reason: collision with root package name */
    public static int f314817m;

    /* renamed from: n, reason: collision with root package name */
    public static int f314818n;

    /* renamed from: o, reason: collision with root package name */
    public static int f314819o;

    /* renamed from: p, reason: collision with root package name */
    public static int f314820p;

    /* renamed from: q, reason: collision with root package name */
    public static int f314821q;

    /* renamed from: r, reason: collision with root package name */
    public static int f314822r;

    /* renamed from: s, reason: collision with root package name */
    public static int f314823s;

    /* renamed from: t, reason: collision with root package name */
    public static int f314824t;

    /* renamed from: u, reason: collision with root package name */
    public static int f314825u;

    /* renamed from: v, reason: collision with root package name */
    public static int f314826v;

    /* renamed from: w, reason: collision with root package name */
    public static int f314827w;

    /* renamed from: x, reason: collision with root package name */
    public static HashMap<Integer, Long> f314828x;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48886);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int i3 = 0 + 1;
        f314806b = 0;
        int i16 = i3 + 1;
        f314807c = i3;
        int i17 = i16 + 1;
        f314808d = i16;
        int i18 = i17 + 1;
        f314809e = i17;
        int i19 = i18 + 1;
        f314810f = i18;
        int i26 = i19 + 1;
        f314811g = i19;
        int i27 = i26 + 1;
        f314812h = i26;
        int i28 = i27 + 1;
        f314813i = i27;
        int i29 = i28 + 1;
        f314814j = i28;
        int i36 = i29 + 1;
        f314815k = i29;
        int i37 = i36 + 1;
        f314816l = i36;
        int i38 = i37 + 1;
        f314817m = i37;
        int i39 = i38 + 1;
        f314818n = i38;
        int i46 = i39 + 1;
        f314819o = i39;
        int i47 = i46 + 1;
        f314820p = i46;
        int i48 = i47 + 1;
        f314821q = i47;
        int i49 = i48 + 1;
        f314822r = i48;
        int i56 = i49 + 1;
        f314823s = i49;
        int i57 = i56 + 1;
        f314824t = i56;
        int i58 = i57 + 1;
        f314825u = i57;
        int i59 = i58 + 1;
        f314826v = i58;
        f314805a = i59 + 1;
        f314827w = i59;
        f314828x = new HashMap<>(f314805a + 1);
    }

    public static long a(long j3, long j16) {
        if (j3 <= 0 || j16 <= 0 || j16 < j3) {
            return 0L;
        }
        return j16 - j3;
    }

    public static long b(int i3) {
        Long l3 = f314828x.get(Integer.valueOf(i3));
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public static long c(int i3) {
        return b(i3);
    }

    public static void d(int i3) {
        e(i3, SystemClock.elapsedRealtime());
    }

    public static void e(int i3, long j3) {
        if (j3 > 0 && f314828x.containsKey(Integer.valueOf(i3))) {
            f314828x.put(Integer.valueOf(i3), Long.valueOf(a(b(i3), j3)));
        }
    }

    public static void f(int i3) {
        g(i3, SystemClock.elapsedRealtime());
    }

    public static void g(int i3, long j3) {
        if (j3 <= 0) {
            return;
        }
        f314828x.put(Integer.valueOf(i3), Long.valueOf(j3));
    }

    public static void h(HashMap<String, String> hashMap) {
        try {
            long b16 = b(f314806b);
            long b17 = b(f314807c);
            long b18 = b(f314808d);
            long b19 = b(f314810f);
            long b26 = b(f314809e);
            long b27 = b(f314811g);
            long b28 = b(f314812h);
            hashMap.put("click_appAttach", a(b16, b17) + "");
            hashMap.put("click_actOnCreate", a(b16, b19) + "");
            hashMap.put("appAttach_appOnCreate", a(b17, b18) + "");
            hashMap.put("appOnCreate_actOnCreate", a(b18, b19) + "");
            hashMap.put("appAttach_runTimeOnCreate", a(b17, b26) + "");
            hashMap.put("actOnCreate_fragOnCreate", a(b19, b27) + "");
            hashMap.put("fragOnCreate_fragOnActCreate", a(b27, b28) + "");
            hashMap.put("fragOnActCreate_onWindowFocus", a(b28, b(f314813i)) + "");
            hashMap.put("fragOnActCreate_loadUrl", a(b28, b(f314814j)) + "");
            hashMap.put("fragOnActCreate_pageStart", a(b28, b(f314815k)) + "");
            hashMap.put("fragOnActCreate_pageFinish", a(b28, b(f314816l)) + "");
            hashMap.put("fragOnActCreate_kernelEnd", a(b28, b(f314817m)) + "");
            hashMap.put("kernel_data", b(f314818n) + "");
            hashMap.put("kernel_x5env", b(f314819o) + "");
            hashMap.put("kernel_engine", b(f314820p) + "");
            hashMap.put("kernel_webview", b(f314821q) + "");
            hashMap.put("kernel_loadurl", b(f314822r) + "");
            hashMap.put("kernel_uiframe", b(f314823s) + "");
            hashMap.put("kernel_content", b(f314824t) + "");
            hashMap.put("kernel_bottom", b(f314826v) + "");
            hashMap.put("kernel_title", b(f314825u) + "");
            hashMap.put("kernel_final", b(f314827w) + "");
            f314828x.clear();
        } catch (Exception unused) {
        }
    }
}
