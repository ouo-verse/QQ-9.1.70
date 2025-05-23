package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f297996a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f297997b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f297998c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f297999d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28745);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int i3 = 0 + 1;
        f297997b = 0;
        int i16 = i3 + 1;
        f297998c = i3;
        f297996a = i16 + 1;
        f297999d = i16;
    }
}
