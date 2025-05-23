package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioEffectConfig {
    private int aiId;
    private boolean denoiseGain;
    private float[] features;
    private int index;
    private boolean mAutoGainEnable;
    private int mAutoGainMode;
    private float mAutoGainScale;
    private String param;
    private byte[] params;
    private String token;
    private final String TAG = "AudioEffectConfig";
    private int effectType = 0;
    private int reverbType = 0;
    private int voiceShiftType = 0;
    private boolean automaticGain = true;
    private int pitchShiftValue = 0;
    private byte[] noteBuf = null;
    private int[] mLyricTimes = null;
    private float reverbKtvScare = 0.5f;
    private float reverbStarScale0 = 0.5f;
    private float reverbStarScale1 = 0.5f;
    private float reverbDistantScale = 0.5f;
    private float reverbLvyingpengScale = 0.0f;
    private float reverbStudioScale = 0.0f;
    private float reverbChurchScale = 0.0f;
    private float reverbHallScale = 0.0f;
    private float reverbRoomScale = 0.0f;
    private float reverbOriginScale = 0.0f;
    private float reverbCDScale = 0.0f;
    private float reverbChangjiangScale = 0.0f;
    private float reverbBassScale = 0.0f;
    private float reverbParkScale = 0.0f;
    private float reverbLivehouseScale = 0.0f;
    private float reverbConcertScale = 0.0f;
    private float reverbSubwayScale = 0.0f;
    private float reverbCustomScale = 0.0f;
    private boolean isOneMixEnabled = false;
    private float oneMixVocVolume = 0.0f;
    private float oneMixObbVolume = 0.0f;
    private int denoiseLevel = 0;
    private int onemixReverbType = 0;
    private String oneMixParams = null;
    private String oneMixAnalyzeResult = "";
    private boolean isRealOneMix = true;
    private int equalizerType = 0;
    private float[] equalizerTypeParamValue = new float[10];
    private float darkOrBright = 0.5f;
    private boolean isLastDarkBrightOrEqualizer = false;
    private int plugStatus = 0;
    private final ConcurrentHashMap<Integer, Float> reverbGainMap = new ConcurrentHashMap<>();
    private boolean revertGainEnable = false;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioEffectConfig)) {
            return false;
        }
        AudioEffectConfig audioEffectConfig = (AudioEffectConfig) obj;
        if (audioEffectConfig.pitchShiftValue == this.pitchShiftValue && audioEffectConfig.reverbType == this.reverbType && audioEffectConfig.voiceShiftType == this.voiceShiftType && audioEffectConfig.denoiseGain == this.denoiseGain && audioEffectConfig.darkOrBright == this.darkOrBright && audioEffectConfig.isLastDarkBrightOrEqualizer == this.isLastDarkBrightOrEqualizer && audioEffectConfig.equalizerType == this.equalizerType) {
            float[] fArr = audioEffectConfig.equalizerTypeParamValue;
            float f16 = fArr[0];
            float[] fArr2 = this.equalizerTypeParamValue;
            if (f16 == fArr2[0] && fArr[1] == fArr2[1] && fArr[2] == fArr2[2] && fArr[3] == fArr2[3] && fArr[4] == fArr2[4] && fArr[5] == fArr2[5] && fArr[6] == fArr2[6] && fArr[7] == fArr2[7] && fArr[8] == fArr2[8] && fArr[9] == fArr2[9]) {
                return true;
            }
        }
        return false;
    }

    public int getAiId() {
        return this.aiId;
    }

    public int getAutoGainMode() {
        return this.mAutoGainMode;
    }

    public float getAutoGainScale() {
        return this.mAutoGainScale;
    }

    public float getDarkOrBright() {
        return this.darkOrBright;
    }

    public int getDenoiseLevel() {
        return this.denoiseLevel;
    }

    public int getEffectType() {
        return this.effectType;
    }

    public int getEqualizerType() {
        return this.equalizerType;
    }

    public float[] getEqualizerTypeParamValue() {
        return this.equalizerTypeParamValue;
    }

    public float[] getFeatures() {
        return this.features;
    }

    public int getIndex() {
        return this.index;
    }

    public int[] getLyricTimes() {
        return this.mLyricTimes;
    }

    public byte[] getNoteBuf() {
        return this.noteBuf;
    }

    public String getOneMixAnalyzeResult() {
        return this.oneMixAnalyzeResult;
    }

    public float getOneMixObbVolume() {
        return this.oneMixObbVolume;
    }

    public String getOneMixParams() {
        return this.oneMixParams;
    }

    public float getOneMixVocVolume() {
        return this.oneMixVocVolume;
    }

    public int getOnemixReverbType() {
        return this.onemixReverbType;
    }

    public String getParam() {
        return this.param;
    }

    public byte[] getParams() {
        return this.params;
    }

    public int getPitchShiftValue() {
        return this.pitchShiftValue;
    }

    public int getPlugStatus() {
        return this.plugStatus;
    }

    public float getReverbBassScale() {
        return this.reverbBassScale;
    }

    public float getReverbCDScale() {
        return this.reverbCDScale;
    }

    public float getReverbChangjiangScale() {
        return this.reverbChangjiangScale;
    }

    public float getReverbChurchScale() {
        return this.reverbChurchScale;
    }

    public float getReverbConcertScale() {
        return this.reverbConcertScale;
    }

    public float getReverbCustomScale() {
        return this.reverbCustomScale;
    }

    public float getReverbDistantScale() {
        return this.reverbDistantScale;
    }

    public boolean getReverbGainEnable() {
        return this.revertGainEnable;
    }

    public ConcurrentHashMap<Integer, Float> getReverbGainMap() {
        return this.reverbGainMap;
    }

    public float getReverbHallScale() {
        return this.reverbHallScale;
    }

    public float getReverbKtvScare() {
        return this.reverbKtvScare;
    }

    public float getReverbLivehouseScale() {
        return this.reverbLivehouseScale;
    }

    public float getReverbLvyingpengScale() {
        return this.reverbLvyingpengScale;
    }

    public float getReverbOriginScale() {
        return this.reverbOriginScale;
    }

    public float getReverbParkScale() {
        return this.reverbParkScale;
    }

    public float getReverbRoomScale() {
        return this.reverbRoomScale;
    }

    public float getReverbStarScale0() {
        return this.reverbStarScale0;
    }

    public float getReverbStarScale1() {
        return this.reverbStarScale1;
    }

    public float getReverbStudioScale() {
        return this.reverbStudioScale;
    }

    public float getReverbSubwayScale() {
        return this.reverbSubwayScale;
    }

    public int getReverbType() {
        return this.reverbType;
    }

    public String getToken() {
        return this.token;
    }

    public int getVoiceShiftType() {
        return this.voiceShiftType;
    }

    public int hashCode() {
        int i3;
        int i16 = (((((this.pitchShiftValue + 37) * 37) + this.reverbType) * 37) + this.voiceShiftType) * 37;
        if (this.denoiseGain) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        return ((i16 + i3) * 37) + this.equalizerType;
    }

    public boolean isAutoGainEnable() {
        return this.mAutoGainEnable;
    }

    public boolean isAutomaticGain() {
        return this.automaticGain;
    }

    public boolean isDenoiseGain() {
        return this.denoiseGain;
    }

    public boolean isLastDarkBrightOrEqualizer() {
        return this.isLastDarkBrightOrEqualizer;
    }

    public boolean isOneMixEnabled() {
        return this.isOneMixEnabled;
    }

    public boolean isRealOneMix() {
        return this.isRealOneMix;
    }

    public boolean ismAutoGainEnable() {
        return this.mAutoGainEnable;
    }

    public void setAiId(int i3) {
        this.aiId = i3;
    }

    public void setAutoGainEnable(boolean z16) {
        this.mAutoGainEnable = z16;
    }

    public void setAutoGainMode(int i3) {
        this.mAutoGainMode = i3;
    }

    public void setAutoGainScale(float f16) {
        this.mAutoGainScale = f16;
    }

    public void setAutomaticGain(boolean z16) {
        this.automaticGain = z16;
    }

    public void setDarkOrBright(float f16) {
        this.darkOrBright = f16;
    }

    public void setDenoiseGain(boolean z16) {
        this.denoiseGain = z16;
    }

    public void setDenoiseLevel(int i3) {
        this.denoiseLevel = i3;
    }

    public void setEffectType(int i3) {
        LogUtil.w("AudioEffectConfig: ", "setEffectType: " + i3);
        this.effectType = i3;
    }

    public void setEqualizerType(int i3) {
        this.equalizerType = i3;
    }

    public void setEqualizerTypeParamValue(float[] fArr) {
        if (fArr != null && fArr.length == 10) {
            for (int i3 = 0; i3 < 10; i3++) {
                this.equalizerTypeParamValue[i3] = fArr[i3];
            }
        }
    }

    public void setFeatures(float[] fArr) {
        this.features = fArr;
    }

    public void setIndex(int i3) {
        this.index = i3;
    }

    public void setLastDarkBrightOrEqualizer(boolean z16) {
        this.isLastDarkBrightOrEqualizer = z16;
    }

    public void setLyricTimes(int[] iArr) {
        this.mLyricTimes = iArr;
    }

    public void setNoteBuf(byte[] bArr) {
        this.noteBuf = bArr;
    }

    public void setOneMixAnalyzeResult(String str) {
        this.oneMixAnalyzeResult = str;
    }

    public void setOneMixEnabled(boolean z16) {
        this.isOneMixEnabled = z16;
    }

    public void setOneMixObbVolume(float f16) {
        this.oneMixObbVolume = f16;
    }

    public void setOneMixParams(String str) {
        this.oneMixParams = str;
    }

    public void setOneMixVocVolume(float f16) {
        this.oneMixVocVolume = f16;
    }

    public void setOnemixReverbType(int i3) {
        this.onemixReverbType = i3;
    }

    public void setParam(String str) {
        this.param = str;
    }

    public void setParams(byte[] bArr) {
        this.params = bArr;
    }

    public void setPitchShiftValue(int i3) {
        this.pitchShiftValue = i3;
    }

    public void setPlugStatus(int i3) {
        this.plugStatus = i3;
    }

    public void setRealOneMix(boolean z16) {
        this.isRealOneMix = z16;
    }

    public void setReverbBassScale(float f16) {
        this.reverbBassScale = f16;
    }

    public void setReverbCDScale(float f16) {
        this.reverbCDScale = f16;
    }

    public void setReverbChangjiangScale(float f16) {
        this.reverbChangjiangScale = f16;
    }

    public void setReverbChurchScale(float f16) {
        this.reverbChurchScale = f16;
    }

    public void setReverbConcertScale(float f16) {
        this.reverbConcertScale = f16;
    }

    public void setReverbCustomScale(float f16) {
        this.reverbCustomScale = f16;
    }

    public void setReverbDistantScale(float f16) {
        this.reverbDistantScale = f16;
    }

    public void setReverbGainEnable(boolean z16) {
        LogUtil.d("AudioEffectConfig", "setReverbGainEnable : " + z16);
        this.revertGainEnable = z16;
    }

    public void setReverbGainMap(ConcurrentHashMap<Integer, Float> concurrentHashMap) {
        LogUtil.d("AudioEffectConfig", "setReverbGainMap");
        if (concurrentHashMap != null) {
            this.reverbGainMap.putAll(concurrentHashMap);
        }
    }

    public void setReverbHallScale(float f16) {
        this.reverbHallScale = f16;
    }

    public void setReverbKtvScare(float f16) {
        this.reverbKtvScare = f16;
    }

    public void setReverbLivehouseScale(float f16) {
        this.reverbLivehouseScale = f16;
    }

    public void setReverbLvyingpengScale(float f16) {
        this.reverbLvyingpengScale = f16;
    }

    public void setReverbOriginScale(float f16) {
        this.reverbOriginScale = f16;
    }

    public void setReverbParkScale(float f16) {
        this.reverbParkScale = f16;
    }

    public void setReverbRoomScale(float f16) {
        this.reverbRoomScale = f16;
    }

    public void setReverbStarScale0(float f16) {
        this.reverbStarScale0 = f16;
    }

    public void setReverbStarScale1(float f16) {
        this.reverbStarScale1 = f16;
    }

    public void setReverbStudioScale(float f16) {
        this.reverbStudioScale = f16;
    }

    public void setReverbSubwayScale(float f16) {
        this.reverbSubwayScale = f16;
    }

    public void setReverbType(int i3) {
        LogUtil.w("AudioEffectConfig: ", "setReverbType: " + i3);
        this.reverbType = i3;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setVoiceShiftType(int i3) {
        this.voiceShiftType = i3;
    }

    public void setmAutoGainEnable(boolean z16) {
        this.mAutoGainEnable = z16;
    }

    public String toString() {
        int length;
        StringBuilder sb5 = new StringBuilder("AudioEffectConfig:[");
        sb5.append("pitchShiftValue=");
        sb5.append(this.pitchShiftValue);
        sb5.append(", voiceShiftType=");
        sb5.append(this.voiceShiftType);
        sb5.append(", effectType=");
        sb5.append(this.effectType);
        sb5.append(", denoiseGain=");
        sb5.append(this.denoiseGain);
        sb5.append(", noteBuf:");
        byte[] bArr = this.noteBuf;
        if (bArr == null) {
            length = -1;
        } else {
            length = bArr.length;
        }
        sb5.append(length);
        sb5.append(", equalizerType=");
        sb5.append(this.equalizerType);
        sb5.append(", reverbKtvScare=");
        sb5.append(this.reverbKtvScare);
        sb5.append(", reverbStarScale0=");
        sb5.append(this.reverbStarScale0);
        sb5.append(", reverbStarScale1=");
        sb5.append(this.reverbStarScale1);
        sb5.append(", reverbDistantScale=");
        sb5.append(this.reverbDistantScale);
        sb5.append(", darkOrBright=");
        sb5.append(this.darkOrBright);
        if (this.equalizerType == 1) {
            sb5.append(", equalizerTypeParamValue=[");
            int i3 = 0;
            while (true) {
                float[] fArr = this.equalizerTypeParamValue;
                if (i3 >= fArr.length) {
                    break;
                }
                sb5.append(fArr[i3]);
                if (i3 < this.equalizerTypeParamValue.length - 1) {
                    sb5.append(",");
                }
                i3++;
            }
            sb5.append("]");
        }
        sb5.append("]");
        return sb5.toString();
    }
}
