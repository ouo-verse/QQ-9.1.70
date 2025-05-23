package com.tencent.beacon.base.net.call;

/* compiled from: P */
/* loaded from: classes2.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callback f77771a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f77772b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j jVar, Callback callback) {
        this.f77772b = jVar;
        this.f77771a = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f77772b.b(this.f77771a);
    }
}
