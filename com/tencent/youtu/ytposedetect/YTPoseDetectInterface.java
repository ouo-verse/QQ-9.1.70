package com.tencent.youtu.ytposedetect;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytposedetect.data.PoseDetectData;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

/* loaded from: classes27.dex */
public class YTPoseDetectInterface {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "YoutuFaceDetect";
    public static final String VERSION = "3.6.0";
    private static PoseDetectResult mCheckResult = null;
    private static int mInitModel = 0;
    private static boolean mIsStarted = false;
    public static int mModelRetainCount = 0;
    private static PoseDetectProcessManager mPoseDetectProcessManager = null;
    public static int mRotateTag = 1;
    private static PoseDetectOnFrame sPoseDetectOnFrame;

    /* loaded from: classes27.dex */
    public interface PoseDetectGetBestImage {
        void onGetBestImage(byte[] bArr, int i3, int i16);
    }

    /* loaded from: classes27.dex */
    public interface PoseDetectGetImage {
        void onGetImage(byte[] bArr, int i3, int i16);
    }

    /* loaded from: classes27.dex */
    public interface PoseDetectLiveType {
        public static final int LIVETYPE_BLINK_EYE = 1;
        public static final int LIVETYPE_CLOSER_FAR = 8;
        public static final int LIVETYPE_FAR_CLOSER = 9;
        public static final int LIVETYPE_NOD_HEAD = 3;
        public static final int LIVETYPE_OPEN_MOUTH = 2;
        public static final int LIVETYPE_SHAKE_HEAD = 4;
        public static final int LIVETYPE_SILENCE = 5;
        public static final int LIVETYPE_TURN_LEFT = 6;
        public static final int LIVETYPE_TURN_RIGHT = 7;
    }

    /* loaded from: classes27.dex */
    public interface PoseDetectOnFrame {
        public static final int DETECT_AUTH_FAILED = 1;
        public static final int DETECT_NOT_CALL_START = 3;
        public static final int DETECT_NOT_INIT_MODEL = 2;
        public static final int DETECT_SUCCESS = 0;

        void onActionFrames(YTActRefImage[] yTActRefImageArr);

        void onCanReflect();

        void onFailed(int i3, String str, String str2);

        boolean onOneActionFrame(byte[] bArr, int i3, int i16, int i17);

        void onRecordingDone(int i3, int i16);

        void onSuccess(int i3);
    }

    /* loaded from: classes27.dex */
    public interface PoseDetectResult {
        public static final int ERROR_AUTH_FAILED = 1;
        public static final int ERROR_NOT_INIT_MODEL = 2;
        public static final int SUCCESS = 0;

        void onFailed(int i3, String str, String str2);

        void onSuccess();
    }

    /* loaded from: classes27.dex */
    public interface PoseDetectSafetyLevel {
        public static final int SAFETY_COUNT = 3;
        public static final int SAFETY_HIGH = 2;
        public static final int SAFETY_LOW = 1;
        public static final int SAFETY_RECOMMAND = 0;
    }

    /* loaded from: classes27.dex */
    public class PoseImage {
        static IPatchRedirector $redirector_;
        public byte[] data;
        public int height;
        public int width;

        public PoseImage() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) YTPoseDetectInterface.this);
            }
        }
    }

    public YTPoseDetectInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean callbackFrame(byte[] bArr, int i3, int i16, int i17) {
        PoseDetectOnFrame poseDetectOnFrame = sPoseDetectOnFrame;
        if (poseDetectOnFrame != null) {
            return poseDetectOnFrame.onOneActionFrame(bArr, i3, i16, i17);
        }
        return false;
    }

    public static void callbackFrameList(YTActRefImage[] yTActRefImageArr) {
        PoseDetectOnFrame poseDetectOnFrame = sPoseDetectOnFrame;
        if (poseDetectOnFrame != null) {
            poseDetectOnFrame.onActionFrames(yTActRefImageArr);
        }
    }

    public static YTActRefData getActReflectData() {
        return YTPoseDetectJNIInterface.getActionReflectData(mPoseDetectProcessManager.mCameraRotateTag);
    }

    public static void getBestImage(PoseDetectGetBestImage poseDetectGetBestImage, boolean z16) {
        int i3 = z16 ? mPoseDetectProcessManager.mCameraRotateTag : 1;
        byte[] bestImage = YTPoseDetectJNIInterface.getBestImage();
        if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8) {
            PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
            poseDetectGetBestImage.onGetBestImage(bestImage, poseDetectProcessManager.mDesiredPreviewWidth, poseDetectProcessManager.mDesiredPreviewHeight);
        } else {
            PoseDetectProcessManager poseDetectProcessManager2 = mPoseDetectProcessManager;
            poseDetectGetBestImage.onGetBestImage(bestImage, poseDetectProcessManager2.mDesiredPreviewHeight, poseDetectProcessManager2.mDesiredPreviewWidth);
        }
    }

    public static YTPoseImage getEyeImage(int i3) {
        YTPoseImage yTPoseImage = new YTPoseImage();
        yTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getEyeImage(i3);
        if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8) {
            PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
            yTPoseImage.width = poseDetectProcessManager.mDesiredPreviewWidth;
            yTPoseImage.height = poseDetectProcessManager.mDesiredPreviewHeight;
        } else {
            PoseDetectProcessManager poseDetectProcessManager2 = mPoseDetectProcessManager;
            yTPoseImage.width = poseDetectProcessManager2.mDesiredPreviewHeight;
            yTPoseImage.height = poseDetectProcessManager2.mDesiredPreviewWidth;
        }
        return yTPoseImage;
    }

    public static YTPoseImage getMouthImage(int i3) {
        YTPoseImage yTPoseImage = new YTPoseImage();
        yTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getMouthImage(i3);
        if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8) {
            PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
            yTPoseImage.width = poseDetectProcessManager.mDesiredPreviewWidth;
            yTPoseImage.height = poseDetectProcessManager.mDesiredPreviewHeight;
        } else {
            PoseDetectProcessManager poseDetectProcessManager2 = mPoseDetectProcessManager;
            yTPoseImage.width = poseDetectProcessManager2.mDesiredPreviewHeight;
            yTPoseImage.height = poseDetectProcessManager2.mDesiredPreviewWidth;
        }
        return yTPoseImage;
    }

    public static String getVersion() {
        return "jar3.6.0_native" + YTPoseDetectJNIInterface.getVersion();
    }

    public static int initModel() {
        try {
            YTPoseDetectJNIInterface.nativeLog(TAG, "[YTFacePreviewInterface.initModel] ---");
            if (mInitModel > 0) {
                YTPoseDetectJNIInterface.nativeLog(TAG, "[YTFacePreviewInterface.initModel] has already inited.");
                mInitModel++;
                return 0;
            }
            int initModel = YTPoseDetectJNIInterface.initModel("");
            if (initModel == 0) {
                PoseDetectProcessManager poseDetectProcessManager = new PoseDetectProcessManager();
                mPoseDetectProcessManager = poseDetectProcessManager;
                poseDetectProcessManager.initAll();
                mInitModel++;
                return 0;
            }
            return initModel;
        } catch (Exception e16) {
            YTPoseDetectJNIInterface.nativeLog(TAG, "initModel failed. message: " + Log.getStackTraceString(e16));
            Log.e(TAG, "initModel failed. message: " + Log.getStackTraceString(e16));
            return 10;
        }
    }

    public static boolean isDetecting() {
        PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
        if (poseDetectProcessManager != null && poseDetectProcessManager.mIsDetecting) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void noticeFailed(int i3, String str, String str2) {
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.noticeFailed] resultCode: " + i3 + " \r\nmessage: " + str + " \r\ntips: " + str2);
        mCheckResult.onFailed(i3, str, str2);
        mCheckResult = null;
        mIsStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void noticeSuccess() {
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.noticeSuccess] ---");
        mCheckResult.onSuccess();
        mCheckResult = null;
        mIsStarted = true;
    }

    public static void poseDetect(PoseDetectData poseDetectData, PoseDetectOnFrame poseDetectOnFrame, int i3) {
        int i16;
        int i17;
        sPoseDetectOnFrame = poseDetectOnFrame;
        if (mInitModel <= 0) {
            poseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
            return;
        }
        if (!mIsStarted) {
            poseDetectOnFrame.onFailed(3, "Not call start() interface before.", "Call YTPoseDetectInterface.start() before.");
            return;
        }
        poseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(poseDetectData));
        if (YTPoseDetectJNIInterface.canReflect()) {
            poseDetectOnFrame.onCanReflect();
        }
        if (YTPoseDetectJNIInterface.isRecordingDone()) {
            PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
            int i18 = poseDetectProcessManager.mCameraRotateTag;
            if (i3 == 1 && (i18 == 5 || i18 == 6 || i18 == 7 || i18 == 8)) {
                i16 = poseDetectProcessManager.mDesiredPreviewHeight;
            } else {
                i16 = poseDetectProcessManager.mDesiredPreviewWidth;
            }
            if (i3 == 1 && (i18 == 5 || i18 == 6 || i18 == 7 || i18 == 8)) {
                i17 = poseDetectProcessManager.mDesiredPreviewWidth;
            } else {
                i17 = poseDetectProcessManager.mDesiredPreviewHeight;
            }
            YTPoseDetectJNIInterface.getOneActionFrame(i17, i16);
            poseDetectOnFrame.onRecordingDone(i17, i16);
        }
    }

    public static void releaseModel() {
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTFacePreviewInterface.finalize] ---");
        sPoseDetectOnFrame = null;
        int i3 = mInitModel - 1;
        mInitModel = i3;
        if (i3 <= 0) {
            PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
            if (poseDetectProcessManager != null) {
                poseDetectProcessManager.clearAll();
            }
            YTPoseDetectJNIInterface.releaseAll();
            mInitModel = 0;
        }
    }

    public static void reset() {
        YTPoseDetectJNIInterface.resetDetect();
    }

    public static void setSafetyLevel(int i3) {
        if (i3 >= 0 && i3 < 3) {
            YTPoseDetectJNIInterface.setSafetyLevel(i3);
        }
    }

    public static int start(Context context, int i3, PoseDetectResult poseDetectResult) {
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.start] ---");
        if (poseDetectResult == null) {
            return -1;
        }
        mCheckResult = poseDetectResult;
        if (mInitModel > 0) {
            mPoseDetectProcessManager.start(context, i3, new PoseDetectResult() { // from class: com.tencent.youtu.ytposedetect.YTPoseDetectInterface.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
                public void onFailed(int i16, String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        YTPoseDetectInterface.noticeFailed(i16, str, str2);
                    } else {
                        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i16), str, str2);
                    }
                }

                @Override // com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult
                public void onSuccess() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        YTPoseDetectInterface.noticeSuccess();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
            return 0;
        }
        noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
        return 0;
    }

    public static void stop() {
        YTPoseDetectJNIInterface.nativeLog(TAG, "[YTPoseDetectInterface.stop] ---");
        PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
        if (poseDetectProcessManager != null) {
            poseDetectProcessManager.stop();
        }
        mIsStarted = false;
    }

    public static YTPoseImage getBestImage(int i3) {
        YTPoseImage yTPoseImage = new YTPoseImage();
        yTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getBestImage();
        if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8) {
            PoseDetectProcessManager poseDetectProcessManager = mPoseDetectProcessManager;
            yTPoseImage.width = poseDetectProcessManager.mDesiredPreviewWidth;
            yTPoseImage.height = poseDetectProcessManager.mDesiredPreviewHeight;
        } else {
            PoseDetectProcessManager poseDetectProcessManager2 = mPoseDetectProcessManager;
            yTPoseImage.width = poseDetectProcessManager2.mDesiredPreviewHeight;
            yTPoseImage.height = poseDetectProcessManager2.mDesiredPreviewWidth;
        }
        return yTPoseImage;
    }
}
