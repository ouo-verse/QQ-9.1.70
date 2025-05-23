package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioEffectChain {
    public static final int SCENE_DEFAULT = 0;
    public static final int SCENE_ONEMIX_ANALYZE = 1;
    private static final String TAG = "AudioEffectChain";
    private long nativeHandle;
    private static volatile boolean mIsLoaded = AudiobaseContext.loadLibrary();
    public static final Integer ID_DENOISE = 1000;
    public static final Integer ID_GAIN = 1001;
    public static final Integer ID_HYBIRD = 1002;
    private boolean mIsValid = false;
    private final int mCapacity = 8192;
    private final ByteBuffer mBuffer = ByteBuffer.allocateDirect(8192);
    private final ByteBuffer mObbBuffer = ByteBuffer.allocateDirect(8192);
    private final ByteBuffer mAnalyseBuffer = ByteBuffer.allocateDirect(8192);
    private final ConcurrentHashMap<Integer, Float> reverbGainMap = new ConcurrentHashMap<>();
    private boolean revertGainEnable = false;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public @interface ENV_STAGE_TYPE {
        public static final int STAGE_PREVIEW = 1;
        public static final int STAGE_PRODUCT = 2;
        public static final int STAGE_RECORD = 0;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public @interface NEW_EFFECT_REVERB_SCALE_TYPE {
        public static final int kParamChangjiangScale = 10;
        public static final int kParamChurchScale = 5;
        public static final int kParamConcertScale = 11;
        public static final int kParamConfigMd5hex = 18;
        public static final int kParamCount = 21;
        public static final int kParamCustomScale = 20;
        public static final int kParamDeepmusicScale = 9;
        public static final int kParamEffectCustom = 19;
        public static final int kParamHallScale = 6;
        public static final int kParamLivehouseScale = 12;
        public static final int kParamLuyinpengScale = 3;
        public static final int kParamOnemixReverbType = 15;
        public static final int kParamOnemixStrategy = 16;
        public static final int kParamOriginScale = 8;
        public static final int kParamParkScale = 14;
        public static final int kParamRoomScale = 7;
        public static final int kParamSceneConfig = 17;
        public static final int kParamStudioScale = 4;
        public static final int kParamSubwayScale = 13;
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public @interface PROCESSOR_PLUG_TYPE {
        public static final int Plug_Count = 2;
        public static final int Plug_Plugged = 0;
        public static final int Plug_Unplugged = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Scene {
    }

    public static synchronized boolean checkEffectJsonAvailable(String str) {
        boolean native_checkConfigJsonAvailable;
        synchronized (AudioEffectChain.class) {
            native_checkConfigJsonAvailable = native_checkConfigJsonAvailable(str);
        }
        return native_checkConfigJsonAvailable;
    }

    private native int native_addEffectJson(String str);

    private native int native_audioEffectEnvPlugType(@PROCESSOR_PLUG_TYPE int i3);

    private native int native_audioEffectEnvStageType(@ENV_STAGE_TYPE int i3);

    private native int native_audioEffectProcessAnalyzeProcess(ByteBuffer byteBuffer, int i3);

    private native int native_audioEffectProcessReset(double d16);

    private native int native_audioEffectReverbScale(@NEW_EFFECT_REVERB_SCALE_TYPE int i3, float f16);

    private static native boolean native_checkConfigJsonAvailable(String str);

    private native float native_getEqualizerParamValue(int i3);

    private native int native_getEqualizerType();

    private native boolean native_getEqulizerEnabled();

    private native float native_getOneMixAccVolume(float f16);

    private native String native_getOneMixAnalyzeResult();

    private native int native_getOneMixResult();

    private native float native_getOneMixVocVolume(float f16);

    private native boolean native_getReverb2Enabled();

    private native float native_getReverb2ParamValue(int i3);

    private native int native_getReverb2TypeId();

    private native boolean native_getVoiceShiftEnabled();

    private native int native_getVoiceShiftType();

    private native int native_init(int i3, int i16, byte[] bArr, int i17, boolean z16, int[] iArr, int i18);

    private native int native_oneMixAnalyzeFinish();

    private native int native_oneMixAnalyzeFinish2();

    private native int native_oneMixAnalyzeInit(int i3, int i16, int[] iArr, byte[] bArr, byte[] bArr2, int i17);

    private native int native_oneMixAnalyzeInit2(int i3, int i16);

    private native int native_oneMixAnalyzeProcess(byte[] bArr, int i3);

    private native int native_oneMixAnalyzeProcess2(byte[] bArr, int i3);

    private native int native_process(ByteBuffer byteBuffer, int i3);

    private native int native_processAi(ByteBuffer byteBuffer, int i3);

    private native int native_processObb(ByteBuffer byteBuffer, int i3, int i16);

    private native int native_processObbNewChain(ByteBuffer byteBuffer, int i3);

    private native int native_processPostMix(ByteBuffer byteBuffer, int i3);

    private native int native_processPreMix();

    private native int native_release();

    private native void native_reset();

    private native int native_resetOneMixAnalyze();

    private native boolean native_seekDebugSavePosition(int i3);

    private native boolean native_setAgcEnabled(boolean z16);

    private native int native_setAiEffect(int i3, int i16, float[] fArr);

    private native boolean native_setAutoGainScale(int i3, float f16);

    private native boolean native_setDebugDump();

    private native boolean native_setDebugSaveEnable(boolean z16, String str);

    private native boolean native_setDebugTimeEnable(boolean z16);

    private native boolean native_setEqualizerEnabled(boolean z16);

    private native boolean native_setEqualizerParamValue(int i3, float f16);

    private native boolean native_setEqualizerTypeId(int i3);

    private native boolean native_setIsRealOneMix(boolean z16);

    private native boolean native_setNoiseGateEnabled(boolean z16);

    private native boolean native_setNsEnabled(boolean z16);

    private native boolean native_setNsLevel(int i3);

    private native boolean native_setOneMixAnalyeResult(String str);

    private native int native_setOneMixEffectType(int i3);

    private native boolean native_setOneMixEnabled(boolean z16);

    private native boolean native_setPluggedEnv(int i3);

    private native boolean native_setReverb2Enabled(boolean z16);

    private native boolean native_setReverb2Json(int i3, String str, int i16);

    private native boolean native_setReverb2ParamValue(int i3, float f16);

    private native boolean native_setReverb2TypeId(int i3, int i16);

    private native boolean native_setReverbGain(int i3, float f16);

    private native boolean native_setReverbGainEnable(boolean z16);

    private native boolean native_setReverbGainType(int i3);

    private native boolean native_setVoiceShiftEnabled(boolean z16);

    private native boolean native_setVoiceShiftKeyShift(int i3);

    private native boolean native_setVoiceShiftType(int i3);

    private native void native_switchRebuildEffectChainBlock(boolean z16);

    public synchronized void NewChainReset(double d16) {
        LogUtil.d(TAG, "NewChainFun, NewChainReset");
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsInited == false");
        } else {
            native_audioEffectProcessReset(d16);
        }
    }

    public synchronized int addEffectjson(String str) {
        LogUtil.d(TAG, "addEffectjson");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return -1;
        }
        return native_addEffectJson(str);
    }

    public synchronized float[] getEqualizerParamValue(int i3) {
        LogUtil.i(TAG, "getEqualizerParamValue: paramType=" + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return null;
        }
        native_setEqualizerTypeId(i3);
        float[] fArr = new float[10];
        for (int i16 = 0; i16 < 10; i16++) {
            fArr[i16] = native_getEqualizerParamValue(AudioEffectConstant.EqualizerParamBandId[i16]);
        }
        return fArr;
    }

    public synchronized float getOneMixAccVolume(float f16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1.0f;
        }
        LogUtil.i(TAG, "oneMix: getOneMixAccVolume");
        return native_getOneMixAccVolume(f16);
    }

    public synchronized String getOneMixAnalyzeResult() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return "";
        }
        return native_getOneMixAnalyzeResult();
    }

    public synchronized int getOneMixResult() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        int native_getOneMixResult = native_getOneMixResult();
        LogUtil.i(TAG, "getOneMixResult result is " + native_getOneMixResult);
        return native_getOneMixResult;
    }

    public synchronized float getOneMixVocVolume(float f16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1.0f;
        }
        LogUtil.i(TAG, "oneMix: getOneMixVocVolume");
        return native_getOneMixVocVolume(f16);
    }

    @Nullable
    public synchronized Float getReverbGain(int i3) {
        if (!this.revertGainEnable) {
            return null;
        }
        return this.reverbGainMap.get(Integer.valueOf(i3));
    }

    public synchronized int getReverbId() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return 0;
        }
        return native_getReverb2TypeId();
    }

    public synchronized float getReverbParamValue(int i3) {
        LogUtil.i(TAG, "getReverbParamValue -> paramType = " + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return 0.0f;
        }
        float native_getReverb2ParamValue = native_getReverb2ParamValue(i3);
        LogUtil.i(TAG, "getReverbParamValue: result=" + native_getReverb2ParamValue);
        return native_getReverb2ParamValue;
    }

    public int init(int i3, int i16, byte[] bArr) {
        return init(i3, i16, bArr, false, null);
    }

    public synchronized int oneMixAnalyzeFinish() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        LogUtil.i(TAG, "oneMix: oneMixAnalyzeFinish");
        return native_oneMixAnalyzeFinish();
    }

    public synchronized int oneMixAnalyzeFinish2() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        LogUtil.i(TAG, "oneMix: oneMixAnalyzeFinish2");
        return native_oneMixAnalyzeFinish2();
    }

    public synchronized int oneMixAnalyzeInit(int i3, int i16, int[] iArr, byte[] bArr, byte[] bArr2, int i17) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        LogUtil.i(TAG, String.format("oneMix: oneMixAnalyzeInit,sampleRate:%d,channels:%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        return native_oneMixAnalyzeInit(i3, i16, iArr, bArr, bArr2, i17);
    }

    public synchronized int oneMixAnalyzeInit2(int i3, int i16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        LogUtil.i(TAG, "oneMix: oneMixAnalyzeInit2");
        return native_oneMixAnalyzeInit2(i3, i16);
    }

    public synchronized int oneMixAnalyzeProcess(byte[] bArr, int i3) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        return native_oneMixAnalyzeProcess(bArr, i3);
    }

    public synchronized int oneMixAnalyzeProcess2(byte[] bArr, int i3) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        return native_oneMixAnalyzeProcess2(bArr, i3);
    }

    public synchronized int process(ByteBuffer byteBuffer, int i3) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        return native_process(byteBuffer, i3);
    }

    public synchronized int processAi(ByteBuffer byteBuffer, int i3) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        return native_processAi(byteBuffer, i3);
    }

    public synchronized int processObb(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < i3) {
            this.mBuffer.clear();
            int min = Math.min(8192, i3 - i18);
            this.mBuffer.put(bArr, i18, min);
            int native_processObb = native_processObb(this.mBuffer, min, i17);
            if (native_processObb >= 0) {
                this.mBuffer.flip();
                this.mBuffer.get(bArr2, i18, min);
            } else {
                LogUtil.w(TAG, "as failed to reduce the noise, copy the source: " + native_processObb);
                System.arraycopy(bArr, i18, bArr2, i18, min);
            }
            i18 += min;
            i19 = native_processObb;
        }
        return i19;
    }

    public synchronized int processObbNewChain(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsInited == null");
            return -1;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            this.mObbBuffer.clear();
            int min = Math.min(8192, i3 - i17);
            this.mObbBuffer.put(bArr, i17, min);
            int native_processObbNewChain = native_processObbNewChain(this.mObbBuffer, min);
            if (native_processObbNewChain >= 0) {
                this.mObbBuffer.flip();
                this.mObbBuffer.get(bArr2, i17, min);
            } else {
                LogUtil.w(TAG, "processObbNewChain failure:code " + native_processObbNewChain);
                System.arraycopy(bArr, i17, bArr2, i17, min);
            }
            i17 += min;
            i18 = native_processObbNewChain;
        }
        return i18;
    }

    public synchronized int processPostMix(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return -1;
        }
        int i17 = 0;
        int i18 = i3;
        while (i17 < i3) {
            this.mBuffer.clear();
            int min = Math.min(8192, i3 - i17);
            this.mBuffer.put(bArr, i17, min);
            int native_processPostMix = native_processPostMix(this.mBuffer, min);
            if (native_processPostMix >= 0) {
                this.mBuffer.flip();
                this.mBuffer.get(bArr2, i17, min);
            } else {
                LogUtil.w(TAG, "process failed, copy the source: " + native_processPostMix);
                System.arraycopy(bArr, i17, bArr2, i17, min);
            }
            i17 += min;
            i18 = native_processPostMix;
        }
        return i18;
    }

    public synchronized void release() {
        LogUtil.d(TAG, "release");
        if (!this.mIsValid) {
            LogUtil.e(TAG, "load library failed");
        } else {
            this.mIsValid = false;
            native_release();
        }
    }

    public synchronized void reset() {
        LogUtil.d(TAG, "reset");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
        } else {
            native_reset();
        }
    }

    public synchronized int resetOneMixAnalyze() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        int native_resetOneMixAnalyze = native_resetOneMixAnalyze();
        LogUtil.i(TAG, "resetOneMixAnalyze result is " + native_resetOneMixAnalyze);
        return native_resetOneMixAnalyze;
    }

    public synchronized boolean seekDebugSavePosition(int i3) {
        LogUtil.d(TAG, "setDebugSaveEnable");
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_seekDebugSavePosition(i3);
    }

    public synchronized boolean setAgcEnabled(boolean z16) {
        LogUtil.d(TAG, "setAgcEnabled:" + z16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setAgcEnabled(z16);
    }

    public synchronized int setAiEffect(int i3, int i16, float[] fArr) {
        LogUtil.i(TAG, "setAiParams -> id: " + i16 + " ,type:" + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        if (fArr == null || fArr.length == 0) {
            fArr = new float[4];
        }
        return native_setAiEffect(i3, i16, fArr);
    }

    public synchronized void setAudioEffectEnvStageType(@ENV_STAGE_TYPE int i3) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsInited == false");
            return;
        }
        if (i3 >= 0 && i3 <= 2) {
            native_audioEffectEnvStageType(i3);
            return;
        }
        LogUtil.e(TAG, "setAudioEffectEnvStageType invalidate, stageType = " + i3);
    }

    public synchronized void setAudioEffectReverbScale(@NEW_EFFECT_REVERB_SCALE_TYPE int i3, float f16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsInited == false");
            return;
        }
        if ((i3 >= 3 && i3 <= 14) || i3 == 20) {
            native_audioEffectReverbScale(i3, f16);
            return;
        }
        LogUtil.e(TAG, "scaleType invalidate, scaleType = " + i3);
    }

    public synchronized boolean setAutoGainScale(int i3, float f16) {
        LogUtil.d(TAG, "setAutoGainScale");
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setAutoGainScale(i3, f16);
    }

    public synchronized boolean setDebugDump() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setDebugDump();
    }

    public synchronized boolean setDebugSaveEnable(boolean z16, String str) {
        LogUtil.d(TAG, "setDebugSaveEnable");
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        return native_setDebugSaveEnable(z16, str);
    }

    public synchronized boolean setDebugTimeEnable(boolean z16) {
        LogUtil.d(TAG, "setDebugTimeEnable");
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setDebugTimeEnable(z16);
    }

    public synchronized boolean setEqualizerEnabled(boolean z16) {
        LogUtil.i(TAG, "setEqualizerEnabled: enable=" + z16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setEqualizerEnabled(z16);
    }

    public synchronized boolean setEqualizerParamValue(int i3, float f16) {
        LogUtil.i(TAG, "setEqualizerParamValue -> paramType=" + i3 + ", value=" + f16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setEqualizerParamValue(i3, f16);
    }

    public synchronized boolean setEqualizerTypeId(int i3) {
        LogUtil.i(TAG, "setEqualizerTypeId -> typeId = " + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setEqualizerTypeId(i3);
    }

    public synchronized boolean setIsRealOneMix(boolean z16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        LogUtil.i(TAG, "oneMix: setIsRealOneMix: " + z16);
        return native_setIsRealOneMix(z16);
    }

    public synchronized boolean setNoiseGateEnabled(boolean z16) {
        LogUtil.d(TAG, "setNoiseGateEnabled:" + z16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setNoiseGateEnabled(z16);
    }

    public synchronized boolean setNsEnabled(boolean z16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setNsEnabled(z16);
    }

    public synchronized boolean setNsLevel(int i3) {
        LogUtil.d(TAG, "setNsLevel:" + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setNsLevel(i3);
    }

    public synchronized boolean setOneMixAnalyzeResult(String str) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setOneMixAnalyeResult(str);
    }

    public synchronized int setOneMixEffectType(int i3) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        LogUtil.i(TAG, "oneMix: setOneMixEffectType = " + i3);
        return native_setOneMixEffectType(i3);
    }

    public synchronized boolean setOneMixEnabled(boolean z16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        LogUtil.i(TAG, "oneMix: setOneMixEnabled: " + z16);
        return native_setOneMixEnabled(z16);
    }

    public synchronized boolean setPluggedEnv(int i3) {
        LogUtil.i(TAG, "setPluggedEnv: " + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setPluggedEnv(i3);
    }

    public synchronized boolean setReverbConfigJson(int i3, String str) {
        return setReverbConfigJson(i3, str, 1);
    }

    public synchronized boolean setReverbEnabled(boolean z16) {
        LogUtil.i(TAG, "setReverbEnabled: " + z16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setReverb2Enabled(z16);
    }

    public synchronized void setReverbGainEnable(boolean z16) {
        LogUtil.d(TAG, "setReverbGainEnable : " + z16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
        } else {
            this.revertGainEnable = z16;
            native_setReverbGainEnable(z16);
        }
    }

    public synchronized void setReverbGainMap(ConcurrentHashMap<Integer, Float> concurrentHashMap) {
        LogUtil.d(TAG, "setReverbGainMap");
        if (concurrentHashMap != null) {
            this.reverbGainMap.putAll(concurrentHashMap);
        }
    }

    public synchronized boolean setReverbId(int i3) {
        return setReverbId(i3, 1);
    }

    public synchronized boolean setReverbParam(int i3, float f16) {
        LogUtil.i(TAG, "setReverbParam -> paramType = " + i3 + ", value = " + f16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setReverb2ParamValue(i3, f16);
    }

    public synchronized void setVoiceShiftEnabled(boolean z16) {
        LogUtil.i(TAG, "setVoiceEnabled: " + z16);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return;
        }
        if (native_setVoiceShiftEnabled(z16)) {
            LogUtil.i(TAG, "setVoiceEnabled: success");
        } else {
            LogUtil.i(TAG, "setVoiceEnabled: fail");
        }
    }

    public synchronized void setVoiceShiftKeyShift(int i3) {
        LogUtil.i(TAG, "setVoiceShiftKeyShift: voiceShift=" + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return;
        }
        if (native_setVoiceShiftKeyShift(i3)) {
            LogUtil.i(TAG, "setVoiceShiftKeyShift: success");
        } else {
            LogUtil.i(TAG, "setVoiceShiftKeyShift: fail");
        }
    }

    public synchronized void setVoiceShiftParam(int i3) {
        LogUtil.i(TAG, "setVoiceShiftParam: parmType=" + i3);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return;
        }
        if (native_setVoiceShiftType(i3)) {
            LogUtil.i(TAG, "setVoiceShiftParam: success");
        } else {
            LogUtil.i(TAG, "setVoiceShiftParam: fail");
        }
    }

    public synchronized void switchRebuildEffectChainBlock(boolean z16) {
        LogUtil.d(TAG, "switchRebuildEffectChainBlock");
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
        } else {
            native_switchRebuildEffectChainBlock(z16);
        }
    }

    public synchronized int init(int i3, int i16, byte[] bArr, boolean z16, int[] iArr, int i17) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init, sampleRate: ");
        sb5.append(i3);
        sb5.append(", channels: ");
        sb5.append(i16);
        sb5.append(",voiceBuf length: ");
        sb5.append(bArr == null ? 0 : bArr.length);
        sb5.append(",lyricTimes length: ");
        sb5.append(iArr == null ? 0 : iArr.length);
        LogUtil.d(TAG, sb5.toString());
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return -1;
        }
        int native_init = native_init(i3, i16, bArr, bArr == null ? 0 : bArr.length, z16, iArr, i17);
        this.mIsValid = native_init == 0;
        return native_init;
    }

    public synchronized boolean setReverbConfigJson(int i3, String str, int i16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        return native_setReverb2Json(i3, str, i16);
    }

    public synchronized boolean setReverbId(int i3, int i16) {
        boolean native_setReverbGainType;
        LogUtil.i(TAG, "setReverbParam -> reverbId = " + i3 + ", revertGainEnable:" + this.revertGainEnable);
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return false;
        }
        if (i3 == 100) {
            LogUtil.w(TAG, "setReverbId: do nothing this time");
            return false;
        }
        Float reverbGain = getReverbGain(i3);
        if (reverbGain != null) {
            native_setReverbGainType = native_setReverbGain(i3, reverbGain.floatValue());
        } else {
            native_setReverbGainType = native_setReverbGainType(i3);
        }
        if (!native_setReverbGainType) {
            LogUtil.i(TAG, "setReverbParam -> reverbId = " + i3 + ", reverbGain: " + reverbGain + ", result: " + native_setReverbGainType);
            native_setReverbGainEnable(false);
        }
        return native_setReverb2TypeId(i3, i16);
    }

    public synchronized int process(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        int i17 = 0;
        int i18 = i3;
        while (i17 < i3) {
            this.mBuffer.clear();
            int min = Math.min(8192, i3 - i17);
            this.mBuffer.put(bArr, i17, min);
            int native_process = native_process(this.mBuffer, min);
            if (native_process >= 0) {
                this.mBuffer.flip();
                this.mBuffer.get(bArr2, i17, min);
            } else {
                LogUtil.w(TAG, "process failed, copy the source: " + native_process);
                System.arraycopy(bArr, i17, bArr2, i17, min);
            }
            i17 += min;
            i18 = native_process;
        }
        return i18;
    }

    public synchronized int processAi(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            this.mBuffer.clear();
            int min = Math.min(8192, i3 - i17);
            this.mBuffer.put(bArr, i17, min);
            int native_processAi = native_processAi(this.mBuffer, min);
            if (native_processAi >= 0) {
                this.mBuffer.flip();
                this.mBuffer.get(bArr2, i17, min);
            } else {
                LogUtil.w(TAG, "as failed to reduce the noise, copy the source: " + native_processAi);
                System.arraycopy(bArr, i17, bArr2, i17, min);
            }
            i17 += min;
            i18 = native_processAi;
        }
        return i18;
    }

    public synchronized int init(int i3, int i16, byte[] bArr, boolean z16, int[] iArr) {
        return init(i3, i16, bArr, z16, iArr, 0);
    }

    public synchronized int process(ByteBuffer byteBuffer, int i3, int i16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        return native_processObb(byteBuffer, i3, i16);
    }
}
