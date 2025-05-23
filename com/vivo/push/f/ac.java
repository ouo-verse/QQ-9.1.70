package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
final class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f387663a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f387664b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f387665c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f387666d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ab f387667e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, int i3, List list, List list2, String str) {
        this.f387667e = abVar;
        this.f387663a = i3;
        this.f387664b = list;
        this.f387665c = list2;
        this.f387666d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ab abVar = this.f387667e;
        PushMessageCallback pushMessageCallback = ((aa) abVar).f387661b;
        context = ((com.vivo.push.s) abVar).f387838a;
        pushMessageCallback.onSetTags(context, this.f387663a, this.f387664b, this.f387665c, this.f387666d);
    }
}
