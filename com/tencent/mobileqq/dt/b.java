package com.tencent.mobileqq.dt;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f203752a;

    /* renamed from: b, reason: collision with root package name */
    private static long f203753b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f203754c;

    /* renamed from: d, reason: collision with root package name */
    private static long f203755d;

    /* renamed from: e, reason: collision with root package name */
    private static long f203756e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f203753b = 0L;
        f203755d = -1L;
        f203756e = -1L;
    }

    private static void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String e16 = e();
        QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] deviceType = " + e16);
        if (e16 != null) {
            map.put("device_type", e16);
        }
        map.put("ram_size", String.valueOf(f()));
        map.put("rom_size", String.valueOf(g()));
    }

    private static void b(Long l3, String str, Map<String, String> map) {
        if (DTEventKey.APP_IN.equals(str)) {
            TreeMap treeMap = new TreeMap();
            a(treeMap);
            VideoReport.reportEvent("qqin", treeMap);
            QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] qqin");
            l();
            return;
        }
        if (DTEventKey.APP_OUT.equals(str)) {
            if (f203753b == 0) {
                QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] startTimestamp is 0");
                return;
            }
            TreeMap treeMap2 = new TreeMap();
            c(treeMap2, map);
            treeMap2.put("qq_lvtm", l3.toString());
            a(treeMap2);
            VideoReport.reportEvent("qqout", treeMap2);
            QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] qqout, timeInterval: " + l3);
        }
    }

    private static void c(Map<String, String> map, Map<String, String> map2) {
        if (map2 != null && map != null) {
            String str = map2.get(DTParamKey.REPORT_KEY_LVTM_DELTA);
            String str2 = map2.get(DTParamKey.REPORT_KEY_LVTM);
            if (str != null) {
                map.put(DTParamKey.REPORT_KEY_LVTM_DELTA, str);
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQDtReportHelper", 4, "848QQDT [doSupplementReport] delta: ", str);
                }
            }
            if (str2 != null) {
                map.put(DTParamKey.REPORT_KEY_LVTM, str2);
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQDtReportHelper", 4, "848QQDT [doSupplementReport] dtLvTime: ", str2);
                }
            }
        }
    }

    private static long d() {
        return SystemClock.uptimeMillis() - f203753b;
    }

    private static String e() {
        if (BaseApplication.getContext() != null) {
            DeviceType a16 = PadUtil.a(BaseApplication.getContext());
            if (a16 == DeviceType.TABLET) {
                return "tablet";
            }
            if (a16 == DeviceType.PHONE) {
                return "phone";
            }
            if (a16 == DeviceType.FOLD) {
                return QCircleDaTongConstant.ElementParamValue.PYMK_FOLD;
            }
            return null;
        }
        return null;
    }

    private static long f() {
        if (f203755d == -1) {
            f203755d = m.c() / 1048576;
        }
        return f203755d;
    }

    private static long g() {
        if (f203756e == -1) {
            f203756e = ah.T()[0];
        }
        return f203756e;
    }

    public static void h() {
        if (!DtSdkInitStep.g()) {
            QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin] dt sdk has not init");
            return;
        }
        QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin]");
        l();
        k(DTEventKey.APP_IN, null);
    }

    public static void i() {
        if (!DtSdkInitStep.g()) {
            QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin] dt sdk has not init");
            return;
        }
        QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogout]");
        k(DTEventKey.APP_OUT, null);
        f203753b = 0L;
    }

    public static void j(int i3) {
        f203752a = true;
        QLog.d("QQDtReportHelper", 1, "848QQDT [setIsMainProcess] process: " + Process.myPid() + ", from: " + i3);
    }

    public static void k(String str, Map<String, String> map) {
        if (f203752a && f203753b == 0) {
            QLog.d("QQDtReportHelper", 1, "848QQDT [supplementReportForSwitchAccount] startTimestamp is 0");
        } else {
            b(Long.valueOf(d()), str, map);
        }
    }

    public static void l() {
        f203753b = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("QQDtReportHelper", 2, "848QQDT [updateStartTime] timeStamp: " + f203753b);
        }
    }
}
