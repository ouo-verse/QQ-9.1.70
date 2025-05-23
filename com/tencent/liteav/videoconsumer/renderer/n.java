package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f119563a;

    n(j jVar) {
        this.f119563a = jVar;
    }

    public static Runnable a(j jVar) {
        return new n(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.c(this.f119563a);
    }
}
