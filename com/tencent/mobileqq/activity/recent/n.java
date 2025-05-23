package com.tencent.mobileqq.activity.recent;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static SparseIntArray f185706a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends SparseIntArray {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            put(0, 1);
            put(1, 2);
            put(3000, 3);
            put(1004, 4);
            put(1006, 5);
            put(1000, 6);
            put(1022, 8);
            put(1001, 10);
            put(10004, 10);
            put(10002, 10);
            put(5000, 11);
            put(9000, 12);
            put(1002, 13);
            put(9002, 14);
            put(AppConstants.VALUE.UIN_TYPE_SERVICE_ACCOUNT_FOLDER, 17);
            put(AppConstants.VALUE.UIN_TYPE_EC_SHOP_ASSIST, 18);
            put(9501, 19);
            put(6000, 20);
            put(7000, 21);
            put(9999, 22);
            put(1023, 23);
            put(1005, 24);
            put(1024, 25);
            put(1025, 26);
            put(AppConstants.VALUE.UIN_TYPE_KANDIAN_MERGE, 29);
            put(10008, 31);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69174);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f185706a = new a();
        }
    }

    private static int a(RecentBaseData recentBaseData, RecentUser recentUser) {
        if (recentUser == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("RecentReportHelper", 4, "getReportID: null RecentUser for " + recentBaseData);
                return 0;
            }
            return 0;
        }
        int i3 = f185706a.get(recentUser.getType());
        if (i3 == 0 && recentUser.getType() == 1008) {
            if ("2909288299".equals(recentUser.uin)) {
                i3 = 27;
            } else if (AppConstants.PUBLIC_ACCOUNT_QQ_MAIL.equals(recentUser.uin)) {
                i3 = 28;
            } else if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(recentUser.uin)) {
                i3 = 29;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("RecentReportHelper", 4, "getReportID:" + i3 + ", for uin:" + recentUser.uin + " and type:" + recentUser.getType());
        }
        return i3;
    }

    private static boolean b(RecentUser recentUser) {
        if (recentUser != null && (recentUser.getType() == 1008 || recentUser.getType() == 7230)) {
            return true;
        }
        return false;
    }

    public static void c(QQAppInterface qQAppInterface, RecentBaseData recentBaseData, RecentUser recentUser, boolean z16) {
        int i3;
        int a16 = a(recentBaseData, recentUser);
        if (a16 > 0) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8006821", "0X8006821", z16 ? 1 : 0, 0, "" + a16, "", "", "");
            if (b(recentUser)) {
                if (z16) {
                    i3 = 7;
                } else {
                    i3 = 9;
                }
                PublicAccountEventReport.h(-1, "", "", i3);
            }
        }
    }
}
