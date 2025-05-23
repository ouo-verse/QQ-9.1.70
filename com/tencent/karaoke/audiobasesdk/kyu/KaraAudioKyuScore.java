package com.tencent.karaoke.audiobasesdk.kyu;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraAudioKyuScore {
    private static final String TAG = "KaraAudioKyuScore";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int getKyuSentencePitchScoreDescsResultCode();

    private native KaraAudioKyuSentencePitchScoreDesc[] native_getSentencePitchScores();

    private native int native_init(int i3, int i16, int i17, int i18, byte[] bArr, int i19, byte[] bArr2, int i26, int i27, int i28, int i29, boolean z16);

    private native int native_processAcc(byte[] bArr, int i3);

    private native int native_processMic(byte[] bArr, int i3);

    private native void native_setDebugEnable(boolean z16);

    private native void native_uninit();

    public synchronized int appendAccPcmData(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_processAcc(bArr, i3);
        }
        LogUtil.i(TAG, "appendMicPcmData: isValid is false");
        return -1;
    }

    public synchronized int appendMicPcmData(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_processMic(bArr, i3);
        }
        LogUtil.i(TAG, "appendMicPcmData: isValid is false");
        return -1;
    }

    public synchronized int getResultErrorCode() {
        if (this.mIsValid) {
            return getKyuSentencePitchScoreDescsResultCode();
        }
        return -1;
    }

    public synchronized KaraAudioKyuSentencePitchScoreDesc[] getSentencePitchScores() {
        if (this.mIsValid) {
            return native_getSentencePitchScores();
        }
        return null;
    }

    public synchronized int init(int i3, int i16, int i17, int i18, byte[] bArr, int i19, byte[] bArr2, int i26, int i27, int i28, int i29, boolean z16) {
        if (!mIsLoaded) {
            return -1;
        }
        LogUtil.i(TAG, "init: ");
        int native_init = native_init(i3, i16, i17, i18, bArr, i19, bArr2, i26, i27, i28, i29, z16);
        boolean z17 = native_init == 0;
        this.mIsValid = z17;
        if (!z17) {
            LogUtil.w(TAG, "KaraAudioPitchCorrection init failed: " + native_init);
        }
        return native_init;
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_uninit();
            this.mIsValid = false;
        }
    }

    public synchronized void setDebugMode(boolean z16) {
        if (mIsLoaded) {
            LogUtil.i(TAG, "setDebugMode: enable=" + z16);
            native_setDebugEnable(z16);
        } else {
            LogUtil.i(TAG, "setDebugMode: has not loaded");
        }
    }
}
