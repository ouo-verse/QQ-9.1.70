package com.xiaomi.push;

import com.tencent.mobileqq.text.EmotcationConstants;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private static final String f388125a = System.getProperty("line.separator");

    /* renamed from: b, reason: collision with root package name */
    private static char[] f388126b = new char[64];

    /* renamed from: c, reason: collision with root package name */
    private static byte[] f388127c;

    static {
        char c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
        int i3 = 0;
        while (c16 <= 'Z') {
            f388126b[i3] = c16;
            c16 = (char) (c16 + 1);
            i3++;
        }
        char c17 = 'a';
        while (c17 <= 'z') {
            f388126b[i3] = c17;
            c17 = (char) (c17 + 1);
            i3++;
        }
        char c18 = '0';
        while (c18 <= '9') {
            f388126b[i3] = c18;
            c18 = (char) (c18 + 1);
            i3++;
        }
        char[] cArr = f388126b;
        cArr[i3] = '+';
        cArr[i3 + 1] = '/';
        f388127c = new byte[128];
        int i16 = 0;
        while (true) {
            byte[] bArr = f388127c;
            if (i16 >= bArr.length) {
                break;
            }
            bArr[i16] = -1;
            i16++;
        }
        for (int i17 = 0; i17 < 64; i17++) {
            f388127c[f388126b[i17]] = (byte) i17;
        }
    }

    public static String a(String str) {
        return new String(e(str.getBytes()));
    }

    public static byte[] b(String str) {
        return c(str.toCharArray());
    }

    public static byte[] c(char[] cArr) {
        return d(cArr, 0, cArr.length);
    }

    public static byte[] d(char[] cArr, int i3, int i16) {
        int i17;
        char c16;
        char c17;
        int i18;
        if (i16 % 4 == 0) {
            while (i16 > 0 && cArr[(i3 + i16) - 1] == '=') {
                i16--;
            }
            int i19 = (i16 * 3) / 4;
            byte[] bArr = new byte[i19];
            int i26 = i16 + i3;
            int i27 = 0;
            while (i3 < i26) {
                int i28 = i3 + 1;
                char c18 = cArr[i3];
                int i29 = i28 + 1;
                char c19 = cArr[i28];
                if (i29 < i26) {
                    i17 = i29 + 1;
                    c16 = cArr[i29];
                } else {
                    i17 = i29;
                    c16 = 'A';
                }
                if (i17 < i26) {
                    i18 = i17 + 1;
                    c17 = cArr[i17];
                } else {
                    int i36 = i17;
                    c17 = 'A';
                    i18 = i36;
                }
                if (c18 <= '\u007f' && c19 <= '\u007f' && c16 <= '\u007f' && c17 <= '\u007f') {
                    byte[] bArr2 = f388127c;
                    byte b16 = bArr2[c18];
                    byte b17 = bArr2[c19];
                    byte b18 = bArr2[c16];
                    byte b19 = bArr2[c17];
                    if (b16 >= 0 && b17 >= 0 && b18 >= 0 && b19 >= 0) {
                        int i37 = (b16 << 2) | (b17 >>> 4);
                        int i38 = ((b17 & RegisterType.DOUBLE_HI) << 4) | (b18 >>> 2);
                        int i39 = ((b18 & 3) << 6) | b19;
                        int i46 = i27 + 1;
                        bArr[i27] = (byte) i37;
                        if (i46 < i19) {
                            bArr[i46] = (byte) i38;
                            i46++;
                        }
                        if (i46 < i19) {
                            bArr[i46] = (byte) i39;
                            i27 = i46 + 1;
                        } else {
                            i27 = i46;
                        }
                        i3 = i18;
                    } else {
                        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                    }
                } else {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static char[] f(byte[] bArr, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        char c16;
        int i26 = ((i16 * 4) + 2) / 3;
        char[] cArr = new char[((i16 + 2) / 3) * 4];
        int i27 = i16 + i3;
        int i28 = 0;
        while (i3 < i27) {
            int i29 = i3 + 1;
            int i36 = bArr[i3] & 255;
            if (i29 < i27) {
                i17 = i29 + 1;
                i18 = bArr[i29] & 255;
            } else {
                i17 = i29;
                i18 = 0;
            }
            if (i17 < i27) {
                i19 = bArr[i17] & 255;
                i17++;
            } else {
                i19 = 0;
            }
            int i37 = i36 >>> 2;
            int i38 = ((i36 & 3) << 4) | (i18 >>> 4);
            int i39 = ((i18 & 15) << 2) | (i19 >>> 6);
            int i46 = i19 & 63;
            int i47 = i28 + 1;
            char[] cArr2 = f388126b;
            cArr[i28] = cArr2[i37];
            int i48 = i47 + 1;
            cArr[i47] = cArr2[i38];
            char c17 = '=';
            if (i48 < i26) {
                c16 = cArr2[i39];
            } else {
                c16 = '=';
            }
            cArr[i48] = c16;
            int i49 = i48 + 1;
            if (i49 < i26) {
                c17 = cArr2[i46];
            }
            cArr[i49] = c17;
            i28 = i49 + 1;
            i3 = i17;
        }
        return cArr;
    }

    public static String g(String str) {
        return new String(b(str));
    }
}
