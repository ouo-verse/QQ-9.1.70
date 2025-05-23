package com.tencent.qimei.s;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f343361a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f343362b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20653);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f343361a = "com.tencent.qm.mulprocess_share";
        f343362b = "com.tencent.qm.spread";
    }
}
