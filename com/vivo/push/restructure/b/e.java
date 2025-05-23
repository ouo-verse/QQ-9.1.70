package com.vivo.push.restructure.b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ag;

/* compiled from: P */
/* loaded from: classes15.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f387806a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ PushConfig f387807b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f387808c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Context context, PushConfig pushConfig) {
        this.f387808c = dVar;
        this.f387806a = context;
        this.f387807b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f387806a;
        ag.a(context, context.getPackageName(), this.f387807b.isAgreePrivacyStatement());
    }
}
