package com.tencent.aelight.camera.aebase;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.peak.PeakConstants;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {
    public static void a(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    public static void d(int i3, int i16, HashMap<String, String> hashMap) {
        IQCircleReportApi iQCircleReportApi = (IQCircleReportApi) QRoute.api(IQCircleReportApi.class);
        QCircleLpReportDc05504DataBuilder thrActionType = new QCircleLpReportDc05504DataBuilder().setActionType(89).setSubActionType(i3).setThrActionType(i16);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        iQCircleReportApi.report5504(thrActionType.setExtras(hashMap));
    }

    public static void b(int i3, HashMap<String, String> hashMap) {
        d(i3, 2, hashMap);
    }

    public static void c(int i3, HashMap<String, String> hashMap) {
        d(i3, 1, hashMap);
    }

    public static void e(int i3, HashMap<String, String> hashMap) {
        d(i3, 3, hashMap);
    }

    public static void g(boolean z16, int i3, int i16, String str) {
        String str2;
        if (i3 > 0 && i16 > 0) {
            str2 = "3";
        } else if (i3 > 0) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", str2);
        hashMap.put("ext3", String.valueOf(i3 + i16));
        hashMap.put("ext4", String.valueOf(i3));
        hashMap.put("ext5", String.valueOf(i16));
        hashMap.put("ext6", str);
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(z16 ? 92 : 88).setSubActionType(3).setThrActionType(2).setExtras(hashMap));
    }

    public static void h(boolean z16, String str) {
        int i3 = z16 ? 92 : 88;
        Bundle bundle = new Bundle();
        bundle.putInt(PeakConstants.QCIRCLE_PHOTOLIST_FIRST_ACTION, i3);
        bundle.putString("qcircle_photolist_type_key", str);
    }

    public static void i(boolean z16) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(z16 ? 92 : 88).setSubActionType(4).setThrActionType(1));
    }

    public static void f(boolean z16, boolean z17, int i3, int i16, String str) {
        String str2;
        int i17 = z17 ? 2 : 3;
        if (i3 != 1) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        int i18 = z16 ? 92 : 88;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", str2);
        hashMap.put("ext3", String.valueOf(i16 + 1));
        hashMap.put("ext6", str);
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(i18).setSubActionType(2).setThrActionType(i17).setExtras(hashMap));
    }
}
