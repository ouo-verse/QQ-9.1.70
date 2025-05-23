package com.tencent.luggage.wxa.tn;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f141708a;

    /* renamed from: b, reason: collision with root package name */
    public Object f141709b;

    /* renamed from: c, reason: collision with root package name */
    public final long f141710c;

    /* renamed from: d, reason: collision with root package name */
    public long f141711d;

    /* renamed from: e, reason: collision with root package name */
    public long f141712e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f141713f;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f141714g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.SDK.SyncTask", "task run manualFinish = " + s0.this.f141713f);
            if (s0.this.f141713f) {
                s0.this.a();
            } else {
                s0 s0Var = s0.this;
                s0Var.a(s0Var.a());
            }
            s0 s0Var2 = s0.this;
            s0Var2.f141712e = w0.e(s0Var2.f141711d);
        }
    }

    public s0() {
        this(0L, null);
    }

    public abstract Object a();

    public s0(long j3, Object obj) {
        this.f141709b = new Object();
        this.f141713f = false;
        this.f141714g = new a();
        this.f141710c = j3;
        this.f141708a = obj;
    }

    public void a(Object obj) {
        w.d("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.f141708a = obj;
        synchronized (this.f141709b) {
            w.d("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.f141709b.notify();
        }
    }

    public Object a(b0 b0Var) {
        boolean equals;
        if (b0Var == null) {
            w.a("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return a();
        }
        w.d("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (b0Var.a() != null) {
            equals = Thread.currentThread().getId() == b0Var.a().getThread().getId();
        } else {
            equals = b0Var.b().equals(com.tencent.luggage.wxa.kq.a.e());
        }
        if (equals) {
            w.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return a();
        }
        this.f141711d = w0.a();
        try {
            synchronized (this.f141709b) {
                w.d("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                b0Var.a(this.f141714g);
                this.f141709b.wait(this.f141710c);
            }
        } catch (InterruptedException e16) {
            w.a("MicroMsg.SDK.SyncTask", e16, "", new Object[0]);
        }
        long e17 = w0.e(this.f141711d);
        w.d("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", "" + this.f141708a, Long.valueOf(e17), Long.valueOf(this.f141712e), Long.valueOf(e17 - this.f141712e));
        return this.f141708a;
    }
}
