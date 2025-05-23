package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.TextureInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVGLUtils {
    public static final String OUT_SAVE_DIR = "/sdcard/tavkit_demo/";
    public static final String OUT_SAVE_EXPORT_DIR = "/sdcard/tavkit_demo/export/";
    public static final String OUT_SAVE_VIDEOS_DIR = "/sdcard/tavkit_demo/videos/";
    private static final String TAV_DEBUG_IMAGE_DIR = "/sdcard/tavkit_demo//TAV\u8c03\u8bd5\u56fe\u7247";

    @NonNull
    public static File newDebugImageFile(int i3, int i16, int i17) throws Exception {
        String str = Long.toHexString(System.currentTimeMillis()) + "_id=" + i3 + "_" + i16 + "_" + i17 + ".png";
        File file = new File(TAV_DEBUG_IMAGE_DIR);
        if (!file.exists() && !file.mkdir()) {
            throw new RuntimeException("mkdir return false, path = " + file.getAbsolutePath());
        }
        return new File(TAV_DEBUG_IMAGE_DIR, str);
    }

    public static void readPixelBuffer(TextureInfo textureInfo, ByteBuffer byteBuffer) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, textureInfo.textureType, textureInfo.textureID, 0);
        GLES20.glReadPixels(0, 0, textureInfo.width, textureInfo.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public static Bitmap saveBitmap(int i3, int i16, int i17) {
        return saveBitmap(i3, GLSLRender.GL_TEXTURE_2D, i16, i17);
    }

    public static void saveBitmapToFile(TextureInfo textureInfo) throws Exception {
        saveBitmapToFile(textureInfo, newDebugImageFile(textureInfo.textureID, textureInfo.width, textureInfo.height));
    }

    public static Bitmap saveBitmap(int i3, int i16, int i17, int i18) {
        return saveBitmap(new TextureInfo(i3, i16, i17, i18, 0));
    }

    public static Bitmap saveBitmap(TextureInfo textureInfo) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(textureInfo.width * textureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        readPixelBuffer(textureInfo, allocateDirect);
        return saveBitmap(allocateDirect, textureInfo.width, textureInfo.height);
    }

    public static void saveBitmapToFile(TextureInfo textureInfo, File file) throws Exception {
        saveBitmapToFile(saveBitmap(textureInfo), file);
    }

    @NonNull
    private static Bitmap saveBitmap(ByteBuffer byteBuffer, int i3, int i16) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
        byteBuffer.rewind();
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        return createBitmap;
    }

    public static void saveBitmapToFile(ByteBuffer byteBuffer, int i3, int i16) throws Exception {
        saveBitmapToFile(saveBitmap(byteBuffer, i3, i16));
    }

    public static void saveBitmapToFile(Bitmap bitmap) throws Exception {
        saveBitmapToFile(bitmap, newDebugImageFile(0, bitmap.getWidth(), bitmap.getHeight()));
    }

    public static void saveBitmapToFile(Bitmap bitmap, File file) throws Exception {
        if (file.createNewFile()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.flush();
            fileOutputStream.close();
            return;
        }
        throw new RuntimeException("createNewFile return false, path = " + file.getAbsolutePath());
    }
}
