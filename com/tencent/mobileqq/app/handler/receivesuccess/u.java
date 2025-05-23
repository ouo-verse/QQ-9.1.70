package com.tencent.mobileqq.app.handler.receivesuccess;

import PushAdMsg.AdMsgInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class u {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        AdMsgInfo adMsgInfo;
        if ("ADMsgSvc.PushMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && (adMsgInfo = (AdMsgInfo) obj) != null && String.valueOf(adMsgInfo.uDstUin).equalsIgnoreCase(toServiceMsg.getUin())) {
            long j3 = adMsgInfo.utime;
            String str = adMsgInfo.strMsgContent;
            int i3 = adMsgInfo.uMsgType;
            if (i3 == 9) {
                MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-2003);
                d16.selfuin = messageHandler.Q.getCurrentAccountUin();
                String str2 = AppConstants.QQBROADCAST_MSG_UIN;
                d16.frienduin = String.valueOf(str2);
                d16.senderuin = String.valueOf(str2);
                d16.f203106msg = str;
                d16.time = j3;
                d16.msgtype = -2003;
                d16.istroop = 0;
                if (!MessageHandlerUtils.msgFilter(messageHandler.Q, d16, false)) {
                    messageHandler.Q.getMessageFacade().c(d16, messageHandler.Q.getCurrentAccountUin());
                    messageHandler.v4("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(adMsgInfo.uSrcUin), 1, true, false, null);
                    return;
                }
                return;
            }
            if (i3 == 513) {
                int c16 = com.tencent.mobileqq.config.a.c(str);
                String b16 = com.tencent.mobileqq.config.a.b(str);
                if ((c16 == 0 || c16 == 2) && b16 != null) {
                    if (b16.equals("WAP") || b16.equals("WAPI") || b16.equals("TMTWAP") || b16.equals("TMTWAPI") || b16.equals("LOCAL")) {
                        MessageRecord d17 = com.tencent.mobileqq.service.message.q.d(-2004);
                        d17.selfuin = messageHandler.Q.getCurrentAccountUin();
                        String str3 = AppConstants.QQBROADCAST_MSG_UIN;
                        d17.frienduin = String.valueOf(str3);
                        d17.senderuin = String.valueOf(str3);
                        d17.f203106msg = str;
                        d17.time = j3;
                        d17.msgtype = -2004;
                        d17.istroop = 0;
                        if (!MessageHandlerUtils.msgFilter(messageHandler.Q, d17, false)) {
                            messageHandler.Q.getMessageFacade().c(d17, messageHandler.Q.getCurrentAccountUin());
                            messageHandler.v4("handlePushADMessageResp", 1000, true, "0_" + String.valueOf(adMsgInfo.uSrcUin), 1, true, false, null);
                        }
                    }
                }
            }
        }
    }
}
