package com.tencent.imcore.message.facade.send;

import com.tencent.imcore.message.facade.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class MessageRealSendProcessorProvider implements Provider<List<e<QQAppInterface>>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<e<QQAppInterface>> f116639a;

    public MessageRealSendProcessorProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116639a = new ArrayList<e<QQAppInterface>>() { // from class: com.tencent.imcore.message.facade.send.MessageRealSendProcessorProvider.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageRealSendProcessorProvider.this);
                    } else {
                        add(new b());
                        add(new a());
                    }
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<e<QQAppInterface>> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116639a;
    }
}
