package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes12.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f387636a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f387637b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f387638c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f387638c = dVar;
        this.f387636a = str;
        this.f387637b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete profileId");
        d.a(this.f387638c, this.f387636a, this.f387637b, 2);
    }
}
