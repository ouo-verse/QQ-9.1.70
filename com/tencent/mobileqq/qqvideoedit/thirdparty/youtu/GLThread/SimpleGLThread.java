package com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes17.dex */
public class SimpleGLThread {

    /* renamed from: a, reason: collision with root package name */
    private Handler f276179a;

    /* renamed from: b, reason: collision with root package name */
    private b f276180b;

    /* renamed from: c, reason: collision with root package name */
    private d f276181c;

    /* renamed from: d, reason: collision with root package name */
    private String f276182d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
    }

    public SimpleGLThread(EGLContext eGLContext, String str) {
        this(eGLContext, str, null);
    }

    public static ByteBuffer f(int i3, int i16, int i17, ByteBuffer byteBuffer) {
        int i18 = i17 * i16 * 4;
        if (byteBuffer == null || byteBuffer.capacity() != i18) {
            byteBuffer = ByteBuffer.allocateDirect(i18);
        }
        byteBuffer.clear();
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        GLES20.glPixelStorei(3333, 1);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return byteBuffer;
    }

    public static int g(int i3, int i16) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        return iArr[0];
    }

    public void h() {
        Handler handler = this.f276179a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.SimpleGLThread.2
                @Override // java.lang.Runnable
                public void run() {
                    SimpleGLThread.this.f276181c.d();
                    SimpleGLThread.this.f276180b.e();
                    SimpleGLThread.this.f276179a.getLooper().quitSafely();
                }
            });
        }
    }

    public void i(Runnable runnable) {
        Handler handler = this.f276179a;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public SimpleGLThread(EGLContext eGLContext, String str, a aVar) {
        this.f276182d = str;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.f276182d);
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.f276179a = handler;
        handler.post(new Runnable(eGLContext, aVar) { // from class: com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread.SimpleGLThread.1

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ EGLContext f276183d;

            @Override // java.lang.Runnable
            public void run() {
                SimpleGLThread.this.f276180b = new b(this.f276183d, 0);
                SimpleGLThread.this.f276181c = new d(SimpleGLThread.this.f276180b, 720, 720);
                SimpleGLThread.this.f276181c.b();
            }
        });
    }
}
