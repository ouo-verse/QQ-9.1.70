package com.tencent.qqmusic.mediaplayer.util;

import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DataConversionUtil {
    private static final float BASE_16BIT = 32768.0f;
    private static final float BASE_32BIT = 2.14748365E9f;
    private static final boolean IS_LITTLE_ENDIAN;

    static {
        boolean z16;
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            z16 = true;
        } else {
            z16 = false;
        }
        IS_LITTLE_ENDIAN = z16;
    }

    public static int byteArray16BitToShortArray(byte[] bArr, int i3, short[] sArr) throws IllegalArgumentException {
        short bytesToShort16bitInBigEndian;
        checkByteArrayLength(bArr, i3);
        checkShortArrayLength(sArr, i3 / 2);
        if (i3 % 2 == 0) {
            int i16 = 0;
            int i17 = 0;
            while (i16 < i3 && i17 < sArr.length) {
                if (IS_LITTLE_ENDIAN) {
                    bytesToShort16bitInBigEndian = bytesToShort16bitInLittleEndian(bArr, i16);
                } else {
                    bytesToShort16bitInBigEndian = bytesToShort16bitInBigEndian(bArr, i16);
                }
                sArr[i17] = bytesToShort16bitInBigEndian;
                i16 += 2;
                i17++;
            }
            return i17;
        }
        throw new IllegalArgumentException("length of byteArray must be multiple of 2");
    }

    public static int byteArray24BitToIntArray(byte[] bArr, int i3, int[] iArr) throws IllegalArgumentException {
        int bytesToInt24bitInBigEndian;
        checkByteArrayLength(bArr, i3);
        checkIntArrayLength(iArr, i3 / 3);
        if (i3 % 3 == 0) {
            int i16 = 0;
            int i17 = 0;
            while (i16 < i3 && i17 < iArr.length) {
                if (IS_LITTLE_ENDIAN) {
                    bytesToInt24bitInBigEndian = bytesToInt24bitInLittleEndian(bArr, i16);
                } else {
                    bytesToInt24bitInBigEndian = bytesToInt24bitInBigEndian(bArr, i16);
                }
                iArr[i17] = bytesToInt24bitInBigEndian;
                i16 += 3;
                i17++;
            }
            return i17;
        }
        throw new IllegalArgumentException("length of byteArray must be multiple of 3");
    }

    public static int byteArray32BitToIntArray(byte[] bArr, int i3, int[] iArr) throws IllegalArgumentException {
        int bytesToInt32bitInBigEndian;
        checkByteArrayLength(bArr, i3);
        checkIntArrayLength(iArr, i3 / 4);
        if (i3 % 4 == 0) {
            int i16 = 0;
            int i17 = 0;
            while (i16 < i3 && i17 < iArr.length) {
                if (IS_LITTLE_ENDIAN) {
                    bytesToInt32bitInBigEndian = bytesToInt32bitInLittleEndian(bArr, i16);
                } else {
                    bytesToInt32bitInBigEndian = bytesToInt32bitInBigEndian(bArr, i16);
                }
                iArr[i17] = bytesToInt32bitInBigEndian;
                i16 += 4;
                i17++;
            }
            return i17;
        }
        throw new IllegalArgumentException("length of byteArray must be multiple of 4");
    }

    public static int byteArrayToFloatArray(byte[] bArr, int i3, int i16, float[] fArr) throws IllegalArgumentException {
        float bytesToFloat32bit;
        checkByteArrayLength(bArr, i3);
        checkFloatArrayLength(fArr, i3 / i16);
        checkByteArrayProperty(i3, i16);
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            int i19 = i17 / i16;
            if (i16 == 3) {
                bytesToFloat32bit = bytesToFloat24bit(bArr, i17);
            } else {
                bytesToFloat32bit = bytesToFloat32bit(bArr, i17);
            }
            fArr[i19] = bytesToFloat32bit;
            i17 += i16;
            i18++;
        }
        return i18;
    }

    public static float bytesToFloat24bit(byte[] bArr, int i3) {
        if (IS_LITTLE_ENDIAN) {
            return bytesToFloat24bitInLittleEndian(bArr, i3);
        }
        return bytesToFloat24bitInBigEndian(bArr, i3);
    }

    public static float bytesToFloat24bitInBigEndian(byte[] bArr, int i3) {
        return bytesToInt24bitInBigEndian(bArr, i3) / BASE_32BIT;
    }

    public static float bytesToFloat24bitInLittleEndian(byte[] bArr, int i3) {
        return bytesToInt24bitInLittleEndian(bArr, i3) / BASE_32BIT;
    }

    public static float bytesToFloat32bit(byte[] bArr, int i3) {
        if (IS_LITTLE_ENDIAN) {
            return bytesToFloat32bitInLittleEndian(bArr, i3);
        }
        return bytesToFloat32bitInBigEndian(bArr, i3);
    }

    public static float bytesToFloat32bitInBigEndian(byte[] bArr, int i3) {
        return bytesToInt32bitInBigEndian(bArr, i3) / BASE_32BIT;
    }

    public static float bytesToFloat32bitInLittleEndian(byte[] bArr, int i3) {
        return bytesToInt32bitInLittleEndian(bArr, i3) / BASE_32BIT;
    }

    public static int bytesToInt24bitInBigEndian(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 24) | ((bArr[i3 + 2] << 8) & 255) | ((bArr[i3 + 1] & 255) << 16);
    }

    public static int bytesToInt24bitInLittleEndian(byte[] bArr, int i3) {
        return ((bArr[i3 + 2] & 255) << 24) | ((bArr[i3] << 8) & 255) | ((bArr[i3 + 1] & 255) << 16);
    }

    public static int bytesToInt32bitInBigEndian(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 24) | (bArr[i3 + 3] & 255) | ((bArr[i3 + 2] & 255) << 8) | ((bArr[i3 + 1] & 255) << 16);
    }

    public static int bytesToInt32bitInLittleEndian(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    public static short bytesToShort16bitInBigEndian(byte[] bArr, int i3) {
        return (short) (((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255));
    }

    public static short bytesToShort16bitInLittleEndian(byte[] bArr, int i3) {
        return (short) (((bArr[i3 + 1] & 255) << 8) | (bArr[i3] & 255));
    }

    private static void checkByteArrayLength(byte[] bArr, int i3) {
        if (bArr != null && bArr.length != 0) {
            if (i3 <= bArr.length) {
                return;
            }
            throw new IllegalArgumentException("the length param can not larger than byte Array length. param:" + i3 + ", byte array length:" + bArr.length);
        }
        throw new IllegalArgumentException("byte Array must not be null or zero length");
    }

    private static void checkByteArrayProperty(int i3, int i16) {
        if (i16 <= 4 && i16 >= 3) {
            if (i3 % i16 == 0) {
            } else {
                throw new IllegalArgumentException("length of byteArray must be multiple of bytesPerSample");
            }
        } else {
            throw new IllegalArgumentException("bytesPerSample of " + i16 + " is not supported");
        }
    }

    private static void checkFloatArrayLength(float[] fArr, int i3) {
        if (fArr != null && fArr.length != 0) {
            if (i3 <= fArr.length) {
                return;
            }
            throw new IllegalArgumentException("the length param can not larger than float Array length. param:" + i3 + ", float array length:" + fArr.length);
        }
        throw new IllegalArgumentException("float Array must not be null or zero length");
    }

    private static void checkIntArrayLength(int[] iArr, int i3) {
        if (iArr != null && iArr.length != 0) {
            if (i3 <= iArr.length) {
                return;
            }
            throw new IllegalArgumentException("the length param can not larger than int Array length. param:" + i3 + ", int array length:" + iArr.length);
        }
        throw new IllegalArgumentException("int Array must not be null or zero length");
    }

    private static void checkShortArrayLength(short[] sArr, int i3) {
        if (sArr != null && sArr.length != 0) {
            if (i3 <= sArr.length) {
                return;
            }
            throw new IllegalArgumentException("the length param can not larger than short Array length. param:" + i3 + ", short array length:" + sArr.length);
        }
        throw new IllegalArgumentException("short Array must not be null or zero length");
    }

    public static void floatTo2Bytes(float f16, byte[] bArr, int i3) {
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        if (f16 < -1.0f) {
            f16 = -1.0f;
        }
        shortTo2Bytes((short) (f16 * BASE_16BIT), bArr, i3);
    }

    public static int intArrayToByteArray24Bit(int[] iArr, int i3, byte[] bArr) throws IllegalArgumentException {
        checkIntArrayLength(iArr, i3);
        checkByteArrayLength(bArr, i3 * 3);
        int i16 = 0;
        int i17 = 0;
        while (i16 < i3) {
            intTo3Bytes(iArr[i16], bArr, i17);
            i16++;
            i17 += 3;
        }
        return i17;
    }

    public static int intArrayToByteArray32Bit(int[] iArr, int i3, byte[] bArr) throws IllegalArgumentException {
        checkIntArrayLength(iArr, i3);
        checkByteArrayLength(bArr, i3 * 4);
        int i16 = 0;
        int i17 = 0;
        while (i16 < i3) {
            intTo4Bytes(iArr[i16], bArr, i17);
            i16++;
            i17 += 4;
        }
        return i17;
    }

    public static void intTo3Bytes(int i3, byte[] bArr, int i16) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i16] = (byte) ((i3 >> 8) & 255);
            bArr[i16 + 1] = (byte) ((i3 >> 16) & 255);
            bArr[i16 + 2] = (byte) ((i3 >> 24) & 255);
        } else {
            bArr[i16 + 2] = (byte) ((i3 >> 8) & 255);
            bArr[i16 + 1] = (byte) ((i3 >> 16) & 255);
            bArr[i16] = (byte) ((i3 >> 24) & 255);
        }
    }

    public static void intTo4Bytes(int i3, byte[] bArr, int i16) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i16] = (byte) (i3 & 255);
            bArr[i16 + 1] = (byte) ((i3 >> 8) & 255);
            bArr[i16 + 2] = (byte) ((i3 >> 16) & 255);
            bArr[i16 + 3] = (byte) ((i3 >> 24) & 255);
            return;
        }
        bArr[i16 + 3] = (byte) (i3 & 255);
        bArr[i16 + 2] = (byte) ((i3 >> 8) & 255);
        bArr[i16 + 1] = (byte) ((i3 >> 16) & 255);
        bArr[i16] = (byte) ((i3 >> 24) & 255);
    }

    public static int shortArrayToByteArray16Bit(short[] sArr, int i3, byte[] bArr) throws IllegalArgumentException {
        checkShortArrayLength(sArr, i3);
        checkByteArrayLength(bArr, i3 * 2);
        int i16 = 0;
        int i17 = 0;
        while (i16 < i3) {
            shortTo2Bytes(sArr[i16], bArr, i17);
            i16++;
            i17 += 2;
        }
        return i17;
    }

    public static void shortTo2Bytes(short s16, byte[] bArr, int i3) {
        if (IS_LITTLE_ENDIAN) {
            bArr[i3] = (byte) (s16 & 255);
            bArr[i3 + 1] = (byte) ((s16 >> 8) & 255);
        } else {
            bArr[i3 + 1] = (byte) (s16 & 255);
            bArr[i3] = (byte) ((s16 >> 8) & 255);
        }
    }
}
