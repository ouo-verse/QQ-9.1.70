package com.tencent.luggage.wxa.g0;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.luggage.wxa.d0.a;
import com.tencent.luggage.wxa.g0.a;
import com.tencent.luggage.wxa.g0.b;
import com.tencent.luggage.wxa.l0.r;
import com.tencent.luggage.wxa.l0.s;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements r.a {
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f126368a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.f0.d f126369b;

    /* renamed from: c, reason: collision with root package name */
    public final s.a f126370c;

    /* renamed from: d, reason: collision with root package name */
    public final int f126371d;

    /* renamed from: g, reason: collision with root package name */
    public final f f126374g;

    /* renamed from: j, reason: collision with root package name */
    public final a.C6124a f126377j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.g0.a f126378k;

    /* renamed from: l, reason: collision with root package name */
    public a.C6226a f126379l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.g0.b f126380m;

    /* renamed from: h, reason: collision with root package name */
    public final List f126375h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final r f126376i = new r("HlsPlaylistTracker:MasterPlaylist");

    /* renamed from: e, reason: collision with root package name */
    public final IdentityHashMap f126372e = new IdentityHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final Handler f126373f = new Handler();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b implements r.a, Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final a.C6226a f126381a;

        /* renamed from: b, reason: collision with root package name */
        public final r f126382b = new r("HlsPlaylistTracker:MediaPlaylist");

        /* renamed from: c, reason: collision with root package name */
        public final s f126383c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.g0.b f126384d;

        /* renamed from: e, reason: collision with root package name */
        public long f126385e;

        /* renamed from: f, reason: collision with root package name */
        public long f126386f;

        /* renamed from: g, reason: collision with root package name */
        public long f126387g;

        /* renamed from: h, reason: collision with root package name */
        public long f126388h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f126389i;

        /* renamed from: j, reason: collision with root package name */
        public IOException f126390j;

        public b(a.C6226a c6226a) {
            this.f126381a = c6226a;
            this.f126383c = new s(e.this.f126369b.a(4), u.b(e.this.f126378k.f126341a, c6226a.f126316a), 4, e.this.f126370c);
        }

        public boolean c() {
            int i3;
            if (this.f126384d == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, com.tencent.luggage.wxa.m.b.b(this.f126384d.f126331p));
            com.tencent.luggage.wxa.g0.b bVar = this.f126384d;
            if (!bVar.f126327l && (i3 = bVar.f126318c) != 2 && i3 != 1 && this.f126385e + max <= elapsedRealtime) {
                return false;
            }
            return true;
        }

        public void d() {
            this.f126388h = 0L;
            if (!this.f126389i && !this.f126382b.b()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.f126387g) {
                    this.f126389i = true;
                    e.this.f126373f.postDelayed(this, this.f126387g - elapsedRealtime);
                } else {
                    e();
                }
            }
        }

        public final void e() {
            this.f126382b.a(this.f126383c, this, e.this.f126371d);
        }

        public void f() {
            this.f126382b.c();
            IOException iOException = this.f126390j;
            if (iOException == null) {
            } else {
                throw iOException;
            }
        }

        public void g() {
            this.f126382b.d();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f126389i = false;
            e();
        }

        public com.tencent.luggage.wxa.g0.b b() {
            return this.f126384d;
        }

        @Override // com.tencent.luggage.wxa.l0.r.a
        public void a(s sVar, long j3, long j16) {
            com.tencent.luggage.wxa.g0.c cVar = (com.tencent.luggage.wxa.g0.c) sVar.e();
            if (cVar instanceof com.tencent.luggage.wxa.g0.b) {
                com.tencent.luggage.wxa.g0.b bVar = (com.tencent.luggage.wxa.g0.b) cVar;
                a(bVar);
                if (bVar.f126327l) {
                    e.this.f126377j.a();
                }
                e.this.f126377j.b(sVar.f132851a, 4, j3, j16, sVar.d());
                return;
            }
            this.f126390j = new o("Loaded playlist has unexpected type.");
        }

        @Override // com.tencent.luggage.wxa.l0.r.a
        public void a(s sVar, long j3, long j16, boolean z16) {
            e.this.f126377j.a(sVar.f132851a, 4, j3, j16, sVar.d());
        }

        @Override // com.tencent.luggage.wxa.l0.r.a
        public int a(s sVar, long j3, long j16, IOException iOException) {
            boolean z16 = iOException instanceof o;
            e.this.f126377j.a(sVar.f132851a, 4, j3, j16, sVar.d(), iOException, z16);
            if (z16) {
                return 3;
            }
            return com.tencent.luggage.wxa.e0.b.a(iOException) ? a() : true ? 0 : 2;
        }

        public final void a(com.tencent.luggage.wxa.g0.b bVar) {
            com.tencent.luggage.wxa.g0.b bVar2 = this.f126384d;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f126385e = elapsedRealtime;
            com.tencent.luggage.wxa.g0.b b16 = e.this.b(bVar2, bVar);
            this.f126384d = b16;
            if (b16 != bVar2) {
                this.f126390j = null;
                this.f126386f = elapsedRealtime;
                e.this.a(this.f126381a, b16);
            } else if (!b16.f126327l) {
                if (bVar.f126323h + bVar.f126330o.size() < this.f126384d.f126323h) {
                    this.f126390j = new d(this.f126381a.f126316a);
                } else if (elapsedRealtime - this.f126386f > com.tencent.luggage.wxa.m.b.b(r12.f126325j) * 3.5d) {
                    this.f126390j = new C6227e(this.f126381a.f126316a);
                    a();
                }
            }
            com.tencent.luggage.wxa.g0.b bVar3 = this.f126384d;
            long j3 = bVar3.f126325j;
            if (bVar3 == bVar2) {
                j3 /= 2;
            }
            this.f126387g = elapsedRealtime + com.tencent.luggage.wxa.m.b.b(j3);
            if (this.f126381a != e.this.f126379l || this.f126384d.f126327l) {
                return;
            }
            d();
        }

        public final boolean a() {
            this.f126388h = SystemClock.elapsedRealtime() + 60000;
            e.this.a(this.f126381a, 60000L);
            return e.this.f126379l == this.f126381a && !e.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(a.C6226a c6226a, long j3);

        void e();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final String f126392a;

        public d(String str) {
            this.f126392a = str;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g0.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6227e extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final String f126393a;

        public C6227e(String str) {
            this.f126393a = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        void a(com.tencent.luggage.wxa.g0.b bVar);
    }

    public e(Uri uri, com.tencent.luggage.wxa.f0.d dVar, a.C6124a c6124a, int i3, f fVar, s.a aVar) {
        this.f126368a = uri;
        this.f126369b = dVar;
        this.f126377j = c6124a;
        this.f126371d = i3;
        this.f126374g = fVar;
        this.f126370c = aVar;
    }

    public void b(c cVar) {
        this.f126375h.remove(cVar);
    }

    public final boolean c() {
        List list = this.f126378k.f126311c;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f126372e.get(list.get(i3));
            if (elapsedRealtime > bVar.f126388h) {
                this.f126379l = bVar.f126381a;
                bVar.d();
                return true;
            }
        }
        return false;
    }

    public void d() {
        this.f126376i.c();
        a.C6226a c6226a = this.f126379l;
        if (c6226a != null) {
            d(c6226a);
        }
    }

    public void e() {
        this.f126376i.d();
        Iterator it = this.f126372e.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).g();
        }
        this.f126373f.removeCallbacksAndMessages(null);
        this.f126372e.clear();
    }

    public void f() {
        this.f126376i.a(new s(this.f126369b.a(4), this.f126368a, 4, this.f126370c), this, this.f126371d);
    }

    public boolean b(a.C6226a c6226a) {
        return ((b) this.f126372e.get(c6226a)).c();
    }

    public boolean b() {
        return this.C;
    }

    public final com.tencent.luggage.wxa.g0.b b(com.tencent.luggage.wxa.g0.b bVar, com.tencent.luggage.wxa.g0.b bVar2) {
        if (bVar2.a(bVar)) {
            return bVar2.a(d(bVar, bVar2), c(bVar, bVar2));
        }
        return bVar2.f126327l ? bVar.a() : bVar;
    }

    public void d(a.C6226a c6226a) {
        ((b) this.f126372e.get(c6226a)).f();
    }

    public final long d(com.tencent.luggage.wxa.g0.b bVar, com.tencent.luggage.wxa.g0.b bVar2) {
        if (bVar2.f126328m) {
            return bVar2.f126320e;
        }
        com.tencent.luggage.wxa.g0.b bVar3 = this.f126380m;
        long j3 = bVar3 != null ? bVar3.f126320e : 0L;
        if (bVar == null) {
            return j3;
        }
        int size = bVar.f126330o.size();
        b.a a16 = a(bVar, bVar2);
        if (a16 != null) {
            return bVar.f126320e + a16.f126335d;
        }
        return size == bVar2.f126323h - bVar.f126323h ? bVar.b() : j3;
    }

    public void e(a.C6226a c6226a) {
        ((b) this.f126372e.get(c6226a)).d();
    }

    public void a(c cVar) {
        this.f126375h.add(cVar);
    }

    public com.tencent.luggage.wxa.g0.a a() {
        return this.f126378k;
    }

    public final void c(a.C6226a c6226a) {
        if (c6226a == this.f126379l || !this.f126378k.f126311c.contains(c6226a)) {
            return;
        }
        com.tencent.luggage.wxa.g0.b bVar = this.f126380m;
        if (bVar == null || !bVar.f126327l) {
            this.f126379l = c6226a;
            ((b) this.f126372e.get(c6226a)).d();
        }
    }

    public com.tencent.luggage.wxa.g0.b a(a.C6226a c6226a) {
        com.tencent.luggage.wxa.g0.b b16 = ((b) this.f126372e.get(c6226a)).b();
        if (b16 != null) {
            c(c6226a);
        }
        return b16;
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public void a(s sVar, long j3, long j16) {
        com.tencent.luggage.wxa.g0.a aVar;
        com.tencent.luggage.wxa.g0.c cVar = (com.tencent.luggage.wxa.g0.c) sVar.e();
        boolean z16 = cVar instanceof com.tencent.luggage.wxa.g0.b;
        if (z16) {
            if (((com.tencent.luggage.wxa.g0.b) cVar).f126327l) {
                this.f126377j.a();
            }
            aVar = com.tencent.luggage.wxa.g0.a.a(cVar.f126341a);
        } else {
            aVar = (com.tencent.luggage.wxa.g0.a) cVar;
        }
        this.f126378k = aVar;
        this.f126379l = (a.C6226a) aVar.f126311c.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.f126311c);
        arrayList.addAll(aVar.f126312d);
        arrayList.addAll(aVar.f126313e);
        a(arrayList);
        b bVar = (b) this.f126372e.get(this.f126379l);
        if (z16) {
            bVar.a((com.tencent.luggage.wxa.g0.b) cVar);
        } else {
            bVar.d();
        }
        this.f126377j.b(sVar.f132851a, 4, j3, j16, sVar.d());
    }

    public final int c(com.tencent.luggage.wxa.g0.b bVar, com.tencent.luggage.wxa.g0.b bVar2) {
        b.a a16;
        if (bVar2.f126321f) {
            return bVar2.f126322g;
        }
        com.tencent.luggage.wxa.g0.b bVar3 = this.f126380m;
        int i3 = bVar3 != null ? bVar3.f126322g : 0;
        return (bVar == null || (a16 = a(bVar, bVar2)) == null) ? i3 : (bVar.f126322g + a16.f126334c) - ((b.a) bVar2.f126330o.get(0)).f126334c;
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public void a(s sVar, long j3, long j16, boolean z16) {
        this.f126377j.a(sVar.f132851a, 4, j3, j16, sVar.d());
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public int a(s sVar, long j3, long j16, IOException iOException) {
        boolean z16 = iOException instanceof o;
        this.f126377j.a(sVar.f132851a, 4, j3, j16, sVar.d(), iOException, z16);
        return z16 ? 3 : 0;
    }

    public final void a(List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.C6226a c6226a = (a.C6226a) list.get(i3);
            this.f126372e.put(c6226a, new b(c6226a));
        }
    }

    public final void a(a.C6226a c6226a, com.tencent.luggage.wxa.g0.b bVar) {
        if (c6226a == this.f126379l) {
            if (this.f126380m == null) {
                this.C = !bVar.f126327l;
            }
            this.f126380m = bVar;
            this.f126374g.a(bVar);
        }
        int size = this.f126375h.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((c) this.f126375h.get(i3)).e();
        }
    }

    public final void a(a.C6226a c6226a, long j3) {
        int size = this.f126375h.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((c) this.f126375h.get(i3)).a(c6226a, j3);
        }
    }

    public static b.a a(com.tencent.luggage.wxa.g0.b bVar, com.tencent.luggage.wxa.g0.b bVar2) {
        int i3 = bVar2.f126323h - bVar.f126323h;
        List list = bVar.f126330o;
        if (i3 < list.size()) {
            return (b.a) list.get(i3);
        }
        return null;
    }
}
