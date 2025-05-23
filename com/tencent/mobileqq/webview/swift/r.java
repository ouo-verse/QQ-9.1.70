package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class r implements ad {
    static IPatchRedirector $redirector_;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public JSONObject K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public WebViewTitleStyle T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* renamed from: a, reason: collision with root package name */
    public boolean f314618a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f314619b;

    /* renamed from: c, reason: collision with root package name */
    public long f314620c;

    /* renamed from: d, reason: collision with root package name */
    public long f314621d;

    /* renamed from: e, reason: collision with root package name */
    public long f314622e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f314623f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f314624g;

    /* renamed from: h, reason: collision with root package name */
    public long f314625h;

    /* renamed from: i, reason: collision with root package name */
    public String f314626i;

    /* renamed from: j, reason: collision with root package name */
    public int f314627j;

    /* renamed from: k, reason: collision with root package name */
    public int f314628k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f314629l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f314630m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f314631n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f314632o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f314633p;

    /* renamed from: q, reason: collision with root package name */
    public Boolean f314634q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f314635r;

    /* renamed from: s, reason: collision with root package name */
    public int f314636s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f314637t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f314638u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f314639v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f314640w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f314641x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f314642y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f314643z;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314618a = false;
        this.f314619b = false;
        this.f314620c = 4L;
        this.f314621d = 0L;
        this.f314622e = 5L;
        this.f314623f = false;
        this.f314624g = false;
        this.f314625h = 0L;
        this.f314627j = 0;
        this.f314628k = -1;
        this.f314629l = false;
        this.f314631n = false;
        this.f314632o = false;
        this.f314633p = false;
        this.f314634q = Boolean.FALSE;
        this.f314635r = false;
        this.f314636s = 50;
        this.f314637t = false;
        this.f314638u = false;
        this.f314639v = false;
        this.f314640w = false;
        this.f314641x = false;
        this.f314642y = false;
        this.f314643z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.K = null;
        this.L = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.T = null;
        this.W = false;
    }

    @Override // com.tencent.mobileqq.webview.swift.ad
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ((this.f314620c & 65536) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.ad
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if ((this.f314621d & 64) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.ad
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f314622e;
    }
}
