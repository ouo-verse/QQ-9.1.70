package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: P */
/* loaded from: classes15.dex */
final class a implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSRegisterCallback f387854a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VUpsManager f387855b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f387855b = vUpsManager;
        this.f387854a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i3) {
        this.f387854a.onResult(new TokenResult(i3, com.vivo.push.restructure.a.a().h().b()));
    }
}
