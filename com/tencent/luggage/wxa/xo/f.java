package com.tencent.luggage.wxa.xo;

import android.util.Pair;
import com.tencent.luggage.wxa.ap.k;
import com.tencent.luggage.wxa.xo.d;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.yo.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f implements com.tencent.luggage.wxa.xo.d {
    public com.tencent.luggage.wxa.yo.d E;
    public List H;
    public List I;
    public List J;
    public Object N;
    public Object O;
    public Object P;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f145201g;

    /* renamed from: h, reason: collision with root package name */
    public volatile Object f145202h;

    /* renamed from: i, reason: collision with root package name */
    public volatile Object f145203i;

    /* renamed from: j, reason: collision with root package name */
    public g f145204j;

    /* renamed from: k, reason: collision with root package name */
    public g f145205k;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f145195a = false;

    /* renamed from: b, reason: collision with root package name */
    public volatile j f145196b = j.Idle;

    /* renamed from: c, reason: collision with root package name */
    public boolean f145197c = false;

    /* renamed from: d, reason: collision with root package name */
    public Queue f145198d = new LinkedList();

    /* renamed from: l, reason: collision with root package name */
    public int f145206l = 0;

    /* renamed from: m, reason: collision with root package name */
    public long f145207m = -1;
    public boolean C = false;
    public com.tencent.luggage.wxa.xo.b D = new h();
    public e.b G = new a();
    public boolean K = false;
    public boolean L = false;
    public boolean M = false;

    /* renamed from: f, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.yo.d f145200f = com.tencent.luggage.wxa.yo.f.a();

    /* renamed from: e, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.yo.d f145199e = this.f145200f;
    public com.tencent.luggage.wxa.yo.e F = new com.tencent.luggage.wxa.yo.e(this.f145200f, this.G);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f145209b;

        public b(d.a aVar) {
            this.f145209b = aVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public Object call(Object obj) {
            return this.f145209b.call();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f145211a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f145212b;

        public c(Pair pair, Object obj) {
            this.f145211a = pair;
            this.f145212b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((e.a) this.f145211a.first).a(this.f145212b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f145214a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f145215b;

        public d(Pair pair, Object obj) {
            this.f145214a = pair;
            this.f145215b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((e.b) this.f145214a.first).a(this.f145215b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair f145217b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f145218c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f145219d;

        public e(Pair pair, Object obj, RuntimeException runtimeException) {
            this.f145217b = pair;
            this.f145218c = obj;
            this.f145219d = runtimeException;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(Void r26) {
            try {
                ((e.c) this.f145217b.first).a(this.f145218c);
                return com.tencent.luggage.wxa.uo.b.f142835a;
            } catch (ClassCastException e16) {
                if (this.f145219d.getCause() == null) {
                    this.f145219d.initCause(e16);
                }
                throw this.f145219d;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xo.f$f, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC6924f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uo.b f145221a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f145222b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f145223c;

        public RunnableC6924f(com.tencent.luggage.wxa.uo.b bVar, Object obj, boolean z16) {
            this.f145221a = bVar;
            this.f145222b = obj;
            this.f145223c = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.F.a(this.f145221a, this.f145222b, this.f145223c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.uo.b f145225a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.luggage.wxa.yo.d f145226b;

        /* renamed from: c, reason: collision with root package name */
        public long f145227c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f145228d;

        public g(com.tencent.luggage.wxa.uo.b bVar, com.tencent.luggage.wxa.yo.d dVar, long j3, boolean z16) {
            this.f145225a = bVar;
            this.f145226b = dVar;
            this.f145227c = j3;
            this.f145228d = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class i extends Error {
        public i(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum j {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone
    }

    @Override // com.tencent.luggage.wxa.xo.e
    public void stop() {
        a(true);
    }

    @Override // com.tencent.luggage.wxa.xo.d
    public com.tencent.luggage.wxa.xo.d d(com.tencent.luggage.wxa.uo.b bVar) {
        return b("Vending.HEAVY_WORK").b(bVar);
    }

    @Override // com.tencent.luggage.wxa.xo.d
    public com.tencent.luggage.wxa.xo.b e() {
        return this.D;
    }

    public final synchronized Object f() {
        return this.f145202h;
    }

    @Override // com.tencent.luggage.wxa.vo.a
    public void g() {
        stop();
    }

    public final synchronized Object h() {
        Object obj;
        obj = this.f145202h;
        this.f145203i = this.f145202h;
        this.f145202h = null;
        this.f145201g = false;
        com.tencent.luggage.wxa.wo.a.a("Vending.Pipeline", "pop input(%s)", c(obj));
        return obj;
    }

    public final void i() {
        ((LinkedList) this.f145198d).add(0, this.f145204j);
        b(this.f145203i);
    }

    public final synchronized void j() {
        if (this.f145197c) {
            this.f145206l++;
            com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "Functional %s, gonna retry %s.", this.f145204j.f145225a.toString(), Integer.valueOf(this.f145206l));
            this.f145197c = false;
            i();
        } else {
            this.f145206l = 0;
        }
    }

    public final com.tencent.luggage.wxa.xo.e k() {
        this.f145195a = true;
        return this;
    }

    public final void d() {
        j jVar = this.f145196b;
        j jVar2 = j.Resolved;
        if (jVar != jVar2) {
            return;
        }
        this.f145196b = j.Invoking;
        g gVar = (g) this.f145198d.peek();
        if (gVar == null) {
            if (this.f145195a) {
                this.f145196b = j.AllDone;
                this.N = h();
                this.K = true;
                List list = this.J;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        c((Pair) it.next(), this.N);
                    }
                    return;
                }
                return;
            }
            this.f145196b = jVar2;
            return;
        }
        com.tencent.luggage.wxa.uo.b bVar = gVar.f145225a;
        com.tencent.luggage.wxa.yo.d dVar = gVar.f145226b;
        long j3 = gVar.f145227c;
        boolean z16 = gVar.f145228d;
        if (this.f145196b == j.Pausing) {
            com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeueFunctionAndInvoke and waiting resume() call", new Object[0]);
            return;
        }
        this.f145205k = (g) this.f145198d.poll();
        this.F.a(dVar);
        Object h16 = h();
        if (j3 < 0) {
            this.F.a(bVar, h16, z16);
            return;
        }
        com.tencent.luggage.wxa.yo.d a16 = com.tencent.luggage.wxa.yo.f.a();
        this.E = a16;
        a16.a(new RunnableC6924f(bVar, h16, z16), j3);
    }

    @Override // com.tencent.luggage.wxa.xo.d
    public com.tencent.luggage.wxa.xo.d c(com.tencent.luggage.wxa.uo.b bVar) {
        return b("Vending.LOGIC").b(bVar);
    }

    public final void c() {
        if (this.f145195a) {
            throw new i("This Pipeline(%s) has terminate and do not allow any next().", this);
        }
    }

    @Override // com.tencent.luggage.wxa.xo.d
    public com.tencent.luggage.wxa.xo.d b(String str) {
        if (str == null) {
            com.tencent.luggage.wxa.er.a.a("schedulerTypeString should not be null!", (Object) str);
            return this;
        }
        this.f145199e = com.tencent.luggage.wxa.yo.f.a(str);
        com.tencent.luggage.wxa.er.a.a("mCurrentScheduler should not be null!", (Object) this.f145199e);
        return this;
    }

    public final void c(Pair pair, Object obj) {
        new com.tencent.luggage.wxa.yo.e((com.tencent.luggage.wxa.yo.d) pair.second, null).a(new e(pair, obj, new RuntimeException("object is not right: " + obj)), null, this.C);
    }

    @Override // com.tencent.luggage.wxa.xo.d
    public com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.vo.b bVar) {
        com.tencent.luggage.wxa.er.a.a("keeper should not be null!", (Object) bVar);
        bVar.b(this);
        return this;
    }

    public static String c(Object obj) {
        if (obj != null) {
            return String.valueOf(obj.hashCode());
        }
        return null;
    }

    public final com.tencent.luggage.wxa.xo.d b(Object... objArr) {
        Object b16;
        if (this.f145196b != j.Idle) {
            return this;
        }
        this.f145196b = j.Resolved;
        if (objArr.length == 0) {
            b16 = null;
        } else {
            b16 = objArr.length == 1 ? objArr[0] : k.b(objArr);
        }
        b(b16);
        d();
        return this;
    }

    public synchronized com.tencent.luggage.wxa.xo.d a(d.a aVar) {
        b(new Object[0]);
        a((com.tencent.luggage.wxa.uo.b) new b(aVar), true);
        return this;
    }

    public synchronized com.tencent.luggage.wxa.xo.d a(Object... objArr) {
        return b(objArr);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements com.tencent.luggage.wxa.xo.b {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.xo.b
        public void a(Object obj) {
            synchronized (f.this) {
                if (f.this.f145196b != j.Interrupted) {
                    if (f.this.b() || f.this.f145196b == j.Pausing) {
                        com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "interrupt Pipeline(%s)", f.this);
                        f.this.a(false);
                        f.this.L = true;
                        f.this.O = obj;
                        if (f.this.I != null) {
                            Iterator it = f.this.I.iterator();
                            while (it.hasNext()) {
                                f.this.a((Pair) it.next(), obj);
                            }
                        }
                        return;
                    }
                    com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
                    return;
                }
                com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
            }
        }

        @Override // com.tencent.luggage.wxa.xo.b
        public void b(Object obj) {
            synchronized (f.this) {
                if (f.this.f145196b != j.Interrupted) {
                    if (f.this.b() || f.this.f145196b == j.Pausing) {
                        f.this.M = true;
                        f.this.P = obj;
                        if (f.this.H != null) {
                            Iterator it = f.this.H.iterator();
                            while (it.hasNext()) {
                                f.this.b((Pair) it.next(), obj);
                            }
                        }
                        return;
                    }
                    com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "progress not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
                    return;
                }
                com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "interrupted, skip this progress.", new Object[0]);
            }
        }

        public final void c() {
            synchronized (f.this) {
                if (f.this.f145196b != j.Interrupted && f.this.f145196b != j.Idle) {
                    if (!f.this.b()) {
                        com.tencent.luggage.wxa.wo.a.b("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", f.this);
                        return;
                    } else if (f.this.a()) {
                        f.this.f145196b = j.Pausing;
                        return;
                    } else {
                        com.tencent.luggage.wxa.wo.a.b("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", f.this);
                        return;
                    }
                }
                com.tencent.luggage.wxa.wo.a.d("Vending.Pipeline", "current is state(%s), ignore pause.", f.this.f145196b);
            }
        }

        @Override // com.tencent.luggage.wxa.xo.b
        public void b() {
            synchronized (f.this) {
                c();
            }
        }

        @Override // com.tencent.luggage.wxa.xo.b
        public void a(Object... objArr) {
            Object b16;
            synchronized (f.this) {
                if (f.this.f145196b != j.Pausing) {
                    com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "state is not pausing %s, skip this wormhole", f.this.f145196b);
                    return;
                }
                f fVar = f.this;
                if (objArr.length == 0) {
                    b16 = null;
                } else {
                    b16 = objArr.length == 1 ? objArr[0] : k.b(objArr);
                }
                fVar.b(b16);
                f fVar2 = f.this;
                com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "pipline(%s) wormhole(%s).", fVar2, f.c(fVar2.f()));
                a();
            }
        }

        @Override // com.tencent.luggage.wxa.xo.b
        public void a() {
            synchronized (f.this) {
                if (f.this.f145196b != j.Pausing) {
                    com.tencent.luggage.wxa.wo.a.b("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", f.this);
                    return;
                }
                if (!f.this.b()) {
                    f.this.f145196b = j.Resolved;
                } else {
                    f.this.f145196b = j.Invoking;
                }
                f.this.j();
                if (!f.this.a()) {
                    f.this.d();
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xo.d
    public com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.uo.b bVar) {
        return b("Vending.UI").b(bVar);
    }

    public final com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.uo.b bVar, boolean z16) {
        c();
        this.f145198d.add(new g(bVar, this.f145199e, this.f145207m, z16));
        this.f145207m = -1L;
        if (this.f145196b == j.Idle || this.f145196b != j.Resolved) {
            return this;
        }
        d();
        return this;
    }

    @Override // com.tencent.luggage.wxa.xo.d
    public synchronized com.tencent.luggage.wxa.xo.d b(com.tencent.luggage.wxa.uo.b bVar) {
        return a(bVar, this.C);
    }

    public final void b(Pair pair, Object obj) {
        a((com.tencent.luggage.wxa.yo.d) pair.second, new d(pair, obj));
    }

    public final synchronized void b(Object obj) {
        this.f145202h = obj;
        this.f145201g = true;
        com.tencent.luggage.wxa.wo.a.a("Vending.Pipeline", "set input(%s)", c(obj));
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements e.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.yo.e.b
        public void a(Object obj) {
            com.tencent.luggage.wxa.xo.g.a().c();
            synchronized (f.this) {
                f fVar = f.this;
                fVar.f145204j = fVar.f145205k;
                f.this.f145205k = null;
                if (!f.this.f145201g) {
                    f.this.b(obj);
                }
                if (f.this.f145197c) {
                    com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                }
                if (f.this.f145196b != j.Interrupted) {
                    if (f.this.f145196b == j.Pausing) {
                        com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "pausing, just return.", new Object[0]);
                        return;
                    }
                    com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "last one resolved, dequeue next.", new Object[0]);
                    f.this.f145196b = j.Resolved;
                    f.this.j();
                    f.this.d();
                    return;
                }
                com.tencent.luggage.wxa.wo.a.c("Vending.Pipeline", "interrupted, just return", new Object[0]);
            }
        }

        @Override // com.tencent.luggage.wxa.yo.e.b
        public void b() {
            com.tencent.luggage.wxa.xo.g.a().a(f.this);
        }

        @Override // com.tencent.luggage.wxa.yo.e.b
        public void a() {
            f.this.a(true);
        }
    }

    public final void a(Pair pair, Object obj) {
        a((com.tencent.luggage.wxa.yo.d) pair.second, new c(pair, obj));
    }

    public final boolean b() {
        return this.f145205k != null;
    }

    public final void a(e.b bVar, com.tencent.luggage.wxa.yo.d dVar) {
        k();
        if (this.H == null) {
            this.H = new LinkedList();
        }
        Pair pair = new Pair(bVar, dVar);
        this.H.add(new Pair(bVar, dVar));
        if (this.M) {
            b(pair, this.P);
        }
    }

    public final void a(e.a aVar, com.tencent.luggage.wxa.yo.d dVar) {
        k();
        if (this.I == null) {
            this.I = new LinkedList();
        }
        Pair pair = new Pair(aVar, dVar);
        if (this.L) {
            a(pair, this.O);
        } else {
            this.I.add(pair);
        }
    }

    public final void a(e.c cVar, com.tencent.luggage.wxa.yo.d dVar) {
        k();
        d();
        if (this.J == null) {
            this.J = new LinkedList();
        }
        Pair pair = new Pair(cVar, dVar);
        if (this.K) {
            c(pair, this.N);
        } else {
            this.J.add(pair);
        }
    }

    @Override // com.tencent.luggage.wxa.xo.e
    public synchronized com.tencent.luggage.wxa.xo.e a(e.b bVar) {
        a(bVar, this.f145200f);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xo.e
    public synchronized com.tencent.luggage.wxa.xo.e a(e.a aVar) {
        a(aVar, this.f145200f);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xo.e
    public synchronized com.tencent.luggage.wxa.xo.e a(com.tencent.luggage.wxa.yo.d dVar, e.a aVar) {
        a(aVar, dVar);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xo.e
    public synchronized com.tencent.luggage.wxa.xo.e a(e.c cVar) {
        a(cVar, this.f145200f);
        return this;
    }

    @Override // com.tencent.luggage.wxa.xo.e
    public synchronized com.tencent.luggage.wxa.xo.e a(com.tencent.luggage.wxa.yo.d dVar, e.c cVar) {
        a(cVar, dVar);
        return this;
    }

    public final synchronized void a(boolean z16) {
        j jVar = this.f145196b;
        j jVar2 = j.Interrupted;
        if (jVar != jVar2 && this.f145196b != j.AllDone) {
            if (z16 && this.f145198d.size() > 0) {
                com.tencent.luggage.wxa.wo.a.d("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.f145198d.size()));
            }
            this.f145196b = jVar2;
            this.f145198d.clear();
            b((Object) null);
            com.tencent.luggage.wxa.yo.d dVar = this.E;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public final void a(com.tencent.luggage.wxa.yo.d dVar, Runnable runnable) {
        if (dVar == null) {
            com.tencent.luggage.wxa.wo.a.b("Vending.Pipeline", "Default scheduler %s is not available!!!", this.f145200f);
        } else {
            dVar.a(runnable);
        }
    }

    public final boolean a() {
        return this.D == com.tencent.luggage.wxa.xo.h.a();
    }
}
