package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SubType0x76 implements a<com.tencent.imcore.message.af>, oz3.a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.msg.SubType0x76";

    public SubType0x76() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void decode0x210Sub0x76(com.tencent.imcore.message.af afVar, MsgInfo msgInfo, long j3, MsgType0x210 msgType0x210) {
        long j16 = msgInfo.lFromUin;
        short s16 = msgInfo.shMsgSeq;
        long j17 = msgInfo.lMsgUid;
        short s17 = msgInfo.shMsgType;
        int i3 = (int) msgType0x210.uSubMsgType;
        if (((ActivateFriendsManager) afVar.d().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).A(msgInfo.shMsgSeq)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "receive same message, seq = " + ((int) msgInfo.shMsgSeq));
            }
        } else if (com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.c.g((QQAppInterface) afVar.d(), msgType0x210.vProtobuf, j16, j3, s16, s17, i3)) {
            afVar.n("handleActivateFriendsPush", true, 1, true, false);
        }
        com.tencent.mobileqq.service.message.p.I(j16, s16, j17, s17, afVar.d());
    }

    public void processMsg(int i3, long j3, long j16, boolean z16, @NotNull nt_msg_common$Msg nt_msg_common_msg, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), nt_msg_common_msg, appRuntime);
        } else {
            decode0x210Sub0x76((QQAppInterface) appRuntime, j3, j16, nt_msg_common_msg);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        decode0x210Sub0x76(afVar, msgInfo, j3, msgType0x210);
        return null;
    }

    private static void decode0x210Sub0x76(QQAppInterface qQAppInterface, long j3, long j16, @NonNull nt_msg_common$Msg nt_msg_common_msg) {
        byte[] byteArray = nt_msg_common_msg.body.msg_content.get().toByteArray();
        long parseLong = Long.parseLong(qQAppInterface.getAccount());
        long j17 = nt_msg_common_msg.content_head.msg_uid.get();
        int i3 = (int) nt_msg_common_msg.content_head.msg_seq.get();
        long j18 = nt_msg_common_msg.content_head.msg_uid.get();
        if (((ActivateFriendsManager) qQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).A(i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "receive same message, seq = " + i3);
            }
        } else if (com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.c.g(qQAppInterface, byteArray, j17, parseLong, i3, (int) j3, (int) j16)) {
            qQAppInterface.getMsgHandler().getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE).n("handleActivateFriendsPush", true, 1, true, false);
        }
        com.tencent.mobileqq.service.message.p.I(j17, i3, j18, (int) j3, qQAppInterface);
    }
}
