package com.qzone.misc.network.report;

import android.os.Looper;
import android.os.SystemClock;
import com.qzone.common.account.LoginData;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes39.dex */
public class ClickReport {

    /* renamed from: a, reason: collision with root package name */
    private static long f48466a = SystemClock.uptimeMillis();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<QZoneClickReport.ReportInfo> f48467b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static String f48468c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f48469d = "";

    /* renamed from: e, reason: collision with root package name */
    private static boolean f48470e = false;

    /* renamed from: f, reason: collision with root package name */
    private static long f48471f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static long f48472g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList<QZoneClickReport.ReportInfo> f48473h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private static ClickReport f48474i = new ClickReport();

    /* renamed from: j, reason: collision with root package name */
    public static final String f48475j = l.a(R.string.kmt);

    /* renamed from: k, reason: collision with root package name */
    public static final String f48476k = l.a(R.string.kmq);

    /* renamed from: l, reason: collision with root package name */
    public static final String f48477l = l.a(R.string.kmr);

    /* renamed from: m, reason: collision with root package name */
    public static final String f48478m = l.a(R.string.kms);

    ClickReport() {
        b();
    }

    public static void c(int i3, int i16, String str, boolean z16, String... strArr) {
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = String.valueOf(i3);
        reportInfo.subactionType = String.valueOf(i16);
        reportInfo.reserves = str;
        if (strArr != null && strArr.length >= 1) {
            reportInfo.reservesExt = new ArrayList<>();
            for (String str2 : strArr) {
                reportInfo.reservesExt.add(str2);
            }
        }
        l(reportInfo, z16);
    }

    public static void d(int i3, String str, String str2, String str3, boolean z16) {
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.tabletype = i3;
        reportInfo.actionType = str;
        reportInfo.subactionType = str2;
        reportInfo.reserves = str3;
        l(reportInfo, z16);
    }

    public static void e(int i3, String str, int... iArr) {
        s(String.valueOf(i3), "", str, iArr);
    }

    public static void i(long j3, String str, String str2, String str3, boolean z16, int... iArr) {
        String[] strArr = new String[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            strArr[i3] = String.valueOf(iArr[i3]);
        }
        j(j3, str, str2, str3, z16, strArr);
    }

    public static void m(String str, String str2, String str3) {
        j(LoginData.getInstance().getUin(), "", "", "", false, str, str2, str3);
    }

    public static void o(String str, String str2, String str3, String str4) {
        j(LoginData.getInstance().getUin(), "", "", "", false, str, str2, str3, str4);
    }

    public static void p(String str, String str2, String str3, String str4, boolean z16) {
        j(LoginData.getInstance().getUin(), "", "", "", z16, str, str2, str3, str4);
    }

    public static void q(String str, String str2, String str3, boolean z16) {
        j(LoginData.getInstance().getUin(), "", "", "", z16, str, str2, str3);
    }

    public static void r(String str, String str2, String str3, boolean z16, String... strArr) {
        j(LoginData.getInstance().getUin(), str, str2, str3, z16, strArr);
    }

    public static void s(String str, String str2, String str3, int... iArr) {
        i(LoginData.getInstance().getUin(), str, str2, str3, false, iArr);
    }

    public static void t(String str, String str2, String str3, boolean z16) {
        h(LoginData.getInstance().getUin(), "", "", "", z16, 2, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(QZoneClickReport.ReportInfo reportInfo, boolean z16) {
        try {
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
            lpReportInfo_pf00064.extraInfo = reportInfo.toJSON().toString();
            if (QZLog.isDevelopLevel()) {
                QZLog.i("ClickReport", "lpReportInfo_pf00064.extraInfo=" + lpReportInfo_pf00064.extraInfo);
            }
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, !z16, false);
        } catch (Exception e16) {
            QLog.e("ClickReport", 1, e16, new Object[0]);
        }
    }

    public static void k(QZoneClickReport.ReportInfo reportInfo) {
        l(reportInfo, false);
    }

    public static void f(int i3, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        k(new QZoneClickReport.ReportInfo(LoginData.getInstance().getUin(), String.valueOf(i3), map));
    }

    public static void g(int i3, Map<String, String> map, boolean z16) {
        if (map == null || map.isEmpty()) {
            return;
        }
        l(new QZoneClickReport.ReportInfo(LoginData.getInstance().getUin(), String.valueOf(i3), map), z16);
    }

    private static void h(long j3, String str, String str2, String str3, boolean z16, int i3, String... strArr) {
        String str4;
        String str5;
        String str6;
        String str7;
        ArrayList arrayList;
        String str8;
        QZoneClickReport.ReportInfo reportInfo;
        String str9;
        String str10;
        String str11;
        String str12 = "";
        if (strArr.length == 1 && (str9 = strArr[0]) != null && str9.length() > 0) {
            String str13 = "" + strArr[0];
            if (str13.length() < 5) {
                str10 = "";
            } else {
                str10 = str13.substring(4, 5);
            }
            if (str13.length() < 4) {
                str11 = "";
            } else {
                str11 = str13.substring(3, 4);
            }
            if (str13.length() >= 3) {
                str12 = str13.substring(0, 3);
            }
            str6 = str10;
            str4 = str12;
            str7 = "0";
            arrayList = null;
            str5 = str11;
        } else {
            if ((strArr.length == 1 && (str8 = strArr[0]) != null && str8.length() == 0) || strArr.length == 0) {
                str7 = str;
                str4 = "";
                str5 = str4;
                str6 = str5;
            } else if (strArr.length <= 0) {
                str4 = "";
                str5 = str4;
                str6 = str5;
                str7 = "0";
            } else {
                ArrayList arrayList2 = new ArrayList();
                String str14 = "";
                String str15 = str14;
                for (int i16 = 0; i16 < strArr.length; i16++) {
                    if (i16 == 0) {
                        str12 = strArr[i16];
                    } else if (i16 == 1) {
                        str14 = strArr[i16];
                    } else if (i16 == 2) {
                        str15 = strArr[i16];
                    } else {
                        arrayList2.add(strArr[i16]);
                    }
                }
                str5 = str14;
                str4 = str12;
                str7 = "0";
                arrayList = arrayList2;
                str6 = str15;
            }
            arrayList = null;
        }
        if ("0".equals(str7)) {
            reportInfo = new QZoneClickReport.ReportInfo(j3, str, str2, str3, str4, str5, i3, str6, arrayList);
        } else {
            reportInfo = new QZoneClickReport.ReportInfo(str7);
        }
        l(reportInfo, z16);
    }

    public static void l(final QZoneClickReport.ReportInfo reportInfo, final boolean z16) {
        if (reportInfo == null) {
            return;
        }
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.misc.network.report.ClickReport.2
                @Override // java.lang.Runnable
                public void run() {
                    ClickReport.v(QZoneClickReport.ReportInfo.this, z16);
                }
            });
        } else {
            v(reportInfo, z16);
        }
    }

    public static void u(final QZoneClickReport.ReportInfo reportInfo) {
        if (reportInfo == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.misc.network.report.ClickReport.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
                    lpReportInfo_pf00064.extraInfo = QZoneClickReport.ReportInfo.this.toJSON().toString();
                    lpReportInfo_pf00064.reportImediately();
                } catch (Exception e16) {
                    QZLog.e("ClickReport", "ClickReport", e16);
                }
            }
        });
    }

    public static void n(String str, String str2, String str3, long j3, boolean z16, int... iArr) {
        i(j3, str, str2, str3, z16, iArr);
    }

    public static void j(long j3, String str, String str2, String str3, boolean z16, String... strArr) {
        h(j3, str, str2, str3, z16, 0, strArr);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ReportRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private void b() {
    }
}
