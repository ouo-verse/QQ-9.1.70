package com.tencent.beacon.base.net.call;

/* compiled from: P */
/* loaded from: classes2.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callback f77769a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f77770b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(j jVar, Callback callback) {
        this.f77770b = jVar;
        this.f77769a = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f77770b.b(this.f77769a);
    }
}
