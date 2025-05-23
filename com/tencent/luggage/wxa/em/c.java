package com.tencent.luggage.wxa.em;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.ValueCallback;
import androidx.arch.core.util.Function;
import com.eclipsesource.mmv8.V8ScriptEvaluateRequest;
import com.tencent.luggage.wxa.b9.c0;
import com.tencent.luggage.wxa.b9.d0;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.r4.a;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.so.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.y;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends c0 {

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray f124933f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f124934g;

    /* renamed from: h, reason: collision with root package name */
    public final SparseArray f124935h;

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.luggage.wxa.so.e f124936i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function {

        /* renamed from: a, reason: collision with root package name */
        public final long f124937a = w0.c();

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f124938b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t f124939c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c0.k f124940d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.em.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6174a implements t.s {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Boolean f124942a;

            public C6174a(Boolean bool) {
                this.f124942a = bool;
            }

            @Override // com.tencent.luggage.wxa.b9.t.s
            public void a(String str, t.C6044t c6044t) {
                c0.k kVar;
                if (this.f124942a.booleanValue() && (kVar = a.this.f124940d) != null) {
                    kVar.a(w0.c() - a.this.f124937a);
                }
            }
        }

        public a(ArrayList arrayList, t tVar, c0.k kVar) {
            this.f124938b = arrayList;
            this.f124939c = tVar;
            this.f124940d = kVar;
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(Boolean bool) {
            c0.k kVar;
            if (!this.f124938b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f124938b);
                this.f124938b.clear();
                this.f124939c.a(arrayList, y.a(), new C6174a(bool));
                return null;
            }
            if (bool.booleanValue() && (kVar = this.f124940d) != null) {
                kVar.a(w0.c() - this.f124937a);
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0.j f124944a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f124945b;

        public b(c0.j jVar, long j3) {
            this.f124944a = jVar;
            this.f124945b = j3;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            c.this.a(this.f124944a, this.f124945b, w0.c(), c6044t);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.em.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6175c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.e f124947a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f124948b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f124949c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t f124950d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f124951e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f124952f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.em.c$c$a */
        /* loaded from: classes8.dex */
        public class a extends a.AbstractC6666a {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.em.c$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6176a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Throwable f124955a;

                public RunnableC6176a(Throwable th5) {
                    this.f124955a = th5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw this.f124955a;
                }
            }

            public a(com.tencent.luggage.wxa.xd.e eVar) {
                super(eVar);
            }

            @Override // com.tencent.luggage.wxa.r4.a.AbstractC6666a, com.tencent.luggage.wxa.a9.a
            public String a(String str, String str2, String str3, int i3, boolean z16, int i16) {
                List list = RunnableC6175c.this.f124948b;
                if (list != null && list.contains(str)) {
                    try {
                        RunnableC6175c runnableC6175c = RunnableC6175c.this;
                        return runnableC6175c.f124947a.a(str, str2, str3, i3, z16, runnableC6175c.f124949c, i16);
                    } catch (Throwable th5) {
                        w.a("MicroMsg.V8EngineWorkerManagerLU", th5, "IMBInvokeHandler.invoke", new Object[0]);
                        com.tencent.luggage.wxa.tn.c0.a(new RunnableC6176a(th5));
                        return "";
                    }
                }
                com.tencent.luggage.wxa.xd.e eVar = RunnableC6175c.this.f124947a;
                eVar.a(i3, eVar.b(str, "fail:not supported"), RunnableC6175c.this.f124949c);
                return "fail:not supported";
            }

            @Override // com.tencent.luggage.wxa.a9.a
            public void b() {
                RunnableC6175c.this.f124950d.h().b();
            }

            @Override // com.tencent.luggage.wxa.a9.a
            public boolean c() {
                return RunnableC6175c.this.f124950d.h().c();
            }
        }

        public RunnableC6175c(com.tencent.luggage.wxa.xd.e eVar, List list, p pVar, t tVar, int i3, boolean z16) {
            this.f124947a = eVar;
            this.f124948b = list;
            this.f124949c = pVar;
            this.f124950d = tVar;
            this.f124951e = i3;
            this.f124952f = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.r4.f g06;
            com.tencent.luggage.wxa.r4.a aVar = new com.tencent.luggage.wxa.r4.a(new a(this.f124947a));
            AppBrandCommonBindingJniParams appBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
            long f16 = this.f124950d.h().f();
            long f17 = this.f124950d.f();
            long j3 = this.f124950d.h().j();
            String g16 = c.this.g();
            appBrandCommonBindingJniParams.wasmCachePath = g16;
            if (!TextUtils.isEmpty(g16)) {
                appBrandCommonBindingJniParams.wasmCachePath = x.b(appBrandCommonBindingJniParams.wasmCachePath, true);
            }
            com.tencent.luggage.wxa.xd.e eVar = this.f124947a;
            if ((eVar instanceof com.tencent.luggage.wxa.r4.d) && (g06 = ((com.tencent.luggage.wxa.r4.d) eVar).g0()) != null) {
                appBrandCommonBindingJniParams.wasmOptState = g06.D();
            }
            aVar.c().notifyCreate(appBrandCommonBindingJniParams);
            aVar.c().notifyBindTo(f16, f17, j3);
            if (!t.d()) {
                aVar.c().notifyBindConsoleTo(f16, f17, j3);
            }
            aVar.b().a(this.f124950d.h().f(), this.f124950d.f());
            c.this.f124933f.put(this.f124951e, aVar);
            if (this.f124952f && !c.this.f124934g.get()) {
                synchronized (c.this.f124935h) {
                    SparseArray sparseArray = c.this.f124935h;
                    int i3 = this.f124951e;
                    sparseArray.put(i3, new e(i3, aVar, this.f124950d, this.f124947a));
                }
                return;
            }
            aVar.c().notifyRuntimeReady(this.f124947a.getAppId(), c.this.c(this.f124947a), c.this.b(this.f124947a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f124957a;

        public d(ValueCallback valueCallback) {
            this.f124957a = valueCallback;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            this.f124957a.onReceiveValue(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f124959a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.r4.a f124960b;

        /* renamed from: c, reason: collision with root package name */
        public final t f124961c;

        /* renamed from: d, reason: collision with root package name */
        public final com.tencent.luggage.wxa.xd.e f124962d;

        public e(int i3, com.tencent.luggage.wxa.r4.a aVar, t tVar, com.tencent.luggage.wxa.xd.e eVar) {
            this.f124959a = i3;
            this.f124960b = aVar;
            this.f124961c = tVar;
            this.f124962d = eVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends c0.j {

        /* renamed from: c, reason: collision with root package name */
        public String f124963c;

        /* renamed from: d, reason: collision with root package name */
        public String f124964d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f124965e;

        /* renamed from: f, reason: collision with root package name */
        public q f124966f;

        /* renamed from: g, reason: collision with root package name */
        public final Runnable f124967g;

        public f(String str, V8ScriptEvaluateRequest v8ScriptEvaluateRequest, String str2, String str3, boolean z16) {
            super(str, v8ScriptEvaluateRequest);
            this.f124966f = null;
            this.f124963c = str2;
            this.f124964d = str3;
            this.f124965e = z16;
            this.f124967g = null;
        }

        public f a(q qVar) {
            this.f124966f = qVar;
            return this;
        }

        @Override // com.tencent.luggage.wxa.b9.c0.j
        public boolean a() {
            if (this.f124967g != null) {
                return true;
            }
            return super.a();
        }

        public f(c0.j jVar, String str, String str2, boolean z16) {
            super(jVar.f122183a, jVar.f122184b);
            this.f124966f = null;
            this.f124963c = str;
            this.f124964d = str2;
            this.f124965e = z16;
            this.f124967g = null;
        }

        public f(String str, String str2, String str3, String str4, boolean z16) {
            super(str, str2);
            this.f124966f = null;
            this.f124963c = str3;
            this.f124964d = str4;
            this.f124965e = z16;
            this.f124967g = null;
        }

        public f(String str, Runnable runnable) {
            super(str, (String) null);
            this.f124966f = null;
            this.f124967g = runnable;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final int f124968a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.fj.a f124969b;

        /* renamed from: c, reason: collision with root package name */
        public final j f124970c;

        public g(int i3, com.tencent.luggage.wxa.fj.a aVar, j jVar) {
            this.f124968a = i3;
            this.f124969b = aVar;
            this.f124970c = jVar;
        }

        public void a() {
            this.f124969b.e();
        }
    }

    public c(d0 d0Var) {
        super(d0Var);
        this.f124933f = new SparseArray(1);
        this.f124934g = new AtomicBoolean(false);
        this.f124935h = new SparseArray();
        this.f124936i = com.tencent.luggage.wxa.so.e.a(new e.b() { // from class: m21.e
            @Override // com.tencent.luggage.wxa.so.e.b
            public final Object a() {
                return new c.h();
            }
        }, new e.a() { // from class: m21.f
            @Override // com.tencent.luggage.wxa.so.e.a
            public final void a(Object obj) {
                ((c.h) obj).a();
            }
        });
        super.a(y.a());
    }

    public void a(c0.j jVar, long j3, long j16, t.C6044t c6044t) {
    }

    public String c(com.tencent.luggage.wxa.xd.e eVar) {
        return "";
    }

    public final String b(com.tencent.luggage.wxa.xd.e eVar) {
        q qVar = (q) eVar.b(q.class);
        if (qVar == null) {
            return "";
        }
        return "v" + qVar.w();
    }

    public com.tencent.luggage.wxa.fj.a f() {
        return new com.tencent.luggage.wxa.fj.a();
    }

    public String g() {
        return "";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends SparseArray {
        public synchronized void a() {
            for (int i3 = 0; i3 < size(); i3++) {
                valueAt(i3).a();
            }
        }

        public synchronized g b(int i3) {
            g gVar;
            int indexOfKey = indexOfKey(i3);
            if (indexOfKey >= 0) {
                gVar = valueAt(indexOfKey);
                removeAt(indexOfKey);
            } else {
                gVar = null;
            }
            return gVar;
        }

        @Override // android.util.SparseArray
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public synchronized g valueAt(int i3) {
            return (g) super.valueAt(i3);
        }

        @Override // android.util.SparseArray
        public synchronized int indexOfKey(int i3) {
            return super.indexOfKey(i3);
        }

        @Override // android.util.SparseArray
        public synchronized void remove(int i3) {
            super.remove(i3);
        }

        @Override // android.util.SparseArray
        public synchronized void removeAt(int i3) {
            super.removeAt(i3);
        }

        @Override // android.util.SparseArray
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized void put(int i3, g gVar) {
            super.put(i3, gVar);
        }

        @Override // android.util.SparseArray
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized g get(int i3) {
            return (g) super.get(i3);
        }
    }

    public final boolean a(c0.j jVar) {
        for (String str : com.tencent.luggage.wxa.m4.c.f134094w) {
            if (StringUtils.endsWith(jVar.f122183a, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.b9.c0
    public void b() {
        int i3;
        super.b();
        if (this.f124934g.getAndSet(true)) {
            return;
        }
        synchronized (this.f124935h) {
            for (int i16 = 0; i16 < this.f124935h.size(); i16++) {
                final e eVar = (e) this.f124935h.valueAt(i16);
                final com.tencent.luggage.wxa.xd.e eVar2 = eVar.f124962d;
                eVar.f124961c.h().a(new Runnable() { // from class: m21.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.em.c.this.a(eVar, eVar2);
                    }
                });
            }
        }
        h hVar = (h) this.f124936i.a();
        synchronized (hVar) {
            for (i3 = 0; i3 < hVar.size(); i3++) {
                g valueAt = hVar.valueAt(i3);
                com.tencent.luggage.wxa.ei.q qVar = (com.tencent.luggage.wxa.ei.q) valueAt.f124970c.a(com.tencent.luggage.wxa.ei.q.class);
                com.tencent.luggage.wxa.fj.a aVar = valueAt.f124969b;
                Objects.requireNonNull(aVar);
                qVar.d(new m21.b(aVar));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.b9.c0
    public void a(t tVar, ArrayList arrayList, c0.k kVar) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        a aVar = new a(arrayList2, tVar, kVar);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0.j jVar = (c0.j) it.next();
            w.d("MicroMsg.V8EngineWorkerManagerLU", "batchInjectWorkEvalItems, about to submit item:%s, valid(%b)", jVar.f122183a, Boolean.valueOf(jVar.a()));
            if (jVar.a()) {
                boolean z16 = jVar instanceof f;
                if (z16) {
                    f fVar = (f) jVar;
                    if (fVar.f124967g != null) {
                        aVar.apply(Boolean.FALSE);
                        tVar.a(fVar.f124967g);
                    }
                }
                if (a(jVar)) {
                    aVar.apply(Boolean.FALSE);
                    a(tVar, jVar);
                } else {
                    String str = z16 ? ((f) jVar).f124963c : null;
                    if (!StringUtils.isEmpty(str)) {
                        arrayList2.add(y.a(str));
                    }
                    arrayList2.add(jVar.f122184b);
                }
            }
        }
        aVar.apply(Boolean.TRUE);
    }

    public final void a(t tVar, c0.j jVar) {
        if (jVar.a()) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(jVar.f122184b);
            tVar.a(arrayList, y.a(), new b(jVar, currentTimeMillis));
        }
    }

    @Override // com.tencent.luggage.wxa.b9.c0
    public void a(int i3, ArrayList arrayList, j jVar, com.tencent.luggage.wxa.xd.e eVar) {
        if (!(eVar instanceof l)) {
            w.b("MicroMsg.V8EngineWorkerManagerLU", "hy: component is not service. do nothing");
            return;
        }
        com.tencent.luggage.wxa.fj.a f16 = f();
        l lVar = (l) eVar;
        f16.a(lVar, jVar, e.a.Worker);
        ((h) this.f124936i.a()).put(i3, new g(i3, f16, jVar));
        String K = lVar.K();
        Iterator it = arrayList.iterator();
        int i16 = 0;
        while (it.hasNext() && !a((c0.j) it.next())) {
            i16++;
        }
        arrayList.add(i16, new c0.j(K + "node.js", f16.a()));
        if ((lVar.getRuntime() == null || !lVar.getRuntime().s0()) || com.tencent.luggage.wxa.fj.b.a() != 1) {
            return;
        }
        arrayList.add(i16 + 1, new f(K + "node_service_init.js", new m21.b(f16)));
    }

    @Override // com.tencent.luggage.wxa.b9.c0
    public void a(Context context, int i3, com.tencent.luggage.wxa.xd.e eVar, List list, boolean z16) {
        w.d("MicroMsg.V8EngineWorkerManagerLU", "hy: trigger bind to %d", Integer.valueOf(i3));
        t a16 = a(i3);
        WeakReference weakReference = new WeakReference(a16);
        if (a16 != null && eVar != null) {
            a16.h().a(new RunnableC6175c(eVar, list, a(i3, weakReference), a16, i3, z16));
        } else {
            w.b("MicroMsg.V8EngineWorkerManagerLU", "hy: worker not in map!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(e eVar, com.tencent.luggage.wxa.xd.e eVar2) {
        eVar.f124960b.c().notifyRuntimeReady(eVar2.getAppId(), c(eVar2), b(eVar2));
    }

    @Override // com.tencent.luggage.wxa.b9.c0
    public void a(t tVar, String str, ValueCallback valueCallback) {
        if (tVar == null) {
            w.f("MicroMsg.V8EngineWorkerManagerLU", "hy: engine context released");
        } else if (valueCallback != null) {
            tVar.a(str, (t.s) new d(valueCallback));
        } else {
            tVar.a(str, (t.s) null);
        }
    }

    @Override // com.tencent.luggage.wxa.b9.c0
    public void a() {
        super.a();
        this.f124936i.b();
        this.f124933f.clear();
        this.f124935h.clear();
    }

    @Override // com.tencent.luggage.wxa.b9.c0
    public void a(final int i3, t tVar) {
        final com.tencent.luggage.wxa.r4.a aVar = (com.tencent.luggage.wxa.r4.a) this.f124933f.get(i3);
        if (aVar != null) {
            tVar.h().c(new Runnable() { // from class: m21.d
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.em.c.this.b(i3, aVar);
                }
            });
        }
        synchronized (this.f124935h) {
            this.f124935h.remove(i3);
        }
        g b16 = ((h) this.f124936i.a()).b(i3);
        if (b16 != null) {
            b16.a();
        }
        super.a(i3, tVar);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(int i3, com.tencent.luggage.wxa.r4.a aVar) {
        aVar.b().a();
        aVar.c().notifyDestroy();
        this.f124933f.remove(i3);
    }
}
