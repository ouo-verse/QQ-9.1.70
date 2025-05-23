package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ae {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (obj == null) {
                messageHandler.M3(toServiceMsg, fromServiceMsg);
            } else {
                messageHandler.notifyCallBack(toServiceMsg, 3012, true, new Object[]{obj});
            }
        }
    }
}
