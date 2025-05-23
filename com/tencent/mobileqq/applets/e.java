package com.tencent.mobileqq.applets;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {
    static IPatchRedirector $redirector_;

    private static void a(@NonNull QQAppInterface qQAppInterface, boolean z16, int i3, long j3, long j16, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountStateReporter", 2, "doPublicAccountFollowState { isFollow=", Boolean.valueOf(z16), " appType=", Integer.valueOf(i3), " appid=", Long.valueOf(j3), " puin=", Long.valueOf(j16), " source=", Integer.valueOf(i16), " }");
        }
        AppletsHandler appletsHandler = (AppletsHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        if (appletsHandler != null) {
            appletsHandler.Q2(z16, i3, j3, j16, i16);
        }
    }

    public static void b(@NonNull QQAppInterface qQAppInterface, boolean z16, long j3, int i3) {
        a(qQAppInterface, z16, -1, -1L, j3, i3);
    }

    public static void c(@NonNull QQAppInterface qQAppInterface, boolean z16, String str, int i3) {
        try {
            a(qQAppInterface, z16, -1, -1L, Long.parseLong(str), i3);
        } catch (NumberFormatException unused) {
            QLog.d("PublicAccountStateReporter", 1, "NumberFormatException, puin=", str);
        }
    }

    private static int d(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 0;
        }
        return 2;
    }

    public static void e(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        int d16 = d(i3);
        if (QLog.isColorLevel()) {
            QLog.i("PublicAccountStateReporter", 2, "onPublicAccountReceiveState state : " + d16 + ", name: " + str2 + ", pUin: " + str);
        }
        AppletsHandler appletsHandler = (AppletsHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        if (appletsHandler != null) {
            appletsHandler.T2(str, str2, d16);
        }
    }
}
