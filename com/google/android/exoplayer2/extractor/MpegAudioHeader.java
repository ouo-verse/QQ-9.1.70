package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MpegAudioHeader {
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;
    private static final String[] MIME_TYPE_BY_LAYER = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] SAMPLING_RATE_V1 = {44100, 48000, 32000};
    private static final int[] BITRATE_V1_L1 = {32, 64, 96, 128, 160, 192, 224, 256, 288, 320, g.CTRL_INDEX, MsgConstant.KRMFILETHUMBSIZE384, 416, TroopInfo.PAY_PRIVILEGE_ALL};
    private static final int[] BITRATE_V2_L1 = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    private static final int[] BITRATE_V1_L2 = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, MsgConstant.KRMFILETHUMBSIZE384};
    private static final int[] BITRATE_V1_L3 = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
    private static final int[] BITRATE_V2 = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    public static int getFrameSize(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        if ((i3 & (-2097152)) != -2097152 || (i16 = (i3 >>> 19) & 3) == 1 || (i17 = (i3 >>> 17) & 3) == 0 || (i18 = (i3 >>> 12) & 15) == 0 || i18 == 15 || (i19 = (i3 >>> 10) & 3) == 3) {
            return -1;
        }
        int i28 = SAMPLING_RATE_V1[i19];
        if (i16 == 2) {
            i28 /= 2;
        } else if (i16 == 0) {
            i28 /= 4;
        }
        int i29 = (i3 >>> 9) & 1;
        if (i17 == 3) {
            if (i16 == 3) {
                i27 = BITRATE_V1_L1[i18 - 1];
            } else {
                i27 = BITRATE_V2_L1[i18 - 1];
            }
            return (((i27 * 12000) / i28) + i29) * 4;
        }
        if (i16 == 3) {
            if (i17 == 2) {
                i26 = BITRATE_V1_L2[i18 - 1];
            } else {
                i26 = BITRATE_V1_L3[i18 - 1];
            }
        } else {
            i26 = BITRATE_V2[i18 - 1];
        }
        int i36 = TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR;
        if (i16 == 3) {
            return ((i26 * TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR) / i28) + i29;
        }
        if (i17 == 1) {
            i36 = DefaultOggSeeker.MATCH_RANGE;
        }
        return ((i36 * i26) / i28) + i29;
    }

    public static boolean populateHeader(int i3, MpegAudioHeader mpegAudioHeader) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        if ((i3 & (-2097152)) != -2097152 || (i16 = (i3 >>> 19) & 3) == 1 || (i17 = (i3 >>> 17) & 3) == 0 || (i18 = (i3 >>> 12) & 15) == 0 || i18 == 15 || (i19 = (i3 >>> 10) & 3) == 3) {
            return false;
        }
        int i37 = SAMPLING_RATE_V1[i19];
        if (i16 == 2) {
            i37 /= 2;
        } else if (i16 == 0) {
            i37 /= 4;
        }
        int i38 = i37;
        int i39 = (i3 >>> 9) & 1;
        if (i17 == 3) {
            if (i16 == 3) {
                i26 = BITRATE_V1_L1[i18 - 1];
            } else {
                i26 = BITRATE_V2_L1[i18 - 1];
            }
            i28 = (((i26 * 12000) / i38) + i39) * 4;
            i29 = 384;
        } else {
            int i46 = TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR;
            int i47 = gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION;
            if (i16 == 3) {
                if (i17 == 2) {
                    i26 = BITRATE_V1_L2[i18 - 1];
                } else {
                    i26 = BITRATE_V1_L3[i18 - 1];
                }
                i27 = (TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR * i26) / i38;
            } else {
                i26 = BITRATE_V2[i18 - 1];
                if (i17 == 1) {
                    i47 = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                }
                if (i17 == 1) {
                    i46 = DefaultOggSeeker.MATCH_RANGE;
                }
                i27 = (i46 * i26) / i38;
            }
            i28 = i27 + i39;
            i29 = i47;
        }
        String str = MIME_TYPE_BY_LAYER[3 - i17];
        if (((i3 >> 6) & 3) == 3) {
            i36 = 1;
        } else {
            i36 = 2;
        }
        mpegAudioHeader.setValues(i16, str, i28, i38, i36, i26 * 1000, i29);
        return true;
    }

    private void setValues(int i3, String str, int i16, int i17, int i18, int i19, int i26) {
        this.version = i3;
        this.mimeType = str;
        this.frameSize = i16;
        this.sampleRate = i17;
        this.channels = i18;
        this.bitrate = i19;
        this.samplesPerFrame = i26;
    }
}
