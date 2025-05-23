package com.tencent.karaoke.encodesdk;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Mp4VideoReader {
    private static boolean IS_LOAD = false;
    private static String TAG = "Mp4VideoReader";
    private a mFrameListener;
    private long nativeHandle;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
    }

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

    private native int native_Init(String str);

    private native int native_decodeVideoFrame();

    private native void native_release();

    private native void native_skipVideoFrame(int i3);

    public int init(String str) {
        if (!IS_LOAD) {
            return -1;
        }
        return native_Init(str);
    }

    public int readVideoFrame() {
        if (!IS_LOAD) {
            return -1;
        }
        return native_decodeVideoFrame();
    }

    public void release() {
        if (!IS_LOAD) {
            return;
        }
        native_release();
    }

    public void skipFrame() {
        native_skipVideoFrame(1);
    }

    public void skipFrames(int i3) {
        native_skipVideoFrame(i3);
    }

    public void setVideoFrameListener(a aVar) {
    }

    public void onVideoFrame(byte[] bArr, int i3, boolean z16, long j3) {
    }
}
