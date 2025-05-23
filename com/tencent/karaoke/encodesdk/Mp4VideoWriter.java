package com.tencent.karaoke.encodesdk;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Mp4VideoWriter {
    private static boolean IS_LOAD = false;
    private static String TAG = "Mp4VideoWriter";
    private long mTimeScale = 90000;
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

    private native int native_Init(String str, String str2);

    private native void native_release();

    private native int native_writeVideoFrame(byte[] bArr, int i3, boolean z16, long j3);

    public long getTimeScale() {
        return this.mTimeScale;
    }

    public int init(String str, String str2) {
        if (!IS_LOAD) {
            return -1;
        }
        return native_Init(str, str2);
    }

    public void release() {
        if (!IS_LOAD) {
            return;
        }
        native_release();
    }

    public void setTimeScale(int i3) {
        this.mTimeScale = i3;
    }

    public int writeVideoFrame(byte[] bArr, int i3, boolean z16, long j3) {
        if (!IS_LOAD) {
            return -1;
        }
        return native_writeVideoFrame(bArr, i3, z16, j3);
    }
}
