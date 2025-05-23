package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class g implements com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(QQMessageFacade qQMessageFacade, QQAppInterface qQAppInterface, List<MessageRecord> list, BaseMessageManager.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQMessageFacade, qQAppInterface, list, aVar, Boolean.valueOf(z16));
        }
    }
}
