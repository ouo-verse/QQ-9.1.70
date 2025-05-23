package com.tencent.commonsdk.util.notification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NotificationLimiterUtil {
    static IPatchRedirector $redirector_;
    static NotificationLimiter s_notificationLimiter;

    public NotificationLimiterUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void setLimiter(NotificationLimiter notificationLimiter) {
        s_notificationLimiter = notificationLimiter;
    }

    public static boolean shouldNotify(int i3) {
        boolean z16;
        NotificationLimiter notificationLimiter = s_notificationLimiter;
        if (notificationLimiter != null) {
            z16 = notificationLimiter.shouldNotify(i3);
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(QQNotificationManager.TAG, 2, "studymode_fight notify id:" + i3 + ",s_notificationLimiter " + s_notificationLimiter + ",result = " + z16);
        }
        return z16;
    }
}
