package com.tencent.imcore.message.facade.msg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class LastMsgGetterProvider implements Provider<Map<Integer, com.tencent.imcore.message.facade.c<QQMessageFacade, QQAppInterface>>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, com.tencent.imcore.message.facade.c<QQMessageFacade, QQAppInterface>> f116637a;

    public LastMsgGetterProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116637a = new HashMap<Integer, com.tencent.imcore.message.facade.c<QQMessageFacade, QQAppInterface>>() { // from class: com.tencent.imcore.message.facade.msg.LastMsgGetterProvider.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LastMsgGetterProvider.this);
                        return;
                    }
                    put(0, new a());
                    put(1, new b());
                    put(2, new c());
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<Integer, com.tencent.imcore.message.facade.c<QQMessageFacade, QQAppInterface>> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116637a;
    }
}
