package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, byte[] bArr) {
        submsgtype0x116$MsgBody submsgtype0x116_msgbody = new submsgtype0x116$MsgBody();
        try {
            submsgtype0x116_msgbody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        long e17 = com.tencent.av.s.e(submsgtype0x116_msgbody.uint32_group_id.get());
        long e18 = com.tencent.av.s.e(submsgtype0x116_msgbody.uint32_room_id.get());
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x116 qqMainThread;roomId=" + e18 + ";groupId=" + e17);
        }
        if (qQAppInterface != null) {
            Intent intent = new Intent("tencent.video.q2v.GvideoMemInviteUpdate");
            intent.putExtra("uin", qQAppInterface.getCurrentUin());
            intent.putExtra("groupId", e17);
            intent.putExtra("roomId", e18);
            intent.putExtra("pushData", bArr);
            intent.setPackage(BaseApplication.getContext().getPackageName());
            qQAppInterface.getApp().sendBroadcast(intent);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgType0x210.vProtobuf);
        return null;
    }
}
