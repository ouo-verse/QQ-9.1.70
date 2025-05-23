package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public e() {
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
        if (list != null && msg_comm_msg != null && msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.msg_content.has()) {
            byte[] byteArray = msg_comm_msg.msg_body.msg_content.get().toByteArray();
            PkgTools.getLongData(byteArray, 0);
            byte b16 = byteArray[4];
            if (b16 == 25) {
                if (!aVar.f286157l) {
                    DiscMessageProcessor.Z(messageHandler.Q, byteArray, 5, null, false);
                }
            } else if (b16 == 35) {
                QLog.i("DiscussionUpdateDecoder", 1, "[discuss.OffLine]");
                if (!aVar.f286157l) {
                    DiscMessageProcessor.b0(messageHandler.Q, byteArray, 5, null, false);
                }
            }
        }
    }
}
