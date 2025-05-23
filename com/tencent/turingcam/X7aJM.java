package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class X7aJM {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, spXPg> f382091a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        HashMap hashMap = new HashMap();
        f382091a = hashMap;
        hashMap.put("4", new fa2Ik());
        hashMap.put("3", new wFc5K());
        hashMap.put("5", new BijG2());
    }

    public static spXPg a(String str) {
        return (spXPg) ((HashMap) f382091a).get(str);
    }
}
