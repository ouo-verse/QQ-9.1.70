package com.tencent.liteav.videoconsumer.renderer;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final e f119537a;

    g(e eVar) {
        this.f119537a = eVar;
    }

    public static Runnable a(e eVar) {
        return new g(eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.c(this.f119537a);
    }
}
