package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class UnreadMsgFilterProvider implements Provider<List<Object>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<Object> f116647a;

    public UnreadMsgFilterProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116647a = new ArrayList<Object>() { // from class: com.tencent.imcore.message.facade.unread.filter.UnreadMsgFilterProvider.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UnreadMsgFilterProvider.this);
                        return;
                    }
                    add(new o());
                    add(new v());
                    add(new n());
                    add(new g());
                    add(new j());
                    add(new h());
                    add(new r());
                    add(new b());
                    add(new k());
                    add(new a());
                    add(new m());
                    add(new t());
                    add(new u());
                    add(new i());
                    add(new p());
                    add(new l());
                    add(new ToggleConfigFilter());
                    add(new s());
                    add(new d());
                    add(new f());
                    add(new e());
                    add(new q());
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Object> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116647a;
    }
}
