package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class OnMessageAddCompleteObserverProvider implements Provider<Map<Integer, com.tencent.imcore.message.facade.g<QQMessageFacade>>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, com.tencent.imcore.message.facade.g<QQMessageFacade>> f116630a;

    public OnMessageAddCompleteObserverProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116630a = new HashMap<Integer, com.tencent.imcore.message.facade.g<QQMessageFacade>>() { // from class: com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverProvider.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OnMessageAddCompleteObserverProvider.this);
                        return;
                    }
                    put(0, new b());
                    put(1, new e());
                    put(2, new f());
                    put(3, new c());
                    put(4, new d());
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<Integer, com.tencent.imcore.message.facade.g<QQMessageFacade>> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116630a;
    }
}
