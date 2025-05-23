package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.av.q;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        if (!aVar.f286157l && q.f74190a) {
            long j3 = msg_comm_msg.msg_head.get().msg_time.get();
            msg_comm_msg.msg_body.get().msg_content.get().toByteArray();
            if (QLog.isColorLevel()) {
                QLog.d("AVMsg", 2, "decodeC2CMsgPkg_MultiVideo, msg[" + j3 + "]");
            }
        }
    }
}
