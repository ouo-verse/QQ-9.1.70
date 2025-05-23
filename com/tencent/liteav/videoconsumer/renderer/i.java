package com.tencent.liteav.videoconsumer.renderer;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final e f119539a;

    i(e eVar) {
        this.f119539a = eVar;
    }

    public static Runnable a(e eVar) {
        return new i(eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119539a.b();
    }
}
