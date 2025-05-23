package cx1;

import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class y {
    public static void a(View view, int i3, String str, int i16) {
        rx1.a.a(view, "em_qqrobot_robot_order");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_order_id", Integer.valueOf(i3));
        hashMap.put("qq_robot_order_name", str);
        hashMap.put("qq_robot_order_location", Integer.valueOf(i16));
        VideoReport.setElementParams(view, hashMap);
    }

    public static void b(View view, int i3, int i16) {
        rx1.a.a(view, "em_qqrobot_function_preview");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_photo_location", Integer.valueOf(i3));
        hashMap.put("qq_robot_photo_number", Integer.valueOf(i16));
        VideoReport.setElementParams(view, hashMap);
    }

    public static void c(View view, String str, HashMap<String, Object> hashMap, boolean z16) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("pgid", "pg_qqrobot_card");
        hashMap2.put("eid", str);
        hashMap2.put("qq_robot_robot_order_more_status", Integer.valueOf(z16 ? 1 : 0));
        e(view, str, hashMap, hashMap2);
    }

    public static void d(View view, int i3, String str) {
        rx1.a.a(view, "em_qqrobot_function");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_function_id", Integer.valueOf(i3));
        hashMap.put("qq_robot_function_name", str);
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    public static void e(View view, String str, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        VideoReport.setPageId(view, "pg_qqrobot_card");
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.setElementParams(view, hashMap2);
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    public static void f(View view, String str, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("pgid", "pg_qqrobot_card");
        hashMap2.put("eid", str);
        e(view, str, hashMap, hashMap2);
    }
}
