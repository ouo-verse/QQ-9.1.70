package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoSR {

    @Nullable
    private static CGLogCallback CGLog_cb_ = null;
    private static final long LOG_INTERVAL_FRAME = 240;
    public static final int SR_SERVICE_ERRR_INVALID_PARAM = 2;
    public static final int SR_SERVICE_ERR_FAILED = 1;
    public static final int SR_SERVICE_ERR_SUCCESS = 0;
    private static final String TAG = "VideoSR";
    public static long avgCostTimeMs_ = 0;

    @Nullable
    private static Callback client_cb_ = null;
    private static int framesPredict_ = 0;
    private static long glContext_ = 0;
    private static long glDisplay_ = 0;
    private static boolean isInitReady_ = false;
    private static boolean isInited_ = false;
    public static boolean isPause_ = false;
    public static final int kSRServiceLogLevelDebug = 0;
    public static final int kSRServiceLogLevelError = 3;
    public static final int kSRServiceLogLevelFATAL = 4;
    public static final int kSRServiceLogLevelInfo = 1;
    public static final int kSRServiceLogLevelVerbose = 10;
    public static final int kSRServiceLogLevelWarning = 2;
    private static int lrHeight_ = 0;
    private static int lrWidth_ = 0;
    public static int predictErrCount_ = 0;
    public static int predictResCode_ = 0;
    public static long predictTimeMs_ = 0;
    private static long renderTimeMs_ = 0;
    private static int scale_ = 0;
    private static int solution_ = 0;
    private static String strBaseDir_ = null;
    private static String strCacheDir_ = null;
    private static String strConfig_ = null;
    private static String strDspLibPath_ = null;
    private static String strGameId_ = null;
    private static final int version_ = 1;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface CGLogCallback {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Callback {
        void OnSrServiceCallbak(int i3, int i16, int i17, int i18, String str);
    }

    static {
        srServiceRelease();
        strBaseDir_ = "1";
        strConfig_ = "1";
        strCacheDir_ = "1";
        strGameId_ = "1";
        strDspLibPath_ = "1";
    }

    @CalledByNative
    public static int CGLog(int i3, String str, String str2) {
        CGLogCallback cGLogCallback = CGLog_cb_;
        if (cGLogCallback == null) {
            return 0;
        }
        if (i3 == 10) {
            cGLogCallback.v(str, str2);
        } else if (i3 == 0) {
            cGLogCallback.d(str, str2);
        } else if (i3 == 1) {
            cGLogCallback.i(str, str2);
        } else if (i3 == 2) {
            cGLogCallback.w(str, str2);
        } else if (i3 == 3 || i3 == 4) {
            cGLogCallback.e(str, str2);
        }
        return 1;
    }

    private static int ClearSrInit() {
        int i3;
        isInited_ = false;
        isInitReady_ = false;
        try {
            i3 = nativesrServiceRelease();
        } catch (Exception e16) {
            e16.printStackTrace();
            Logging.e(TAG, "ClearSrInit exception: " + e16.getMessage());
            i3 = -13107;
        }
        isInitReady_ = true;
        lrWidth_ = 0;
        lrHeight_ = 0;
        predictResCode_ = 0;
        predictErrCount_ = 0;
        Logging.d(TAG, "ClearSrInit.");
        return i3;
    }

    public static int getHeight() {
        return lrHeight_;
    }

    public static int getScale() {
        return scale_;
    }

    public static int getVersion() {
        return 1;
    }

    public static int getWidth() {
        return lrWidth_;
    }

    public static boolean isInited() {
        return isInited_;
    }

    public static boolean isPause() {
        return isPause_;
    }

    public static boolean load(String str) {
        Logging.d(TAG, "Loading library: " + str);
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e16) {
            Logging.e(TAG, "Failed to load native library: " + str, e16);
            return false;
        }
    }

    private static native void nativeCGLogCbEnable(boolean z16);

    private static native int nativesrServiceInit(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, long j3, long j16);

    private static native int nativesrServicePredict(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i3, int i16, int i17);

    private static native int nativesrServicePredictSlice(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4, ByteBuffer byteBuffer5, ByteBuffer byteBuffer6, int i3, int i16, int i17);

    private static native int nativesrServiceRelease();

    private static native String nativesrServiceVersion();

    public static void registerCGLogCallback(CGLogCallback cGLogCallback) {
        CGLog_cb_ = cGLogCallback;
        if (cGLogCallback != null) {
            nativeCGLogCbEnable(true);
        } else {
            nativeCGLogCbEnable(false);
        }
    }

    public static boolean registerSrClientCallback(Callback callback) {
        client_cb_ = callback;
        return true;
    }

    public static int srServiceEnable(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, int i17, int i18, long j3, long j16) {
        Callback callback;
        if (z16) {
            int srServiceInit = srServiceInit(str, str2, str3, str4, str5, i16, i17, i18, j3, j16);
            if (!isPause_ && (callback = client_cb_) != null) {
                callback.OnSrServiceCallbak(solution_, 0, 0, srServiceInit, "ServiceInit Result");
                return srServiceInit;
            }
            return srServiceInit;
        }
        return srServiceRelease();
    }

    private static int srServiceInit(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, long j3, long j16) {
        if (!isInitReady_) {
            return -1;
        }
        isInitReady_ = false;
        int nativesrServiceInit = nativesrServiceInit(str, str2, str3, str4, str5, i3, i16, i17, j3, j16);
        if (nativesrServiceInit == 0) {
            strBaseDir_ = str;
            strConfig_ = str2;
            strCacheDir_ = str3;
            strGameId_ = str4;
            strDspLibPath_ = str5;
            lrWidth_ = i16;
            lrHeight_ = i3;
            scale_ = i17;
            glContext_ = j3;
            glDisplay_ = j16;
            isInited_ = true;
            Logging.d(TAG, "ServiceInit successfully. width=" + i16 + " height=" + i3 + " scale=" + i17 + " ctx=" + j3 + " id=" + j16);
        } else {
            Logging.d(TAG, "ServiceInit error. errCode=" + nativesrServiceInit + " width=" + i16 + " height=" + i3 + " scale=" + i17 + " ctx=" + j3 + " id=" + j16);
        }
        isInitReady_ = true;
        return nativesrServiceInit;
    }

    public static void srServicePause() {
        isPause_ = true;
    }

    public static int srServicePredict(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i3, int i16) {
        if (i16 != lrWidth_ || i3 != lrHeight_) {
            srServiceReinit("ServicePredict", i16, i3);
        }
        int nativesrServicePredict = nativesrServicePredict(byteBuffer, byteBuffer2, i3, i16, scale_);
        if (nativesrServicePredict != 0) {
            Logging.e(TAG, "ServicePredict error! errCode=" + nativesrServicePredict + " scale=" + scale_);
        }
        return nativesrServicePredict;
    }

    public static int srServicePredictSlice(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4, ByteBuffer byteBuffer5, ByteBuffer byteBuffer6, int i3, int i16) {
        Callback callback;
        if (i16 != lrWidth_ || i3 != lrHeight_) {
            srServiceReinit("ServicePredictSlice", i16, i3);
        }
        long nanoTime = System.nanoTime();
        int nativesrServicePredictSlice = nativesrServicePredictSlice(byteBuffer, byteBuffer2, byteBuffer3, byteBuffer4, byteBuffer5, byteBuffer6, i3, i16, scale_);
        if (nativesrServicePredictSlice != 0) {
            predictErrCount_++;
            predictResCode_ = -1;
            Logging.e(TAG, "ServicePredict error!! errCode=" + nativesrServicePredictSlice + " scale=" + scale_);
            if (!isPause_ && (callback = client_cb_) != null) {
                callback.OnSrServiceCallbak(solution_, 0, 2, nativesrServicePredictSlice, "ServicePredict Error");
            }
        } else {
            predictResCode_ = 0;
        }
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
        predictTimeMs_ = nanoTime2;
        long j3 = renderTimeMs_ + nanoTime2;
        renderTimeMs_ = j3;
        int i17 = framesPredict_ + 1;
        framesPredict_ = i17;
        if (i17 >= LOG_INTERVAL_FRAME) {
            avgCostTimeMs_ = j3 / i17;
            Logging.d(TAG, "Perfpormance Statistics: framesPredict=" + framesPredict_ + " renderTimeMs=" + renderTimeMs_ + " avg cost=" + avgCostTimeMs_ + " ms");
            framesPredict_ = 0;
            renderTimeMs_ = 0L;
        }
        return nativesrServicePredictSlice;
    }

    public static int srServiceReinit(String str, int i3, int i16) {
        Callback callback;
        ClearSrInit();
        int srServiceInit = srServiceInit(strBaseDir_, strConfig_, strCacheDir_, strGameId_, strDspLibPath_, i16, i3, scale_, glContext_, glDisplay_);
        if (!isPause_ && (callback = client_cb_) != null) {
            callback.OnSrServiceCallbak(solution_, 0, 1, srServiceInit, "ServiceInit Result");
        }
        Logging.d(TAG, str + " ServiceReinit res=" + srServiceInit + " width=" + i3 + " height=" + i16);
        return srServiceInit;
    }

    public static int srServiceRelease() {
        int ClearSrInit = ClearSrInit();
        strBaseDir_ = "0";
        strConfig_ = "0";
        strCacheDir_ = "0";
        strGameId_ = "0";
        strDspLibPath_ = "0";
        glContext_ = 0L;
        glDisplay_ = 0L;
        scale_ = 1;
        solution_ = 0;
        predictTimeMs_ = 0L;
        renderTimeMs_ = 0L;
        framesPredict_ = 0;
        avgCostTimeMs_ = 0L;
        isPause_ = false;
        unregisterSrClientCallback();
        Logging.d(TAG, "ServiceRelease~");
        return ClearSrInit;
    }

    public static void srServiceResume() {
        isPause_ = false;
    }

    public static void srServiceSendCallback(int i3, int i16, int i17, int i18, String str) {
        if (!isInited_) {
            Logging.e(TAG, "srServiceSendCallback error!! isInited=" + isInited_);
            return;
        }
        if (isPause_) {
            Logging.e(TAG, "srServiceSendCallback error!! isPause=" + isPause_);
            return;
        }
        Callback callback = client_cb_;
        if (callback == null) {
            Logging.e(TAG, "srServiceSendCallback error!! client_cb is null");
        } else {
            callback.OnSrServiceCallbak(i3, i16, i17, i18, str);
        }
    }

    public static String srServiceVersion() {
        return nativesrServiceVersion();
    }

    public static void unregisterCGLogCallback() {
        nativeCGLogCbEnable(false);
        CGLog_cb_ = null;
    }

    public static void unregisterSrClientCallback() {
        client_cb_ = null;
    }
}
