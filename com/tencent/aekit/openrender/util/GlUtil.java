package com.tencent.aekit.openrender.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.ETC1Util;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class GlUtil {
    static IPatchRedirector $redirector_ = null;
    public static final float[] EMPTY_POSITIONS;
    public static final float[] EMPTY_POSITIONS_TRIANGLES;
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    public static final float[] IDENTITY_MATRIX;
    public static final int NO_TEXTURE = -1;
    public static final float[] ORIGIN_POSITION_COORDS;
    public static final float[] ORIGIN_TEX_COORDS;
    public static final float[] ORIGIN_TEX_COORDS_REVERSE;
    public static final float[] ORIGIN_TEX_COORDS_TRIANGLES;
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG;
    private static AtomicInteger blendModeRef;
    public static boolean curBlendModeEnabled;
    private static boolean enableLog;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12590);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = GlUtil.class.getSimpleName();
        EMPTY_POSITIONS = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        EMPTY_POSITIONS_TRIANGLES = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        ORIGIN_POSITION_COORDS = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
        ORIGIN_TEX_COORDS = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        ORIGIN_TEX_COORDS_REVERSE = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        ORIGIN_TEX_COORDS_TRIANGLES = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
        enableLog = true;
        blendModeRef = new AtomicInteger(0);
    }

    GlUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @TargetApi(18)
    public static void checkEglError(String str) {
        if (!enableLog) {
            return;
        }
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                Log.e(TAG, str + ": eglGetError: 0x" + Integer.toHexString(eglGetError));
            } else {
                return;
            }
        }
    }

    public static void checkGlError(String str) {
        int glGetError;
        if (enableLog && (glGetError = GLES20.glGetError()) != 0) {
            Log.e(TAG, str + ": glError " + glGetError);
            for (StackTraceElement stackTraceElement : Thread.getAllStackTraces().get(Thread.currentThread())) {
                Log.e(TAG, stackTraceElement.toString());
            }
        }
    }

    public static void createEtcTexture(int[] iArr) {
        GLES20.glGenTextures(iArr.length, iArr, 0);
        for (int i3 : iArr) {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        }
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int createImageTexture(ByteBuffer byteBuffer, int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i18 = iArr[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i18);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, i17, i3, i16, 0, i17, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
        checkGlError("loadImageTexture");
        return i18;
    }

    public static FloatBuffer createSquareVtx() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(80);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(new float[]{-1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f});
        asFloatBuffer.position(0);
        return asFloatBuffer;
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

    public static void glBindTexture(int i3, int i16) {
        GLES20.glBindTexture(i3, i16);
    }

    public static void glDeleteTextures(int i3, int[] iArr, int i16) {
        GLES20.glDeleteTextures(i3, iArr, i16);
    }

    public static void glGenTextures(int i3, int[] iArr, int i16) {
        GLES20.glGenTextures(i3, iArr, i16);
    }

    public static void glTexImage2D(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, Buffer buffer) {
        GLES20.glTexImage2D(i3, i16, i17, i18, i19, i26, i27, i28, buffer);
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    @RequiresApi(api = 18)
    public static void loadFloatTexture(int i3, FloatBuffer floatBuffer, int i16, int i17) {
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        checkGlError("loadFloatTexture");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 33328, i16, i17, 0, 33319, 5126, floatBuffer);
        checkGlError("loadFloatTexture");
    }

    public static void loadTexture(int i3, ETC1Util.ETC1Texture eTC1Texture) {
        if (eTC1Texture != null) {
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            ETC1Util.loadTexture(GLSLRender.GL_TEXTURE_2D, 0, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_SHORT_5_6_5, eTC1Texture);
        }
    }

    public static void logVersionInfo() {
        String str = TAG;
        Log.i(str, "vendor  : " + GLES20.glGetString(7936));
        Log.i(str, "renderer: " + GLES20.glGetString(7937));
        Log.i(str, "version : " + GLES20.glGetString(7938));
    }

    public static void resetFilterCoords(VideoFilterBase videoFilterBase) {
        if (videoFilterBase == null) {
            return;
        }
        videoFilterBase.setTexCords(AEOpenRenderConfig.ORIGIN_POSITION_COORDS);
        videoFilterBase.setTexCords(AEOpenRenderConfig.ORIGIN_TEX_COORDS);
    }

    public static Bitmap saveTexture(Frame frame) {
        return saveTexture(frame.getTextureId(), frame.width, frame.height);
    }

    public static void saveTextureToRgbaBuffer(int i3, int i16, int i17, byte[] bArr, int i18) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        GLES20.glBindFramebuffer(36160, i18);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        checkGlError("glFramebufferTexture2D");
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        GLES20.glPixelStorei(3333, 1);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        GLES20.glBindFramebuffer(36160, 0);
        checkGlError("glBindFramebuffer");
    }

    public static void setBlendMode(boolean z16) {
        curBlendModeEnabled = z16;
        if (z16) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        } else {
            GLES20.glDisable(3042);
        }
    }

    public static void setBlendModeSrcAlpha(boolean z16) {
        if (z16) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        } else {
            GLES20.glDisable(3042);
        }
    }

    public static void setEnableLog(boolean z16) {
        enableLog = z16;
    }

    public static void texImage2D(int i3, int i16, int i17, Bitmap bitmap, int i18) {
        GLUtils.texImage2D(i3, i16, i17, bitmap, i18);
    }

    public static Bitmap saveTexture(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        checkGlError("glFramebufferTexture2D");
        checkGlError("glReadPixels");
        ByteBuffer wrap = ByteBuffer.wrap(new byte[i16 * i17 * 4]);
        GLES20.glPixelStorei(3333, 1);
        GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        Bitmap createBitmap = Bitmap.createBitmap(i16, i17, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(wrap);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        checkGlError("glBindFramebuffer");
        return createBitmap;
    }

    public static void texImage2D(int i3, int i16, int i17, Bitmap bitmap, int i18, int i19) {
        GLUtils.texImage2D(i3, i16, i17, bitmap, i18, i19);
    }

    public static void loadTexture(int i3, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
    }

    public static void texImage2D(int i3, int i16, Bitmap bitmap, int i17) {
        GLUtils.texImage2D(i3, i16, bitmap, i17);
    }

    public static void loadTexture(int i3, ByteBuffer byteBuffer, int i16, int i17, int i18) {
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, i18, i16, i17, 0, i18, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
        checkGlError("loadImageTexture");
    }

    public static int createTexture(int i3) {
        return createTexture(i3, null, 9729, 9729, 33071, 33071);
    }

    public static void saveTextureToRgbaBuffer(int i3, int i16, int i17, int i18, int i19, byte[] bArr, int i26) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        GLES20.glBindFramebuffer(36160, i26);
        checkGlError("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        checkGlError("glFramebufferTexture2D");
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        GLES20.glPixelStorei(3333, 1);
        GLES20.glReadPixels(i16, i17, i18, i19, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        GLES20.glBindFramebuffer(36160, 0);
        checkGlError("glBindFramebuffer");
    }
}
