package nw2;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import java.util.HashMap;
import java.util.Map;
import pw2.n;
import pw2.w;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    private static Map<String, Object> a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
            Object remove = hashMap.remove("pgid");
            Object remove2 = hashMap.remove("ztid");
            if (remove != null) {
                hashMap.put("page_id", remove);
            }
            if (remove2 != null) {
                hashMap.put("ztid", remove2);
            }
        }
        return hashMap;
    }

    private static Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("business", "ad");
        return hashMap;
    }

    public static void c(a aVar, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("ztid", "");
        if (!y.i(map)) {
            hashMap.putAll(a(map));
        }
        if (!TextUtils.isEmpty(aVar.d())) {
            hashMap.put("ad_request_id", aVar.d());
        }
        hashMap.put(VRReportDefine$ReportParam.REPORT_STATUS, Integer.valueOf(aVar.c()));
        hashMap.put(VRReportDefine$ReportParam.IS_VIEW, Integer.valueOf(aVar.f() ? 1 : 0));
        hashMap.putAll(b());
        hashMap.put(VRReportDefine$ReportParam.REPORT_REASON, 1);
        e(VRReportDefine$ReportParam.ADFUNNEL_SEND_VIEW, hashMap);
    }

    public static void d(a aVar, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("ztid", "");
        if (!y.i(map)) {
            hashMap.putAll(a(map));
        }
        if (!TextUtils.isEmpty(aVar.d())) {
            hashMap.put("ad_request_id", aVar.d());
        }
        hashMap.put(VRReportDefine$ReportParam.REPORT_STATUS, Integer.valueOf(aVar.c()));
        if (aVar.c() == 7) {
            hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, Long.valueOf(aVar.b()));
        }
        hashMap.put(VRReportDefine$ReportParam.IS_VIEW, Integer.valueOf(aVar.f() ? 1 : 0));
        hashMap.put(VRReportDefine$ReportParam.AD_TERMINAL_REPORT_PARAM, aVar.a());
        Map<String, String> e16 = aVar.e();
        if (!y.i(e16)) {
            hashMap.putAll(e16);
        }
        hashMap.putAll(b());
        hashMap.put(VRReportDefine$ReportParam.REPORT_REASON, 5);
        e(VRReportDefine$ReportParam.ADFUNNEL_RECEIVE_VIEW, hashMap);
    }

    private static void e(String str, Map<String, Object> map) {
        if (com.tencent.miniqadsdk.a.f151670a) {
            n.e("QAdFunnelVrReport", "reportEventId = " + str + ", params = " + new Gson().toJson(map));
        }
        w.i(str, map);
    }
}
