package com.tencent.mobileqq.doc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        QLog.d("TencentDocUtils", 1, "WL_DEBUG reportClickEvent actionName = " + str);
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
}
