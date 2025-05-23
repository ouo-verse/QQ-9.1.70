package com.tencent.luggage.wxa.id;

import com.tencent.luggage.wxa.hn.xb;
import com.tencent.luggage.wxa.hn.zc;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {
    public String A;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.r4.d f130025a;

    /* renamed from: b, reason: collision with root package name */
    public final xb f130026b;

    /* renamed from: c, reason: collision with root package name */
    public String f130027c;

    /* renamed from: g, reason: collision with root package name */
    public zc f130031g;

    /* renamed from: h, reason: collision with root package name */
    public f f130032h;

    /* renamed from: l, reason: collision with root package name */
    public long f130036l;

    /* renamed from: o, reason: collision with root package name */
    public boolean f130039o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f130040p;

    /* renamed from: d, reason: collision with root package name */
    public int f130028d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f130029e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f130030f = 0;

    /* renamed from: i, reason: collision with root package name */
    public AtomicInteger f130033i = new AtomicInteger(0);

    /* renamed from: j, reason: collision with root package name */
    public long f130034j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f130035k = 0;

    /* renamed from: m, reason: collision with root package name */
    public long f130037m = System.currentTimeMillis();

    /* renamed from: n, reason: collision with root package name */
    public AtomicInteger f130038n = new AtomicInteger(0);

    /* renamed from: q, reason: collision with root package name */
    public final HashMap f130041q = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    public final HashMap f130042r = new HashMap();

    /* renamed from: s, reason: collision with root package name */
    public LinkedList f130043s = new LinkedList();

    /* renamed from: t, reason: collision with root package name */
    public final LinkedList f130044t = new LinkedList();

    /* renamed from: u, reason: collision with root package name */
    public final Map f130045u = new HashMap();

    /* renamed from: v, reason: collision with root package name */
    public final LinkedList f130046v = new LinkedList();

    /* renamed from: w, reason: collision with root package name */
    public final HashMap f130047w = new HashMap();

    /* renamed from: x, reason: collision with root package name */
    public final Object f130048x = new Object();

    /* renamed from: y, reason: collision with root package name */
    public int f130049y = 0;

    /* renamed from: z, reason: collision with root package name */
    public long f130050z = 0;

    public e() {
        xb xbVar = new xb();
        this.f130026b = xbVar;
        xbVar.f129032d = com.tencent.luggage.wxa.tn.e.f141563e;
    }

    public synchronized boolean A() {
        return this.f130040p;
    }

    public boolean B() {
        if (u() == 4) {
            return true;
        }
        return false;
    }

    public synchronized boolean C() {
        boolean z16;
        if (u() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public void D() {
        this.f130049y = 0;
    }

    public boolean E() {
        return l.a(this.f130032h.f130058h);
    }

    public void F() {
        this.f130035k = System.currentTimeMillis();
    }

    public void G() {
        this.f130036l = System.currentTimeMillis();
    }

    public void H() {
        this.f130034j = System.currentTimeMillis();
        G();
    }

    public void I() {
        this.f130037m = System.currentTimeMillis();
    }

    public void a(com.tencent.luggage.wxa.r4.d dVar, String str) {
        this.f130025a = dVar;
        l.b(dVar.getRuntime().S().f130798j0);
        this.f130032h = l.b(str);
        com.tencent.luggage.wxa.j4.g j06 = this.f130025a.getRuntime().j0();
        if (j06 != null) {
            j06.H = this.f130032h.f130057g;
            j06.I = true;
            com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.getRuntime().a(com.tencent.luggage.wxa.yi.a.class);
            if (aVar != null) {
                aVar.f145792b = !j06.H;
            }
        }
    }

    public void b(String str) {
        this.A = str;
    }

    public synchronized void c(int i3) {
        this.f130028d = i3;
    }

    public synchronized void d(int i3) {
        if (this.f130029e < i3) {
            this.f130029e = i3;
        }
    }

    public int e() {
        return this.f130038n.incrementAndGet();
    }

    public long f() {
        return this.f130035k;
    }

    public long g() {
        return this.f130036l;
    }

    public long h() {
        return this.f130034j;
    }

    public long i() {
        return this.f130037m;
    }

    public Object j() {
        return this.f130048x;
    }

    public synchronized String k() {
        return this.f130027c;
    }

    public LinkedList l() {
        return this.f130046v;
    }

    public LinkedList m() {
        return this.f130043s;
    }

    public synchronized int n() {
        return this.f130028d;
    }

    public long o() {
        return this.f130050z;
    }

    public synchronized int p() {
        return this.f130029e;
    }

    public Map q() {
        return this.f130045u;
    }

    public LinkedList r() {
        return this.f130044t;
    }

    public int s() {
        return this.f130033i.incrementAndGet();
    }

    public com.tencent.luggage.wxa.r4.d t() {
        return this.f130025a;
    }

    public synchronized int u() {
        return this.f130030f;
    }

    public String v() {
        return this.A;
    }

    public void w() {
        this.f130049y++;
    }

    public boolean x() {
        if (this.f130032h.f130055e == 3) {
            return true;
        }
        return false;
    }

    public synchronized boolean y() {
        return this.f130039o;
    }

    public boolean z() {
        if (u() == 5) {
            return true;
        }
        return false;
    }

    public xb b() {
        return this.f130026b;
    }

    public f c() {
        return this.f130032h;
    }

    public synchronized void b(int i3) {
        this.f130030f = i3;
    }

    public HashMap d() {
        return this.f130047w;
    }

    public synchronized void b(boolean z16) {
        this.f130040p = z16;
    }

    public synchronized void a(String str) {
        this.f130027c = str;
    }

    public synchronized void a(int i3, int i16) {
        int i17 = this.f130029e;
        if (i17 >= i3 && i17 <= i16) {
            this.f130029e = i16;
        }
    }

    public void a(zc zcVar) {
        this.f130031g = zcVar;
    }

    public synchronized void a(boolean z16) {
        this.f130039o = z16;
    }

    public boolean a() {
        return !B() && ((long) this.f130049y) < 10;
    }

    public void a(int i3) {
        this.f130050z += i3;
    }
}
