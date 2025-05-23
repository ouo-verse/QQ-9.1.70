package com.tencent.mobileqq.msgbackup.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static c f251402a;

    public static void a() {
        c cVar = f251402a;
        if (cVar != null) {
            cVar.a();
            f251402a = null;
        }
    }

    public static void b() {
        if (f251402a == null) {
            c cVar = new c();
            f251402a = cVar;
            cVar.a();
            f251402a.f251372b = 4;
        }
    }

    private static HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        c cVar = f251402a;
        if (cVar != null) {
            f.D("MsgBackup_MsgBackupReporter", "mReportContainer = %s", cVar);
            hashMap.put("bizType", String.valueOf(f251402a.f251371a));
            hashMap.put("platForm", String.valueOf(f251402a.f251372b));
            hashMap.put("requestStatus", String.valueOf(f251402a.f251373c));
            hashMap.put("errorCode", String.valueOf(f251402a.f251374d));
            hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, String.valueOf(f251402a.f251375e));
            hashMap.put("averageSpeed", String.valueOf(f251402a.f251376f));
            hashMap.put("totalSessionCount", String.valueOf(f251402a.f251377g));
            hashMap.put("finishedSessionCount", String.valueOf(f251402a.f251378h));
            hashMap.put("resSessionContains", String.valueOf(f251402a.f251379i));
            hashMap.put("resTotalSize", String.valueOf(f251402a.f251380j));
            hashMap.put("dbTotalSize", String.valueOf(f251402a.f251381k));
            hashMap.put("resRequestCount", String.valueOf(f251402a.f251382l));
            hashMap.put("resRequestFailedCount", String.valueOf(f251402a.f251383m));
            hashMap.put("resRequestCancelCount", String.valueOf(f251402a.f251384n));
            hashMap.put("resTrivialCount", String.valueOf(f251402a.f251385o));
            hashMap.put("resTrivialFailedCount", String.valueOf(f251402a.f251386p));
            hashMap.put("resTrivialCancelCount", String.valueOf(f251402a.f251387q));
            hashMap.put("dbRequestCount", String.valueOf(f251402a.f251388r));
            hashMap.put("dbRequestFailedCount", String.valueOf(f251402a.f251389s));
            hashMap.put("dbRequestCancelCount", String.valueOf(f251402a.f251390t));
            hashMap.put("udpDetected", String.valueOf(f251402a.f251391u));
            hashMap.put("connectType", String.valueOf(f251402a.f251392v));
            hashMap.put("connectElipse", String.valueOf(f251402a.f251393w));
            hashMap.put("sessionReadyAllTimes", String.valueOf(f251402a.f251394x));
            hashMap.put("fileFailedCount", String.valueOf(f251402a.f251395y));
            hashMap.put("fileErrorList", String.valueOf(f251402a.f251396z));
        }
        return hashMap;
    }

    public static void d() {
        if (f251402a != null) {
            HashMap<String, String> c16 = c();
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "MsgBackup_MsgBackupReporter", true, 0L, 0L, c16, null);
            a();
        }
    }

    public static void e(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + str + "]");
        }
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static void f(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + str + "], fromType = [" + i3 + "]");
        }
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }

    public static void g(String str, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupReporter", 2, "report() called with: key = [" + str + "], fromType = [" + i3 + "], reservedFromType = [" + i16 + "]");
        }
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, String.valueOf(i16), "", "", "");
    }
}
