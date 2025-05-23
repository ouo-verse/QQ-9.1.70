package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraVolumeScaler {
    private static final int INPUT_BUFFER_SIZE = 4096;
    private static final int OUTPUT_BUFFER_SIZE = 8192;
    private static final String TAG = "KaraVolumeScaler";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_init(int i3, int i16);

    private native int native_process(byte[] bArr, int i3);

    private native void native_release();

    private native void native_volume_scale(int i3);

    public synchronized void init(int i3, int i16) {
        boolean z16;
        if (mIsLoaded) {
            int native_init = native_init(i3, i16);
            if (native_init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            if (!z16) {
                LogUtil.w(TAG, "KaraVolumeScaler init failed: " + native_init);
            }
        }
    }

    public synchronized int process(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_process(bArr, i3);
        }
        return -1;
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        }
    }

    public synchronized void setVolumeScale(int i3) {
        if (this.mIsValid) {
            native_volume_scale(i3);
        }
    }
}
