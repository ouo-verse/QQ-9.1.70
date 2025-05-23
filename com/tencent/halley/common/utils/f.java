package com.tencent.halley.common.utils;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f113547a;

    /* renamed from: b, reason: collision with root package name */
    public static String f113548b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f113549c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113547a = null;
        f113548b = null;
        f113549c = false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a() {
        return false;
    }
}
