package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class d extends a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(QQMessageFacade qQMessageFacade, List<MessageRecord> list, boolean z16, boolean z17, boolean z18) {
        MessageRecord b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQMessageFacade, list, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        if ((z17 || z18) && (b16 = b(list)) != null) {
            qQMessageFacade.L0();
            qQMessageFacade.notifyObservers(b16);
        }
        qQMessageFacade.l0(list);
    }
}
