package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f238034a;

    /* renamed from: b, reason: collision with root package name */
    public static int f238035b;

    /* renamed from: c, reason: collision with root package name */
    public static int f238036c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f238034a = 0;
        f238035b = 0;
        f238036c = 0;
    }
}
