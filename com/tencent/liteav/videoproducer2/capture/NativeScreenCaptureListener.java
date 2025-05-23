package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class NativeScreenCaptureListener implements SurfaceTexture.OnFrameAvailableListener {
    private final CustomHandler mCallbackHandler = new CustomHandler(Looper.myLooper());
    private long mNativeHandle;

    public NativeScreenCaptureListener(long j3) {
        this.mNativeHandle = j3;
    }

    private static native void nativeOnCaptureError(long j3);

    private static native void nativeOnClassNotFound(long j3);

    private static native void nativeOnFrameAvailable(long j3, SurfaceTexture surfaceTexture);

    private static native void nativeOnStartFinish(long j3, boolean z16, boolean z17);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyCaptureError() {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeOnCaptureError(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyClassNotFound() {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeOnClassNotFound(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyFrameAvailable(SurfaceTexture surfaceTexture) {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeOnFrameAvailable(j3, surfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyStartFinish(boolean z16, boolean z17) {
        long j3 = this.mNativeHandle;
        if (j3 != 0) {
            nativeOnStartFinish(j3, z16, z17);
        }
    }

    public Handler getCallbackHandler() {
        return this.mCallbackHandler;
    }

    public void onCaptureError() {
        this.mCallbackHandler.runOrPost(h.a(this));
    }

    public void onClassNotFound() {
        this.mCallbackHandler.runOrPost(i.a(this));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mCallbackHandler.runOrPost(f.a(this, surfaceTexture));
    }

    public void onStartFinish(boolean z16, boolean z17) {
        this.mCallbackHandler.runOrPost(g.a(this, z16, z17));
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandle = 0L;
    }
}
