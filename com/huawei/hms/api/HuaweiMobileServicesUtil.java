package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.AndroidException;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ReadApkFileUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class HuaweiMobileServicesUtil {
    public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";
    private static final int HMS_VERSION_CODE_NOMDM = 20500000;
    private static final String TAG = "HuaweiMobileServicesUtil";

    public static Dialog getErrorDialog(int i3, Activity activity, int i16) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(activity, i3, i16, null);
    }

    public static String getErrorString(int i3) {
        return HuaweiApiAvailability.getInstance().getErrorString(i3);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return "";
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(HMSPackageManager.getInstance(context).getHMSPackageName(), 2);
        } catch (AndroidException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(HMSPackageManager.getInstance(context).getHMSPackageName());
        } catch (AndroidException unused) {
            return null;
        }
    }

    public static int isHuaweiMobileServicesAvailable(Context context, int i3) {
        Checker.checkNonNull(context, "context must not be null.");
        if (HMSPackageManager.getInstance(context).isUseOldCertificate()) {
            HMSLog.e(TAG, "The CP uses the old certificate to terminate the connection.");
            return 13;
        }
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        String hMSPackageNameForMultiService = HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService();
        HMSLog.i(TAG, "hmsPackageName is " + hMSPackageNameForMultiService);
        PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
        PackageManagerHelper.PackageStates packageStates = PackageManagerHelper.PackageStates.NOT_INSTALLED;
        if (packageStates.equals(hMSPackageStatesForMultiService)) {
            HMSLog.i(TAG, "HMS is not installed");
            return 1;
        }
        String hmsPath = ReadApkFileUtil.getHmsPath(context);
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 5 && packageManagerHelper.getPackageVersionCode(hMSPackageNameForMultiService) < HMS_VERSION_CODE_NOMDM && ReadApkFileUtil.isCertFound(hmsPath)) {
            String packageSignature = packageManagerHelper.getPackageSignature(hMSPackageNameForMultiService);
            return ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(packageSignature) || "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature) || "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature)) ? 2 : 9;
        }
        if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
            HMSLog.i(TAG, "HMS is spoofed");
            return 9;
        }
        if (PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
            HMSLog.i(TAG, "HMS is disabled");
            return 3;
        }
        if (packageStates.equals(hMSPackageStatesForMultiService)) {
            String packageSignature2 = packageManagerHelper.getPackageSignature(hMSPackageNameForMultiService);
            if (!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(packageSignature2) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature2) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature2)) {
                return 9;
            }
        }
        HMSLog.i(TAG, "connect versionCode:" + HMSPackageManager.getInstance(context).getHmsMultiServiceVersion());
        if (!HMSPackageManager.getInstance(context).isApkUpdateNecessary(i3)) {
            return 0;
        }
        HMSLog.i(TAG, "The current version does not meet the minimum version requirements");
        return 2;
    }

    public static boolean isUserRecoverableError(int i3) {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(i3);
    }

    public static boolean popupErrDlgFragment(int i3, Activity activity, int i16, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i3, i16, onCancelListener);
    }

    public static void setApplication(Application application) {
        ActivityMgr.INST.init(application);
    }

    public static boolean showErrorDialogFragment(int i3, Activity activity, int i16) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i3, i16, null);
    }

    public static void showErrorNotification(int i3, Context context) {
        HuaweiApiAvailability.getInstance().showErrorNotification(context, i3);
    }

    public static Dialog getErrorDialog(int i3, Activity activity, int i16, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(activity, i3, i16, onCancelListener);
    }

    public static boolean popupErrDlgFragment(int i3, Activity activity, Fragment fragment, int i16, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i3, fragment, i16, onCancelListener);
    }

    public static int isHuaweiMobileServicesAvailable(Context context) {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
    }
}
