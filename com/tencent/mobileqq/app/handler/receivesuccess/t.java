package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.onlinepush.OnlinePushTrans$PbMsgInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class t {
    static IPatchRedirector $redirector_;

    public static void a(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if ("OnlinePush.PbPushTransMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            byte[] bArr = new byte[wupBuffer.length - 4];
            PkgTools.copyData(bArr, 0, wupBuffer, 4, wupBuffer.length - 4);
            OnlinePushTrans$PbMsgInfo onlinePushTrans$PbMsgInfo = new OnlinePushTrans$PbMsgInfo();
            try {
                onlinePushTrans$PbMsgInfo.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                onlinePushTrans$PbMsgInfo = null;
            }
            if (onlinePushTrans$PbMsgInfo != null) {
                if ((onlinePushTrans$PbMsgInfo.uint32_general_flag.get() & 32) == 32) {
                    az.d(true);
                } else {
                    az.d(false);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "PbPushTransMsg muteGeneralFlag:", Integer.valueOf(onlinePushTrans$PbMsgInfo.uint32_general_flag.get()));
                }
                if (onlinePushTrans$PbMsgInfo.msg_type.get() == 207) {
                    messageHandler.u3(onlinePushTrans$PbMsgInfo.msg_data.get().toByteArray());
                } else if (onlinePushTrans$PbMsgInfo.msg_type.get() == 529 && onlinePushTrans$PbMsgInfo.msg_subtype.get() == 11) {
                    messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_VIDEO).t(3001, toServiceMsg, fromServiceMsg, onlinePushTrans$PbMsgInfo.msg_data.get().toByteArray());
                }
            }
            ToServiceMsg createToServiceMsg = messageHandler.createToServiceMsg(BaseConstants.CMD_RESPPUSH);
            if (onlinePushTrans$PbMsgInfo != null) {
                int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
                createToServiceMsg.extraData.putInt("svrip", onlinePushTrans$PbMsgInfo.svr_ip.get());
                createToServiceMsg.extraData.putInt("seq", requestSsoSeq);
            }
            createToServiceMsg.extraData.putLong("lUin", Long.parseLong(messageHandler.Q.getCurrentAccountUin()));
            createToServiceMsg.setNeedCallback(false);
            messageHandler.send(createToServiceMsg);
        }
    }
}
