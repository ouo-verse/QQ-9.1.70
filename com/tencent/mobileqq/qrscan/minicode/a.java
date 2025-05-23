package com.tencent.mobileqq.qrscan.minicode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GlUtil", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    public static Bitmap b(int i3, int i16, int i17) {
        ByteBuffer d16 = d(i3, i16, i17);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(d16);
        return createBitmap;
    }

    @TargetApi(18)
    public static int c(int i3, int i16) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GLES30.glTexStorage2D(GLSLRender.GL_TEXTURE_2D, 1, 32856, i3, i16);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
        a("glTexParameter");
        return iArr[0];
    }

    private static ByteBuffer d(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        GLES20.glGetIntegerv(36006, iArr2, 0);
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, iArr2[0]);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return allocate;
    }
}
