package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraAutoGain {
    public static final int GAIN_MODE_AUTO = 1;
    public static final int GAIN_MODE_MANUAL = 0;
    private static final String TAG = "KaraAutoGain";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    public boolean mIsValid = false;
    private long nativeHandle;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class AutoGainErrorType {
        public static final int AutoGainEburInitError = -3020;
        public static final int AutoGainEmptyPointerError = -3000;
        public static final int AutoGainInbufferInitError = -3040;
        public static final int AutoGainModeError = -3100;
        public static final int AutoGainResampleInitError = -3030;
        public static final int AutoGainSetBiasError = -3090;
        public static final int AutoGainSetGainError = -3080;
        public static final int AutoGainVocError = -3010;
        public static final int AutoGainVocNullPointerError = -3060;
        public static final int AutoGainVocSizeError = -3070;
        public static final int Init_OutBufferInitError = -3050;
    }

    private native float native_GetAccBias();

    private native float native_GetAccScale();

    private native int native_GetAutoGainMode();

    private native int native_GetLastError();

    private native float native_GetProcessScale();

    private native float native_GetVocBias();

    private native float native_GetVocScale();

    private native boolean native_Init(int i3, int i16);

    private native boolean native_SetAccBias(float f16);

    private native boolean native_SetAccGain(float f16);

    private native boolean native_SetAutoGainMode(int i3);

    private native boolean native_SetProcessScale(float f16);

    private native boolean native_SetVocBias(float f16);

    private native boolean native_SetVocGain(byte[] bArr, float f16);

    private native void native_release();

    public synchronized float getAccBias() {
        if (this.mIsValid) {
            return native_GetAccBias();
        }
        LogUtil.e(TAG, "not valid");
        return -1000.0f;
    }

    public synchronized float getAccScale() {
        if (this.mIsValid) {
            return native_GetAccScale();
        }
        LogUtil.e(TAG, "not valid");
        return -1000.0f;
    }

    public synchronized int getAutoGainMode() {
        if (this.mIsValid) {
            return native_GetAutoGainMode();
        }
        LogUtil.e(TAG, "not valid");
        return -1000;
    }

    public synchronized float getProcessScale() {
        if (this.mIsValid) {
            return native_GetProcessScale();
        }
        LogUtil.e(TAG, "not valid");
        return 0.0f;
    }

    public synchronized float getVocBias() {
        if (this.mIsValid) {
            return native_GetVocBias();
        }
        LogUtil.e(TAG, "not valid");
        return -1000.0f;
    }

    public synchronized float getVocScale() {
        if (this.mIsValid) {
            return native_GetVocScale();
        }
        LogUtil.e(TAG, "not valid");
        return -1000.0f;
    }

    public synchronized boolean init(int i3, int i16) {
        if (mIsLoaded) {
            boolean native_Init = native_Init(i3, i16);
            if (!native_Init) {
                LogUtil.e(TAG, "native_Init failed");
            } else {
                this.mIsValid = true;
            }
            return native_Init;
        }
        LogUtil.d(TAG, "so load failed");
        return false;
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_release();
        }
        this.mIsValid = false;
    }

    public synchronized boolean setAccBias(float f16) {
        if (this.mIsValid) {
            boolean native_SetAccBias = native_SetAccBias(f16);
            if (!native_SetAccBias) {
                LogUtil.e(TAG, "setVocBias -> error:" + native_GetLastError());
            }
            return native_SetAccBias;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }

    public synchronized boolean setAccGain(float f16) {
        if (this.mIsValid) {
            boolean native_SetAccGain = native_SetAccGain(f16);
            if (!native_SetAccGain) {
                LogUtil.e(TAG, "" + native_GetLastError());
            }
            return native_SetAccGain;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }

    public synchronized boolean setAutoGainMode(int i3) {
        if (this.mIsValid) {
            boolean native_SetAutoGainMode = native_SetAutoGainMode(i3);
            if (!native_SetAutoGainMode) {
                LogUtil.e(TAG, "" + native_GetLastError());
            }
            return native_SetAutoGainMode;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }

    public synchronized boolean setProcessScale(float f16) {
        if (this.mIsValid) {
            boolean native_SetProcessScale = native_SetProcessScale(f16);
            if (!native_SetProcessScale) {
                LogUtil.e(TAG, "" + native_GetLastError());
            }
            return native_SetProcessScale;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }

    public synchronized boolean setVocBias(float f16) {
        if (this.mIsValid) {
            boolean native_SetVocBias = native_SetVocBias(f16);
            if (!native_SetVocBias) {
                LogUtil.e(TAG, "setVocBias -> error:" + native_GetLastError());
            }
            return native_SetVocBias;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }

    public synchronized boolean setVocGain(byte[] bArr, float f16) {
        if (this.mIsValid) {
            boolean native_SetVocGain = native_SetVocGain(bArr, f16);
            if (!native_SetVocGain) {
                LogUtil.e(TAG, "" + native_GetLastError());
            }
            return native_SetVocGain;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }
}
