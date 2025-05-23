package com.tencent.mobileqq.app.handler.receivesuccess;

import AccostSvc.RespGetBlackList;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && fromServiceMsg.getResultCode() == 1000 && obj != null) {
            RespGetBlackList respGetBlackList = (RespGetBlackList) obj;
            if (respGetBlackList.stHeader.eReplyCode == 0) {
                int size = respGetBlackList.vBlackListUin.size();
                if (size > 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        String str = respGetBlackList.vBlackListUin.get(i3).longValue() + "";
                        com.tencent.qqnt.contact.friends.b bVar = com.tencent.qqnt.contact.friends.b.f355778a;
                        if (!bVar.c(str, "GetBlackList")) {
                            bVar.a(str, "GetBlackList");
                        }
                    }
                }
                long j3 = respGetBlackList.lNextMid;
                if (j3 != -1) {
                    messageHandler.V2(j3);
                }
            }
        }
    }
}
