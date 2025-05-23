package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bs implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, byte[] bArr, MsgInfo msgInfo) {
        boolean z16;
        SubMsgType0xcb$MsgBody subMsgType0xcb$MsgBody = new SubMsgType0xcb$MsgBody();
        try {
            subMsgType0xcb$MsgBody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg decode failed" + e16.toString());
            }
        }
        MessageForNearbyLiveTip messageForNearbyLiveTip = (MessageForNearbyLiveTip) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP);
        boolean z17 = false;
        if (subMsgType0xcb$MsgBody.uint32_anchor_status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        messageForNearbyLiveTip.isLiving = z16;
        messageForNearbyLiveTip.jumpingUrl = subMsgType0xcb$MsgBody.bytes_jump_schema.get().toStringUtf8();
        messageForNearbyLiveTip.f203106msg = subMsgType0xcb$MsgBody.bytes_live_wording.get().toStringUtf8();
        messageForNearbyLiveTip.headUrl = subMsgType0xcb$MsgBody.bytes_anchor_head_url.get().toStringUtf8();
        messageForNearbyLiveTip.nickName = subMsgType0xcb$MsgBody.bytes_anchor_nickname.get().toStringUtf8();
        messageForNearbyLiveTip.liveEndWording = subMsgType0xcb$MsgBody.bytes_live_end_wording.get().toStringUtf8();
        messageForNearbyLiveTip.c2cMsgWording = subMsgType0xcb$MsgBody.bytes_c2c_msg_wording.get().toStringUtf8();
        messageForNearbyLiveTip.startLiveWordingType = subMsgType0xcb$MsgBody.uint32_live_wording_type.get();
        messageForNearbyLiveTip.endLiveWordingType = subMsgType0xcb$MsgBody.uint32_end_wording_type.get();
        int i3 = msgInfo.uRealMsgTime;
        messageForNearbyLiveTip.time = i3;
        messageForNearbyLiveTip.msgseq = i3;
        messageForNearbyLiveTip.shmsgseq = msgInfo.shMsgSeq;
        messageForNearbyLiveTip.msgUid = msgInfo.lMsgUid;
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        messageForNearbyLiveTip.selfuin = qQAppInterface.getCurrentAccountUin();
        messageForNearbyLiveTip.istroop = 1001;
        long j3 = msgInfo.lFromUin;
        long j16 = AppConstants.NOW_LIVE_TIP_UIN_BASE;
        messageForNearbyLiveTip.senderuin = String.valueOf(j3 + j16);
        messageForNearbyLiveTip.frienduin = String.valueOf(msgInfo.lFromUin + j16);
        messageForNearbyLiveTip.getBytes();
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "status=" + messageForNearbyLiveTip.isLiving + "jumpingUrl=" + messageForNearbyLiveTip.jumpingUrl + "liveWording=" + messageForNearbyLiveTip.f203106msg + "headUrl" + messageForNearbyLiveTip.headUrl + "nickName" + messageForNearbyLiveTip.nickName + "startLiveWordingType=" + subMsgType0xcb$MsgBody.uint32_live_wording_type.get() + "endLiveWordingType=" + subMsgType0xcb$MsgBody.uint32_end_wording_type.get());
        }
        if (MessageForNearbyLiveTip.isHuayangTip(messageForNearbyLiveTip.jumpingUrl) && !MessageForNearbyLiveTip.isSupportHuayangBusinessType(messageForNearbyLiveTip.jumpingUrl)) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg discard a not support huayang tips message, jumpUrl=" + messageForNearbyLiveTip.jumpingUrl);
                return;
            }
            return;
        }
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        if (!MessageHandlerUtils.msgFilter(qQAppInterface, messageForNearbyLiveTip, true)) {
            arrayList.add(messageForNearbyLiveTip);
            boolean equals = messageForNearbyLiveTip.senderuin.equals(String.valueOf(j16 + 1822701914));
            if (equals) {
                messageForNearbyLiveTip.isLiving = true;
            }
            if (messageForNearbyLiveTip.isLiving) {
                boolean hasRecvAndUnreadMsg = BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList);
                int j17 = com.tencent.imcore.message.ad.j(arrayList, qQAppInterface.getMsgCache());
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                if (hasRecvAndUnreadMsg && qQAppInterface.isBackgroundStop) {
                    z17 = true;
                }
                messageFacade.e(arrayList, currentAccountUin, z17);
                qQAppInterface.getMsgCache().L1((int) messageForNearbyLiveTip.time);
                if (!StudyModeManager.t() && equals) {
                    afVar.n("handleGetBuddyMessageResp", true, j17, qQAppInterface.getMsgHandler().needNotifyNotification(hasRecvAndUnreadMsg), false);
                    return;
                }
                return;
            }
            Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(messageForNearbyLiveTip.frienduin, messageForNearbyLiveTip.istroop);
            if (lastMessage != null) {
                qQAppInterface.getMessageFacade().Y0(messageForNearbyLiveTip.frienduin, messageForNearbyLiveTip.istroop, lastMessage.uniseq, messageForNearbyLiveTip.msgData);
                qQAppInterface.getMessageFacade().K0(lastMessage);
                return;
            }
            boolean hasRecvAndUnreadMsg2 = BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList);
            QQMessageFacade messageFacade2 = qQAppInterface.getMessageFacade();
            String currentAccountUin2 = qQAppInterface.getCurrentAccountUin();
            if (hasRecvAndUnreadMsg2 && qQAppInterface.isBackgroundStop) {
                z17 = true;
            }
            messageFacade2.e(arrayList, currentAccountUin2, z17);
            qQAppInterface.getMsgCache().L1((int) messageForNearbyLiveTip.time);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(afVar, msgType0x210.vProtobuf, msgInfo);
        return null;
    }
}
