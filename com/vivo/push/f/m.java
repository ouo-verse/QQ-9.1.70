package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f387683a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f387684b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f387685c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f387686d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f387687e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, int i3, List list, List list2, String str) {
        this.f387687e = lVar;
        this.f387683a = i3;
        this.f387684b = list;
        this.f387685c = list2;
        this.f387686d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f387687e;
        PushMessageCallback pushMessageCallback = ((aa) lVar).f387661b;
        context = ((com.vivo.push.s) lVar).f387838a;
        pushMessageCallback.onDelTags(context, this.f387683a, this.f387684b, this.f387685c, this.f387686d);
    }
}
