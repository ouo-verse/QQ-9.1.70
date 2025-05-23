package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTAGReflectLiveCheckJNIInterface {
    static IPatchRedirector $redirector_ = null;
    public static int TIME_REGULATION_LOOSE = 1;
    public static int TIME_REGULATION_STRICT = 0;
    public static int compressReflectionImageScore = 95;
    private static YTAGReflectLiveCheckJNIInterface instance;
    private static Lock instanceLock;
    private static IYtLoggerListener loggerListener;
    private long FRnativePtr;
    public Context context;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19906);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            instanceLock = new ReentrantLock();
        }
    }

    YTAGReflectLiveCheckJNIInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.context = null;
            FRNativeConstructor();
        }
    }

    public static native String FRGenConfigData(int i3, String str);

    public static native String FRVersion();

    public static native void SetActStr(String str);

    public static native void SetPipelineVersion(String str);

    public static synchronized void clearInstance() {
        synchronized (YTAGReflectLiveCheckJNIInterface.class) {
            try {
                instanceLock.lock();
                YTAGReflectLiveCheckJNIInterface yTAGReflectLiveCheckJNIInterface = instance;
                if (yTAGReflectLiveCheckJNIInterface != null) {
                    yTAGReflectLiveCheckJNIInterface.FRNativeDestructor();
                    instance = null;
                }
            } finally {
                instanceLock.unlock();
            }
        }
    }

    public static void compressTest(Bitmap bitmap, int i3) {
        try {
            File file = new File("/sdcard/reflect/");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = "/sdcard/reflect/" + i3 + "/";
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str, "mytestInJava_" + System.currentTimeMillis() + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static native void configNativeLog(boolean z16);

    public static byte[] encodeJpeg(Bitmap bitmap, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, compressReflectionImageScore, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static synchronized YTAGReflectLiveCheckJNIInterface getInstance() {
        YTAGReflectLiveCheckJNIInterface yTAGReflectLiveCheckJNIInterface;
        synchronized (YTAGReflectLiveCheckJNIInterface.class) {
            try {
                instanceLock.lock();
                if (instance == null) {
                    instance = new YTAGReflectLiveCheckJNIInterface();
                }
                instanceLock.unlock();
                yTAGReflectLiveCheckJNIInterface = instance;
            } catch (Throwable th5) {
                instanceLock.unlock();
                throw th5;
            }
        }
        return yTAGReflectLiveCheckJNIInterface;
    }

    public static String modelVersion() {
        return "";
    }

    public static void nativeLog(String str, String str2) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log(str, str2);
        }
    }

    public static String sdkVersion() {
        return "";
    }

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static native int updateParam(String str, String str2);

    public native int FRDoDetectionYuvs(boolean z16, int i3);

    public native FullPack FRGetAGin();

    public native int FRGetChangePoint();

    public native int FRGetConfigBegin();

    public native int FRGetConfigEnd();

    public native int FRGetISOCaptureTimeVecSize();

    public native double FRGetISObackup();

    public native int FRGetISOchangeFrame();

    public native double FRGetISOmin();

    public native int FRGetTriggerTime();

    public native int FRInit(boolean z16, String str, int i3, long[] jArr, float f16);

    public native void FRNativeConstructor();

    public native void FRNativeDestructor();

    public native void FRPushCaptureTime(Timeval timeval);

    public native void FRPushISOCaptureTime(Timeval timeval);

    public native void FRPushISOImgYuv(byte[] bArr, int i3, int i16);

    public native void FRPushYuv(byte[] bArr, int i3, int i16, Timeval timeval, int i17, float[] fArr);

    public native int FRRelease();

    public native void FRSetBegin(Timeval timeval);

    public native void FRSetChangePointTime(Timeval timeval);

    public native void FRSetDoingDelayCalc(boolean z16);

    public native void FRSetEnd(Timeval timeval);

    public native void FRSetISObackup(double d16);

    public native void FRSetISOchangeFrame(int i3);

    public native void FRSetISOchangeTime(Timeval timeval);

    public static void nativeLog(int i3, String str) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log("[YTAGReflectLiveCheckJNIInterface.nativeLog]", str);
        }
    }

    public static byte[] encodeJpeg(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 99, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
