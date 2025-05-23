package com.tencent.mobileqq.app.handler.receivesuccess;

import AccostSvc.RespClientMsg;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class w {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        long j16 = toServiceMsg.extraData.getLong("uniseq");
        long j17 = toServiceMsg.extraData.getLong("to");
        long j18 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        Object[] objArr = {String.valueOf(j17), 1001, 0, null, Long.valueOf(j18), Long.valueOf(j16)};
        messageHandler.Q.getMessageFacade().Z0(j17 + "", 1001, j16, 32768, fromServiceMsg.getResultCode());
        messageHandler.notifyBusiness(3001, false, objArr);
        if (480000 == j18 && messageHandler.getHandlerFromQueue(j3) != null) {
            messageHandler.removeSendMessageHandler(j3);
        }
    }

    public static void b(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("AccostSvc.ClientMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            RespClientMsg respClientMsg = (RespClientMsg) obj;
            if (respClientMsg == null) {
                a(messageHandler, toServiceMsg, fromServiceMsg);
                return;
            }
            toServiceMsg.extraData.getLong("startTime", 0L);
            long j3 = toServiceMsg.extraData.getLong("msgSeq");
            long j16 = toServiceMsg.extraData.getLong("uniseq");
            long j17 = toServiceMsg.extraData.getLong("to");
            long j18 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
            messageHandler.removeSendMessageHandler(j3);
            if (respClientMsg.stHeader.eReplyCode == 0) {
                messageHandler.Q.getMsgCache().G1(String.valueOf(toServiceMsg.extraData.getLong("to")), 1001, j16);
                messageHandler.notifyUI(6003, true, new String[]{String.valueOf(toServiceMsg.extraData.getLong("to")), j16 + ""});
                return;
            }
            Object[] objArr = {String.valueOf(j17), 1001, Integer.valueOf(respClientMsg.stHeader.eReplyCode), null, Long.valueOf(j18), Long.valueOf(j16)};
            messageHandler.Q.getMessageFacade().Z0(j17 + "", 1001, j16, 32768, fromServiceMsg.getResultCode());
            messageHandler.notifyBusiness(3001, false, objArr);
        }
    }
}
