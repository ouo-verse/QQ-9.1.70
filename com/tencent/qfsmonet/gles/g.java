package com.tencent.qfsmonet.gles;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {
    static IPatchRedirector $redirector_;

    private static boolean a(int i3) {
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i3, 35714, iArr, 0);
        com.tencent.qfsmonet.utils.a.c("MonetGLShaderUtils", "linkStatus:" + iArr[0]);
        if (iArr[0] != 0) {
            return true;
        }
        com.tencent.qfsmonet.utils.a.b("MonetGLShaderUtils", "link err:" + GLES20.glGetProgramInfoLog(i3));
        return false;
    }

    private static int b(int i3, @NonNull String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader == 0) {
            com.tencent.qfsmonet.utils.a.b("MonetGLShaderUtils", "shader create failed. shader type:" + i3);
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            com.tencent.qfsmonet.utils.a.b("MonetGLShaderUtils", "shader compile failed! shader:" + str);
            return 0;
        }
        com.tencent.qfsmonet.utils.a.c("MonetGLShaderUtils", "shader compile info:" + GLES20.glGetShaderInfoLog(glCreateShader));
        return glCreateShader;
    }

    public static int c(@NonNull String str, @NonNull String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            com.tencent.qfsmonet.utils.a.b("MonetGLShaderUtils", "shader create program failed!");
            return 0;
        }
        int b16 = b(35633, str);
        if (b16 == 0) {
            com.tencent.qfsmonet.utils.a.b("MonetGLShaderUtils", "shader create vertex shader failed!");
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        int b17 = b(35632, str2);
        if (b17 == 0) {
            GLES20.glDeleteShader(b16);
            GLES20.glDeleteProgram(glCreateProgram);
            com.tencent.qfsmonet.utils.a.b("MonetGLShaderUtils", "shader create fragment shader failed!");
            return 0;
        }
        if (!d(glCreateProgram, b16, b17)) {
            com.tencent.qfsmonet.utils.a.b("MonetGLShaderUtils", "link program failed!");
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        com.tencent.qfsmonet.utils.a.c("MonetGLShaderUtils", "create program success! id = " + glCreateProgram);
        return glCreateProgram;
    }

    private static boolean d(int i3, int i16, int i17) {
        GLES20.glAttachShader(i3, i16);
        GLES20.glAttachShader(i3, i17);
        GLES20.glLinkProgram(i3);
        GLES20.glDeleteShader(i16);
        GLES20.glDeleteShader(i17);
        return a(i3);
    }
}
