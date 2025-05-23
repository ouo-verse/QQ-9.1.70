package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.class, reason: invalid class name */
/* loaded from: classes27.dex */
public final class Cclass {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f383240a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f383240a = new int[0];
        }
    }
}
