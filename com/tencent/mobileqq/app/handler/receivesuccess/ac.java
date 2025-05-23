package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.k;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ac {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, FromServiceMsg fromServiceMsg, Object obj) {
        if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (obj == null) {
                messageHandler.notifyUI(3011, false, null);
            } else {
                messageHandler.notifyUI(3011, true, new Object[]{(k.d) obj});
            }
        }
    }
}
