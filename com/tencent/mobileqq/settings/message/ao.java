package com.tencent.mobileqq.settings.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ao {
    static IPatchRedirector $redirector_;

    public static void a(AppInterface appInterface, String str, boolean z16) {
        if (z16) {
            ReportController.o(appInterface, "dc00898", "", "", str, str, 1, 0, "", "", "", "");
        } else {
            ReportController.o(appInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        }
    }
}
