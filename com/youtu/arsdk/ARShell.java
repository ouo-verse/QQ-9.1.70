package com.youtu.arsdk;

import android.content.Context;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.k;
import com.tencent.mobileqq.ar.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import w81.b;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ARShell {
    public static final int ERROR_LOST_TARGET = 3;
    public static final int ERROR_OK = 0;
    public static final int ERROR_TARGET_EMPTY = 4;
    public static final int ERROR_TARGET_RECOGNIZED = 1;
    public static final int ERROR_TARGET_TRACKED = 2;
    public static final int ERROR_TRAINING_DATA_LOAD_FAILED = -1001;
    private static volatile boolean loadARCoreSoSuccess = false;
    private static volatile boolean loadARFeatureSoSuccess = false;
    private static boolean loadSoSuccess = false;
    private static boolean soLoaded = false;

    public static boolean getARCoreSoHasLoadSuccess() {
        return loadARCoreSoSuccess;
    }

    public static String getCommonSoFilename() {
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.AE_RES_BASE_PACKAGE) + "libYTCommon.so";
    }

    public static native int getMarkerCount();

    public static native int getMarkerInfo(long j3, ARPatternInfo aRPatternInfo);

    public static native void getPatternSizeById(int i3, float[] fArr);

    public static native void getProjectionMatrix(float f16, float f17, float[] fArr, boolean z16);

    public static native String getSDKVersion();

    public static synchronized boolean loadARFeatureNativeLibrary() {
        synchronized (ARShell.class) {
            if (QLog.isColorLevel()) {
                QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary");
            }
            boolean z16 = true;
            if (loadARFeatureSoSuccess) {
                return true;
            }
            if (!k.b()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ARShell", 2, "native so is not exist!");
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary soLoaded=" + soLoaded);
            }
            loadARFeatureSoSuccess = true;
            try {
                int c16 = k.c("libARFeature");
                if (c16 != 0) {
                    z16 = false;
                }
                loadARFeatureSoSuccess = z16;
                if (QLog.isColorLevel()) {
                    QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary ret1=" + c16);
                }
            } catch (Throwable th5) {
                loadARFeatureSoSuccess = false;
                if (QLog.isColorLevel()) {
                    QLog.e("ARShell", 2, "loadARFeatureNativeLibrary", th5);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARShell", 2, "isArEnable, loadARFeatureNativeLibrary loadSoSuccess=" + loadARFeatureSoSuccess);
            }
            return loadARFeatureSoSuccess;
        }
    }

    public static synchronized boolean loadArCoreNativeLibrary() {
        synchronized (ARShell.class) {
            if (QLog.isColorLevel()) {
                QLog.d("ARShell", 2, "isArCoreEnable, loadArCoreNativeLibrary " + loadARCoreSoSuccess);
            }
            if (loadARCoreSoSuccess) {
                return true;
            }
            b.a();
            loadARCoreSoSuccess = false;
            return loadARCoreSoSuccess;
        }
    }

    public static synchronized boolean loadNativeLibrary() {
        synchronized (ARShell.class) {
            if (!n.d("libAlphaAR")) {
                if (QLog.isColorLevel()) {
                    QLog.d("ARShell", 2, "loadNativeLibrary failed. native so is not exist!");
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARShell", 2, "loadNativeLibrary soLoaded=" + soLoaded);
            }
            boolean z16 = true;
            soLoaded = true;
            try {
                System.loadLibrary(SoLoadConstants.SONAME_YTCOMMON);
                int e16 = n.e("libAlphaAR");
                if (e16 != 0) {
                    z16 = false;
                }
                loadSoSuccess = z16;
                if (QLog.isColorLevel()) {
                    QLog.d("ARShell", 2, "loadNativeLibrary ret1=" + e16);
                }
            } catch (UnsatisfiedLinkError e17) {
                loadSoSuccess = false;
                if (QLog.isColorLevel()) {
                    QLog.e("ARShell", 2, "loadNativeLibrary", e17);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARShell", 2, "loadNativeLibrary loadSoSuccess=" + loadSoSuccess);
            }
            return loadSoSuccess;
        }
    }

    private static boolean loadSo() {
        soLoaded = true;
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        String str = baseApplicationImpl.getApplicationInfo().nativeLibraryDir + "/";
        String str2 = str + "libAlphaAR.so";
        String str3 = baseApplicationImpl.getFilesDir() + "libAlphaAR.so";
        if (!new File(str2).exists()) {
            if (!new File(str3).exists()) {
                str2 = "";
            } else {
                str2 = str3;
            }
        }
        String str4 = str + "libYTCommon.so";
        String str5 = baseApplicationImpl.getFilesDir() + "libYTCommon.so";
        if (!new File(str4).exists()) {
            if (!new File(str5).exists()) {
                str4 = "";
            } else {
                str4 = str5;
            }
        }
        if (!str2.equals("") && !str4.equals("")) {
            try {
                System.load(str4);
                System.load(str2);
                QLog.i("ARShell", 1, "load " + str2 + " successfully!");
                QLog.i("ARShell", 1, "load " + str4 + " successfully!");
                loadSoSuccess = true;
                return true;
            } catch (UnsatisfiedLinkError e16) {
                QLog.i("ARShell", 1, "load " + str2 + " failed!" + e16.getMessage());
                QLog.i("ARShell", 1, "load " + str4 + " failed!" + e16.getMessage());
            }
        }
        QLog.i("ARShell", 1, "load " + str2 + " failed!");
        QLog.i("ARShell", 1, "load " + str4 + " failed!");
        loadSoSuccess = false;
        return false;
    }

    public static native int nativeAddMarker(String str, String str2);

    public static native int nativeAddMarkers(String[] strArr, String[] strArr2);

    public static native boolean nativeCreate(Context context);

    public static native boolean nativeDestroy();

    public static native long[] nativeGetMarkerIndice();

    public static native int nativeGetScore(byte[] bArr);

    public static native int nativeInitialize(AROption aROption);

    public static native int nativeRecognize(byte[] bArr, ARTargetInfo[] aRTargetInfoArr);

    public static native boolean nativeStart();

    public static native boolean nativeStop();

    public static native int nativeTrack(byte[] bArr, ARTargetInfo[] aRTargetInfoArr);

    public static native int removeAllMarkers();

    public static native int removeMarker(long j3);
}
