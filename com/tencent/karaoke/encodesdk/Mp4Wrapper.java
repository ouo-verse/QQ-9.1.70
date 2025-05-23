package com.tencent.karaoke.encodesdk;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Mp4Wrapper {
    private static boolean IS_LOAD = false;
    private static final String TAG = "Mp4Wrapper";
    private long nativeHandle;

    static {
        try {
            System.loadLibrary("mp4encode");
            IS_LOAD = true;
        } catch (Exception e16) {
            Log.d(TAG, e16.getMessage());
        } catch (UnsatisfiedLinkError e17) {
            Log.d(TAG, e17.getMessage());
        }
    }

    private native int native_copyAudioData(String str);

    private native int native_copyVideoData(String str);

    private native int native_init(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27);

    private native int native_optimize();

    private native int native_release();

    private native int native_writeAudio(byte[] bArr, int i3);

    private native int native_writeVideo(byte[] bArr, int i3, long j3);

    public int copyAudioData(String str) {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_copyAudioData(str);
    }

    public int copyVideoData(String str) {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_copyVideoData(str);
    }

    public int init(String str, int i3, int i16, int i17) {
        if (IS_LOAD) {
            return native_init(str, 0, 0, 0, 0, i3, i16, i17);
        }
        return -1001;
    }

    public int optimize() {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_optimize();
    }

    public int release() {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_release();
    }

    public int writeAudio(byte[] bArr, int i3) {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_writeAudio(bArr, i3);
    }

    public int writeVideo(byte[] bArr, int i3, long j3) {
        if (!IS_LOAD) {
            return -1001;
        }
        return native_writeVideo(bArr, i3, j3);
    }

    public int init(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        if (IS_LOAD) {
            return native_init(str, i3, i16, i17, i18, i19, i26, i27);
        }
        return -1001;
    }
}
