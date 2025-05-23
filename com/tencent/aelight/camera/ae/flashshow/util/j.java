package com.tencent.aelight.camera.ae.flashshow.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {
    public static Bitmap a(int i3, int i16, int i17) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i16 * i17 * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
            allocateDirect.rewind();
            bitmap.copyPixelsFromBuffer(allocateDirect);
            GLES20.glBindFramebuffer(36160, 0);
            return bitmap;
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }
}
