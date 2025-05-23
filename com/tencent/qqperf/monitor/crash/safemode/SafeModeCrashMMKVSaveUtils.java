package com.tencent.qqperf.monitor.crash.safemode;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SafeModeCrashMMKVSaveUtils {

    /* renamed from: a, reason: collision with root package name */
    private static MMKVOptionEntity f363203a;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(@NonNull Context context) {
        c(context).encodeInt("key_count_start_fail", 0);
        wy3.c.e("SafeModeCrashMMKVSaveUtils", "clearSafeMode end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(Context context) {
        return c(context).decodeInt("key_count_start_fail", 0);
    }

    private static MMKVOptionEntity c(@NonNull Context context) {
        if (f363203a == null) {
            f363203a = QMMKV.from(context, "BuglySdkInfos");
        }
        return f363203a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(final Context context) {
        if (context == null) {
            return;
        }
        c(context).encodeInt("key_count_start_fail", b(context) + 1);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.safemode.SafeModeCrashMMKVSaveUtils.1
            @Override // java.lang.Runnable
            public void run() {
                SafeModeCrashMMKVSaveUtils.a(context);
            }
        }, 16, null, false, 15000L);
    }
}
