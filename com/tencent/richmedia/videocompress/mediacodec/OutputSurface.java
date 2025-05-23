package com.tencent.richmedia.videocompress.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes25.dex */
public class OutputSurface implements SurfaceTexture.OnFrameAvailableListener {
    static final int EGL_OPENGL_ES2_BIT = 4;
    static final String TAG = "OutputSurface";
    static final boolean VERBOSE = false;
    EGL10 mEGL;
    EGLContext mEGLContext;
    EGLDisplay mEGLDisplay;
    EGLSurface mEGLSurface;
    boolean mFrameAvailable;
    Object mFrameSyncObject = new Object();
    Surface mSurface;
    SurfaceTexture mSurfaceTexture;
    TextureRender mTextureRender;

    public OutputSurface(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            eglSetup(i3, i16);
            makeCurrent();
            setup();
            return;
        }
        throw new IllegalArgumentException();
    }

    @SuppressLint({"NewApi"})
    public void awaitNewImage() {
        synchronized (this.mFrameSyncObject) {
            while (!this.mFrameAvailable) {
                try {
                    this.mFrameSyncObject.wait(5000L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                if (!this.mFrameAvailable) {
                    throw new RuntimeException("Surface frame wait timed out");
                    break;
                }
            }
            this.mFrameAvailable = false;
        }
        this.mTextureRender.checkGlError("before updateTexImage");
        this.mSurfaceTexture.updateTexImage();
    }

    public void changeFragmentShader(String str) {
        this.mTextureRender.changeFragmentShader(str);
    }

    void checkEglError(String str) {
        boolean z16 = false;
        while (true) {
            int eglGetError = this.mEGL.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z16 = true;
        }
        if (!z16) {
        } else {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public void drawImage() {
        this.mTextureRender.drawFrame(this.mSurfaceTexture);
    }

    void eglSetup(int i3, int i16) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEGL = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEGLDisplay = eglGetDisplay;
        if (this.mEGL.eglInitialize(eglGetDisplay, null)) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.mEGL.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                checkEglError("eglCreateContext");
                if (this.mEGLContext != null) {
                    this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, eGLConfigArr[0], new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, i3, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, i16, 12344});
                    checkEglError("eglCreatePbufferSurface");
                    if (this.mEGLSurface != null) {
                        return;
                    } else {
                        throw new RuntimeException("surface was null");
                    }
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        throw new RuntimeException("unable to initialize EGL10");
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void makeCurrent() {
        if (this.mEGL != null) {
            checkEglError("before makeCurrent");
            EGL10 egl10 = this.mEGL;
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = this.mEGLSurface;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
                return;
            } else {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        }
        throw new RuntimeException("not configured for makeCurrent");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mFrameSyncObject) {
            if (!this.mFrameAvailable) {
                this.mFrameAvailable = true;
                this.mFrameSyncObject.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }

    public void release() {
        EGL10 egl10 = this.mEGL;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.mEGLContext)) {
                EGL10 egl102 = this.mEGL;
                EGLDisplay eGLDisplay = this.mEGLDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
            this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        }
        this.mSurface.release();
        this.mEGLDisplay = null;
        this.mEGLContext = null;
        this.mEGLSurface = null;
        this.mEGL = null;
        this.mTextureRender = null;
        this.mSurface = null;
        this.mSurfaceTexture = null;
    }

    void setup() {
        TextureRender textureRender = new TextureRender();
        this.mTextureRender = textureRender;
        textureRender.surfaceCreated();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureRender.getTextureId());
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.mSurface = new Surface(this.mSurfaceTexture);
    }

    public OutputSurface() {
        setup();
    }
}
