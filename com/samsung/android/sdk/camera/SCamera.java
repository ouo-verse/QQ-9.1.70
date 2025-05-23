package com.samsung.android.sdk.camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.samsung.android.sdk.camera.delegator.AbstractSemCamera;
import com.samsung.android.sdk.camera.delegator.SemCamera10_1;
import com.samsung.android.sdk.camera.delegator.SemCamera10_2;
import com.samsung.android.sdk.camera.delegator.SemCameraDefault;
import com.samsung.android.sdk.camera.util.SsdkVendorCheck;
import com.samsung.android.sdk.camera.util.SsdkVersionCheck;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SCamera {
    public static final int AVAILABILITY_SUPPORTED = 0;
    public static final int AVAILABILITY_UNSUPPORTED_DEVICE = 2;
    public static final int AVAILABILITY_UNSUPPORTED_VENDOR = 1;
    private static final String CAMERA_ID_FRONT = "1";
    private static final String CAMERA_ID_REAR = "0";
    private static final String CAMERA_ID_REAR_WIDE = "2";
    public static final int FEATURE_CAPTURE_PROCESSOR = 1;
    private static final String MICRO_VERSION_NAME = "2";
    private static final String SCAMERA_SERVICE_PACKAGE = "com.samsung.android.camerasdkservice";
    static final String SEP_CLIENT_VERSION_1 = "2.0.0";
    static final String SEP_CLIENT_VERSION_2 = "2.0.1";
    static final String SEP_CLIENT_VERSION_3 = "2.0.2";
    static final int SEP_VERSION_10_1 = 100100;
    static final int SEP_VERSION_10_2 = 100200;
    private static final String TAG = "SCamera";
    private static final int VERSION_CODE = 101;
    private static final String VERSION_NAME = "2.0.1";
    private static SCamera mSCamera;
    private Context mContext;
    private AbstractSemCamera mSemCamera = null;

    SCamera() {
        Log.i(TAG, "SCamera SDK version: 2.0.1 mver: 2");
    }

    public static synchronized SCamera getInstance() {
        SCamera sCamera;
        synchronized (SCamera.class) {
            if (mSCamera == null) {
                mSCamera = new SCamera();
            }
            sCamera = mSCamera;
        }
        return sCamera;
    }

    private synchronized AbstractSemCamera getSemCamera() {
        if (this.mSemCamera == null) {
            if (AbstractSemCamera.getSepPlatformVersion(this.mContext) >= 100100) {
                try {
                    String sEPClientVersion = AbstractSemCamera.getSEPClientVersion();
                    Log.i(TAG, "getSemCamera semVersion : " + sEPClientVersion);
                    if (SsdkVersionCheck.compareVersion(sEPClientVersion, "2.0.1") >= 0) {
                        this.mSemCamera = new SemCamera10_2();
                    }
                } catch (Throwable unused) {
                    Log.i(TAG, "getSemCamera semVersion : SEP_VERSION_10_1 in caught Error:");
                    this.mSemCamera = new SemCamera10_1();
                }
            } else {
                this.mSemCamera = new SemCameraDefault();
            }
        }
        Log.i(TAG, "getSemCamera : " + this.mSemCamera);
        return this.mSemCamera;
    }

    private static boolean isNonCompatibleBinary() {
        String str = Build.MANUFACTURER;
        String str2 = Build.DEVICE;
        String str3 = Build.DISPLAY;
        if (str == null || str2 == null || str3 == null) {
            return true;
        }
        if (!str.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) || !str2.toLowerCase().contains("beyond")) {
            return false;
        }
        if (str3.toUpperCase().endsWith("SAT") || str3.toUpperCase().endsWith("SAU")) {
            return true;
        }
        return false;
    }

    private boolean isSDKServiceOnDevice(Context context) {
        try {
            if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), SCAMERA_SERVICE_PACKAGE, 0) == null) {
                Log.d(TAG, "isSDKServiceOnDevice - false");
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d(TAG, "isSDKServiceOnDevice - false");
            return false;
        } catch (NullPointerException unused2) {
            throw new IllegalArgumentException("Context is invalid");
        }
    }

    private boolean isSEPSupported(Context context) {
        int sepPlatformVersion = AbstractSemCamera.getSepPlatformVersion(context);
        Log.i(TAG, " getSeCamera SEP VERSION: " + sepPlatformVersion);
        if (sepPlatformVersion >= 100100) {
            return true;
        }
        return false;
    }

    public int checkAvailability(Context context) {
        if (context != null) {
            if (!SsdkVendorCheck.isSamsungDevice()) {
                return 1;
            }
            if (!isSDKServiceOnDevice(context) || !isSEPSupported(context)) {
                return 2;
            }
            if (isNonCompatibleBinary()) {
                Log.d(TAG, "checkAvailability: isNonCompatibleBinary - true");
                return 2;
            }
            return 0;
        }
        throw new IllegalArgumentException("context cannot be null");
    }

    public int getVersionCode() {
        return 101;
    }

    public String getVersionName() {
        return "2.0.1";
    }

    public boolean isFeatureEnabled(Context context, String str, int i3) {
        if (context != null) {
            if (str != null) {
                this.mContext = context;
                try {
                    getSemCamera();
                } catch (NoSuchMethodError unused) {
                    if (!str.equals("0") && !str.equals("1")) {
                        return false;
                    }
                }
                if (SsdkVersionCheck.compareVersion(AbstractSemCamera.getSEPClientVersion(), "2.0.1") != 1 && !str.equals("0") && !str.equals("1")) {
                    return false;
                }
                getSemCamera();
                if (SsdkVersionCheck.compareVersion(AbstractSemCamera.getSEPClientVersion(), SEP_CLIENT_VERSION_3) == 0) {
                    if (str.equals("2")) {
                        return false;
                    }
                }
                if (checkAvailability(context) != 0) {
                    return false;
                }
                return getSemCamera().isFeatureEnabled(context, str, i3);
            }
            throw new IllegalArgumentException("cameraId cannot be null");
        }
        throw new IllegalArgumentException("context cannot be null");
    }
}
