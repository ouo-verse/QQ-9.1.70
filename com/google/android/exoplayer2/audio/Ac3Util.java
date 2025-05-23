package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.tencent.luggage.wxa.nf.f;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Ac3Util {
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 8;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 12;
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {48000, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 22050, 16000};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, MsgConstant.KRMFILETHUMBSIZE384, TroopInfo.PAY_PRIVILEGE_ALL, 512, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT, 640};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, 208, 243, 278, f.b.CTRL_INDEX, 417, 487, PlayerResources.ViewId.PLAYER_DURATION, 696, 835, 975, 1114, UfsGROUPMASK.GROUP_MASK_PRECISE_FEATURE, 1393};

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Ac3SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        Ac3SyncFrameInfo(String str, int i3, int i16, int i17, int i18, int i19) {
            this.mimeType = str;
            this.streamType = i3;
            this.channelCount = i16;
            this.sampleRate = i17;
            this.frameSize = i18;
            this.sampleCount = i19;
        }
    }

    Ac3Util() {
    }

    public static int getAc3SyncframeAudioSampleCount() {
        return AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
    }

    private static int getAc3SyncframeSize(int i3, int i16) {
        int i17 = i16 / 2;
        if (i3 >= 0) {
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            if (i3 < iArr.length && i16 >= 0) {
                int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
                if (i17 < iArr2.length) {
                    int i18 = iArr[i3];
                    if (i18 == 44100) {
                        return (iArr2[i17] + (i16 % 2)) * 2;
                    }
                    int i19 = BITRATE_BY_HALF_FRMSIZECOD[i17];
                    if (i18 == 32000) {
                        return i19 * 6;
                    }
                    return i19 * 4;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i3 = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i16 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i16++;
        }
        return Format.createAudioSampleFormat(str, "audio/ac3", null, -1, -1, i16, i3, null, drmInitData, 0, str2);
    }

    public static Ac3SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        boolean z16;
        int ac3SyncframeSize;
        int i3;
        int i16;
        int i17;
        String str;
        int i18;
        int readBits;
        int i19;
        int i26;
        int position = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        if (parsableBitArray.readBits(5) == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        parsableBitArray.setPosition(position);
        if (z16) {
            parsableBitArray.skipBits(16);
            i17 = parsableBitArray.readBits(2);
            parsableBitArray.skipBits(3);
            ac3SyncframeSize = (parsableBitArray.readBits(11) + 1) * 2;
            int readBits2 = parsableBitArray.readBits(2);
            if (readBits2 == 3) {
                i19 = 6;
                i3 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray.readBits(2)];
                readBits = 3;
            } else {
                readBits = parsableBitArray.readBits(2);
                i19 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[readBits];
                i3 = SAMPLE_RATE_BY_FSCOD[readBits2];
            }
            i18 = i19 * 256;
            int readBits3 = parsableBitArray.readBits(3);
            boolean readBit = parsableBitArray.readBit();
            i16 = CHANNEL_COUNT_BY_ACMOD[readBits3] + (readBit ? 1 : 0);
            parsableBitArray.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(8);
            }
            if (readBits3 == 0) {
                parsableBitArray.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
            }
            if (i17 == 1 && parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (readBits3 > 2) {
                    parsableBitArray.skipBits(2);
                }
                if ((readBits3 & 1) != 0 && readBits3 > 2) {
                    parsableBitArray.skipBits(6);
                }
                if ((readBits3 & 4) != 0) {
                    parsableBitArray.skipBits(6);
                }
                if (readBit && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                if (i17 == 0) {
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(6);
                    }
                    if (readBits3 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(6);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(6);
                    }
                    int readBits4 = parsableBitArray.readBits(2);
                    if (readBits4 == 1) {
                        parsableBitArray.skipBits(5);
                    } else if (readBits4 == 2) {
                        parsableBitArray.skipBits(12);
                    } else if (readBits4 == 3) {
                        int readBits5 = parsableBitArray.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray.skipBits((readBits5 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (readBits3 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                        if (readBits3 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (readBits == 0) {
                            parsableBitArray.skipBits(5);
                        } else {
                            for (int i27 = 0; i27 < i19; i27++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
                if (readBits3 == 2) {
                    parsableBitArray.skipBits(4);
                }
                if (readBits3 >= 6) {
                    parsableBitArray.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (readBits3 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                i26 = 3;
                if (readBits2 < 3) {
                    parsableBitArray.skipBit();
                }
            } else {
                i26 = 3;
            }
            if (i17 == 0 && readBits != i26) {
                parsableBitArray.skipBit();
            }
            if (i17 == 2 && (readBits == i26 || parsableBitArray.readBit())) {
                parsableBitArray.skipBits(6);
            }
            if (parsableBitArray.readBit() && parsableBitArray.readBits(6) == 1 && parsableBitArray.readBits(8) == 1) {
                str = "audio/eac3-joc";
            } else {
                str = "audio/eac3";
            }
        } else {
            parsableBitArray.skipBits(32);
            int readBits6 = parsableBitArray.readBits(2);
            ac3SyncframeSize = getAc3SyncframeSize(readBits6, parsableBitArray.readBits(6));
            parsableBitArray.skipBits(8);
            int readBits7 = parsableBitArray.readBits(3);
            if ((readBits7 & 1) != 0 && readBits7 != 1) {
                parsableBitArray.skipBits(2);
            }
            if ((readBits7 & 4) != 0) {
                parsableBitArray.skipBits(2);
            }
            if (readBits7 == 2) {
                parsableBitArray.skipBits(2);
            }
            i3 = SAMPLE_RATE_BY_FSCOD[readBits6];
            i16 = CHANNEL_COUNT_BY_ACMOD[readBits7] + (parsableBitArray.readBit() ? 1 : 0);
            i17 = -1;
            str = "audio/ac3";
            i18 = AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
        }
        return new Ac3SyncFrameInfo(str, i17, i16, i3, ac3SyncframeSize, i18);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        byte b16 = bArr[4];
        return getAc3SyncframeSize((b16 & 192) >> 6, b16 & 63);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        String str3;
        parsableByteArray.skipBytes(2);
        int i3 = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i16 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i16++;
        }
        if (((parsableByteArray.readUnsignedByte() & 30) >> 1) > 0 && (2 & parsableByteArray.readUnsignedByte()) != 0) {
            i16 += 2;
        }
        int i17 = i16;
        if (parsableByteArray.bytesLeft() > 0 && (parsableByteArray.readUnsignedByte() & 1) != 0) {
            str3 = "audio/eac3-joc";
        } else {
            str3 = "audio/eac3";
        }
        return Format.createAudioSampleFormat(str, str3, null, -1, -1, i17, i3, null, drmInitData, 0, str2);
    }

    public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int i3 = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i3 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i3 * 256;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && bArr[7] == -70) {
            return 40 << (bArr[8] & 7);
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        if (byteBuffer.getInt(byteBuffer.position() + 4) != -1167101192) {
            return 0;
        }
        return 40 << (byteBuffer.get(byteBuffer.position() + 8) & 7);
    }
}
