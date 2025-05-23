package com.vivo.push.restructure.a.a;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes15.dex */
final class g extends a<com.vivo.push.restructure.a.a> {

    /* renamed from: b, reason: collision with root package name */
    private long f387786b;

    public g(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("IPCNode", aVar, iVar);
        this.f387786b = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long d16 = aVar.d();
        if (d16 > 0 && elapsedRealtime > d16) {
            this.f387786b = elapsedRealtime - d16;
        }
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return 0;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final synchronized String b() {
        a(this.f387786b);
        return super.b();
    }
}
