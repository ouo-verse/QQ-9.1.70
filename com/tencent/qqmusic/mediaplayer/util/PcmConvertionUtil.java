package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

/* loaded from: classes23.dex */
public class PcmConvertionUtil {
    private static void checkArrayLength(int[] iArr, int i3) {
        if (iArr != null && iArr.length != 0) {
            if (i3 <= iArr.length) {
                return;
            }
            throw new IllegalArgumentException("the length param can not larger than int Array length. param:" + i3 + ", int array length:" + iArr.length);
        }
        throw new IllegalArgumentException("int Array must not be null or zero length");
    }

    private static void checkBufferLength(BufferInfo bufferInfo) {
        if (bufferInfo != null && bufferInfo.byteBuffer != null && bufferInfo.bufferSize > 0) {
        } else {
            throw new IllegalArgumentException("bufferInfo must not be null or zero length");
        }
    }

    private static void convertBitDepth24To16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i3) {
        checkBufferLength(bufferInfo);
        if (bufferInfo2 != null) {
            if (i3 == 3) {
                int i16 = bufferInfo.bufferSize;
                bufferInfo2.setTempByteBufferCapacity(i16);
                int i17 = 0;
                for (int i18 = 0; i18 < i16; i18++) {
                    if (i18 % 3 != 0) {
                        bufferInfo2.tempByteBuffer[i17] = bufferInfo.byteBuffer[i18];
                        i17++;
                    }
                }
                bufferInfo2.fillByte(bufferInfo2.tempByteBuffer, i17);
                bufferInfo2.bufferSize = i17;
                return;
            }
            throw new IllegalArgumentException("origin bit depth must be 3");
        }
        throw new IllegalArgumentException("BufferInfo dest must not be null");
    }

    private static void convertBitDepth32To16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i3) {
        checkBufferLength(bufferInfo);
        if (bufferInfo2 != null) {
            if (i3 == 4) {
                int i16 = bufferInfo.bufferSize;
                bufferInfo2.setTempByteBufferCapacity(i16);
                int i17 = 0;
                for (int i18 = 0; i18 < i16; i18 += 4) {
                    DataConversionUtil.floatTo2Bytes(DataConversionUtil.bytesToFloat32bitInLittleEndian(bufferInfo.byteBuffer, i18), bufferInfo2.tempByteBuffer, i17);
                    i17 += 2;
                }
                bufferInfo2.fillByte(bufferInfo2.tempByteBuffer, i17);
                bufferInfo2.bufferSize = i17;
                return;
            }
            throw new IllegalArgumentException("origin bit depth must be 4");
        }
        throw new IllegalArgumentException("BufferInfo dest must not be null");
    }

    public static void convertBitDepthTo16(BufferInfo bufferInfo, BufferInfo bufferInfo2, int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    convertBitDepth32To16(bufferInfo, bufferInfo2, i3);
                    return;
                }
                throw new IllegalArgumentException("not support originBitDepth, originBitDepth=" + i3);
            }
            convertBitDepth24To16(bufferInfo, bufferInfo2, i3);
            return;
        }
        checkBufferLength(bufferInfo);
        bufferInfo.fillInto(bufferInfo2);
    }

    public static void convertByteBufferToFloatBuffer(BufferInfo bufferInfo, FloatBufferInfo floatBufferInfo, int i3) {
        checkBufferLength(bufferInfo);
        if (floatBufferInfo != null) {
            if (i3 > 0) {
                floatBufferInfo.setTempFloatBufferCapacity(bufferInfo.bufferSize / i3);
                int i16 = bufferInfo.bufferSize;
                floatBufferInfo.bufferSize = i16 / i3;
                DataConversionUtil.byteArrayToFloatArray(bufferInfo.byteBuffer, i16, i3, floatBufferInfo.tempFloatBuffer);
                floatBufferInfo.fillFloat(floatBufferInfo.tempFloatBuffer, floatBufferInfo.bufferSize);
                return;
            }
            throw new IllegalArgumentException("bit depth must not be zero");
        }
        throw new IllegalArgumentException("BufferInfo dest must not be null");
    }

    private static void interpolateIn16Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j3, long j16) {
        int i3 = bufferInfo.bufferSize / 2;
        float f16 = i3;
        int round = Math.round(((1.0f * f16) / ((float) j3)) * ((float) j16));
        short[] sArr = new short[i3];
        short[] sArr2 = new short[round];
        DataConversionUtil.byteArray16BitToShortArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, sArr);
        linearInterpolate(sArr, i3, sArr2, round, round / f16);
        int i16 = round * 2;
        byte[] bArr = new byte[i16];
        DataConversionUtil.shortArrayToByteArray16Bit(sArr2, round, bArr);
        bufferInfo2.fillByte(bArr, i16);
    }

    private static void interpolateIn24Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j3, long j16) {
        int i3 = bufferInfo.bufferSize / 3;
        float f16 = i3;
        int round = Math.round(((1.0f * f16) / ((float) j3)) * ((float) j16));
        int[] iArr = new int[i3];
        int[] iArr2 = new int[round];
        DataConversionUtil.byteArray24BitToIntArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, iArr);
        linearInterpolate(iArr, i3, iArr2, round, round / f16);
        int i16 = round * 3;
        byte[] bArr = new byte[i16];
        DataConversionUtil.intArrayToByteArray24Bit(iArr2, round, bArr);
        bufferInfo2.fillByte(bArr, i16);
    }

    private static void interpolateIn32Bit(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j3, long j16) {
        int i3 = bufferInfo.bufferSize / 4;
        float f16 = i3;
        int round = Math.round(((1.0f * f16) / ((float) j3)) * ((float) j16));
        int[] iArr = new int[i3];
        int[] iArr2 = new int[round];
        DataConversionUtil.byteArray32BitToIntArray(bufferInfo.byteBuffer, bufferInfo.bufferSize, iArr);
        linearInterpolate(iArr, i3, iArr2, round, round / f16);
        int i16 = round * 4;
        byte[] bArr = new byte[i16];
        DataConversionUtil.intArrayToByteArray32Bit(iArr2, round, bArr);
        bufferInfo2.fillByte(bArr, i16);
    }

    private static void linearInterpolate(int[] iArr, int i3, int[] iArr2, int i16, float f16) {
        checkArrayLength(iArr, i3);
        checkArrayLength(iArr2, i16);
        for (int i17 = 0; i17 < i16; i17++) {
            float f17 = i17 / f16;
            int i18 = (int) f17;
            int i19 = i18 + 1;
            if (i19 >= i3) {
                i19 = i3 - 1;
            }
            int i26 = iArr[i19];
            iArr2[i17] = (int) (((i26 - r4) * (f17 - i18)) + iArr[i18]);
        }
    }

    public static void reSample(BufferInfo bufferInfo, BufferInfo bufferInfo2, long j3, long j16, int i3) throws IllegalArgumentException {
        checkBufferLength(bufferInfo);
        if (bufferInfo2 != null) {
            if (j3 != j16 && j16 > 0 && j3 > 0) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            bufferInfo.fillInto(bufferInfo2);
                            return;
                        } else {
                            interpolateIn32Bit(bufferInfo, bufferInfo2, j3, j16);
                            return;
                        }
                    }
                    interpolateIn24Bit(bufferInfo, bufferInfo2, j3, j16);
                    return;
                }
                interpolateIn16Bit(bufferInfo, bufferInfo2, j3, j16);
                return;
            }
            bufferInfo.fillInto(bufferInfo2);
            return;
        }
        throw new IllegalArgumentException("BufferInfo dest must not be null");
    }

    private static void checkArrayLength(short[] sArr, int i3) {
        if (sArr != null && sArr.length != 0) {
            if (i3 <= sArr.length) {
                return;
            }
            throw new IllegalArgumentException("the length param can not larger than short Array length. param:" + i3 + ", short array length:" + sArr.length);
        }
        throw new IllegalArgumentException("short Array must not be null or zero length");
    }

    private static void linearInterpolate(short[] sArr, int i3, short[] sArr2, int i16, float f16) {
        checkArrayLength(sArr, i3);
        checkArrayLength(sArr2, i16);
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = (int) (i17 / f16);
            int i19 = i18 + 1;
            if (i19 >= i3) {
                i19 = i3 - 1;
            }
            short s16 = sArr[i19];
            short s17 = sArr[i18];
            sArr2[i17] = (short) (((s16 - s17) * (r1 - i18)) + s17);
        }
    }
}
