package com.tencent.luggage.wxa.yo;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public volatile d f146047a;

    /* renamed from: b, reason: collision with root package name */
    public volatile b f146048b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uo.b f146049a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f146050b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f146051c;

        public a(com.tencent.luggage.wxa.uo.b bVar, Object obj, RuntimeException runtimeException) {
            this.f146049a = bVar;
            this.f146050b = obj;
            this.f146051c = runtimeException;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f146048b != null) {
                e.this.f146048b.b();
            }
            try {
                Object a16 = com.tencent.luggage.wxa.uo.a.a(this.f146049a, this.f146050b);
                if (e.this.f146048b != null) {
                    e.this.f146048b.a(a16);
                }
            } catch (ClassCastException e16) {
                this.f146051c.initCause(e16);
                throw this.f146051c;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void a(Object obj);

        void b();
    }

    public e(d dVar, b bVar) {
        a(dVar);
        a(bVar);
    }

    public final void b(d dVar) {
        this.f146047a = dVar;
    }

    public final void a(b bVar) {
        this.f146048b = bVar;
    }

    public final synchronized void b(com.tencent.luggage.wxa.uo.b bVar, Object obj, long j3, boolean z16) {
        d dVar = this.f146047a;
        if (dVar == null) {
            if (this.f146048b != null) {
                this.f146048b.a();
            }
            return;
        }
        a aVar = new a(bVar, obj, new RuntimeException("object is not right: " + obj));
        if (j3 < 0) {
            if (z16 && f.a() == dVar) {
                aVar.run();
            } else {
                dVar.a(aVar);
            }
        } else {
            dVar.a(aVar, j3);
        }
    }

    public synchronized void a(d dVar) {
        b(dVar);
    }

    public void a(com.tencent.luggage.wxa.uo.b bVar, Object obj, boolean z16) {
        a(bVar, obj, -1L, z16);
    }

    public void a(com.tencent.luggage.wxa.uo.b bVar, Object obj, long j3, boolean z16) {
        b(bVar, obj, j3, z16);
    }
}
