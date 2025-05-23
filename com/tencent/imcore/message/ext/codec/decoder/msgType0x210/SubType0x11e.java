package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SubType0x11e implements a<com.tencent.imcore.message.af>, oz3.a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.msg.SubType0x11e";

    public SubType0x11e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void decode0x210Sub0x11e(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        decode0x210Sub0x11e(qQAppInterface, msgType0x210.vProtobuf);
    }

    public void processMsg(int i3, long j3, long j16, boolean z16, @NotNull nt_msg_common$Msg nt_msg_common_msg, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), nt_msg_common_msg, appRuntime);
            return;
        }
        byte[] byteArray = nt_msg_common_msg.body.msg_content.get().toByteArray();
        QLog.d(TAG, 1, "Use NT push channel, decode NT data!");
        decode0x210Sub0x11e((QQAppInterface) appRuntime, byteArray);
    }

    private static void decode0x210Sub0x11e(QQAppInterface qQAppInterface, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11e");
        }
        FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler != null) {
            friendListHandler.decodePush0x210_0x11e(bArr);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        decode0x210Sub0x11e((QQAppInterface) afVar.d(), msgType0x210);
        return null;
    }
}
