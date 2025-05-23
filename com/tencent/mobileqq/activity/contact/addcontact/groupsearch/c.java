package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleReporter;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void c(final View view, final String str, final Map<String, Object> map, final int i3) {
        if (view == null) {
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.groupsearch.a
            @Override // java.lang.Runnable
            public final void run() {
                c.e(view, str, i3, map);
            }
        });
    }

    public static void d(final Activity activity, final View view, final String str) {
        if (view == null) {
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.groupsearch.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(activity, view, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(View view, String str, int i3, Map map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementReuseIdentifier(view, str + "_" + i3);
        VideoReport.setElementParams(view, map);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Activity activity, View view, String str) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, str);
    }
}
