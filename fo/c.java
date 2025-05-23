package fo;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f400130a;

    static {
        HashMap hashMap = new HashMap();
        f400130a = hashMap;
        hashMap.put(1, "pg_bas_social_updates");
        hashMap.put(2, "pg_qz_dynamic_detail_page");
        hashMap.put(3, "pg_qz_personal_homepage");
        hashMap.put(12, "pg_qz_personal_homepage");
        hashMap.put(5, "pg_qz_talk_about_list");
    }

    public static void a(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneDaTongReporter", 1, "customReport  params error ");
            return;
        }
        Map<String, Object> e16 = new a().e();
        if (map != null) {
            e16.putAll(map);
        }
        VideoReport.reportEvent(str, e16);
    }

    public static void b(String str, View view, String str2, b bVar) {
        if (!TextUtils.isEmpty(str) && view != null) {
            if (!TextUtils.isEmpty(str2)) {
                o(view, str2, bVar);
            }
            Map<String, Object> b16 = new a().b();
            if (bVar != null && bVar.f() != null) {
                b16.putAll(bVar.f());
            }
            VideoReport.reportEvent(str, view, b16);
            return;
        }
        QLog.e("QZoneDaTongReporter", 1, "trackingReport  params error ");
    }

    public static void c(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneDaTongReporter", 1, "customReport  params error ");
            return;
        }
        Map<String, Object> b16 = new a().b();
        if (map != null) {
            b16.putAll(map);
        }
        VideoReport.reportEvent(str, b16);
    }

    public static void e(String str, String str2, View view, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", str);
        hashMap.put("qq_pgid", str2);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        b("qq_clck", view, str, new b().l(hashMap));
    }

    public static void g(String str, String str2, View view, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", str);
        hashMap.put("qq_pgid", str2);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        b("qq_imp", view, str, new b().l(hashMap));
    }

    public static String h(int i3) {
        Map<Integer, String> map = f400130a;
        if (!map.containsKey(Integer.valueOf(i3))) {
            return "";
        }
        return map.get(Integer.valueOf(i3));
    }

    public static void j(View view, Map<String, Object> map, String str, boolean z16) {
        Map<String, Object> b16 = new a().b();
        if (map != null && map.size() > 0) {
            b16.putAll(map);
        }
        if (z16) {
            VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
        }
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) b16));
        VideoReport.reportEvent("dt_pgin", view, b16);
    }

    public static void k(View view, Map<String, Object> map, String str, boolean z16) {
        Map<String, Object> b16 = new a().b();
        if (map != null && map.size() > 0) {
            b16.putAll(map);
        }
        if (z16) {
            VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
        }
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) b16));
        VideoReport.reportEvent("dt_pgout", view, b16);
    }

    public static void l(View view, View view2) {
        VideoReport.setLogicParent(view, view2);
    }

    public static void m(View view, String str) {
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, new a().d(str, null));
    }

    public static void p(String str, String str2, View view, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", str);
        hashMap.put("qq_pgid", str2);
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        o(view, str, new b().l(hashMap));
    }

    public static void q(View view, String str, Map<String, Object> map) {
        b l3 = new b().l(map);
        l3.k(ExposurePolicy.REPORT_NONE);
        l3.j(EndExposurePolicy.REPORT_NONE);
        o(view, str, l3);
    }

    public static void r(View view, String str, Map<String, Object> map) {
        b l3 = new b().l(map);
        l3.k(ExposurePolicy.REPORT_ALL);
        l3.j(EndExposurePolicy.REPORT_NONE);
        l3.g(ClickPolicy.REPORT_NONE);
        o(view, str, l3);
    }

    public static void d(String str, String str2, View view) {
        e(str, str2, view, null);
    }

    public static void f(String str, String str2, View view) {
        g(str, str2, view, null);
    }

    public static void i(View view, Map<String, Object> map, String str) {
        j(view, map, str, false);
    }

    public static void n(View view, String str) {
        o(view, str, null);
    }

    public static void o(View view, String str, b bVar) {
        if (view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            Map<String, Object> b16 = new a().b();
            if (bVar != null && bVar.f() != null) {
                b16.putAll(bVar.f());
            }
            VideoReport.setElementParams(view, b16);
            if (bVar != null && bVar.b() != null) {
                VideoReport.setEventDynamicParams(view, bVar.b());
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.c())) {
                VideoReport.setElementReuseIdentifier(view, bVar.c());
            }
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            if (bVar != null && bVar.e() != null) {
                exposurePolicy = bVar.e();
            }
            if (bVar != null && bVar.d() != null) {
                endExposurePolicy = bVar.d();
            }
            if (bVar != null && bVar.a() != null) {
                clickPolicy = bVar.a();
            }
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
            VideoReport.setElementClickPolicy(view, clickPolicy);
            return;
        }
        QLog.e("QZoneDaTongReporter", 1, "trackingReport  params error ");
    }
}
