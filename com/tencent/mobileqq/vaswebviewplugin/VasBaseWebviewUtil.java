package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.m;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasBaseWebviewUtil {
    public static final String TAG = "VasBaseWebviewUtil";

    public static void doSonicErrorCodeReport(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5) {
        ((m) aa.k(m.class)).d(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_errorcode_report_hour", str + "|" + str2 + "|" + str3 + "|" + i3 + "|" + i16 + "|" + i17 + "|" + str4 + "|" + str5, true);
    }

    public static void doSonicSpeedReport(String str, String str2, String str3, int i3, int i16, long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, int i17, int i18, String str4, String str5) {
        ((m) aa.k(m.class)).d(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_speed_report", str + "|" + str2 + "|" + str3 + "|" + i3 + "|" + i16 + "|" + j3 + "|" + j16 + "|" + j17 + "|" + j18 + "|" + j19 + "|" + j26 + "|" + j27 + "|" + j28 + "|" + j29 + "|" + j36 + "|" + j37 + "|" + i17 + "|" + i18 + "|" + str4 + "|" + str5, true);
    }

    public static void reportNetworkSpeedTimeFromX5(String str, String str2, int i3, int i16, int i17, String str3, long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, long j38, String str4, String str5, String str6) {
        ((m) aa.k(m.class)).d(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_network_speed_time_from_x5", str + "|" + str2 + "|" + i3 + "|" + i16 + "|" + i17 + "|" + str3 + "|" + j3 + "|" + j16 + "|" + j17 + "|" + j18 + "|" + j19 + "|" + j26 + "|" + j27 + "|" + j28 + "|" + j29 + "|" + j36 + "|" + j37 + "|" + j38 + "|" + str4 + "|" + str5 + "|" + str6, true);
    }

    public static void reportQBWebInfo(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, int i17, int i18, String str8, String str9) {
        ((m) aa.k(m.class)).d(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_qbwebview_report", str + "|" + str2 + "|" + str3 + "|" + str4 + "|" + i3 + "|" + i16 + "|" + str5 + "|" + str6 + "|" + str7 + "|" + i17 + "|" + i18 + "|" + str8 + "|" + str9, true);
    }

    public static void reportVasStatus(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, String str5) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        sb5.append(str2);
        sb5.append("|");
        if (TextUtils.isEmpty(str3)) {
            str3 = "0";
        }
        sb5.append(str3);
        sb5.append("|");
        sb5.append(i3);
        sb5.append("|");
        sb5.append(i16);
        sb5.append("|");
        sb5.append(i17);
        sb5.append("|");
        sb5.append(i18);
        sb5.append("|");
        sb5.append(str4);
        sb5.append("|");
        sb5.append(str5);
        ((m) aa.k(m.class)).d(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", sb5.toString(), true);
    }

    public static void reportX5SpeedData(SwiftBrowserStatistics swiftBrowserStatistics) {
        if (swiftBrowserStatistics != null && !swiftBrowserStatistics.f314368m && !TextUtils.isEmpty(swiftBrowserStatistics.C) && swiftBrowserStatistics.D != 0) {
            swiftBrowserStatistics.f314368m = true;
            String str = swiftBrowserStatistics.C;
            String b16 = com.tencent.mobileqq.webview.util.g.b();
            int tbsVersion = QbSdk.getTbsVersion(BaseApplication.getContext());
            String str2 = swiftBrowserStatistics.A0;
            int i3 = 0;
            if (!TextUtils.isEmpty(str2) && str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str2 = str2.substring(0, str2.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
            }
            String valueOf = String.valueOf(swiftBrowserStatistics.T0.f314410c);
            if (swiftBrowserStatistics.G0) {
                i3 = 2;
            } else if (SwiftBrowserStatistics.f314343h1) {
                i3 = 1;
            }
            long j3 = swiftBrowserStatistics.f314358f;
            long j16 = swiftBrowserStatistics.f314361h;
            long j17 = swiftBrowserStatistics.R;
            long j18 = swiftBrowserStatistics.E;
            long j19 = swiftBrowserStatistics.F;
            long j26 = swiftBrowserStatistics.D;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reportX5SpeedData");
            }
            reportNetworkSpeedTimeFromX5(str2, valueOf, i3, 0, tbsVersion, b16, j3, j16, j17, j18, j19, j26, str);
        }
    }

    public static void reportNetworkSpeedTimeFromX5(String str, String str2, int i3, int i16, int i17, String str3, long j3, long j16, long j17, long j18, long j19, long j26, String str4) {
        reportNetworkSpeedTimeFromX5(str, str2, i3, i16, i17, str3, j3, j16, j17, j18, j19, j26, 0L, 0L, 0L, 0L, 0L, 0L, str4, "", "");
    }
}
