package com.tencent.mobileqq.olympic.activity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f255224a;

    /* renamed from: b, reason: collision with root package name */
    public static int f255225b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f255224a = false;
            f255225b = 1;
        }
    }
}
