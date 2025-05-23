package com.tencent.imcore.message.facade.send.sender;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
class c implements com.tencent.imcore.message.facade.f<QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.f
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord.msgtype == -2071) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.facade.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(QQAppInterface qQAppInterface, MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, messageRecord, businessObserver, Boolean.valueOf(z16));
            return;
        }
        if (messageRecord.istroop == 1) {
            com.tencent.biz.anonymous.a.h().a(messageRecord);
        }
        qQAppInterface.getMsgHandler().j5(messageRecord, businessObserver, z16);
    }
}
