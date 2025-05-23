package com.tencent.luggage.wxa.vc;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.dd.b;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.dd.b {
    public volatile long C;
    public volatile long D;
    public volatile int E;
    public volatile long F;
    public volatile long G;
    public String I;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f143317a;

    /* renamed from: b, reason: collision with root package name */
    public JSONArray f143318b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.dd.c f143319c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.vc.d f143320d;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.dd.b f143322f;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f143323g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f143324h;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f143327k;

    /* renamed from: l, reason: collision with root package name */
    public volatile long f143328l;

    /* renamed from: i, reason: collision with root package name */
    public Runnable f143325i = new a();

    /* renamed from: j, reason: collision with root package name */
    public Runnable f143326j = new RunnableC6839b();

    /* renamed from: m, reason: collision with root package name */
    public volatile int f143329m = 0;
    public boolean H = true;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.vc.c f143321e = new com.tencent.luggage.wxa.vc.c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.G = 0L;
            b.this.f143324h = true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vc.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6839b implements Runnable {
        public RunnableC6839b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16 = b.this.f143324h;
            b.this.f143324h = false;
            w.d("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", Boolean.valueOf(z16), Boolean.valueOf(b.this.f()));
            if (z16 && b.this.f()) {
                b.this.f143322f.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONArray f143332a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b.a f143333b;

        public c(JSONArray jSONArray, b.a aVar) {
            this.f143332a = jSONArray;
            this.f143333b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.dd.c cVar = b.this.f143319c;
            b.this.f143319c = null;
            b.this.f143318b = this.f143332a;
            b.this.H = true;
            b.this.f143317a = true;
            b.a aVar = this.f143333b;
            if (aVar != null) {
                aVar.a(cVar);
            }
            b.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONArray f143335a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b.a f143336b;

        public d(JSONArray jSONArray, b.a aVar) {
            this.f143335a = jSONArray;
            this.f143336b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.H = true;
            if (b.this.f143318b == null) {
                b.this.f143318b = this.f143335a;
            } else {
                for (int i3 = 0; i3 < this.f143335a.length(); i3++) {
                    b.this.f143318b.mo162put(this.f143335a.opt(i3));
                }
            }
            b.this.f143317a = true;
            b.a aVar = this.f143336b;
            if (aVar != null) {
                aVar.a(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e implements com.tencent.luggage.wxa.vc.a {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f143338a;

        public e(com.tencent.luggage.wxa.dd.b bVar) {
            this.f143338a = new WeakReference(bVar);
        }

        @Override // com.tencent.luggage.wxa.vc.a
        public void invalidate() {
            com.tencent.luggage.wxa.dd.b bVar = (com.tencent.luggage.wxa.dd.b) this.f143338a.get();
            if (bVar == null) {
                return;
            }
            bVar.a();
        }
    }

    public b(com.tencent.luggage.wxa.dd.b bVar) {
        this.f143322f = bVar;
        this.f143320d = new com.tencent.luggage.wxa.vc.d(new e(bVar));
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void a() {
    }

    public boolean f() {
        return this.f143317a;
    }

    public void g() {
        this.f143327k = 0L;
        this.f143322f.a(this.f143325i);
    }

    public void h() {
        this.f143322f.a(this.f143326j);
    }

    public void a(com.tencent.luggage.wxa.cd.a aVar) {
    }

    public String d() {
        return this.f143323g;
    }

    public String e() {
        return this.I;
    }

    public final void b() {
        if (this.f143328l != 0) {
            this.C += System.nanoTime() - this.f143328l;
            this.f143328l = 0L;
            this.f143329m++;
        }
    }

    public final boolean c(Canvas canvas) {
        this.f143320d.a(true);
        if (this.f143319c == null) {
            this.f143317a = false;
            return false;
        }
        if (this.f143319c.c() && !this.f143319c.d()) {
            return a(canvas, this.f143319c.b());
        }
        this.f143317a = false;
        List<com.tencent.luggage.wxa.xc.d> a16 = this.f143319c == null ? null : this.f143319c.a();
        if (a16 == null || a16.size() == 0) {
            return false;
        }
        long j3 = this.f143327k;
        long nanoTime = System.nanoTime();
        this.f143320d.h();
        for (com.tencent.luggage.wxa.xc.d dVar : a16) {
            try {
                if (dVar != null) {
                    try {
                        int i3 = dVar.f144673a;
                        if (i3 == 1) {
                            this.f143321e.a(this.f143320d, canvas, dVar.f144675c);
                            throw new IllegalStateException("please use draw obj " + dVar.f144675c.toString());
                            break;
                        }
                        if (i3 != 2) {
                            w.h("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", Integer.valueOf(i3));
                        } else {
                            this.f143321e.a(this.f143320d, canvas, dVar.f144674b);
                        }
                    } catch (Exception e16) {
                        w.b("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e16);
                    }
                }
            } catch (Exception e17) {
                w.a("MicroMsg.DrawActionDelegateImpl", e17, "", new Object[0]);
            }
        }
        a(j3, nanoTime, System.nanoTime());
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f143324h) {
            this.G = currentTimeMillis;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public boolean a(Canvas canvas) {
        if (this.H) {
            return b(canvas);
        }
        return c(canvas);
    }

    public final boolean b(Canvas canvas) {
        this.f143320d.a(false);
        return a(canvas, this.f143318b);
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void b(JSONArray jSONArray, b.a aVar) {
        this.f143322f.a(new c(jSONArray, aVar));
    }

    public final void a(long j3, long j16, long j17) {
        long j18 = j17 - j16;
        if (j3 != 0) {
            this.F += j18;
            this.D += j17 - j3;
            this.E++;
        }
    }

    public void b(String str) {
        this.I = str;
    }

    public final boolean a(Canvas canvas, JSONArray jSONArray) {
        this.f143317a = false;
        if (jSONArray == null || jSONArray.length() == 0) {
            return false;
        }
        long j3 = this.f143327k;
        long nanoTime = System.nanoTime();
        this.f143320d.h();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                try {
                    this.f143321e.a(this.f143320d, canvas, optJSONObject);
                } catch (Exception e16) {
                    w.b("MicroMsg.DrawActionDelegateImpl", "drawAction error with method[%s], exception : %s", optJSONObject.optString("method"), e16);
                }
            }
        }
        a(j3, nanoTime, System.nanoTime());
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f143324h) {
            this.G = currentTimeMillis;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void a(JSONArray jSONArray, b.a aVar) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.f143322f.a(new d(jSONArray, aVar));
    }

    public com.tencent.luggage.wxa.vc.d c() {
        return this.f143320d;
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void a(Runnable runnable) {
        if (equals(this.f143322f)) {
            return;
        }
        c0.a(runnable);
    }

    public void a(String str) {
        this.f143323g = str;
    }

    public void a(long j3) {
        this.f143327k = j3;
        this.f143328l = j3;
    }
}
