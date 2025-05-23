package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: P */
/* loaded from: classes15.dex */
final class b implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f387856a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f387857b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f387857b = vUpsManager;
        this.f387856a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i3) {
        this.f387856a.onResult(new TokenResult(i3, ""));
    }
}
