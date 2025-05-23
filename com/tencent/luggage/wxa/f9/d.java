package com.tencent.luggage.wxa.f9;

import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f125538a = false;

    public static void a() {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            f125538a = true;
        } else {
            f125538a = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        if (r6 != 3) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(int i3, int i16, byte[] bArr) {
        if (i3 == i16) {
            return bArr;
        }
        int length = bArr.length;
        if (i3 != 1) {
            if (i3 == 2) {
                if (i16 == 1 || i16 == 3) {
                    int i17 = length / 2;
                    byte[] bArr2 = new byte[i17];
                    for (int i18 = 0; i18 < i17; i18++) {
                        int i19 = i18 * 2;
                        bArr2[i18] = (byte) (a.a(bArr[i19], bArr[i19 + 1], f125538a) / 256);
                    }
                    return bArr2;
                }
            }
            return bArr;
        }
        if (i16 == 2) {
            byte[] bArr3 = new byte[length * 2];
            for (int i26 = 0; i26 < length; i26++) {
                byte[] a16 = a.a((short) (bArr[i26] * 256), f125538a);
                int i27 = i26 * 2;
                bArr3[i27] = a16[0];
                bArr3[i27 + 1] = a16[1];
            }
            return bArr3;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        if (r10 != 3) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
    
        if (r10 != 3) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(int i3, int i16, int i17, byte[] bArr) {
        if (bArr == null || i3 == i16) {
            return bArr;
        }
        if (i17 != 1 && i17 != 2 && i17 != 3) {
            return bArr;
        }
        int length = bArr.length;
        int i18 = 0;
        if (i3 != 1) {
            if (i3 == 2 && i16 == 1) {
                int i19 = length / 2;
                byte[] bArr2 = new byte[i19];
                if (i17 != 1) {
                    if (i17 == 2) {
                        for (int i26 = 0; i26 < i19; i26 += 2) {
                            int i27 = i26 * 2;
                            byte[] a16 = a.a(bArr[i27], bArr[i27 + 1], bArr[i27 + 2], bArr[i27 + 3], f125538a);
                            bArr2[i26] = a16[0];
                            bArr2[i26 + 1] = a16[1];
                        }
                    }
                    return bArr2;
                }
                while (i18 < i19) {
                    int i28 = i18 * 2;
                    bArr2[i18] = (byte) (((short) (bArr[i28] + bArr[i28 + 1])) >> 1);
                    i18 += 2;
                }
                return bArr2;
            }
        } else if (i16 == 2) {
            byte[] bArr3 = new byte[length * 2];
            if (i17 != 1) {
                if (i17 == 2) {
                    while (i18 < length) {
                        byte b16 = bArr[i18];
                        byte b17 = bArr[i18 + 1];
                        int i29 = i18 * 2;
                        bArr3[i29] = b16;
                        bArr3[i29 + 1] = b17;
                        bArr3[i29 + 2] = b16;
                        bArr3[i29 + 3] = b17;
                        i18 += 2;
                    }
                }
                return bArr3;
            }
            while (i18 < length) {
                byte b18 = bArr[i18];
                int i36 = i18 * 2;
                bArr3[i36] = b18;
                bArr3[i36 + 1] = b18;
                i18++;
            }
            return bArr3;
        }
        return bArr;
    }

    public static void a(int i3, byte[] bArr, byte[][] bArr2) {
        if (bArr2.length <= 1) {
            return;
        }
        int length = bArr.length / 2;
        byte[] bArr3 = bArr2[0];
        Arrays.fill(bArr3, 0, bArr3.length, (byte) 0);
        byte[] bArr4 = bArr2[1];
        Arrays.fill(bArr4, 0, bArr4.length, (byte) 0);
        if (i3 != 1) {
            if (i3 == 2) {
                for (int i16 = 0; i16 < length; i16 += 2) {
                    byte[] bArr5 = bArr2[0];
                    int i17 = i16 * 2;
                    bArr5[i16] = bArr[i17];
                    int i18 = i16 + 1;
                    bArr5[i18] = bArr[i17 + 1];
                    byte[] bArr6 = bArr2[1];
                    bArr6[i16] = bArr[i17 + 2];
                    bArr6[i18] = bArr[i17 + 3];
                }
                return;
            }
            if (i3 != 3) {
                return;
            }
        }
        int i19 = 0;
        for (int i26 = 0; i26 < length; i26 += 2) {
            bArr2[0][i19] = bArr[i26];
            bArr2[1][i19] = bArr[i26 + 1];
            i19++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r7 != 3) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(int i3, byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && bArr.length != 0 && bArr2.length != 0) {
            if (bArr.length != bArr2.length) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray and sourceSecondByteArray length is not same");
                return null;
            }
            int length = bArr.length;
            byte[] bArr3 = new byte[length * 2];
            int i16 = 0;
            if (i3 != 1) {
                if (i3 == 2) {
                    while (i16 < length) {
                        int i17 = i16 * 2;
                        bArr3[i17] = bArr[i16];
                        int i18 = i16 + 1;
                        bArr3[i17 + 1] = bArr[i18];
                        bArr3[i17 + 2] = bArr2[i16];
                        bArr3[i17 + 3] = bArr2[i18];
                        i16 += 2;
                    }
                }
                return bArr3;
            }
            while (i16 < length) {
                bArr3[i16] = bArr[i16];
                bArr3[i16 + 1] = bArr2[i16];
                i16 += 2;
            }
            return bArr3;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray or sourceSecondByteArray is null");
        return null;
    }
}
