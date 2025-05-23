package com.tencent.mobileqq.zplan.cc.util;

import android.opengl.GLES20;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes35.dex */
public class i {
    public static int b(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader == 0) {
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("GLUtil", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static void c(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e("GLUtil", str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public static int a(String str, String str2) {
        int b16;
        int glCreateProgram;
        int b17 = b(35633, str);
        if (b17 == 0 || (b16 = b(35632, str2)) == 0 || (glCreateProgram = GLES20.glCreateProgram()) == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, b17);
        GLES20.glAttachShader(glCreateProgram, b16);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }
}
