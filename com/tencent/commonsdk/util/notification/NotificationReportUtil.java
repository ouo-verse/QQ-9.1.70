package com.tencent.commonsdk.util.notification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NotificationReportUtil {
    static IPatchRedirector $redirector_;
    static NotificationReportController s_notificationReportController;

    public NotificationReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportAll() {
        NotificationReportController notificationReportController = s_notificationReportController;
        if (notificationReportController != null) {
            notificationReportController.reportAll();
        }
    }

    public static void reportNotification(int i3, String str, int i16) {
        NotificationReportController notificationReportController = s_notificationReportController;
        if (notificationReportController != null) {
            notificationReportController.report(1, i3, str, i16);
        }
    }

    public static void setReport(NotificationReportController notificationReportController) {
        s_notificationReportController = notificationReportController;
    }
}
