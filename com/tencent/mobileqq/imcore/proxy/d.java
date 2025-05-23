package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f238032a;

    /* renamed from: b, reason: collision with root package name */
    public static int f238033b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39840);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f238032a = 0;
            f238033b = 0;
        }
    }
}
