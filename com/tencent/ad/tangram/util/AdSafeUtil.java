package com.tencent.ad.tangram.util;

import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdSafeUtil {
    private static final String TAG = "AdSafeUtil";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface SafeRunnable<T> {
        T run();
    }

    public static <T> T safeRun(SafeRunnable<T> safeRunnable, String str, String str2) {
        try {
            return safeRunnable.run();
        } catch (Throwable th5) {
            if (TextUtils.isEmpty(str)) {
                str = TAG;
            }
            AdLog.e(str, "safeRun<T>" + str2, th5);
            return null;
        }
    }

    public static void safeRun(Runnable runnable, String str, String str2) {
        try {
            runnable.run();
        } catch (Throwable th5) {
            if (TextUtils.isEmpty(str)) {
                str = TAG;
            }
            AdLog.e(str, "safeRun" + str2, th5);
        }
    }
}
