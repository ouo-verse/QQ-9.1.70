package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
class NativeRenderViewListener implements RenderViewHelperInterface.RenderViewListener {
    private long mNativeHandler;

    public NativeRenderViewListener(long j3) {
        this.mNativeHandler = j3;
    }

    private static native void nativeOnRequestRedraw(long j3, Bitmap bitmap);

    private static native void nativeOnSurfaceChanged(long j3, Surface surface, boolean z16);

    private static native void nativeOnSurfaceDestroy(long j3);

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onRequestRedraw(Bitmap bitmap) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnRequestRedraw(j3, bitmap);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onSurfaceChanged(Surface surface, boolean z16) {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnSurfaceChanged(j3, surface, z16);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onSurfaceDestroy() {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnSurfaceDestroy(j3);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }
}
