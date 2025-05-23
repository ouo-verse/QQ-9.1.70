package com.tencent.biz.qqstory.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AssertUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "Q.qqstory.AssertUtils";

    public static <T> void assertNotNull_DEBUG(T t16) {
        if (t16 == null) {
            Throwable b16 = i.b("StoryAssertUtils Exception!");
            CaughtExceptionReportProxy.e(b16, "StoryAssertUtils assertNotNull_DEBUG()");
            hd0.c.h(TAG, "assertNotNull_DEBUG failed: ", b16);
        }
    }

    public static void assertTrue(boolean z16) {
        if (z16) {
            return;
        }
        hd0.c.g(TAG, "assertTrue failed:" + getStackTrace(4));
    }

    public static void checkNotEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return;
        }
        hd0.c.g(TAG, "checkNotEmpty failed :" + getStackTrace(2));
    }

    public static <T> T checkNotNull(T t16) {
        if (t16 == null) {
            hd0.c.g(TAG, "checkNotNull failed:" + getStackTrace(2));
        }
        return t16;
    }

    public static void fail(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        hd0.c.g(TAG, str);
    }

    public static String getStackTrace(int i3) {
        try {
            StackTraceElement[] stackTrace = new RuntimeException("getStackTrace").getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            if (stackTrace.length <= i3) {
                i3 = stackTrace.length;
            }
            for (int i16 = 2; i16 < i3; i16++) {
                sb5.append("\n" + stackTrace[i16].toString());
            }
            return sb5.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void assertTrue(boolean z16, @NonNull String str) {
        if (z16) {
            return;
        }
        hd0.c.g(TAG, str);
    }

    public static void assertTrue(boolean z16, @NonNull String str, Object... objArr) {
        if (z16) {
            return;
        }
        hd0.c.g(TAG, String.format(null, str, objArr));
    }

    public static void mainThreadCheck() {
    }

    public static void notMainThreadCheck() {
    }
}
