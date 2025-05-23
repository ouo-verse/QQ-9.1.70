package com.tencent.tavsticker.log;

import android.util.Log;
import com.tencent.tavsticker.TAVStickerHelper;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TLog {
    public static final String TAG_PREFIX = "TAVSticker-";

    public static void d(String str, String str2) {
        if (TAVStickerHelper.isDebug()) {
            Log.d(TAG_PREFIX + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (TAVStickerHelper.isDebug()) {
            Log.e(TAG_PREFIX + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (TAVStickerHelper.isDebug()) {
            Log.i(TAG_PREFIX + str, str2);
        }
    }

    public static void printCallTraces(String str) {
        StackTraceElement[] stackTraceElementArr;
        if (!TAVStickerHelper.isDebug() || (stackTraceElementArr = Thread.getAllStackTraces().get(Thread.currentThread())) == null) {
            return;
        }
        v(TAG_PREFIX + str, "======================start============================");
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            v(TAG_PREFIX + str, stackTraceElement.toString());
        }
        v(TAG_PREFIX + str, "=======================end============================");
    }

    public static void v(String str, String str2) {
        if (TAVStickerHelper.isDebug()) {
            Log.v(TAG_PREFIX + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (TAVStickerHelper.isDebug()) {
            Log.w(TAG_PREFIX + str, str2);
        }
    }
}
