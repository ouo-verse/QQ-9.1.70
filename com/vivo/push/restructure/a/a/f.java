package com.vivo.push.restructure.a.a;

import com.vivo.push.PushClient;

/* compiled from: P */
/* loaded from: classes15.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f387783a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f387784b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f387785c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, int i3, String str) {
        this.f387785c = eVar;
        this.f387783a = i3;
        this.f387784b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f387783a;
        if (i3 == 3) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.f387784b, null);
        } else if (i3 == 4) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.f387784b, null);
        }
    }
}
