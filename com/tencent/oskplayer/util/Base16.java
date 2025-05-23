package com.tencent.oskplayer.util;

import com.tencent.mobileqq.text.EmotcationConstants;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Base16 {
    public static final char[] ENC_TAB = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] DEC_TAB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static byte[] decode(String str) {
        byte[] bArr = new byte[str.length() / 2];
        decode(str, bArr, 0);
        return bArr;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static String encode(byte[] bArr, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            char[] cArr = ENC_TAB;
            sb5.append(cArr[(bArr[i3] & 240) >> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
            i3++;
        }
        return sb5.toString();
    }

    public static void decode(String str, byte[] bArr, int i3) {
        int length = (str.length() / 2) * 2;
        int i16 = 0;
        while (i16 < length) {
            byte[] bArr2 = DEC_TAB;
            int i17 = i16 + 1;
            bArr[i3] = (byte) ((bArr2[str.charAt(i16)] << 4) | bArr2[str.charAt(i17)]);
            i3++;
            i16 = i17 + 1;
        }
    }
}
