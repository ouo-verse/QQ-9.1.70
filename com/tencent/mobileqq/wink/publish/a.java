package com.tencent.mobileqq.wink.publish;

import android.content.Intent;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.report.PublishActivityErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;

/* compiled from: P */
@Deprecated
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f325643a = "com.tencent.mobileqq.wink.publish.a";

    private static void a(String str) {
        if (str == null || str.isEmpty()) {
            QLog.w(f325643a, 1, "trace id is empty or null");
        }
    }

    public static String b(Intent intent) {
        if (intent != null) {
            return intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        }
        return "QCIRCLE";
    }

    public static String c(Intent intent) {
        if (intent != null && intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID) != null) {
            return intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        }
        return "";
    }

    public static void d(String str, String str2, PublishActivityErrorCode publishActivityErrorCode, long j3, String str3, String str4) {
        a(str3);
        WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
        builder.eventId(str2).traceId(str3).ext1(String.valueOf(j3)).desc(publishActivityErrorCode.getMessage()).retCode(String.valueOf(publishActivityErrorCode.transformedCode()));
        if (str4 != null) {
            builder.attachInfo(str4);
        }
        WinkPublishReportQueue.INSTANCE.report(builder.getReportData(), str);
    }
}
