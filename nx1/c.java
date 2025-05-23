package nx1;

import ap0.f;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f421521a;

    public static void a(boolean z16, HashMap<String, Object> hashMap) {
        if (!z16) {
            hashMap.put("invoke_scene", 3);
        } else {
            hashMap.put("invoke_scene", 4);
        }
    }

    private static HashMap<String, Object> b(ReportPageArgs reportPageArgs) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("pgid", "pg_sgrp_robot_slash_halfscreen");
        hashMap.put("sgrp_robot_order_sign", "0");
        hashMap.put("sgrp_sub_channel_id", reportPageArgs.getChannelId());
        hashMap.put("sgrp_channel_id", reportPageArgs.getGuildId());
        IGPSService iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(reportPageArgs.getChannelId());
        if (channelInfo != null) {
            hashMap.put("sgrp_sub_channel_name", channelInfo.getChannelName());
        }
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(reportPageArgs.getGuildId());
        if (guildInfo != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, guildInfo.getGuildName());
            hashMap.put("sgrp_user_type", Integer.valueOf(3 - guildInfo.getUserType()));
        }
        if (f.isSlashPanelOpenFromAdd) {
            hashMap.put("sgrp_robot_order_source", "3");
            f.isSlashPanelOpenFromAdd = false;
        } else {
            hashMap.put("sgrp_robot_order_source", "0");
        }
        a(reportPageArgs.getIsDirectMsg(), hashMap);
        return hashMap;
    }

    public static void c(ReportPageArgs reportPageArgs) {
        VideoReport.addToDetectionWhitelist(reportPageArgs.getActivity());
        VideoReport.setPageId(reportPageArgs.getRootView(), "pg_sgrp_robot_slash_halfscreen");
        HashMap<String, Object> b16 = b(reportPageArgs);
        if (b16 == null) {
            return;
        }
        f421521a = b16;
        VideoReport.setPageParams(reportPageArgs.getRootView(), new PageParams(b16));
        VideoReport.reportEvent("pgin", reportPageArgs.getRootView(), b16);
    }

    public static void d(ReportPageArgs reportPageArgs) {
        VideoReport.addToDetectionWhitelist(reportPageArgs.getActivity());
        VideoReport.setPageId(reportPageArgs.getRootView(), "pg_sgrp_robot_slash_halfscreen");
        HashMap<String, Object> b16 = b(reportPageArgs);
        if (b16 == null) {
            return;
        }
        VideoReport.setPageParams(reportPageArgs.getRootView(), new PageParams(b16));
        VideoReport.reportEvent("pgout", reportPageArgs.getRootView(), b16);
    }
}
