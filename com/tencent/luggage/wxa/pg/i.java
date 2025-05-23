package com.tencent.luggage.wxa.pg;

import android.os.ConditionVariable;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.pg.a;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements com.tencent.luggage.wxa.pg.a {

    /* renamed from: a, reason: collision with root package name */
    public long f137564a;

    /* renamed from: b, reason: collision with root package name */
    public final v f137565b;

    /* renamed from: c, reason: collision with root package name */
    public final d f137566c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f137567d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f137568e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f137569f = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f137570a;

        public a(ConditionVariable conditionVariable) {
            this.f137570a = conditionVariable;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (i.this) {
                this.f137570a.open();
                i.this.b();
            }
        }
    }

    public i(v vVar, d dVar) {
        this.f137565b = vVar;
        this.f137566c = dVar;
        ConditionVariable conditionVariable = new ConditionVariable();
        new a(conditionVariable).start();
        conditionVariable.block();
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized f b(String str, long j3) {
        f g16;
        f a16 = f.a(str, j3);
        while (true) {
            g16 = g(a16);
            if (g16 == null) {
                LockMethodProxy.wait(this);
            }
        }
        return g16;
    }

    public final boolean c(f fVar) {
        TreeSet treeSet = (TreeSet) this.f137568e.get(fVar.f137553a);
        if (treeSet == null) {
            treeSet = new TreeSet();
            this.f137568e.put(fVar.f137553a, treeSet);
        }
        boolean add = treeSet.add(fVar);
        this.f137564a += fVar.f137555c;
        e(fVar);
        return add;
    }

    public final f d(f fVar) {
        String str = fVar.f137553a;
        long j3 = fVar.f137554b;
        TreeSet treeSet = (TreeSet) this.f137568e.get(str);
        if (treeSet == null) {
            return f.b(str, fVar.f137554b);
        }
        f fVar2 = (f) treeSet.floor(fVar);
        if (fVar2 != null) {
            long j16 = fVar2.f137554b;
            if (j16 <= j3 && j3 < j16 + fVar2.f137555c) {
                if (fVar2.f137559g.e()) {
                    return fVar2;
                }
                c();
                return d(fVar);
            }
        }
        f fVar3 = (f) treeSet.ceiling(fVar);
        if (fVar3 == null) {
            return f.b(str, fVar.f137554b);
        }
        long j17 = fVar.f137554b;
        return f.a(str, j17, fVar3.f137554b - j17);
    }

    public synchronized NavigableSet e(String str) {
        TreeSet treeSet;
        treeSet = (TreeSet) this.f137568e.get(str);
        return treeSet == null ? null : new TreeSet((SortedSet) treeSet);
    }

    public final void f(f fVar) {
        ArrayList arrayList = (ArrayList) this.f137569f.get(fVar.f137553a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.InterfaceC6600a) arrayList.get(size)).b(this, fVar);
            }
        }
        this.f137566c.b(this, fVar);
    }

    public final synchronized f g(f fVar) {
        f d16 = d(fVar);
        if (d16.f137558f) {
            return d16;
        }
        if (!this.f137567d.containsKey(fVar.f137553a)) {
            this.f137567d.put(fVar.f137553a, d16);
            return d16;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized long a() {
        return this.f137564a;
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized f a(String str, long j3) {
        return g(f.a(str, j3));
    }

    public final void e(f fVar) {
        ArrayList arrayList = (ArrayList) this.f137569f.get(fVar.f137553a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.InterfaceC6600a) arrayList.get(size)).a(this, fVar);
            }
        }
        this.f137566c.a(this, fVar);
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized v a(String str, long j3, long j16, com.tencent.luggage.wxa.rg.b bVar, long j17) {
        com.tencent.luggage.wxa.tg.a.b(this.f137567d.containsKey(str));
        if (!this.f137565b.e()) {
            c();
            this.f137565b.w();
        }
        this.f137566c.a(this, str, j3, j17);
        return f.a(this.f137565b, str, j3, j16, bVar, System.currentTimeMillis());
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized void b(f fVar) {
        com.tencent.luggage.wxa.tg.a.b(fVar == this.f137567d.remove(fVar.f137553a));
        notifyAll();
    }

    public final void b() {
        if (!this.f137565b.e()) {
            this.f137565b.w();
        }
        v[] u16 = this.f137565b.u();
        if (u16 == null) {
            return;
        }
        for (v vVar : u16) {
            if (vVar.s() == 0) {
                vVar.d();
            } else {
                f a16 = f.a(vVar);
                if (a16 == null) {
                    vVar.d();
                } else if (!c(a16)) {
                    com.tencent.luggage.wxa.tg.h.a(3, "SimpleCache", "remove duplicated span " + a16.f137559g);
                    a(a16);
                }
            }
        }
    }

    public final void c() {
        Iterator it = this.f137568e.entrySet().iterator();
        while (it.hasNext()) {
            Iterator it5 = ((TreeSet) ((Map.Entry) it.next()).getValue()).iterator();
            boolean z16 = true;
            while (it5.hasNext()) {
                f fVar = (f) it5.next();
                if (fVar.f137559g.e()) {
                    z16 = false;
                } else {
                    it5.remove();
                    if (fVar.f137558f) {
                        this.f137564a -= fVar.f137555c;
                    }
                    f(fVar);
                }
            }
            if (z16) {
                it.remove();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized void a(v vVar) {
        f a16 = f.a(vVar);
        com.tencent.luggage.wxa.tg.a.b(a16 != null);
        com.tencent.luggage.wxa.tg.a.b(this.f137567d.containsKey(a16.f137553a));
        if (vVar.e()) {
            if (vVar.s() == 0) {
                vVar.d();
            } else {
                c(a16);
                notifyAll();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized com.tencent.luggage.wxa.rg.b d(String str) {
        f fVar;
        NavigableSet e16 = e(str);
        if (e16 != null && (fVar = (f) e16.first()) != null && fVar.f137556d >= 0) {
            return fVar.f137557e;
        }
        return com.tencent.luggage.wxa.rg.b.f139662c;
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized void a(f fVar) {
        TreeSet treeSet = (TreeSet) this.f137568e.get(fVar.f137553a);
        this.f137564a -= fVar.f137555c;
        fVar.f137559g.d();
        if (treeSet == null || treeSet.isEmpty()) {
            this.f137568e.remove(fVar.f137553a);
        }
        f(fVar);
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized long b(String str) {
        NavigableSet<f> e16 = e(str);
        long j3 = 0;
        if (e16 != null) {
            f fVar = (f) e16.first();
            if (fVar != null && fVar.f137558f && fVar.f137556d >= 0 && fVar.f137554b != 0) {
                return 0L;
            }
            if (fVar != null && fVar.f137556d >= 0) {
                for (f fVar2 : e16) {
                    if (!fVar2.f137558f) {
                        return j3;
                    }
                    j3 += fVar2.f137555c;
                }
            }
        }
        return j3;
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized long c(String str) {
        f fVar;
        NavigableSet e16 = e(str);
        if (e16 != null && (fVar = (f) e16.first()) != null) {
            long j3 = fVar.f137556d;
            if (j3 >= 0) {
                return j3;
            }
        }
        return -1L;
    }

    @Override // com.tencent.luggage.wxa.pg.a
    public synchronized boolean a(String str) {
        f fVar;
        NavigableSet<f> e16 = e(str);
        if (e16 != null && (fVar = (f) e16.first()) != null) {
            long j3 = fVar.f137556d;
            long j16 = 0;
            if (j3 >= 0) {
                for (f fVar2 : e16) {
                    if (!fVar2.f137558f) {
                        return false;
                    }
                    j16 += fVar2.f137555c;
                }
                if (j16 >= j3) {
                    return true;
                }
            }
        }
        return false;
    }
}
