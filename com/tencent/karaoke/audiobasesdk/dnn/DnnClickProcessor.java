package com.tencent.karaoke.audiobasesdk.dnn;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* loaded from: classes7.dex */
public class DnnClickProcessor {
    public static final int INVALID = -1;
    public static final String TAG = "DnnClickProcessor";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    public synchronized int flush(byte[] bArr, int i3) {
        return -1;
    }

    public synchronized boolean init(String str, byte[] bArr, int i3, int i16) {
        return false;
    }

    public synchronized int process(byte[] bArr, int i3, byte[] bArr2, int i16) {
        return this.mIsValid ? -1 : -1;
    }

    public synchronized void seek(int i3) {
        if (!this.mIsValid) {
            LogUtil.i(TAG, "seek: not valid,don't need seek");
        }
    }

    public synchronized void uninit() {
        if (this.mIsValid) {
            LogUtil.i(TAG, "uninit");
            this.mIsValid = false;
        }
    }
}
