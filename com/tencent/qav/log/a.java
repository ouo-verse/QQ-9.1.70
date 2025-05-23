package com.tencent.qav.log;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f342386a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39879);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342386a = new b();
        }
    }

    public static void a(String str, String str2) {
        f342386a.a(str, str2);
    }

    public static void b(String str, String str2) {
        f342386a.b(str, str2);
    }

    public static void c(String str, String str2, Throwable th5) {
        f342386a.c(str, str2, th5);
    }

    public static void d(String str, String str2) {
        f342386a.d(str, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        f342386a.e(str, str2, th5);
    }

    public static void f(b bVar) {
        if (bVar != null) {
            f342386a = bVar;
        } else {
            f342386a = new b();
        }
    }

    public static void g(String str, String str2) {
        f342386a.f(str, str2);
    }

    public static void h(String str, String str2, Throwable th5) {
        f342386a.g(str, str2, th5);
    }
}
