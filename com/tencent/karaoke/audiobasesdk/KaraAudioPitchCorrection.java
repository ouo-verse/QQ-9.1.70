package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection;

/* loaded from: classes7.dex */
public class KaraAudioPitchCorrection implements IPitchCorrection {
    public static final int MODE_ALL_ANALYZED = 1;
    public static final int MODE_PITCH_SHARED = 2;
    public static final int MODE_PITCH_SHARED_V3 = 3;
    public static final int MODE_PRE_ANALYZED = 0;
    public static final int PITCH_CORRECTION_VERSION_ERROR = 0;
    public static final int PITCH_CORRECTION_VERSION_V30 = 1;
    public static final int PITCH_CORRECTION_VERSION_V31 = 2;
    public static final int PITCH_CORRECTION_VERSION_V32 = 3;
    public static final int PITCH_CORRECTION_VERSION_V40 = 4;
    public static final int PITCH_CORRECTION_VERSION_V41 = 5;
    private static final String TAG = "KaraAudioPitchCorrection";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    /* loaded from: classes7.dex */
    public @interface Mode {
    }

    private native boolean native_enableVersionByID(int i3);

    private native int native_getAccompanyShift();

    private native int native_getCorrectionResult(byte[] bArr, int i3);

    private native int native_getPitchCorrectMode();

    private native float native_getPitchCorrectScale();

    private native int native_getPitchCorrectionProgress();

    private native boolean native_getPitchCorrectionRunBlock();

    private native boolean native_getSentenceCorrectFlag(int i3);

    private native int native_getSentenceCount();

    private native KaraAudioPitchCorrectionWordDesc[] native_getSentenceWordDescs(int i3);

    private native int native_getVersionID();

    private native int native_init(int i3, int i16, String str, byte[] bArr, int i17, @Mode int i18, float[] fArr, int i19);

    private native int native_pitchAnalyzeBegin();

    private native int native_pitchAnalyzedComplete(int i3);

    private native int native_pitchAnalyzedProcess(byte[] bArr, int i3, int i16);

    private native int native_pitchCorrectionAnalyzed(byte[] bArr, int i3, int i16, int i17);

    private native int native_pitchCorrectionCancel();

    private native int native_pitchCorrectionRun(byte[] bArr, int i3, int i16);

    private native void native_release();

    private native int native_saveCorrectionResultToFile(String str);

    private native int native_setAccompanyShift(int i3);

    private native int native_setPitchCorrectMode(int i3);

    private native int native_setPitchCorrectScale(float f16);

    private native int native_setSentenceCorrectFlag(int i3, boolean z16);

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getPitchCorrectMode() {
        if (this.mIsValid) {
            return native_getPitchCorrectMode();
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public float getPitchCorrectScale() {
        if (this.mIsValid) {
            return native_getPitchCorrectScale();
        }
        return 0.0f;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getPitchCorrectionProgress() {
        if (this.mIsValid) {
            return native_getPitchCorrectionProgress();
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getPitchCorrectionResult(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_getCorrectionResult(bArr, i3);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public boolean getPitchCorrectionRunBlock() {
        if (this.mIsValid) {
            return native_getPitchCorrectionRunBlock();
        }
        return false;
    }

    public int getPitchCorrectionVersion() {
        if (this.mIsValid) {
            return native_getVersionID();
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public boolean getSentenceCorrectFlag(int i3) {
        if (this.mIsValid) {
            return native_getSentenceCorrectFlag(i3);
        }
        return false;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getSentenceCount() {
        if (this.mIsValid) {
            return native_getSentenceCount();
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public KaraAudioPitchCorrectionWordDesc[] getSentenceWordDescs(int i3) {
        if (this.mIsValid) {
            return native_getSentenceWordDescs(i3);
        }
        return null;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int init(int i3, int i16, String str, byte[] bArr, @Mode int i17, float[] fArr, int i18, boolean z16) {
        if (mIsLoaded) {
            boolean z17 = false;
            LogUtil.d(TAG, String.format("init begin. configFilepath:%s, refFile length:%d,vocoderMode=%d,pitchLen=%d", str, Integer.valueOf(bArr.length), Integer.valueOf(i17), Integer.valueOf(i18)));
            LogUtil.i(TAG, "init: isKaraokeSupport autotune");
            int native_init = native_init(i3, i16, str, bArr, bArr.length, i17, fArr, i18);
            if (native_init == 0) {
                z17 = true;
            }
            this.mIsValid = z17;
            if (!z17) {
                LogUtil.w(TAG, "KaraAudioPitchCorrection init failed: " + native_init);
            }
            return native_init;
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchAnalyzedBegin() {
        if (this.mIsValid) {
            return native_pitchAnalyzeBegin();
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchAnalyzedComplete(int i3) {
        if (this.mIsValid) {
            return native_pitchAnalyzedComplete(i3);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchAnalyzedProcess(byte[] bArr, int i3, int i16) {
        if (this.mIsValid) {
            return native_pitchAnalyzedProcess(bArr, i3, i16);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchCorrectionAnalyzed(byte[] bArr, int i3, int i16, int i17) {
        if (this.mIsValid) {
            return native_pitchCorrectionAnalyzed(bArr, i3, i16, i17);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchCorrectionCancel() {
        if (this.mIsValid) {
            return native_pitchCorrectionCancel();
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchCorrectionRun(byte[] bArr, int i3, int i16) {
        if (!this.mIsValid || bArr == null || bArr.length <= 0) {
            return -1;
        }
        return native_pitchCorrectionRun(bArr, i3, i16);
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public void release() {
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int saveCorrectionResultToFile(String str) {
        if (this.mIsValid) {
            return native_saveCorrectionResultToFile(str);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setAccompanyShift(int i3) {
        if (this.mIsValid) {
            return native_setAccompanyShift(i3);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setPitchCorrectMode(int i3) {
        if (this.mIsValid) {
            return native_setPitchCorrectMode(i3);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setPitchCorrectScale(float f16) {
        if (this.mIsValid) {
            return native_setPitchCorrectScale(f16);
        }
        return -1;
    }

    public boolean setPitchCorrectionVersion(int i3) {
        if (this.mIsValid) {
            return native_enableVersionByID(i3);
        }
        return false;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setSentenceCorrectFlag(int i3, boolean z16) {
        if (this.mIsValid) {
            return native_setSentenceCorrectFlag(i3, z16);
        }
        return -1;
    }
}
