package com.tencent.ams.fusion.service.splash.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f70310a;

    /* renamed from: b, reason: collision with root package name */
    public static int f70311b;

    /* renamed from: c, reason: collision with root package name */
    public static int f70312c;

    /* renamed from: d, reason: collision with root package name */
    public static int f70313d;

    /* renamed from: e, reason: collision with root package name */
    public static int f70314e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55588);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f70310a = 0;
        f70311b = 0;
        f70312c = 0;
        f70313d = 0;
        f70314e = 1;
    }

    public static void a() {
        f70311b = 1;
    }

    public static void b() {
        f70314e = 0;
    }

    public static void c() {
        f70313d = 1;
    }

    public static void d() {
        f70312c = 1;
    }

    public static void e() {
        f70310a = 1;
    }
}
