package com.tencent.luggage.wxa.eq;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public Handler f125080a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Thread.currentThread().getId() == this.f125080a.getLooper().getThread().getId()) {
            runnable.run();
        } else {
            this.f125080a.post(runnable);
        }
    }
}
