package oicq.wlogin_sdk.tools;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cryptor {
    public static byte[] decrypt(byte[] bArr, int i3, int i16, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[i16];
        System.arraycopy(bArr, i3, bArr3, 0, i16);
        byte[] bArr4 = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        a aVar = new a();
        aVar.f422982e = 0;
        aVar.f422981d = 0;
        aVar.f422985h = bArr4;
        byte[] bArr5 = new byte[8];
        if (i16 % 8 != 0 || i16 < 16) {
            return null;
        }
        byte[] a16 = aVar.a(bArr3, 0);
        aVar.f422979b = a16;
        int i17 = a16[0] & 7;
        aVar.f422983f = i17;
        int i18 = (i16 - i17) - 10;
        if (i18 < 0) {
            return null;
        }
        for (int i19 = 0; i19 < 8; i19++) {
            bArr5[i19] = 0;
        }
        aVar.f422980c = new byte[i18];
        aVar.f422982e = 0;
        aVar.f422981d = 8;
        aVar.f422987j = 8;
        aVar.f422983f++;
        aVar.f422984g = 1;
        while (true) {
            int i26 = aVar.f422984g;
            if (i26 <= 2) {
                int i27 = aVar.f422983f;
                if (i27 < 8) {
                    aVar.f422983f = i27 + 1;
                    aVar.f422984g = i26 + 1;
                }
                if (aVar.f422983f == 8) {
                    if (!aVar.a(bArr3, 0, i16)) {
                        return null;
                    }
                    bArr5 = bArr3;
                }
            } else {
                int i28 = 0;
                while (i18 != 0) {
                    int i29 = aVar.f422983f;
                    if (i29 < 8) {
                        aVar.f422980c[i28] = (byte) (bArr5[(aVar.f422982e + 0) + i29] ^ aVar.f422979b[i29]);
                        i28++;
                        i18--;
                        aVar.f422983f = i29 + 1;
                    }
                    if (aVar.f422983f == 8) {
                        aVar.f422982e = aVar.f422981d - 8;
                        if (!aVar.a(bArr3, 0, i16)) {
                            return null;
                        }
                        bArr5 = bArr3;
                    }
                }
                aVar.f422984g = 1;
                while (aVar.f422984g < 8) {
                    int i36 = aVar.f422983f;
                    if (i36 < 8) {
                        if ((bArr5[(aVar.f422982e + 0) + i36] ^ aVar.f422979b[i36]) != 0) {
                            return null;
                        }
                        aVar.f422983f = i36 + 1;
                    }
                    if (aVar.f422983f == 8) {
                        aVar.f422982e = aVar.f422981d;
                        if (!aVar.a(bArr3, 0, i16)) {
                            return null;
                        }
                        bArr5 = bArr3;
                    }
                    aVar.f422984g++;
                }
                return aVar.f422980c;
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int i17;
        if (bArr != null && bArr2 != null) {
            byte[] bArr3 = new byte[i16];
            System.arraycopy(bArr, i3, bArr3, 0, i16);
            byte[] bArr4 = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            a aVar = new a();
            byte[] bArr5 = new byte[8];
            aVar.f422978a = bArr5;
            aVar.f422979b = new byte[8];
            aVar.f422983f = 1;
            aVar.f422984g = 0;
            aVar.f422982e = 0;
            aVar.f422981d = 0;
            aVar.f422985h = bArr4;
            aVar.f422986i = true;
            int i18 = (i16 + 10) % 8;
            aVar.f422983f = i18;
            if (i18 != 0) {
                aVar.f422983f = 8 - i18;
            }
            aVar.f422980c = new byte[aVar.f422983f + i16 + 10];
            bArr5[0] = (byte) ((aVar.f422988k.nextInt() & 248) | aVar.f422983f);
            int i19 = 1;
            while (true) {
                i17 = aVar.f422983f;
                if (i19 > i17) {
                    break;
                }
                aVar.f422978a[i19] = (byte) (aVar.f422988k.nextInt() & 255);
                i19++;
            }
            aVar.f422983f = i17 + 1;
            for (int i26 = 0; i26 < 8; i26++) {
                aVar.f422979b[i26] = 0;
            }
            aVar.f422984g = 1;
            while (aVar.f422984g <= 2) {
                int i27 = aVar.f422983f;
                if (i27 < 8) {
                    byte[] bArr6 = aVar.f422978a;
                    aVar.f422983f = i27 + 1;
                    bArr6[i27] = (byte) (aVar.f422988k.nextInt() & 255);
                    aVar.f422984g++;
                }
                if (aVar.f422983f == 8) {
                    aVar.a();
                }
            }
            int i28 = 0;
            while (i16 > 0) {
                int i29 = aVar.f422983f;
                if (i29 < 8) {
                    byte[] bArr7 = aVar.f422978a;
                    aVar.f422983f = i29 + 1;
                    bArr7[i29] = bArr3[i28];
                    i16--;
                    i28++;
                }
                if (aVar.f422983f == 8) {
                    aVar.a();
                }
            }
            aVar.f422984g = 1;
            while (true) {
                int i36 = aVar.f422984g;
                if (i36 <= 7) {
                    int i37 = aVar.f422983f;
                    if (i37 < 8) {
                        byte[] bArr8 = aVar.f422978a;
                        aVar.f422983f = i37 + 1;
                        bArr8[i37] = 0;
                        aVar.f422984g = i36 + 1;
                    }
                    if (aVar.f422983f == 8) {
                        aVar.a();
                    }
                } else {
                    return aVar.f422980c;
                }
            }
        } else {
            return null;
        }
    }
}
