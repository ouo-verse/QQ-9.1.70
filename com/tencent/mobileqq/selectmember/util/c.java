package com.tencent.mobileqq.selectmember.util;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(TroopAddFrdsInnerFrame.d dVar) {
        if (dVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_num", dVar.f187210d);
        View view = dVar.I;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        com.tencent.mobileqq.troop.dtreport.a.g(view, "em_group_member_unit", hashMap, clickPolicy);
        Button button = dVar.E;
        if (button != null && button.getVisibility() == 0) {
            com.tencent.mobileqq.troop.dtreport.a.g(dVar.D, "em_group_member_add", hashMap, clickPolicy);
            return;
        }
        VideoReport.setElementClickPolicy(dVar.D, clickPolicy);
        VideoReport.setElementExposePolicy(dVar.D, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(dVar.D, EndExposurePolicy.REPORT_NONE);
    }

    public static void b(Activity activity, int i3, String str) {
        if (activity == null) {
            return;
        }
        if (i3 != 30) {
            if (i3 == 38) {
                VideoReport.addToDetectionWhitelist(activity);
                VideoReport.setPageId(activity, "pg_group_invite_new_member");
                VideoReport.setPageParams(activity, "group_id", str);
                VideoReport.setPageReportPolicy(activity, PageReportPolicy.REPORT_ALL);
                return;
            }
            return;
        }
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(activity, "pg_group_add_member_list");
        VideoReport.setPageParams(activity, "group_id", str);
        VideoReport.setPageReportPolicy(activity, PageReportPolicy.REPORT_ALL);
    }

    public static void c(View view, String str) {
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_num", str);
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }
}
