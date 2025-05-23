package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioSoundTouch {
    private static final String TAG = "AudioSoundTouch";
    private static volatile boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_init(int i3, int i16);

    private native int native_process(byte[] bArr, int i3, byte[] bArr2, int i16);

    private native void native_release();

    private native int native_setTempo(float f16);

    public synchronized int init(int i3, int i16) {
        boolean z16;
        if (!mIsLoaded) {
            LogUtil.e(TAG, "load library failed");
            return -1;
        }
        int native_init = native_init(i3, i16);
        if (native_init == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsValid = z16;
        return native_init;
    }

    public synchronized int process(byte[] bArr, int i3, byte[] bArr2, int i16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        return native_process(bArr, i3, bArr2, i16);
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        }
    }

    public synchronized int setTempo(float f16) {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        return native_setTempo(f16);
    }
}
