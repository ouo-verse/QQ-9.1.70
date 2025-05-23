package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ba implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ba() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Finally extract failed */
    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        submsgtype0x78$MsgBody submsgtype0x78_msgbody = new submsgtype0x78$MsgBody();
        try {
            submsgtype0x78_msgbody.mergeFrom(msgType0x210.vProtobuf);
            int i3 = submsgtype0x78_msgbody.uint32_type.get();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "MSG_TYPE_RED_PACKET type:" + i3 + ", serverVersion:" + submsgtype0x78_msgbody.uint32_version.get());
            }
            if (i3 == 1013) {
                try {
                    ((com.tencent.mobileqq.springhb.config.g) qQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).g(qQAppInterface, submsgtype0x78_msgbody.uint32_version.get());
                    return;
                } catch (Throwable th5) {
                    QLog.d("Q.msg.BaseMessageProcessor", 1, th5.getMessage(), th5);
                    return;
                }
            }
            if (i3 == 49) {
                ConfigServlet.p(qQAppInterface, qQAppInterface.getCurrentAccountUin(), submsgtype0x78_msgbody.uint32_version.get());
                return;
            }
            if (i3 == 222) {
                int i16 = qQAppInterface.getPreferences().getInt("public_account_ad_preload_task", 0);
                if (i16 != submsgtype0x78_msgbody.uint32_version.get()) {
                    ConfigServlet.n(qQAppInterface, 222, qQAppInterface.getCurrentAccountUin());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePublicAccountAdPreloadTaskPush localVersion:" + i16 + ", serverVersion:" + submsgtype0x78_msgbody.uint32_version.get());
                    return;
                }
                return;
            }
            if (i3 == 283 && qQAppInterface != null) {
                try {
                    QLog.d("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG excute");
                    ConfigServlet.n(qQAppInterface, 283, qQAppInterface.getCurrentAccountUin());
                } catch (Throwable th6) {
                    QLog.e("Q.msg.BaseMessageProcessor", 1, "SAFE_MODE_COMMAND_CONFIG  Push throw an exception:", th6);
                }
            }
        } catch (Throwable th7) {
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "", th7);
            }
            throw new RuntimeException(th7);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgType0x210);
        return null;
    }
}
