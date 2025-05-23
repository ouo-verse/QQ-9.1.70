package com.google.common.util.concurrent;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
class MoreExecutors$Application$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ExecutorService f35150d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f35151e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ TimeUnit f35152f;
    final /* synthetic */ MoreExecutors.a this$0;

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f35150d.shutdown();
            this.f35150d.awaitTermination(this.f35151e, this.f35152f);
        } catch (InterruptedException unused) {
        }
    }
}
