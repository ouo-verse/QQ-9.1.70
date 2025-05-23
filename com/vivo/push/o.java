package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f387755a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f387756b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f387757c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f387757c = mVar;
        this.f387755a = bVar;
        this.f387756b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f387757c.a(this.f387755a);
        this.f387757c.c(this.f387756b);
    }
}
