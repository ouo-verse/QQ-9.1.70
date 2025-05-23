package com.tencent.tmediacodec.preload.glrender;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.tmediacodec.hook.PreloadSurface;
import com.tencent.tmediacodec.hook.PreloadSurfaceTexture;
import com.tencent.tmediacodec.util.LogUtils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes26.dex */
public class OutputSurface implements SurfaceTexture.OnFrameAvailableListener {
    static IPatchRedirector $redirector_ = null;
    static final int EGL_OPENGL_ES2_BIT = 4;
    static final String TAG = "OutputSurface";
    static final boolean VERBOSE = false;
    EGL10 mEGL;
    EGLContext mEGLContext;
    EGLDisplay mEGLDisplay;
    EGLSurface mEGLSurface;
    boolean mFrameAvailable;
    Object mFrameSyncObject;
    Surface mSurface;
    PreloadSurfaceTexture mSurfaceTexture;
    TextureRender mTextureRender;

    public OutputSurface(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mFrameSyncObject = new Object();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mTextureRender.changeFragmentShader(str);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mTextureRender.drawFrame(this.mSurfaceTexture);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Surface) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mSurface;
    }

    public void makeCurrent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) surfaceTexture);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
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
        PreloadSurfaceTexture preloadSurfaceTexture = new PreloadSurfaceTexture(this.mTextureRender.getTextureId());
        this.mSurfaceTexture = preloadSurfaceTexture;
        preloadSurfaceTexture.setActionCallback(new PreloadSurfaceTexture.ActionCallback() { // from class: com.tencent.tmediacodec.preload.glrender.OutputSurface.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OutputSurface.this);
                }
            }

            @Override // com.tencent.tmediacodec.hook.PreloadSurfaceTexture.ActionCallback
            public void onReleased() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                LogUtils.d(OutputSurface.TAG, "mSurfaceTexture:" + OutputSurface.this.mSurfaceTexture + " onReleased, release OutputSurface");
                OutputSurface.this.release();
            }
        });
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        this.mSurface = new PreloadSurface(this.mSurfaceTexture);
    }

    public OutputSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mFrameSyncObject = new Object();
            setup();
        }
    }
}
