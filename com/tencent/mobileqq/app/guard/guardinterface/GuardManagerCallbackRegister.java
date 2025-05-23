package com.tencent.mobileqq.app.guard.guardinterface;

import com.tencent.mobileqq.app.guardcallback.SplashProcessor;
import com.tencent.mobileqq.app.guardcallback.a;
import com.tencent.mobileqq.app.guardcallback.b;
import com.tencent.mobileqq.app.guardcallback.c;
import com.tencent.mobileqq.app.guardcallback.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GuardManagerCallbackRegister {
    static IPatchRedirector $redirector_;

    @ConfigInject(configPath = "Foundation/QQActivity/src/main/resources/Inject_GuardManagerConfig.yml", version = 2)
    public static ArrayList<Class<? extends IGuardInterface>> injectClassList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends IGuardInterface>> arrayList = new ArrayList<>();
        injectClassList = arrayList;
        arrayList.add(c.class);
        injectClassList.add(SplashProcessor.class);
        injectClassList.add(d.class);
        injectClassList.add(a.class);
        injectClassList.add(com.tencent.mobileqq.tianjige.d.class);
        injectClassList.add(b.class);
    }

    public GuardManagerCallbackRegister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
