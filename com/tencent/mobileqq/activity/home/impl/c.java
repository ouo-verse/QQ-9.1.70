package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f183064a;

    /* renamed from: b, reason: collision with root package name */
    private final Class f183065b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f183066c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f183067d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f183068e;

    /* renamed from: f, reason: collision with root package name */
    private int f183069f;

    /* renamed from: g, reason: collision with root package name */
    private final String f183070g;

    /* renamed from: h, reason: collision with root package name */
    private final int f183071h;

    /* renamed from: i, reason: collision with root package name */
    private final int f183072i;

    /* renamed from: j, reason: collision with root package name */
    private final int f183073j;

    /* renamed from: k, reason: collision with root package name */
    private final int f183074k;

    /* renamed from: l, reason: collision with root package name */
    private final int f183075l;

    /* renamed from: m, reason: collision with root package name */
    private final int f183076m;

    /* renamed from: n, reason: collision with root package name */
    private final int f183077n;

    /* renamed from: o, reason: collision with root package name */
    private final int f183078o;

    /* renamed from: p, reason: collision with root package name */
    private final int f183079p;

    /* renamed from: q, reason: collision with root package name */
    private final String f183080q;

    /* renamed from: r, reason: collision with root package name */
    private final String f183081r;

    /* renamed from: s, reason: collision with root package name */
    private final String f183082s;

    /* renamed from: t, reason: collision with root package name */
    private final int f183083t;

    /* renamed from: u, reason: collision with root package name */
    private final int f183084u;

    /* renamed from: v, reason: collision with root package name */
    private final String f183085v;

    /* renamed from: w, reason: collision with root package name */
    private final String f183086w;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f183087a;

        /* renamed from: b, reason: collision with root package name */
        private Class f183088b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f183089c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f183090d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f183091e;

        /* renamed from: f, reason: collision with root package name */
        private int f183092f;

        /* renamed from: g, reason: collision with root package name */
        private String f183093g;

        /* renamed from: h, reason: collision with root package name */
        private int f183094h;

        /* renamed from: i, reason: collision with root package name */
        private int f183095i;

        /* renamed from: j, reason: collision with root package name */
        private int f183096j;

        /* renamed from: k, reason: collision with root package name */
        private int f183097k;

        /* renamed from: l, reason: collision with root package name */
        private int f183098l;

        /* renamed from: m, reason: collision with root package name */
        private int f183099m;

        /* renamed from: n, reason: collision with root package name */
        private int f183100n;

        /* renamed from: o, reason: collision with root package name */
        private String f183101o;

        /* renamed from: p, reason: collision with root package name */
        private String f183102p;

        /* renamed from: q, reason: collision with root package name */
        private int f183103q;

        /* renamed from: r, reason: collision with root package name */
        private int f183104r;

        /* renamed from: s, reason: collision with root package name */
        private String f183105s;

        /* renamed from: t, reason: collision with root package name */
        public String f183106t;

        /* renamed from: u, reason: collision with root package name */
        public String f183107u;

        /* renamed from: v, reason: collision with root package name */
        public int f183108v;

        /* renamed from: w, reason: collision with root package name */
        public int f183109w;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static b B() {
            return new b();
        }

        public c A() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (c) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return new c(this, null);
        }

        public b C(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (b) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            }
            this.f183105s = str;
            return this;
        }

        public b D(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (b) iPatchRedirector.redirect((short) 20, (Object) this, i3);
            }
            this.f183103q = i3;
            return this;
        }

        public b E(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (b) iPatchRedirector.redirect((short) 21, (Object) this, i3);
            }
            this.f183104r = i3;
            return this;
        }

        public b F(Class cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
            }
            this.f183088b = cls;
            return this;
        }

        public b G(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.f183092f = i3;
            return this;
        }

        public b H(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f183087a = str;
            return this;
        }

        public b I(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (b) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            }
            this.f183102p = str;
            return this;
        }

        public b J(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (b) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            }
            this.f183101o = str;
            return this;
        }

        public b K(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.f183089c = z16;
            return this;
        }

        public b L(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.f183091e = z16;
            return this;
        }

        public b M(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.f183090d = z16;
            return this;
        }

        public b N(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (b) iPatchRedirector.redirect((short) 13, (Object) this, i3);
            }
            this.f183096j = i3;
            return this;
        }

        public b O(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (b) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            }
            this.f183107u = str;
            return this;
        }

        public b P(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (b) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            }
            this.f183106t = str;
            return this;
        }

        public b Q(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.f183093g = str;
            return this;
        }

        public b R(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (b) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.f183108v = i3;
            return this;
        }

        public b t(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (b) iPatchRedirector.redirect((short) 14, (Object) this, i3);
            }
            this.f183097k = i3;
            return this;
        }

        public b u(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (b) iPatchRedirector.redirect((short) 15, (Object) this, i3);
            }
            this.f183098l = i3;
            return this;
        }

        public b v(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (b) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.f183109w = i3;
            return this;
        }

        public b w(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (b) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.f183094h = i3;
            return this;
        }

        public b x(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (b) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            this.f183095i = i3;
            return this;
        }

        public b y(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (b) iPatchRedirector.redirect((short) 16, (Object) this, i3);
            }
            this.f183099m = i3;
            return this;
        }

        public b z(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (b) iPatchRedirector.redirect((short) 17, (Object) this, i3);
            }
            this.f183100n = i3;
            return this;
        }
    }

    /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, (Object) this, (Object) bVar, (Object) aVar);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f183074k;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f183075l;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.f183078o;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f183071h;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f183072i;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f183076m;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.f183077n;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f183082s;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.f183083t;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f183084u;
    }

    public Class k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183065b;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f183069f;
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f183064a;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f183081r;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f183080q;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f183073j;
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f183086w;
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f183085v;
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f183070g;
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.f183079p;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f183066c;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f183067d;
    }

    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.f183069f = i3;
        }
    }

    c(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f183064a = bVar.f183087a;
        this.f183065b = bVar.f183088b;
        this.f183066c = bVar.f183089c;
        this.f183067d = bVar.f183090d;
        this.f183068e = bVar.f183091e;
        this.f183069f = bVar.f183092f;
        this.f183070g = bVar.f183093g;
        this.f183071h = bVar.f183094h;
        this.f183072i = bVar.f183095i;
        this.f183073j = bVar.f183096j;
        this.f183074k = bVar.f183097k;
        this.f183075l = bVar.f183098l;
        this.f183076m = bVar.f183099m;
        this.f183077n = bVar.f183100n;
        this.f183080q = bVar.f183101o;
        this.f183081r = bVar.f183102p;
        this.f183083t = bVar.f183103q;
        this.f183084u = bVar.f183104r;
        this.f183082s = bVar.f183105s;
        this.f183085v = bVar.f183106t;
        this.f183086w = bVar.f183107u;
        this.f183079p = bVar.f183108v;
        this.f183078o = bVar.f183109w;
    }
}
