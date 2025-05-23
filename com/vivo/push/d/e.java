package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes12.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f387633a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f387634b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f387635c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f387635c = dVar;
        this.f387633a = str;
        this.f387634b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("add profileId");
        d.a(this.f387635c, this.f387633a, this.f387634b, 1);
    }
}
