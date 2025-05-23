package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tu implements ol {

    /* renamed from: a, reason: collision with root package name */
    private oq f151107a;

    /* renamed from: b, reason: collision with root package name */
    private tz f151108b;

    /* renamed from: c, reason: collision with root package name */
    private om f151109c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f151110d;

    public tu(tr trVar, String str) {
        this.f151108b = trVar;
        this.f151107a = new tx(trVar.H(), str);
        this.f151109c = new tv(trVar.H(), str);
    }

    @Override // com.tencent.mapsdk.internal.ol
    public final boolean a() {
        return this.f151110d;
    }

    @Override // com.tencent.mapsdk.internal.ol
    public final void b() {
        this.f151110d = true;
    }

    @Override // com.tencent.mapsdk.internal.ol
    public final oq c() {
        return this.f151107a;
    }

    @Override // com.tencent.mapsdk.internal.ol
    public final lu d() {
        return new tt(this.f151108b);
    }

    @Override // com.tencent.mapsdk.internal.ol
    public final om e() {
        return this.f151109c;
    }
}
