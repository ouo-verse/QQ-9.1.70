package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: P */
/* loaded from: classes13.dex */
final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f387680a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f387681b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f387682c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.f387682c = hVar;
        this.f387680a = str;
        this.f387681b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f387680a)) {
            h hVar = this.f387682c;
            PushMessageCallback pushMessageCallback = ((aa) hVar).f387661b;
            context2 = ((com.vivo.push.s) hVar).f387838a;
            pushMessageCallback.onReceiveRegId(context2, this.f387680a);
        }
        h hVar2 = this.f387682c;
        PushMessageCallback pushMessageCallback2 = ((aa) hVar2).f387661b;
        context = ((com.vivo.push.s) hVar2).f387838a;
        pushMessageCallback2.onBind(context, this.f387681b.i(), this.f387681b.d());
    }
}
