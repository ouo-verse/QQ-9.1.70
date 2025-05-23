package com.tencent.mobileqq.troop.dtreport;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a(List<?> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 != 0) {
                    sb5.append(",");
                }
                sb5.append(list.get(i3));
            }
            return sb5.toString();
        }
        return "";
    }

    public static void b(String str, String str2, String str3, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", str2);
        hashMap.put("pgid", str2);
        HashMap hashMap2 = new HashMap(map);
        hashMap2.put("dt_eid", str3);
        hashMap2.put("eid", str3);
        hashMap2.put("cur_pg", hashMap);
        VideoReport.reportEvent(str, hashMap2);
    }

    public static void c(String str, Map<String, Object> map) {
        b(str, "pg_bas_agent_selects_group", "em_group_order_copy_popup", map);
    }

    public static void d(String str, String str2, Map<String, Object> map) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("dt_pgid", str2);
        hashMap.put("pgid", str2);
        VideoReport.reportEvent(str, hashMap);
    }

    public static void e(String str) {
        d(str, "pg_bas_agent_selects_group", new HashMap());
    }

    public static void f(View view, String str, Map<String, Object> map) {
        g(view, str, map, ClickPolicy.REPORT_ALL);
    }

    public static void g(View view, String str, Map<String, Object> map, ClickPolicy clickPolicy) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, map);
    }
}
