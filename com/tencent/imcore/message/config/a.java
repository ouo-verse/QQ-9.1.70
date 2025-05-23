package com.tencent.imcore.message.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f116582a;

    /* renamed from: b, reason: collision with root package name */
    protected static int f116583b;

    /* renamed from: c, reason: collision with root package name */
    protected static int f116584c;

    /* renamed from: d, reason: collision with root package name */
    protected static boolean f116585d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37488);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f116582a = false;
        f116583b = 2;
        f116584c = 40;
        f116585d = false;
    }

    public static int a() {
        return f116583b;
    }

    public static boolean b() {
        return f116582a;
    }
}
