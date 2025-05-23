package com.tencent.mobileqq.qqperfnativetool;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.mobileqq.qqperfnativetool.signalTool.a f274246a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqperfnativetool.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class C8421a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static a f274247a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10275);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f274247a = new a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        return C8421a.f274247a;
    }

    public com.tencent.mobileqq.qqperfnativetool.signalTool.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qqperfnativetool.signalTool.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f274246a;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            System.loadLibrary("qqperfnativetool");
        }
    }

    public void d(com.tencent.mobileqq.qqperfnativetool.signalTool.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f274246a = aVar;
        }
    }
}
