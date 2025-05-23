package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x85.SubMsgType0x85$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bd implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MessageRecord b(QQAppInterface qQAppInterface, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        int i3;
        int i16;
        String str;
        String currentAccountUin;
        String str2;
        SubMsgType0x85$MsgBody subMsgType0x85$MsgBody = new SubMsgType0x85$MsgBody();
        MessageForQQWalletTips messageForQQWalletTips = (MessageForQQWalletTips) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_QQWALLET_TIPS);
        try {
            subMsgType0x85$MsgBody.mergeFrom(msgType0x210.vProtobuf);
            messageForQQWalletTips.senderUin = subMsgType0x85$MsgBody.uint64_sender_uin.get() + "";
            messageForQQWalletTips.reciverUin = subMsgType0x85$MsgBody.uint64_receiver_uin.get() + "";
            messageForQQWalletTips.senderContent = subMsgType0x85$MsgBody.bytes_sender_rich_content.get().toStringUtf8();
            messageForQQWalletTips.reciverContent = subMsgType0x85$MsgBody.bytes_receiver_rich_content.get().toStringUtf8();
            messageForQQWalletTips.authKey = subMsgType0x85$MsgBody.bytes_authkey.get().toStringUtf8();
            messageForQQWalletTips.type = subMsgType0x85$MsgBody.uint32_type.get();
            messageForQQWalletTips.subType = subMsgType0x85$MsgBody.uint32_sub_type.get();
            messageForQQWalletTips.bytes_jumpurl = subMsgType0x85$MsgBody.bytes_jumpurl.get().toStringUtf8();
            currentAccountUin = qQAppInterface.getCurrentAccountUin();
            if (qQAppInterface.getCurrentAccountUin().equals(messageForQQWalletTips.senderUin)) {
                str2 = messageForQQWalletTips.reciverUin;
            } else {
                str2 = messageForQQWalletTips.senderUin;
            }
            i3 = 1;
        } catch (Exception e16) {
            e = e16;
            i3 = 1;
        }
        try {
            messageForQQWalletTips.init(currentAccountUin, str2, "", "[QQWallet Tips]", msgInfo.getUMsgTime(), MessageRecord.MSG_TYPE_QQWALLET_TIPS, 0, msgInfo.getShMsgSeq());
            messageForQQWalletTips.isread = true;
            messageForQQWalletTips.shmsgseq = msgInfo.shMsgSeq;
            messageForQQWalletTips.msgUid = msgInfo.lMsgUid;
            messageForQQWalletTips.getBytes();
            messageForQQWalletTips.onReceiveGrapTips();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "0x85 push type: " + messageForQQWalletTips.type + ", subtype: " + messageForQQWalletTips.subType);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("0x85 push jumpurl: ");
                sb5.append(messageForQQWalletTips.bytes_jumpurl);
                QLog.d("Q.msg.BaseMessageProcessor", 2, sb5.toString());
            }
        } catch (Exception e17) {
            e = e17;
            e.printStackTrace();
            i16 = messageForQQWalletTips.type;
            if (i16 == i3) {
            }
            if (i16 != i3) {
            }
        }
        i16 = messageForQQWalletTips.type;
        if (i16 == i3 || messageForQQWalletTips.subType != 0) {
            if (i16 != i3) {
                String currentAccountUin2 = qQAppInterface.getCurrentAccountUin();
                if (currentAccountUin2.equals(messageForQQWalletTips.senderUin)) {
                    str = messageForQQWalletTips.senderContent;
                } else if (currentAccountUin2.equals(messageForQQWalletTips.reciverUin)) {
                    str = messageForQQWalletTips.reciverContent;
                } else {
                    str = null;
                }
                String qqStr = HardCodeUtil.qqStr(R.string.oyd);
                String qqStr2 = HardCodeUtil.qqStr(R.string.oyc);
                String qQWalletTips = messageForQQWalletTips.getQQWalletTips(qQAppInterface, str);
                if (!TextUtils.isEmpty(qQWalletTips)) {
                    if (qQWalletTips.equals(qqStr) || qQWalletTips.equals(qqStr2)) {
                        messageForQQWalletTips.addQQWalletTips(qQAppInterface, qQWalletTips, messageForQQWalletTips.highLightStart, messageForQQWalletTips.highLightEnd, messageForQQWalletTips.textColor, messageForQQWalletTips.url);
                    } else {
                        return messageForQQWalletTips;
                    }
                } else {
                    return messageForQQWalletTips;
                }
            } else {
                return messageForQQWalletTips;
            }
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        return b((QQAppInterface) afVar.d(), msgInfo, msgType0x210);
    }
}
