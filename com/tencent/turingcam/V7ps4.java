package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class V7ps4 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final IyjbE<V7ps4> f382068a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg extends IyjbE<V7ps4> {
        static IPatchRedirector $redirector_;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.tencent.turingcam.V7ps4] */
        @Override // com.tencent.turingcam.IyjbE
        public V7ps4 a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new V7ps4();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382068a = new spXPg();
        }
    }

    public V7ps4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (fBfpd.class) {
        }
        return "1";
    }
}
