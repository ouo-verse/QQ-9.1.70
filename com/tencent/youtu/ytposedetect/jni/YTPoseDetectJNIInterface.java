package com.tencent.youtu.ytposedetect.jni;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytposedetect.data.ActionData;
import com.tencent.youtu.ytposedetect.data.PoseDetectData;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTFaceDistanceDetectData;
import java.io.ByteArrayOutputStream;

/* loaded from: classes27.dex */
public class YTPoseDetectJNIInterface {
    static IPatchRedirector $redirector_ = null;
    public static final int CHECKSUM_BEST = 0;
    public static final int CHECKSUM_EYE = 1;
    public static final int CHECKSUM_MOUTH = 2;
    public static int compressPoseImageScore = 99;
    public static int compressVideoScore = 80;
    private static IYtLoggerListener loggerListener;

    /* loaded from: classes27.dex */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    public YTPoseDetectJNIInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native boolean canReflect();

    public static native void configNativeLog(boolean z16);

    public static byte[] encodeJpeg(Bitmap bitmap, boolean z16) {
        int i3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (z16) {
            i3 = compressPoseImageScore;
        } else {
            i3 = compressVideoScore;
        }
        bitmap.compress(compressFormat, i3, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static native ActionData getActionData();

    public static native YTActRefData getActionReflectData(int i3);

    public static native byte[] getBestImage();

    public static native byte[] getEyeImage(int i3);

    public static native String getFaceDetectDistanceRectParam();

    public static native YTFaceDistanceDetectData getFaceDistanceDetectData();

    public static native float getFar2NearRectChangeScore();

    public static native byte[][] getFrameList();

    public static native byte[] getMouthImage(int i3);

    public static native void getOneActionFrame(int i3, int i16);

    public static native String getVersion();

    public static native void initFaceDistanceDetect(int i3, int i16, int i17, float f16, float f17);

    public static native int initModel(String str);

    public static native boolean isFrameListNull();

    public static native boolean isRecordingDone();

    public static void nativeLog(String str, String str2) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log(str, str2);
        }
    }

    public static native int poseDetect(PoseDetectData poseDetectData);

    public static native void releaseAll();

    public static native void resetDetect();

    public static native void resetQualityContinuousCount();

    public static native void setColorData(String str, String str2, String str3, String str4, String str5);

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static native void setSafetyLevel(int i3);

    public static native int updateParam(String str, String str2);

    public static void nativeLog(int i3, String str) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log("[YTPoseDetectJNIInterface.nativeLog]", str);
        }
    }
}
