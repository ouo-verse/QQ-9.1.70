package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class p implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f387758a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.f387758a = mVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i3) {
        if (i3 == 0) {
            com.vivo.push.restructure.a.a().h().b("");
        } else {
            com.vivo.push.restructure.a.a().h().c("");
        }
    }
}
