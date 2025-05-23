package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            try {
                messageHandler.y3(toServiceMsg, fromServiceMsg, obj);
            } catch (Exception e16) {
                QLog.w("MessageSvcPbGetShareHistoryGroupMsg", 1, "onReceiveMessage exception ! ", e16);
                messageHandler.H3(toServiceMsg, fromServiceMsg);
            }
        }
    }
}
