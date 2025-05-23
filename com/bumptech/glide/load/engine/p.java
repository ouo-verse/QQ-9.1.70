package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import i0.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class p<Z> implements q<Z>, a.f {

    /* renamed from: i, reason: collision with root package name */
    private static final Pools.Pool<p<?>> f31744i = i0.a.d(20, new a());

    /* renamed from: d, reason: collision with root package name */
    private final i0.c f31745d = i0.c.a();

    /* renamed from: e, reason: collision with root package name */
    private q<Z> f31746e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f31747f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f31748h;

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements a.d<p<?>> {
        a() {
        }

        @Override // i0.a.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p<?> create() {
            return new p<>();
        }
    }

    p() {
    }

    private void a(q<Z> qVar) {
        this.f31748h = false;
        this.f31747f = true;
        this.f31746e = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <Z> p<Z> b(q<Z> qVar) {
        p<Z> pVar = (p) h0.j.d(f31744i.acquire());
        pVar.a(qVar);
        return pVar;
    }

    private void c() {
        this.f31746e = null;
        f31744i.release(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d() {
        this.f31745d.c();
        if (this.f31747f) {
            this.f31747f = false;
            if (this.f31748h) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Z get() {
        return this.f31746e.get();
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<Z> getResourceClass() {
        return this.f31746e.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.q
    public int getSize() {
        return this.f31746e.getSize();
    }

    @Override // i0.a.f
    @NonNull
    public i0.c h() {
        return this.f31745d;
    }

    @Override // com.bumptech.glide.load.engine.q
    public synchronized void recycle() {
        this.f31745d.c();
        this.f31748h = true;
        if (!this.f31747f) {
            this.f31746e.recycle();
            c();
        }
    }
}
