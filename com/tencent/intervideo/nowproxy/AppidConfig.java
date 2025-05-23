package com.tencent.intervideo.nowproxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AppidConfig {
    static IPatchRedirector $redirector_;
    public static String APPID_KUAIBAO;
    public static String APPID_QB;
    public static String APPID_QB_FAST;
    public static String APPID_QQ;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9906);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        APPID_QQ = "2";
        APPID_QB = "1023";
        APPID_QB_FAST = "1031";
        APPID_KUAIBAO = "1028";
    }

    public AppidConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isBrowserPlugin(String str) {
        if (!APPID_QB.equals(str) && !APPID_QB_FAST.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean isKuaiBaoPlugin(String str) {
        return APPID_KUAIBAO.equals(str);
    }

    public static boolean isQQPlugin(String str) {
        return APPID_QQ.equals(str);
    }
}
