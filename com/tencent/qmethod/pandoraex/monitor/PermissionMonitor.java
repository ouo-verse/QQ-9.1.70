package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes22.dex */
public class PermissionMonitor {
    private static final String SYSTEM_CALL_PERMISSION = "call system api:Permission.";
    public static final String TAG = "PermissionMonitor";

    @SuppressLint({"NewApi"})
    public static void requestPermissions(Activity activity, String[] strArr, int i3) {
        MonitorReporter.getStrategyAndReport(QCircleDaTongConstant.ElementParamValue.PERMISSION, "ACT#REQ_PER#SI", null, null);
        activity.requestPermissions(strArr, i3);
    }
}
