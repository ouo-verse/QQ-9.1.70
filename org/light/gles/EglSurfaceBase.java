package org.light.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes29.dex */
class EglSurfaceBase {
    protected static final String TAG = "EglSurfaceBase";
    protected EglCore mEglCore;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public EglSurfaceBase(EglCore eglCore) {
        this.mEglCore = eglCore;
    }

    private void checkGlError(String str) {
        if (GLES20.glGetError() != 0) {
            Thread.getAllStackTraces().get(Thread.currentThread());
        }
    }

    public void createOffscreenSurface(int i3, int i16) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createOffscreenSurface(i3, i16);
            this.mWidth = i3;
            this.mHeight = i16;
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public int getHeight() {
        int i3 = this.mHeight;
        if (i3 < 0) {
            return this.mEglCore.querySurface(this.mEGLSurface, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT);
        }
        return i3;
    }

    public int getWidth() {
        int i3 = this.mWidth;
        if (i3 < 0) {
            return this.mEglCore.querySurface(this.mEGLSurface, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH);
        }
        return i3;
    }

    public void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public void makeCurrentReadFrom(EglSurfaceBase eglSurfaceBase) {
        this.mEglCore.makeCurrent(this.mEGLSurface, eglSurfaceBase.mEGLSurface);
    }

    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void saveFrame(File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        if (this.mEglCore.isCurrent(this.mEGLSurface)) {
            String file2 = file.toString();
            int width = getWidth();
            int height = getHeight();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, width, height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
            checkGlError("glReadPixels");
            allocateDirect.rewind();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(allocateDirect);
                createBitmap.compress(Bitmap.CompressFormat.PNG, 90, bufferedOutputStream);
                createBitmap.recycle();
                bufferedOutputStream.close();
                return;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                throw th;
            }
        }
        throw new RuntimeException("Expected EGL context/surface is not current");
    }

    public void setPresentationTime(long j3) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, j3);
    }

    public boolean swapBuffers() {
        return this.mEglCore.swapBuffers(this.mEGLSurface);
    }
}
