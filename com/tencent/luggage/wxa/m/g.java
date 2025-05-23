package com.tencent.luggage.wxa.m;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.luggage.wxa.d0.h;
import com.tencent.luggage.wxa.m.e;
import com.tencent.luggage.wxa.m.h;
import com.tencent.luggage.wxa.m.q;
import com.tencent.luggage.wxa.m.u;
import com.tencent.luggage.wxa.n0.v;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements e {

    /* renamed from: a, reason: collision with root package name */
    public final r[] f133822a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k0.h f133823b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k0.g f133824c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f133825d;

    /* renamed from: e, reason: collision with root package name */
    public final h f133826e;

    /* renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet f133827f;

    /* renamed from: g, reason: collision with root package name */
    public final u.c f133828g;

    /* renamed from: h, reason: collision with root package name */
    public final u.b f133829h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f133830i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f133831j;

    /* renamed from: k, reason: collision with root package name */
    public int f133832k;

    /* renamed from: l, reason: collision with root package name */
    public int f133833l;

    /* renamed from: m, reason: collision with root package name */
    public int f133834m;

    /* renamed from: n, reason: collision with root package name */
    public int f133835n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f133836o;

    /* renamed from: p, reason: collision with root package name */
    public u f133837p;

    /* renamed from: q, reason: collision with root package name */
    public Object f133838q;

    /* renamed from: r, reason: collision with root package name */
    public com.tencent.luggage.wxa.d0.o f133839r;

    /* renamed from: s, reason: collision with root package name */
    public com.tencent.luggage.wxa.k0.g f133840s;

    /* renamed from: t, reason: collision with root package name */
    public p f133841t;

    /* renamed from: u, reason: collision with root package name */
    public h.b f133842u;

    /* renamed from: v, reason: collision with root package name */
    public int f133843v;

    /* renamed from: w, reason: collision with root package name */
    public int f133844w;

    /* renamed from: x, reason: collision with root package name */
    public long f133845x;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            g.this.a(message);
        }
    }

    public g(r[] rVarArr, com.tencent.luggage.wxa.k0.h hVar, m mVar) {
        boolean z16;
        Looper mainLooper;
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.5.4] [" + v.f135107e + "]");
        if (rVarArr.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        this.f133822a = (r[]) com.tencent.luggage.wxa.n0.a.a(rVarArr);
        this.f133823b = (com.tencent.luggage.wxa.k0.h) com.tencent.luggage.wxa.n0.a.a(hVar);
        this.f133831j = false;
        this.f133832k = 0;
        this.f133833l = 1;
        this.f133827f = new CopyOnWriteArraySet();
        com.tencent.luggage.wxa.k0.g gVar = new com.tencent.luggage.wxa.k0.g(new com.tencent.luggage.wxa.k0.f[rVarArr.length]);
        this.f133824c = gVar;
        this.f133837p = u.f133925a;
        this.f133828g = new u.c();
        this.f133829h = new u.b();
        this.f133839r = com.tencent.luggage.wxa.d0.o.f124051d;
        this.f133840s = gVar;
        this.f133841t = p.f133919d;
        if (Looper.myLooper() != null) {
            mainLooper = Looper.myLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        a aVar = new a(mainLooper);
        this.f133825d = aVar;
        h.b bVar = new h.b(0, 0L);
        this.f133842u = bVar;
        this.f133826e = new h(rVarArr, hVar, mVar, this.f133831j, this.f133832k, aVar, bVar, this);
    }

    @Override // com.tencent.luggage.wxa.m.q
    public void a(q.a aVar) {
        this.f133827f.remove(aVar);
    }

    @Override // com.tencent.luggage.wxa.m.q
    public void b(q.a aVar) {
        this.f133827f.add(aVar);
    }

    @Override // com.tencent.luggage.wxa.m.q
    public int c() {
        return this.f133833l;
    }

    public long d() {
        if (!this.f133837p.c() && this.f133834m <= 0) {
            return b(this.f133842u.f133881e);
        }
        return this.f133845x;
    }

    public int e() {
        if (!this.f133837p.c() && this.f133834m <= 0) {
            return this.f133837p.a(this.f133842u.f133877a.f123995a, this.f133829h).f133928c;
        }
        return this.f133843v;
    }

    public boolean f() {
        if (!this.f133837p.c() && this.f133834m == 0 && this.f133842u.f133877a.a()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.m.q
    public long getCurrentPosition() {
        if (!this.f133837p.c() && this.f133834m <= 0) {
            return b(this.f133842u.f133880d);
        }
        return this.f133845x;
    }

    @Override // com.tencent.luggage.wxa.m.q
    public long getDuration() {
        if (this.f133837p.c()) {
            return -9223372036854775807L;
        }
        if (f()) {
            h.b bVar = this.f133842u.f133877a;
            this.f133837p.a(bVar.f123995a, this.f133829h);
            return b.b(this.f133829h.a(bVar.f123996b, bVar.f123997c));
        }
        return this.f133837p.a(e(), this.f133828g).b();
    }

    @Override // com.tencent.luggage.wxa.m.q
    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.5.4] [" + v.f135107e + "] [" + i.a() + "]");
        this.f133826e.f();
        this.f133825d.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.luggage.wxa.m.q
    public void stop() {
        this.f133826e.j();
    }

    @Override // com.tencent.luggage.wxa.m.e
    public void a(com.tencent.luggage.wxa.d0.h hVar) {
        a(hVar, true, true);
    }

    @Override // com.tencent.luggage.wxa.m.q
    public boolean b() {
        return this.f133831j;
    }

    public void a(com.tencent.luggage.wxa.d0.h hVar, boolean z16, boolean z17) {
        if (z17) {
            if (!this.f133837p.c() || this.f133838q != null) {
                this.f133837p = u.f133925a;
                this.f133838q = null;
                Iterator it = this.f133827f.iterator();
                while (it.hasNext()) {
                    ((q.a) it.next()).a(this.f133837p, this.f133838q);
                }
            }
            if (this.f133830i) {
                this.f133830i = false;
                this.f133839r = com.tencent.luggage.wxa.d0.o.f124051d;
                this.f133840s = this.f133824c;
                this.f133823b.a((Object) null);
                Iterator it5 = this.f133827f.iterator();
                while (it5.hasNext()) {
                    ((q.a) it5.next()).a(this.f133839r, this.f133840s);
                }
            }
        }
        this.f133835n++;
        this.f133826e.a(hVar, z16);
    }

    @Override // com.tencent.luggage.wxa.m.e
    public void b(e.c... cVarArr) {
        this.f133826e.a(cVarArr);
    }

    public final long b(long j3) {
        long b16 = b.b(j3);
        if (this.f133842u.f133877a.a()) {
            return b16;
        }
        this.f133837p.a(this.f133842u.f133877a.f123995a, this.f133829h);
        return b16 + this.f133829h.e();
    }

    @Override // com.tencent.luggage.wxa.m.q
    public void a(boolean z16) {
        if (this.f133831j != z16) {
            this.f133831j = z16;
            this.f133826e.c(z16);
            Iterator it = this.f133827f.iterator();
            while (it.hasNext()) {
                ((q.a) it.next()).a(z16, this.f133833l);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.m.q
    public void a(long j3) {
        a(e(), j3);
    }

    public void a(int i3, long j3) {
        if (i3 >= 0 && (this.f133837p.c() || i3 < this.f133837p.b())) {
            this.f133834m++;
            this.f133843v = i3;
            if (this.f133837p.c()) {
                this.f133844w = 0;
            } else {
                this.f133837p.a(i3, this.f133828g);
                long a16 = j3 == -9223372036854775807L ? this.f133828g.a() : b.a(j3);
                u.c cVar = this.f133828g;
                int i16 = cVar.f133942f;
                long c16 = cVar.c() + a16;
                long d16 = this.f133837p.a(i16, this.f133829h).d();
                while (d16 != -9223372036854775807L && c16 >= d16 && i16 < this.f133828g.f133943g) {
                    c16 -= d16;
                    i16++;
                    d16 = this.f133837p.a(i16, this.f133829h).d();
                }
                this.f133844w = i16;
            }
            if (j3 == -9223372036854775807L) {
                this.f133845x = 0L;
                this.f133826e.a(this.f133837p, i3, -9223372036854775807L);
                return;
            }
            this.f133845x = j3;
            this.f133826e.a(this.f133837p, i3, b.a(j3));
            Iterator it = this.f133827f.iterator();
            while (it.hasNext()) {
                ((q.a) it.next()).a();
            }
            return;
        }
        throw new l(this.f133837p, i3, j3);
    }

    @Override // com.tencent.luggage.wxa.m.q
    public void a(p pVar) {
        if (pVar == null) {
            pVar = p.f133919d;
        }
        this.f133826e.a(pVar);
    }

    @Override // com.tencent.luggage.wxa.m.e
    public void a(e.c... cVarArr) {
        this.f133826e.b(cVarArr);
    }

    @Override // com.tencent.luggage.wxa.m.q
    public int a() {
        if (this.f133837p.c()) {
            return 0;
        }
        long d16 = d();
        long duration = getDuration();
        if (d16 == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return v.a((int) ((d16 * 100) / duration), 0, 100);
    }

    public void a(Message message) {
        switch (message.what) {
            case 0:
                this.f133835n--;
                return;
            case 1:
                this.f133833l = message.arg1;
                Iterator it = this.f133827f.iterator();
                while (it.hasNext()) {
                    ((q.a) it.next()).a(this.f133831j, this.f133833l);
                }
                return;
            case 2:
                this.f133836o = message.arg1 != 0;
                Iterator it5 = this.f133827f.iterator();
                while (it5.hasNext()) {
                    ((q.a) it5.next()).a(this.f133836o);
                }
                return;
            case 3:
                if (this.f133835n == 0) {
                    com.tencent.luggage.wxa.k0.i iVar = (com.tencent.luggage.wxa.k0.i) message.obj;
                    this.f133830i = true;
                    this.f133839r = iVar.f131409a;
                    this.f133840s = iVar.f131410b;
                    this.f133823b.a(iVar.f131411c);
                    Iterator it6 = this.f133827f.iterator();
                    while (it6.hasNext()) {
                        ((q.a) it6.next()).a(this.f133839r, this.f133840s);
                    }
                    return;
                }
                return;
            case 4:
                int i3 = this.f133834m - 1;
                this.f133834m = i3;
                if (i3 == 0) {
                    this.f133842u = (h.b) message.obj;
                    if (this.f133837p.c()) {
                        this.f133844w = 0;
                        this.f133843v = 0;
                        this.f133845x = 0L;
                    }
                    if (message.arg1 != 0) {
                        Iterator it7 = this.f133827f.iterator();
                        while (it7.hasNext()) {
                            ((q.a) it7.next()).a();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.f133834m == 0) {
                    this.f133842u = (h.b) message.obj;
                    Iterator it8 = this.f133827f.iterator();
                    while (it8.hasNext()) {
                        ((q.a) it8.next()).a();
                    }
                    return;
                }
                return;
            case 6:
                h.d dVar = (h.d) message.obj;
                int i16 = this.f133834m - dVar.f133888d;
                this.f133834m = i16;
                if (this.f133835n == 0) {
                    u uVar = dVar.f133885a;
                    this.f133837p = uVar;
                    this.f133838q = dVar.f133886b;
                    this.f133842u = dVar.f133887c;
                    if (i16 == 0 && uVar.c()) {
                        this.f133844w = 0;
                        this.f133843v = 0;
                        this.f133845x = 0L;
                    }
                    Iterator it9 = this.f133827f.iterator();
                    while (it9.hasNext()) {
                        ((q.a) it9.next()).a(this.f133837p, this.f133838q);
                    }
                    return;
                }
                return;
            case 7:
                p pVar = (p) message.obj;
                if (this.f133841t.equals(pVar)) {
                    return;
                }
                this.f133841t = pVar;
                Iterator it10 = this.f133827f.iterator();
                while (it10.hasNext()) {
                    ((q.a) it10.next()).a(pVar);
                }
                return;
            case 8:
                d dVar2 = (d) message.obj;
                Iterator it11 = this.f133827f.iterator();
                while (it11.hasNext()) {
                    ((q.a) it11.next()).a(dVar2);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
