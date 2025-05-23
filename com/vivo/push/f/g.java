package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f387678a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f387679b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f387679b = eVar;
        this.f387678a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        e eVar = this.f387679b;
        PushMessageCallback pushMessageCallback = ((aa) eVar).f387661b;
        context = ((com.vivo.push.s) eVar).f387838a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f387678a);
    }
}
