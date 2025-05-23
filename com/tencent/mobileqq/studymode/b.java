package com.tencent.mobileqq.studymode;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(AppInterface appInterface) {
        try {
            return ((Boolean) com.tencent.mobileqq.utils.p.a(BaseApplication.context, appInterface.getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.FALSE)).booleanValue();
        } catch (Throwable th5) {
            QLog.e("AlphabeticFontHelper", 1, th5, new Object[0]);
            return false;
        }
    }
}
