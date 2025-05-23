package com.tencent.mobileqq.qrscan.minicode;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.Nullable;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(int i3, Bitmap bitmap) {
        return b(i3, bitmap, 9729, 9729, 33071, 33071);
    }

    public static int b(int i3, @Nullable Bitmap bitmap, int i16, int i17, int i18, int i19) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a.a("glGenTextures");
        GLES20.glBindTexture(i3, iArr[0]);
        a.a("glBindTexture " + iArr[0]);
        GLES20.glTexParameterf(i3, 10241, (float) i16);
        GLES20.glTexParameterf(i3, 10240, (float) i17);
        GLES20.glTexParameteri(i3, 10242, i18);
        GLES20.glTexParameteri(i3, 10243, i19);
        if (bitmap != null && !bitmap.isRecycled()) {
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        }
        a.a("glTexParameter");
        return iArr[0];
    }

    public static void c(int i3) {
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        a.a("glDeleteTextures");
    }
}
