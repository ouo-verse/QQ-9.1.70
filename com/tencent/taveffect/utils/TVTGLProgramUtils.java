package com.tencent.taveffect.utils;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;

/* loaded from: classes26.dex */
public class TVTGLProgramUtils {
    private static final String TAG = "TVTGLProgramUtils";

    public static int createProgram(String str, String str2) {
        int loadShader;
        GLES20.glEnable(3042);
        GLES20.glBlendEquationSeparate(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE, TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
        GLES20.glBlendFuncSeparate(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 != 0 && (loadShader = loadShader(35632, str2)) != 0) {
            int glCreateProgram = GLES20.glCreateProgram();
            TAVGLUtils.checkEglError("glCreateProgram");
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            TAVGLUtils.checkEglError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            TAVGLUtils.checkEglError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 0) {
                GLES20.glDeleteShader(loadShader2);
                GLES20.glDeleteShader(loadShader);
                return glCreateProgram;
            }
            GLES20.glDeleteProgram(glCreateProgram);
            Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
        }
        return 0;
    }

    private static int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        TAVGLUtils.checkEglError("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e(TAG, "Could not compile shader " + i3 + ":");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" ");
            sb5.append(GLES20.glGetShaderInfoLog(glCreateShader));
            Log.e(TAG, sb5.toString());
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }
}
