package com.tencent.mobileqq.video;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f312467a;

    /* renamed from: b, reason: collision with root package name */
    public static int f312468b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77207);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f312467a = false;
            f312468b = 0;
        }
    }

    public static boolean a(Context context) {
        return false;
    }
}
