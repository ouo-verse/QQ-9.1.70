package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes12.dex */
public final class j implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f387644a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f387645b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f387646c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar, IPushRequestCallback iPushRequestCallback, int i3) {
        this.f387646c = dVar;
        this.f387644a = iPushRequestCallback;
        this.f387645b = i3;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i3) {
        if (this.f387644a != null) {
            u.b(this.f387645b + " sync err : " + i3);
            this.f387644a.onError(i3);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.d.a.b bVar) {
        if (this.f387644a != null) {
            u.b(this.f387645b + " sync success");
            this.f387644a.onSuccess(0);
        }
    }
}
