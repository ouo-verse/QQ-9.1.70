package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class KaraAudioAgc {
    private static final String TAG = "KaraAudioAgc";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    public boolean mIsValid = false;
    private long nativeHandle;

    private native boolean native_Init(int i3, int i16);

    private native int native_Process(byte[] bArr, int i3);

    private native boolean native_Release();

    private native boolean native_setAgcEnable(boolean z16);

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

    public synchronized int process(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return native_Process(bArr, i3);
        }
        return -2;
    }

    public synchronized void release() {
        if (this.mIsValid) {
            native_Release();
        }
        this.mIsValid = false;
    }

    public synchronized boolean setAgcEnable(boolean z16) {
        if (this.mIsValid) {
            return native_setAgcEnable(z16);
        }
        return false;
    }
}
