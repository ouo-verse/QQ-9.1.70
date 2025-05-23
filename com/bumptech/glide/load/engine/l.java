package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
class l<Z> implements q<Z> {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f31732d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f31733e;

    /* renamed from: f, reason: collision with root package name */
    private final q<Z> f31734f;

    /* renamed from: h, reason: collision with root package name */
    private final a f31735h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.c f31736i;

    /* renamed from: m, reason: collision with root package name */
    private int f31737m;

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface a {
        void a(com.bumptech.glide.load.c cVar, l<?> lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(q<Z> qVar, boolean z16, boolean z17, com.bumptech.glide.load.c cVar, a aVar) {
        this.f31734f = (q) h0.j.d(qVar);
        this.f31732d = z16;
        this.f31733e = z17;
        this.f31736i = cVar;
        this.f31735h = (a) h0.j.d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.C) {
            this.f31737m++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<Z> b() {
        return this.f31734f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f31732d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        boolean z16;
        synchronized (this) {
            int i3 = this.f31737m;
            if (i3 > 0) {
                z16 = true;
                int i16 = i3 - 1;
                this.f31737m = i16;
                if (i16 != 0) {
                    z16 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z16) {
            this.f31735h.a(this.f31736i, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Z get() {
        return this.f31734f.get();
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<Z> getResourceClass() {
        return this.f31734f.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.q
    public int getSize() {
        return this.f31734f.getSize();
    }

    @Override // com.bumptech.glide.load.engine.q
    public synchronized void recycle() {
        if (this.f31737m <= 0) {
            if (!this.C) {
                this.C = true;
                if (this.f31733e) {
                    this.f31734f.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f31732d + ", listener=" + this.f31735h + ", key=" + this.f31736i + ", acquired=" + this.f31737m + ", isRecycled=" + this.C + ", resource=" + this.f31734f + '}';
    }
}
