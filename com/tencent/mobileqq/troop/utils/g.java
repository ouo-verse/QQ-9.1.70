package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static long a(byte[] bArr) {
        long j3 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            j3 += (bArr[i3] & 255) << ((3 - i3) * 8);
        }
        return j3;
    }
}
