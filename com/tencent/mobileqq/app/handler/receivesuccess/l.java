package com.tencent.mobileqq.app.handler.receivesuccess;

import PushNotifyPack.RequestPushNotify;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.util.az;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        if ("MessageSvc.PushNotify".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            boolean z17 = false;
            String str2 = null;
            if (obj instanceof RequestPushNotify) {
                RequestPushNotify requestPushNotify = (RequestPushNotify) obj;
                messageHandler.Q.userActiveStatus = requestPushNotify.wUserActive;
                if ((requestPushNotify.wGeneralFlag & 8) == 8) {
                    str2 = Long.toString(requestPushNotify.lBindedUin);
                    if ((requestPushNotify.wGeneralFlag & 16) == 16) {
                        messageHandler.Q.getMsgHandler().l3().f1(requestPushNotify);
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (requestPushNotify.ping_flag == 1) {
                    messageHandler.delC2COnlinePushMsg(requestPushNotify.lUin, requestPushNotify.svrip, fromServiceMsg.getRequestSsoSeq());
                }
                if ((requestPushNotify.wGeneralFlag & 32) == 32) {
                    az.d(true);
                } else {
                    az.d(false);
                }
                if (QLog.isColorLevel()) {
                    if (z16) {
                        str = "SUB_ACCOUNT";
                    } else {
                        str = "Q.msg.MessageHandler";
                    }
                    QLog.d(str, 2, String.format("MessageSvc.PushNotify, notify.wUserActive: %d isSubAccount: %s, cmd: %s, wGeneralFlag:%d, bytesServerBuf: %s, ping_flag%d", Integer.valueOf(requestPushNotify.wUserActive), Boolean.valueOf(z16), requestPushNotify.strCmd, Integer.valueOf(requestPushNotify.wGeneralFlag), requestPushNotify.bytes_server_buf, Long.valueOf(requestPushNotify.ping_flag)));
                }
                z17 = z16;
            }
            if (z17) {
                if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "subaccount push and start get subaccount msg, subUin=" + str2);
                }
                if (str2 != null) {
                    ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).loadServerMessage(messageHandler.Q, str2, true);
                    return;
                }
                return;
            }
            if (messageHandler.Q.mAutomator.G2()) {
                messageHandler.p3(fromServiceMsg, obj);
            }
        }
    }
}
