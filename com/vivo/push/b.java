package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushQueryActionListener f387556a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f387557b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IPushQueryActionListener iPushQueryActionListener) {
        this.f387557b = aVar;
        this.f387556a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b16 = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener iPushQueryActionListener = this.f387556a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(b16);
        }
    }
}
