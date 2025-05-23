package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;

/* loaded from: classes23.dex */
class MP3Header {
    public static final int MPEG1 = 3;
    public static final int MPEG2 = 2;
    public static final int MPEG25 = 0;
    private int bitrate_index;
    private int framesize;
    private int layer;
    private int lsf;
    private int mode;
    private int mode_extension;
    private int padding;
    private int protection_bit;
    private int sampling_frequency;
    private int sideinfosize;
    private int verID;
    private int[][][] bitrate = {new int[][]{new int[]{0, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, g.CTRL_INDEX, MsgConstant.KRMFILETHUMBSIZE384, 416, TroopInfo.PAY_PRIVILEGE_ALL}, new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, MsgConstant.KRMFILETHUMBSIZE384}, new int[]{0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320}}, new int[][]{new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}}};
    private int[][] samplingRate = {new int[]{11025, 12000, 8000, 0}, new int[]{0, 0, 0, 0}, new int[]{22050, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 16000, 0}, new int[]{44100, 48000, 32000, 0}};

    public void decode(int i3) {
        int i16;
        int i17 = (i3 >> 19) & 3;
        this.verID = i17;
        int i18 = 4 - ((i3 >> 17) & 3);
        this.layer = i18;
        this.protection_bit = (i3 >> 16) & 1;
        int i19 = (i3 >> 12) & 15;
        this.bitrate_index = i19;
        int i26 = (i3 >> 10) & 3;
        this.sampling_frequency = i26;
        int i27 = (i3 >> 9) & 1;
        this.padding = i27;
        int i28 = (i3 >> 6) & 3;
        this.mode = i28;
        this.mode_extension = (i3 >> 4) & 3;
        if (i17 == 3) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        this.lsf = i16;
        if (i18 != 1) {
            if (i18 != 2) {
                if (i18 == 3) {
                    int i29 = this.bitrate[i16][2][i19] * TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR;
                    this.framesize = i29;
                    this.framesize = (i29 / (this.samplingRate[i17][i26] << i16)) + i27;
                    int i36 = 17;
                    if (i17 == 3) {
                        if (i28 != 3) {
                            i36 = 32;
                        }
                        this.sideinfosize = i36;
                        return;
                    } else {
                        if (i28 == 3) {
                            i36 = 9;
                        }
                        this.sideinfosize = i36;
                        return;
                    }
                }
                return;
            }
            int i37 = this.bitrate[i16][1][i19] * TVKCommonErrorCodeUtil.CODE.LIVE.CGI_UNKONWN_ERR;
            this.framesize = i37;
            this.framesize = (i37 / this.samplingRate[i17][i26]) + i27;
            return;
        }
        int i38 = this.bitrate[i16][0][i19] * 12000;
        this.framesize = i38;
        this.framesize = ((i38 / this.samplingRate[i17][i26]) + i27) << 2;
    }

    public int getFrameSize() {
        return this.framesize;
    }

    public void initialize() {
        this.framesize = 0;
        this.sideinfosize = 0;
        this.layer = 0;
        this.verID = 1;
    }

    public boolean isProtected() {
        if (this.protection_bit == 0) {
            return true;
        }
        return false;
    }
}
