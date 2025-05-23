package com.tencent.luggage.wxa.xp;

import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public static volatile f f145265b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile SparseArray f145266c;

    /* renamed from: a, reason: collision with root package name */
    public final Object f145267a = new Object();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xp.d f145268a;

        public a(com.tencent.luggage.wxa.xp.d dVar) {
            this.f145268a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f145268a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xp.d f145270a;

        public b(com.tencent.luggage.wxa.xp.d dVar) {
            this.f145270a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f145270a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f145272a;

        public c(int i3) {
            this.f145272a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f145267a) {
                com.tencent.luggage.wxa.xp.d dVar = (com.tencent.luggage.wxa.xp.d) f.f145266c.get(this.f145272a);
                if (dVar != null) {
                    dVar.e();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f145274a;

        public d(int i3) {
            this.f145274a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (f.this.f145267a) {
                obj = (com.tencent.luggage.wxa.xp.d) f.f145266c.get(this.f145274a);
            }
            if (obj != null && (obj instanceof com.tencent.luggage.wxa.xp.a)) {
                com.tencent.luggage.wxa.xp.a aVar = (com.tencent.luggage.wxa.xp.a) obj;
                if (!aVar.isCancelled()) {
                    aVar.a();
                }
            }
        }
    }

    public f() {
        f145266c = new SparseArray(5);
    }

    public static f c() {
        f fVar;
        if (f145265b == null) {
            synchronized (f.class) {
                if (f145265b == null) {
                    f145265b = new f();
                }
                fVar = f145265b;
            }
            return fVar;
        }
        return f145265b;
    }

    public void b() {
        synchronized (this.f145267a) {
            com.tencent.luggage.wxa.np.e.c("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
            if (f145266c.size() != 0) {
                for (int i3 = 0; i3 < f145266c.size(); i3++) {
                    g.a().b(new c(f145266c.keyAt(i3)));
                }
            }
            f145266c.clear();
        }
    }

    public void d() {
        synchronized (this.f145267a) {
            com.tencent.luggage.wxa.np.e.c("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
            if (f145266c.size() != 0) {
                for (int i3 = 0; i3 < f145266c.size(); i3++) {
                    g.a().b(new d(f145266c.keyAt(i3)));
                }
            }
        }
    }

    public boolean a(com.tencent.luggage.wxa.xp.d dVar, com.tencent.luggage.wxa.sp.e eVar) {
        if (dVar == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterTaskManager", "soter: task is null. should not happen", new Object[0]);
            return false;
        }
        if (eVar == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterTaskManager", "soter: instanceOnError is null. should not happen", new Object[0]);
            return false;
        }
        if (!dVar.f()) {
            int hashCode = dVar.hashCode();
            if (!dVar.d()) {
                com.tencent.luggage.wxa.np.e.c("Soter.SoterTaskManager", "soter: not single instance. directly execute", new Object[0]);
                synchronized (this.f145267a) {
                    f145266c.put(hashCode, dVar);
                }
                g.a().b(new a(dVar));
                return true;
            }
            synchronized (this.f145267a) {
                for (int i3 = 0; i3 < f145266c.size(); i3++) {
                    int keyAt = f145266c.keyAt(i3);
                    if (f145266c.get(keyAt) != null && ((com.tencent.luggage.wxa.xp.d) f145266c.get(keyAt)).getClass().getName().equals(dVar.getClass().getName())) {
                        com.tencent.luggage.wxa.np.e.e("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                        eVar.a(1023);
                        eVar.a("add SOTER task to queue failed. check the logcat for further information");
                        dVar.a(eVar);
                        return false;
                    }
                }
                f145266c.put(hashCode, dVar);
                g.a().b(new b(dVar));
                return true;
            }
        }
        com.tencent.luggage.wxa.np.e.a("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
        return false;
    }

    public void a(com.tencent.luggage.wxa.xp.d dVar) {
        Object[] objArr = new Object[1];
        objArr[0] = dVar != null ? Integer.valueOf(dVar.hashCode()) : "null";
        com.tencent.luggage.wxa.np.e.c("Soter.SoterTaskManager", "soter: removing task: %d", objArr);
        if (dVar == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterTaskManager", "soter: task is null", new Object[0]);
            return;
        }
        synchronized (this.f145267a) {
            if (f145266c.get(dVar.hashCode()) == null) {
                com.tencent.luggage.wxa.np.e.c("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", Integer.valueOf(dVar.hashCode()));
            } else {
                f145266c.remove(dVar.hashCode());
            }
        }
    }
}
