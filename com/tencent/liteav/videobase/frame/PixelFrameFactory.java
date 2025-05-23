package com.tencent.liteav.videobase.frame;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class PixelFrameFactory {
    private EGLSurface mCallerEGLDrawSurface;
    private EGLSurface mCallerEGLReadSurface;
    private e mGLTexturePool;
    private final Size mLastFrameSize;
    private h mPixelFrameRenderer;
    private EGLCore mRenderEGLCore;
    private final com.tencent.liteav.base.b.b mThrottlers;
    private final String mTAG = "PixelFrameFactory_" + hashCode();
    private Object mSharedEGLContext = null;
    private EGLDisplay mCallerEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLContext mCallerEGLContext = EGL14.EGL_NO_CONTEXT;

    public PixelFrameFactory() {
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        this.mCallerEGLReadSurface = eGLSurface;
        this.mCallerEGLDrawSurface = eGLSurface;
        this.mLastFrameSize = new Size();
        this.mThrottlers = new com.tencent.liteav.base.b.b();
    }

    private PixelFrame copyTexture(PixelFrame pixelFrame) {
        if (this.mGLTexturePool == null) {
            this.mGLTexturePool = new e();
        }
        d a16 = this.mGLTexturePool.a(pixelFrame.getWidth(), pixelFrame.getHeight());
        if (this.mLastFrameSize.width != pixelFrame.getWidth() || this.mLastFrameSize.height != pixelFrame.getHeight()) {
            h hVar = this.mPixelFrameRenderer;
            if (hVar != null) {
                hVar.a();
                this.mPixelFrameRenderer = null;
            }
            this.mLastFrameSize.width = pixelFrame.getWidth();
            this.mLastFrameSize.height = pixelFrame.getHeight();
        }
        if (this.mPixelFrameRenderer == null) {
            this.mPixelFrameRenderer = new h(pixelFrame.getWidth(), pixelFrame.getHeight());
        }
        this.mPixelFrameRenderer.a(pixelFrame, GLConstants.GLScaleType.FILL, a16);
        PixelFrame a17 = a16.a(pixelFrame.getGLContext());
        a16.release();
        return a17;
    }

    private PixelFrame deepCopyDataToPixelFrame(PixelFrame pixelFrame, Object obj) {
        if (obj instanceof byte[]) {
            byte[] a16 = com.tencent.liteav.videobase.utils.d.a(((byte[]) obj).length);
            if (a16 == null) {
                return null;
            }
            System.arraycopy(obj, 0, a16, 0, a16.length);
            pixelFrame.setData(a16);
        } else if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            ByteBuffer b16 = com.tencent.liteav.videobase.utils.d.b(byteBuffer.capacity());
            if (b16 == null) {
                return null;
            }
            byteBuffer.rewind();
            b16.put(byteBuffer);
            b16.rewind();
            pixelFrame.setBuffer(b16);
        }
        pixelFrame.retain();
        return pixelFrame;
    }

    private PixelFrame deepCopyTextureToPixelFrame(PixelFrame pixelFrame, Object obj) {
        saveCallerEGLContext();
        GLES20.glFinish();
        if (!CommonUtil.equals(this.mSharedEGLContext, obj)) {
            uninitOpenGLComponents();
            initRenderEGLContext(obj);
        }
        if (!makeCurrent()) {
            LiteavLog.e(this.mThrottlers.a("makeCurrent"), this.mTAG, "use origin texture when makeCurrent error", new Object[0]);
            pixelFrame.retain();
            return pixelFrame;
        }
        PixelFrame copyTexture = copyTexture(pixelFrame);
        GLES20.glFinish();
        restoreCallerEGLContext();
        return copyTexture;
    }

    private void initRenderEGLContext(Object obj) {
        if (this.mRenderEGLCore != null) {
            return;
        }
        LiteavLog.i(this.mTAG, "initRenderEGLContext");
        this.mSharedEGLContext = obj;
        EGLCore eGLCore = new EGLCore();
        this.mRenderEGLCore = eGLCore;
        try {
            eGLCore.initialize(obj, null, 128, 128);
        } catch (com.tencent.liteav.videobase.egl.d e16) {
            this.mRenderEGLCore = null;
            LiteavLog.e(this.mThrottlers.a("initEGLCore"), this.mTAG, "create EGLCore failed.", e16);
        }
    }

    private boolean makeCurrent() {
        EGLCore eGLCore = this.mRenderEGLCore;
        if (eGLCore == null) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentNull"), this.mTAG, "makeCurrent on mEGLCore is null", new Object[0]);
            return false;
        }
        try {
            eGLCore.makeCurrent();
            return true;
        } catch (com.tencent.liteav.videobase.egl.d e16) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentError"), this.mTAG, "make current failed.", e16);
            return false;
        }
    }

    private void restoreCallerEGLContext() {
        if (!CommonUtil.equals(this.mCallerEGLContext, EGL14.EGL_NO_CONTEXT)) {
            EGL14.eglMakeCurrent(this.mCallerEGLDisplay, this.mCallerEGLDrawSurface, this.mCallerEGLReadSurface, this.mCallerEGLContext);
            return;
        }
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eglGetCurrentDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
    }

    private void saveCallerEGLContext() {
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (CommonUtil.equals(this.mCallerEGLContext, EGL14.EGL_NO_CONTEXT) || !CommonUtil.equals(eglGetCurrentContext, this.mCallerEGLContext)) {
            this.mCallerEGLContext = eglGetCurrentContext;
            this.mCallerEGLDisplay = EGL14.eglGetCurrentDisplay();
            this.mCallerEGLReadSurface = EGL14.eglGetCurrentSurface(12378);
            this.mCallerEGLDrawSurface = EGL14.eglGetCurrentSurface(12377);
        }
    }

    private PixelFrame shallowCopyDataToPixelFrame(PixelFrame pixelFrame, Object obj) {
        if (obj instanceof byte[]) {
            pixelFrame.setData((byte[]) obj);
        } else if (obj instanceof ByteBuffer) {
            pixelFrame.setBuffer((ByteBuffer) obj);
        }
        pixelFrame.retain();
        return pixelFrame;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r2 = deepCopyDataToPixelFrame(r0, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized PixelFrame create(int i3, int i16, int i17, long j3, int i18, int i19, int i26, Object obj, Object obj2, boolean z16) {
        PixelFrame shallowCopyDataToPixelFrame;
        PixelFrame pixelFrame = new PixelFrame();
        pixelFrame.setWidth(i3);
        pixelFrame.setHeight(i16);
        pixelFrame.setRotation(k.a(i17));
        pixelFrame.setTimestamp(j3);
        pixelFrame.setGLContext(obj);
        pixelFrame.setTextureId(i26);
        pixelFrame.setPixelBufferType(GLConstants.a.a(i18));
        pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.a(i19));
        if (pixelFrame.getPixelBufferType() != GLConstants.a.BYTE_ARRAY && pixelFrame.getPixelBufferType() != GLConstants.a.BYTE_BUFFER) {
            shallowCopyDataToPixelFrame = deepCopyTextureToPixelFrame(pixelFrame, obj);
        }
        shallowCopyDataToPixelFrame = shallowCopyDataToPixelFrame(pixelFrame, obj2);
        return shallowCopyDataToPixelFrame;
    }

    public synchronized void release(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            pixelFrame.release();
        }
    }

    public synchronized void uninitOpenGLComponents() {
        if (this.mRenderEGLCore == null) {
            return;
        }
        LiteavLog.i(this.mTAG, "uninitOpenGLComponents");
        if (makeCurrent()) {
            e eVar = this.mGLTexturePool;
            if (eVar != null) {
                eVar.a();
                this.mGLTexturePool.b();
                this.mGLTexturePool = null;
            }
            h hVar = this.mPixelFrameRenderer;
            if (hVar != null) {
                hVar.a();
                this.mPixelFrameRenderer = null;
            }
        }
        EGLCore.destroy(this.mRenderEGLCore);
        this.mRenderEGLCore = null;
    }
}
