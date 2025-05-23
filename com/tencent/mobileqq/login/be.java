package com.tencent.mobileqq.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class be extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public String f241956f;

    /* renamed from: g, reason: collision with root package name */
    public String f241957g;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f241958a;

        /* renamed from: b, reason: collision with root package name */
        private final int f241959b;

        /* renamed from: c, reason: collision with root package name */
        private String f241960c;

        /* renamed from: d, reason: collision with root package name */
        private String f241961d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f241962e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f241963f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f241964g;

        public a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f241958a = i3;
                this.f241959b = i16;
            }
        }

        public be h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (be) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new be(this);
        }

        public a i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f241960c = str;
            return this;
        }

        public a j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.f241962e = z16;
            return this;
        }

        public a k(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.f241964g = z16;
            return this;
        }

        public a l(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f241961d = str;
            return this;
        }

        public a m(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.f241963f = z16;
            return this;
        }
    }

    be(a aVar) {
        super(aVar.f241958a, aVar.f241959b);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f242204e = aVar.f241962e;
        this.f242202c = aVar.f241963f;
        this.f242203d = aVar.f241964g;
        this.f241956f = aVar.f241960c;
        this.f241957g = aVar.f241961d;
    }
}
