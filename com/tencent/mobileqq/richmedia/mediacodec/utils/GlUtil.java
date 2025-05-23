package com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GlUtil {
    public static final int NO_TEXTURE = -1;
    private static final int SIZEOF_FLOAT = 4;
    private static final String TAG = "GlUtil";

    public static Bitmap captureFrame(int i3, int i16, int i17, int i18) {
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glGenFramebuffers(1, r9, 0);
        GLES20.glBindFramebuffer(36160, r9[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, r9, 0);
        int[] iArr = {0};
        allocate.position(0);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocate);
        Matrix matrix = new Matrix();
        matrix.postRotate(i18);
        matrix.postScale(1.0f, -1.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, i16, i17, matrix, true);
        createBitmap.recycle();
        return createBitmap2;
    }

    public static void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e(TAG, str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    public static int createComputeProgram(String str) {
        int loadShader = loadShader(37305, str);
        if (loadShader == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        checkGlError("createComputeProgram");
        if (glCreateProgram == 0) {
            Log.e(TAG, "Could not create ComputeProgram");
        }
        GLES20.glAttachShader(glCreateProgram, loadShader);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e(TAG, "Could not link ComputeProgram: ");
            Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static IntBuffer createIntBuffer(int[] iArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(iArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        asIntBuffer.put(iArr);
        asIntBuffer.position(0);
        return asIntBuffer;
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e(TAG, "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, loadShader);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e(TAG, "Could not link program: ");
            Log.e(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static int createTexture(int i3, Bitmap bitmap, int i16, int i17, int i18, int i19) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlError("glGenTextures");
        GLES20.glBindTexture(i3, iArr[0]);
        checkGlError("glBindTexture " + iArr[0]);
        GLES20.glTexParameterf(i3, 10241, (float) i16);
        GLES20.glTexParameterf(i3, 10240, (float) i17);
        GLES20.glTexParameteri(i3, 10242, i18);
        GLES20.glTexParameteri(i3, 10243, i19);
        if (bitmap != null) {
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        }
        checkGlError("glTexParameter");
        return iArr[0];
    }

    @TargetApi(18)
    public static int createTextureAllocate(int i3, int i16, boolean z16) {
        int createTexture = createTexture(GLSLRender.GL_TEXTURE_2D);
        if (z16) {
            GLES30.glTexStorage2D(GLSLRender.GL_TEXTURE_2D, 1, 32856, i3, i16);
        } else {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        return createTexture;
    }

    public static void deleteTexture(int i3) {
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        checkGlError("glDeleteTextures");
    }

    public static int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        checkGlError("glCreateShader type=" + i3);
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readTextFromRawResource(Context context, int i3) {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = context.getResources().openRawResource(i3);
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    sb5.append(readLine);
                                    sb5.append('\n');
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e16) {
                                        e16.printStackTrace();
                                    }
                                }
                            } catch (IOException unused) {
                                bufferedReader2.close();
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                                if (inputStream != null) {
                                }
                                return null;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                        throw th;
                                    } catch (IOException e26) {
                                        e26.printStackTrace();
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e27) {
                            e27.printStackTrace();
                            inputStreamReader.close();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                }
                            }
                            return null;
                        }
                    }
                    bufferedReader2.close();
                    try {
                        inputStreamReader.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e36) {
                            e36.printStackTrace();
                        }
                    }
                    return sb5.toString();
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            inputStreamReader = null;
        }
    }

    public static byte[] saveTextureToRgbaBuffer(int i3, int i16, int i17) {
        byte[] bArr = new byte[i16 * i17 * 4];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        GLES20.glGenFramebuffers(1, r9, 0);
        GLES20.glBindFramebuffer(36160, r9[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, r9, 0);
        int[] iArr = {0};
        return bArr;
    }

    public static FloatBuffer createFloatBuffer(float[] fArr, ByteOrder byteOrder) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(byteOrder);
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int createTexture(int i3) {
        return createTexture(i3, null, 9729, 9729, 33071, 33071);
    }

    public static int createTexture(int i3, Bitmap bitmap) {
        return createTexture(i3, bitmap, 9729, 9729, 33071, 33071);
    }

    public static Bitmap captureFrame(int i3, int i16, int i17) {
        ByteBuffer allocate = ByteBuffer.allocate(i16 * i17 * 4);
        GLES20.glGenFramebuffers(1, r9, 0);
        GLES20.glBindFramebuffer(36160, r9[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, r9, 0);
        int[] iArr = {0};
        allocate.position(0);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocate);
        return createBitmap;
    }
}
