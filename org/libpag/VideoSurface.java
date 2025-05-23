package org.libpag;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: P */
/* loaded from: classes29.dex */
class VideoSurface implements SurfaceTexture.OnFrameAvailableListener {
    long nativeContext = 0;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    VideoSurface(int i3, int i16) {
        nativeSetup(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static VideoSurface a(int i3, int i16) {
        VideoSurface videoSurface = new VideoSurface(i3, i16);
        if (videoSurface.nativeContext == 0) {
            return null;
        }
        return videoSurface;
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup(int i3, int i16);

    private native void notifyFrameAvailable();

    protected void finalize() {
        nativeFinalize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native Surface getInputSurface();

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyFrameAvailable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        nativeRelease();
    }
}
