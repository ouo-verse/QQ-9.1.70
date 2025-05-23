package com.tencent.util;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, int i3, long j3) {
        if (i3 == 7220) {
            try {
                d(qQAppInterface, "0X80098E4", "" + j3, "", "", "");
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQKRPUtil", 2, th5, new Object[0]);
                }
            }
        }
    }

    public static void b(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        try {
            int i3 = messageRecord.istroop;
            if (i3 != 7220 && (i3 != 1008 || !AppConstants.NEW_KANDIAN_UIN.equals(messageRecord.frienduin))) {
                if (messageRecord.istroop == 10007) {
                    ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).report(qQAppInterface, messageRecord.frienduin, 10006, 1);
                    return;
                }
                return;
            }
            d(qQAppInterface, "0X80098E5", "" + messageRecord.msgUid, "", "", "");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("QQKRPUtil", 2, th5, new Object[0]);
            }
        }
    }

    public static void c(QQAppInterface qQAppInterface, RecentUser recentUser) {
        if (recentUser != null) {
            try {
                if (recentUser.getType() == 7220) {
                    d(qQAppInterface, "0X80098E3", "", "", "", "");
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQKRPUtil", 2, th5, new Object[0]);
                }
            }
        }
    }

    public static void d(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, String str5) {
        ReportController.o(qQAppInterface, "dc00898", "", "", str, str, 0, 0, str2, str3, str4, str5);
    }
}
