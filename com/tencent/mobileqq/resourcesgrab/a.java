package com.tencent.mobileqq.resourcesgrab;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    ResourceGrabView f281265a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.resourcesgrab.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private static final class C8512a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static a f281266a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74670);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f281266a = new a();
            }
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        return C8512a.f281266a;
    }
}
