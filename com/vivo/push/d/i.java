package com.vivo.push.d;

import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes12.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f387643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f387643a = hVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.d.a.b bVar) {
        com.vivo.push.d.a.b bVar2 = bVar;
        if (this.f387643a.f387641a != null) {
            u.b("query success");
            this.f387643a.f387641a.onSuccess(bVar2.a());
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i3) {
        if (this.f387643a.f387641a != null) {
            u.b("query err : ".concat(String.valueOf(i3)));
            this.f387643a.f387641a.onError(i3);
        }
    }
}
