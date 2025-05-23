package com.tencent.mobileqq.qzoneplayer.panorama;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {
    public static int a(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.e("GLUtil", "Error compiling shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                glCreateShader = 0;
            }
        }
        if (glCreateShader != 0) {
            return glCreateShader;
        }
        throw new RuntimeException("Error creating shader.");
    }

    public static int b(int i3, int i16, String[] strArr) {
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
                Log.e("GLUtil", "Error compiling program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                glCreateProgram = 0;
            }
        }
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }

    public static String d(Context context, int i3) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i3)));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                    sb5.append('\n');
                } else {
                    return sb5.toString();
                }
            } catch (IOException unused) {
                return null;
            }
        }
    }

    public static boolean e(Context context) {
        return ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public static void c(Context context, int i3, i iVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i3)));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("v ")) {
                    arrayList.add(readLine.substring(2));
                }
                if (readLine.startsWith("vt ")) {
                    arrayList2.add(readLine.substring(3));
                }
                if (readLine.startsWith("vn ")) {
                    arrayList3.add(readLine.substring(3));
                }
                if (readLine.startsWith("f ")) {
                    arrayList4.add(readLine.substring(2));
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        int size = arrayList4.size() * 3 * 3;
        float[] fArr = new float[size];
        int size2 = arrayList4.size() * 3 * 2;
        float[] fArr2 = new float[size2];
        int size3 = arrayList4.size() * 3;
        short[] sArr = new short[size3];
        Iterator it = arrayList4.iterator();
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split(" ");
            int length = split.length;
            Iterator it5 = it;
            int i19 = 0;
            while (i19 < length) {
                int i26 = length;
                String str = split[i19];
                int i27 = i16 + 1;
                int i28 = i17;
                sArr[i16] = (short) i16;
                String[] split2 = str.split("/");
                String str2 = (String) arrayList.get(Integer.parseInt(split2[0]) - 1);
                String str3 = (String) arrayList2.get(Integer.parseInt(split2[1]) - 1);
                String[] split3 = str2.split(" ");
                String[] split4 = str3.split(" ");
                int length2 = split3.length;
                ArrayList arrayList5 = arrayList;
                int i29 = 0;
                while (i29 < length2) {
                    fArr[i28] = Float.parseFloat(split3[i29]);
                    i29++;
                    i28++;
                }
                int length3 = split4.length;
                int i36 = 0;
                while (i36 < length3) {
                    fArr2[i18] = Float.parseFloat(split4[i36]);
                    i36++;
                    i18++;
                }
                i19++;
                length = i26;
                i16 = i27;
                i17 = i28;
                arrayList = arrayList5;
            }
            it = it5;
        }
        FloatBuffer put = ByteBuffer.allocateDirect(size * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        put.position(0);
        FloatBuffer put2 = ByteBuffer.allocateDirect(size2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        put2.position(0);
        iVar.h(put);
        iVar.g(put2);
        iVar.f(size3);
    }
}
