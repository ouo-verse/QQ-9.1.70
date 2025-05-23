package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import msf.msgcomm.nt_msg_common$Msg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SubType0xc7 implements a<com.tencent.imcore.message.af>, oz3.a {
    static IPatchRedirector $redirector_;

    public SubType0xc7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void decode0x210Sub0xc7(com.tencent.imcore.message.af afVar, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.e("HotFriend_PushMessage", 2, "onLinePush receive 0x210_0xc7");
        }
        long j3 = msgInfo.lFromUin;
        short s16 = msgInfo.shMsgSeq;
        long j16 = msgInfo.lMsgUid;
        short s17 = msgInfo.shMsgType;
        afVar.Y(msgType0x210.vProtobuf, new PushMsg0x210C7Info(j3, s16, j16, s17, msgInfo.uRealMsgTime, true), "SubType0xc7_TOP");
        com.tencent.mobileqq.service.message.p.I(j3, s16, j16, s17, afVar.d());
    }

    public void processMsg(int i3, long j3, long j16, boolean z16, @NonNull nt_msg_common$Msg nt_msg_common_msg, @NonNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), nt_msg_common_msg, appRuntime);
        } else {
            QLog.i("HotFriend_PushMessage", 1, "onLinePush receive 0x210_0xc7 from NT");
            decode0x210Sub0xc7((QQAppInterface) appRuntime, j3, j16, nt_msg_common_msg);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        QLog.i("HotFriend_PushMessage", 1, "onLinePush receive 0x210_0xc7 from Normal");
        decode0x210Sub0xc7(afVar, msgInfo, msgType0x210);
        return null;
    }

    private static void decode0x210Sub0xc7(QQAppInterface qQAppInterface, long j3, long j16, @NonNull nt_msg_common$Msg nt_msg_common_msg) {
        byte[] byteArray = nt_msg_common_msg.body.msg_content.get().toByteArray();
        long j17 = nt_msg_common_msg.content_head.msg_uid.get();
        int i3 = (int) nt_msg_common_msg.content_head.msg_seq.get();
        long j18 = nt_msg_common_msg.content_head.msg_uid.get();
        int i16 = (int) j3;
        ((com.tencent.imcore.message.af) qQAppInterface.getMsgHandler().getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE)).Y(byteArray, new PushMsg0x210C7Info(j17, i3, j18, i16, (int) nt_msg_common_msg.content_head.msg_time.get(), true), "SubType0xc7_NT");
        com.tencent.mobileqq.service.message.p.I(j17, i3, j18, i16, qQAppInterface);
    }
}
