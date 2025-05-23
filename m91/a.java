package m91;

import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    public static void a(AppRuntime appRuntime, String str, String str2, boolean z16, int i3) {
        if (appRuntime != null && str != null && str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("cmd", str2);
            hashMap.put("usedTime", String.valueOf(i3));
            QLog.i("ArkApp.Report", 1, "reportAppSSOResult, app=" + str + ", success=" + z16 + ", usedTime=" + i3 + ", params=" + hashMap);
            QQBeaconReport.report(appRuntime.getCurrentAccountUin(), "ArkSSOMonitor", z16, (Map<String, String>) hashMap, false);
        }
    }

    public static void b(AppRuntime appRuntime, String str, String str2) {
        if (appRuntime != null && str != null && str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("errorMsg", str2);
            QLog.i("ArkApp.Report", 1, "reportScriptError, app=" + str + ", error=" + str2);
            QQBeaconReport.report(appRuntime.getCurrentAccountUin(), "ArkAppScriptError", true, (Map<String, String>) hashMap, false);
        }
    }
}
