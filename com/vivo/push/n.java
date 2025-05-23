package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class n implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m.a f387751a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f387752b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f387753c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f387754d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, m.a aVar, String str, String str2) {
        this.f387754d = mVar;
        this.f387751a = aVar;
        this.f387752b = str;
        this.f387753c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i3) {
        if (i3 == 0) {
            Object[] b16 = this.f387751a.b();
            if (b16 != null && b16.length != 0) {
                com.vivo.push.restructure.a.a().h().a((String) this.f387751a.b()[0], this.f387752b, this.f387753c);
                return;
            } else {
                com.vivo.push.util.u.a("PushClientManager", "bind app result is null");
                return;
            }
        }
        com.vivo.push.restructure.a.a().h().a("");
    }
}
