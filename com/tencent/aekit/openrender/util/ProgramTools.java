package com.tencent.aekit.openrender.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.tencwebrtc.EglBase;

/* loaded from: classes3.dex */
public class ProgramTools {
    static IPatchRedirector $redirector_ = null;
    public static final int PER_FLOAT_BYTE = 4;
    private static final String TAG;

    /* loaded from: classes3.dex */
    public static class ProgramInfo {
        static IPatchRedirector $redirector_;
        public int fragShaderId;
        public int programId;
        public int vertextShaderId;

        public ProgramInfo(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.programId = i3;
            this.vertextShaderId = i16;
            this.fragShaderId = i17;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(EglBase.EGL_RECORDABLE_ANDROID);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = ProgramTools.class.getSimpleName();
        }
    }

    public ProgramTools() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int createComputeProgram(String str) {
        int i3;
        int glCreateShader = GLES20.glCreateShader(37305);
        GLES20.glShaderSource(glCreateShader, str);
        int[] iArr = new int[1];
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            String str2 = TAG;
            Log.e(str2, "vertex shader compile, failed computerShader: [" + str + "]");
            Log.e(str2, glGetShaderInfoLog);
            if (AEOpenRenderConfig.isEnableLog()) {
                if (str.length() >= 100) {
                    i3 = str.length() - 100;
                } else {
                    i3 = 0;
                }
                Log.e(str2, "vertex shader compile, failed computerShader substring(index) : [" + str.substring(i3) + "]");
                Log.e(str2, glGetShaderInfoLog);
            }
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(glCreateProgram);
            String str3 = TAG;
            Log.e(str3, "link program,failed:" + GLES20.glGetProgramInfoLog(glCreateProgram));
            if (AEOpenRenderConfig.isEnableLog()) {
                Log.e(str3, "link program,failed:" + GLES20.glGetProgramInfoLog(glCreateProgram));
            }
            return 0;
        }
        GLES20.glDeleteShader(glCreateShader);
        return glCreateProgram;
    }

    public static ProgramInfo createProgram(String str, String str2) {
        int glCreateShader = GLES20.glCreateShader(35633);
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glShaderSource(glCreateShader2, str2);
        int[] iArr = new int[1];
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            String str3 = TAG;
            Log.e(str3, "vertex shader compile,failed vertexShader Code : " + str);
            Log.e(str3, glGetShaderInfoLog);
            return null;
        }
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            String glGetShaderInfoLog2 = GLES20.glGetShaderInfoLog(glCreateShader2);
            GLES20.glDeleteShader(glCreateShader2);
            String str4 = TAG;
            Log.e(str4, "fragment shader compile,failed:" + str2);
            Log.e(str4, glGetShaderInfoLog2);
            return null;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, glCreateShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
            GLES20.glDeleteProgram(glCreateProgram);
            String str5 = TAG;
            Log.e(str5, "link program,failed:" + glGetProgramInfoLog);
            if (AEOpenRenderConfig.isEnableLog()) {
                Log.e(str5, "link program,failed:" + glGetProgramInfoLog);
            }
            return null;
        }
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        return new ProgramInfo(glCreateProgram, glCreateShader, glCreateShader2);
    }

    public static void createTexture(int i3, int i16, int i17, int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, i17, i3, i16, 0, i17, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
    }

    public static int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public static void mallocTexture(int i3, int i16, int i17) {
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i16, i17, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
    }

    private static String readTextFile(Context context, int i3) {
        InputStream openRawResource = context.getResources().openRawResource(i3);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb5.append(readLine);
                        sb5.append("\n");
                    } else {
                        try {
                            break;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    try {
                        openRawResource.close();
                        bufferedReader.close();
                        return null;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        return null;
                    }
                }
            } catch (Throwable th5) {
                try {
                    openRawResource.close();
                    bufferedReader.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                throw th5;
            }
        }
        openRawResource.close();
        bufferedReader.close();
        return sb5.toString();
    }

    @TargetApi(18)
    public static void setupSSBufferObject(int i3, int i16, float[] fArr, int i17) {
        int i18 = i17 * 4;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(i18).order(ByteOrder.nativeOrder()).asFloatBuffer();
        if (fArr != null) {
            asFloatBuffer.put(fArr).position(0);
        }
        GLES20.glBindBuffer(37074, i3);
        GLES20.glBufferData(37074, i18, asFloatBuffer, 35044);
        GLES30.glBindBufferBase(37074, i16, i3);
    }

    public static boolean testCompileShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        int[] iArr = new int[1];
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            String str2 = TAG;
            Log.e(str2, "vertex shader test compile failed, shader : [" + str + "]");
            Log.e(str2, glGetShaderInfoLog);
            GLES20.glDeleteShader(glCreateShader);
            return false;
        }
        GLES20.glDeleteShader(glCreateShader);
        return true;
    }
}
