package com.tencent.ttpic.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.logic.watermark.DecibelDetector;
import com.tencent.ttpic.logic.watermark.FFTData;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum AudioDataManager {
    INSTANCE;

    private static final String TAG = AudioDataManager.class.getSimpleName();
    private int mDecibel;
    private boolean mHasMusic;
    private boolean needDecible;
    private boolean mUseDecibelFromCameraRecorder = false;
    private FFTData mFFTDataResult = new FFTData();

    AudioDataManager() {
    }

    public static AudioDataManager getInstance() {
        return INSTANCE;
    }

    private void reset() {
        this.needDecible = false;
        this.mDecibel = 0;
        this.mUseDecibelFromCameraRecorder = false;
        resetFFTData();
    }

    private void resetFFTData() {
        Arrays.fill(this.mFFTDataResult.mFFTBuffer, 0);
        this.mFFTDataResult.mFFTSum = 0;
    }

    public void destroy() {
        DecibelDetector.getInstance().destroy();
    }

    public int getDecibel() {
        if (this.mHasMusic) {
            return this.mDecibel;
        }
        if (!this.mUseDecibelFromCameraRecorder) {
            DecibelDetector.getInstance().init();
            int decibel = DecibelDetector.getInstance().getDecibel();
            if (decibel != 0) {
                setMicDecibel(decibel);
            }
        }
        return this.mDecibel;
    }

    public FFTData getFFTResult() {
        if (this.mHasMusic) {
            return this.mFFTDataResult;
        }
        if (!this.mUseDecibelFromCameraRecorder) {
            DecibelDetector.getInstance().init();
            FFTData fFTResult = DecibelDetector.getInstance().getFFTResult();
            if (fFTResult != null) {
                setFFTData(fFTResult);
            }
        }
        return this.mFFTDataResult;
    }

    public boolean isUsePcmDecibel() {
        return this.mHasMusic;
    }

    public boolean needMicDecibel() {
        if (this.needDecible && !this.mHasMusic) {
            return true;
        }
        return false;
    }

    public void resetPermission() {
        DecibelDetector.getInstance().resetPermission();
    }

    public void setDecibel(int i3) {
        this.mDecibel = i3;
    }

    public void setDecibelFromCameraRecorder(boolean z16) {
        this.mUseDecibelFromCameraRecorder = z16;
    }

    public void setFFTData(FFTData fFTData) {
        if (fFTData == null) {
            return;
        }
        this.mFFTDataResult.mFFTBuffer = Arrays.copyOf(fFTData.mFFTBuffer, fFTData.mFFTSize);
        FFTData fFTData2 = this.mFFTDataResult;
        fFTData2.mFFTSum = fFTData.mFFTSum;
        fFTData2.mFFTSize = fFTData.mFFTSize;
        fFTData2.mFFTFreqMax = fFTData.mFFTFreqMax;
    }

    public void setMicDecibel(int i3) {
        MicAudioAdjustManager.getInstance().setMicDecibel(i3);
        setDecibel(i3);
    }

    public void setMusic(boolean z16) {
        this.mHasMusic = z16;
    }

    public void setNeedDecible(boolean z16) {
        reset();
        this.needDecible = z16;
    }

    public void setPcmDecibel(int i3) {
        LogUtils.d(TAG, "[decibel] pcm = " + i3);
        setDecibel(i3);
    }

    public void setPcmFFTDataReset() {
        resetFFTData();
    }
}
