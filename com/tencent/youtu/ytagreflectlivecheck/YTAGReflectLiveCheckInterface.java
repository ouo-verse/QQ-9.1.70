package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.CAPTCHA;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTAGReflectLiveCheckInterface {
    static IPatchRedirector $redirector_ = null;
    private static int ERRCODE_GET_ACTREFLECTDATA_FAILED = 4;
    private static int ERRCODE_JNI_DETECT_FAILED = 3;
    private static int ERRCODE_JSON_DECODE_FAILED = 2;
    private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
    private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
    private static final String TAG = "YoutuLightLiveCheck";
    public static final String VERSION = "3.6.9.2";
    private static Lock initLock = null;
    public static YTAGReflectSettings mAGSettings = null;
    public static String mAppId = "";
    private static Camera mCamera;
    private static int mCameraRotatedTag;
    private static LightLiveCheckResult mCheckResult;
    private static String mColorSeq;
    private static int mInitModel;
    private static int mOnGetValueCount;
    private static int mOverlayAlpha;
    private static IYTReflectListener mReflectListener;
    public static YTReflectNotice mReflectNotice;
    private static int mState;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYTReflectListener {
        float onGetAppBrightness();

        void onReflectEvent(ColorMatrixColorFilter colorMatrixColorFilter, float f16);

        void onReflectStart(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface LightLiveCheckResult {
        public static final int AUTH_FAILED = 1;
        public static final int COLOR_DATA_ERROR = 500;
        public static final int FINISH_ERRORBASE = 300;
        public static final int INIT_ERROR = 400;
        public static final int INIT_ERRORBASE = 100;
        public static final int NOT_INIT_MODEL = 2;
        public static final int NOT_SET_RGBREQUEST = 4;
        public static final int NOT_SET_UPLOADREQUEST = 5;
        public static final int REFLECT_ERRORBASE = 200;
        public static final int SUCCESS = 0;
        public static final int USER_CANCEL = 3;

        void onFailed(int i3, String str, String str2);

        void onReflectLiveImgData(RawImgData rawImgData);

        void onSuccess(ReflectionData reflectionData);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface LightLiveProcessState {
        public static final int GET_RGBCONFIG = 1;
        public static final int HANGUP = 0;
        public static final int REFLECTING = 2;
        public static final int UPLOAD = 3;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface YTSAFETYLEVEL {
        public static final int SAFETY_HIGH = 2;
        public static final int SAFETY_LOW = 1;
        public static final int SAFETY_RECOMMEND = 0;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19912);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        mAGSettings = new YTAGReflectSettings();
        mInitModel = 0;
        initLock = new ReentrantLock();
        mOverlayAlpha = 0;
    }

    public YTAGReflectLiveCheckInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cancel() {
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.cancel] --- ");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRRelease();
    }

    public static YTAGReflectSettings getAGSettings() {
        return mAGSettings;
    }

    public static IYTReflectListener getReflectListener() {
        return mReflectListener;
    }

    public static synchronized int initModel(String str, String str2) {
        int i3;
        synchronized (YTAGReflectLiveCheckInterface.class) {
            try {
                try {
                    initLock.lock();
                    if (mInitModel > 0) {
                        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "initModel repeated calls.");
                    } else {
                        mAppId = str;
                        if (str == null) {
                            mAppId = "";
                        }
                    }
                    mInitModel++;
                    initLock.unlock();
                    i3 = 0;
                } catch (Throwable th5) {
                    initLock.unlock();
                    throw th5;
                }
            } catch (Exception e16) {
                YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "initModel failed. message: " + Log.getStackTraceString(e16));
                initLock.unlock();
                i3 = -1;
            }
            YTAGReflectLiveCheckJNIInterface.SetPipelineVersion(str2);
        }
        return i3;
    }

    public static void onCameraChanged(int i3) {
        Log.d(TAG, "on Camera changed " + i3);
        try {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setExposureCompensation(i3);
            mCamera.setParameters(parameters);
        } catch (Exception e16) {
            Log.e(TAG, "on camera changed failed:" + Log.getStackTraceString(e16));
        }
    }

    public static int[] onFetchCameraInfo() {
        int i3;
        int i16;
        int i17;
        try {
            Camera.Parameters parameters = mCamera.getParameters();
            i3 = parameters.getExposureCompensation();
            try {
                try {
                    String str = parameters.get("iso");
                    if (!TextUtils.isEmpty(str)) {
                        i3 = Integer.parseInt(str);
                    }
                } catch (Exception e16) {
                    e = e16;
                    i16 = 0;
                    Log.d(TAG, "on fectch camera info failed:" + Log.getStackTraceString(e));
                    i17 = 0;
                    Log.d(TAG, "on fetch camera exp:" + i3 + " min:" + i16 + " max:" + i17);
                    return new int[]{i3, i16, i17};
                }
            } catch (Exception e17) {
                Log.d(TAG, "on fectch camera compoensation failed:" + Log.getStackTraceString(e17));
            }
            i16 = parameters.getMinExposureCompensation();
            try {
                i17 = parameters.getMaxExposureCompensation();
            } catch (Exception e18) {
                e = e18;
                Log.d(TAG, "on fectch camera info failed:" + Log.getStackTraceString(e));
                i17 = 0;
                Log.d(TAG, "on fetch camera exp:" + i3 + " min:" + i16 + " max:" + i17);
                return new int[]{i3, i16, i17};
            }
        } catch (Exception e19) {
            e = e19;
            i3 = 0;
            i16 = 0;
        }
        Log.d(TAG, "on fetch camera exp:" + i3 + " min:" + i16 + " max:" + i17);
        return new int[]{i3, i16, i17};
    }

    public static void onFinish() {
        ReflectionData reflectionData;
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "on finished");
        int FRDoDetectionYuvs = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, mCameraRotatedTag);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "on finished " + FRDoDetectionYuvs);
        if (FRDoDetectionYuvs == 0) {
            FullPack FRGetAGin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
            ReflectionData reflectionData2 = new ReflectionData();
            DataPack dataPack = FRGetAGin.AGin;
            if (dataPack != null) {
                reflectionData = reflectionData2;
                reflectionData2.setDataPack(dataPack.videoData, dataPack.beginTime, dataPack.changePointTime, dataPack.changePointTimeList, dataPack.offsetSys, dataPack.frameNum, dataPack.landMarkNum, dataPack.width, dataPack.height, dataPack.config_begin, dataPack.log, dataPack.seqID);
            } else {
                reflectionData = reflectionData2;
            }
            CAPTCHA captcha = FRGetAGin.CP;
            if (captcha != null) {
                reflectionData.setCaptcha(captcha.fixedInterval, captcha.unit, captcha.randShift, captcha.randInv, captcha.intervals, captcha.seqID, FRGetAGin.frames);
            }
            mCheckResult.onSuccess(reflectionData);
            return;
        }
        mCheckResult.onFailed(-1, "JNI return failed.[" + FRDoDetectionYuvs + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: " + FRDoDetectionYuvs);
    }

    public static void onReflectLiveImgData(RawImgData rawImgData) {
        mCheckResult.onReflectLiveImgData(rawImgData);
    }

    public static void onScreenChanged(int i3, int i16, int i17, int i18, float f16) {
        float[] fArr;
        if (mOverlayAlpha != 0) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, i16, 0.0f, 0.0f, 0.0f, 0.0f, i17, 0.0f, 0.0f, 0.0f, 0.0f, i18, 0.0f, 0.0f, 0.0f, i3, 0.0f};
        } else {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, i16, 0.0f, 0.0f, 0.0f, 0.0f, i17, 0.0f, 0.0f, 0.0f, 0.0f, i18, 0.0f, 0.0f, 0.0f, 0.0f, i3};
        }
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(fArr);
        IYTReflectListener iYTReflectListener = mReflectListener;
        if (iYTReflectListener == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "On reflection screen change failed:mReflectListener is null");
        } else {
            iYTReflectListener.onReflectEvent(colorMatrixColorFilter, f16);
        }
    }

    public static void onStateChanged(int i3) {
        mState = i3;
        Log.d(TAG, "on state changed call " + mState);
        try {
            if (i3 == 0) {
                Camera.Parameters parameters = mCamera.getParameters();
                parameters.setAutoWhiteBalanceLock(true);
                mCamera.setParameters(parameters);
                return;
            }
            if (i3 == 1) {
                YTReflectNotice yTReflectNotice = mReflectNotice;
                if (yTReflectNotice != null) {
                    yTReflectNotice.onDelayCalc();
                    return;
                }
                return;
            }
            if (i3 == 2) {
                try {
                    try {
                        Camera.Parameters parameters2 = mCamera.getParameters();
                        parameters2.setAutoWhiteBalanceLock(false);
                        mCamera.setParameters(parameters2);
                    } catch (Throwable th5) {
                        onFinish();
                        throw th5;
                    }
                } catch (Exception e16) {
                    YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "on finish get param failed:" + Log.getStackTraceString(e16));
                }
                onFinish();
            }
        } catch (Exception e17) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "on state changed failed:" + Log.getStackTraceString(e17));
        }
    }

    public static void pushImageData(byte[] bArr, int i3, int i16, long j3, int i17, float[] fArr, float f16, float f17, float f18) {
        int i18 = mState;
        if (i18 == 0) {
            int FRGetConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin() - 2;
            int FRGetConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd() + 4;
            int FRGetTriggerTime = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetTriggerTime();
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "onPreviewFrameReceived. beginFrame: " + FRGetConfigBegin + " endFrame: " + FRGetConfigEnd + " currentFrame: " + FRGetTriggerTime);
            if (FRGetTriggerTime > FRGetConfigBegin && FRGetTriggerTime < FRGetConfigEnd) {
                System.currentTimeMillis();
                YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "onPreviewFrameReceived. insertYuv and time");
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(bArr, i3, i16, JNIUtils.getTimeval(j3), i17, fArr);
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval(j3));
                return;
            }
            return;
        }
        if (i18 == 1) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[ReflectController.onPreviewFrameReceived] record ios");
            YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(bArr, i3, i16);
            YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval(j3));
        }
    }

    public static synchronized void releaseModel() {
        synchronized (YTAGReflectLiveCheckInterface.class) {
            try {
                initLock.lock();
                int i3 = mInitModel - 1;
                mInitModel = i3;
                if (i3 <= 0) {
                    mInitModel = 0;
                    mReflectNotice = null;
                    mReflectListener = null;
                    mCamera = null;
                }
                initLock.unlock();
                YTAGReflectLiveCheckJNIInterface.clearInstance();
            } catch (Throwable th5) {
                initLock.unlock();
                throw th5;
            }
        }
    }

    public static void setAGSettings(YTAGReflectSettings yTAGReflectSettings) {
        mAGSettings = yTAGReflectSettings;
    }

    public static void setReflectListener(IYTReflectListener iYTReflectListener) {
        mReflectListener = iYTReflectListener;
    }

    public static void setReflectNotice(YTReflectNotice yTReflectNotice) {
        mReflectNotice = yTReflectNotice;
    }

    public static void setSafetyLevel(int i3) {
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: " + i3);
        mAGSettings.safetylevel = i3;
    }

    public static void setupConfig(String str, String str2) {
        if (str == "overlay_alpha") {
            try {
                mOverlayAlpha = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                mOverlayAlpha = 0;
            }
        }
    }

    public static void start(Context context, Camera camera2, int i3, String str, LightLiveCheckResult lightLiveCheckResult) {
        float f16;
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "[YTAGReflectLiveCheckInterface.start] ---");
        if (lightLiveCheckResult == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "On reflection start failed:checkResult is null");
            return;
        }
        mCheckResult = lightLiveCheckResult;
        if (mInitModel <= 0) {
            lightLiveCheckResult.onFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
            return;
        }
        mCameraRotatedTag = i3;
        mColorSeq = str;
        mCamera = camera2;
        long[] jArr = new long[2];
        if (mReflectListener == null) {
            YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "On reflection start failed:mReflectListener is null");
        }
        IYTReflectListener iYTReflectListener = mReflectListener;
        if (iYTReflectListener != null) {
            f16 = iYTReflectListener.onGetAppBrightness();
        } else {
            f16 = -1.0f;
        }
        int FRInit = YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(false, str, mAGSettings.safetylevel, jArr, f16);
        YTAGReflectLiveCheckJNIInterface.nativeLog(TAG, "output duration ms" + jArr[0] + " " + jArr[1]);
        if (FRInit != 0) {
            if (FRInit != -1 && FRInit != -2 && FRInit != -3) {
                lightLiveCheckResult.onFailed(400, "Reflection Init Error", "");
                return;
            } else {
                lightLiveCheckResult.onFailed(500, "Color Data Error", "Check Color Data Format");
                return;
            }
        }
        IYTReflectListener iYTReflectListener2 = mReflectListener;
        if (iYTReflectListener2 != null) {
            iYTReflectListener2.onReflectStart(jArr[0]);
        }
    }
}
