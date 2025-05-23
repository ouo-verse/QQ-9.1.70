package com.tencent.ams.fusion.service.splash.c.a.a.d;

import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a implements pt.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private pt.b f70444a;

    /* renamed from: b, reason: collision with root package name */
    private pt.c f70445b;

    /* renamed from: c, reason: collision with root package name */
    protected long f70446c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // pt.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // pt.a
    public pt.c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f70445b : (pt.c) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ot.d d(SplashOrder splashOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ot.d) iPatchRedirector.redirect((short) 8, (Object) this, (Object) splashOrder);
        }
        return e(splashOrder, Integer.MIN_VALUE);
    }

    protected ot.d e(SplashOrder splashOrder, int... iArr) {
        com.tencent.ams.fusion.service.splash.c.a.a.c.a.a[] aVarArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ot.d) iPatchRedirector.redirect((short) 9, (Object) this, (Object) splashOrder, (Object) iArr);
        }
        if (iArr != null) {
            aVarArr = new com.tencent.ams.fusion.service.splash.c.a.a.c.a.a[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                com.tencent.ams.fusion.service.splash.c.a.a.c.a.a aVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.a.a();
                aVar.b(iArr[i3]);
                aVar.d(Integer.MIN_VALUE);
                aVarArr[i3] = aVar;
            }
        } else {
            aVarArr = null;
        }
        return f(splashOrder, aVarArr);
    }

    protected ot.d f(SplashOrder splashOrder, com.tencent.ams.fusion.service.splash.c.a.a.c.a.a... aVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ot.d) iPatchRedirector.redirect((short) 10, (Object) this, (Object) splashOrder, (Object) aVarArr);
        }
        com.tencent.ams.fusion.service.splash.c.a.a.c.b.b bVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
        bVar.e(false);
        bVar.b(d());
        ArrayList arrayList = new ArrayList();
        arrayList.add(splashOrder);
        bVar.d(arrayList);
        if (!j.d(aVarArr)) {
            bVar.j(Arrays.asList(aVarArr));
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ot.d j(List<SplashOrder> list, List<com.tencent.ams.fusion.service.splash.c.a.a.c.a.a> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ot.d) iPatchRedirector.redirect((short) 11, (Object) this, (Object) list, (Object) list2);
        }
        com.tencent.ams.fusion.service.splash.c.a.a.c.b.b bVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
        bVar.e(false);
        bVar.b(d());
        bVar.d(list);
        if (!j.b(list2)) {
            bVar.j(list2);
        }
        return bVar;
    }

    protected pt.c k(ot.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (pt.c) iPatchRedirector.redirect((short) 13, (Object) this, (Object) dVar);
        }
        com.tencent.ams.fusion.service.splash.c.a.a.c.a aVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.a();
        aVar.b(dVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            m(null, i16, i3, Integer.MIN_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(SplashOrder splashOrder, int i3, int i16, int i17) {
        ot.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, splashOrder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f70446c;
        if (s() != null) {
            cVar = s().a();
        } else {
            cVar = null;
        }
        ot.b.a(cVar, splashOrder, i16, i3, currentTimeMillis, i17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(SplashOrder splashOrder, int i3, int i16, int i17, long j3) {
        ot.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, splashOrder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
            return;
        }
        if (s() != null) {
            cVar = s().a();
        } else {
            cVar = null;
        }
        ot.b.a(cVar, splashOrder, i16, i3, j3, i17);
    }

    public void o(pt.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bVar);
        } else {
            this.f70444a = bVar;
        }
    }

    protected pt.c p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (pt.c) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        com.tencent.ams.fusion.service.splash.c.a.a.c.b.b bVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
        bVar.f(i3);
        bVar.i(e());
        bVar.b(d());
        return k(bVar);
    }

    @Override // kt.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public pt.c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (pt.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        pt.b bVar = this.f70444a;
        if (bVar != null && bVar.a() != null) {
            this.f70446c = System.currentTimeMillis();
            ot.d r16 = r();
            if (r16 instanceof com.tencent.ams.fusion.service.splash.c.a.a.c.b.a) {
                ((com.tencent.ams.fusion.service.splash.c.a.a.c.b.a) r16).c(System.currentTimeMillis() - this.f70446c);
            }
            pt.c k3 = k(r16);
            this.f70445b = k3;
            return k3;
        }
        return p(1);
    }

    protected abstract ot.d r();

    /* JADX INFO: Access modifiers changed from: protected */
    public pt.b s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (pt.b) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f70444a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ot.d a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? b(i3, Integer.MIN_VALUE, Integer.MIN_VALUE, false) : (ot.d) iPatchRedirector.redirect((short) 5, (Object) this, i3);
    }

    protected ot.d b(int i3, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? c(i3, i16, i17, z16, true) : (ot.d) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
    }

    protected ot.d c(int i3, int i16, int i17, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ot.d) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        com.tencent.ams.fusion.service.splash.c.a.a.c.b.b bVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
        bVar.f(i3);
        bVar.i(e());
        bVar.b(d());
        bVar.h(z16);
        bVar.e(z17);
        com.tencent.ams.fusion.service.splash.c.a.a.c.a.a aVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.a.a();
        aVar.b(i16);
        aVar.d(i17);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        bVar.j(arrayList);
        return bVar;
    }
}
