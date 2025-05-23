package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToastNotifier;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static void a(BaseActivity baseActivity, String str, int i3) {
        if (str != null && str.length() != 0 && baseActivity != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            new QQToastNotifier(baseActivity).notifyUser(str, baseActivity.getTitleBarHeight(), 0, i3);
        }
    }

    public static String b(String str) {
        if (str == null) {
            return "null";
        }
        return String.valueOf(str.length());
    }
}
