package com.huawei.hms.utils;

import com.tencent.mobileqq.text.EmotcationConstants;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HEX {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f37669a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f37670b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    HEX() {
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i3 = 0;
        for (byte b16 : bArr) {
            int i16 = i3 + 1;
            cArr2[i3] = cArr[(b16 & 240) >>> 4];
            i3 = i16 + 1;
            cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
        }
        return cArr2;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z16) {
        return new String(encodeHex(bArr, z16));
    }

    public static char[] encodeHex(byte[] bArr, boolean z16) {
        return a(bArr, z16 ? f37670b : f37669a);
    }
}
