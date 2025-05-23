package com.tencent.mobileqq.danmaku;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f203066a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203066a = false;
        }
    }

    public static void a() {
        if (!f203066a) {
            com.tencent.common.danmaku.a.b().c(new QQDanmakuDependImp());
        }
        f203066a = true;
    }
}
