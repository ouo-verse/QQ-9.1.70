package com.tencent.mobileqq.pushnotice;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.b
    public boolean a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent)).booleanValue();
        }
        return c.c(intent);
    }

    @Override // com.tencent.mobileqq.pushnotice.b
    public ThirdPushNotifyManager.PushNotificationData b(Intent intent) {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ThirdPushNotifyManager.PushNotificationData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        String stringExtra = intent.getStringExtra("third_id");
        String stringExtra2 = intent.getStringExtra("type");
        String stringExtra3 = intent.getStringExtra("url");
        String stringExtra4 = intent.getStringExtra("report_data");
        String stringExtra5 = intent.getStringExtra("token");
        String stringExtra6 = intent.getStringExtra("to_uin");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.i("HwPushDataHandler", 1, "handlePushJumpIntent: thirdId is empty.");
            return null;
        }
        try {
            int parseInt2 = Integer.parseInt(stringExtra);
            if (TextUtils.isEmpty(stringExtra2)) {
                parseInt = -1;
            } else {
                parseInt = Integer.parseInt(stringExtra2);
            }
            return new ThirdPushNotifyManager.PushNotificationData(parseInt2, parseInt, stringExtra3, stringExtra4, stringExtra5, stringExtra6);
        } catch (NumberFormatException e16) {
            QLog.e("HwPushDataHandler", 1, "handlePushJumpIntent: exception.", e16);
            return null;
        }
    }
}
