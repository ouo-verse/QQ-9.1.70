package com.tencent.mobileqq.shortvideo.hwcodec;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoSourceHelper {
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_SUCCESS = 0;
    public static WeakReference<VideoSourceHelper> sCurrentRef;
    private long mAfFilePtr;
    private String mAfPath;
    public int mChannel;
    private int mDestVideoHeight;
    private int mDestVideoWidth;
    public int mPCMFormat;
    public int mSampleRate;
    private long mTmpBufferPtr;
    private long mVfFilePtr;
    private String mVfPath;
    private final Object mGetFrameBitmapLock = new Object();
    private int mVideoBufferSize = 0;
    private int mAudioBufferSize = 0;
    private boolean isInited = false;
    public int mOrientationDegree = 0;

    public VideoSourceHelper(String str, String str2) {
        this.mVfPath = str;
        this.mAfPath = str2;
        sCurrentRef = new WeakReference<>(this);
    }

    private native int nativeCloseHelper(long j3, long j16, long j17);

    private native int nativeGetNextAudioFrame(byte[] bArr, int i3, long j3);

    private native int nativeGetNextVideoFrame(byte[] bArr, int i3, long j3, long[] jArr, long j16, int i16);

    private native int nativeGetNextVideoFrameBitmap(long j3, Bitmap bitmap, long j16);

    private native int nativeGetNextVideoFrameCache(long j3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, boolean z16);

    private native int nativeGetVideoFrameBitMapByIndex(long j3, Bitmap bitmap, long j16, int i3);

    private native int nativeInitHelper(String str, String str2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3);

    private native int nativeResetSource(long j3, long j16);

    public static native int nativeSetMaxPhotoFrameCount(int i3);

    public static native int nativeSetMosaic(int i3, byte[] bArr);

    public static native int nativeSetPlayAFMute(boolean z16);

    public static native void nativeSetPlayGapFrameCount(int i3);

    public static native void nativeSetPlayMode(int i3);

    public static native void nativeSetPlayStepFrameCount(int i3);

    public static native int nativeSetSlideMode(int i3, float f16);

    public void closeHelper() {
        if (!this.isInited) {
            return;
        }
        try {
            nativeCloseHelper(this.mVfFilePtr, this.mAfFilePtr, this.mTmpBufferPtr);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        this.isInited = false;
        this.mVfFilePtr = 0L;
        this.mAfFilePtr = 0L;
        this.mTmpBufferPtr = 0L;
    }

    public int[] getBufferSize() {
        return new int[]{this.mVideoBufferSize, this.mAudioBufferSize};
    }

    public int getFirstFrameIndexArray(long j3, long[] jArr) {
        if (!this.isInited) {
            return -1;
        }
        int i3 = 0;
        try {
            synchronized (this.mGetFrameBitmapLock) {
                i3 = nativeGetFirstFrameIndexArray(this.mVfFilePtr, j3, jArr);
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        return i3;
    }

    public int getNextAudioFrame(byte[] bArr) {
        if (!this.isInited) {
            return -1;
        }
        return nativeGetNextAudioFrame(bArr, bArr.length, this.mAfFilePtr);
    }

    public int getNextVideoFrame(byte[] bArr, long[] jArr, int i3) {
        if (!this.isInited || jArr.length < 1) {
            return -1;
        }
        return nativeGetNextVideoFrame(bArr, bArr.length, this.mVfFilePtr, jArr, this.mTmpBufferPtr, i3);
    }

    public int getNextVideoFrameBitmap(Bitmap bitmap) {
        if (!this.isInited) {
            return -1;
        }
        int i3 = 0;
        try {
            synchronized (this.mGetFrameBitmapLock) {
                i3 = nativeGetNextVideoFrameBitmap(this.mVfFilePtr, bitmap, this.mTmpBufferPtr);
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        return i3;
    }

    public int[] getSourceVideoParam() {
        return new int[]{this.mDestVideoWidth, this.mDestVideoHeight};
    }

    public int getVideoFrameBitmap(Bitmap bitmap, long j3) {
        if (!this.isInited) {
            return -1;
        }
        int i3 = 0;
        try {
            synchronized (this.mGetFrameBitmapLock) {
                i3 = nativeGetVideoFrameBitmap(this.mVfFilePtr, bitmap, this.mTmpBufferPtr, j3);
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        return i3;
    }

    public int getVideoFrameByIndex(Bitmap bitmap, int i3) {
        if (!this.isInited) {
            return -1;
        }
        int i16 = 0;
        try {
            synchronized (this.mGetFrameBitmapLock) {
                i16 = nativeGetVideoFrameBitMapByIndex(this.mVfFilePtr, bitmap, this.mTmpBufferPtr, i3);
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        return i16;
    }

    public int initHelperParam() {
        int i3;
        long[] jArr = new long[3];
        int[] iArr = new int[2];
        int[] iArr2 = new int[3];
        int[] iArr3 = new int[3];
        try {
            i3 = nativeInitHelper(this.mVfPath, this.mAfPath, jArr, iArr, iArr2, iArr3);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            i3 = -1;
        }
        if (i3 == 0) {
            this.mVfFilePtr = jArr[0];
            this.mAfFilePtr = jArr[1];
            this.mTmpBufferPtr = jArr[2];
            this.mVideoBufferSize = iArr[0];
            this.mAudioBufferSize = 4000;
            this.mDestVideoWidth = iArr2[0];
            this.mDestVideoHeight = iArr2[1];
            this.mOrientationDegree = iArr2[2];
            this.mSampleRate = iArr3[0];
            if (iArr3[1] == 1) {
                this.mChannel = 2;
            } else {
                this.mChannel = 3;
            }
            if (iArr3[2] == 0) {
                this.mPCMFormat = 3;
            } else {
                this.mPCMFormat = 2;
            }
            this.isInited = true;
        }
        return i3;
    }

    public native int nativeGetFirstFrameIndexArray(long j3, long j16, long[] jArr);

    public native int nativeGetVideoFrameBitmap(long j3, Bitmap bitmap, long j16, long j17);

    public native int nativeSetCurrentVideoFrameRange(long j3, boolean z16, long j16, long j17, long j18, long j19);

    public int resetDataSource() {
        if (!this.isInited) {
            return -1;
        }
        try {
            return nativeResetSource(this.mVfFilePtr, this.mAfFilePtr);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public int setCurrentVideoFrameRange(boolean z16, long j3, long j16, long j17, long j18) {
        if (!this.isInited) {
            return -1;
        }
        try {
            return nativeSetCurrentVideoFrameRange(this.mVfFilePtr, z16, j3, j16, j17, j18);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public int getNextVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, boolean z16) {
        if (!this.isInited) {
            return -1;
        }
        try {
            return nativeGetNextVideoFrameCache(this.mVfFilePtr, byteBuffer, byteBuffer2, byteBuffer3, z16);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return 0;
        }
    }
}
