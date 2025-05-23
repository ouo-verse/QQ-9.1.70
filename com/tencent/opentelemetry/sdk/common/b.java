package com.tencent.opentelemetry.sdk.common;

import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f341840d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f341840d.countDown();
    }
}
