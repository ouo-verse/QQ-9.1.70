package com.tencent.mobileqq.automator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f199910a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f199911b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f199910a = false;
            f199911b = false;
        }
    }
}
