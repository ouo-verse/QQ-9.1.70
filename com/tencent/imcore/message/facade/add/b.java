package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class b extends a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(QQMessageFacade qQMessageFacade, List<MessageRecord> list, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQMessageFacade, list, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        MessageRecord b16 = b(list);
        if (b16 != null) {
            qQMessageFacade.L0();
            if (z16) {
                qQMessageFacade.notifyObservers(b16);
            }
        }
        if (z16) {
            qQMessageFacade.l0(list);
        }
    }
}
