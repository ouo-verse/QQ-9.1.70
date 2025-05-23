package com.tencent.mobileqq.conditionsearch.datareport;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(View view, String str, String str2, Map<String, ?> map) {
        if (view == null) {
            QLog.e("ConditionSearchDaReport", 1, "doReportElement fail: eleView=null, eleId=" + str);
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent(str2, view, map);
    }

    public static void b(Activity activity, View view, String str, PageParams pageParams) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, str);
        if (pageParams != null) {
            VideoReport.setPageParams(view, pageParams);
        }
    }
}
