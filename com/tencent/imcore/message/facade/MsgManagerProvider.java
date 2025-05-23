package com.tencent.imcore.message.facade;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.app.message.SubMessageManager;
import com.tencent.mobileqq.app.message.o;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.guild.message.api.IGuildMessageManagerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.x;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* loaded from: classes7.dex */
public class MsgManagerProvider implements Provider<Map<Integer, BaseMessageManager>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, BaseMessageManager> f116629a;

    public MsgManagerProvider(AppRuntime appRuntime, MsgPool msgPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgPool);
        } else {
            this.f116629a = new HashMap<Integer, BaseMessageManager>(appRuntime, msgPool) { // from class: com.tencent.imcore.message.facade.MsgManagerProvider.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AppRuntime val$app;
                final /* synthetic */ MsgPool val$msgPool;

                {
                    this.val$app = appRuntime;
                    this.val$msgPool = msgPool;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MsgManagerProvider.this, appRuntime, msgPool);
                        return;
                    }
                    put(1, new x(appRuntime, msgPool));
                    put(3000, new com.tencent.mobileqq.app.message.g(appRuntime, msgPool));
                    put(7000, new SubMessageManager(appRuntime, msgPool));
                    put(10007, new o(appRuntime, msgPool));
                    put(10014, ((IGuildMessageManagerApi) QRoute.api(IGuildMessageManagerApi.class)).newGuildMessageManager(appRuntime, msgPool));
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<Integer, BaseMessageManager> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116629a;
    }
}
