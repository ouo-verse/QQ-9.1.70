package com.tencent.mobileqq.startup.step;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f289751a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f289751a = new String[]{"qwallet_plugin.apk"};
        }
    }

    public static boolean a(String str) {
        for (String str2 : f289751a) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }
}
