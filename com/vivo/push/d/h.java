package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f387641a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f387642b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f387642b = dVar;
        this.f387641a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("query all profileIds");
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            u.b("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.f387641a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context b16 = com.vivo.push.restructure.a.a().b();
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.d.a.a(new com.vivo.push.d.a.b(b16.getPackageName(), new ArrayList(), 4)), new i(this), (byte) 0));
    }
}
