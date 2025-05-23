package com.tencent.karaoke.audiobasesdk.audiofx;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Visualizer {
    private static final String TAG = "Visualizer";
    private static volatile boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int init();

    private native int release();

    private native int visualize(byte[] bArr, int i3);

    public synchronized int visualizerInit() {
        boolean z16;
        if (mIsLoaded) {
            int init = init();
            if (init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            return init;
        }
        LogUtil.e(TAG, "failed to load library");
        return -1;
    }

    public synchronized int visualizerProcess(byte[] bArr, int i3) {
        if (this.mIsValid) {
            return visualize(bArr, i3);
        }
        LogUtil.e(TAG, "mIsValid == false");
        return -1;
    }

    public synchronized int visualizerRelease() {
        if (!this.mIsValid) {
            LogUtil.e(TAG, "mIsValid == false");
            return -1;
        }
        this.mIsValid = false;
        return release();
    }
}
