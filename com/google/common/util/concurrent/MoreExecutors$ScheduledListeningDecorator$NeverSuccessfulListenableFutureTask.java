package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
final class MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask extends AbstractFuture.h<Void> implements Runnable {
    private final Runnable D;

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.D.run();
        } catch (Throwable th5) {
            E(th5);
            throw com.google.common.base.p.e(th5);
        }
    }
}
