package com.tencent.aio.runtime;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static SecureRandom f69807a;

    /* renamed from: b, reason: collision with root package name */
    public static Random f69808b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11171);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f69807a = new SecureRandom();
            f69808b = new Xoroshiro128PlusRandom(f69807a.nextLong());
        }
    }
}
