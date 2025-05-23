package com.tencent.mobileqq.zplan.cc.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes35.dex */
public class o {
    public static Bitmap a(int i3, int i16, int i17) {
        return b(i3, i16, i17, 0, 0);
    }

    public static Bitmap b(int i3, int i16, int i17, int i18, int i19) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        i.c("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        i.c("glFramebufferTexture2D");
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glReadPixels(i18, i19, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        i.c("glReadPixels");
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocate);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }
}
