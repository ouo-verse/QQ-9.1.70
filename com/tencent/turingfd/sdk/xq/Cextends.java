package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.extends, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cextends {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final long f383329a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f383330b = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13602);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f383329a = System.currentTimeMillis();
        }
    }
}
