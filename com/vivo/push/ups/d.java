package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: P */
/* loaded from: classes15.dex */
final class d implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSTurnCallback f387860a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f387861b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f387861b = vUpsManager;
        this.f387860a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i3) {
        this.f387860a.onResult(new CodeResult(i3));
    }
}
