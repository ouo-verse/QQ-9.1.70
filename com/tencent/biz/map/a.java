package com.tencent.biz.map;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    private static void a(View view, String str, String str2, Map<String, ?> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent(str2, view, map);
    }

    public static void b(Activity activity, View view, String str, PageParams pageParams) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, pageParams);
    }

    public static void c(View view, String str) {
        a(view, str, "dt_clck", null);
    }

    public static void d(View view, String str) {
        a(view, str, "dt_imp", null);
    }
}
