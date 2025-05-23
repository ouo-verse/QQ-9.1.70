package com.tencent.mobileqq.troop.utils.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f302051a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29663);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f302051a = "https://cgi.connect.qq.com/qqconnectwebsite/v3/appinfo/getauth";
        }
    }
}
