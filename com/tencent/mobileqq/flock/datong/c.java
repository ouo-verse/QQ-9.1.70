package com.tencent.mobileqq.flock.datong;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(String str, View view, String str2, b bVar) {
        if (!TextUtils.isEmpty(str) && view != null) {
            if (!TextUtils.isEmpty(str2)) {
                d(view, str2, bVar);
            }
            Map<String, Object> a16 = a.a();
            if (bVar != null && bVar.f() != null) {
                a16.putAll(bVar.f());
            }
            VideoReport.reportEvent(str, view, a16);
            return;
        }
        QLog.e("FlockDaTongReporter", 1, "trackingReport  params error ");
    }

    public static void b(View view, View view2) {
        VideoReport.setLogicParent(view, view2);
    }

    public static void c(View view, String str) {
        d(view, str, null);
    }

    public static void d(View view, String str, b bVar) {
        if (view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            Map<String, Object> a16 = a.a();
            if (bVar != null && bVar.f() != null) {
                a16.putAll(bVar.f());
            }
            VideoReport.setElementParams(view, a16);
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
        QLog.e("FlockDaTongReporter", 1, "trackingReport  params error ");
    }
}
