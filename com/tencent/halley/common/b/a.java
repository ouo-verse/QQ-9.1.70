package com.tencent.halley.common.b;

import com.tencent.halley.common.a.c.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f113284a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f113284a = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a(String str) {
        return com.tencent.halley.common.a.b.a(str);
    }

    public static a a() {
        return f113284a;
    }

    public static void a(String str, com.tencent.halley.common.a.a aVar, int i3, int i16) {
        com.tencent.halley.common.a.b.a(str, aVar, i3, i16);
    }
}
