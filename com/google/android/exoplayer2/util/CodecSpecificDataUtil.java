package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CodecSpecificDataUtil {
    private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    private static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
    private static final int AUDIO_OBJECT_TYPE_PS = 29;
    private static final int AUDIO_OBJECT_TYPE_SBR = 5;
    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    CodecSpecificDataUtil() {
    }

    public static byte[] buildAacAudioSpecificConfig(int i3, int i16, int i17) {
        return new byte[]{(byte) (((i3 << 3) & 248) | ((i16 >> 1) & 7)), (byte) (((i16 << 7) & 128) | ((i17 << 3) & 120))};
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i3, int i16) {
        int i17 = 0;
        int i18 = -1;
        int i19 = 0;
        while (true) {
            int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
            if (i19 >= iArr.length) {
                break;
            }
            if (i3 == iArr[i19]) {
                i18 = i19;
            }
            i19++;
        }
        int i26 = -1;
        while (true) {
            int[] iArr2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
            if (i17 >= iArr2.length) {
                break;
            }
            if (i16 == iArr2[i17]) {
                i26 = i17;
            }
            i17++;
        }
        if (i3 != -1 && i26 != -1) {
            return buildAacAudioSpecificConfig(2, i18, i26);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i3 + ", " + i16);
    }

    public static byte[] buildNalUnit(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[bArr2.length + i16];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i3, bArr3, bArr2.length, i16);
        return bArr3;
    }

    private static int findNalStartCode(byte[] bArr, int i3) {
        int length = bArr.length - NAL_START_CODE.length;
        while (i3 <= length) {
            if (isNalStartCode(bArr, i3)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private static int getAacAudioObjectType(ParsableBitArray parsableBitArray) {
        int readBits = parsableBitArray.readBits(5);
        if (readBits == 31) {
            return parsableBitArray.readBits(6) + 32;
        }
        return readBits;
    }

    private static int getAacSamplingFrequency(ParsableBitArray parsableBitArray) {
        boolean z16;
        int readBits = parsableBitArray.readBits(4);
        if (readBits == 15) {
            return parsableBitArray.readBits(24);
        }
        if (readBits < 13) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[readBits];
    }

    private static boolean isNalStartCode(byte[] bArr, int i3) {
        if (bArr.length - i3 <= NAL_START_CODE.length) {
            return false;
        }
        int i16 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i16 < bArr2.length) {
                if (bArr[i3 + i16] != bArr2[i16]) {
                    return false;
                }
                i16++;
            } else {
                return true;
            }
        }
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] bArr) throws ParserException {
        return parseAacAudioSpecificConfig(new ParsableBitArray(bArr), false);
    }

    private static void parseGaSpecificConfig(ParsableBitArray parsableBitArray, int i3, int i16) {
        parsableBitArray.skipBits(1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(14);
        }
        boolean readBit = parsableBitArray.readBit();
        if (i16 != 0) {
            if (i3 == 6 || i3 == 20) {
                parsableBitArray.skipBits(3);
            }
            if (readBit) {
                if (i3 == 22) {
                    parsableBitArray.skipBits(16);
                }
                if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                    parsableBitArray.skipBits(3);
                }
                parsableBitArray.skipBits(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        int length;
        if (!isNalStartCode(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        do {
            arrayList.add(Integer.valueOf(i3));
            i3 = findNalStartCode(bArr, i3 + NAL_START_CODE.length);
        } while (i3 != -1);
        byte[][] bArr2 = new byte[arrayList.size()];
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            int intValue = ((Integer) arrayList.get(i16)).intValue();
            if (i16 < arrayList.size() - 1) {
                length = ((Integer) arrayList.get(i16 + 1)).intValue();
            } else {
                length = bArr.length;
            }
            int i17 = length - intValue;
            byte[] bArr3 = new byte[i17];
            System.arraycopy(bArr, intValue, bArr3, 0, i17);
            bArr2[i16] = bArr3;
        }
        return bArr2;
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(ParsableBitArray parsableBitArray, boolean z16) throws ParserException {
        int aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
        int aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
        int readBits = parsableBitArray.readBits(4);
        if (aacAudioObjectType == 5 || aacAudioObjectType == 29) {
            aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
            aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
            if (aacAudioObjectType == 22) {
                readBits = parsableBitArray.readBits(4);
            }
        }
        if (z16) {
            if (aacAudioObjectType != 1 && aacAudioObjectType != 2 && aacAudioObjectType != 3 && aacAudioObjectType != 4 && aacAudioObjectType != 6 && aacAudioObjectType != 7 && aacAudioObjectType != 17) {
                switch (aacAudioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + aacAudioObjectType);
                }
            }
            parseGaSpecificConfig(parsableBitArray, aacAudioObjectType, readBits);
            switch (aacAudioObjectType) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int readBits2 = parsableBitArray.readBits(2);
                    if (readBits2 == 2 || readBits2 == 3) {
                        throw new ParserException("Unsupported epConfig: " + readBits2);
                    }
            }
        }
        int i3 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[readBits];
        Assertions.checkArgument(i3 != -1);
        return Pair.create(Integer.valueOf(aacSamplingFrequency), Integer.valueOf(i3));
    }
}
