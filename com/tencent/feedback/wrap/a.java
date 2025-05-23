package com.tencent.feedback.wrap;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f105565a;

    /* renamed from: b, reason: collision with root package name */
    public static int f105566b;

    /* renamed from: c, reason: collision with root package name */
    public static int f105567c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
            return;
        }
        f105565a = 0;
        f105566b = 1;
        f105567c = 3;
    }
}
