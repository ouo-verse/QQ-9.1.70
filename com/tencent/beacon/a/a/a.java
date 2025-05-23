package com.tencent.beacon.a.a;

/* compiled from: P */
/* loaded from: classes2.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f77576a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f77577b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f77577b = bVar;
        this.f77576a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f77577b.b(this.f77576a);
    }
}
