package com.tencent.mobileqq.reminder.biz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.impl.QQReminderAlarmServiceImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderAlarmReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    public QQReminderAlarmReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AppRuntime peekAppRuntime;
        IQQReminderDataService iQQReminderDataService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (QQReminderAlarmServiceImpl.NOTIFICATION_ALRAM_ACTION.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("msg");
            String stringExtra2 = intent.getStringExtra("msg_id");
            if (QLog.isColorLevel()) {
                QLog.d("QQReminderAlarmReceiver", 2, "---" + stringExtra + "---msgId---" + stringExtra2);
            }
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iQQReminderDataService = (IQQReminderDataService) peekAppRuntime.getRuntimeService(IQQReminderDataService.class, "")) != null) {
                iQQReminderDataService.doNotifaction(stringExtra, stringExtra2);
            }
        }
    }
}
