package com.tencent.mobileqq.bridge;

import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import z91.b;
import z91.c;
import z91.d;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Provider<b> f200526a;

    /* renamed from: b, reason: collision with root package name */
    private static Provider<d> f200527b;

    /* renamed from: c, reason: collision with root package name */
    private static Provider<c> f200528c;

    /* renamed from: d, reason: collision with root package name */
    private static Provider<aa1.a> f200529d;

    /* renamed from: e, reason: collision with root package name */
    private static Provider<aa1.b> f200530e;

    public static aa1.a a() {
        Provider<aa1.a> provider = f200529d;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }

    public static b b() {
        Provider<b> provider = f200526a;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }

    public static c c() {
        Provider<c> provider = f200528c;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }

    public static aa1.b d() {
        Provider<aa1.b> provider = f200530e;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }

    public static void e(Provider<aa1.a> provider) {
        f200529d = provider;
    }

    public static void f(Provider<b> provider) {
        f200526a = provider;
    }

    public static void g(Provider<c> provider) {
        f200528c = provider;
    }

    public static void h(Provider<aa1.b> provider) {
        f200530e = provider;
    }

    public static void i(Provider<d> provider) {
        f200527b = provider;
    }
}
