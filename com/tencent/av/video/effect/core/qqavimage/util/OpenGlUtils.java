package com.tencent.av.video.effect.core.qqavimage.util;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.ShaderManager;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.filter.GLSLRender;
import java.nio.IntBuffer;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OpenGlUtils {
    public static final float[] CUBE;
    public static final float[] CUBE16;
    public static final int NO_TEXTURE = -1;
    private static final String TAG = "OpenGlUtils";
    public static final float[] CUBE1 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] CUBE8 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static int[] bufferId = null;

    static {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        CUBE16 = fArr;
        CUBE = fArr;
    }

    public static boolean checkNeedCrypt(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    public static int loadProgram(String str, String str2) {
        int[] iArr = new int[1];
        int loadShader = loadShader(str, 35633, checkNeedCrypt(str));
        if (loadShader == 0) {
            Log.d(TAG, "Load Program: Vertex Shader Failed1");
            return 0;
        }
        int loadShader2 = loadShader(str2, 35632, checkNeedCrypt(str2));
        if (loadShader2 == 0) {
            Log.d(TAG, "Load Program: Fragment Shader Failed2");
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            Log.d(TAG, "Load Program: Linking Failed");
            return 0;
        }
        GLES20.glDeleteShader(loadShader);
        GLES20.glDeleteShader(loadShader2);
        return glCreateProgram;
    }

    public static int loadShader(String str, int i3, boolean z16) {
        int i16;
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader == 0) {
            Log.d(TAG, "Load loadShader: shader == 0");
            return glCreateShader;
        }
        if (z16) {
            try {
                i16 = Integer.parseInt(str);
            } catch (Exception e16) {
                Log.d(TAG, "Load loadShader: " + e16);
                i16 = 0;
            }
            if (i16 == 0) {
                Log.d(TAG, "Load loadShader: get shader source index fail");
                return 0;
            }
            try {
                ShaderManager.nativeGLShaderSource(glCreateShader, i16);
            } catch (Throwable th5) {
                Log.e(TAG, "Load loadShader: nativeGLShaderSource Exception e : " + th5);
                return 0;
            }
        } else {
            GLES20.glShaderSource(glCreateShader, str);
        }
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.d(TAG, "Load Program: Vertex Shader Failed1");
            return 0;
        }
        return glCreateShader;
    }

    public static int loadTexture(Bitmap bitmap, int i3) {
        return loadTexture(bitmap, i3, true);
    }

    public static int loadTextureAsBitmap(IntBuffer intBuffer, Camera.Size size, int i3) {
        return loadTexture(Bitmap.createBitmap(intBuffer.array(), size.width, size.height, Bitmap.Config.ARGB_8888), i3);
    }

    public static int loadTextureWithClear(Bitmap bitmap, int i3) {
        int[] iArr = new int[1];
        releaseTexture(i3);
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        return iArr[0];
    }

    public static void releaseTexture(int i3) {
        if (i3 == -1) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
    }

    public static float rnd(float f16, float f17) {
        return f16 + ((f17 - f16) * ((float) Math.random()));
    }

    public static int loadTexture(Bitmap bitmap, int i3, boolean z16) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLUtils.texSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, bitmap);
            iArr[0] = i3;
        }
        if (z16) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static int loadTexture(IntBuffer intBuffer, Camera.Size size, int i3) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, size.width, size.height, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, intBuffer);
        } else {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLES20.glTexSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, size.width, size.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, intBuffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }
}
