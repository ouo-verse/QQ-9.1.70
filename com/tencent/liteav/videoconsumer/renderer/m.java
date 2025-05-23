package com.tencent.liteav.videoconsumer.renderer;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f119561a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f119562b;

    m(j jVar, boolean z16) {
        this.f119561a = jVar;
        this.f119562b = z16;
    }

    public static Runnable a(j jVar, boolean z16) {
        return new m(jVar, z16);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a(this.f119561a, this.f119562b);
    }
}
