package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NotificationDeleteReceiver extends QQBroadcastReceiver {
    static IPatchRedirector $redirector_;

    public NotificationDeleteReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.QQBroadcastReceiver
    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
        com.tencent.util.notification.d h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, context, intent);
            return;
        }
        QLog.d("NotificationDeleteReceiver", 2, "NotificationDeleteReceiver");
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X80046A6", "0X80046A6", 0, 0, "", "", "", "");
        String stringExtra = intent.getStringExtra("uin");
        int intExtra = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 0);
        if (QLog.isColorLevel()) {
            QLog.i("NotificationDeleteReceiver", 2, "onReceive: invoked.  notifyId: " + intExtra + " friendOrTroopUin: " + stringExtra);
        }
        if (intExtra >= 512 && intExtra <= 522 && (h16 = com.tencent.util.notification.d.h(qQAppInterface)) != null) {
            h16.f(stringExtra);
        }
    }
}
