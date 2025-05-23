package com.tencent.imcore.message.facade.send.sender;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class MsgSenderProvider implements Provider<List<com.tencent.imcore.message.facade.f<QQAppInterface>>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<com.tencent.imcore.message.facade.f<QQAppInterface>> f116640a;

    public MsgSenderProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116640a = new ArrayList<com.tencent.imcore.message.facade.f<QQAppInterface>>() { // from class: com.tencent.imcore.message.facade.send.sender.MsgSenderProvider.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgSenderProvider.this);
                        return;
                    }
                    add(new b());
                    add(new g());
                    add(new f());
                    add(new c());
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<com.tencent.imcore.message.facade.f<QQAppInterface>> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116640a;
    }
}
