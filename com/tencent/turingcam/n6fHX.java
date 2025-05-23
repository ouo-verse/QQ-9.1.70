package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class n6fHX {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final VV8k1<wUeOG> f382314a;

    /* renamed from: b, reason: collision with root package name */
    public static final VV8k1<wUeOG> f382315b;

    /* renamed from: c, reason: collision with root package name */
    public static final wUeOG[] f382316c;

    /* renamed from: d, reason: collision with root package name */
    public static long f382317d;

    /* renamed from: e, reason: collision with root package name */
    public static final FE6di f382318e;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements FE6di {
        static IPatchRedirector $redirector_;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(wUeOG wueog) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) wueog);
                return;
            }
            int i3 = wueog.f382416b;
            if (i3 != 2 && i3 != 3) {
                FjMaF fjMaF = wueog.f382417c;
                if (fjMaF != null) {
                    long abs = Math.abs(fjMaF.f381825a - n6fHX.f382317d);
                    n6fHX.f382317d = System.currentTimeMillis();
                    if (abs < 1000) {
                        return;
                    }
                    VV8k1<wUeOG> vV8k1 = n6fHX.f382314a;
                    synchronized (vV8k1) {
                        vV8k1.a(wueog);
                    }
                    return;
                }
                return;
            }
            VV8k1<wUeOG> vV8k12 = n6fHX.f382315b;
            synchronized (vV8k12) {
                vV8k12.a(wueog);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382314a = new VV8k1<>(3);
        f382315b = new VV8k1<>(3);
        f382316c = new wUeOG[0];
        f382317d = 0L;
        f382318e = new spXPg();
    }
}
