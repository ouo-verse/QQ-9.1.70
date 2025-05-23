package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d {
    public static void b(QQAppInterface qQAppInterface, String str, String str2) {
        c(qQAppInterface, str, "", str2, "", "", "");
    }

    public static void c(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(qQAppInterface, "dc00899", "grp_lbs", str2, "pay_like", str, 0, 0, str3, str4, str5, str6);
        if (QLog.isColorLevel()) {
            QLog.d("nearbyLike.report", 2, "report, opName=" + str + ", toUin=" + str2 + ", extra1=" + str3 + ", extra2=" + str4 + ", extra3=" + str5 + ", extra4=" + str6);
        }
    }

    public static boolean a(long j3) {
        boolean z16 = j3 == 6 || j3 == 8 || j3 == 37 || j3 == 41 || j3 == 42 || j3 == 43 || j3 == 45 || j3 == 46 || j3 == 47 || j3 == 51 || j3 == 10002;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "isNeedNewLimitCheck, source=" + j3 + ", ret=" + z16);
        }
        return z16;
    }
}
