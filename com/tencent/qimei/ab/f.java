package com.tencent.qimei.ab;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f342928a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f342928a = new AtomicBoolean(false);
        }
    }

    public static void a(String str) {
        if (!f342928a.get()) {
            return;
        }
        throw new IllegalStateException("[strict] " + str);
    }
}
