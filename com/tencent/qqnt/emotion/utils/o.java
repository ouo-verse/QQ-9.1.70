package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class o {
    static IPatchRedirector $redirector_;

    public static int a(byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 = (i16 << 8) | (bArr[i17] & 255);
        }
        return i16;
    }

    public static int[] b(char[] cArr) {
        return new int[]{a(new byte[]{(byte) cArr[0], (byte) cArr[1]}, 2), cArr[2]};
    }
}
