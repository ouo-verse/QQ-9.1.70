package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static String a(int i3, int i16, int i17) {
        return TransFileUtil.buildTag(TransFileUtil.getUinDesc(i3), RichMediaUtil.getFileTypeDesc(i17), RichMediaUtil.getActionDesc(i16), "L");
    }

    public static void b(Object obj, String str, String str2) {
        TransFileUtil.printRichMediaDebug(obj, str, str2);
    }

    public static void c(String str, String str2, String str3, String str4) {
        g(str, str2, str3, str4, 1);
    }

    public static void d(Object obj, String str, String str2) {
        TransFileUtil.printRichMediaError(obj, str, str2);
    }

    public static void e(String str, String str2, String str3, String str4) {
        g(str, str2, str3, str4, 2);
    }

    public static void f(String str, String str2, String str3, String str4) {
        g(str, str2, str3, str4, 2);
    }

    private static void g(String str, String str2, String str3, String str4, int i3) {
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "id:" + str2 + " \tstep:" + str3 + " \tcont:" + str4);
                return;
            }
            return;
        }
        if (i3 == 2) {
            QLog.e(str, 1, "id:" + str2 + " \tstep:" + str3 + " \tcont:" + str4);
        }
    }
}
