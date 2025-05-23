package com.tencent.mobileqq.splashad.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f288762a;

    /* renamed from: b, reason: collision with root package name */
    public static String[] f288763b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288762a = "";
            f288763b = new String[]{"normal", "night", "simple", "study", "elder"};
        }
    }
}
