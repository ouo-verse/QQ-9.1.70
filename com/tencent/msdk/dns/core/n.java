package com.tencent.msdk.dns.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.b;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.i.a;
import java.nio.channels.Selector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class n<LookupExtra extends i.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final o<LookupExtra> f336274a;

    /* renamed from: b, reason: collision with root package name */
    private int f336275b;

    /* renamed from: c, reason: collision with root package name */
    private m f336276c;

    /* renamed from: d, reason: collision with root package name */
    private a f336277d;

    /* renamed from: e, reason: collision with root package name */
    private b.c f336278e;

    /* renamed from: f, reason: collision with root package name */
    private CountDownLatch f336279f;

    /* renamed from: g, reason: collision with root package name */
    private Selector f336280g;

    /* renamed from: h, reason: collision with root package name */
    private Set<i> f336281h;

    /* renamed from: i, reason: collision with root package name */
    private List<i.b> f336282i;

    n(o<LookupExtra> oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            return;
        }
        this.f336275b = -1;
        if (oVar != null) {
            this.f336274a = oVar;
            return;
        }
        throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
    }

    public static <LookupExtra extends i.a> n<LookupExtra> k(o<LookupExtra> oVar) {
        return new n<>(oVar);
    }

    public m A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (m) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        m mVar = this.f336276c;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("mSorter".concat(" is not initialized yet"));
    }

    public a B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (a) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        a aVar = this.f336277d;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("mStatMerge".concat(" is not initialized yet"));
    }

    public b.c C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (b.c) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        b.c cVar = this.f336278e;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException("mTransaction".concat(" is not initialized yet"));
    }

    public n<LookupExtra> a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (n) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        if (!com.tencent.msdk.dns.c.e.d.b(i3)) {
            this.f336275b = i3;
            return this;
        }
        throw new IllegalArgumentException("curNetStack".concat(" is invalid"));
    }

    public n<LookupExtra> b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (n) iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar);
        }
        if (aVar != null) {
            this.f336277d = aVar;
            return this;
        }
        throw new IllegalArgumentException("statMerge".concat(" can not be null"));
    }

    public n<LookupExtra> c(b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (n) iPatchRedirector.redirect((short) 20, (Object) this, (Object) cVar);
        }
        if (cVar != null) {
            this.f336278e = cVar;
            return this;
        }
        throw new IllegalArgumentException("transaction".concat(" can not be null"));
    }

    public n<LookupExtra> d(m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (n) iPatchRedirector.redirect((short) 16, (Object) this, (Object) mVar);
        }
        if (mVar != null) {
            this.f336276c = mVar;
            return this;
        }
        throw new IllegalArgumentException("sorter".concat(" can not be null"));
    }

    public n<LookupExtra> e(o<LookupExtra> oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (n) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar);
        }
        return k(oVar).a(this.f336275b).d(this.f336276c).b(this.f336277d).c(this.f336278e).i(this.f336279f).f(this.f336280g).h(this.f336281h).g(this.f336282i);
    }

    public n<LookupExtra> f(Selector selector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (n) iPatchRedirector.redirect((short) 23, (Object) this, (Object) selector);
        }
        this.f336280g = selector;
        return this;
    }

    public n<LookupExtra> g(List<i.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (n) iPatchRedirector.redirect((short) 28, (Object) this, (Object) list);
        }
        if (list != null) {
            this.f336282i = list;
            return this;
        }
        throw new IllegalArgumentException("sessions".concat(" can not be null"));
    }

    public n<LookupExtra> h(Set<i> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (n) iPatchRedirector.redirect((short) 25, (Object) this, (Object) set);
        }
        if (set != null) {
            this.f336281h = set;
            return this;
        }
        throw new IllegalArgumentException("dnses".concat(" can not be null"));
    }

    public n<LookupExtra> i(CountDownLatch countDownLatch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (n) iPatchRedirector.redirect((short) 22, (Object) this, (Object) countDownLatch);
        }
        if (countDownLatch != null) {
            this.f336279f = countDownLatch;
            return this;
        }
        throw new IllegalArgumentException("countDownLatch".concat(" can not be null"));
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        Set<i> set = this.f336281h;
        if (set != null) {
            return set.isEmpty();
        }
        throw new IllegalStateException("mDnses".concat(" is not initialized yet"));
    }

    public o<LookupExtra> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (o) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f336274a;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f336274a.f336293h;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f336274a.f336291f;
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f336274a.f336297l;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (!com.tencent.msdk.dns.c.e.d.b(this.f336275b)) {
            return this.f336275b;
        }
        throw new IllegalStateException("mCurNetStack".concat(" is not initialized yet"));
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f336274a.f336289d;
    }

    public Set<i> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Set) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        Set<i> set = this.f336281h;
        if (set != null) {
            return set;
        }
        throw new IllegalStateException("mDnses".concat(" is not initialized yet"));
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f336274a.f336296k;
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f336274a.f336294i;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return "LookupContext{mLookupParams=" + this.f336274a + ", mCurNetStack=" + this.f336275b + ", mSorter=" + this.f336276c + ", mStatMerge=" + this.f336277d + ", mTransaction=" + this.f336278e + ", mCountDownLatch=" + this.f336279f + ", mSelector=" + this.f336280g + ", mDnses=" + this.f336281h + ", mSessions=" + this.f336282i + '}';
    }

    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f336274a.f336287b;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f336274a.f336295j;
    }

    public LookupExtra w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LookupExtra) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f336274a.f336290e;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f336274a.f336298m;
    }

    public Selector y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Selector) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f336280g;
    }

    public List<i.b> z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        List<i.b> list = this.f336282i;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("mSessions".concat(" is not initialized yet"));
    }
}
