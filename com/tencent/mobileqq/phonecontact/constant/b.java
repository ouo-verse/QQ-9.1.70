package com.tencent.mobileqq.phonecontact.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static boolean f258441a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31929);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258441a = false;
        }
    }
}
