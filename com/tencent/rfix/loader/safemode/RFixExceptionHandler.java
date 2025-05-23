package com.tencent.rfix.loader.safemode;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.rfix.loader.log.RFixLog;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "RFix.RFixExceptionHandler";
    private final Context context;
    private final Thread.UncaughtExceptionHandler oldExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public RFixExceptionHandler(Context context) {
        this.context = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th5) {
        RFixLog.e(TAG, String.format("handle uncaught Exception!!! thread=%s", thread), th5);
        RFixSafeModeKeeper.onJavaCrash(this.context, th5);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.oldExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th5);
        }
    }
}
