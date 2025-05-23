package com.tencent.qmsp.oaid2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static int f344180a = -12;

    /* renamed from: b, reason: collision with root package name */
    public static int f344181b = -13;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14979);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }
}
