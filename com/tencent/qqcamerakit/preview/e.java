package com.tencent.qqcamerakit.preview;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GlUtil", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    public static FloatBuffer b(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int c(String str, String str2) {
        int f16;
        int f17 = f(35633, str);
        if (f17 == 0 || (f16 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("GlUtil", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, f17);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, f16);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GlUtil", "Could not link program: ");
            Log.e("GlUtil", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static int d(int i3) {
        return e(i3, null, 9729, 9729, 33071, 33071);
    }

    public static int e(int i3, Bitmap bitmap, int i16, int i17, int i18, int i19) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a("glGenTextures");
        GLES20.glBindTexture(i3, iArr[0]);
        a("glBindTexture " + iArr[0]);
        GLES20.glTexParameterf(i3, 10241, (float) i16);
        GLES20.glTexParameterf(i3, 10240, (float) i17);
        GLES20.glTexParameteri(i3, 10242, i18);
        GLES20.glTexParameteri(i3, 10243, i19);
        if (bitmap != null) {
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        }
        a("glTexParameter");
        return iArr[0];
    }

    public static int f(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        a("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("GlUtil", "Could not compile shader " + i3 + ":");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" ");
            sb5.append(GLES20.glGetShaderInfoLog(glCreateShader));
            Log.e("GlUtil", sb5.toString());
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }
}
