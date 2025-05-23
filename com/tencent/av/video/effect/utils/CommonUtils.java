package com.tencent.av.video.effect.utils;

import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CommonUtils {
    public static final String TAG = "CommonUtils";

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine + "\n");
                    } catch (IOException e16) {
                        Log.e(TAG, "convertStreamToString", e16);
                        inputStream.close();
                    }
                } catch (Throwable th5) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        Log.e(TAG, "convertStreamToString", e17);
                    }
                    throw th5;
                }
            } catch (IOException e18) {
                Log.e(TAG, "convertStreamToString", e18);
            }
        }
        inputStream.close();
        return sb5.toString();
    }

    public static InputStream getInputStreamFromPath(Context context, String str) {
        InputStream inputStream = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.toLowerCase().startsWith("assets://")) {
                    inputStream = context.getAssets().open(str.substring(9));
                } else {
                    File file = new File(str);
                    if (file.exists()) {
                        inputStream = new BufferedInputStream(new FileInputStream(file));
                    }
                }
            }
        } catch (Exception e16) {
            Log.e(TAG, "getInputStreamFromPath", e16);
        }
        return inputStream;
    }

    public static void glCheckError() {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e(TAG, "glerror : " + glGetError);
        }
    }

    public static int initFrameBuffer(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i17, 0);
        GLES20.glBindFramebuffer(36160, 0);
        return iArr[0];
    }

    public static void saveTextureToRgbaBuffer(int i3, int i16, int i17, byte[] bArr) {
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glViewport(0, 0, i16, i17);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, ByteBuffer.wrap(bArr));
        GLES20.glBindFramebuffer(36160, 0);
    }
}
