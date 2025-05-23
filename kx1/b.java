package kx1;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f413362a;

    public static void a(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_send_result", 1);
        VideoReport.reportEvent("ev_qqrobot_content_send", view, hashMap);
    }

    public static void b(int i3, View view, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_qqrobot_halfscreen_searchresult");
        hashMap.put("eid", "em_qqrobot_search_content");
        hashMap.put("qq_robot_content_type", str);
        hashMap.put("qq_robot_content_location", Integer.valueOf(i3));
        VideoReport.reportEvent("imp", view, hashMap);
    }

    public static void c(View view, String str) {
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_searchresult");
        VideoReport.setPageParams(view, new PageParams(f413362a));
        VideoReport.setElementId(view, "em_qqrobot_search_content");
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_qqrobot_halfscreen_searchresult");
        hashMap.put("eid", "em_qqrobot_input_field");
        hashMap.put("qq_robot_search_keywords", str);
        VideoReport.reportEvent("imp", view, hashMap);
    }

    public static void d(Activity activity, View view, AppRuntime appRuntime, String str, String str2, String str3, int i3) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_searchresult");
        String str4 = "";
        IGPSService iGPSService = (IGPSService) appRuntime.getRuntimeService(IGPSService.class, "");
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str2);
        if (channelInfo != null) {
            str4 = channelInfo.getChannelName();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("qq_robot_role_type", Integer.valueOf(i3));
        hashMap.put("qq_robot_robot_id", str3);
        hashMap.put("qq_robot_channel_id", str);
        hashMap.put("qq_robot_channel_name", iGPSService.getGuildName(str));
        hashMap.put("qq_robot_sub_channel_id", str2);
        hashMap.put("qq_robot_sub_channel_name", str4);
        hashMap.put("pgid", "pg_qqrobot_halfscreen_searchresult");
        nx1.c.a(false, hashMap);
        f413362a = hashMap;
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.reportEvent("pgin", view, f413362a);
    }

    public static void e(int i3, View view, String str) {
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_searchresult");
        VideoReport.setPageParams(view, new PageParams(f413362a));
        VideoReport.setElementId(view, "em_qqrobot_search_content");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(view, String.valueOf(i3));
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_content_type", str);
        hashMap.put("qq_robot_content_location", Integer.valueOf(i3));
        VideoReport.setElementParams(view, hashMap);
    }
}
