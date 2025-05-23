package com.tencent.mobileqq.qroute.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static g f276496a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f276497b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276496a = null;
            f276497b = false;
        }
    }

    public static void a(String str) {
        g gVar = f276496a;
        if (gVar != null) {
            gVar.info("UIRoute", str);
        }
    }

    public static void b(String str) {
        g gVar = f276496a;
        if (gVar != null) {
            gVar.info("UIRoute", str);
        }
    }

    public static void c(String str) {
        g gVar = f276496a;
        if (gVar != null) {
            gVar.a("UIRoute", str);
        }
    }

    public static void d(String str, Throwable th5) {
        g gVar = f276496a;
        if (gVar != null) {
            gVar.b("UIRoute", str, th5);
        }
    }
}
