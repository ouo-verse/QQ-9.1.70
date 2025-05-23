package com.tencent.mobileqq.uftransfer.task.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;
    public String A;
    public long B;
    public int C;
    public String D;

    /* renamed from: a, reason: collision with root package name */
    public String f305671a;

    /* renamed from: b, reason: collision with root package name */
    public String f305672b;

    /* renamed from: c, reason: collision with root package name */
    public int f305673c;

    /* renamed from: d, reason: collision with root package name */
    public int f305674d;

    /* renamed from: e, reason: collision with root package name */
    public long f305675e;

    /* renamed from: f, reason: collision with root package name */
    public long f305676f;

    /* renamed from: g, reason: collision with root package name */
    public long f305677g;

    /* renamed from: h, reason: collision with root package name */
    public long f305678h;

    /* renamed from: i, reason: collision with root package name */
    public long f305679i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f305680j;

    /* renamed from: k, reason: collision with root package name */
    public int f305681k;

    /* renamed from: l, reason: collision with root package name */
    public int f305682l;

    /* renamed from: m, reason: collision with root package name */
    public int f305683m;

    /* renamed from: n, reason: collision with root package name */
    public int f305684n;

    /* renamed from: o, reason: collision with root package name */
    public long f305685o;

    /* renamed from: p, reason: collision with root package name */
    public long f305686p;

    /* renamed from: q, reason: collision with root package name */
    public String f305687q;

    /* renamed from: r, reason: collision with root package name */
    public String f305688r;

    /* renamed from: s, reason: collision with root package name */
    public long f305689s;

    /* renamed from: t, reason: collision with root package name */
    public int f305690t;

    /* renamed from: u, reason: collision with root package name */
    public int f305691u;

    /* renamed from: v, reason: collision with root package name */
    public int f305692v;

    /* renamed from: w, reason: collision with root package name */
    public int f305693w;

    /* renamed from: x, reason: collision with root package name */
    public int f305694x;

    /* renamed from: y, reason: collision with root package name */
    protected final String f305695y;

    /* renamed from: z, reason: collision with root package name */
    protected final String f305696z;

    public c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f305691u = 0;
        this.f305692v = 0;
        this.f305693w = 0;
        this.f305694x = 0;
        a();
        this.f305696z = str;
        this.f305695y = str2;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f305673c = 0;
        this.f305674d = 0;
        this.f305675e = 0L;
        this.f305676f = 0L;
        this.f305677g = 0L;
        this.f305678h = 0L;
        this.f305679i = 0L;
        this.f305680j = false;
        this.f305681k = -1;
        this.f305682l = 0;
        this.f305683m = 0;
        this.f305684n = 0;
        this.f305685o = 0L;
        this.f305686p = 0L;
        this.f305671a = "";
        this.f305672b = "";
        this.f305687q = "";
        this.f305688r = "";
        this.f305689s = 0L;
        this.f305690t = 0;
        this.f305691u = 0;
        this.f305692v = 0;
        this.f305693w = 0;
        this.f305694x = 0;
        this.A = "";
        this.B = 0L;
        this.C = 0;
        this.D = "";
    }
}
