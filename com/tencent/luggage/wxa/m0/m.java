package com.tencent.luggage.wxa.m0;

import android.os.ConditionVariable;
import com.tencent.luggage.wxa.m0.a;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m implements com.tencent.luggage.wxa.m0.a {

    /* renamed from: a, reason: collision with root package name */
    public final File f134012a;

    /* renamed from: b, reason: collision with root package name */
    public final f f134013b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f134014c;

    /* renamed from: d, reason: collision with root package name */
    public final j f134015d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f134016e;

    /* renamed from: f, reason: collision with root package name */
    public long f134017f;

    /* renamed from: g, reason: collision with root package name */
    public a.C6454a f134018g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f134019a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f134019a = conditionVariable;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (m.this) {
                this.f134019a.open();
                try {
                    m.this.b();
                } catch (a.C6454a e16) {
                    m.this.f134018g = e16;
                }
                m.this.f134013b.a();
            }
        }
    }

    public m(File file, f fVar) {
        this(file, fVar, null, false);
    }

    public final void c() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f134015d.a().iterator();
        while (it.hasNext()) {
            Iterator it5 = ((i) it.next()).b().iterator();
            while (it5.hasNext()) {
                g gVar = (g) it5.next();
                if (!gVar.f133989e.exists()) {
                    linkedList.add(gVar);
                }
            }
        }
        Iterator it6 = linkedList.iterator();
        while (it6.hasNext()) {
            a((g) it6.next(), false);
        }
        this.f134015d.e();
        this.f134015d.f();
    }

    public final n d(String str, long j3) {
        n a16;
        i c16 = this.f134015d.c(str);
        if (c16 == null) {
            return n.b(str, j3);
        }
        while (true) {
            a16 = c16.a(j3);
            if (!a16.f133988d || a16.f133989e.exists()) {
                break;
            }
            c();
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.m0.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized n b(String str, long j3) {
        n a16;
        while (true) {
            a16 = a(str, j3);
            if (a16 == null) {
                LockMethodProxy.wait(this);
            }
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.m0.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized n a(String str, long j3) {
        a.C6454a c6454a = this.f134018g;
        if (c6454a == null) {
            n d16 = d(str, j3);
            if (d16.f133988d) {
                n b16 = this.f134015d.c(str).b(d16);
                a(d16, b16);
                return b16;
            }
            if (!this.f134014c.containsKey(str)) {
                this.f134014c.put(str, d16);
                return d16;
            }
            return null;
        }
        throw c6454a;
    }

    public m(File file, f fVar, byte[] bArr, boolean z16) {
        this(file, fVar, new j(file, bArr, z16));
    }

    public m(File file, f fVar, j jVar) {
        this.f134017f = 0L;
        this.f134012a = file;
        this.f134013b = fVar;
        this.f134014c = new HashMap();
        this.f134015d = jVar;
        this.f134016e = new HashMap();
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("SimpleCache.initialize()", conditionVariable).start();
        conditionVariable.block();
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized NavigableSet b(String str) {
        i c16;
        c16 = this.f134015d.c(str);
        return (c16 == null || c16.d()) ? null : new TreeSet((Collection) c16.b());
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized long a() {
        return this.f134017f;
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized void a(File file) {
        n a16 = n.a(file, this.f134015d);
        boolean z16 = true;
        com.tencent.luggage.wxa.n0.a.b(a16 != null);
        com.tencent.luggage.wxa.n0.a.b(this.f134014c.containsKey(a16.f133985a));
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            Long valueOf = Long.valueOf(a(a16.f133985a));
            if (valueOf.longValue() != -1) {
                if (a16.f133986b + a16.f133987c > valueOf.longValue()) {
                    z16 = false;
                }
                com.tencent.luggage.wxa.n0.a.b(z16);
            }
            a(a16);
            this.f134015d.f();
            notifyAll();
        }
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized File b(String str, long j3, long j16) {
        com.tencent.luggage.wxa.n0.a.b(this.f134014c.containsKey(str));
        if (!this.f134012a.exists()) {
            c();
            this.f134012a.mkdirs();
        }
        this.f134013b.a(this, str, j3, j16);
        return n.a(this.f134012a, this.f134015d.b(str), j3, System.currentTimeMillis());
    }

    public final void c(g gVar) {
        ArrayList arrayList = (ArrayList) this.f134016e.get(gVar.f133985a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).b(this, gVar);
            }
        }
        this.f134013b.b(this, gVar);
    }

    public final void b() {
        if (!this.f134012a.exists()) {
            this.f134012a.mkdirs();
            return;
        }
        this.f134015d.c();
        File[] listFiles = this.f134012a.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.getName().equals("cached_content_index.exi")) {
                n a16 = file.length() > 0 ? n.a(file, this.f134015d) : null;
                if (a16 != null) {
                    a(a16);
                } else {
                    file.delete();
                }
            }
        }
        this.f134015d.e();
        this.f134015d.f();
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized void c(String str, long j3) {
        this.f134015d.b(str, j3);
        this.f134015d.f();
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized void a(g gVar) {
        com.tencent.luggage.wxa.n0.a.b(gVar == this.f134014c.remove(gVar.f133985a));
        notifyAll();
    }

    public final void a(n nVar) {
        this.f134015d.a(nVar.f133985a).a(nVar);
        this.f134017f += nVar.f133987c;
        b(nVar);
    }

    public final void a(g gVar, boolean z16) {
        i c16 = this.f134015d.c(gVar.f133985a);
        if (c16 == null || !c16.a(gVar)) {
            return;
        }
        this.f134017f -= gVar.f133987c;
        if (z16) {
            try {
                if (c16.d()) {
                    this.f134015d.e(c16.f133992b);
                    this.f134015d.f();
                }
            } finally {
                c(gVar);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized void b(g gVar) {
        a(gVar, true);
    }

    public final void b(n nVar) {
        ArrayList arrayList = (ArrayList) this.f134016e.get(nVar.f133985a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).a(this, nVar);
            }
        }
        this.f134013b.a(this, nVar);
    }

    public final void a(n nVar, g gVar) {
        ArrayList arrayList = (ArrayList) this.f134016e.get(nVar.f133985a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).a(this, nVar, gVar);
            }
        }
        this.f134013b.a(this, nVar, gVar);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized long a(String str, long j3, long j16) {
        i c16;
        c16 = this.f134015d.c(str);
        return c16 != null ? c16.a(j3, j16) : -j16;
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized long a(String str) {
        return this.f134015d.d(str);
    }
}
