package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videobase.videobase.f;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
class NativeVideoCaptureListener implements com.tencent.liteav.videobase.videobase.c, CaptureSourceInterface.CaptureSourceListener {
    private static final String TAG = "NativeVideoCaptureListener";
    private long mNativeHandler;

    public NativeVideoCaptureListener(long j3) {
        this.mNativeHandler = j3;
    }

    private static native void nativeOnAutoFocusEnabled(long j3, boolean z16);

    private static native void nativeOnCaptureError(long j3, int i3, String str);

    private static native void nativeOnCaptureFirstFrame(long j3);

    private static native void nativeOnCapturePaused(long j3);

    private static native void nativeOnCaptureResumed(long j3);

    private static native void nativeOnCaptureStopped(long j3);

    private static native void nativeOnFrameAvailable(long j3, PixelFrame pixelFrame);

    private static native void nativeOnScreenDisplayOrientationChanged(long j3, int i3);

    private static native void nativeOnStartFinish(long j3, boolean z16);

    private static native void nativeOnZoomEnabled(long j3, boolean z16);

    public synchronized void notifyError(e.a aVar, String str) {
        if (this.mNativeHandler == 0) {
            return;
        }
        int a16 = com.tencent.liteav.videobase.videobase.e.a(aVar);
        if (a16 != 0) {
            nativeOnCaptureError(this.mNativeHandler, a16, str);
            return;
        }
        LiteavLog.i(TAG, "notifyError error code:" + aVar + ", do not need transfer to LiteAvCode:" + a16);
    }

    public void notifyEvent(e.b bVar, int i3, String str) {
    }

    @Override // com.tencent.liteav.videobase.videobase.c
    public synchronized void notifyWarning(e.c cVar, String str) {
    }

    public synchronized void onCameraTouchEnable(boolean z16) {
        boolean z17;
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            if (!z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            nativeOnAutoFocusEnabled(j3, z17);
        }
    }

    public synchronized void onCameraZoomEnable(boolean z16) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnZoomEnabled(j3, z16);
        }
    }

    public synchronized void onCaptureError() {
    }

    public synchronized void onCaptureFirstFrame() {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnCaptureFirstFrame(j3);
        }
    }

    public synchronized void onFrameAvailable(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnFrameAvailable(j3, pixelFrame);
        }
    }

    public synchronized void onScreenDisplayOrientationChanged(k kVar) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnScreenDisplayOrientationChanged(j3, k.a(kVar));
        }
    }

    public synchronized void onStartFinish(boolean z16) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnStartFinish(j3, z16);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }

    public synchronized void updateStatus(f fVar, Object obj) {
    }

    public synchronized void notifyEvent(e.b bVar, Object obj, String str) {
        long j3 = this.mNativeHandler;
        if (j3 == 0) {
            return;
        }
        if (bVar == e.b.EVT_VIDEO_CAPTURE_FIRST_FRAME) {
            nativeOnCaptureFirstFrame(j3);
            return;
        }
        if (bVar == e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED) {
            nativeOnCapturePaused(j3);
        } else if (bVar == e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME) {
            nativeOnCaptureResumed(j3);
        } else {
            if (bVar == e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS) {
                nativeOnCaptureStopped(j3);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.c
    public synchronized void updateStatus(f fVar, int i3, Object obj) {
    }
}
