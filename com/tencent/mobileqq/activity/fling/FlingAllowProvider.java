package com.tencent.mobileqq.activity.fling;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class FlingAllowProvider {
    static IPatchRedirector $redirector_;
    private static List<String> sWhiteList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sWhiteList = new ArrayList();
        }
    }

    public FlingAllowProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean contain(String str) {
        return sWhiteList.contains(str);
    }
}
