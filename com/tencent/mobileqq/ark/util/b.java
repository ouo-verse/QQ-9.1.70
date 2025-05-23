package com.tencent.mobileqq.ark.util;

import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.ark.open.appmanage.Utility;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f199652a = {Constants.Event.Action_PerfGetApp, Constants.Event.Action_PerfCreateView, Constants.Event.Action_PerfDisplayView};

    /* renamed from: b, reason: collision with root package name */
    static final String[] f199653b = {Constants.Event.ArkAppUpdateMonitor, Constants.Event.ArkAppDisplayMonitor, "ArkHTTPMonitor"};

    static long a(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static void b(AppRuntime appRuntime, String str, String str2, int i3, int i16, long j3, long j16, long j17, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && Utility.isValidAppName(str) && !TextUtils.isEmpty(str2)) {
            ArkAppReportController.b(appRuntime, str, "__platform__", str2, i3, i16, j3, j16, j17, str3, str4);
        } else {
            QLog.i("ArkApp.DataReport", 1, String.format("platformEventReport, invalid args, app-name=%s, op-name=%s", str, str2));
        }
    }

    public static void c(AppRuntime appRuntime, String str, String str2, boolean z16, int i3, Map<String, String> map) {
        if (i(str2)) {
            e(appRuntime, str, str2, z16, i3, map);
            return;
        }
        if (h(str2)) {
            d(appRuntime, str, str2, z16, i3, map);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkApp.DataReport", 2, "reportArkEngineEvent, ignore event, app=" + str + ", event=" + str2 + ", success=" + z16 + ", usedTime=" + i3 + ", params=" + map);
        }
    }

    static void d(AppRuntime appRuntime, String str, String str2, boolean z16, int i3, Map<String, String> map) {
        if (QLog.isColorLevel()) {
            QLog.i("ArkApp.DataReport", 2, "reportArkEngineEventToBeacon, app=" + str + ", event=" + str2 + ", success=" + z16 + ", usedTime=" + i3 + ", params=" + map);
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("appid", str);
        hashMap.put("usedTime", String.valueOf(i3));
        QQBeaconReport.report(appRuntime.getCurrentUin(), str2, z16, (Map<String, String>) hashMap, true);
    }

    static void e(AppRuntime appRuntime, String str, String str2, boolean z16, int i3, Map<String, String> map) {
        if (QLog.isColorLevel()) {
            QLog.i("ArkApp.DataReport", 2, "reportArkEngineEventToBigT, app=" + str + ", event=" + str2 + ", success=" + z16 + ", usedTime=" + i3 + ", params=" + map);
        }
        b(appRuntime, str, str2, (int) a(map, "result"), (int) a(map, "entry"), i3, a(map, "r1"), a(map, "r2"), map.get("r3"), map.get("r4"));
    }

    private static void f(AppRuntime appRuntime, String str, int i3, int i16, int i17, int i18, String str2, String str3) {
        ReportController.n(appRuntime, "CliOper", "", "", "0X800776F", str, i3, 1, i16, Integer.toString(i17), Integer.toString(i18), str2, str3);
    }

    public static void g(String str) {
        f(null, str, 0, 0, 0, 0, "", "");
    }

    static boolean h(String str) {
        for (String str2 : f199653b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean i(String str) {
        for (String str2 : f199652a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
