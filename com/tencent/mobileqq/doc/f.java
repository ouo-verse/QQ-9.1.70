package com.tencent.mobileqq.doc;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static int a(AppInterface appInterface, Context context) {
        if (appInterface != null && context != null) {
            int i3 = context.getSharedPreferences("tencent_doc", 4).getInt("shown_" + appInterface.getCurrentAccountUin(), 0);
            if (QLog.isColorLevel()) {
                QLog.i("TencentDocGuideHelper", 2, "getShownTimes " + i3);
            }
            return i3;
        }
        QLog.e("TencentDocGuideHelper", 1, "getShownTimes sth is null");
        return 0;
    }

    public static void b(AppInterface appInterface, Context context, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("TencentDocGuideHelper", 2, "setShownTimes " + i3);
        }
        if (appInterface != null && context != null) {
            context.getSharedPreferences("tencent_doc", 4).edit().putInt("shown_" + appInterface.getCurrentAccountUin(), i3).commit();
            return;
        }
        QLog.e("TencentDocGuideHelper", 1, "setShownTimes sth is null");
    }
}
