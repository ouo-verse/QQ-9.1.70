package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FrameInjectUtil {
    static IPatchRedirector $redirector_;

    @ConfigInject(configPath = "Foundation/QQActivity/src/main/resources/Inject_FrameFragmentTabConfig.yml", version = 1)
    public static ArrayList<Class<? extends IFrameInjectInterface>> sFrameInjectInterfaceClzList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends IFrameInjectInterface>> arrayList = new ArrayList<>();
        sFrameInjectInterfaceClzList = arrayList;
        arrayList.add(ap.class);
    }

    public FrameInjectUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
