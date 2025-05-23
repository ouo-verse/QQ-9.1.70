package com.tencent.qqnt.emotion.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f356199a;

    /* renamed from: b, reason: collision with root package name */
    public static int f356200b;

    /* renamed from: c, reason: collision with root package name */
    public static int f356201c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f356202d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f356199a = 1;
        f356200b = 1 + 1;
        f356201c = 60000;
        f356202d = false;
    }
}
