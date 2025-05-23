package com.tencent.tmsqmsp.oaid2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static int f380770a = -12;

    /* renamed from: b, reason: collision with root package name */
    public static int f380771b = -13;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }
}
