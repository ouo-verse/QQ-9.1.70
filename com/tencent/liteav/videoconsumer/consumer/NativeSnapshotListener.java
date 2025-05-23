package com.tencent.liteav.videoconsumer.consumer;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class NativeSnapshotListener {
    private long mNativeVideoSnapListener;

    NativeSnapshotListener(long j3) {
        this.mNativeVideoSnapListener = j3;
    }

    private native void nativeDestroy(long j3);

    private native void nativeOnComplete(long j3, Bitmap bitmap);

    protected void finalize() throws Throwable {
        long j3 = this.mNativeVideoSnapListener;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.mNativeVideoSnapListener = 0L;
        }
        super.finalize();
    }

    public void onComplete(Bitmap bitmap) {
        long j3 = this.mNativeVideoSnapListener;
        if (j3 != 0) {
            nativeOnComplete(j3, bitmap);
            this.mNativeVideoSnapListener = 0L;
        }
    }
}
