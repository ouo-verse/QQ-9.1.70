package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ag;

/* compiled from: P */
/* loaded from: classes6.dex */
final class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f387550a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f387551b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, String str) {
        this.f387551b = zVar;
        this.f387550a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j3;
        Context b16 = com.vivo.push.restructure.a.a().b();
        if (b16 == null) {
            return;
        }
        if (m.a().f()) {
            j3 = 488;
        } else {
            j3 = 341;
        }
        if (!TextUtils.isEmpty(this.f387550a) && ag.a(b16, b16.getPackageName(), this.f387550a, j3)) {
            com.vivo.push.restructure.a.a().e().e();
            this.f387551b.f387947d = "";
        }
    }
}
