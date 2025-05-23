package com.tencent.mobileqq.friend.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(byte[] bArr, int i3, int i16) {
        bArr[i3 + 3] = (byte) (i16 >> 0);
        bArr[i3 + 2] = (byte) (i16 >> 8);
        bArr[i3 + 1] = (byte) (i16 >> 16);
        bArr[i3 + 0] = (byte) (i16 >> 24);
    }

    public static void b(byte[] bArr, int i3, long j3) {
        bArr[i3 + 7] = (byte) (j3 >> 0);
        bArr[i3 + 6] = (byte) (j3 >> 8);
        bArr[i3 + 5] = (byte) (j3 >> 16);
        bArr[i3 + 4] = (byte) (j3 >> 24);
        bArr[i3 + 3] = (byte) (j3 >> 32);
        bArr[i3 + 2] = (byte) (j3 >> 40);
        bArr[i3 + 1] = (byte) (j3 >> 48);
        bArr[i3 + 0] = (byte) (j3 >> 56);
    }
}
