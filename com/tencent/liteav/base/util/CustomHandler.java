package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class CustomHandler extends Handler {
    private static final long TIMEOUT_QUIT_LOOPER = TimeUnit.SECONDS.toMillis(30);
    private Runnable mQuitLooperTimeoutRunnable;
    private final String mTAG;
    private final Handler mUIHandler;

    public CustomHandler(Looper looper) {
        this(looper, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$quitLooper$2(CustomHandler customHandler) {
        LiteavLog.i(customHandler.mTAG, "queue idle handle.");
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            customHandler.getLooper().quitSafely();
        } else {
            customHandler.getLooper().quit();
        }
        customHandler.mUIHandler.removeCallbacks(customHandler.mQuitLooperTimeoutRunnable);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$quitLooper$3(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        if (customHandler.getLooper() == Looper.getMainLooper()) {
            LiteavLog.e(customHandler.mTAG, "try to quitLooper main looper!");
        } else {
            LiteavLog.i(customHandler.mTAG, "add idle handle.");
            Looper.myQueue().addIdleHandler(idleHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$runAndWaitDone$0(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$runAndWaitDone$1(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    public boolean isCurrentThread() {
        if (Looper.myLooper() != null && Looper.myLooper() == getLooper()) {
            return true;
        }
        return false;
    }

    public boolean postDelayedTask(Runnable runnable, long j3) {
        return postDelayed(runnable, j3);
    }

    public boolean postTask(Runnable runnable) {
        return post(runnable);
    }

    public void quitLooper() {
        post(d.a(this, c.a(this)));
        this.mUIHandler.postDelayed(this.mQuitLooperTimeoutRunnable, TIMEOUT_QUIT_LOOPER);
    }

    public void quitLooperAndWaitDone() {
        quitLooper();
        try {
            getLooper().getThread().join();
        } catch (InterruptedException unused) {
        }
    }

    public boolean runAndWaitDone(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean post = post(a.a(runnable, countDownLatch));
        if (post) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return post;
    }

    public boolean runOrPost(Runnable runnable) {
        return runOrPost(runnable, 0);
    }

    public CustomHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mQuitLooperTimeoutRunnable = new Runnable() { // from class: com.tencent.liteav.base.util.CustomHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                LiteavLog.e(CustomHandler.this.mTAG, "quit looper failed.");
            }
        };
        String str = "TXCHandler_" + hashCode();
        this.mTAG = str;
        LiteavLog.i(str, "[" + Thread.currentThread().getName() + "]");
    }

    public boolean runOrPost(Runnable runnable, int i3) {
        if (!getLooper().getThread().isAlive()) {
            return false;
        }
        if (Looper.myLooper() == getLooper() && i3 == 0) {
            runnable.run();
            return true;
        }
        if (i3 == 0) {
            return post(runnable);
        }
        return postDelayed(runnable, i3);
    }

    public boolean runAndWaitDone(Runnable runnable, long j3) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean post = post(b.a(runnable, countDownLatch));
        if (post) {
            try {
                countDownLatch.await(j3, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return post;
    }
}
