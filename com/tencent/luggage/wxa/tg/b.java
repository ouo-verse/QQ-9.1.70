package com.tencent.luggage.wxa.tg;

import com.tencent.mobileqq.text.EmotcationConstants;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f141287a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f141288b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            char[] cArr = f141287a;
            sb5.append(cArr[(bArr[i3] & 240) >> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
            i3++;
        }
        return sb5.toString();
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[str.length() / 2];
        a(str, bArr, 0);
        return bArr;
    }

    public static void a(String str, byte[] bArr, int i3) {
        int length = (str.length() / 2) * 2;
        int i16 = 0;
        while (i16 < length) {
            byte[] bArr2 = f141288b;
            int i17 = i16 + 1;
            bArr[i3] = (byte) ((bArr2[str.charAt(i16)] << 4) | bArr2[str.charAt(i17)]);
            i3++;
            i16 = i17 + 1;
        }
    }
}
