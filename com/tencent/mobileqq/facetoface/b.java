package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f205745a;

    /* renamed from: b, reason: collision with root package name */
    public static long f205746b;

    /* renamed from: c, reason: collision with root package name */
    public static long f205747c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71830);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f205745a = 0L;
        f205746b = 0L;
        f205747c = 0L;
    }
}
