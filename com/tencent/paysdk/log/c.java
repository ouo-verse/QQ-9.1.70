package com.tencent.paysdk.log;

import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f342031a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342031a = new a();
        }
    }

    public static void a(String str, String str2) {
        f342031a.e("AuthSDK->" + str, str2);
    }

    public static void b(String str, String str2) {
        f342031a.i("AuthSDK->" + str, str2);
    }

    public static void c(b bVar) {
        f342031a = bVar;
    }
}
