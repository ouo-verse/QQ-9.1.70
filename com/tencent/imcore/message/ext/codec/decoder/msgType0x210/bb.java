package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import tencent.im.c2c.msgtype0x210.submsgtype0x79.submsgtype0x79$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bb implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive zebarunread push message, seq = " + ((int) msgInfo.shMsgSeq) + "submsgtype:" + ((int) msgInfo.shMsgType));
        }
        try {
            submsgtype0x79$MsgBody submsgtype0x79_msgbody = new submsgtype0x79$MsgBody();
            submsgtype0x79_msgbody.mergeFrom(msgType0x210.vProtobuf);
            submsgtype0x79_msgbody.uint32_src_app_id.get();
            int i3 = submsgtype0x79_msgbody.uint32_undeal_count.get();
            if (QLog.isColorLevel()) {
                QLog.d("UndealCount.ZebraAlbum.Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive zebarunread count: " + i3);
            }
            int int4Uin = LocalMultiProcConfig.getInt4Uin("NavigatorItemShow7", -1, qQAppInterface.getLongAccountUin());
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "account: " + qQAppInterface.getLongAccountUin() + " QZoneGetFeedAlertRequest read NavigatorItemShow 7 from sharerefrence value: " + int4Uin);
            }
            if (int4Uin == 1) {
                QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
                ArrayList<QZoneCountUserInfo> arrayList = new ArrayList<>();
                QZoneCountUserInfo qZoneCountUserInfo = new QZoneCountUserInfo();
                qZoneCountUserInfo.uin = qQAppInterface.getLongAccountUin();
                arrayList.add(qZoneCountUserInfo);
                qZoneManagerImp.w(17, i3, arrayList, "", false, true, "");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgInfo, msgType0x210);
        return null;
    }
}
