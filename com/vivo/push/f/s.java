package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: P */
/* loaded from: classes13.dex */
final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.n f387695a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f387696b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, com.vivo.push.b.n nVar) {
        this.f387696b = rVar;
        this.f387695a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        r rVar = this.f387696b;
        PushMessageCallback pushMessageCallback = ((aa) rVar).f387661b;
        context = ((com.vivo.push.s) rVar).f387838a;
        pushMessageCallback.onLog(context, this.f387695a.d(), this.f387695a.e(), this.f387695a.f());
    }
}
