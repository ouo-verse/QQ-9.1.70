package com.tencent.mobileqq.processkiller;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a4\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0002j\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000`\u0003\u001a\u0018\u0010\u000b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0000\u00a8\u0006\u000e"}, d2 = {"", "action", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "param", "", "c", "Landroid/content/Context;", "application", "", "pid", "a", "processName", "b", "QQPerf-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    @NotNull
    public static final String a(@Nullable Context context, int i3) {
        Object obj;
        if (context != null) {
            obj = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) obj);
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i3) {
                    String str = runningAppProcessInfo.processName;
                    Intrinsics.checkNotNullExpressionValue(str, "proc.processName");
                    return str;
                }
            }
            return "undefined";
        }
        return "undefined";
    }

    public static final int b(@Nullable Context context, @NotNull String processName) {
        Object obj;
        boolean endsWith;
        Intrinsics.checkNotNullParameter(processName, "processName");
        if (context != null) {
            obj = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.ActivityManager");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) obj)) {
            String str = runningAppProcessInfo.processName;
            Intrinsics.checkNotNullExpressionValue(str, "proc.processName");
            endsWith = StringsKt__StringsJVMKt.endsWith(str, processName, true);
            if (endsWith) {
                return runningAppProcessInfo.pid;
            }
        }
        return -1;
    }

    public static final void c(@NotNull String action, @NotNull HashMap<String, String> param) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(param, "param");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", action, true, 0L, 0L, param, "");
    }

    public static /* synthetic */ void d(String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            hashMap = new HashMap();
        }
        c(str, hashMap);
    }
}
