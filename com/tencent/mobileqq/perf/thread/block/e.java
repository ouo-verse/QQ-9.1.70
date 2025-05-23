package com.tencent.mobileqq.perf.thread.block;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Object f258114a;

    /* renamed from: b, reason: collision with root package name */
    private static Object f258115b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258114a = new Object();
            f258115b = new Object();
        }
    }
}
