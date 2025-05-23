package com.tencent.mobileqq.shortvideo.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Environment;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TextureUtils {
    public static String fileFolder = Environment.getExternalStorageDirectory() + "/testBitmap/";

    public static Bitmap convertFrameToBitmap(Frame frame) {
        return convertTexToBitmap(frame.getTextureId(), frame.width, frame.height);
    }

    public static Bitmap convertTexToBitmap(int i3, int i16, int i17) {
        ByteBuffer readTextureToByteBuffer = readTextureToByteBuffer(i3, i16, i17);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(readTextureToByteBuffer);
        return createBitmap;
    }

    public static ByteBuffer readTextureToByteBuffer(int i3, int i16, int i17) {
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

    public static boolean saveFrameToFile(Frame frame, String str) {
        if (!FileUtils.fileExists(fileFolder)) {
            return false;
        }
        Bitmap convertTexToBitmap = convertTexToBitmap(frame.getTextureId(), frame.width, frame.height);
        File file = new File(fileFolder, str);
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                convertTexToBitmap.compress(Bitmap.CompressFormat.JPEG, 20, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (!convertTexToBitmap.isRecycled()) {
                    convertTexToBitmap.recycle();
                    return true;
                }
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (!convertTexToBitmap.isRecycled()) {
                    convertTexToBitmap.recycle();
                }
                return false;
            }
        } catch (Throwable th5) {
            if (!convertTexToBitmap.isRecycled()) {
                convertTexToBitmap.recycle();
            }
            throw th5;
        }
    }
}
