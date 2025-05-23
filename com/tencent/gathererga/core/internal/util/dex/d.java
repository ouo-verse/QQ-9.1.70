package com.tencent.gathererga.core.internal.util.dex;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static int a(long j3) {
        if (j3 >= 0 && j3 <= TTL.MAX_VALUE) {
            return (int) j3;
        }
        throw new ArithmeticException("unsigned integer overflow");
    }
}
