package com.tencent.qq.effect.alphavideo.videoplayer.render;

import android.opengl.GLES20;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ShaderHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoPlayer|ShaderHelper";

    public ShaderHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int compileShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                LogUtil.e(TAG, "Error compiling shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                glCreateShader = 0;
            }
        }
        if (glCreateShader == 0) {
            LogUtil.e(TAG, "Error creating shader.");
        }
        return glCreateShader;
    }

    public static int createAndLinkProgram(int i3, int i16, String[] strArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i3);
            GLES20.glAttachShader(glCreateProgram, i16);
            if (strArr != null) {
                int length = strArr.length;
                for (int i17 = 0; i17 < length; i17++) {
                    GLES20.glBindAttribLocation(glCreateProgram, i17, strArr[i17]);
                }
            }
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                LogUtil.e(TAG, "Error compiling program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                glCreateProgram = 0;
            }
        }
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }
}
