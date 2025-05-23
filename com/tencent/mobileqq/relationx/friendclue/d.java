package com.tencent.mobileqq.relationx.friendclue;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendClueReporter", 2, String.format("reportFriendClueClick source=%s", Integer.valueOf(i3)));
        }
        ReportController.o(null, "dc00898", "", "", "0X800B6B7", "0X800B6B7", i3, 0, "", "", "", "");
    }

    public static void b(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendClueReporter", 2, String.format("reportFriendClueExpose source=%s", Integer.valueOf(i3)));
        }
        ReportController.o(null, "dc00898", "", "", "0X800B6B6", "0X800B6B6", i3, 0, "", "", "", "");
    }
}
