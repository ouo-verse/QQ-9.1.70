package com.tencent.luggage.wxa.sm;

import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: d, reason: collision with root package name */
    private static final String f140398d = "MicroMsg.Music.BasePlayer";

    /* renamed from: a, reason: collision with root package name */
    protected f f140399a;

    /* renamed from: b, reason: collision with root package name */
    protected com.tencent.luggage.wxa.rb.d f140400b;

    /* renamed from: c, reason: collision with root package name */
    protected g f140401c = new g();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f140402a;

        public a(boolean z16) {
            this.f140402a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(b.f140398d, "onError, needRetry:%b", Boolean.valueOf(this.f140402a));
            b bVar = b.this;
            bVar.f140399a.a(bVar.f140400b, this.f140402a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sm.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6724b implements Runnable {
        public RunnableC6724b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(b.f140398d, "onStart %b", Boolean.valueOf(b.this.e()));
            b bVar = b.this;
            bVar.f140399a.a(bVar.f140400b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f140405a;

        public c(int i3) {
            this.f140405a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.d()) {
                b bVar = b.this;
                bVar.f140399a.a(bVar.f140400b, this.f140405a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f140407a;

        public d(boolean z16) {
            this.f140407a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(b.f140398d, "onStop, isComplete:%b", Boolean.valueOf(this.f140407a));
            b bVar = b.this;
            bVar.f140399a.b(bVar.f140400b, this.f140407a);
        }
    }

    public abstract int a();

    public abstract void a(long j3);

    public void a(f fVar) {
        this.f140399a = fVar;
    }

    public abstract void a(String str);

    public abstract int b();

    public void b(boolean z16) {
        if (this.f140399a != null) {
            c0.a(new d(z16));
        }
    }

    public abstract String c();

    public abstract boolean d();

    public abstract boolean e();

    public void f() {
        if (this.f140399a != null) {
            c0.a(new RunnableC6724b());
        }
    }

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public void a(com.tencent.luggage.wxa.rb.d dVar) {
        this.f140400b = dVar;
    }

    public void a(boolean z16) {
        if (this.f140399a != null) {
            c0.a(new a(z16));
        }
    }

    public void a(int i3) {
        if (this.f140399a != null) {
            c0.a(new c(i3));
        }
    }
}
