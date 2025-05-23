package com.google.common.cache;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final g f34818a = LongAddables.a();

    /* renamed from: b, reason: collision with root package name */
    private final g f34819b = LongAddables.a();

    /* renamed from: c, reason: collision with root package name */
    private final g f34820c = LongAddables.a();

    /* renamed from: d, reason: collision with root package name */
    private final g f34821d = LongAddables.a();

    /* renamed from: e, reason: collision with root package name */
    private final g f34822e = LongAddables.a();

    /* renamed from: f, reason: collision with root package name */
    private final g f34823f = LongAddables.a();

    @Override // com.google.common.cache.b
    public void a(int i3) {
        this.f34818a.add(i3);
    }

    @Override // com.google.common.cache.b
    public void b() {
        this.f34823f.increment();
    }

    @Override // com.google.common.cache.b
    public void c(long j3) {
        this.f34820c.increment();
        this.f34822e.add(j3);
    }

    @Override // com.google.common.cache.b
    public void d(int i3) {
        this.f34819b.add(i3);
    }

    @Override // com.google.common.cache.b
    public d e() {
        return new d(this.f34818a.sum(), this.f34819b.sum(), this.f34820c.sum(), this.f34821d.sum(), this.f34822e.sum(), this.f34823f.sum());
    }

    @Override // com.google.common.cache.b
    public void f(long j3) {
        this.f34821d.increment();
        this.f34822e.add(j3);
    }

    public void g(b bVar) {
        d e16 = bVar.e();
        this.f34818a.add(e16.b());
        this.f34819b.add(e16.e());
        this.f34820c.add(e16.d());
        this.f34821d.add(e16.c());
        this.f34822e.add(e16.f());
        this.f34823f.add(e16.a());
    }
}
