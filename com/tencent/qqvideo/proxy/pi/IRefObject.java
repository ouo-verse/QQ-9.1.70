package com.tencent.qqvideo.proxy.pi;

/* compiled from: P */
/* loaded from: classes34.dex */
public class IRefObject {
    private long mNativePtr;

    public IRefObject(long j3) {
        this.mNativePtr = j3;
    }

    private static native void freeNativePtr(long j3);

    private synchronized long getNativePtr() {
        return this.mNativePtr;
    }

    public native void finalize();

    public native synchronized void release();

    public native synchronized void retain();
}
