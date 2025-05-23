package com.tencent.mobileqq.guild.util.performance;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f235584a;

    public static long a(Context context) {
        Debug.MemoryInfo memoryInfo;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT > 28) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        } else {
            memoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{Process.myPid()})[0];
        }
        return memoryInfo.getTotalPss() / 1024.0f;
    }

    public static long b() {
        long[] c16 = c();
        return c16[1] + c16[2] + c16[3];
    }

    public static long[] c() {
        long[] jArr = new long[4];
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            long[] jArr2 = {0, 0, 0, 0};
            Object[] objArr = {"/proc/meminfo", new String[]{"MemTotal:", "MemFree:", "Buffers:", "Cached:"}, jArr2};
            if (method != null) {
                method.invoke(null, objArr);
                for (int i3 = 0; i3 < 4; i3++) {
                    jArr[i3] = jArr2[i3] / 1024;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jArr;
    }

    public static long d() {
        if (f235584a == 0) {
            f235584a = c()[0];
        }
        return f235584a;
    }
}
