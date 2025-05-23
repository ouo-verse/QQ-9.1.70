package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f387759a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f387760b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f387761c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f387761c = mVar;
        this.f387759a = bVar;
        this.f387760b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f387761c.a(this.f387759a);
        this.f387761c.c(this.f387760b);
    }
}
