package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f387688a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f387689b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f387690c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f387691d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f387692e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, int i3, List list, List list2, String str) {
        this.f387692e = lVar;
        this.f387688a = i3;
        this.f387689b = list;
        this.f387690c = list2;
        this.f387691d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f387692e;
        PushMessageCallback pushMessageCallback = ((aa) lVar).f387661b;
        context = ((com.vivo.push.s) lVar).f387838a;
        pushMessageCallback.onDelAlias(context, this.f387688a, this.f387689b, this.f387690c, this.f387691d);
    }
}
