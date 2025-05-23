package com.tencent.mobileqq.matchfriend.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f244062a;

    /* renamed from: b, reason: collision with root package name */
    public static String f244063b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24110);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f244062a = "Android_greet";
            f244063b = "Android_edit";
        }
    }
}
