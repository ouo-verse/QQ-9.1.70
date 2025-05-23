package com.tencent.luggage.wxa.h9;

import android.os.Process;
import com.tencent.luggage.wxa.g9.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends l {

    /* renamed from: e, reason: collision with root package name */
    public g f126939e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f126940f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.l9.c f126941g;

    public c(g gVar, String str, int i3) {
        super(str, i3);
        this.f126940f = false;
        this.f126939e = gVar;
    }

    @Override // com.tencent.luggage.wxa.g9.l
    public void a() {
        this.f126940f = false;
    }

    public void b() {
        this.f126941g = null;
    }

    public g c() {
        return this.f126939e;
    }

    public boolean d() {
        if (this.f126941g == null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f126940f;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadTask", "run task %s", this.f126660a);
        if (this.f126940f) {
            this.f126939e.a(this);
            return;
        }
        Process.setThreadPriority(10);
        this.f126939e.a(this.f126941g);
        this.f126939e.a(this);
        this.f126940f = true;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDownloadTask", "run task %s end", this.f126660a);
    }

    public void a(com.tencent.luggage.wxa.l9.c cVar) {
        this.f126941g = cVar;
        this.f126662c = System.currentTimeMillis();
    }
}
