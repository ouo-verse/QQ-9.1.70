package com.tencent.luggage.wxa.g9;

import android.os.Process;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends l {

    /* renamed from: e, reason: collision with root package name */
    public m f126618e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f126619f;

    /* renamed from: g, reason: collision with root package name */
    public n f126620g;

    public b(m mVar, String str, int i3) {
        super(str, i3);
        this.f126619f = false;
        this.f126618e = mVar;
    }

    @Override // com.tencent.luggage.wxa.g9.l
    public void a() {
        this.f126619f = false;
    }

    public void b() {
        this.f126620g = null;
    }

    public n c() {
        return this.f126620g;
    }

    public boolean d() {
        if (this.f126620g == null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f126619f;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeTask", "run task %s", this.f126660a);
        if (this.f126619f) {
            return;
        }
        Process.setThreadPriority(-16);
        this.f126618e.a(this.f126620g);
        this.f126618e.a(this);
        this.f126619f = true;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeTask", "run task %s end", this.f126660a);
    }

    public void a(n nVar) {
        this.f126620g = nVar;
        this.f126662c = System.currentTimeMillis();
    }
}
