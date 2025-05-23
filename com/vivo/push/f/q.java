package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: P */
/* loaded from: classes13.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.m f387693a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f387694b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, com.vivo.push.b.m mVar) {
        this.f387694b = pVar;
        this.f387693a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f387694b;
        PushMessageCallback pushMessageCallback = ((aa) pVar).f387661b;
        context = ((com.vivo.push.s) pVar).f387838a;
        pushMessageCallback.onListTags(context, this.f387693a.i(), this.f387693a.d(), this.f387693a.h());
    }
}
