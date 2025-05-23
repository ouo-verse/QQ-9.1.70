package com.tencent.liteav.videobase.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class OpenGlUtils {
    private static final String TAG = "OpenGlUtils";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videobase.utils.OpenGlUtils$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119369a;

        static {
            int[] iArr = new int[k.values().length];
            f119369a = iArr;
            try {
                iArr[k.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119369a[k.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119369a[k.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119369a[k.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void attachTextureToFrameBuffer(int i3, int i16) {
        GLES20.glBindFramebuffer(36160, i16);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public static void bindFramebuffer(int i3, int i16) {
        GLES20.glBindFramebuffer(i3, i16);
    }

    public static void bindTexture(int i3, int i16) {
        GLES20.glBindTexture(i3, i16);
    }

    public static void convertYuvFormat(GLConstants.PixelFormatType pixelFormatType, Object obj, GLConstants.PixelFormatType pixelFormatType2, Object obj2, int i3, int i16) {
        boolean nativeConvertYuvFormatArrayToArray;
        int value = pixelFormatType.getValue();
        int value2 = pixelFormatType2.getValue();
        boolean z16 = obj instanceof ByteBuffer;
        if (z16 && (obj2 instanceof ByteBuffer)) {
            nativeConvertYuvFormatArrayToArray = nativeConvertYuvFormatBufferToBuffer(value, (ByteBuffer) obj, value2, (ByteBuffer) obj2, i3, i16);
        } else if (z16 && (obj2 instanceof byte[])) {
            nativeConvertYuvFormatArrayToArray = nativeConvertYuvFormatBufferToArray(value, (ByteBuffer) obj, value2, (byte[]) obj2, i3, i16);
        } else if ((obj instanceof byte[]) && (obj2 instanceof ByteBuffer)) {
            nativeConvertYuvFormatArrayToArray = nativeConvertYuvFormatArrayToBuffer(value, (byte[]) obj, value2, (ByteBuffer) obj2, i3, i16);
        } else {
            nativeConvertYuvFormatArrayToArray = nativeConvertYuvFormatArrayToArray(value, (byte[]) obj, value2, (byte[]) obj2, i3, i16);
        }
        if (nativeConvertYuvFormatArrayToArray) {
            return;
        }
        throw new IllegalArgumentException("Do not support " + pixelFormatType + " to " + pixelFormatType2);
    }

    public static FloatBuffer createNormalCubeVerticesBuffer() {
        float[] fArr = GLConstants.f119222d;
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).position(0);
    }

    public static int createTexture(int i3, int i16, int i17, int i18) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, i17, i3, i16, 0, i18, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        return iArr[0];
    }

    public static FloatBuffer createTextureCoordsBuffer(k kVar, boolean z16, boolean z17) {
        float[] fArr = GLConstants.f119223e;
        float[] fArr2 = new float[fArr.length];
        initTextureCoordsBuffer(fArr2, kVar, z16, z17);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr2).position(0);
        return asFloatBuffer;
    }

    public static void deleteFrameBuffer(int i3) {
        if (i3 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
        }
    }

    public static void deleteShaderId(int i3) {
        if (i3 != -1) {
            GLES20.glDeleteShader(i3);
        }
    }

    public static void deleteTexture(int i3) {
        if (i3 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        }
    }

    public static void detachTextureFromFrameBuffer(int i3) {
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, 0, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private static float flip(float f16) {
        if (f16 != 0.0f) {
            return 0.0f;
        }
        return 1.0f;
    }

    public static int generateFrameBufferId() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    public static int generateTextureOES() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static Object getCurrentContext() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            return EGL14.eglGetCurrentContext();
        }
        return ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
    }

    public static long getGLContextNativeHandle(Object obj) {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (obj instanceof android.opengl.EGLContext)) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                return ((android.opengl.EGLContext) obj).getNativeHandle();
            }
            return ((android.opengl.EGLContext) obj).getHandle();
        }
        return 0L;
    }

    public static int getGLErrorCount() {
        int i3 = 0;
        while (GLES20.glGetError() != 0) {
            i3++;
        }
        return i3;
    }

    public static void glViewport(int i3, int i16, int i17, int i18) {
        GLES20.glViewport(i3, i16, i17, i18);
    }

    public static void initTextureCoordsBuffer(float[] fArr, k kVar, boolean z16, boolean z17) {
        float[] fArr2 = GLConstants.f119223e;
        if (kVar != null) {
            int i3 = AnonymousClass1.f119369a[kVar.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        fArr2 = GLConstants.f119224f;
                    }
                } else {
                    fArr2 = GLConstants.f119226h;
                }
            } else {
                fArr2 = GLConstants.f119225g;
            }
        }
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        if (z16) {
            fArr[0] = flip(fArr[0]);
            fArr[2] = flip(fArr[2]);
            fArr[4] = flip(fArr[4]);
            fArr[6] = flip(fArr[6]);
        }
        if (z17) {
            fArr[1] = flip(fArr[1]);
            fArr[3] = flip(fArr[3]);
            fArr[5] = flip(fArr[5]);
            fArr[7] = flip(fArr[7]);
        }
    }

    public static boolean isNoGLContext(Object obj) {
        if (obj instanceof EGLContext) {
            return obj.equals(EGL10.EGL_NO_CONTEXT);
        }
        if (!(obj instanceof android.opengl.EGLContext) || getGLContextNativeHandle(obj) != 0) {
            return false;
        }
        return true;
    }

    public static int loadTexture(Bitmap bitmap, int i3, boolean z16) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
            bindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        } else {
            bindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLUtils.texSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, bitmap);
            iArr[0] = i3;
        }
        if (z16) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static void loadYuv420DataToTextures(ByteBuffer byteBuffer, int i3, int i16, int i17, int[] iArr) {
        if (byteBuffer.isDirect()) {
            nativeLoadYuv420ByteBufferToTextures(byteBuffer, i3, i16, i17, iArr);
        } else {
            nativeLoadYuv420ByteArrayToTextures(byteBuffer.array(), i3, i16, i17, iArr);
        }
    }

    private static native boolean nativeConvertYuvFormatArrayToArray(int i3, byte[] bArr, int i16, byte[] bArr2, int i17, int i18);

    private static native boolean nativeConvertYuvFormatArrayToBuffer(int i3, byte[] bArr, int i16, ByteBuffer byteBuffer, int i17, int i18);

    private static native boolean nativeConvertYuvFormatBufferToArray(int i3, ByteBuffer byteBuffer, int i16, byte[] bArr, int i17, int i18);

    private static native boolean nativeConvertYuvFormatBufferToBuffer(int i3, ByteBuffer byteBuffer, int i16, ByteBuffer byteBuffer2, int i17, int i18);

    public static native void nativeCopyDataFromByteArrayToByteBuffer(byte[] bArr, ByteBuffer byteBuffer, int i3);

    public static native void nativeCopyDataFromByteBufferToByteArray(ByteBuffer byteBuffer, byte[] bArr, int i3);

    public static native void nativeCopyDataFromByteBufferToByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i3);

    public static native void nativeCopyYuvFromByteBufferToByteBuffer(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, int i17, int i18, int i19);

    private static native void nativeLoadYuv420ByteArrayToTextures(byte[] bArr, int i3, int i16, int i17, int[] iArr);

    private static native void nativeLoadYuv420ByteBufferToTextures(ByteBuffer byteBuffer, int i3, int i16, int i17, int[] iArr);

    public static void readPixels(int i3, int i16, int i17, int i18, Object obj) {
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            buffer.position(0);
            GLES20.glReadPixels(i3, i16, i17, i18, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
        } else if (obj instanceof byte[]) {
            GLES20.glReadPixels(i3, i16, i17, i18, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, ByteBuffer.wrap((byte[]) obj));
        } else {
            LiteavLog.e(TAG, "read pixels failed due to unsupport object. ".concat(String.valueOf(obj)));
        }
    }

    public static Point reverseMappingPoint(GLConstants.GLScaleType gLScaleType, k kVar, Point point, Size size, Size size2) {
        float f16 = (size2.width * 1.0f) / size.width;
        float f17 = (size2.height * 1.0f) / size.height;
        Matrix matrix = new Matrix();
        matrix.setTranslate((-size.width) / 2.0f, (-size.height) / 2.0f);
        if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
            float min = Math.min(f16, f17);
            matrix.postScale(min, min);
        } else if (gLScaleType == GLConstants.GLScaleType.FILL) {
            matrix.postScale(f16, f17);
        } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            float max = Math.max(f16, f17);
            matrix.postScale(max, max);
        }
        matrix.postRotate(360 - kVar.mValue);
        if (kVar != k.ROTATION_90 && kVar != k.ROTATION_270) {
            matrix.postTranslate(size2.width / 2.0f, size2.height / 2.0f);
        } else {
            matrix.postTranslate(size2.height / 2.0f, size2.width / 2.0f);
        }
        float[] fArr = new float[2];
        matrix.mapPoints(fArr, new float[]{point.x, point.y});
        return new Point((int) fArr[0], (int) fArr[1]);
    }

    public static int loadTexture(int i3, Buffer buffer, int i16, int i17, int i18) {
        int[] iArr = new int[1];
        if (i18 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
            bindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, i3, i16, i17, 0, i3, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
        } else {
            bindTexture(GLSLRender.GL_TEXTURE_2D, i18);
            GLES20.glTexSubImage2D(GLSLRender.GL_TEXTURE_2D, 0, 0, 0, i16, i17, i3, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
            iArr[0] = i18;
        }
        return iArr[0];
    }

    public static void checkGlError(String str) {
    }
}
