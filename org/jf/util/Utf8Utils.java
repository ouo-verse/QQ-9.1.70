package org.jf.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Utf8Utils {
    private static final ThreadLocal<char[]> localBuffer = new ThreadLocal<char[]>() { // from class: org.jf.util.Utf8Utils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[256];
        }
    };

    public static byte[] stringToUtf8Bytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[length * 3];
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (charAt != 0 && charAt < '\u0080') {
                bArr[i3] = (byte) charAt;
                i3++;
            } else if (charAt < '\u0800') {
                bArr[i3] = (byte) (((charAt >> 6) & 31) | 192);
                bArr[i3 + 1] = (byte) ((charAt & '?') | 128);
                i3 += 2;
            } else {
                bArr[i3] = (byte) (((charAt >> '\f') & 15) | 224);
                bArr[i3 + 1] = (byte) (((charAt >> 6) & 63) | 128);
                bArr[i3 + 2] = (byte) ((charAt & '?') | 128);
                i3 += 3;
            }
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    private static String throwBadUtf8(int i3, int i16) {
        throw new IllegalArgumentException("bad utf-8 byte " + Hex.u1(i3) + " at offset " + Hex.u4(i16));
    }

    public static String utf8BytesToString(byte[] bArr, int i3, int i16) {
        char c16;
        ThreadLocal<char[]> threadLocal = localBuffer;
        char[] cArr = threadLocal.get();
        if (cArr == null || cArr.length < i16) {
            cArr = new char[i16];
            threadLocal.set(cArr);
        }
        int i17 = 0;
        while (i16 > 0) {
            int i18 = bArr[i3] & 255;
            switch (i18 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    i16--;
                    if (i18 == 0) {
                        return throwBadUtf8(i18, i3);
                    }
                    c16 = (char) i18;
                    i3++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return throwBadUtf8(i18, i3);
                case 12:
                case 13:
                    i16 -= 2;
                    if (i16 < 0) {
                        return throwBadUtf8(i18, i3);
                    }
                    int i19 = i3 + 1;
                    int i26 = bArr[i19] & 255;
                    if ((i26 & 192) != 128) {
                        return throwBadUtf8(i26, i19);
                    }
                    int i27 = ((i18 & 31) << 6) | (i26 & 63);
                    if (i27 != 0 && i27 < 128) {
                        return throwBadUtf8(i26, i19);
                    }
                    c16 = (char) i27;
                    i3 += 2;
                    break;
                case 14:
                    i16 -= 3;
                    if (i16 < 0) {
                        return throwBadUtf8(i18, i3);
                    }
                    int i28 = i3 + 1;
                    int i29 = bArr[i28] & 255;
                    if ((i29 & 192) != 128) {
                        return throwBadUtf8(i29, i28);
                    }
                    int i36 = i3 + 2;
                    int i37 = bArr[i36] & 255;
                    if ((i37 & 192) != 128) {
                        return throwBadUtf8(i37, i36);
                    }
                    int i38 = ((i18 & 15) << 12) | ((i29 & 63) << 6) | (i37 & 63);
                    if (i38 < 2048) {
                        return throwBadUtf8(i37, i36);
                    }
                    c16 = (char) i38;
                    i3 += 3;
                    break;
            }
            cArr[i17] = c16;
            i17++;
        }
        return new String(cArr, 0, i17);
    }

    public static String utf8BytesWithUtf16LengthToString(@Nonnull byte[] bArr, int i3, int i16) {
        return utf8BytesWithUtf16LengthToString(bArr, i3, i16, null);
    }

    public static String utf8BytesWithUtf16LengthToString(@Nonnull byte[] bArr, int i3, int i16, @Nullable int[] iArr) {
        char c16;
        ThreadLocal<char[]> threadLocal = localBuffer;
        char[] cArr = threadLocal.get();
        if (cArr == null || cArr.length < i16) {
            cArr = new char[i16];
            threadLocal.set(cArr);
        }
        int i17 = i3;
        int i18 = 0;
        while (i16 > 0) {
            int i19 = bArr[i17] & 255;
            switch (i19 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (i19 != 0) {
                        c16 = (char) i19;
                        i17++;
                        break;
                    } else {
                        return throwBadUtf8(i19, i17);
                    }
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return throwBadUtf8(i19, i17);
                case 12:
                case 13:
                    int i26 = i17 + 1;
                    int i27 = bArr[i26] & 255;
                    if ((i27 & 192) != 128) {
                        return throwBadUtf8(i27, i26);
                    }
                    int i28 = ((i19 & 31) << 6) | (i27 & 63);
                    if (i28 != 0 && i28 < 128) {
                        return throwBadUtf8(i27, i26);
                    }
                    c16 = (char) i28;
                    i17 += 2;
                    break;
                case 14:
                    int i29 = i17 + 1;
                    int i36 = bArr[i29] & 255;
                    if ((i36 & 192) != 128) {
                        return throwBadUtf8(i36, i29);
                    }
                    int i37 = i17 + 2;
                    int i38 = bArr[i37] & 255;
                    if ((i38 & 192) == 128) {
                        int i39 = ((i19 & 15) << 12) | ((i36 & 63) << 6) | (i38 & 63);
                        if (i39 >= 2048) {
                            c16 = (char) i39;
                            i17 += 3;
                            break;
                        } else {
                            return throwBadUtf8(i38, i37);
                        }
                    } else {
                        return throwBadUtf8(i38, i37);
                    }
            }
            cArr[i18] = c16;
            i18++;
            i16--;
        }
        if (iArr != null && iArr.length > 0) {
            int i46 = i17 - i3;
            iArr[0] = i46;
            iArr[0] = i46;
        }
        return new String(cArr, 0, i18);
    }
}
