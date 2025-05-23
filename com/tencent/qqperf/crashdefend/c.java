package com.tencent.qqperf.crashdefend;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.o;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f363087a = {"CrashDefend", "SafeMode", "MSFInterfaceAdapterImpl"};

    public static void a(Context context) {
        if (!((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            Log.e("CrashDefendInvokeCheckUtils", "checkInvokeIsCrashDefendMod jump stackTrace is null!");
            return;
        }
        int length = stackTrace.length;
        int i3 = 0;
        boolean z16 = false;
        int i16 = 1;
        while (i3 < length) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            int i17 = i16 + 1;
            if (i16 <= 15) {
                stackTraceElement.toString();
            }
            String className = stackTraceElement.getClassName();
            String[] strArr = f363087a;
            int length2 = strArr.length;
            int i18 = 0;
            while (true) {
                if (i18 >= length2) {
                    break;
                }
                if (className.contains(strArr[i18])) {
                    z16 = true;
                    break;
                }
                i18++;
            }
            if (z16) {
                break;
            }
            i3++;
            i16 = i17;
        }
        if (z16) {
            return;
        }
        b(context, stackTrace.toString());
        throw new RuntimeException("checkInvokeIsCrashDefendMod is false!");
    }

    private static void b(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("trace", str);
        hashMap.put("qimei_36", o.c());
        hashMap.put("branchName", ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getBranchName());
        StatisticCollector.getInstance(context).collectPerformance("", "config_clear_wrong_invoke", true, 0L, 0L, hashMap, "");
    }
}
