package com.tencent.component.media.gif;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class SafeRunnable implements Runnable {
    final NewGifDrawable mGifDrawable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeRunnable(NewGifDrawable newGifDrawable) {
        this.mGifDrawable = newGifDrawable;
    }

    abstract void doWork();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.mGifDrawable.isRecycled()) {
                doWork();
            }
        } catch (Throwable th5) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th5);
            }
        }
    }
}
