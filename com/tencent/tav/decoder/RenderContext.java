package com.tencent.tav.decoder;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.ark.EGLContextHolder;
import com.tencent.filter.GLSLRender;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RenderContext implements IDecoderTrack.SurfaceCreator {
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final String TAG = "RenderContext";
    private HashMap<Surface, String> activeSurfaceCache;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private HashMap<String, Surface> freeSurfaceCache;

    @Nullable
    private CGRect glViewportRect;
    private int height;
    private boolean isSharedContext;
    private boolean pBufferEnable;
    private final RenderContextParams params;
    private volatile boolean released;
    private List<Surface> releasingSurfaceCache;

    @Nullable
    private Surface surface;
    private long threadId;
    private HashMap<Surface, VideoTexture> videoTextureMap;
    private int width;

    public RenderContext() {
        this.params = new RenderContextParams();
        this.isSharedContext = false;
        this.released = false;
        this.threadId = -1L;
        this.pBufferEnable = false;
        this.videoTextureMap = new HashMap<>();
        this.activeSurfaceCache = new HashMap<>();
        this.freeSurfaceCache = new HashMap<>();
        this.releasingSurfaceCache = new ArrayList();
    }

    public static boolean checkEglActionSuccess(String str) throws RuntimeException {
        return checkEglActionSuccess(str, false);
    }

    public static void checkEglError(String str) throws RuntimeException {
        checkEglActionSuccess(str);
    }

    private void checkThread() {
        if (this.threadId != Thread.currentThread().getId()) {
            Logger.e(TAG, "\u7ebf\u7a0b\u4e0d\u5bf9\uff0c\u6ce8\u610fEGL\u76f8\u5173\u7684\u6cc4\u9732\u95ee\u9898\uff01threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
        }
    }

    public static int createTexture(int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i16 = iArr[0];
        GLES20.glBindTexture(i3, i16);
        checkEglError("glBindTexture mTextureID");
        GLES20.glTexParameterf(i3, 10241, 9729.0f);
        GLES20.glTexParameterf(i3, 10240, 9729.0f);
        GLES20.glTexParameteri(i3, 10242, 33071);
        GLES20.glTexParameteri(i3, 10243, 33071);
        checkEglError("glTexParameter");
        return i16;
    }

    private synchronized void eglSetup(EGLContext eGLContext) {
        eglSetup(eGLContext, false);
    }

    public static TextureInfo newTextureInfo(CGSize cGSize) {
        return newTextureInfo(cGSize.width, cGSize.height);
    }

    private synchronized void release(Surface surface) {
        checkThread();
        if (surface == null) {
            return;
        }
        if (this.videoTextureMap.containsKey(surface)) {
            this.videoTextureMap.remove(surface).release();
        }
        surface.release();
    }

    private void releaseReleadingSurface() {
        checkThread();
        for (int i3 = 0; i3 < this.releasingSurfaceCache.size(); i3++) {
            release(this.releasingSurfaceCache.remove(i3));
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized Surface createOutputSurface(int i3, int i16, int i17) {
        Surface remove;
        if (this.released) {
            return null;
        }
        checkThread();
        releaseReleadingSurface();
        String str = i3 + "*" + i16 + "-" + i17;
        if (this.freeSurfaceCache.containsKey(str) && (remove = this.freeSurfaceCache.remove(str)) != null) {
            this.activeSurfaceCache.put(remove, str);
            return remove;
        }
        makeCurrent();
        VideoTexture videoTexture = new VideoTexture(i3, i16, 36197, i17);
        videoTexture.setRenderContext(this);
        Surface surface = new Surface(videoTexture.surfaceTexture());
        this.videoTextureMap.put(surface, videoTexture);
        this.activeSurfaceCache.put(surface, str);
        return surface;
    }

    public EGLContext eglContext() {
        return this.eglContext;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized void free(Surface surface) {
        Logger.i(TAG, "free " + Thread.currentThread().getId());
        if (surface == null) {
            return;
        }
        String remove = this.activeSurfaceCache.remove(surface);
        if (!TextUtils.isEmpty(remove)) {
            this.freeSurfaceCache.containsKey(remove);
        }
        this.releasingSurfaceCache.add(surface);
    }

    public long getEglSurfaceHandle() {
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface != null) {
            return eGLSurface.getNativeHandle();
        }
        return 0L;
    }

    @Nullable
    public CGRect getGlViewportRect() {
        return this.glViewportRect;
    }

    @NonNull
    public RenderContextParams getParams() {
        return this.params;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public int height() {
        return this.height;
    }

    public boolean isPBufferEnable() {
        return this.pBufferEnable;
    }

    public synchronized void makeCurrent() {
        makeCurrent(false);
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    @Deprecated
    public void setParams(@Nullable RenderContextParams renderContextParams) {
        if (renderContextParams != null && renderContextParams.getAllParams() != null) {
            this.params.getAllParams().putAll(renderContextParams.getAllParams());
        }
    }

    @RequiresApi(api = 18)
    public synchronized void setPresentationTime(long j3) {
        EGLDisplay eGLDisplay;
        EGLSurface eGLSurface;
        if (this.released) {
            return;
        }
        if (this.surface != null && (eGLDisplay = this.eglDisplay) != null && (eGLSurface = this.eglSurface) != null) {
            EGLExt.eglPresentationTimeANDROID(eGLDisplay, eGLSurface, j3 * 1000);
        }
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public synchronized boolean swapBuffers() {
        EGLDisplay eGLDisplay;
        EGLSurface eGLSurface;
        checkThread();
        if (!this.released && (eGLDisplay = this.eglDisplay) != null && (eGLSurface = this.eglSurface) != null) {
            return EGL14.eglSwapBuffers(eGLDisplay, eGLSurface);
        }
        return false;
    }

    public String toString() {
        return "RenderContext{_eglContext=" + this.eglContext + ", isSharedContext=" + this.isSharedContext + ", released=" + this.released + '}';
    }

    public void updateViewport(CGRect cGRect) {
        if (cGRect == null) {
            return;
        }
        this.glViewportRect = cGRect;
        makeCurrent();
        PointF pointF = cGRect.origin;
        int i3 = (int) pointF.x;
        int i16 = (int) pointF.y;
        CGSize cGSize = cGRect.size;
        GLES20.glViewport(i3, i16, (int) cGSize.width, (int) cGSize.height);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized VideoTexture videoTextureForSurface(Surface surface) {
        return this.videoTextureMap.get(surface);
    }

    public int width() {
        return this.width;
    }

    public static boolean checkEglActionSuccess(String str, boolean z16) throws RuntimeException {
        StringBuilder sb5 = new StringBuilder("");
        boolean z17 = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            sb5.append(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z17 = true;
        }
        if (z17) {
            RuntimeException runtimeException = new RuntimeException("EGL error encountered (see log): " + sb5.toString());
            Logger.e(TAG, "checkEglActionSuccess: ", runtimeException);
            if (z16) {
                throw runtimeException;
            }
        }
        return !z17;
    }

    @NonNull
    public static TextureInfo newTextureInfo(float f16, float f17) {
        return newTextureInfo((int) f16, (int) f17);
    }

    private synchronized void eglSetup(EGLContext eGLContext, boolean z16) {
        EGLDisplay eglGetDisplay;
        this.threadId = Thread.currentThread().getId();
        if (this.released) {
            return;
        }
        try {
            eglGetDisplay = EGL14.eglGetDisplay(0);
            this.eglDisplay = eglGetDisplay;
        } catch (Error | Exception e16) {
            Logger.e(TAG, "eglSetup: ", e16);
            if (z16) {
                throw e16;
            }
        }
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            Logger.e(TAG, "eglSetup: ", new RuntimeException("unable to get EGL14 display"));
            return;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.eglDisplay = null;
            Logger.e(TAG, "eglSetup: ", new RuntimeException("unable to initialize EGL14"));
            return;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            Logger.e(TAG, "eglSetup: ", new RuntimeException("unable to find RGB888+recordable ES2 EGL config"));
            return;
        }
        int[] iArr2 = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        if (eGLContext != null) {
            this.isSharedContext = true;
            this.eglContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfigArr[0], eGLContext, iArr2, 0);
            checkEglError("eglCreateContext");
            if (this.eglContext == null) {
                Logger.e(TAG, "eglSetup: ", new RuntimeException("null context"));
                return;
            }
        } else {
            this.eglContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, iArr2, 0);
            checkEglError("eglCreateContext");
            if (this.eglContext == null) {
                Logger.e(TAG, "eglSetup: ", new RuntimeException("null context"));
                return;
            }
        }
        Surface surface = this.surface;
        if (surface != null) {
            this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, eGLConfigArr[0], surface, new int[]{12344}, 0);
        } else {
            this.eglSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, eGLConfigArr[0], new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.width, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.height, 12344}, 0);
        }
        if (checkEglActionSuccess("eglCreateWindowSurface", z16)) {
            this.pBufferEnable = true;
        }
        if (this.eglSurface == null) {
            Logger.e(TAG, "eglSetup: ", new RuntimeException("surface was null"));
        }
    }

    public static TextureInfo newTextureInfo(int i3, int i16) {
        return newTextureInfo(i3, i16, false);
    }

    public synchronized void makeCurrent(boolean z16) {
        EGLSurface eGLSurface;
        EGLContext eGLContext;
        checkThread();
        if (this.released) {
            return;
        }
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != null && (eGLSurface = this.eglSurface) != null && (eGLContext = this.eglContext) != null) {
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext)) {
                checkEglError("eglMakeCurrent failed");
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("makeCurrent nullPoint exception, eglDisplay is null:");
        boolean z17 = true;
        sb5.append(this.eglDisplay == null);
        sb5.append(", eglSurface is null:");
        sb5.append(this.eglSurface == null);
        sb5.append(", eglContext is null:");
        if (this.eglContext != null) {
            z17 = false;
        }
        sb5.append(z17);
        RuntimeException runtimeException = new RuntimeException(sb5.toString());
        Logger.e(TAG, "make current error", runtimeException);
        if (z16) {
            throw runtimeException;
        }
    }

    @NonNull
    public static TextureInfo newTextureInfo(int i3, int i16, boolean z16) {
        TextureInfo textureInfo = new TextureInfo(createTexture(GLSLRender.GL_TEXTURE_2D), GLSLRender.GL_TEXTURE_2D, i3, i16, null, 0);
        textureInfo.setFormat(6408);
        if (z16) {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, textureInfo.textureID);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, textureInfo.getFormat(), textureInfo.width, textureInfo.height, 0, textureInfo.getFormat(), NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        return textureInfo;
    }

    public void updateViewport(int i3, int i16, int i17, int i18) {
        CGRect cGRect = new CGRect(i3, i16, i17, i18);
        CGRect cGRect2 = this.glViewportRect;
        if (cGRect2 == null || !cGRect2.equals(cGRect)) {
            updateViewport(cGRect);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized void release() {
        checkThread();
        if (this.released) {
            return;
        }
        makeCurrent();
        this.released = true;
        releaseReleadingSurface();
        Iterator<Surface> it = this.videoTextureMap.keySet().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        Iterator<VideoTexture> it5 = this.videoTextureMap.values().iterator();
        while (it5.hasNext()) {
            it5.next().release();
        }
        this.videoTextureMap.clear();
        try {
            EGLDisplay eGLDisplay = this.eglDisplay;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGLSurface eGLSurface2 = this.eglSurface;
                if (eGLSurface2 != null) {
                    EGL14.eglDestroySurface(this.eglDisplay, eGLSurface2);
                }
                EGLContext eGLContext = this.eglContext;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.eglDisplay, eGLContext);
                }
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.eglDisplay);
            }
        } catch (Error e16) {
            Logger.e(TAG, "release: ", e16);
        } catch (Exception e17) {
            Logger.e(TAG, "release: ", e17);
        }
        this.eglDisplay = null;
        this.eglContext = null;
        this.eglSurface = null;
        this.surface = null;
    }

    public RenderContext(int i3, int i16) {
        this(i3, i16, (Surface) null, false);
    }

    public RenderContext(int i3, int i16, boolean z16) {
        this(i3, i16, (Surface) null, z16);
    }

    public RenderContext(int i3, int i16, Surface surface) {
        this(i3, i16, surface, null, false);
    }

    public RenderContext(int i3, int i16, Surface surface, boolean z16) {
        this(i3, i16, surface, null, z16);
    }

    public RenderContext(int i3, int i16, @Nullable Surface surface, EGLContext eGLContext) {
        this(i3, i16, surface, eGLContext, false);
    }

    public RenderContext(int i3, int i16, @Nullable Surface surface, EGLContext eGLContext, boolean z16) {
        this.params = new RenderContextParams();
        this.isSharedContext = false;
        this.released = false;
        this.threadId = -1L;
        this.pBufferEnable = false;
        this.videoTextureMap = new HashMap<>();
        this.activeSurfaceCache = new HashMap<>();
        this.freeSurfaceCache = new HashMap<>();
        this.releasingSurfaceCache = new ArrayList();
        this.surface = surface;
        this.width = i3;
        this.height = i16;
        eglSetup(eGLContext, z16);
        makeCurrent(z16);
    }
}
