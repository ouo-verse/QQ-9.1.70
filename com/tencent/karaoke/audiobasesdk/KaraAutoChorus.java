package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraAutoChorus {
    private static final String TAG = "KaraAutoChorus";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private long nativeHandle;
    public boolean mIsValid = false;
    private boolean mIsCanGetScale = false;

    private native boolean native_EstimateAccGain(byte[] bArr, int i3, byte[] bArr2, int i16);

    private native float native_GetAccScale();

    private native int native_GetLastError();

    private native float native_GetUgcScale();

    private native boolean native_Init(int[] iArr, int[] iArr2, int i3, int i16);

    private native boolean native_SetTimeStamp(float f16);

    private native void native_release();

    public synchronized boolean estimateAccGain(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (this.mIsValid) {
            boolean native_EstimateAccGain = native_EstimateAccGain(bArr, i3, bArr2, i16);
            if (!native_EstimateAccGain) {
                LogUtil.e(TAG, "" + native_GetLastError());
            } else {
                this.mIsCanGetScale = true;
            }
            return native_EstimateAccGain;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }

    public synchronized float getAccScale() {
        if (this.mIsValid) {
            return native_GetAccScale();
        }
        LogUtil.e(TAG, "not valid");
        return -100.0f;
    }

    public synchronized float getUgcScale() {
        if (this.mIsValid) {
            return native_GetUgcScale();
        }
        LogUtil.e(TAG, "not valid");
        return -100.0f;
    }

    public synchronized boolean init(int[] iArr, int[] iArr2, int i3, int i16) {
        if (mIsLoaded) {
            boolean native_Init = native_Init(iArr, iArr2, i3, i16);
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

    public synchronized boolean setTimeScale(float f16) {
        if (this.mIsValid) {
            boolean native_SetTimeStamp = native_SetTimeStamp(f16);
            if (!native_SetTimeStamp) {
                LogUtil.e(TAG, "" + native_GetLastError());
            }
            return native_SetTimeStamp;
        }
        LogUtil.e(TAG, "not valid");
        return false;
    }
}
