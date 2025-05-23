package org.light;

import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AudioOutput {
    private static final String TAG = "AudioOutput";
    private long nativeContext = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum SyncMode {
        NONE(0),
        SOFT_SYNC(1),
        FORCE_SYNC(2);

        public int value;

        SyncMode(int i3) {
            this.value = i3;
        }

        public static SyncMode get(int i3) {
            if (i3 == 0) {
                return NONE;
            }
            if (i3 == 1) {
                return SOFT_SYNC;
            }
            return FORCE_SYNC;
        }

        int value() {
            return this.value;
        }
    }

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    private native AudioFrame nativeCopyNextSample();

    private native AudioFrame nativeCopyNextSampleSyncEnable(int i3);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSeekTo(long j3);

    public AudioFrame copyNextSample() {
        return nativeCopyNextSample();
    }

    public AudioFrame copyNextSampleSyncEnable(SyncMode syncMode) {
        return nativeCopyNextSampleSyncEnable(syncMode.value());
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativeContext != 0) {
            nativeFinalize();
        }
    }

    public final void release() {
        nativeRelease();
    }

    public void seekTo(long j3) {
        nativeSeekTo(j3);
    }
}
