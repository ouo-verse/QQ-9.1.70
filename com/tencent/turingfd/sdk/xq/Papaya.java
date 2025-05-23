package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public final class Papaya {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f382982a = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int i3 = Plum.f383026a;
        byte[] bArr = new byte[3];
        for (int i16 = 0; i16 < 3; i16++) {
            int i17 = i16 * 2;
            bArr[i16] = Integer.valueOf("414553".substring(i17, i17 + 2), 16).byteValue();
        }
        new String(bArr);
    }
}
