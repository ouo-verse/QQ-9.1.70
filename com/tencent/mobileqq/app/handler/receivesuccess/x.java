package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.k;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class x {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("TransService.ReqGetSign".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            k.c cVar = (k.c) obj;
            if (cVar == null) {
                messageHandler.handleError(toServiceMsg, fromServiceMsg);
            } else {
                ((IPicTransFile) messageHandler.Q.getRuntimeService(IPicTransFile.class, "")).setSig(cVar.f286309a, cVar.f286310b);
                messageHandler.notifyBusiness(5002, true, null);
            }
        }
    }
}
