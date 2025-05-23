package org.libpag;

import android.graphics.Matrix;
import android.graphics.RectF;
import org.extra.tools.Reporter;

/* loaded from: classes29.dex */
public class PAGPlayer {

    /* renamed from: a, reason: collision with root package name */
    private PAGSurface f423751a = null;
    private long nativeContext = 0;

    static {
        org.extra.tools.a.b("ffavc");
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    public PAGPlayer() {
        nativeSetup();
        PAGLicenseManager.a(null);
        Reporter.c();
    }

    private native void nativeFinalize();

    private native void nativeGetMatrix(float[] fArr);

    private static final native void nativeInit();

    private final native void nativeRelease();

    private native void nativeSetMatrix(float f16, float f17, float f18, float f19, float f26, float f27);

    private native void nativeSetSurface(long j3);

    private final native void nativeSetup();

    public native boolean cacheEnabled();

    public native float cacheScale();

    public native long currentFrame();

    public native long duration();

    protected void finalize() {
        nativeFinalize();
    }

    public boolean flush() {
        return flushAndFenceSync(null);
    }

    public native boolean flushAndFenceSync(long[] jArr);

    public native RectF getBounds(PAGLayer pAGLayer);

    public native PAGComposition getComposition();

    public native PAGLayer[] getLayersUnderPoint(float f16, float f17);

    public native double getProgress();

    public PAGSurface getSurface() {
        return this.f423751a;
    }

    public native boolean hitTestPoint(PAGLayer pAGLayer, float f16, float f17, boolean z16);

    public Matrix matrix() {
        float[] fArr = new float[9];
        nativeGetMatrix(fArr);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public native float maxFrameRate();

    public native void prepare();

    public void release() {
        nativeRelease();
    }

    public native int scaleMode();

    public native void setCacheEnabled(boolean z16);

    public native void setCacheScale(float f16);

    public native void setComposition(PAGComposition pAGComposition);

    public void setMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        nativeSetMatrix(fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]);
    }

    public native void setMaxFrameRate(float f16);

    public native void setProgress(double d16);

    public native void setScaleMode(int i3);

    public void setSurface(PAGSurface pAGSurface) {
        this.f423751a = pAGSurface;
        if (pAGSurface == null) {
            nativeSetSurface(0L);
        } else {
            nativeSetSurface(pAGSurface.nativeSurface);
        }
    }

    public native void setUseDiskCache(boolean z16);

    public native void setVideoEnabled(boolean z16);

    public native boolean useDiskCache();

    public native boolean videoEnabled();

    public native boolean waitSync(long j3);
}
