package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DtsUtil {
    private static final byte FIRST_BYTE_14B_BE = 31;
    private static final byte FIRST_BYTE_14B_LE = -1;
    private static final byte FIRST_BYTE_BE = Byte.MAX_VALUE;
    private static final byte FIRST_BYTE_LE = -2;
    private static final int SYNC_VALUE_14B_BE = 536864768;
    private static final int SYNC_VALUE_14B_LE = -14745368;
    private static final int SYNC_VALUE_BE = 2147385345;
    private static final int SYNC_VALUE_LE = -25230976;
    private static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 48000, -1, -1};
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, 112, 128, 192, 224, 256, MsgConstant.KRMFILETHUMBSIZE384, TroopInfo.PAY_PRIVILEGE_ALL, 512, 640, 768, 896, 1024, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION, 1280, 1536, 1920, 2048, 2304, ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    DtsUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getDtsFrameSize(byte[] bArr) {
        int i3;
        byte b16;
        int i16;
        int i17;
        byte b17;
        boolean z16 = false;
        byte b18 = bArr[0];
        if (b18 != -2) {
            if (b18 != -1) {
                if (b18 != 31) {
                    i3 = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                    b16 = bArr[7];
                } else {
                    i17 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                    b17 = bArr[8];
                }
            } else {
                i17 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b17 = bArr[9];
            }
            i16 = (((b17 & 60) >> 2) | i17) + 1;
            z16 = true;
            if (!z16) {
                return (i16 * 16) / 14;
            }
            return i16;
        }
        i3 = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b16 = bArr[6];
        i16 = (((b16 & 240) >> 4) | i3) + 1;
        if (!z16) {
        }
    }

    private static ParsableBitArray getNormalizedFrameHeader(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new ParsableBitArray(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (isLittleEndianFrameHeader(copyOf)) {
            for (int i3 = 0; i3 < copyOf.length - 1; i3 += 2) {
                byte b16 = copyOf[i3];
                int i16 = i3 + 1;
                copyOf[i3] = copyOf[i16];
                copyOf[i16] = b16;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
        if (copyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(copyOf);
            while (parsableBitArray2.bitsLeft() >= 16) {
                parsableBitArray2.skipBits(2);
                parsableBitArray.putInt(parsableBitArray2.readBits(14), 14);
            }
        }
        parsableBitArray.reset(copyOf);
        return parsableBitArray;
    }

    private static boolean isLittleEndianFrameHeader(byte[] bArr) {
        byte b16 = bArr[0];
        if (b16 != -2 && b16 != -1) {
            return false;
        }
        return true;
    }

    public static boolean isSyncWord(int i3) {
        if (i3 != SYNC_VALUE_BE && i3 != SYNC_VALUE_LE && i3 != SYNC_VALUE_14B_BE && i3 != SYNC_VALUE_14B_LE) {
            return false;
        }
        return true;
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        int i3;
        byte b16;
        int i16;
        byte b17;
        byte b18 = bArr[0];
        if (b18 != -2) {
            if (b18 == -1) {
                i3 = (bArr[4] & 7) << 4;
                b17 = bArr[7];
            } else if (b18 != 31) {
                i3 = (bArr[4] & 1) << 6;
                b16 = bArr[5];
            } else {
                i3 = (bArr[5] & 7) << 4;
                b17 = bArr[6];
            }
            i16 = b17 & 60;
            return (((i16 >> 2) | i3) + 1) * 32;
        }
        i3 = (bArr[5] & 1) << 6;
        b16 = bArr[4];
        i16 = b16 & 252;
        return (((i16 >> 2) | i3) + 1) * 32;
    }

    public static Format parseDtsFormat(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i3;
        int i16;
        ParsableBitArray normalizedFrameHeader = getNormalizedFrameHeader(bArr);
        normalizedFrameHeader.skipBits(60);
        int i17 = CHANNELS_BY_AMODE[normalizedFrameHeader.readBits(6)];
        int i18 = SAMPLE_RATE_BY_SFREQ[normalizedFrameHeader.readBits(4)];
        int readBits = normalizedFrameHeader.readBits(5);
        int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
        if (readBits >= iArr.length) {
            i3 = -1;
        } else {
            i3 = (iArr[readBits] * 1000) / 2;
        }
        int i19 = i3;
        normalizedFrameHeader.skipBits(10);
        if (normalizedFrameHeader.readBits(2) > 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        return Format.createAudioSampleFormat(str, "audio/vnd.dts", null, i19, -1, i17 + i16, i18, null, drmInitData, 0, str2);
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int i3;
        byte b16;
        int i16;
        byte b17;
        int position = byteBuffer.position();
        byte b18 = byteBuffer.get(position);
        if (b18 != -2) {
            if (b18 == -1) {
                i3 = (byteBuffer.get(position + 4) & 7) << 4;
                b17 = byteBuffer.get(position + 7);
            } else if (b18 != 31) {
                i3 = (byteBuffer.get(position + 4) & 1) << 6;
                b16 = byteBuffer.get(position + 5);
            } else {
                i3 = (byteBuffer.get(position + 5) & 7) << 4;
                b17 = byteBuffer.get(position + 6);
            }
            i16 = b17 & 60;
            return (((i16 >> 2) | i3) + 1) * 32;
        }
        i3 = (byteBuffer.get(position + 5) & 1) << 6;
        b16 = byteBuffer.get(position + 4);
        i16 = b16 & 252;
        return (((i16 >> 2) | i3) + 1) * 32;
    }
}
