package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes12.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f387639a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f387640b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f387640b = dVar;
        this.f387639a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete all profileIds");
        d.a(this.f387640b, "", this.f387639a, 3);
    }
}
