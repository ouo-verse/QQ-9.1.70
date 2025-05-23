package com.tencent.qqmusic.mediaplayer.util;

import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BytesTransUtil {
    private static BytesTransUtil instance;
    private String TAG = "BytesTransUtil";

    BytesTransUtil() {
    }

    public static BytesTransUtil getInstance() {
        if (instance == null) {
            instance = new BytesTransUtil();
        }
        return instance;
    }

    public int[] Bytes2Ints(byte[] bArr) {
        int length = bArr.length / 4;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            byte[] bArr2 = new byte[4];
            for (int i16 = 0; i16 < 4; i16++) {
                bArr2[i16] = bArr[(i3 * 4) + i16];
            }
            iArr[i3] = getInt(bArr2);
            System.out.println("2out->" + iArr[i3]);
        }
        return iArr;
    }

    public long[] Bytes2Longs(byte[] bArr) {
        int length = bArr.length / 8;
        long[] jArr = new long[length];
        for (int i3 = 0; i3 < length; i3++) {
            byte[] bArr2 = new byte[8];
            for (int i16 = 0; i16 < 8; i16++) {
                bArr2[i16] = bArr[(i3 * 8) + i16];
            }
            jArr[i3] = getLong(bArr2);
        }
        return jArr;
    }

    public short[] Bytes2Shorts(short[] sArr, byte[] bArr) {
        byte[] bArr2 = new byte[2];
        for (int i3 = 0; i3 < sArr.length; i3++) {
            System.arraycopy(bArr, i3 * 2, bArr2, 0, 2);
            sArr[i3] = getShort(bArr2);
        }
        return sArr;
    }

    public byte[] Ints2Bytes(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            byte[] bytes = getBytes(iArr[i3]);
            System.out.println("1out->" + iArr[i3]);
            for (int i16 = 0; i16 < 4; i16++) {
                bArr[(i3 * 4) + i16] = bytes[i16];
            }
        }
        return bArr;
    }

    public byte[] Longs2Bytes(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        for (int i3 = 0; i3 < jArr.length; i3++) {
            byte[] bytes = getBytes(jArr[i3]);
            for (int i16 = 0; i16 < 8; i16++) {
                bArr[(i3 * 8) + i16] = bytes[i16];
            }
        }
        return bArr;
    }

    public byte[] Shorts2Bytes(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        Shorts2Bytes(sArr, bArr);
        return bArr;
    }

    public byte[] getBytes(short s16, boolean z16) {
        byte[] bArr = new byte[2];
        if (z16) {
            for (int i3 = 1; i3 >= 0; i3--) {
                bArr[i3] = (byte) (s16 & 255);
                s16 = (short) (s16 >> 8);
            }
        } else {
            for (int i16 = 0; i16 < 2; i16++) {
                bArr[i16] = (byte) (s16 & 255);
                s16 = (short) (s16 >> 8);
            }
        }
        return bArr;
    }

    public int getInt(byte[] bArr, boolean z16) {
        if (bArr != null) {
            if (bArr.length > 4) {
                throw new IllegalArgumentException("byte array size > 4 !");
            }
            int i3 = 0;
            if (z16) {
                int i16 = 0;
                while (i3 < bArr.length) {
                    i16 = (i16 << 8) | (bArr[i3] & 255);
                    i3++;
                }
                return i16;
            }
            for (int length = bArr.length - 1; length >= 0; length--) {
                i3 = (i3 << 8) | (bArr[length] & 255);
            }
            return i3;
        }
        throw new IllegalArgumentException("byte array is null!");
    }

    public long getLong(byte[] bArr, boolean z16) {
        if (bArr != null) {
            if (bArr.length > 8) {
                throw new IllegalArgumentException("byte array size > 8 !");
            }
            long j3 = 0;
            if (z16) {
                for (byte b16 : bArr) {
                    j3 = (j3 << 8) | (b16 & 255);
                }
            } else {
                for (int length = bArr.length - 1; length >= 0; length--) {
                    j3 = (j3 << 8) | (bArr[length] & 255);
                }
            }
            return j3;
        }
        throw new IllegalArgumentException("byte array is null!");
    }

    public short getShort(byte[] bArr, boolean z16) {
        if (bArr != null) {
            if (bArr.length > 2) {
                throw new IllegalArgumentException("byte array size > 2 !");
            }
            int i3 = 0;
            if (z16) {
                short s16 = 0;
                while (i3 < bArr.length) {
                    s16 = (short) (((short) (s16 << 8)) | (bArr[i3] & 255));
                    i3++;
                }
                return s16;
            }
            for (int length = bArr.length - 1; length >= 0; length--) {
                i3 = (short) (((short) (i3 << 8)) | (bArr[length] & 255));
            }
            return i3 == true ? (short) 1 : (short) 0;
        }
        throw new IllegalArgumentException("byte array is null!");
    }

    public boolean testCPU() {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            return true;
        }
        return false;
    }

    public void Shorts2Bytes(short[] sArr, byte[] bArr) {
        for (int i3 = 0; i3 < sArr.length; i3++) {
            System.arraycopy(getBytes(sArr[i3]), 0, bArr, i3 * 2, 2);
        }
    }

    public byte[] getBytes(int i3, boolean z16) {
        byte[] bArr = new byte[4];
        if (z16) {
            for (int i16 = 3; i16 >= 0; i16--) {
                bArr[i16] = (byte) (i3 & 255);
                i3 >>= 8;
            }
        } else {
            System.out.println("1");
            for (int i17 = 0; i17 < 4; i17++) {
                bArr[i17] = (byte) (i3 & 255);
                i3 >>= 8;
            }
        }
        return bArr;
    }

    public byte[] getBytes(long j3, boolean z16) {
        byte[] bArr = new byte[8];
        if (z16) {
            for (int i3 = 7; i3 >= 0; i3--) {
                bArr[i3] = (byte) (j3 & 255);
                j3 >>= 8;
            }
        } else {
            for (int i16 = 0; i16 < 8; i16++) {
                bArr[i16] = (byte) (j3 & 255);
                j3 >>= 8;
            }
        }
        return bArr;
    }

    public byte[] getBytes(int i3) {
        return getBytes(i3, testCPU());
    }

    public int getInt(byte[] bArr) {
        return getInt(bArr, testCPU());
    }

    public long getLong(byte[] bArr) {
        return getLong(bArr, testCPU());
    }

    public short getShort(byte[] bArr) {
        return getShort(bArr, testCPU());
    }

    public byte[] getBytes(short s16) {
        return getBytes(s16, testCPU());
    }

    public byte[] getBytes(long j3) {
        return getBytes(j3, testCPU());
    }
}
