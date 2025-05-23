package com.tencent.liteav.videoconsumer.renderer;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f119564a;

    o(j jVar) {
        this.f119564a = jVar;
    }

    public static Runnable a(j jVar) {
        return new o(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.b(this.f119564a);
    }
}
