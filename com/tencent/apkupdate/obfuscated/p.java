package com.tencent.apkupdate.obfuscated;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            new HashMap();
            new HashMap();
        }
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            str2 = "............";
        }
        Log.i(str, str2);
    }
}
