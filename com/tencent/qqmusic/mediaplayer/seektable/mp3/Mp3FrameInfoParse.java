package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes23.dex */
class Mp3FrameInfoParse {
    private static final int DECODE_ERROR_IO_READ = -3;
    private static final int DECODE_ERROR_MEMORY_ALLOC = -2;
    private static final int DECODE_ERROR_SUCCESS = 0;
    private static final int DECODE_FAIL = -1;
    private static final String TAG = "Mp3FrameInfoParse";
    public static final int VBR_TYPE_CBR = 0;
    public static final int VBR_TYPE_VBRI = 1;
    public static final int VBR_TYPE_XING = 2;
    private static final int[][][] BitrateTable = {new int[][]{new int[]{0, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, g.CTRL_INDEX, MsgConstant.KRMFILETHUMBSIZE384, 416, TroopInfo.PAY_PRIVILEGE_ALL}, new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, MsgConstant.KRMFILETHUMBSIZE384}, new int[]{0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320}}, new int[][]{new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}}};
    private static final int[][] SAMPLE_RATE_TABLE = {new int[]{11025, 12000, 8000}, new int[]{0, 0, 0}, new int[]{22050, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 16000}, new int[]{44100, 48000, 32000}};
    private static final int[][] SAMPLE_PER_FRAME = {new int[]{MsgConstant.KRMFILETHUMBSIZE384, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION}, new int[]{MsgConstant.KRMFILETHUMBSIZE384, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT}, new int[]{MsgConstant.KRMFILETHUMBSIZE384, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT}};

    /* loaded from: classes23.dex */
    public static class Mp3Info {
        int channels = 0;
        int bit_rate = 0;
        long sample_rate = 0;
        long duration = 0;
        int isVbr = 0;
        int idv2Size = 0;
        long firstFramePosition = 0;
        long firstFrameSize = 0;
        int mpeg_version = 0;
        int layer = 0;
        long lengthInFrames = 0;
        long fileLengthInBytes = 0;
        long[] toc_table = null;
        int flag_value = 0;
        int VBRType = 0;
        int entry_count = 0;
        int entry_size = 0;
        int scale_factor = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean IsMp3Header(TrackPositionDataSource trackPositionDataSource, byte[] bArr, int i3, int i16, Mp3Info mp3Info) throws IOException {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        if (bArr == null || mp3Info == null) {
            return false;
        }
        byte b16 = bArr[i16 + 1];
        int i37 = (b16 >> 3) & 3;
        if (1 == i37 || (i17 = (b16 >> 1) & 3) == 0) {
            return false;
        }
        int i38 = 4 - i17;
        byte b17 = bArr[i16 + 2];
        int i39 = (b17 >> 4) & 15;
        if (15 == i39 || 3 == (i18 = (b17 >> 2) & 3)) {
            return false;
        }
        int i46 = (bArr[i16 + 3] >> 6) & 3;
        int i47 = (b17 >> 1) & 1;
        if (i37 == 3) {
            i19 = 0;
        } else {
            i19 = 1;
        }
        if (1 == i38) {
            i27 = (((BitrateTable[i19][0][i39] * 12000) / SAMPLE_RATE_TABLE[i37][i18]) + i47) << 2;
        } else {
            if (2 == i38) {
                i26 = (BitrateTable[i19][1][i39] * TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR) / SAMPLE_RATE_TABLE[i37][i18];
            } else {
                i26 = (BitrateTable[i19][2][i39] * TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR) / (SAMPLE_RATE_TABLE[i37][i18] << i19);
            }
            i27 = i26 + i47;
        }
        if (i27 > 0) {
            long curPosition = trackPositionDataSource.getCurPosition();
            long j3 = i27;
            if (trackPositionDataSource.seek((curPosition - i3) + i16 + j3) < 0) {
                return false;
            }
            byte[] bArr2 = new byte[4];
            if (trackPositionDataSource.read(bArr2, 4) == -1) {
                return false;
            }
            int readInt = Mp3DecodeBase.readInt(bArr, i16, 4);
            int readInt2 = Mp3DecodeBase.readInt(bArr2, 4);
            trackPositionDataSource.seek(curPosition);
            if (readInt != 0 && readInt2 != 0 && (readInt & (-128000)) == ((-128000) & readInt2)) {
                Logger.i(TAG, "FirstFrameSize = " + i27);
                mp3Info.firstFrameSize = j3;
                if (i37 == 3) {
                    i28 = 2;
                } else {
                    i28 = 2;
                    if (i37 == 2) {
                        i29 = 1;
                    } else if (i37 == 0) {
                        i29 = 2;
                    }
                    mp3Info.mpeg_version = i29;
                    mp3Info.layer = i38;
                    mp3Info.sample_rate = SAMPLE_RATE_TABLE[i37][i18];
                    mp3Info.bit_rate = BitrateTable[i19][i38 - 1][i39];
                    if (i46 != 3) {
                        i36 = 1;
                    } else {
                        i36 = i28;
                    }
                    mp3Info.channels = i36;
                    return true;
                }
                i29 = 0;
                mp3Info.mpeg_version = i29;
                mp3Info.layer = i38;
                mp3Info.sample_rate = SAMPLE_RATE_TABLE[i37][i18];
                mp3Info.bit_rate = BitrateTable[i19][i38 - 1][i39];
                if (i46 != 3) {
                }
                mp3Info.channels = i36;
                return true;
            }
            return false;
        }
        mp3Info.firstFrameSize = -1L;
        return false;
    }

    public static int parseFrameInfo(TrackPositionDataSource trackPositionDataSource, Mp3Info mp3Info) throws IOException {
        int i3;
        int i16 = -1;
        if (trackPositionDataSource == null) {
            return -1;
        }
        byte[] bArr = new byte[1024];
        if (trackPositionDataSource.read(bArr, 1024) < 1024) {
            return -2;
        }
        long j3 = 0;
        if (Mp3DecodeBase.hasId3v2(bArr, 4)) {
            Logger.i(TAG, "hasId3v2");
            skipId3v2(trackPositionDataSource, bArr, mp3Info);
        } else {
            trackPositionDataSource.seek(0L);
        }
        long size = trackPositionDataSource.getSize();
        long j16 = mp3Info.idv2Size;
        if (j16 > 0 && size > j16) {
            size -= j16;
        }
        int i17 = 0;
        while (true) {
            long curPosition = trackPositionDataSource.getCurPosition();
            if (j16 > 0) {
                curPosition -= j16;
            }
            if (curPosition >= size / 10) {
                return -3;
            }
            if (i17 >= 3) {
                i3 = i17;
                if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() - 3) < j3) {
                    return -3;
                }
            } else {
                i3 = i17;
            }
            int read = trackPositionDataSource.read(bArr, 1024);
            if (read == i16) {
                mp3Info.firstFramePosition = -1L;
                return -3;
            }
            i17 = i3 + read;
            for (int i18 = 0; i18 + 4 <= read; i18++) {
                if (255 == (bArr[i18] & 255) && 224 == (bArr[i18 + 1] & 224) && IsMp3Header(trackPositionDataSource, bArr, 1024, i18, mp3Info)) {
                    mp3Info.firstFramePosition = ((mp3Info.idv2Size + i17) - read) + i18;
                    Logger.i(TAG, "FirstFramePos = " + mp3Info.firstFramePosition);
                    if (trackPositionDataSource.seek(mp3Info.firstFramePosition) < 0) {
                        return -1;
                    }
                    boolean parseVBRFrameInfo = parseVBRFrameInfo(trackPositionDataSource, mp3Info);
                    if (trackPositionDataSource.seek(0L) < 0 || !parseVBRFrameInfo) {
                        return -1;
                    }
                    return 0;
                }
                j3 = 0;
            }
            i16 = -1;
        }
    }

    private static boolean parseVBRFrameInfo(TrackPositionDataSource trackPositionDataSource, Mp3Info mp3Info) throws IOException {
        long j3;
        if (trackPositionDataSource == null || mp3Info == null) {
            return false;
        }
        long j16 = mp3Info.sample_rate;
        int i3 = mp3Info.channels;
        byte[] bArr = new byte[1024];
        if (mp3Info.mpeg_version == 0) {
            if (i3 != 1) {
                j3 = 36;
            }
            j3 = 21;
        } else {
            if (i3 == 1) {
                j3 = 13;
            }
            j3 = 21;
        }
        if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() + j3) < 0 || trackPositionDataSource.read(bArr, 1024) < 1024) {
            return false;
        }
        if (Mp3DecodeBase.isXingVBRheader(bArr, 4)) {
            Logger.i(TAG, "is Xing VBR");
            mp3Info.VBRType = 2;
            mp3Info.isVbr = 1;
            parseXingInfo(bArr, j16, mp3Info);
        } else {
            if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() - (j3 + 1024)) < 0 || trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() + 36) < 0 || trackPositionDataSource.read(bArr, 1024) < 1024) {
                return false;
            }
            if (Mp3DecodeBase.isVBRIVBRHeader(bArr, 4)) {
                Logger.i(TAG, "is VBRI VBR");
                mp3Info.VBRType = 1;
                mp3Info.isVbr = 1;
                parseVBRIInfo(mp3Info, bArr, j16);
            } else {
                Logger.i(TAG, "is CBR");
                mp3Info.VBRType = 0;
                long size = trackPositionDataSource.getSize();
                if (mp3Info.fileLengthInBytes <= 0) {
                    mp3Info.fileLengthInBytes = size;
                }
                mp3Info.duration = (((float) (mp3Info.fileLengthInBytes - mp3Info.idv2Size)) * 8.0f) / mp3Info.bit_rate;
            }
        }
        return true;
    }

    private static void parseVBRIInfo(Mp3Info mp3Info, byte[] bArr, long j3) {
        int i3;
        long[] jArr;
        int readUnsignedInt24;
        if (bArr != null && mp3Info != null) {
            long readLong = Mp3DecodeBase.readLong(bArr, 10, 4);
            mp3Info.fileLengthInBytes = readLong;
            long readLong2 = Mp3DecodeBase.readLong(bArr, 14, 4);
            if (readLong2 > 0 && j3 > 0) {
                int i16 = mp3Info.mpeg_version;
                int i17 = mp3Info.layer - 1;
                mp3Info.lengthInFrames = readLong2;
                mp3Info.duration = (long) ((((readLong2 * SAMPLE_PER_FRAME[i16][i17]) * 1.0d) / j3) * 1000.0d);
            }
            int readShort = Mp3DecodeBase.readShort(bArr, 18, 2);
            int readShort2 = Mp3DecodeBase.readShort(bArr, 20, 2);
            int readShort3 = Mp3DecodeBase.readShort(bArr, 22, 2);
            if (readShort > 0 && readShort2 > 0) {
                int i18 = readShort + 1;
                long[] jArr2 = new long[i18];
                long j16 = mp3Info.firstFramePosition;
                int i19 = 0;
                if (j16 > 0) {
                    i19 = (int) (0 + j16);
                }
                long j17 = mp3Info.firstFrameSize;
                if (j17 > 0) {
                    i19 = (int) (i19 + j17);
                }
                int i26 = 24;
                int i27 = 1;
                while (true) {
                    if (i27 >= i18) {
                        break;
                    }
                    if (readShort3 == 1) {
                        int readByte = Mp3DecodeBase.readByte(bArr, i26, 1);
                        i26++;
                        jArr = jArr2;
                        i3 = readByte;
                    } else {
                        if (readShort3 == 2) {
                            readUnsignedInt24 = Mp3DecodeBase.readShort(bArr, i26, 2);
                            i26 += 2;
                        } else if (readShort3 == 3) {
                            readUnsignedInt24 = Mp3DecodeBase.readUnsignedInt24(bArr, i26, 3);
                            i26 += 3;
                        } else if (readShort3 == 4) {
                            int readInt = Mp3DecodeBase.readInt(bArr, i26, 4);
                            i26 += 4;
                            jArr = jArr2;
                            i3 = readInt;
                        } else {
                            i3 = -1;
                            jArr = null;
                        }
                        jArr = jArr2;
                        i3 = readUnsignedInt24;
                    }
                    if (i3 < 0) {
                        jArr2 = jArr;
                        break;
                    }
                    i19 += i3 * readShort2;
                    if (i19 >= readLong) {
                        i19 = (int) readLong;
                    }
                    jArr[i27] = i19;
                    i27++;
                    jArr2 = jArr;
                }
                mp3Info.entry_count = readShort;
                mp3Info.entry_size = readShort3;
                mp3Info.scale_factor = readShort2;
                mp3Info.toc_table = jArr2;
            }
        }
    }

    private static void parseXingInfo(byte[] bArr, long j3, Mp3Info mp3Info) {
        long[] jArr;
        if (bArr != null && mp3Info != null) {
            int readInt = Mp3DecodeBase.readInt(bArr, 4, 4);
            int i3 = 8;
            if ((readInt & 1) == 1) {
                long readLong = Mp3DecodeBase.readLong(bArr, 8, 4) - 1;
                if (readLong > 0 && j3 > 0) {
                    int i16 = mp3Info.mpeg_version;
                    int i17 = mp3Info.layer - 1;
                    mp3Info.lengthInFrames = readLong;
                    mp3Info.duration = (long) ((((readLong * SAMPLE_PER_FRAME[i16][i17]) * 1.0d) / j3) * 1000.0d);
                }
                i3 = 12;
            }
            if ((readInt & 2) == 2) {
                mp3Info.fileLengthInBytes = Mp3DecodeBase.readLong(bArr, i3, 4);
                i3 += 4;
            }
            if ((readInt & 4) == 4) {
                jArr = new long[100];
                for (int i18 = 0; i18 < 100; i18++) {
                    jArr[i18] = bArr[i18 + i3] & 255;
                }
            } else {
                jArr = null;
            }
            if (readInt > 0 && jArr != null) {
                mp3Info.toc_table = jArr;
                mp3Info.flag_value = readInt;
            }
        }
    }

    private static void skipId3v2(TrackPositionDataSource trackPositionDataSource, byte[] bArr, Mp3Info mp3Info) throws IOException {
        int i3;
        boolean z16;
        if (trackPositionDataSource != null && bArr != null && bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            int i16 = ((bArr[6] & Byte.MAX_VALUE) << 21) + ((bArr[7] & Byte.MAX_VALUE) << 14) + ((bArr[8] & Byte.MAX_VALUE) << 7) + (bArr[9] & Byte.MAX_VALUE);
            if ((bArr[5] & RegisterType.UNINIT_REF) != 0) {
                i3 = i16 + 20;
                z16 = true;
            } else {
                i3 = i16 + 10;
                z16 = false;
            }
            if (trackPositionDataSource.seek(i3) < 0) {
                return;
            }
            if (!z16) {
                byte[] bArr2 = new byte[1];
                int read = trackPositionDataSource.read(bArr2, 1);
                while (bArr2[0] == 0 && read == 1) {
                    i3++;
                    read = trackPositionDataSource.read(bArr2, 1);
                }
            }
            mp3Info.idv2Size = i3;
            Logger.i(TAG, "id3V2 Size: " + mp3Info.idv2Size);
            trackPositionDataSource.seek((long) i3);
        }
    }
}
