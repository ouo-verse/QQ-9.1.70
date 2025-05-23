package com.tencent.mobileqq.squarepants;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f289654a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13463);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f289654a = new a();
        }
    }

    public static void a(String str, String str2) {
        f289654a.d(str, str2);
    }

    public static void b(String str, String str2) {
        f289654a.e(str, str2);
    }

    public static void c(String str, Throwable th5) {
        f289654a.e(str, th5);
    }

    public static void d(b bVar) {
        if (bVar == null) {
            return;
        }
        f289654a = bVar;
    }
}
