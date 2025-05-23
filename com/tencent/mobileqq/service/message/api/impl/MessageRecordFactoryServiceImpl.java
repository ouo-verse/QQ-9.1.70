package com.tencent.mobileqq.service.message.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.service.message.q;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MessageRecordFactoryServiceImpl implements IMessageRecordFactoryService {
    static IPatchRedirector $redirector_;

    public MessageRecordFactoryServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService
    public MessageRecord createMsgRecordByMsgType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return q.d(i3);
    }
}
