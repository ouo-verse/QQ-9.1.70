package com.tencent.libra.extension.gif;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class SafeRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final GifDrawable f118744d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeRunnable(GifDrawable gifDrawable) {
        this.f118744d = gifDrawable;
    }

    abstract void e();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.f118744d.j()) {
                e();
            }
        } catch (Throwable th5) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th5);
            }
            throw th5;
        }
    }
}
