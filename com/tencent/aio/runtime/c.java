package com.tencent.aio.runtime;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class c {
    static IPatchRedirector $redirector_;

    public static long a(long j3) {
        long j16 = (j3 ^ (j3 >>> 33)) * (-49064778989728563L);
        long j17 = (j16 ^ (j16 >>> 33)) * (-4265267296055464877L);
        return j17 ^ (j17 >>> 33);
    }
}
