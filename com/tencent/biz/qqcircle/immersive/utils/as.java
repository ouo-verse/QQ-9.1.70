package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qcircle.api.IQCircleRMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class as {

    /* renamed from: a, reason: collision with root package name */
    private static IQCircleRMonitorApi f90163a;

    private static IQCircleRMonitorApi a() {
        if (f90163a == null) {
            f90163a = (IQCircleRMonitorApi) QRoute.api(IQCircleRMonitorApi.class);
        }
        return f90163a;
    }

    public static void b(@NonNull String str, @NonNull String str2) {
        IQCircleRMonitorApi a16 = a();
        if (a16 == null) {
            return;
        }
        String a17 = yd2.a.a(str);
        if (!TextUtils.isEmpty(a17)) {
            str2 = a17;
        }
        QLog.d("QFSRMonitorUtils", 1, "[traceEndMonitor] traceEndMonitor: " + str2);
        a16.traceEnd(str2);
    }

    public static void c(@NonNull String str, @NonNull String str2) {
        IQCircleRMonitorApi a16 = a();
        if (a16 == null) {
            return;
        }
        String a17 = yd2.a.a(str);
        if (!TextUtils.isEmpty(a17)) {
            str2 = a17;
        }
        QLog.d("QFSRMonitorUtils", 1, "[traceStartMonitor] monitorReportScene: " + str2);
        a16.traceStart(str2);
    }
}
