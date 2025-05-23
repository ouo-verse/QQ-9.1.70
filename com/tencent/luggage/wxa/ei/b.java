package com.tencent.luggage.wxa.ei;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.ei.f;
import com.tencent.luggage.wxa.ei.n;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends e implements j, t, n {

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.d f124865c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.t f124866d;

    /* renamed from: e, reason: collision with root package name */
    public final f f124867e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f124868f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f124869g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f124870h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final Object f124871i = new byte[0];

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f124872j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final boolean f124873k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            synchronized (b.this.f124871i) {
                arrayList = new ArrayList(b.this.f124872j);
                b.this.f124872j.clear();
                b.this.f124872j = null;
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                return;
            }
            com.tencent.luggage.wxa.k0.d.a(it.next());
            throw null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ei.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6171b implements f.a {
        public C6171b() {
        }

        @Override // com.tencent.luggage.wxa.ei.f.a
        public com.tencent.luggage.wxa.b9.t a(int i3) {
            return b.this.f124865c.c(i3);
        }

        @Override // com.tencent.luggage.wxa.ei.f.a
        public com.tencent.luggage.wxa.b9.t a(int i3, int i16) {
            return b.this.f124865c.a(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            synchronized (b.this) {
                arrayList = new ArrayList(b.this.f124868f);
                arrayList.addAll(b.this.f124869g);
                b.this.f124868f.clear();
                b.this.f124869g.clear();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                n.a aVar = (n.a) arrayList.get(i3);
                if (aVar != null) {
                    aVar.onDestroy();
                }
            }
            if (com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g) {
                synchronized (b.this) {
                    if (b.this.f124868f.size() != 0 || b.this.f124869g.size() != 0) {
                        throw new IllegalStateException("OnDestroyListener execute failed. Add Destroy listener recursively is forbidden.");
                    }
                }
            }
        }
    }

    public b(d.a aVar) {
        boolean z16 = false;
        com.tencent.luggage.wxa.b9.d a16 = a(aVar);
        this.f124865c = a16;
        if (aVar != null && aVar.f122191g) {
            z16 = true;
        }
        this.f124873k = z16;
        this.f124866d = a(a16, f.c());
        a16.a(new a());
        f fVar = new f(new C6171b());
        this.f124867e = fVar;
        fVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f124870h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((n.a) it.next()).onDestroy();
        }
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.v
    public /* bridge */ /* synthetic */ long B() {
        return super.B();
    }

    @Override // com.tencent.luggage.wxa.ei.e
    public final com.tencent.luggage.wxa.b9.t C() {
        return this.f124866d;
    }

    public abstract com.tencent.luggage.wxa.b9.d a(d.a aVar);

    public abstract com.tencent.luggage.wxa.b9.t a(com.tencent.luggage.wxa.b9.d dVar, int i3);

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.j
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.j
    public void destroy() {
        C().h().c(new c());
        C().h().b(new Runnable() { // from class: l21.a
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.ei.b.this.D();
            }
        });
        this.f124867e.b();
        super.destroy();
        this.f124865c.e();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.p
    public /* bridge */ /* synthetic */ void evaluateJavascript(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.v
    public /* bridge */ /* synthetic */ long f() {
        return super.f();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.s
    public /* bridge */ /* synthetic */ ByteBuffer g(int i3) {
        return super.g(i3);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.m
    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.v
    public /* bridge */ /* synthetic */ long j() {
        return super.j();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.l
    public /* bridge */ /* synthetic */ x m() {
        return super.m();
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public final boolean n() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ei.t
    public final h o() {
        return this.f124867e.a();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.l
    public /* bridge */ /* synthetic */ int p() {
        return super.p();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.u
    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public final int q() {
        return f.c();
    }

    @Override // com.tencent.luggage.wxa.ei.t
    public final h s() {
        return this.f124867e.d();
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(i iVar) {
        C().a(q(), iVar);
    }

    @Override // com.tencent.luggage.wxa.ei.e
    public com.tencent.luggage.wxa.b9.d u() {
        return this.f124865c;
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.m
    public /* bridge */ /* synthetic */ boolean w() {
        return super.w();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.s
    public /* bridge */ /* synthetic */ int b(int i3) {
        return super.b(i3);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.q
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.q
    public /* bridge */ /* synthetic */ String d() {
        return super.d();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.s
    public /* bridge */ /* synthetic */ void e(int i3) {
        super.e(i3);
    }

    @Override // com.tencent.luggage.wxa.ei.t
    public final h f(int i3) {
        return this.f124867e.c(i3);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.q
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.v
    public /* bridge */ /* synthetic */ void a(ArrayList arrayList, String str, t.s sVar) {
        super.a(arrayList, str, sVar);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.q
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.tencent.luggage.wxa.ei.t
    public final void c(int i3) {
        this.f124867e.b(i3);
    }

    @Override // com.tencent.luggage.wxa.ei.t
    public h d(int i3) {
        return this.f124867e.a(i3);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.l
    public /* bridge */ /* synthetic */ boolean e() {
        return super.e();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.l
    public /* bridge */ /* synthetic */ void a(long j3, long j16) {
        super.a(j3, j16);
    }

    @Override // com.tencent.luggage.wxa.ei.n
    public synchronized void b(n.a aVar) {
        a(aVar, false);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.j
    public /* bridge */ /* synthetic */ void a(URL url, String str, ValueCallback valueCallback) {
        super.a(url, str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.j
    public /* bridge */ /* synthetic */ void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
        super.a(url, str, str2, i3, str3, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.v
    public /* bridge */ /* synthetic */ void a(URL url, String str, String str2, int i3, String str3, t.s sVar) {
        super.a(url, str, str2, i3, str3, sVar);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.m
    public /* bridge */ /* synthetic */ void a(String str, String str2, ValueCallback valueCallback) {
        super.a(str, str2, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.h
    public /* bridge */ /* synthetic */ void a(String str, ValueCallback valueCallback) {
        super.a(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.l
    public /* bridge */ /* synthetic */ ByteBuffer a(int i3, boolean z16) {
        return super.a(i3, z16);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.q
    public /* bridge */ /* synthetic */ void a(Runnable runnable) {
        super.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.q
    public /* bridge */ /* synthetic */ void a(Runnable runnable, boolean z16) {
        super.a(runnable, z16);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.h
    public /* bridge */ /* synthetic */ void a(Object obj) {
        super.a(obj);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.u
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.l
    public /* bridge */ /* synthetic */ void a(x xVar) {
        super.a(xVar);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.h
    public /* bridge */ /* synthetic */ void a(String str, Object obj) {
        super.a(str, obj);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.l
    public /* bridge */ /* synthetic */ void a(int i3, ByteBuffer byteBuffer) {
        super.a(i3, byteBuffer);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.q
    public /* bridge */ /* synthetic */ void a(int i3) {
        super.a(i3);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.h
    public /* bridge */ /* synthetic */ void a(h hVar, String str) {
        super.a(hVar, str);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.m
    public /* bridge */ /* synthetic */ void a(String str, boolean z16) {
        super.a(str, z16);
    }

    @Override // com.tencent.luggage.wxa.ei.e, com.tencent.luggage.wxa.ei.j
    public final k a(Class cls) {
        if (cls != o.class || this.f124873k) {
            return super.a(cls);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.ei.t
    public final List a(boolean z16) {
        return this.f124867e.a(z16);
    }

    @Override // com.tencent.luggage.wxa.ei.n
    public synchronized void a(n.a aVar, boolean z16) {
        if (z16) {
            this.f124869g.add(aVar);
        } else {
            this.f124868f.add(aVar);
        }
    }

    @Override // com.tencent.luggage.wxa.ei.n
    public synchronized void a(n.a aVar) {
        this.f124870h.add(aVar);
    }
}
