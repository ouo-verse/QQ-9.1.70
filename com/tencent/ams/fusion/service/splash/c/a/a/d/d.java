package com.tencent.ams.fusion.service.splash.c.a.a.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final List<pt.a> f70464d;

    /* renamed from: e, reason: collision with root package name */
    private final List<pt.c> f70465e;

    /* renamed from: f, reason: collision with root package name */
    private volatile pt.c f70466f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f70467g;

    /* renamed from: h, reason: collision with root package name */
    private int f70468h;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70464d = new CopyOnWriteArrayList();
        this.f70465e = new CopyOnWriteArrayList();
        this.f70467g = com.tencent.ams.fusion.service.splash.a.a.d().x();
        this.f70468h = 0;
    }

    private synchronized ot.d B() {
        ot.d a16;
        boolean z16 = true;
        int i3 = 4;
        int i16 = -1;
        for (int i17 = 0; i17 < this.f70465e.size(); i17++) {
            pt.c cVar = this.f70465e.get(i17);
            if (cVar != null && (a16 = cVar.a()) != null) {
                int d16 = a16.d();
                if (d16 == 3 && a16.a() == null && (a16 instanceof com.tencent.ams.fusion.service.splash.c.a.a.c.b.b) && ((com.tencent.ams.fusion.service.splash.c.a.a.c.b.b) a16).l() == 64) {
                    z16 = this.f70467g;
                    com.tencent.ams.fusion.a.f.g("real time select timeout canUseLocal :" + z16);
                }
                com.tencent.ams.fusion.a.f.a("ParallelSelectOrderTask getSelectOrderResponse currentType :" + d16 + ",needContinue " + a16.b());
                if (d16 != -1 && d16 <= i3 && (a16.a() != null || a16.g())) {
                    i16 = i17;
                    i3 = d16;
                }
            }
        }
        if (i3 == 4 && !z16) {
            com.tencent.ams.fusion.a.f.g("local select has result and can not use.");
            return null;
        }
        if (i16 >= 0) {
            this.f70466f = this.f70465e.get(i16);
            if (this.f70466f != null) {
                return this.f70466f.a();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(pt.c cVar) {
        if (cVar != null && cVar.a() != null && cVar.a().a() != null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a, pt.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        for (pt.a aVar : this.f70464d) {
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a, pt.a
    public synchronized pt.c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (pt.c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f70466f == null) {
            B();
        }
        return this.f70466f;
    }

    @Override // pt.a
    public int d() {
        ot.d a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        pt.c cVar = this.f70466f;
        if (cVar != null && (a16 = cVar.a()) != null) {
            return a16.d();
        }
        return -1;
    }

    @Override // pt.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        synchronized (this.f70464d) {
            for (pt.a aVar : this.f70464d) {
                if (aVar != null) {
                    this.f70468h = aVar.e() | this.f70468h;
                }
            }
        }
        return this.f70468h;
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a
    protected ot.d r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ot.d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        pt.b s16 = s();
        if (s16 == null) {
            return a(1);
        }
        if (s16.a() == null) {
            return a(1);
        }
        List<pt.a> list = this.f70464d;
        if (list != null && list.size() != 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.f70464d);
            int size = copyOnWriteArrayList.size();
            CountDownLatch countDownLatch = new CountDownLatch(size);
            for (int i3 = 1; i3 < size; i3++) {
                pt.a aVar = (pt.a) copyOnWriteArrayList.get(i3);
                if (aVar == null) {
                    countDownLatch.countDown();
                } else {
                    com.tencent.ams.fusion.service.b.b().g().b(new Runnable(aVar, countDownLatch) { // from class: com.tencent.ams.fusion.service.splash.c.a.a.d.d.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ pt.a f70469d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ CountDownLatch f70470e;

                        {
                            this.f70469d = aVar;
                            this.f70470e = countDownLatch;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, d.this, aVar, countDownLatch);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            pt.c c16 = this.f70469d.c();
                            synchronized (d.this.f70464d) {
                                if (d.this.x(c16)) {
                                    d.this.f70468h |= this.f70469d.e();
                                }
                                d.this.f70465e.add(c16);
                                d.this.z(this.f70469d);
                            }
                            this.f70470e.countDown();
                        }
                    });
                }
            }
            pt.a aVar2 = (pt.a) copyOnWriteArrayList.get(0);
            if (aVar2 != null) {
                pt.c c16 = aVar2.c();
                synchronized (this.f70464d) {
                    if (x(c16)) {
                        this.f70468h |= aVar2.e();
                    }
                    this.f70465e.add(c16);
                    z(aVar2);
                }
            }
            countDownLatch.countDown();
            try {
                countDownLatch.await(com.tencent.ams.fusion.service.splash.a.a.d().c(r0.h()), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                com.tencent.ams.fusion.a.f.d("ParallelSelectOrderTask execute error :", e16);
            }
            return B();
        }
        return null;
    }

    public boolean w(pt.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).booleanValue();
        }
        return this.f70464d.add(aVar);
    }

    public boolean z(pt.a aVar) {
        boolean remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).booleanValue();
        }
        synchronized (this.f70464d) {
            remove = this.f70464d.remove(aVar);
        }
        return remove;
    }
}
