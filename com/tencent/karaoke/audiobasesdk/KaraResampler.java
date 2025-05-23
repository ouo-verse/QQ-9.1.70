package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraResampler {
    private static final short DEPTH_PER_SAMPLE = 2;
    private static final String TAG = "KaraResampler";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_getOutLenBytes(int i3);

    private native boolean native_init(int i3, int i16, int i17, int i18, int i19);

    private native void native_release();

    private native int native_resample(byte[] bArr, int i3, byte[] bArr2, int i16);

    public synchronized int getMaxOututSize(int i3) {
        if (this.mIsValid) {
            return native_getOutLenBytes(i3);
        }
        return 0;
    }

    public synchronized int init(int i3, int i16, int i17, int i18, int i19) {
        if (mIsLoaded) {
            boolean native_init = native_init(i3, i16, i17, i18, i19);
            this.mIsValid = native_init;
            if (native_init) {
                return 0;
            }
            LogUtil.i(TAG, "native_init failed");
            return -1;
        }
        LogUtil.i(TAG, "SimpleKara Resampler Invalid because load library failed");
        return -1;
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        }
    }

    public synchronized int resample(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (this.mIsValid) {
            return native_resample(bArr, i3, bArr2, i16);
        }
        return -1;
    }
}
