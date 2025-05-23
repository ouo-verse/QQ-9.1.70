package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements com.tencent.mobileqq.service.message.codec.decoder.d<MessageHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.imcore.message.basic.c<Integer, com.tencent.mobileqq.service.message.codec.decoder.d> f286181a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286181a = new com.tencent.imcore.message.basic.d();
            c();
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        com.tencent.mobileqq.service.message.codec.decoder.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, messageHandler, msg_comm_msg, list, aVar);
        } else if (msg_comm_msg.msg_head.get().c2c_cmd.has() && (dVar = this.f286181a.get(Integer.valueOf(msg_comm_msg.msg_head.c2c_cmd.get()))) != null) {
            dVar.a(messageHandler, msg_comm_msg, list, aVar);
        }
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f286181a.a(169, c.class);
        this.f286181a.a(241, c.class);
        this.f286181a.a(242, c.class);
        this.f286181a.a(243, c.class);
        this.f286181a.a(175, b.class);
        this.f286181a.a(11, b.class);
        this.f286181a.a(129, d.class);
        this.f286181a.a(131, d.class);
        this.f286181a.a(133, d.class);
    }
}
