package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* loaded from: classes7.dex */
public class AudioPracticingSing {
    private static final String TAG = "AudioPracticingSing";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_analysisFeaturesInfo(String str);

    private native int[] native_fetchAllBreathingPointsMs();

    private native int[] native_fetchAllBreathingSentenceLineNumbers();

    private native int[] native_fetchAllHardSentenceLineNumbers();

    private native int[] native_fetchAllPortamentosMs();

    private native int[] native_fetchAllVibratosMs();

    private native int[] native_fetchBreathingPointPositionsInSentence(int i3);

    private native int[] native_fetchTipsInSentence(int i3);

    private native int native_init(String str, String str2);

    private native int native_initWithContent(String str, int i3, String str2, int i16);

    private native void native_printQrcFeatureInfos();

    private native void native_release();

    public synchronized int analysisFeaturesInfo(String str) {
        if (this.mIsValid) {
            return native_analysisFeaturesInfo(str);
        }
        LogUtil.i(TAG, "analysisFeaturesInfo: so is not loaded");
        return -1;
    }

    public synchronized int[] fetchAllBreathingPointsMs() {
        if (this.mIsValid) {
            return native_fetchAllBreathingPointsMs();
        }
        LogUtil.i(TAG, "fetchAllBreathingPointsMs: so is not loaded");
        return null;
    }

    public synchronized int[] fetchAllBreathingSentenceLineNumbers() {
        if (this.mIsValid) {
            return native_fetchAllBreathingSentenceLineNumbers();
        }
        LogUtil.i(TAG, "fetchAllBreathingSentenceLineNumbers: so is not loaded");
        return null;
    }

    public synchronized int[] fetchAllHardSentenceLineNumbers() {
        if (this.mIsValid) {
            return native_fetchAllHardSentenceLineNumbers();
        }
        LogUtil.i(TAG, "fetchAllHardSentenceLineNumbers: so is not loaded");
        return null;
    }

    public synchronized int[] fetchAllPortamentosMs() {
        if (this.mIsValid) {
            return native_fetchAllPortamentosMs();
        }
        LogUtil.i(TAG, "fetchAllPortamentosMs: so is not loaded");
        return null;
    }

    public synchronized int[] fetchAllVibratosMs() {
        if (this.mIsValid) {
            return native_fetchAllVibratosMs();
        }
        LogUtil.i(TAG, "fetchAllVibratosMs: so is not loaded");
        return null;
    }

    public synchronized int[] fetchBreathingPointPositionsInSentence(int i3) {
        if (this.mIsValid) {
            return native_fetchBreathingPointPositionsInSentence(i3);
        }
        LogUtil.i(TAG, "fetchBreathingPointPositionsInSentence: so is not loaded");
        return null;
    }

    public synchronized int[] fetchTipsInSentence(int i3) {
        if (this.mIsValid) {
            return native_fetchTipsInSentence(i3);
        }
        LogUtil.i(TAG, "fetchTipsInSentence: so is not loaded");
        return null;
    }

    public synchronized int init(String str, String str2) {
        boolean z16;
        if (mIsLoaded) {
            int native_init = native_init(str, str2);
            if (native_init > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            return native_init;
        }
        LogUtil.i(TAG, "init: so is not loaded");
        return -1;
    }

    public synchronized int initWithContent(String str, int i3, String str2, int i16) {
        boolean z16;
        if (mIsLoaded) {
            int native_initWithContent = native_initWithContent(str, i3, str2, i16);
            if (native_initWithContent > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            return native_initWithContent;
        }
        LogUtil.i(TAG, "init: so is not loaded");
        return -1;
    }

    public synchronized void printQrcFeatureInfos() {
        if (this.mIsValid) {
            native_printQrcFeatureInfos();
        } else {
            LogUtil.i(TAG, "printQrcFeatureInfos: so is not loaded");
        }
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        } else {
            LogUtil.i(TAG, "release: so is not loaded");
        }
    }
}
