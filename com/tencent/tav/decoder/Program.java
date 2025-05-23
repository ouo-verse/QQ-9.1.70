package com.tencent.tav.decoder;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;

/* loaded from: classes26.dex */
public class Program {
    private static final String TAG = "Program";

    public static void checkEglError(String str) throws RuntimeException {
        StringBuilder sb5 = new StringBuilder("");
        boolean z16 = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            sb5.append(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z16 = true;
        }
        if (z16) {
            new RuntimeException("EGL error encountered (see log): " + sb5.toString()).printStackTrace();
        }
    }

    public static synchronized int createProgram(String str, String str2) {
        int createProgram;
        synchronized (Program.class) {
            createProgram = createProgram(str, str2, null);
        }
        return createProgram;
    }

    private static synchronized int loadShader(int i3, String str) {
        int glCreateShader;
        synchronized (Program.class) {
            glCreateShader = GLES20.glCreateShader(i3);
            checkEglError("glCreateShader type=" + i3);
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
                glCreateShader = 0;
            }
        }
        return glCreateShader;
    }

    public static synchronized int createProgram(String str, String str2, int[] iArr) {
        synchronized (Program.class) {
            GLES20.glEnable(3042);
            GLES20.glBlendEquationSeparate(TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE, TraeAudioManager.CustomHandler.MSG_CONNECT_HIGHEST_PRIORITY_DEVICE);
            GLES20.glBlendFuncSeparate(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            int loadShader = loadShader(35633, str);
            int i3 = 0;
            if (loadShader == 0) {
                return 0;
            }
            int loadShader2 = loadShader(35632, str2);
            if (loadShader2 == 0) {
                return 0;
            }
            if (iArr != null && iArr.length >= 2) {
                iArr[0] = loadShader;
                iArr[1] = loadShader2;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            checkEglError("glCreateProgram");
            if (glCreateProgram == 0) {
                Log.e(TAG, "Could not create program");
            }
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkEglError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkEglError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
            if (iArr2[0] != 1) {
                Log.e(TAG, "Could not link program: ");
                Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
            } else {
                i3 = glCreateProgram;
            }
            return i3;
        }
    }
}
