package com.tencent.imcore.message;

import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d implements BaseMessageProcessor.b {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor.b
    public boolean a(AppRuntime appRuntime, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, messageRecord, Boolean.valueOf(z16))).booleanValue();
        }
        return MessageHandlerUtils.msgFilter((QQAppInterface) appRuntime, messageRecord, z16);
    }
}
