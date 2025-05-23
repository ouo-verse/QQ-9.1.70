package com.tencent.taveffect.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.taveffect.core.RGBTextureFilter;
import com.tencent.taveffect.core.TAVTextureInfo;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVGLUtils {
    private static final String TAG = "TAVGLUtils";
    private static RGBTextureFilter rgbTextureFilter;

    public static void checkEglError(String str) throws RuntimeException {
        boolean z16 = false;
        String str2 = "";
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            str2 = str2 + str + ": EGL error: 0x" + Integer.toHexString(eglGetError);
            z16 = true;
        }
        if (z16) {
            new RuntimeException("EGL error encountered (see log): " + str2).printStackTrace();
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            return useDelimiter.next();
        }
        return "";
    }

    public static float lerp(float f16, float f17, float f18) {
        return (f16 * (1.0f - f18)) + (f17 * f18);
    }

    public static String loadShaderCode(Context context, String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                return convertStreamToString(inputStream);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return "";
                } catch (IOException e18) {
                    e18.printStackTrace();
                    return "";
                }
            }
            return "";
        }
    }

    public static Bitmap saveBitmap(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i16 * i17 * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_4444);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        return createBitmap;
    }

    public static Bitmap saveBitmap(TAVTextureInfo tAVTextureInfo) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, tAVTextureInfo.textureID, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(tAVTextureInfo.width * tAVTextureInfo.height * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.rewind();
        GLES20.glReadPixels(0, 0, tAVTextureInfo.width, tAVTextureInfo.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
        Bitmap createBitmap = Bitmap.createBitmap(tAVTextureInfo.width, tAVTextureInfo.height, Bitmap.Config.ARGB_4444);
        allocateDirect.rewind();
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }
}
