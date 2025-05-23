package com.tencent.mobileqq.managers;

import android.content.Intent;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static NotificationReportController f243709a;

    public static int a(String str, int i3, Intent intent) {
        boolean z16;
        int i16;
        int i17 = 0;
        if (intent != null) {
            z16 = intent.getBooleanExtra(AppConstants.Key.KEY_NOTIFYCATION_ONEWAY_MESSAGE, false);
        } else {
            z16 = false;
        }
        if (i3 == 1008) {
            i16 = 267;
        } else if (z16 && i3 == 1010) {
            i16 = 272;
        } else if ((z16 && i3 == 1001) || i3 == 10002) {
            i16 = 268;
        } else if (intent != null && intent.getBooleanExtra("qav_notify_flag", false)) {
            i16 = 236;
        } else if (i3 == 3001) {
            i16 = 271;
        } else if (i3 != 1044 && i3 != 1045) {
            if (intent != null && intent.getBooleanExtra("activepull_push_flag", false)) {
                i16 = 269;
            } else if (i3 == 1030) {
                if (intent != null) {
                    i16 = intent.getIntExtra("campus_notice_id", 0);
                }
                i16 = -1;
            } else if (i3 != 1035 && i3 != 1041 && i3 != 1042) {
                if (i3 == 1012) {
                    i16 = 240;
                } else if (i3 == 7225) {
                    i16 = 526;
                } else if (i3 == 10007) {
                    i16 = 527;
                } else {
                    i16 = 265;
                }
            } else {
                if (intent != null) {
                    i16 = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 0);
                }
                i16 = -1;
            }
        } else {
            i16 = 266;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getNotifyID: ");
            sb5.append(i16);
            sb5.append(", for uin: ");
            sb5.append(str);
            sb5.append(" and type: ");
            sb5.append(i3);
            sb5.append("  intent: ");
            if (intent != null) {
                i17 = 1;
            }
            sb5.append(i17);
            QLog.d("MsgPushReportHelper", 4, sb5.toString());
        }
        return i16;
    }

    public static void b(Intent intent) {
        NotificationReportController notificationReportController;
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 0);
                String stringExtra = intent.getStringExtra(QQNotificationManager.PARAM_FROMUIN);
                int intExtra2 = intent.getIntExtra(QQNotificationManager.PARAM_UINTYPE, 0);
                int intExtra3 = intent.getIntExtra(AppConstants.Key.COLUMN_MSG_TYPE, 0);
                intent.removeExtra(QQNotificationManager.PARAM_NOTIFYID);
                intent.removeExtra(QQNotificationManager.PARAM_FROMUIN);
                intent.removeExtra(QQNotificationManager.PARAM_UINTYPE);
                intent.removeExtra(AppConstants.Key.COLUMN_MSG_TYPE);
                if (QQNotificationManager.getInstance().isIdValid("MsgPushReportHelper", intExtra) && (notificationReportController = f243709a) != null) {
                    notificationReportController.report(2, intExtra, stringExtra, intExtra2);
                }
                if (intExtra2 == 1 && intExtra3 == -2016) {
                    f(intent.getStringExtra("KEY_FRIEND_UIN"));
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("MsgPushReportHelper", 2, th5, new Object[0]);
                }
            }
        }
    }

    public static void c(int i3, String str, int i16) {
        NotificationReportController notificationReportController = f243709a;
        if (notificationReportController != null) {
            notificationReportController.report(3, i3, str, i16);
        }
    }

    public static void d(int i3, String str, int i16) {
        NotificationReportController notificationReportController = f243709a;
        if (notificationReportController != null) {
            notificationReportController.report(4, i3, str, i16);
        }
    }

    public static void e(NotificationReportController notificationReportController) {
        f243709a = notificationReportController;
    }

    private static void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", str);
        hashMap.put(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, 1);
        VideoReport.reportEvent("ev_group_live_push_clck", hashMap);
    }
}
