package com.tencent.imcore.message.facade.notify;

import com.tencent.imcore.message.facade.d;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements d<QQAppInterface> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(QQAppInterface qQAppInterface, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) list);
        } else if (list != null && list.size() > 0) {
            qQAppInterface.getMsgHandler().notifyUI(MessageHandlerConstants.NOTIFY_TYPE_NEW_MESSAGE_ADDED, true, list);
        }
    }
}
