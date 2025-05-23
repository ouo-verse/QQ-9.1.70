package com.tencent.luggage.wxa.qc;

import android.os.Looper;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public Object f138670a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f138671b;

    /* renamed from: c, reason: collision with root package name */
    public final long f138672c;

    /* renamed from: d, reason: collision with root package name */
    public long f138673d;

    /* renamed from: e, reason: collision with root package name */
    public long f138674e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f138675f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f138676g;

    /* renamed from: h, reason: collision with root package name */
    public volatile b0 f138677h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.SDK.SyncTask", "task run manualFinish = " + i.this.f138675f);
            if (i.this.f138675f) {
                i.this.b();
            } else {
                i iVar = i.this;
                iVar.a(iVar.b());
            }
            i iVar2 = i.this;
            iVar2.f138674e = w0.e(iVar2.f138673d);
        }
    }

    public i() {
        this(0L, null);
    }

    public abstract Object b();

    public i(long j3, Object obj) {
        this.f138671b = new Object();
        this.f138675f = false;
        this.f138676g = new a();
        this.f138672c = j3;
        this.f138670a = obj;
    }

    public void a(Object obj) {
        w.d("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.f138670a = obj;
        synchronized (this.f138671b) {
            w.d("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.f138671b.notify();
        }
    }

    public void a() {
        b0 b0Var = this.f138677h;
        if (b0Var == null) {
            return;
        }
        this.f138677h.b(this.f138676g);
        if (Looper.myLooper() == b0Var.a()) {
            this.f138676g.run();
        } else {
            a(this.f138670a);
        }
    }

    public Object a(b0 b0Var) {
        if (b0Var == null) {
            w.a("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return b();
        }
        this.f138677h = b0Var;
        w.d("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == b0Var.a().getThread().getId()) {
            w.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return b();
        }
        this.f138673d = w0.a();
        try {
            synchronized (this.f138671b) {
                w.d("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                b0Var.a(this.f138676g);
                this.f138671b.wait(this.f138672c);
            }
        } catch (InterruptedException e16) {
            w.a("MicroMsg.SDK.SyncTask", e16, "", new Object[0]);
        }
        long e17 = w0.e(this.f138673d);
        w.d("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", "" + this.f138670a, Long.valueOf(e17), Long.valueOf(this.f138674e), Long.valueOf(e17 - this.f138674e));
        return this.f138670a;
    }
}
