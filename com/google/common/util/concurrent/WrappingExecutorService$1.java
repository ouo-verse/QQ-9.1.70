package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
class WrappingExecutorService$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Callable f35160d;
    final /* synthetic */ w this$0;

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f35160d.call();
        } catch (Exception e16) {
            com.google.common.base.p.j(e16);
            throw new RuntimeException(e16);
        }
    }
}
