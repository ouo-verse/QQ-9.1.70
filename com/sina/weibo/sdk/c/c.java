package com.sina.weibo.sdk.c;

import android.util.Log;
import com.tencent.mobileqq.activity.recent.MsgSummary;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: ao, reason: collision with root package name */
    private static boolean f61249ao = false;

    public static void a(String str, String str2) {
        if (f61249ao) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + MsgSummary.STR_COLON + str2);
        }
    }

    public static void b(String str, String str2) {
        if (f61249ao) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + MsgSummary.STR_COLON + str2);
        }
    }

    public static void setLoggerEnable(boolean z16) {
        f61249ao = z16;
    }
}
