package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x96.submsgtype0x96$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bi implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor receive 0x96 push message ");
        }
        submsgtype0x96$MsgBody submsgtype0x96_msgbody = new submsgtype0x96$MsgBody();
        try {
            submsgtype0x96_msgbody.mergeFrom(msgType0x210.vProtobuf);
            Intent intent = new Intent("tencent.qqcomic.push.msg");
            if (submsgtype0x96_msgbody.uint32_push_type.has()) {
                int i3 = submsgtype0x96_msgbody.uint32_push_type.get();
                if (i3 != 0) {
                    if (i3 != 1) {
                        intent.setAction("tencent.qqcomic.show.dialog");
                    } else {
                        intent.setAction("tencent.qqcomic.show.egg");
                    }
                } else {
                    intent.setAction("tencent.qqcomic.show.dialog");
                }
            } else {
                intent.setAction("tencent.qqcomic.show.dialog");
            }
            intent.putExtra("msg", submsgtype0x96_msgbody.string_push_msg.get());
            qQAppInterface.getApp().sendBroadcast(intent);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 4, "OnLinePushMessageProcessor mergeFrom 0x96 exception ");
            }
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
