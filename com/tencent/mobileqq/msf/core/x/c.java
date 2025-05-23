package com.tencent.mobileqq.msf.core.x;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f250206a = "ConfigManagerFactory";

    /* renamed from: b, reason: collision with root package name */
    public static int f250207b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f250208c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f250209d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f250210e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f250211f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f250212g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f250213h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f250214i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f250215j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f250216k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f250217l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f250218m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f250219n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f250220o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f250221p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f250222q;

    /* renamed from: r, reason: collision with root package name */
    public static final int f250223r;

    /* renamed from: s, reason: collision with root package name */
    public static final int f250224s;

    /* renamed from: t, reason: collision with root package name */
    public static final int f250225t;

    /* renamed from: u, reason: collision with root package name */
    public static final int f250226u;

    /* renamed from: v, reason: collision with root package name */
    public static final int f250227v;

    /* renamed from: w, reason: collision with root package name */
    public static final int f250228w;

    /* renamed from: x, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Class<? extends f>> f250229x;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f250209d = 1;
        f250210e = 2;
        f250211f = 3;
        f250212g = 4;
        f250213h = 5;
        f250214i = 6;
        f250215j = 7;
        f250216k = 8;
        f250217l = 9;
        f250218m = 10;
        f250219n = 11;
        f250220o = 12;
        f250221p = 13;
        f250222q = 14;
        f250223r = 15;
        f250224s = 16;
        f250225t = 17;
        f250226u = 18;
        f250207b = 20;
        f250227v = 19;
        f250228w = 20;
        ConcurrentHashMap<Integer, Class<? extends f>> concurrentHashMap = new ConcurrentHashMap<>();
        f250229x = concurrentHashMap;
        concurrentHashMap.put(0, com.tencent.mobileqq.msf.core.j.class);
        concurrentHashMap.put(1, l.class);
        concurrentHashMap.put(2, n.class);
        concurrentHashMap.put(3, j.class);
        concurrentHashMap.put(4, com.tencent.mobileqq.msf.core.f0.c.e.e.class);
        concurrentHashMap.put(5, com.tencent.mobileqq.msf.core.f0.c.e.g.class);
        concurrentHashMap.put(6, com.tencent.mobileqq.msf.core.f0.c.e.i.class);
        concurrentHashMap.put(7, com.tencent.mobileqq.msf.core.f0.c.e.l.class);
        concurrentHashMap.put(8, com.tencent.mobileqq.msf.core.f0.c.e.m.class);
        concurrentHashMap.put(9, com.tencent.mobileqq.msf.core.f0.c.e.n.class);
        concurrentHashMap.put(10, com.tencent.mobileqq.msf.core.h0.b.class);
        concurrentHashMap.put(11, com.tencent.mobileqq.msf.core.f0.c.e.d.class);
        concurrentHashMap.put(12, com.tencent.mobileqq.msf.core.f0.c.e.c.class);
        concurrentHashMap.put(13, com.tencent.mobileqq.msf.core.f0.c.e.h.class);
        concurrentHashMap.put(14, com.tencent.mobileqq.msf.core.f0.c.e.k.class);
        concurrentHashMap.put(15, com.tencent.mobileqq.msf.core.f0.c.e.f.class);
        concurrentHashMap.put(16, com.tencent.mobileqq.msf.core.f0.c.e.j.class);
        concurrentHashMap.put(18, com.tencent.mobileqq.msf.core.f0.c.e.b.class);
        concurrentHashMap.put(17, com.tencent.mobileqq.msf.core.f0.c.e.a.class);
        concurrentHashMap.put(19, k.class);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    @RequiresApi(api = 19)
    public static f a(int i3) {
        Class<? extends f> cls = f250229x.get(Integer.valueOf(i3));
        if (cls == null) {
            QLog.e(f250206a, 1, "NOT Found ConfigManager, name = " + i3);
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e16) {
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                BaseApplication.getContext().getMSFInterfaceAdapter().handleCatchException(Thread.currentThread(), e16, "ConfigManagerCreateException", null);
            }
            QLog.e(f250206a, 1, e16, new Object[0]);
            return null;
        }
    }
}
