package org.light.utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Process;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import org.light.NativeBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightGLUtils {
    private static final String TAG = "LightGLUtils";

    public static void checkProcessFence() {
        int length;
        try {
            int myPid = Process.myPid();
            File[] listFiles = new File("/proc/" + myPid + "/fd/").listFiles();
            if (listFiles == null) {
                length = 0;
            } else {
                length = listFiles.length;
            }
            LightLogUtil.w(TAG, "process pid:" + myPid + ",fd:" + length);
        } catch (Throwable th5) {
            LightLogUtil.e(TAG, "read process fd exception:" + th5);
        }
    }

    public static int createTexture(int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i3, iArr[0]);
        GLES20.glTexParameteri(i3, 10242, 33071);
        GLES20.glTexParameteri(i3, 10243, 33071);
        GLES20.glTexParameteri(i3, 10241, 9729);
        GLES20.glTexParameteri(i3, 10240, 9729);
        return iArr[0];
    }

    public static void deleteTexture(int i3) {
        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
    }

    public static void saveBitmap2JPG(Bitmap bitmap, String str) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public static void saveNativeBuffer2Jpg(NativeBuffer nativeBuffer, String str) {
        saveBitmap2JPG(saveTexture2Bitmap(nativeBuffer.getBindTexture(), GLSLRender.GL_TEXTURE_2D, nativeBuffer.getBufferWidth(), nativeBuffer.getBufferHeight()), str);
    }

    public static Bitmap saveTexture2Bitmap(int i3, int i16, int i17, int i18) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, i16, i3, 0);
        ByteBuffer allocate = ByteBuffer.allocate(i17 * i18 * 4);
        GLES20.glReadPixels(0, 0, i17, i18, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
        allocate.position(0);
        createBitmap.copyPixelsFromBuffer(allocate);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return createBitmap;
    }

    public static void saveTexture2Jpg(int i3, int i16, int i17, String str) {
        saveBitmap2JPG(saveTexture2Bitmap(i3, GLSLRender.GL_TEXTURE_2D, i16, i17), str);
    }

    public static void saveTexture2Jpg(int i3, int i16, int i17, int i18, String str) {
        saveBitmap2JPG(saveTexture2Bitmap(i3, i16, i17, i18), str);
    }
}
