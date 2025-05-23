package kx1;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f413361a;

    public static void a(int i3, View view, CommonBotInfo commonBotInfo, CommonBotFeatureInfo commonBotFeatureInfo) {
        if (h34.a.d(commonBotFeatureInfo)) {
            b(view, String.valueOf(commonBotInfo.getTinyid()));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_robot_id", Long.valueOf(commonBotInfo.getTinyid()));
        hashMap.put("qq_robot_function_id", Integer.valueOf(commonBotFeatureInfo.getId()));
        hashMap.put("qq_robot_function_name", commonBotFeatureInfo.getName());
        hashMap.put("qq_robot_service_location", Integer.valueOf(i3));
        hashMap.put("pgid", "pg_qqrobot_halfscreen_order");
        hashMap.put("eid", "em_qqrobot_function_at");
        VideoReport.reportEvent("clck", view, hashMap);
        VideoReport.reportEvent("imp", view, hashMap);
        VideoReport.reportEvent("imp_end", view, hashMap);
    }

    public static void b(View view, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_robot_id", str);
        hashMap.put("pgid", "pg_qqrobot_halfscreen_order");
        hashMap.put("eid", "em_qqrobot_inline_at");
        VideoReport.reportEvent("clck", view, hashMap);
        VideoReport.reportEvent("imp", view, hashMap);
        VideoReport.reportEvent("imp_end", view, hashMap);
    }

    public static void c(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_oder_jump_result", "jumped");
        VideoReport.reportEvent("ev_qqrobot_order_jump", view, hashMap);
    }

    public static void d(int i3, View view, CommonBotFeatureInfo commonBotFeatureInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_qqrobot_halfscreen_order");
        hashMap.put("eid", "em_qqrobot_robot_order");
        hashMap.put("qq_robot_order_id", Integer.valueOf(commonBotFeatureInfo.getId()));
        hashMap.put("qq_robot_order_name", commonBotFeatureInfo.getName());
        hashMap.put("qq_robot_order_location", Integer.valueOf(i3));
        VideoReport.reportEvent("imp", view, hashMap);
    }

    public static void e(Activity activity, View view, AppRuntime appRuntime, String str, String str2, String str3, int i3, int i16, boolean z16) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_order");
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
        hashMap.put("sgrp_robot_order_source", Integer.valueOf(i16));
        hashMap.put("pgid", "pg_qqrobot_halfscreen_order");
        nx1.c.a(false, hashMap);
        f413361a = hashMap;
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.reportEvent("pgin", view, f413361a);
        VideoReport.reportEvent("pgout", view, f413361a);
    }

    public static void f(int i3, View view, CommonBotInfo commonBotInfo, CommonBotFeatureInfo commonBotFeatureInfo) {
        if (h34.a.d(commonBotFeatureInfo)) {
            g(view, commonBotInfo);
        }
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_order");
        VideoReport.setPageParams(view, new PageParams(f413361a));
        VideoReport.setElementId(view, "em_qqrobot_function_at");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_robot_id", String.valueOf(commonBotInfo.getTinyid()));
        hashMap.put("qq_robot_function_id", Integer.valueOf(commonBotFeatureInfo.getId()));
        hashMap.put("qq_robot_function_name", commonBotFeatureInfo.getName());
        hashMap.put("qq_robot_service_location", Integer.valueOf(i3));
        VideoReport.setElementParams(view, hashMap);
    }

    public static void g(View view, CommonBotInfo commonBotInfo) {
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_order");
        VideoReport.setPageParams(view, new PageParams(f413361a));
        VideoReport.setElementId(view, "em_qqrobot_inline_at");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_robot_id", String.valueOf(commonBotInfo.getTinyid()));
        VideoReport.setElementParams(view, hashMap);
    }

    public static void h(int i3, View view, CommonBotFeatureInfo commonBotFeatureInfo) {
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_order");
        VideoReport.setPageParams(view, new PageParams(f413361a));
        VideoReport.setElementId(view, "em_qqrobot_robot_order");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(view, String.valueOf(i3));
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_order_id", Integer.valueOf(commonBotFeatureInfo.getId()));
        hashMap.put("qq_robot_order_name", commonBotFeatureInfo.getName());
        hashMap.put("qq_robot_order_location", Integer.valueOf(i3));
        VideoReport.setElementParams(view, hashMap);
    }
}
