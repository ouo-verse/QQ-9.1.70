package com.tencent.mobileqq.surfaceviewaction.util;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(String str, String str2) {
        int b16 = b(35633, str);
        int b17 = b(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, b16);
            GLES20.glAttachShader(glCreateProgram, b17);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 0) {
                GLES20.glDeleteShader(b16);
                GLES20.glDeleteShader(b17);
                return glCreateProgram;
            }
            GLES20.glDeleteProgram(glCreateProgram);
            throw new RuntimeException("Error linking program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
        }
        throw new RuntimeException("Error create program.");
    }

    public static int b(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            int[] iArr = new int[1];
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            GLES20.glDeleteShader(glCreateShader);
            throw new RuntimeException("Error compile shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
        }
        throw new RuntimeException("Error create shader.");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0043: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:68), block:B:28:0x0043 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context, String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(str));
            } catch (Exception e16) {
                e = e16;
                inputStreamReader = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStreamReader3 != null) {
                }
                throw th;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append('\n');
                }
                String sb6 = sb5.toString();
                try {
                    inputStreamReader.close();
                } catch (IOException unused) {
                }
                return sb6;
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader3 = inputStreamReader2;
            if (inputStreamReader3 != null) {
                try {
                    inputStreamReader3.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }
}
