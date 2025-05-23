package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SubType0x87 implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private boolean off0x87Switch;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            TAG = "SubType0x87";
        }
    }

    public SubType0x87() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.off0x87Switch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105686", false);
        }
    }

    private static void decode0x210Sub0x87(QQAppInterface qQAppInterface, MessageHandler messageHandler, MsgType0x210 msgType0x210) {
        boolean z16;
        SubMsgType0x87$MsgBody subMsgType0x87$MsgBody = new SubMsgType0x87$MsgBody();
        try {
            subMsgType0x87$MsgBody.mergeFrom(msgType0x210.vProtobuf);
            if (subMsgType0x87$MsgBody.uint64_friend_msg_type_flag.has()) {
                if (subMsgType0x87$MsgBody.uint64_friend_msg_type_flag.get() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    messageHandler.m3().v0(2);
                }
            }
            if (subMsgType0x87$MsgBody.rpt_msg_msg_notify.has()) {
                com.tencent.mobileqq.activity.contact.newfriend.a.g(qQAppInterface, subMsgType0x87$MsgBody);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager", 2, "", th5);
            }
            throw new RuntimeException(th5);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        if (this.off0x87Switch) {
            QLog.d(TAG, 2, "SubType0x87 off");
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        decode0x210Sub0x87(qQAppInterface, qQAppInterface.getMsgHandler(), msgType0x210);
        return null;
    }
}
