package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
final class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f387668a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f387669b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f387670c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f387671d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ab f387672e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, int i3, List list, List list2, String str) {
        this.f387672e = abVar;
        this.f387668a = i3;
        this.f387669b = list;
        this.f387670c = list2;
        this.f387671d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ab abVar = this.f387672e;
        PushMessageCallback pushMessageCallback = ((aa) abVar).f387661b;
        context = ((com.vivo.push.s) abVar).f387838a;
        pushMessageCallback.onSetAlias(context, this.f387668a, this.f387669b, this.f387670c, this.f387671d);
    }
}
