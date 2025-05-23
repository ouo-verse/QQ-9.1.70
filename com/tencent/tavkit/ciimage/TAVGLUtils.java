package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVGLUtils {
    private static final String TAG = "TAVGLUtils";
    private static final String TAV_DEBUG_IMAGE_DIR = "/sdcard/tavkit_demo/TAV\u8c03\u8bd5\u56fe\u7247";

    private static TextureInfo checkTextureInfo(TextureInfo textureInfo) {
        if (textureInfo.textureType == 3553) {
            return textureInfo;
        }
        TextureInfo textureInfo2 = new TextureInfo(RenderContext.createTexture(GLSLRender.GL_TEXTURE_2D), GLSLRender.GL_TEXTURE_2D, textureInfo.width, textureInfo.height, null, 0);
        Renderer renderer = new Renderer();
        renderer.setOutputTextureInfo(textureInfo2);
        renderer.render(textureInfo, null, textureInfo.getTextureMatrix(), 1.0f, null);
        return textureInfo2;
    }

    @NotNull
    private static String getTimeTag() {
        return Long.toHexString(System.currentTimeMillis());
    }

    @NotNull
    private static File newDebugImageFile(int i3, int i16, int i17) throws Exception {
        return newDebugImageFile(getTimeTag(), i3, i16, i17);
    }

    public static Bitmap saveBitmap(int i3, int i16, int i17) {
        return saveBitmap(i3, GLSLRender.GL_TEXTURE_2D, i16, i17);
    }

    public static String saveBitmapToFile(TextureInfo textureInfo) throws Exception {
        return saveBitmapToFile(textureInfo, getTimeTag());
    }

    public static ByteBuffer savePixelBuffer(TextureInfo textureInfo, int i3) {
        TextureInfo checkTextureInfo = checkTextureInfo(textureInfo);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, checkTextureInfo.textureID, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(checkTextureInfo.width * checkTextureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, checkTextureInfo.width, checkTextureInfo.height, i3, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        allocateDirect.rewind();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return allocateDirect;
    }

    private static File newDebugImageFile(String str, int i3, int i16, int i17) throws Exception {
        String str2 = str + "_id=" + i3 + "_" + i16 + "_" + i17 + ".png";
        File file = new File(TAV_DEBUG_IMAGE_DIR);
        if (!file.exists() && !file.mkdir()) {
            throw new RuntimeException("mkdir return false, path = " + file.getAbsolutePath());
        }
        return new File(TAV_DEBUG_IMAGE_DIR, str2);
    }

    public static Bitmap saveBitmap(int i3, int i16, int i17, int i18) {
        return saveBitmap(new TextureInfo(i3, i16, i17, i18, 0));
    }

    public static String saveBitmapToFile(TextureInfo textureInfo, String str) throws Exception {
        return saveBitmapToFile(textureInfo, newDebugImageFile(str, textureInfo.textureID, textureInfo.width, textureInfo.height));
    }

    public static Bitmap saveBitmap(CIImage cIImage) {
        TextureInfo newTextureInfo = CIContext.newTextureInfo(cIImage.getSize().width, cIImage.getSize().height);
        RendererWrapper rendererWrapper = new RendererWrapper();
        rendererWrapper.setOutputTextureInfo(newTextureInfo);
        cIImage.drawTo(rendererWrapper);
        return saveBitmap(newTextureInfo);
    }

    public static String saveBitmapToFile(TextureInfo textureInfo, File file) throws Exception {
        return saveBitmapToFile(saveBitmap(textureInfo), file);
    }

    public static Bitmap saveBitmap(TextureInfo textureInfo) {
        TextureInfo checkTextureInfo = checkTextureInfo(textureInfo);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, checkTextureInfo.textureID, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(checkTextureInfo.width * checkTextureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, checkTextureInfo.width, checkTextureInfo.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(checkTextureInfo.width, checkTextureInfo.height, Bitmap.Config.ARGB_4444);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }

    public static String saveBitmapToFile(Bitmap bitmap) throws Exception {
        return saveBitmapToFile(bitmap, newDebugImageFile(0, bitmap.getWidth(), bitmap.getHeight()));
    }

    public static String saveBitmapToFile(Bitmap bitmap, File file) throws Exception {
        if (file.createNewFile()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArray);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return file.getAbsolutePath();
        }
        throw new RuntimeException("createNewFile return false, path = " + file.getAbsolutePath());
    }
}
