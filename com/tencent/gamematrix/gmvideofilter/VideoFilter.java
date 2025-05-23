package com.tencent.gamematrix.gmvideofilter;

import android.os.Build;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import org.tencwebrtc.CalledByNative;
import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes6.dex */
public class VideoFilter {

    @Nullable
    private static CGLogCallback CGLog_cb_ = null;
    public static final int DEBUG = 1;
    public static final int ERROR = 5;
    public static final int Event = 3;
    public static final int INFO = 2;
    private static final long LOG_INTERVAL_FRAME = 240;
    public static final int SDK_INT;
    private static final String TAG = "VideoFilter";
    public static final int VERBOSE = 0;
    public static final int WARN = 4;
    public static long avgCostTimeMs_;
    private static final Object callbackThreadLock_;

    @Nullable
    private static Thread callbackThread_;

    @Nullable
    private static Callback client_cb_;
    public static int draw_errcode_;
    private static int framesPredict_;
    public static int init_errcode_;
    public static boolean isFsrEnabled_;
    private static long renderTimeMs_;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface CGLogCallback {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Callback {
        void OnVideoFilterCallbak(int i3, int i16, int i17, int i18, String str);
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i3 = 26;
        }
        SDK_INT = i3;
        callbackThreadLock_ = new Object();
    }

    @CalledByNative
    public static int CGLog(int i3, String str, String str2) {
        CGLogCallback cGLogCallback = CGLog_cb_;
        if (cGLogCallback == null) {
            return 0;
        }
        if (i3 == 0) {
            cGLogCallback.v(str, str2);
        } else if (i3 == 1) {
            cGLogCallback.d(str, str2);
        } else if (i3 != 2 && i3 != 3) {
            if (i3 == 4) {
                cGLogCallback.w(str, str2);
            } else if (i3 == 5) {
                cGLogCallback.e(str, str2);
            }
        } else {
            cGLogCallback.i(str, str2);
        }
        return 1;
    }

    public static void drawOes(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27) {
        int nativedrawOes = nativedrawOes(i3, fArr, i16, i17, i18, i19, i26, i27);
        if ((65536 & nativedrawOes) != 0) {
            draw_errcode_ = nativedrawOes & 255;
        } else {
            init_errcode_ = nativedrawOes;
        }
    }

    public static void drawYuv(int[] iArr, float[] fArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        nativedrawYuv(iArr, fArr, i3, i16, i17, i18, i19, i26);
    }

    public static float getSharpFactor() {
        return nativegetSharpFactor();
    }

    public static void inputYuvFileToDumpFsrEnabled(boolean z16) {
        nativeinputYuvFileToDumpFsrEnabled(z16);
    }

    public static boolean isOpenFsr() {
        return nativeisOpenFsr();
    }

    public static boolean isOpenTvesr() {
        return nativeisOpenTvesr();
    }

    public static void load_kernel(ByteBuffer byteBuffer, long j3) {
        nativeload_kernel(byteBuffer, j3);
    }

    private static native void nativeCGLogCbEnable(boolean z16);

    private static native void nativeFilterClientCbEnable(boolean z16);

    private static native void nativeSetSGSRDeltaLimit(float f16);

    private static native void nativeSetSGSREdgeSharpness(float f16);

    private static native void nativeSetSGSREdgeThreshold(float f16);

    private static native int nativedrawOes(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27);

    private static native int nativedrawYuv(int[] iArr, float[] fArr, int i3, int i16, int i17, int i18, int i19, int i26);

    private static native float nativegetSharpFactor();

    private static native void nativeinputYuvFileToDumpFsrEnabled(boolean z16);

    private static native boolean nativeisOpenFsr();

    private static native boolean nativeisOpenTvesr();

    private static native void nativeload_kernel(ByteBuffer byteBuffer, long j3);

    private static native void nativerelease();

    private static native void nativesetFsrOesTransferType(int i3);

    private static native void nativesetOpenFsr(boolean z16, int i3);

    private static native void nativesetOpenTvesr(boolean z16);

    private static native void nativesetSharpFactor(float f16);

    public static void registerCGLogCallback(CGLogCallback cGLogCallback) {
        CGLog_cb_ = cGLogCallback;
        if (cGLogCallback != null) {
            nativeCGLogCbEnable(true);
        } else {
            nativeCGLogCbEnable(false);
        }
    }

    public static boolean registerFilterClientCallback(Callback callback) {
        client_cb_ = callback;
        if (callback != null) {
            nativeFilterClientCbEnable(true);
        } else {
            nativeFilterClientCbEnable(false);
        }
        return true;
    }

    public static void release() {
        nativerelease();
        synchronized (callbackThreadLock_) {
            isFsrEnabled_ = false;
            Thread thread = callbackThread_;
            if (thread != null) {
                try {
                    thread.join(2000L);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                callbackThread_ = null;
            }
        }
    }

    public static void setDrawerRotate(float f16) {
        Log.e(TAG, "No need to call setDrawerRotate.do not need to do anything!");
    }

    public static void setFsrOesTransferType(int i3) {
        nativesetFsrOesTransferType(i3);
    }

    public static void setOpenFsr(boolean z16, int i3) {
        synchronized (callbackThreadLock_) {
            isFsrEnabled_ = z16;
        }
        nativesetOpenFsr(z16, i3);
    }

    public static void setOpenTvesr(boolean z16) {
        synchronized (callbackThreadLock_) {
            if (z16) {
                isFsrEnabled_ = false;
            }
        }
        nativesetOpenTvesr(z16);
    }

    public static void setSGSRDeltaLimit(float f16) {
        nativeSetSGSRDeltaLimit(f16);
    }

    public static void setSGSREdgeSharpness(float f16) {
        nativeSetSGSREdgeSharpness(f16);
    }

    public static void setSGSREdgeThreshold(float f16) {
        nativeSetSGSREdgeThreshold(f16);
    }

    public static void setSharpFactor(float f16) {
        nativesetSharpFactor(f16);
    }

    public static void unregisterCGLogCallback() {
        nativeCGLogCbEnable(false);
        CGLog_cb_ = null;
    }

    public static void unregisterFilterClientCallback() {
        nativeFilterClientCbEnable(false);
        client_cb_ = null;
    }

    public static void updateRenderTime(long j3) {
        long j16 = renderTimeMs_ + j3;
        renderTimeMs_ = j16;
        int i3 = framesPredict_ + 1;
        framesPredict_ = i3;
        if (i3 >= LOG_INTERVAL_FRAME) {
            avgCostTimeMs_ = j16 / i3;
            Logging.d(TAG, "Perfpormance Statistics: framesPredict=" + framesPredict_ + " renderTimeMs=" + renderTimeMs_ + " avg cost=" + avgCostTimeMs_ + " ms");
            framesPredict_ = 0;
            renderTimeMs_ = 0L;
        }
    }

    @CalledByNative
    public static void videoFilterSendCallback(int i3, int i16, int i17, int i18, String str) {
        synchronized (callbackThreadLock_) {
            if (client_cb_ == null) {
                Logging.e(TAG, "videoFilterSendCallback error!! client_cb is null");
                return;
            }
            Logging.w(TAG, "videoFilterSendCallback solution=" + i3 + " module=" + i16 + " function=" + i17 + " errCode=" + i18 + " desc=" + str);
            Thread thread = callbackThread_;
            if (thread != null) {
                try {
                    thread.join(2000L);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                callbackThread_ = null;
            }
            if (!isFsrEnabled_) {
                Logging.w(TAG, "videoFilterSendCallback isFsrEnabled=" + isFsrEnabled_);
                return;
            }
            BaseThread baseThread = new BaseThread(new VideoFilterRunnable(client_cb_, i3, i16, i17, i18, str));
            callbackThread_ = baseThread;
            baseThread.start();
        }
    }

    public static void drawRgb(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27) {
    }
}
