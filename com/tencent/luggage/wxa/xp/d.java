package com.tencent.luggage.wxa.xp;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.sp.b f145255a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f145256b = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.sp.e f145257a;

        public a(com.tencent.luggage.wxa.sp.e eVar) {
            this.f145257a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(this.f145257a);
        }
    }

    public abstract void b();

    public final void b(com.tencent.luggage.wxa.sp.e eVar) {
        com.tencent.luggage.wxa.sp.b bVar = this.f145255a;
        if (bVar != null && !this.f145256b) {
            bVar.a(eVar);
            this.f145256b = true;
        }
    }

    public abstract void c(com.tencent.luggage.wxa.sp.e eVar);

    public boolean c() {
        return this.f145256b;
    }

    public abstract boolean d();

    public abstract void e();

    public abstract boolean f();

    public void a(com.tencent.luggage.wxa.sp.b bVar) {
        this.f145255a = bVar;
    }

    public synchronized void a(com.tencent.luggage.wxa.sp.e eVar) {
        if (this.f145256b) {
            com.tencent.luggage.wxa.np.e.e("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
            return;
        }
        c(eVar);
        f.c().a(this);
        g.a().a(new a(eVar));
    }
}
