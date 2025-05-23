package com.tencent.liteav.videoconsumer.renderer;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final e f119538a;

    h(e eVar) {
        this.f119538a = eVar;
    }

    public static Runnable a(e eVar) {
        return new h(eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.b(this.f119538a);
    }
}
