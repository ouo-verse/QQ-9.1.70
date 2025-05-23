package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.util.LiteavLog;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f119720a;

    c(b bVar) {
        this.f119720a = bVar;
    }

    public static Runnable a(b bVar) {
        return new c(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f119720a;
        if (bVar.f119697e != null) {
            LiteavLog.w(bVar.f119693a, "onRequestRestart");
            bVar.f119697e.a();
        }
    }
}
