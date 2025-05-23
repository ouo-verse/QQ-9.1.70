package com.tencent.ams.fusion.service.c.a;

import com.tencent.ams.fusion.a.f;
import com.tencent.ams.fusion.a.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kt.d;
import kt.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a<T extends d, R extends e> implements kt.b<T, R> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<kt.b<?, ?>> f70246a;

    /* renamed from: b, reason: collision with root package name */
    private final Lock f70247b;

    /* renamed from: c, reason: collision with root package name */
    private final Condition f70248c;

    /* renamed from: d, reason: collision with root package name */
    private long f70249d;

    /* renamed from: e, reason: collision with root package name */
    private kt.a<R> f70250e;

    /* renamed from: f, reason: collision with root package name */
    private String f70251f;

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f70246a = new ArrayList<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f70247b = reentrantLock;
        this.f70248c = reentrantLock.newCondition();
        this.f70249d = Long.MAX_VALUE;
        this.f70251f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v4, types: [kt.e] */
    public void d(kt.a<R> aVar, kt.b<?, ?> bVar) {
        long c16;
        String str;
        if (bVar == null) {
            return;
        }
        f.i(bVar.b() + " onPreExecute");
        if (aVar != null) {
            aVar.a(bVar);
        }
        f.i("ParallelTask execute " + bVar.getClass().getSimpleName());
        ?? c17 = bVar.c();
        if (c17 == 0) {
            c16 = -1;
        } else {
            c16 = c17.c();
        }
        if (c16 > -1) {
            str = " timeCost:" + c16;
        } else {
            str = "";
        }
        f.i(bVar.b() + " onAfterExecute" + str);
        if (aVar != null) {
            aVar.b(bVar, c17);
        }
    }

    private void e(kt.a<R> aVar, lt.a aVar2, kt.b<?, ?> bVar) {
        if (aVar2 == null) {
            f.i("threadService is null");
        } else {
            aVar2.b(new Runnable(aVar, bVar) { // from class: com.tencent.ams.fusion.service.c.a.a.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ kt.a f70252d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ kt.b f70253e;

                {
                    this.f70252d = aVar;
                    this.f70253e = bVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, a.this, aVar, bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        a.this.d(this.f70252d, this.f70253e);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f70247b.lock();
        try {
            this.f70248c.signalAll();
        } finally {
            this.f70247b.unlock();
        }
    }

    @Override // kt.c
    public R c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (R) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        lt.a g16 = com.tencent.ams.fusion.service.b.b().g();
        if (g16 == null) {
            f.i("threadService is null");
            return null;
        }
        if (j.b(this.f70246a)) {
            f.i("mActivityTasks is empty");
            return null;
        }
        kt.a<R> aVar = this.f70250e;
        if (aVar != null) {
            aVar.a();
        }
        this.f70247b.lock();
        Iterator<kt.b<?, ?>> it = this.f70246a.iterator();
        while (it.hasNext()) {
            kt.b<?, ?> next = it.next();
            if (next != null) {
                e(this.f70250e, g16, next);
            }
        }
        try {
            if (this.f70250e != null) {
                try {
                    long j3 = this.f70249d;
                    if (j3 == Long.MAX_VALUE) {
                        this.f70248c.await();
                    } else {
                        this.f70248c.await(j3, TimeUnit.MILLISECONDS);
                    }
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            kt.a<R> aVar2 = this.f70250e;
            if (aVar2 != null) {
                return aVar2.c();
            }
            return null;
        } finally {
            this.f70247b.unlock();
        }
    }

    public void f(kt.b<?, ?> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else if (bVar != null) {
            this.f70246a.add(bVar);
        }
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = this.f70251f;
        return str == null ? "ParallelTask" : str;
    }

    public void c(kt.a<R> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f70250e = aVar;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        }
    }
}
