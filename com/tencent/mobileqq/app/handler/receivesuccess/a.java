package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        if ("AccostSvc.ReqDeleteBlackList".equals(fromServiceMsg.getServiceCmd())) {
            String string = toServiceMsg.extraData.getString("deleteUin");
            int i3 = toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE);
            if (fromServiceMsg.getResultCode() == 1000) {
                messageHandler.O4(string);
            }
            if (fromServiceMsg.getResultCode() == 1000) {
                z16 = true;
            } else {
                z16 = false;
            }
            messageHandler.notifyUI(6002, z16, new Object[]{string, Integer.valueOf(i3)});
        }
    }
}
