package com.tencent.luggage.wxa.w8;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public Object f144116a;

    /* renamed from: c, reason: collision with root package name */
    public final long f144118c;

    /* renamed from: d, reason: collision with root package name */
    public long f144119d;

    /* renamed from: e, reason: collision with root package name */
    public long f144120e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f144121f;

    /* renamed from: b, reason: collision with root package name */
    public Object f144117b = new Object();

    /* renamed from: g, reason: collision with root package name */
    public Runnable f144122g = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.SDK.SyncTask", "task run manualFinish = " + d.this.f144121f, new Object[0]);
            if (d.this.f144121f) {
                d.this.a();
            } else {
                d dVar = d.this;
                dVar.a(dVar.a());
            }
            d dVar2 = d.this;
            dVar2.f144120e = h.a(dVar2.f144119d);
        }
    }

    public d(long j3, Object obj, boolean z16) {
        this.f144121f = false;
        this.f144118c = j3;
        this.f144116a = obj;
        this.f144121f = z16;
    }

    public abstract Object a();

    public void a(Object obj) {
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.SDK.SyncTask", "setResultFinish ", new Object[0]);
        this.f144116a = obj;
        synchronized (this.f144117b) {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.SDK.SyncTask", "setResultFinish synchronized", new Object[0]);
            this.f144117b.notify();
        }
    }

    public Object a(com.tencent.luggage.wxa.r8.a aVar) {
        if (aVar == null) {
            com.tencent.luggage.wxa.p8.f.a("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now", new Object[0]);
            return a();
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.SDK.SyncTask", "sync task exec...", new Object[0]);
        this.f144119d = h.a();
        try {
            synchronized (this.f144117b) {
                com.tencent.luggage.wxa.p8.f.c("MicroMsg.SDK.SyncTask", "sync task exec at synchronized", new Object[0]);
                aVar.a(this.f144122g, false);
                this.f144117b.wait(this.f144118c);
            }
        } catch (InterruptedException e16) {
            com.tencent.luggage.wxa.p8.f.a("MicroMsg.SDK.SyncTask", e16, "", new Object[0]);
        }
        long a16 = h.a(this.f144119d);
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", "" + this.f144116a, Long.valueOf(a16), Long.valueOf(this.f144120e), Long.valueOf(a16 - this.f144120e));
        return this.f144116a;
    }
}
