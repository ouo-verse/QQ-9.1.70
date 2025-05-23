package com.tencent.mobileqq.qqlive.anchor.beauty.processor;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static boolean a(String str) throws RuntimeException {
        StringBuilder sb5 = new StringBuilder("");
        boolean z16 = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            QLog.e("TextureUtils", 1, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            sb5.append(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z16 = true;
        }
        if (z16) {
            QLog.e("TextureUtils", 1, "checkEglActionSuccess: ", new RuntimeException("EGL error encountered (see log): " + sb5.toString()));
        }
        return !z16;
    }

    public static void b(String str) throws RuntimeException {
        a(str);
    }

    public static int c() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        b("glBindTexture mTextureID");
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        b("glTexParameter");
        return i3;
    }

    @NonNull
    public static c d(int i3, int i16, int i17) {
        c cVar = new c(i3, GLSLRender.GL_TEXTURE_2D, i16, i17);
        cVar.d(6408);
        return cVar;
    }
}
