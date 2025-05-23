package com.tencent.ams.fusion.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f70236a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f70236a = false;
        }
    }

    public static void a(String str) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().b("FusionAd_", String.valueOf(str));
        }
    }

    public static void b(String str, String str2) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().b("FusionAd_" + str, String.valueOf(str2));
        }
    }

    public static void c(String str, String str2, Throwable th5) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().a("FusionAd_" + str, String.valueOf(str2), th5);
        }
    }

    public static void d(String str, Throwable th5) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().a("FusionAd_", String.valueOf(str), th5);
        }
    }

    public static void e(boolean z16) {
        f70236a = z16;
    }

    public static boolean f() {
        if (f70236a) {
            return true;
        }
        return false;
    }

    public static void g(String str) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().e("FusionAd_", String.valueOf(str));
        }
    }

    public static void h(String str, String str2) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().e("FusionAd_" + str, String.valueOf(str2));
        }
    }

    public static void i(String str) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().c("FusionAd_", String.valueOf(str));
        }
    }

    public static void j(String str, String str2) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().c("FusionAd_" + str, String.valueOf(str2));
        }
    }

    public static void k(String str) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().d("FusionAd_", String.valueOf(str));
        }
    }

    public static void l(String str, String str2) {
        if (f()) {
            com.tencent.ams.fusion.service.b.b().l().d("FusionAd_" + str, String.valueOf(str2));
        }
    }
}
