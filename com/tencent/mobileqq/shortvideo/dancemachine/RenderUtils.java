package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RenderUtils {
    public static Bitmap saveTextureTo(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocate);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }
}
