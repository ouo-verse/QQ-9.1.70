package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class h implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        if (th5 instanceof SQLiteException) {
        } else {
            throw new RuntimeException(th5);
        }
    }
}
