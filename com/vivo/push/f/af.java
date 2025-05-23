package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: P */
/* loaded from: classes13.dex */
final class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f387673a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ae f387674b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.vivo.push.b.i iVar) {
        this.f387674b = aeVar;
        this.f387673a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ae aeVar = this.f387674b;
        PushMessageCallback pushMessageCallback = ((aa) aeVar).f387661b;
        context = ((com.vivo.push.s) aeVar).f387838a;
        pushMessageCallback.onUnBind(context, this.f387673a.i(), this.f387673a.d());
    }
}
