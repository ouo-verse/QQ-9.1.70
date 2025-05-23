package com.tencent.imcore.message.facade.send;

import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.facade.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
class b implements e<QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) messageRecord);
        } else if (AppSetting.B()) {
            qQAppInterface.getParcelHooker().recordMrAsJson(messageRecord);
        }
    }
}
