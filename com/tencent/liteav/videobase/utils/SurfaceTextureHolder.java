package com.tencent.liteav.videobase.utils;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class SurfaceTextureHolder implements SurfaceTexture.OnFrameAvailableListener {
    private CustomHandler mCallbackHandler;
    private SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private final String mTag = "SurfaceTextureHolder_" + Integer.toHexString(hashCode());
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();

    public SurfaceTextureHolder(int i3, boolean z16) {
        this.mSurfaceTexture = new SurfaceTexture(i3);
        if (z16) {
            this.mSurface = new Surface(this.mSurfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onFrameAvailable$0(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = surfaceTextureHolder.mOnFrameAvailableListener;
        if (onFrameAvailableListener != null) {
            onFrameAvailableListener.onFrameAvailable(surfaceTexture);
        }
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public float[] getTransformMatrix(boolean z16, float f16, float f17, float f18, float f19) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mThrottlers.a("getTransformMatrix"), this.mTag, "getTransformMatrix, surface texture is released!", new Object[0]);
            return null;
        }
        float[] fArr = new float[16];
        try {
            surfaceTexture.getTransformMatrix(fArr);
        } catch (Throwable th5) {
            LiteavLog.w(this.mThrottlers.a("getTransformMatrix"), this.mTag, "updateTexImage exception: ".concat(String.valueOf(th5)), new Object[0]);
        }
        if (z16) {
            if (!com.tencent.liteav.base.util.f.a(f16, 0.0f) || !com.tencent.liteav.base.util.f.a(f17, 0.0f)) {
                Matrix.translateM(fArr, 0, f16, f17, 0.0f);
            }
            if (!com.tencent.liteav.base.util.f.a(f18, 1.0f) || !com.tencent.liteav.base.util.f.a(f19, 1.0f)) {
                Matrix.scaleM(fArr, 0, f18, f19, 1.0f);
            }
        }
        return fArr;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        CustomHandler customHandler = this.mCallbackHandler;
        if (customHandler != null) {
            customHandler.runOrPost(f.a(this, surfaceTexture));
        }
    }

    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
    }

    public void setDefaultBufferSize(int i3, int i16) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mThrottlers.a("setDefaultBufferSize"), this.mTag, "setDefaultBufferSize, surface texture is released!", new Object[0]);
        } else {
            surfaceTexture.setDefaultBufferSize(i3, i16);
        }
    }

    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        Looper mainLooper;
        if (this.mSurfaceTexture == null) {
            LiteavLog.e(this.mThrottlers.a("setOnFrameAvailableListener"), this.mTag, "setOnFrameAvailableListener, surface texture is released!", new Object[0]);
            return;
        }
        if (handler != null) {
            mainLooper = handler.getLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.mCallbackHandler = new CustomHandler(mainLooper);
        this.mOnFrameAvailableListener = onFrameAvailableListener;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            this.mSurfaceTexture.setOnFrameAvailableListener(this, this.mCallbackHandler);
        } else {
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }
    }

    public void updateTexImage() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mThrottlers.a("updateTexImage"), this.mTag, "updateTexImage, surface texture is released!", new Object[0]);
            return;
        }
        try {
            surfaceTexture.updateTexImage();
        } catch (Throwable th5) {
            LiteavLog.w(this.mThrottlers.a("updateTexImage"), this.mTag, "updateTexImage exception: ".concat(String.valueOf(th5)), new Object[0]);
        }
    }
}
