package com.tencent.relation.common.handler;

import com.tencent.mobileqq.app.automator.step.o;
import com.tencent.mobileqq.profilecard.handler.ProfileHandlerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends com.tencent.relation.common.handler.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_0x5ebForColdStartProcessor.yml", version = 1)
    private static ArrayList<Class<? extends c>> f364722b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static b f364723a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27441);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f364723a = new b();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27444);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f364722b = arrayList;
        arrayList.add(ProfileHandlerProcessor.class);
        f364722b.add(com.tencent.mobileqq.studymode.a.class);
        f364722b.add(o.class);
        f364722b.add(com.tencent.qqnt.aio.assistedchat.setting.a.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b c() {
        return a.f364723a;
    }

    @Override // com.tencent.relation.common.handler.a
    public List<Class<? extends c>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return f364722b;
    }
}
