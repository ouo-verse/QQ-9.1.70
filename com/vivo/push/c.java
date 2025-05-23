package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushActionListener f387613a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f387614b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IPushActionListener iPushActionListener) {
        this.f387614b = aVar;
        this.f387613a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int a16 = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener iPushActionListener = this.f387613a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(a16);
        }
    }
}
