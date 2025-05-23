package com.tencent.mobileqq.pushnotice;

import android.text.TextUtils;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class QQHuaweiPushService extends HmsMessageService {
    static IPatchRedirector $redirector_;

    public QQHuaweiPushService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) remoteMessage);
            return;
        }
        super.onMessageReceived(remoteMessage);
        if (QLog.isColorLevel()) {
            QLog.d("HPush", 2, "HPush_Huawei Push Token-QQHuaweiPushSddervice.onMessageReceived : ");
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        super.onNewToken(str);
        ThirdPushManager.getInstance().setToken(str);
        if (!TextUtils.isEmpty(str)) {
            ThirdPushManager.getInstance().registerThirdPartyPush();
        }
        if (QLog.isColorLevel()) {
            QLog.d("HPush", 2, "HPush_Huawei Push Token-QQHuaweiPushService.onNewToken : " + TextUtils.isEmpty(str));
        }
    }
}
