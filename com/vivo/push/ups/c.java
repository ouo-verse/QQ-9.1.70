package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: P */
/* loaded from: classes15.dex */
final class c implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f387858a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f387859b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f387859b = vUpsManager;
        this.f387858a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i3) {
        this.f387858a.onResult(new CodeResult(i3));
    }
}
