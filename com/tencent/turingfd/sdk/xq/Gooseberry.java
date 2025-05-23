package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Gooseberry {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final UrsaMinor<Cwhile> f382788a;

    /* renamed from: b, reason: collision with root package name */
    public static final UrsaMinor<Cwhile> f382789b;

    /* renamed from: c, reason: collision with root package name */
    public static final Cwhile[] f382790c;

    /* renamed from: d, reason: collision with root package name */
    public static long f382791d;

    /* renamed from: e, reason: collision with root package name */
    public static final k f382792e;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Gooseberry$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements k {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(Cwhile cwhile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cwhile);
                return;
            }
            int i3 = cwhile.f383459b;
            if (i3 != 2 && i3 != 3) {
                Segment segment = cwhile.f383460c;
                if (segment != null) {
                    long abs = Math.abs(segment.f383063a - Gooseberry.f382791d);
                    Gooseberry.f382791d = System.currentTimeMillis();
                    if (abs < 1000) {
                        return;
                    }
                    UrsaMinor<Cwhile> ursaMinor = Gooseberry.f382788a;
                    synchronized (ursaMinor) {
                        ursaMinor.a(cwhile);
                    }
                    return;
                }
                return;
            }
            UrsaMinor<Cwhile> ursaMinor2 = Gooseberry.f382789b;
            synchronized (ursaMinor2) {
                ursaMinor2.a(cwhile);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382788a = new UrsaMinor<>(3);
        f382789b = new UrsaMinor<>(3);
        f382790c = new Cwhile[0];
        f382791d = 0L;
        f382792e = new Cdo();
    }
}
