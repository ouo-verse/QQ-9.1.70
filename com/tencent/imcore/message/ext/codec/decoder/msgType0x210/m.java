package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.du;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class m implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210) {
        int i3;
        try {
            submsgtype0x126$MsgBody submsgtype0x126_msgbody = new submsgtype0x126$MsgBody();
            if (afVar.L(msgType0x210)) {
                submsgtype0x126_msgbody.mergeFrom(msgType0x210.vProtobuf);
                if (submsgtype0x126_msgbody.uint32_msg_type.has()) {
                    i3 = submsgtype0x126_msgbody.uint32_msg_type.get();
                } else {
                    i3 = 0;
                }
                QLog.i("Q.msg.BaseMessageProcessor", 2, "onlinepush receive 0x210_0x126, push for webview " + i3);
                String str = "";
                QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
                if (i3 == 4) {
                    qQAppInterface.getAVNotifyCenter().u0(submsgtype0x126_msgbody);
                } else if (i3 == 2) {
                    qQAppInterface.getAVNotifyCenter().u0(submsgtype0x126_msgbody);
                } else {
                    if (i3 != 5 && i3 != 6) {
                        if (submsgtype0x126_msgbody.str_msg_info.has()) {
                            try {
                                str = submsgtype0x126_msgbody.str_msg_info.get().toStringUtf8();
                            } catch (Throwable th5) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("Q.msg.BaseMessageProcessor", 2, "onlinepush receive 0x210_0x126 parse str_msg_info fail.", th5);
                                }
                            }
                        }
                        Bundle bundle = new Bundle();
                        bundle.putInt(QQBrowserActivity.KEY_MSG_TYPE, i3);
                        bundle.putString("info", str);
                        qQAppInterface.notifyObservers(du.class, 11, true, bundle);
                    }
                    qQAppInterface.getAVNotifyCenter().u0(submsgtype0x126_msgbody);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "webpush type:", Integer.valueOf(i3), " info:", str);
                }
            }
        } catch (Exception e16) {
            QLog.e("Q.msg.BaseMessageProcessor", 1, "webview push errInfo->" + e16.getMessage());
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(afVar, msgType0x210);
        return null;
    }
}
