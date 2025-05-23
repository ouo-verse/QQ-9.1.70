package com.tencent.mobileqq.app.message;

import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.ag;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21$ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    public h(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
        }
    }

    private boolean A(MsgInfo msgInfo) {
        JceInputStream jceInputStream = new JceInputStream(msgInfo.vMsg);
        SlaveMasterMsg slaveMasterMsg = new SlaveMasterMsg();
        slaveMasterMsg.readFrom(jceInputStream);
        if (((int) slaveMasterMsg.uMsgType) == 529 && 4 == slaveMasterMsg.uCmd) {
            z(((QQAppInterface) this.f116342a).getMsgHandler(), msgInfo, slaveMasterMsg);
            return true;
        }
        return false;
    }

    private void z(MessageHandler messageHandler, MsgInfo msgInfo, SlaveMasterMsg slaveMasterMsg) {
        hummer_resv_21$ResvAttr hummer_resv_21_resvattr;
        try {
            SubMsgType0x4$MsgBody mergeFrom = new SubMsgType0x4$MsgBody().mergeFrom(slaveMasterMsg.vOrigMsg);
            if (mergeFrom.msg_not_online_file.has()) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody is NotOnlineFile");
                }
                im_msg_body$NotOnlineFile im_msg_body_notonlinefile = mergeFrom.msg_not_online_file.get();
                if (mergeFrom.resv_attr.has()) {
                    hummer_resv_21_resvattr = mergeFrom.resv_attr.get();
                } else {
                    hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
                }
                hummer_resv_21$ResvAttr hummer_resv_21_resvattr2 = hummer_resv_21_resvattr;
                if (mergeFrom.file_image_info.has()) {
                    hummer_resv_21_resvattr2.file_image_info.set(mergeFrom.file_image_info.get());
                }
                ArrayList arrayList = new ArrayList();
                msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
                msg_comm_msg.msg_head.msg_uid.set(msgInfo.lMsgUid);
                msg_comm_msg.msg_head.msg_time.set(msgInfo.uRealMsgTime);
                msg_comm_msg.msg_head.from_uin.set(slaveMasterMsg.lFromUin);
                msg_comm_msg.msg_head.msg_seq.set((int) slaveMasterMsg.uSeq);
                messageHandler.Q.getFileTransferHandler().V(messageHandler, arrayList, msg_comm_msg, im_msg_body_notonlinefile, String.valueOf(slaveMasterMsg.lToUin), true, false, -100L, -1, hummer_resv_21_resvattr2);
                return;
            }
            if (mergeFrom.msg_wlan_recved_notify.has()) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody is WlanRecvedNotify");
                }
                messageHandler.Q.getFileTransferHandler().t0(mergeFrom.msg_wlan_recved_notify.get());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", e16);
            }
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public ag o(int i3, MsgInfo msgInfo, SvcReqPushMsg svcReqPushMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ag) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), msgInfo, svcReqPushMsg);
        }
        if (i3 == 9012) {
            if (msgInfo != null && svcReqPushMsg != null) {
                z16 = A(msgInfo);
            } else {
                f(getClass().getName(), i3);
            }
        }
        return new ag(null, z16);
    }
}
