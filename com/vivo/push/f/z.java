package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: P */
/* loaded from: classes13.dex */
final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.r f387701a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ y f387702b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, com.vivo.push.b.r rVar) {
        this.f387702b = yVar;
        this.f387701a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        y yVar = this.f387702b;
        PushMessageCallback pushMessageCallback = ((aa) yVar).f387661b;
        context = ((com.vivo.push.s) yVar).f387838a;
        pushMessageCallback.onPublish(context, this.f387701a.i(), this.f387701a.h());
    }
}
