package com.tencent.luggage.wxa.eq;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: j, reason: collision with root package name */
    public static f f125065j = new c();

    /* renamed from: k, reason: collision with root package name */
    public static f f125066k = new com.tencent.luggage.wxa.eq.b();

    /* renamed from: l, reason: collision with root package name */
    public static f f125067l = new g();

    /* renamed from: m, reason: collision with root package name */
    public static final b f125068m = new b();

    /* renamed from: a, reason: collision with root package name */
    public Object f125069a;

    /* renamed from: b, reason: collision with root package name */
    public f f125070b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.eq.a f125071c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.eq.a f125072d;

    /* renamed from: e, reason: collision with root package name */
    public volatile e f125073e;

    /* renamed from: f, reason: collision with root package name */
    public volatile e f125074f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f125075g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f125076h = false;

    /* renamed from: i, reason: collision with root package name */
    public AtomicBoolean f125077i = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.jq.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.eq.a f125078a;

        public a(com.tencent.luggage.wxa.eq.a aVar) {
            this.f125078a = aVar;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return this.f125078a.toString();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f125074f.f125069a = this.f125078a.a(e.this.f125069a);
                e.this.f125074f.a(e.this.f125074f.f125071c);
                e.this.a();
            } catch (Throwable th5) {
                try {
                    com.tencent.luggage.wxa.eq.a c16 = e.this.c();
                    if (c16 != null) {
                        Object a16 = c16.a(th5);
                        e eVar = e.this;
                        while (eVar.f125074f != null) {
                            eVar = eVar.f125074f;
                        }
                        eVar.f125069a = a16;
                        e.this.b();
                    } else {
                        throw th5;
                    }
                } catch (Throwable th6) {
                    e.this.b();
                    e.this.f125074f = null;
                    e.this.f125073e = null;
                    e.this.f125071c = null;
                    e.this.f125072d = null;
                    throw th6;
                }
            }
            e.this.f125074f = null;
            e.this.f125073e = null;
            e.this.f125071c = null;
            e.this.f125072d = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {
    }

    public e() {
    }

    public com.tencent.luggage.wxa.eq.a c() {
        return null;
    }

    public f d() {
        return this.f125070b;
    }

    public Object e() {
        try {
            if (this.f125069a == null) {
                synchronized (this.f125075g) {
                    if (this.f125069a == null) {
                        this.f125076h = true;
                        LockMethodProxy.wait(this.f125075g);
                        this.f125076h = false;
                    }
                }
            }
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        return this.f125069a;
    }

    public static e a(Object obj) {
        return new e(obj);
    }

    public e b(com.tencent.luggage.wxa.eq.a aVar) {
        Objects.requireNonNull(aVar);
        e eVar = new e();
        eVar.f125070b = d();
        eVar.f125073e = null;
        this.f125074f = eVar;
        this.f125071c = aVar;
        this.f125077i.compareAndSet(false, true);
        a(aVar);
        return eVar;
    }

    public void a(com.tencent.luggage.wxa.eq.a aVar) {
        if (aVar == null) {
            a();
            return;
        }
        a aVar2 = new a(aVar);
        if (this.f125069a != null) {
            f fVar = this.f125070b;
            if (fVar == null) {
                aVar2.run();
            } else {
                fVar.execute(aVar2);
            }
        }
    }

    public e(Object obj) {
        this.f125069a = obj;
    }

    public final void a() {
        if (this.f125076h) {
            synchronized (this.f125075g) {
                if (this.f125076h) {
                    this.f125075g.notifyAll();
                }
            }
        }
    }

    public final void b() {
        for (e eVar = this; eVar != null; eVar = eVar.f125074f) {
            eVar.a();
        }
    }
}
