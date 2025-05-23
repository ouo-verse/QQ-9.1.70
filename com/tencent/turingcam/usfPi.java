package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class usfPi {
    static IPatchRedirector $redirector_;

    /* loaded from: classes27.dex */
    public static class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f382404a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f382405b;

        /* renamed from: c, reason: collision with root package name */
        public String f382406c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f382407d;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f382404a = 200;
                this.f382407d = false;
            }
        }
    }

    public usfPi(spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            int unused = spxpg.f382404a;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spxpg);
        }
    }
}
