package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraMixer {
    private static final int INPUT_BUFFER_SIZE = 4096;
    private static final int OUTPUT_BUFFER_SIZE = 8192;
    private static final String TAG = "KaraMixer";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    public boolean mIsValid = false;
    private long nativeHandle;

    private native void native_destory();

    private native float native_getAccompanyAbsVolumeByRatio(float f16);

    private native float native_getAccompanyRatioByAbsVolume(float f16);

    private native float native_getVocalAbsVolumeByRatio(float f16);

    private native float native_getVocalRatioByAbsVolume(float f16);

    private native int native_init(int i3, int i16);

    private native int native_mix(byte[] bArr, int i3, byte[] bArr2, int i16, byte[] bArr3, int i17);

    private native int native_mix(byte[] bArr, int i3, byte[] bArr2, int i16, byte[] bArr3, int i17, float f16, float f17, int i18);

    private native int native_mix(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3);

    private native int native_reset();

    private native int native_setAccompanyAbsVolume(float f16);

    private native boolean native_setMix(float f16, float f17, int i3);

    private native int native_setVocalAbsVolume(float f16);

    public synchronized float GetAccompanyAbsVolumeByRatio(float f16) {
        LogUtil.i(TAG, "GetAccompanyAbsVolumeByRatio: accompanyRatio" + f16);
        if (this.mIsValid) {
            return native_getAccompanyAbsVolumeByRatio(f16);
        }
        LogUtil.w(TAG, "Mix invalid");
        return -1.0f;
    }

    public synchronized float GetAccompanyRatioByAbsVolume(float f16) {
        LogUtil.i(TAG, "GetAccompanyRatioByAbsVolume: accompanyAbsVolume" + f16);
        if (this.mIsValid) {
            return native_getAccompanyRatioByAbsVolume(f16);
        }
        LogUtil.w(TAG, "Mix invalid");
        return 0.0f;
    }

    public synchronized float GetVocalAbsVolumeByRatio(float f16) {
        LogUtil.i(TAG, "GetVocalAbsVolumeByRatio: vocalRatio" + f16);
        if (this.mIsValid) {
            return native_getVocalAbsVolumeByRatio(f16);
        }
        LogUtil.w(TAG, "Mix invalid");
        return -1.0f;
    }

    public synchronized float GetVocalRatioByAbsVolume(float f16) {
        LogUtil.i(TAG, "GetVocalRatioByAbsVolume: vocalAbsVolume" + f16);
        if (this.mIsValid) {
            return native_getVocalRatioByAbsVolume(f16);
        }
        LogUtil.w(TAG, "Mix invalid");
        return 0.0f;
    }

    public synchronized void SetAccompanyAbsVolume(float f16) {
        LogUtil.i(TAG, "SetAccompanyAbsVolume: accompanyAbsVolume" + f16);
        if (this.mIsValid) {
            native_setAccompanyAbsVolume(f16);
        } else {
            LogUtil.w(TAG, "Mix invalid");
        }
    }

    public synchronized void SetVocalAbsVolume(float f16) {
        LogUtil.i(TAG, "SetVocalAbsVolume: vocalAbsVolume" + f16);
        if (this.mIsValid) {
            native_setVocalAbsVolume(f16);
        } else {
            LogUtil.w(TAG, "Mix invalid");
        }
    }

    public synchronized void destory() {
        if (this.mIsValid) {
            native_destory();
            this.mIsValid = false;
        } else {
            LogUtil.w(TAG, "Mix invalid");
        }
    }

    public synchronized void init(MixConfig mixConfig) {
        boolean z16;
        if (mIsLoaded) {
            int native_init = native_init(mixConfig.sampleRate, mixConfig.channel);
            if (native_init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            if (!z16) {
                LogUtil.w(TAG, "Mixer init failed: " + native_init);
            }
        }
    }

    public synchronized boolean initMixer(MixConfig mixConfig) {
        boolean z16 = false;
        if (!mIsLoaded) {
            return false;
        }
        int native_init = native_init(mixConfig.sampleRate, mixConfig.channel);
        if (native_init == 0) {
            z16 = true;
        }
        this.mIsValid = z16;
        if (!z16) {
            LogUtil.w(TAG, "Mixer init failed: " + native_init);
        }
        return this.mIsValid;
    }

    public synchronized int mix(byte[] bArr, int i3, byte[] bArr2, int i16, byte[] bArr3, int i17) {
        if (this.mIsValid) {
            return native_mix(bArr, i3, bArr2, i16, bArr3, i17);
        }
        LogUtil.w(TAG, "Mix invalid");
        return -1;
    }

    public synchronized int reset() {
        if (this.mIsValid) {
            return native_reset();
        }
        LogUtil.w(TAG, "Mix invalid");
        return -1;
    }

    public synchronized boolean setMix(MixConfig mixConfig) {
        if (this.mIsValid) {
            return native_setMix(mixConfig.leftVolum, mixConfig.rightVolum, mixConfig.rightDelay);
        }
        LogUtil.w(TAG, "Mix invalid");
        return false;
    }

    public synchronized int mix(byte[] bArr, int i3, byte[] bArr2, int i16, byte[] bArr3, int i17, MixConfig mixConfig) {
        if (this.mIsValid) {
            return native_mix(bArr, i3, bArr2, i16, bArr3, i17, mixConfig.leftVolum, mixConfig.rightVolum, mixConfig.rightDelay);
        }
        LogUtil.w(TAG, "Mix invalid");
        return -1;
    }

    public synchronized int mix(byte[] bArr, int i3, byte[] bArr2, int i16, byte[] bArr3, int i17, float f16, float f17, int i18) {
        if (this.mIsValid) {
            return native_mix(bArr, i3, bArr2, i16, bArr3, i17, f16, f17, i18);
        }
        LogUtil.w(TAG, "Mix invalid");
        return -1;
    }

    public synchronized int mix(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3) {
        if (this.mIsValid) {
            return native_mix(bArr, bArr2, bArr3, bArr4, i3);
        }
        LogUtil.w(TAG, "Mix invalid");
        return -1;
    }
}
