package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes32.dex */
public class PtvFilterUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f67600a = c("android.graphics.SurfaceTexture", "release", new Class[0]);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f67601b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f67602c = false;

    /* renamed from: d, reason: collision with root package name */
    private static int[] f67603d = new int[2];

    /* renamed from: e, reason: collision with root package name */
    private static Method f67604e;

    static {
        f67604e = null;
        try {
            f67604e = HandlerThread.class.getDeclaredMethod("quitSafely", new Class[0]);
        } catch (NoSuchMethodException unused) {
        }
    }

    public static void a(String str, String str2) {
        String str3 = str + File.separator + "configure.txt";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "configure file content:" + sb5.toString());
        }
        FileUtils.writeFile(str3, sb5.toString());
    }

    private static native ByteBuffer allocate();

    public static native ByteBuffer allocateSharedMem(long j3);

    private static boolean c(String str, String str2, Class<?>... clsArr) {
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static native void copyMapData(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i3);

    public static void d(int i3) {
        try {
            setBeautyKind(i3);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void e(boolean z16) {
        try {
            setSupportBeauty(z16);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static native Object getBitmapFromSharedMem(int i3, int i16, int i17);

    private static native int getGLFrameBufferData(int i3, int i16, int i17, int i18, int i19);

    public static native void getGLFrameBufferDataPBO(int i3, int i16, int i17);

    public static native void getGLFrameBufferDataPBOMap(int i3, int i16, int i17, int i18);

    public static native long getNativePtrIndex(int i3, int i16, int i17, int i18);

    private static native int getVideoFrameData(byte[] bArr);

    public static native int processVideoFrame(byte[] bArr, int i3, int i16, int i17, int i18, boolean z16, boolean z17, ByteBuffer byteBuffer);

    private static native int realWriteData(AVIOStruct aVIOStruct);

    private static native void setBeautyKind(int i3);

    private static native void setEnableAsyncClipVideo(boolean z16);

    private static native void setSupportBeauty(boolean z16);

    private static native void setVideoClipThreadNum(int i3);

    private static native int writeSharedMemtoFile(int i3, int i16, int i17, boolean z16, boolean z17, int i18, AVIOStruct aVIOStruct, int i19, boolean z18, int i26);

    public static void b(boolean z16) {
        if (z16) {
            GLES20.glFinish();
        } else {
            GLES20.glFlush();
        }
    }
}
