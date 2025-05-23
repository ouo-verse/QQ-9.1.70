package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.ar.ARLBSHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f199721a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f199722b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70852);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f199721a = ArMapHandler.class.getName();
            f199722b = ARLBSHandler.class.getName();
        }
    }
}
