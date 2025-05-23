package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraAudioLocalBalance {
    public static final int ERROR_CODE_NOT_VALID = -1000;
    public static final int ERROR_CODE_NULL_OBJ = -99;
    private static final String TAG = "KaraAudioLocalBalance";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    public boolean mIsValid = false;
    private long nativeHandle;

    private native float native_GetAccLoudness();

    private native float native_GetAccScale();

    private native int native_GetLastError();

    private native float native_GetVocLoudness();

    private native float native_GetVocScale();

    private native boolean native_Init();

    private native boolean native_SetAccTarget(byte[] bArr, int i3, int i16, int i17, float f16);

    private native boolean native_SetVocTarget(byte[] bArr, int i3, int i16, int i17, float f16);

    private native void native_release();

    public synchronized float getAccLoudness() {
        if (this.mIsValid) {
            return native_GetAccLoudness();
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

    public synchronized float getVocLoudness() {
        if (this.mIsValid) {
            return native_GetVocLoudness();
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

    public synchronized boolean init() {
        if (mIsLoaded) {
            boolean native_Init = native_Init();
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

    public synchronized boolean setAccTarget(byte[] bArr, int i3, int i16, int i17, float f16) {
        if (this.mIsValid) {
            boolean native_SetAccTarget = native_SetAccTarget(bArr, i3, i16, i17, f16);
            if (!native_SetAccTarget) {
                LogUtil.e(TAG, "setAccTarget() get error:" + native_GetLastError());
            }
            return native_SetAccTarget;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }

    public synchronized boolean setVocTarget(byte[] bArr, int i3, int i16, int i17, float f16) {
        if (this.mIsValid) {
            boolean native_SetVocTarget = native_SetVocTarget(bArr, i3, i16, i17, f16);
            if (!native_SetVocTarget) {
                LogUtil.e(TAG, "setVocTarget() get error:" + native_GetLastError());
            }
            return native_SetVocTarget;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }
}
