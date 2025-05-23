package com.tencent.mobileqq.msf.core.push;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249681a = "NewMsgNotificationManager";

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static boolean a(Context context) {
        boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(context);
        if (QLog.isColorLevel()) {
            QLog.d(f249681a, 2, "checkSystemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(areNotificationsEnabled));
        }
        return areNotificationsEnabled;
    }

    public static boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return a(context, str);
        }
        return true;
    }

    static boolean a(Context context, String str) {
        boolean readValue = SettingCloneUtil.readValue(context, str, (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
        if (QLog.isColorLevel()) {
            QLog.d(f249681a, 2, "globalSwitchOn: invoked. ", " enable: ", Boolean.valueOf(readValue));
        }
        return readValue;
    }
}
