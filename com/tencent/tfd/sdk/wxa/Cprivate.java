package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.private, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cprivate {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f375766a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375766a = new LinkedHashSet();
        }
    }
}
