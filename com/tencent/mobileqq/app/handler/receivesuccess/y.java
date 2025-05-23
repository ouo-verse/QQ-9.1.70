package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgResp;
import tencent.im.oidb.cmd0xa89.oidb_0xa89$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class y {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:40:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        oidb_0xa89$RspBody oidb_0xa89_rspbody;
        int i3;
        msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp;
        String str;
        long j3;
        boolean z16;
        Object obj2;
        boolean z17;
        long j16;
        if ("OidbSvc.0xa89".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageRespPB enter");
            }
            String string = toServiceMsg.extraData.getString("groupuin");
            long j17 = toServiceMsg.extraData.getLong("msgSeq");
            long j18 = toServiceMsg.extraData.getLong("uniseq");
            try {
                oidb_0xa89_rspbody = new oidb_0xa89$RspBody();
                i3 = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xa89_rspbody);
            } catch (Exception e16) {
                e16.printStackTrace();
                oidb_0xa89_rspbody = null;
                i3 = 4;
            }
            if (oidb_0xa89_rspbody != null) {
                j3 = oidb_0xa89_rspbody.uint64_msg_seq.get();
                str = oidb_0xa89_rspbody.bytes_poid.get().toStringUtf8();
                oidb_0xa89_rspbody.bytes_msg_error_info.get().toStringUtf8();
                if (oidb_0xa89_rspbody.bytes_rsp_msg_body.has()) {
                    try {
                        msg_svc_pbsendmsgresp = new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
                    } catch (Exception unused) {
                    }
                }
                msg_svc_pbsendmsgresp = null;
            } else {
                msg_svc_pbsendmsgresp = null;
                str = null;
                j3 = 0;
            }
            fromServiceMsg.extraData.putLong("ServerReplyCode", i3);
            messageHandler.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, String.format("%s, troopUin = %s, replycode=%d, msgSeq=%d, uniseq=%d, shmsgseq=%d, uuid=%s", "handleSendHotchatTopicMessageRespPB", string, Integer.valueOf(i3), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j3), str));
            }
            SendMessageHandler handlerFromQueue = messageHandler.getHandlerFromQueue(j17);
            if (handlerFromQueue == null) {
                return;
            }
            if (i3 == 255) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && messageHandler.retrySendMessage(handlerFromQueue, "server")) {
                return;
            }
            Object[] objArr = new Object[7];
            objArr[0] = string;
            objArr[1] = 1026;
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = toServiceMsg.getAttribute("sendmsgHandler");
            objArr[4] = Long.valueOf(toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT));
            objArr[5] = Long.valueOf(j18);
            if (msg_svc_pbsendmsgresp != null) {
                obj2 = msg_svc_pbsendmsgresp.errmsg.get();
            } else {
                obj2 = "";
            }
            objArr[6] = obj2;
            if (i3 != 108 && i3 != 102) {
                if (i3 == 0) {
                    z17 = true;
                    if (!z17) {
                        messageHandler.Q.getMsgCache().G1(string, 1026, j18);
                        long j19 = toServiceMsg.extraData.getLong("msg_request_time", 0L);
                        messageHandler.notifyUI(6003, true, new String[]{string, String.valueOf(j18)});
                        if (j19 == 0) {
                            j19 = com.tencent.mobileqq.service.message.e.K0();
                        }
                        j16 = j18;
                        messageHandler.updateGroupMsgSeqAndTime(string, 1026, j18, j3, j19);
                    } else {
                        j16 = j18;
                        messageHandler.s5(objArr, fromServiceMsg.getUin(), i3);
                        messageHandler.notifyBusiness(3013, false, objArr);
                    }
                    messageHandler.S3(toServiceMsg, fromServiceMsg, i3, j16, z17);
                    messageHandler.removeSendMessageHandler(j17);
                    com.tencent.mobileqq.app.handler.d.a(messageHandler.Q, toServiceMsg, fromServiceMsg);
                }
            } else {
                RecentUserProxy m3 = messageHandler.Q.getProxyManager().m();
                RecentUser findRecentUserByUin = m3.findRecentUserByUin(string, 1);
                if (findRecentUserByUin != null) {
                    m3.delRecentUser(findRecentUserByUin);
                }
                messageHandler.notifyBusiness(1002, true, objArr);
                messageHandler.notifyBusiness(2001, true, objArr);
                messageHandler.notifyBusiness(2002, true, objArr);
            }
            z17 = false;
            if (!z17) {
            }
            messageHandler.S3(toServiceMsg, fromServiceMsg, i3, j16, z17);
            messageHandler.removeSendMessageHandler(j17);
            com.tencent.mobileqq.app.handler.d.a(messageHandler.Q, toServiceMsg, fromServiceMsg);
        }
    }
}
