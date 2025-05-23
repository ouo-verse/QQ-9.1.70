package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.ab;
import com.vivo.push.m;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes15.dex */
final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.restructure.a.a f387848a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f387849b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.vivo.push.restructure.a.a aVar2) {
        this.f387849b = aVar;
        this.f387848a = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        u.d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.f387848a.j())));
        m a16 = m.a();
        context = ((ab) this.f387849b).f387552a;
        a16.a(context);
        com.vivo.push.restructure.a.a().d().a(this.f387848a);
    }
}
