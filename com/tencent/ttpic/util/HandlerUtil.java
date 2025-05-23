package com.tencent.ttpic.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class HandlerUtil {
    public static void waitDone(Handler handler) {
        if (handler == null) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable = new Runnable() { // from class: com.tencent.ttpic.util.HandlerUtil.1
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        };
        if (Looper.myLooper() == handler.getLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    public static void waitDone(Handler handler, int i3) {
        if (handler == null) {
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable = new Runnable() { // from class: com.tencent.ttpic.util.HandlerUtil.2
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        };
        if (Looper.myLooper() == handler.getLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
        try {
            countDownLatch.await(i3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }
}
