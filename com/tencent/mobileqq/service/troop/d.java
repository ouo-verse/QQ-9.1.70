package com.tencent.mobileqq.service.troop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f286418a;

    /* renamed from: b, reason: collision with root package name */
    public static int f286419b;

    /* renamed from: c, reason: collision with root package name */
    public static int f286420c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f286418a = 0;
        f286419b = 0 + 1;
        f286420c = 0;
    }
}
