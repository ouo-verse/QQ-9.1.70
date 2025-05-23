package com.tencent.mobileqq.login;

import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class bl extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public String f241977f;

    /* renamed from: g, reason: collision with root package name */
    public String f241978g;

    /* renamed from: h, reason: collision with root package name */
    public String f241979h;

    /* renamed from: i, reason: collision with root package name */
    public String f241980i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f241981a;

        /* renamed from: b, reason: collision with root package name */
        private final int f241982b;

        /* renamed from: c, reason: collision with root package name */
        private String f241983c;

        /* renamed from: d, reason: collision with root package name */
        private String f241984d;

        /* renamed from: e, reason: collision with root package name */
        private String f241985e;

        /* renamed from: f, reason: collision with root package name */
        private String f241986f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f241987g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f241988h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f241989i;

        public a(@LoginReportConstants.PhoneLoginScene int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f241981a = 5;
                this.f241982b = i3;
            }
        }

        public bl a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (bl) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            bl blVar = new bl(this.f241981a, this.f241982b);
            blVar.f241977f = this.f241983c;
            blVar.f241978g = this.f241984d;
            blVar.f241979h = this.f241985e;
            blVar.f241980i = this.f241986f;
            blVar.f242204e = this.f241987g;
            blVar.f242202c = this.f241988h;
            blVar.f242203d = this.f241989i;
            return blVar;
        }

        public a b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f241983c = str;
            return this;
        }

        public a c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.f241987g = z16;
            return this;
        }

        public a d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f241986f = str;
            return this;
        }

        public a e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            this.f241989i = z16;
            return this;
        }

        public a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f241984d = str;
            return this;
        }

        public a g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f241985e = str;
            return this;
        }

        public a h(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f241988h = z16;
            return this;
        }
    }

    bl(int i3, int i16) {
        super(i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
