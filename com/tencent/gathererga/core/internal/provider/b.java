package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static b f108228f;

    /* renamed from: a, reason: collision with root package name */
    private int f108229a;

    /* renamed from: b, reason: collision with root package name */
    private int f108230b;

    /* renamed from: c, reason: collision with root package name */
    private int f108231c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f108232d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f108233e;

    /* compiled from: P */
    /* renamed from: com.tencent.gathererga.core.internal.provider.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1142b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f108234a;

        /* renamed from: b, reason: collision with root package name */
        private int f108235b;

        /* renamed from: c, reason: collision with root package name */
        private int f108236c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f108237d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f108238e;

        /* synthetic */ C1142b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return;
            }
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
        }

        public final b f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (b) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return new b(this, null);
        }

        public final C1142b g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (C1142b) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.f108238e = z16;
            return this;
        }

        public final C1142b h(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (C1142b) iPatchRedirector.redirect((short) 11, (Object) this, z16);
            }
            this.f108237d = z16;
            return this;
        }

        public final C1142b i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C1142b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            this.f108234a = 4;
            return this;
        }

        public final C1142b j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C1142b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            this.f108234a = 1;
            return this;
        }

        public final C1142b k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (C1142b) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            this.f108235b = 2;
            return this;
        }

        public final C1142b l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (C1142b) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            this.f108235b = 1;
            return this;
        }

        public final C1142b m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (C1142b) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            this.f108236c = 2;
            return this;
        }

        public final C1142b n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (C1142b) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            this.f108236c = 1;
            return this;
        }

        C1142b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f108234a = 0;
            this.f108235b = 0;
            this.f108236c = 0;
            this.f108237d = true;
            this.f108238e = true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56033);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f108228f = new b(4, 2, 1);
        }
    }

    /* synthetic */ b(C1142b c1142b, a aVar) {
        this(c1142b);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) c1142b, (Object) aVar);
    }

    public static C1142b f() {
        return new C1142b(null);
    }

    public static b g() {
        return f108228f;
    }

    @Override // com.tencent.gathererga.core.e
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f108230b;
    }

    @Override // com.tencent.gathererga.core.e
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f108232d;
    }

    @Override // com.tencent.gathererga.core.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f108229a;
    }

    @Override // com.tencent.gathererga.core.e
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f108231c;
    }

    @Override // com.tencent.gathererga.core.e
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f108233e;
    }

    b(C1142b c1142b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c1142b);
            return;
        }
        this.f108229a = 0;
        this.f108230b = 0;
        this.f108231c = 0;
        this.f108232d = true;
        this.f108233e = false;
        this.f108229a = c1142b.f108234a;
        this.f108230b = c1142b.f108235b;
        this.f108231c = c1142b.f108236c;
        this.f108232d = c1142b.f108237d;
        this.f108233e = c1142b.f108238e;
    }

    b(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f108232d = true;
        this.f108233e = false;
        this.f108229a = i3;
        this.f108230b = i16;
        this.f108231c = i17;
    }
}
