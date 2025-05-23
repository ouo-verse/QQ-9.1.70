package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class AddMultiMessagesInnerFinishProcessorProvider implements Provider<List<com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface>>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface>> f116632a;

    public AddMultiMessagesInnerFinishProcessorProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116632a = new ArrayList<com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface>>() { // from class: com.tencent.imcore.message.facade.add.inner.end.AddMultiMessagesInnerFinishProcessorProvider.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddMultiMessagesInnerFinishProcessorProvider.this);
                        return;
                    }
                    add(new b());
                    add(new e());
                    add(new i());
                    add(new g());
                    add(new d());
                    add(new a());
                    add(new h());
                    add(new f());
                    add(new c());
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface>> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116632a;
    }
}
