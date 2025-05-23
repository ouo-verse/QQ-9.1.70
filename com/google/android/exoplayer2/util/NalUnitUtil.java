package com.google.android.exoplayer2.util;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    private static final String TAG = "NalUnitUtil";
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object scratchEscapePositionsLock = new Object();
    private static int[] scratchEscapePositions = new int[10];

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i3, int i16, boolean z16) {
            this.picParameterSetId = i3;
            this.seqParameterSetId = i16;
            this.bottomFieldPicOrderInFramePresentFlag = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SpsData {
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i3, int i16, int i17, float f16, boolean z16, boolean z17, int i18, int i19, int i26, boolean z18) {
            this.seqParameterSetId = i3;
            this.width = i16;
            this.height = i17;
            this.pixelWidthAspectRatio = f16;
            this.separateColorPlaneFlag = z16;
            this.frameMbsOnlyFlag = z17;
            this.frameNumLength = i18;
            this.picOrderCountType = i19;
            this.picOrderCntLsbLength = i26;
            this.deltaPicOrderAlwaysZeroFlag = z18;
        }
    }

    NalUnitUtil() {
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int i17 = i3 + 1;
            if (i17 < position) {
                int i18 = byteBuffer.get(i3) & 255;
                if (i16 == 3) {
                    if (i18 == 1 && (byteBuffer.get(i17) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i3 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i18 == 0) {
                    i16++;
                }
                if (i18 != 0) {
                    i16 = 0;
                }
                i3 = i17;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int findNalUnit(byte[] bArr, int i3, int i16, boolean[] zArr) {
        boolean z16;
        boolean z17;
        int i17 = i16 - i3;
        boolean z18 = false;
        if (i17 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        if (i17 == 0) {
            return i16;
        }
        if (zArr != null) {
            if (zArr[0]) {
                clearPrefixFlags(zArr);
                return i3 - 3;
            }
            if (i17 > 1 && zArr[1] && bArr[i3] == 1) {
                clearPrefixFlags(zArr);
                return i3 - 2;
            }
            if (i17 > 2 && zArr[2] && bArr[i3] == 0 && bArr[i3 + 1] == 1) {
                clearPrefixFlags(zArr);
                return i3 - 1;
            }
        }
        int i18 = i16 - 1;
        int i19 = i3 + 2;
        while (i19 < i18) {
            byte b16 = bArr[i19];
            if ((b16 & 254) == 0) {
                int i26 = i19 - 2;
                if (bArr[i26] == 0 && bArr[i19 - 1] == 0 && b16 == 1) {
                    if (zArr != null) {
                        clearPrefixFlags(zArr);
                    }
                    return i26;
                }
                i19 -= 2;
            }
            i19 += 3;
        }
        if (zArr != null) {
            boolean z19 = i17 > 2 ? false : false;
            zArr[0] = z19;
            if (i17 <= 1 ? !(!zArr[2] || bArr[i18] != 0) : !(bArr[i16 - 2] != 0 || bArr[i18] != 0)) {
                z17 = true;
            } else {
                z17 = false;
            }
            zArr[1] = z17;
            if (bArr[i18] == 0) {
                z18 = true;
            }
            zArr[2] = z18;
        }
        return i16;
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i3, int i16) {
        while (i3 < i16 - 2) {
            if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                return i3;
            }
            i3++;
        }
        return i16;
    }

    public static int getH265NalUnitType(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i3) {
        return bArr[i3 + 3] & 31;
    }

    public static boolean isNalUnitSei(String str, byte b16) {
        if ("video/avc".equals(str) && (b16 & 31) == 6) {
            return true;
        }
        if ("video/hevc".equals(str) && ((b16 & 126) >> 1) == 39) {
            return true;
        }
        return false;
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i3, int i16) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i3, i16);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpsData parseSpsNalUnit(byte[] bArr, int i3, int i16) {
        int readUnsignedExpGolombCodedInt;
        boolean z16;
        boolean z17;
        int i17;
        int i18;
        boolean z18;
        int i19;
        boolean z19;
        boolean readBit;
        float f16;
        int readBits;
        int i26;
        int i27;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i3, i16);
        parsableNalUnitBitArray.skipBits(8);
        int readBits2 = parsableNalUnitBitArray.readBits(8);
        parsableNalUnitBitArray.skipBits(16);
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i28 = 1;
        if (readBits2 != 100 && readBits2 != 110 && readBits2 != 122 && readBits2 != 244 && readBits2 != 44 && readBits2 != 83 && readBits2 != 86 && readBits2 != 118 && readBits2 != 128 && readBits2 != 138) {
            readUnsignedExpGolombCodedInt = 1;
            z17 = false;
        } else {
            readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt == 3) {
                z16 = parsableNalUnitBitArray.readBit();
            } else {
                z16 = false;
            }
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                if (readUnsignedExpGolombCodedInt != 3) {
                    i17 = 8;
                } else {
                    i17 = 12;
                }
                for (int i29 = 0; i29 < i17; i29++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        if (i29 < 6) {
                            i18 = 16;
                        } else {
                            i18 = 64;
                        }
                        skipScalingList(parsableNalUnitBitArray, i18);
                    }
                }
            }
            z17 = z16;
        }
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt4 == 0) {
            i19 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
            z18 = z17;
        } else {
            if (readUnsignedExpGolombCodedInt4 == 1) {
                boolean readBit2 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                long readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                z18 = z17;
                for (int i36 = 0; i36 < readUnsignedExpGolombCodedInt5; i36++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z19 = readBit2;
                i19 = 0;
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
                int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                readBit = parsableNalUnitBitArray.readBit();
                int i37 = (2 - (readBit ? 1 : 0)) * readUnsignedExpGolombCodedInt7;
                if (!readBit) {
                    parsableNalUnitBitArray.skipBit();
                }
                parsableNalUnitBitArray.skipBit();
                int i38 = readUnsignedExpGolombCodedInt6 * 16;
                int i39 = i37 * 16;
                if (parsableNalUnitBitArray.readBit()) {
                    int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (readUnsignedExpGolombCodedInt == 0) {
                        i27 = 2 - (readBit ? 1 : 0);
                    } else {
                        if (readUnsignedExpGolombCodedInt == 3) {
                            i26 = 1;
                        } else {
                            i26 = 2;
                        }
                        if (readUnsignedExpGolombCodedInt == 1) {
                            i28 = 2;
                        }
                        i27 = (2 - (readBit ? 1 : 0)) * i28;
                        i28 = i26;
                    }
                    i38 -= (readUnsignedExpGolombCodedInt8 + readUnsignedExpGolombCodedInt9) * i28;
                    i39 -= (readUnsignedExpGolombCodedInt10 + readUnsignedExpGolombCodedInt11) * i27;
                }
                int i46 = i38;
                int i47 = i39;
                float f17 = 1.0f;
                if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                    readBits = parsableNalUnitBitArray.readBits(8);
                    if (readBits != 255) {
                        int readBits3 = parsableNalUnitBitArray.readBits(16);
                        int readBits4 = parsableNalUnitBitArray.readBits(16);
                        if (readBits3 != 0 && readBits4 != 0) {
                            f17 = readBits3 / readBits4;
                        }
                    } else {
                        float[] fArr = ASPECT_RATIO_IDC_VALUES;
                        if (readBits < fArr.length) {
                            f16 = fArr[readBits];
                            return new SpsData(readUnsignedExpGolombCodedInt2, i46, i47, f16, z18, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i19, z19);
                        }
                        Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits);
                    }
                }
                f16 = f17;
                return new SpsData(readUnsignedExpGolombCodedInt2, i46, i47, f16, z18, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i19, z19);
            }
            z18 = z17;
            i19 = 0;
        }
        z19 = false;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt62 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        int readUnsignedExpGolombCodedInt72 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        readBit = parsableNalUnitBitArray.readBit();
        int i372 = (2 - (readBit ? 1 : 0)) * readUnsignedExpGolombCodedInt72;
        if (!readBit) {
        }
        parsableNalUnitBitArray.skipBit();
        int i382 = readUnsignedExpGolombCodedInt62 * 16;
        int i392 = i372 * 16;
        if (parsableNalUnitBitArray.readBit()) {
        }
        int i462 = i382;
        int i472 = i392;
        float f172 = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            readBits = parsableNalUnitBitArray.readBits(8);
            if (readBits != 255) {
            }
        }
        f16 = f172;
        return new SpsData(readUnsignedExpGolombCodedInt2, i462, i472, f16, z18, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i19, z19);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i3) {
        int i16 = 8;
        int i17 = 8;
        for (int i18 = 0; i18 < i3; i18++) {
            if (i16 != 0) {
                i16 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i17) + 256) % 256;
            }
            if (i16 != 0) {
                i17 = i16;
            }
        }
    }

    public static int unescapeStream(byte[] bArr, int i3) {
        int i16;
        synchronized (scratchEscapePositionsLock) {
            int i17 = 0;
            int i18 = 0;
            while (i17 < i3) {
                try {
                    i17 = findNextUnescapeIndex(bArr, i17, i3);
                    if (i17 < i3) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i18) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i18] = i17;
                        i17 += 3;
                        i18++;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            i16 = i3 - i18;
            int i19 = 0;
            int i26 = 0;
            for (int i27 = 0; i27 < i18; i27++) {
                int i28 = scratchEscapePositions[i27] - i26;
                System.arraycopy(bArr, i26, bArr, i19, i28);
                int i29 = i19 + i28;
                int i36 = i29 + 1;
                bArr[i29] = 0;
                i19 = i36 + 1;
                bArr[i36] = 0;
                i26 += i28 + 3;
            }
            System.arraycopy(bArr, i26, bArr, i19, i16 - i19);
        }
        return i16;
    }
}
