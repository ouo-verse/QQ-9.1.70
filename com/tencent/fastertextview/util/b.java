package com.tencent.fastertextview.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f105529a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15015);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f105529a = false;
        }
    }

    public static boolean a() {
        return f105529a;
    }
}
