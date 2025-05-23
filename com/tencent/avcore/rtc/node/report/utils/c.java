package com.tencent.avcore.rtc.node.report.utils;

import android.text.TextUtils;
import com.tencent.avcore.rtc.node.report.RtcNodeReportManager;
import com.tencent.avcore.rtc.node.report.data.CommonNodeData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.mobileqq.tianjige.f;
import com.tencent.mobileqq.tianjige.i;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static final boolean a(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static i b() {
        return f.d(13);
    }

    public static void c(String str) {
        f.e(13, new a.C8649a().o("qq").m(1.0d).p(str).n(true).k());
    }

    public static void d(String str, long j3) {
        CommonNodeData commonNodeData;
        if (a(str) && (commonNodeData = RtcNodeReportManager.getInstance().getCommonNodeData(str)) != null) {
            commonNodeData.roomId = j3;
            RtcNodeReportManager.getInstance().setNodeCommonData(str, commonNodeData, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/rtc_node_report.cfg");
        }
    }

    public static boolean e() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_nt_rtc_node_report_switch", true);
    }

    public static String f(Map<String, String> map) {
        if (map != null && map.containsKey("start_double_rtc_talk_from_source")) {
            return map.get("start_double_rtc_talk_from_source");
        }
        return "5";
    }
}
