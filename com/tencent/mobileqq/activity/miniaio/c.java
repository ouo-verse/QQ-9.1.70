package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static String a(boolean z16) {
        if (z16) {
            return "2";
        }
        return "1";
    }

    public static void b(String str, String str2, String str3) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, str2, str3, "", "");
    }

    public static void c(boolean z16) {
        b("0X8009C2B", "", a(z16));
    }

    public static void d(QQAppInterface qQAppInterface, int i3, boolean z16) {
        int i16;
        if (qQAppInterface != null && qQAppInterface.getMessageFacade() != null) {
            i16 = com.tencent.mobileqq.activity.home.chats.unread.c.b();
        } else {
            i16 = 0;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A0F6", "0X800A0F6", i3, 1, "" + i16, a(z16), "", "");
    }
}
