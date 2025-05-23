package com.tencent.luggage.wxa.v3;

import android.content.Context;
import com.tencent.luggage.wxa.qc.c;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements com.tencent.luggage.wxa.v3.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.d f143049a;

    /* renamed from: b, reason: collision with root package name */
    public final c.InterfaceC6640c f143050b;

    /* renamed from: c, reason: collision with root package name */
    public final int f143051c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentSkipListSet f143052d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.InterfaceC6640c {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (com.tencent.luggage.wxa.qc.b.FOREGROUND == bVar) {
                Iterator it = c.this.f143052d.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Runnable runnable, Runnable runnable2) {
            return runnable.hashCode() - runnable2.hashCode();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.v3.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6818c {
        public static c a(com.tencent.luggage.wxa.ic.d dVar) {
            return new c(dVar);
        }
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public com.tencent.luggage.wxa.h1.b b(Class cls) {
        return this.f143049a.b(cls);
    }

    public void c() {
        Iterator it = this.f143052d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public int d() {
        return this.f143051c;
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public String f() {
        try {
            return this.f143049a.getRuntime().Y().getCurrentPage().getCurrentPageView().n0();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.tencent.luggage.wxa.v3.b
    /* renamed from: getAppId */
    public String getF140742c() {
        return this.f143049a.getAppId();
    }

    @Override // com.tencent.luggage.wxa.v3.b
    /* renamed from: getContext */
    public Context getF140743d() {
        return this.f143049a.getContext();
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public boolean h() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public String j() {
        try {
            return this.f143049a.getRuntime().Y().getCurrentUrl();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public void release() {
        if (this.f143049a.getRuntime() != null) {
            this.f143049a.getRuntime().c0().b(this.f143050b);
        }
        this.f143052d.clear();
    }

    public c(com.tencent.luggage.wxa.ic.d dVar) {
        a aVar = new a();
        this.f143050b = aVar;
        this.f143052d = new ConcurrentSkipListSet(new b());
        this.f143049a = dVar;
        if (dVar.getRuntime() != null) {
            dVar.getRuntime().c0().a(aVar);
            this.f143051c = dVar.getRuntime().l0();
        } else {
            this.f143051c = 0;
        }
    }

    public com.tencent.luggage.wxa.ic.d a() {
        return this.f143049a;
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public String b() {
        return this.f143049a.getContext().getClass().getName();
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public com.tencent.luggage.wxa.xd.o a(String str) {
        return this.f143049a.a(str);
    }

    @Override // com.tencent.luggage.wxa.vo.b
    public void b(com.tencent.luggage.wxa.vo.a aVar) {
        if (this.f143049a.getRuntime() != null) {
            this.f143049a.getRuntime().b(aVar);
        }
    }

    @Override // com.tencent.luggage.wxa.v3.b
    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f143052d.add(runnable);
    }
}
