package com.tencent.liteav.base;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.lang.Thread;

/* compiled from: P */
@JNINamespace("base::android")
/* loaded from: classes7.dex */
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    private final Thread.UncaughtExceptionHandler mParent;

    JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z16) {
        this.mParent = uncaughtExceptionHandler;
        this.mCrashAfterReport = z16;
    }

    private static void installHandler(boolean z16) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z16));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        if (!this.mHandlingException) {
            this.mHandlingException = true;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mParent;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th5);
        }
    }

    public static void reportStackTrace(String str) {
    }
}
