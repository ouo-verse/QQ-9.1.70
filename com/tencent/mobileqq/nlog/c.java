package com.tencent.mobileqq.nlog;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f254234a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f254234a = new a();
        }
    }

    public static void a(String str, String str2) {
        f254234a.e(str, str2);
    }

    public static void b(String str, String str2, Throwable th5) {
        f254234a.e(str, str2, th5);
    }

    public static void c(String str, String str2) {
        f254234a.i(str, str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        f254234a.i(str, str2, th5);
    }

    public static void e(b bVar) {
        f254234a = bVar;
    }
}
