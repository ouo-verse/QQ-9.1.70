package hynb.q;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {
    public static byte[] a(String str, byte[] bArr) {
        return a(bArr, bArr.length, str.getBytes());
    }

    public static byte[] b(String str, byte[] bArr) {
        int length = bArr.length;
        return a(bArr, length, str.getBytes(), a(length));
    }

    public static byte[] a(byte[] bArr, int i3, byte[] bArr2, int i16) {
        byte[] bArr3 = new byte[8];
        byte[] bArr4 = new byte[8];
        byte[] bArr5 = new byte[8];
        Random random = new Random();
        int i17 = i16;
        bArr3[0] = (byte) ((((byte) random.nextInt(32767)) & 248) | ((byte) i17));
        int i18 = 1;
        int i19 = 1;
        while (true) {
            int i26 = i17 - 1;
            if (i17 <= 0) {
                break;
            }
            bArr3[i19] = (byte) random.nextInt(32767);
            i19++;
            i17 = i26;
        }
        for (int i27 = 0; i27 < 8; i27++) {
            bArr4[i27] = 0;
        }
        byte[] bArr6 = bArr4;
        int i28 = 1;
        int i29 = 0;
        while (i28 <= 2) {
            if (i19 < 8) {
                bArr3[i19] = (byte) random.nextInt(32767);
                i28++;
                i19++;
            }
            if (i19 == 8) {
                for (int i36 = 0; i36 < 8; i36++) {
                    bArr3[i36] = (byte) (bArr3[i36] ^ bArr4[i36]);
                }
                byte[] b16 = b(bArr3, bArr2);
                for (int i37 = 0; i37 < 8; i37++) {
                    b16[i37] = (byte) (b16[i37] ^ bArr6[i37]);
                }
                System.arraycopy(b16, 0, bArr5, i29, 8);
                bArr6 = Arrays.copyOf(bArr3, 8);
                System.arraycopy(bArr5, i29, bArr4, 0, 8);
                i29 += 8;
                bArr5 = Arrays.copyOfRange(bArr5, 0, bArr5.length + 8);
                i19 = 0;
            }
        }
        byte[] bArr7 = bArr5;
        int i38 = 0;
        int i39 = i3;
        while (i39 > 0) {
            if (i19 < 8) {
                bArr3[i19] = bArr[i38];
                i39--;
                i19++;
                i38++;
            }
            if (i19 == 8) {
                for (int i46 = 0; i46 < 8; i46++) {
                    bArr3[i46] = (byte) (bArr3[i46] ^ bArr4[i46]);
                }
                byte[] b17 = b(bArr3, bArr2);
                for (int i47 = 0; i47 < 8; i47++) {
                    b17[i47] = (byte) (b17[i47] ^ bArr6[i47]);
                }
                System.arraycopy(b17, 0, bArr7, i29, 8);
                bArr6 = Arrays.copyOf(bArr3, 8);
                System.arraycopy(bArr7, i29, bArr4, 0, 8);
                i29 += 8;
                bArr7 = Arrays.copyOfRange(bArr7, 0, bArr7.length + 8);
                i19 = 0;
            }
        }
        while (i18 <= 7) {
            if (i19 < 8) {
                bArr3[i19] = 0;
                i18++;
                i19++;
            }
            if (i19 == 8) {
                for (int i48 = 0; i48 < 8; i48++) {
                    bArr3[i48] = (byte) (bArr3[i48] ^ bArr4[i48]);
                }
                byte[] b18 = b(bArr3, bArr2);
                for (int i49 = 0; i49 < 8; i49++) {
                    b18[i49] = (byte) (b18[i49] ^ bArr6[i49]);
                }
                System.arraycopy(b18, 0, bArr7, i29, 8);
                bArr6 = Arrays.copyOf(bArr3, 8);
                System.arraycopy(bArr7, i29, bArr4, 0, 8);
                i29 += 8;
                bArr7 = Arrays.copyOfRange(bArr7, 0, bArr7.length + 8);
                i19 = 0;
            }
        }
        return Arrays.copyOfRange(bArr7, 0, i29);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int[] iArr = new int[4];
        int a16 = a(bArr, 0);
        int a17 = a(bArr, 4);
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr3 = new byte[4];
            for (int i16 = 0; i16 < 4; i16++) {
                bArr3[i16] = bArr2[(i3 * 4) + i16];
            }
            iArr[i3] = a(bArr3, 0);
        }
        int i17 = 0;
        for (int i18 = 0; i18 < 16; i18++) {
            i17 -= 1640531527;
            a16 += (a17 << 4) + (iArr[0] ^ a17) + ((a17 >>> 5) ^ i17) + iArr[1];
            a17 += (a16 << 4) + (iArr[2] ^ a16) + ((a16 >>> 5) ^ i17) + iArr[3];
        }
        byte[] bArr4 = new byte[length];
        a(a16, bArr4, 0);
        a(a17, bArr4, 4);
        return bArr4;
    }

    public static int a(int i3) {
        int i16 = (((i3 + 1) + 2) + 7) % 8;
        return i16 > 0 ? 8 - i16 : i16;
    }

    public static byte[] a(byte[] bArr, int i3, byte[] bArr2) {
        byte[] bArr3 = new byte[8];
        byte[] bArr4 = new byte[8];
        if (i3 % 8 != 0 || i3 < 16) {
            return bArr4;
        }
        byte[] a16 = a(bArr, bArr2);
        int i16 = a16[0] & 7;
        int i17 = 2;
        int i18 = (((i3 - 1) - i16) - 2) - 7;
        Arrays.fill(bArr3, (byte) 0);
        byte[] copyOf = Arrays.copyOf(bArr, 8);
        int i19 = i16 + 1;
        int i26 = 8;
        int i27 = 1;
        while (i27 <= i17) {
            if (i19 < 8) {
                i19++;
                i27++;
            } else if (i19 == 8) {
                bArr3 = Arrays.copyOf(copyOf, 8);
                System.arraycopy(bArr, i26, copyOf, 0, 8);
                for (int i28 = 0; i28 < 8; i28++) {
                    int i29 = i26 + i28;
                    if (i29 >= i3) {
                        return bArr4;
                    }
                    a16[i28] = (byte) (a16[i28] ^ bArr[i29]);
                }
                a16 = a(a16, bArr2);
                i26 += 8;
                i19 = 0;
                i17 = 2;
            } else {
                continue;
            }
        }
        int i36 = 0;
        while (i18 > 0) {
            if (i19 < 8) {
                if (i36 >= bArr4.length) {
                    bArr4 = Arrays.copyOfRange(bArr4, 0, bArr4.length + 8);
                }
                bArr4[i36] = (byte) (a16[i19] ^ bArr3[i19]);
                i19++;
                i18--;
                i36++;
            } else if (i19 == 8) {
                bArr3 = Arrays.copyOf(copyOf, 8);
                System.arraycopy(bArr, i26, copyOf, 0, 8);
                for (int i37 = 0; i37 < 8; i37++) {
                    int i38 = i26 + i37;
                    if (i38 >= i3) {
                        return bArr4;
                    }
                    a16[i37] = (byte) (bArr[i38] ^ a16[i37]);
                }
                a16 = a(a16, bArr2);
                i26 += 8;
                i19 = 0;
            } else {
                continue;
            }
        }
        int i39 = 1;
        while (i39 <= 7) {
            if (i19 < 8) {
                if ((a16[i19] ^ bArr3[i19]) != 0) {
                    return bArr4;
                }
                i19++;
                i39++;
            } else if (i19 == 8) {
                bArr3 = Arrays.copyOf(copyOf, 8);
                System.arraycopy(bArr, i26, copyOf, 0, 8);
                for (int i46 = 0; i46 < 8; i46++) {
                    int i47 = i26 + i46;
                    if (i47 >= i3) {
                        return bArr4;
                    }
                    a16[i46] = (byte) (bArr[i47] ^ a16[i46]);
                }
                a16 = a(a16, bArr2);
                i26 += 8;
                i19 = 0;
            } else {
                continue;
            }
        }
        return Arrays.copyOfRange(bArr4, 0, i36);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int[] iArr = new int[4];
        if (length < 8) {
            return bArr;
        }
        int a16 = a(bArr, 0);
        int a17 = a(bArr, 4);
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = a(bArr2, i3 * 4);
        }
        int i16 = -478700656;
        for (int i17 = 0; i17 < 16; i17++) {
            a17 -= (((a16 << 4) + (iArr[2] ^ a16)) + ((a16 >>> 5) ^ i16)) + iArr[3];
            a16 -= (((a17 << 4) + (iArr[0] ^ a17)) + ((a17 >>> 5) ^ i16)) + iArr[1];
            i16 += 1640531527;
        }
        byte[] bArr3 = new byte[length];
        a(a16, bArr3, 0);
        a(a17, bArr3, 4);
        return bArr3;
    }

    public static int a(byte[] bArr, int i3) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i3, bArr2, 0, 4);
        return ByteBuffer.wrap(bArr2).getInt();
    }

    public static void a(int i3, byte[] bArr, int i16) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i3);
        System.arraycopy(allocate.array(), 0, bArr, i16, 4);
    }
}
