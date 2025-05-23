package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioAlignAccompany {
    private static final String TAG = "AudioAlignAccompany";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    public static int[] calculateMixWavAlign(int[] iArr, byte[] bArr, int i3, byte[] bArr2, int i16, int i17, int i18) {
        if (mIsLoaded) {
            return native_CalculateMixWavsOffset(iArr, bArr, i3, bArr2, i16, i17, i18);
        }
        LogUtil.i(TAG, "calculateVocalWavAlign: so is not loaded");
        return null;
    }

    private static native int[] native_CalculateMixWavsOffset(int[] iArr, byte[] bArr, int i3, byte[] bArr2, int i16, int i17, int i18);

    private native int native_CalculateVocalWavAlign(int i3, long[] jArr, int i16);

    private native int native_Cancel();

    private native String native_FetchLog();

    private native int native_ProcessAccompanyData(byte[] bArr, int i3);

    private native int native_ProcessVocalData(byte[] bArr, int i3);

    private native int native_SetAccompanyDataInfo(int i3, int i16);

    private native int native_SetVocalDataInfo(int i3, int i16, boolean z16);

    private native int native_destory();

    private native int native_init(int i3);

    private native int native_init(int i3, float f16, float f17, int i16);

    private native int native_init(int i3, int i16);

    private native int native_setVoiceStartMs(int i3);

    public synchronized int calculateVocalWavAlign(int i3, long[] jArr, int i16) {
        if (this.mIsValid) {
            return native_CalculateVocalWavAlign(i3, jArr, i16);
        }
        LogUtil.i(TAG, "calculateVocalWavAlign: is not valid");
        return -11000;
    }

    public synchronized int destory() {
        if (this.mIsValid) {
            int native_destory = native_destory();
            this.mIsValid = false;
            return native_destory;
        }
        LogUtil.w(TAG, "AudioAlignAccompany invalid");
        return 0;
    }

    public synchronized String fetchLog() {
        if (this.mIsValid) {
            return native_FetchLog();
        }
        return null;
    }

    public synchronized int init(int i3) {
        if (!mIsLoaded) {
            return -1;
        }
        int native_init = native_init(i3);
        this.mIsValid = native_init > 0;
        return native_init;
    }

    public synchronized int processAccompanyData(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_ProcessAccompanyData(bArr, i3);
        }
        return -1;
    }

    public synchronized int processVocalData(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_ProcessVocalData(bArr, i3);
        }
        return -1;
    }

    public synchronized int setAccompanyDataInfo(int i3, int i16) {
        if (this.mIsValid) {
            return native_SetAccompanyDataInfo(i3, i16);
        }
        return -1;
    }

    public synchronized int setRealVoiceDataStartMs(int i3) {
        if (this.mIsValid) {
            return native_setVoiceStartMs(i3);
        }
        return -1;
    }

    public synchronized int setVocalDataInfo(int i3, int i16, boolean z16) {
        if (this.mIsValid) {
            return native_SetVocalDataInfo(i3, i16, z16);
        }
        return -1;
    }

    public synchronized int init(int i3, int i16) {
        if (!mIsLoaded) {
            return -1;
        }
        int native_init = native_init(i3, i16);
        this.mIsValid = native_init > 0;
        return native_init;
    }

    public synchronized int init(int i3, float f16, float f17, int i16) {
        if (!mIsLoaded) {
            return -1;
        }
        int native_init = native_init(i3, f16, f17, i16);
        this.mIsValid = native_init > 0;
        return native_init;
    }
}
