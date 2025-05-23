package com.tencent.tedger.routecenter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.routecenter.defaultimp.b;
import com.tencent.tedger.routecenter.defaultimp.d;
import com.tencent.tedger.routecenter.defaultimp.e;
import com.tencent.tedger.routecenter.defaultimp.f;
import com.tencent.tedger.routecenter.defaultimp.g;
import com.tencent.tedger.routecenter.defaultimp.i;
import com.tencent.tedger.routecenter.defaultimp.j;
import com.tencent.tedger.routecenter.defaultimp.k;
import com.tencent.tedger.routecenter.defaultimp.l;
import com.tencent.tedger.routecenter.defaultimp.m;
import com.tencent.tedger.routecenter.defaultimp.n;
import com.tencent.tedger.routecenter.defaultimp.o;
import com.tencent.tedger.routecenter.defaultimp.p;
import com.tencent.tedger.routecenter.defaultimp.q;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final j f375303a;

    /* renamed from: b, reason: collision with root package name */
    public final f f375304b;

    /* renamed from: c, reason: collision with root package name */
    public final m f375305c;

    /* renamed from: d, reason: collision with root package name */
    public final n f375306d;

    /* renamed from: e, reason: collision with root package name */
    public final q f375307e;

    /* renamed from: f, reason: collision with root package name */
    public final k f375308f;

    /* renamed from: g, reason: collision with root package name */
    public final i f375309g;

    /* renamed from: h, reason: collision with root package name */
    public final o f375310h;

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.tedger.routecenter.defaultimp.a f375311i;

    /* renamed from: j, reason: collision with root package name */
    public final b f375312j;

    /* renamed from: k, reason: collision with root package name */
    public final d f375313k;

    /* renamed from: l, reason: collision with root package name */
    public final e f375314l;

    /* renamed from: m, reason: collision with root package name */
    public final l f375315m;

    /* renamed from: n, reason: collision with root package name */
    public final p f375316n;

    /* renamed from: o, reason: collision with root package name */
    public final g f375317o;

    /* renamed from: p, reason: collision with root package name */
    public ve4.l f375318p;

    public a(ve4.l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lVar);
            return;
        }
        this.f375303a = new j(this);
        this.f375304b = new f(this);
        this.f375305c = new m(this);
        this.f375306d = new n(this);
        this.f375307e = new q(this);
        this.f375308f = new k(this);
        this.f375309g = new i(this);
        this.f375310h = new o(this);
        this.f375311i = new com.tencent.tedger.routecenter.defaultimp.a(this);
        this.f375312j = new b(this);
        this.f375313k = new d(this);
        this.f375314l = new e(this);
        this.f375315m = new l(this);
        this.f375316n = new p(this);
        this.f375317o = new g(this);
        this.f375318p = lVar;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f375303a.B();
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f375303a.onDestroy();
        this.f375304b.onDestroy();
        this.f375305c.onDestroy();
        this.f375306d.onDestroy();
        this.f375307e.onDestroy();
        this.f375308f.onDestroy();
        this.f375309g.onDestroy();
        this.f375311i.onDestroy();
        this.f375312j.onDestroy();
        this.f375313k.onDestroy();
        this.f375314l.onDestroy();
        this.f375315m.onDestroy();
        this.f375316n.onDestroy();
        this.f375317o.onDestroy();
        this.f375310h.onDestroy();
    }
}
