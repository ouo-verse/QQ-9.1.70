package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f243059a;

    /* renamed from: b, reason: collision with root package name */
    public static long f243060b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32353);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f243059a = 0;
        }
    }
}
