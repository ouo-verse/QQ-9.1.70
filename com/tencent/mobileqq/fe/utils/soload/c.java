package com.tencent.mobileqq.fe.utils.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static int a(byte[] bArr, int i3, ByteOrder byteOrder) {
        int i16;
        int i17;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i18 = i3 + 1;
            int i19 = i18 + 1;
            int i26 = ((bArr[i3] & 255) << 24) | ((bArr[i18] & 255) << 16);
            i16 = i26 | ((bArr[i19] & 255) << 8);
            i17 = (bArr[i19 + 1] & 255) << 0;
        } else {
            int i27 = i3 + 1;
            int i28 = i27 + 1;
            int i29 = ((bArr[i3] & 255) << 0) | ((bArr[i27] & 255) << 8);
            i16 = i29 | ((bArr[i28] & 255) << 16);
            i17 = (bArr[i28 + 1] & 255) << 24;
        }
        return i17 | i16;
    }

    public static short b(byte[] bArr, int i3, ByteOrder byteOrder) {
        int i16;
        byte b16;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i16 = bArr[i3] << 8;
            b16 = bArr[i3 + 1];
        } else {
            i16 = bArr[i3 + 1] << 8;
            b16 = bArr[i3];
        }
        return (short) ((b16 & 255) | i16);
    }
}
