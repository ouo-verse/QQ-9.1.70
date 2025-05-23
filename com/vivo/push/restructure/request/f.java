package com.vivo.push.restructure.request;

/* compiled from: P */
/* loaded from: classes15.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f387836a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f387837b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, b bVar) {
        this.f387837b = eVar;
        this.f387836a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f387836a;
        if (bVar != null && bVar.b() != null) {
            this.f387836a.b().a(1003);
        }
    }
}
