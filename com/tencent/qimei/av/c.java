package com.tencent.qimei.av;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f343152a;

    public c(f fVar) {
        this.f343152a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVar = this.f343152a;
        fVar.getClass();
        Looper.getMainLooper().getQueue().addIdleHandler(new d(fVar));
        com.tencent.qimei.t.a.a().a(30000L, new e(fVar));
    }
}
