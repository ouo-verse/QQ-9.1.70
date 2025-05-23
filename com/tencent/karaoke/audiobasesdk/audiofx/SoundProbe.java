package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* loaded from: classes7.dex */
public class SoundProbe {
    private static final String TAG = "SoundProbe";
    private static volatile boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_getloudness();

    private native int native_init(int i3, int i16);

    private native int native_isabsolutemute();

    private native int native_issoundlow();

    private native int native_process(byte[] bArr, int i3);

    private native int native_release();

    public synchronized int getLoudness() {
        if (this.mIsValid) {
            return native_getloudness();
        }
        LogUtil.w(TAG, "lmIsValid == false");
        return -1;
    }

    public synchronized int init(int i3, int i16) {
        boolean z16;
        if (mIsLoaded) {
            int native_init = native_init(i3, i16);
            if (native_init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            return native_init;
        }
        LogUtil.w(TAG, "library missed");
        return -1;
    }

    public synchronized boolean isAbsoluteMute() {
        boolean z16 = false;
        if (this.mIsValid) {
            if (native_isabsolutemute() == 0) {
                z16 = true;
            }
            return z16;
        }
        LogUtil.w(TAG, "lmIsValid == false");
        return false;
    }

    public synchronized boolean isSoundLow() {
        boolean z16 = false;
        if (this.mIsValid) {
            if (native_issoundlow() == 1) {
                z16 = true;
            }
            return z16;
        }
        LogUtil.w(TAG, "lmIsValid == false");
        return false;
    }

    public synchronized int process(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_process(bArr, i3);
        }
        LogUtil.w(TAG, "lmIsValid == false");
        return -1;
    }

    public synchronized int release() {
        if (this.mIsValid) {
            this.mIsValid = false;
            return native_release();
        }
        LogUtil.w(TAG, "library missed");
        return -1;
    }
}
