package com.tencent.mobileqq.troop.data;

import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class t {
    static IPatchRedirector $redirector_;
    public String A;
    public String B;
    public String C;
    public String D;
    public int E;
    public String F;
    public String G;
    public boolean H;
    public int I;
    public long J;
    public long K;

    /* renamed from: a, reason: collision with root package name */
    public UUID f294967a;

    /* renamed from: b, reason: collision with root package name */
    public String f294968b;

    /* renamed from: c, reason: collision with root package name */
    public int f294969c;

    /* renamed from: d, reason: collision with root package name */
    public long f294970d;

    /* renamed from: e, reason: collision with root package name */
    public long f294971e;

    /* renamed from: f, reason: collision with root package name */
    public int f294972f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f294973g;

    /* renamed from: h, reason: collision with root package name */
    public int f294974h;

    /* renamed from: i, reason: collision with root package name */
    public int f294975i;

    /* renamed from: j, reason: collision with root package name */
    public long f294976j;

    /* renamed from: k, reason: collision with root package name */
    public long f294977k;

    /* renamed from: l, reason: collision with root package name */
    public String f294978l;

    /* renamed from: m, reason: collision with root package name */
    public String f294979m;

    /* renamed from: n, reason: collision with root package name */
    public String f294980n;

    /* renamed from: o, reason: collision with root package name */
    public String f294981o;

    /* renamed from: p, reason: collision with root package name */
    public int f294982p;

    /* renamed from: q, reason: collision with root package name */
    public int f294983q;

    /* renamed from: r, reason: collision with root package name */
    public int f294984r;

    /* renamed from: s, reason: collision with root package name */
    public String f294985s;

    /* renamed from: t, reason: collision with root package name */
    public String f294986t;

    /* renamed from: u, reason: collision with root package name */
    public String f294987u;

    /* renamed from: v, reason: collision with root package name */
    public int f294988v;

    /* renamed from: w, reason: collision with root package name */
    public long f294989w;

    /* renamed from: x, reason: collision with root package name */
    public String f294990x;

    /* renamed from: y, reason: collision with root package name */
    public String f294991y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f294992z;

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.E = 0;
            this.f294972f = 7;
        }
    }

    public void a(t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tVar);
            return;
        }
        this.f294972f = 7;
        if (tVar != null) {
            this.f294967a = tVar.f294967a;
            this.f294968b = tVar.f294968b;
            this.f294969c = tVar.f294969c;
            this.f294970d = tVar.f294970d;
            this.f294971e = tVar.f294971e;
            this.f294972f = tVar.f294972f;
            this.f294974h = tVar.f294974h;
            this.f294976j = tVar.f294976j;
            this.f294977k = tVar.f294977k;
            this.f294978l = tVar.f294978l;
            this.f294979m = tVar.f294979m;
            this.f294980n = tVar.f294980n;
            this.f294981o = tVar.f294981o;
            this.f294982p = tVar.f294982p;
            this.f294983q = tVar.f294983q;
            this.f294984r = tVar.f294984r;
            this.f294985s = tVar.f294985s;
            this.f294987u = tVar.f294987u;
            this.f294988v = tVar.f294988v;
            this.f294990x = tVar.f294990x;
            this.f294991y = tVar.f294991y;
            this.f294992z = tVar.f294992z;
            this.A = tVar.A;
            this.I = tVar.I;
            this.H = tVar.H;
            this.E = tVar.E;
            this.F = tVar.F;
            this.G = tVar.G;
        }
        if (this.f294972f == 11 && !RFWFileUtils.fileExists(this.f294978l)) {
            this.f294972f = 7;
            if (tVar != null) {
                tVar.f294972f = 7;
            }
        }
    }

    public t(t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tVar);
        } else {
            this.E = 0;
            a(tVar);
        }
    }
}
