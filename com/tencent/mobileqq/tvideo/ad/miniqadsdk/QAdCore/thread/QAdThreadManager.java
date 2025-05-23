package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread;

import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes19.dex */
public enum QAdThreadManager {
    INSTANCE;

    private final c qAdExecutors = new c();

    QAdThreadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execIoDelay$0(Runnable runnable) {
        this.qAdExecutors.a().execute(runnable);
    }

    public void execIo(Runnable runnable) {
        if (runnable != null) {
            this.qAdExecutors.a().execute(runnable);
        }
    }

    public void execIoDelay(final Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        execOnUiThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.d
            @Override // java.lang.Runnable
            public final void run() {
                QAdThreadManager.this.lambda$execIoDelay$0(runnable);
            }
        }, j3);
    }

    public void execOnUiThread(Runnable runnable) {
        if (runnable != null) {
            this.qAdExecutors.c().execute(runnable);
        }
    }

    public void execOnUiThreadDelay(Runnable runnable, long j3) {
        if (runnable != null) {
            this.qAdExecutors.c().executeDelay(runnable, j3);
        }
    }

    public void execTask(Runnable runnable) {
        if (runnable != null) {
            this.qAdExecutors.b().execute(runnable);
        }
    }

    public Executor getIoExecutor() {
        return this.qAdExecutors.a();
    }

    public boolean isOnUiThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public void postOnUiThread(Runnable runnable) {
        if (runnable != null) {
            this.qAdExecutors.c().d(runnable);
        }
    }

    public void removeCallBackOnUiThread(Runnable runnable) {
        if (runnable != null) {
            this.qAdExecutors.c().f(runnable);
        }
    }
}
