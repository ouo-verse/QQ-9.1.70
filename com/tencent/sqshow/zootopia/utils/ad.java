package com.tencent.sqshow.zootopia.utils;

import android.app.ActivityManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ad;", "", "", "b", "", "a", "", "Ljava/lang/String;", "ZPLAN_PROCESS_NAME", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    public static final ad f373254a = new ad();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String ZPLAN_PROCESS_NAME = BaseApplication.context.getPackageName() + ":zplan";

    ad() {
    }

    public final int a() {
        Object systemService = BaseApplication.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        int i3 = -1;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService)) {
            if (Intrinsics.areEqual(ZPLAN_PROCESS_NAME, runningAppProcessInfo.processName)) {
                i3 = runningAppProcessInfo.pid;
            }
        }
        QLog.i("ZPlanProcessKiller_", 1, "findZPlanProcessPid pid:" + i3);
        return i3;
    }

    public final void b() {
        QLog.i("ZPlanProcessKiller_", 1, "killZPlanProcess!");
        int a16 = a();
        if (a16 <= 0) {
            QLog.w("ZPlanProcessKiller_", 1, "killZPlanProcess bad pid:" + a16);
            return;
        }
        try {
            SystemMethodProxy.killProcess(a16);
            QLog.i("ZPlanProcessKiller_", 1, "killZPlanProcess killed " + a16);
        } catch (Throwable th5) {
            QLog.e("ZPlanProcessKiller_", 1, "killZPlanProcess error", th5);
        }
    }
}
