package com.tencent.luggage.wxa.bk;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f123016a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public volatile b f123017b;

    /* renamed from: c, reason: collision with root package name */
    public final d f123018c;

    /* renamed from: d, reason: collision with root package name */
    public final c f123019d;

    /* renamed from: e, reason: collision with root package name */
    public final String f123020e;

    /* renamed from: f, reason: collision with root package name */
    public long f123021f;

    /* renamed from: g, reason: collision with root package name */
    public long f123022g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public long f123023a;

        public c() {
        }

        @Override // com.tencent.luggage.wxa.bk.o.b
        public void a() {
            o.this.f123021f = w0.c() - this.f123023a;
        }

        @Override // com.tencent.luggage.wxa.bk.o.b
        public void b() {
            this.f123023a = w0.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public long f123025a;

        public d() {
        }

        @Override // com.tencent.luggage.wxa.bk.o.b
        public void a() {
            o.this.f123022g = w0.c() - this.f123025a;
        }

        @Override // com.tencent.luggage.wxa.bk.o.b
        public void b() {
            this.f123025a = w0.c();
        }
    }

    public o(String str) {
        this.f123018c = new d();
        this.f123019d = new c();
        this.f123020e = str;
        this.f123017b = new e();
    }

    public boolean c() {
        if (1 == this.f123016a.get()) {
            return true;
        }
        return false;
    }

    public void d() {
        this.f123016a.set(-1);
        this.f123017b = new e();
    }

    public boolean e() {
        boolean z16;
        if (this.f123016a.getAndSet(2) != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        w.a("Luggage.StayingRecorder", "%s toBackground, changed:%b", this.f123020e, Boolean.valueOf(z16));
        if (z16) {
            this.f123017b.a();
            c cVar = this.f123019d;
            this.f123017b = cVar;
            cVar.b();
        }
        return z16;
    }

    public boolean f() {
        boolean z16;
        if (this.f123016a.getAndSet(1) != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        w.a("Luggage.StayingRecorder", "%s toForeground, changed:%b", this.f123020e, Boolean.valueOf(z16));
        if (z16) {
            this.f123017b.a();
            d dVar = this.f123018c;
            this.f123017b = dVar;
            dVar.b();
        }
        return z16;
    }

    public long a() {
        return this.f123022g;
    }

    public boolean b() {
        int i3 = this.f123016a.get();
        return -1 == i3 || 2 == i3;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class e implements b {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.bk.o.b
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.bk.o.b
        public void b() {
        }
    }
}
