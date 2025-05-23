package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.io.File;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Auth {
    static IPatchRedirector $redirector_ = null;
    private static final String LIC_FILE_NAME = ".youtu_common.lic";
    private static final String TAG = "youtu-common";
    private static long handle;
    private static String licensePath;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12009);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            handle = 0L;
            licensePath = "";
        }
    }

    public Auth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean check() {
        boolean nativeCheck = nativeCheck(handle);
        Log.d("sdk", "--------------check");
        return nativeCheck;
    }

    public static int getAuthResult() {
        long j3 = handle;
        if (j3 != 0) {
            return getCurrentAuthStatus(j3);
        }
        Log.w("sdk", "you should call YTCommonInterface.initAuth() first");
        return -1;
    }

    private static native int getCurrentAuthStatus(long j3);

    public static long getEndTime() {
        return nativeGetEndTime(handle);
    }

    public static native String getFailedReason(int i3);

    public static long getHandle() {
        return handle;
    }

    public static String getLicensePath() {
        return licensePath;
    }

    public static int getVersion() {
        return nativeGetVersion();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (new java.io.File(r11).exists() == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int init(Context context, String str, int i3) {
        YTLog.d(TAG, "start init");
        boolean z16 = Build.VERSION.SDK_INT < 29 && context.checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0;
        try {
            if (i3 == 0) {
                InputStream open = context.getAssets().open(str, 0);
                if (open == null) {
                    return -10;
                }
                open.close();
            } else {
                if (i3 == 2) {
                }
                handle = nativeInitN(context, i3, str, context.getAssets(), str, z16);
                YTLog.d(TAG, "handleinit: " + handle);
                return getCurrentAuthStatus(handle);
            }
            handle = nativeInitN(context, i3, str, context.getAssets(), str, z16);
            YTLog.d(TAG, "handleinit: " + handle);
            return getCurrentAuthStatus(handle);
        } catch (Exception unused) {
        }
        return -10;
    }

    public static int initAuthForQQ(Context context) {
        boolean z16;
        YTLog.d(TAG, "start init");
        if (Build.VERSION.SDK_INT >= 29 || context.checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        handle = nativeInitN(context, 1, "oWxLt1xJmA2/uaL5b3J2OoXQuppLT0Su2szcfjfKvPiuDF40cJoVL+9UUfHwStdYs6QEDV1cYTR4i/S2HAQurX+asnVcb4AW+O5XfqUMBdN/mrJ1XG+AFhqs/yTHjNBNvmckDgBPCL/vrpjjD7plQjxYvUs2iVQEbpBaXarIXV08WL1LNolUBFs8CRb9zOHrZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHeJyPkwbK322b8YymrUh2ls8g0VH/nH5kDsvY1CWKAle+ZyQOAE8Ivxo3SsZQSeHUmh3cVajW+kOm9qMOF5WIwIGnICZWiBx8PFi9SzaJVASDGTlJVChdTmfCCgpLkdLXRcwQnvqHFVXxZYDjK9TEFo/OQptjkTvwTmOwMbacnJ0E8l3uYLZ8IKQkrbUL8A/NpZ32SXyB4MqSA6oIJS7ygp1o8RUPT2hPw7ViurRuxSLDtWK6tG7FIsO1Yrq0bsUiLYiW0fpoPV0vMxAmJlT9Hi8zECYmVP0eLzMQJiZU/R7iHhNgzhesl4rkPMbKDg0m/0tvBQ5nJ5w1WHaXQvj4Iw==", context.getAssets(), "oWxLt1xJmA2/uaL5b3J2OoXQuppLT0Su2szcfjfKvPiuDF40cJoVL+9UUfHwStdYs6QEDV1cYTR4i/S2HAQurX+asnVcb4AW+O5XfqUMBdN/mrJ1XG+AFhqs/yTHjNBNvmckDgBPCL/vrpjjD7plQjxYvUs2iVQEbpBaXarIXV08WL1LNolUBFs8CRb9zOHrZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHZJQ6DQN60oe+XZVkgYkU63CUs7duFYmHeJyPkwbK322b8YymrUh2ls8g0VH/nH5kDsvY1CWKAle+ZyQOAE8Ivxo3SsZQSeHUmh3cVajW+kOm9qMOF5WIwIGnICZWiBx8PFi9SzaJVASDGTlJVChdTmfCCgpLkdLXRcwQnvqHFVXxZYDjK9TEFo/OQptjkTvwTmOwMbacnJ0E8l3uYLZ8IKQkrbUL8A/NpZ32SXyB4MqSA6oIJS7ygp1o8RUPT2hPw7ViurRuxSLDtWK6tG7FIsO1Yrq0bsUiLYiW0fpoPV0vMxAmJlT9Hi8zECYmVP0eLzMQJiZU/R7iHhNgzhesl4rkPMbKDg0m/0tvBQ5nJ5w1WHaXQvj4Iw==", z16);
        YTLog.d(TAG, "handleinit: " + handle);
        return getCurrentAuthStatus(handle);
    }

    private static native boolean nativeCheck(long j3);

    private static native long nativeGetEndTime(long j3);

    private static native long nativeGetLicense(Context context, String str, String str2, String str3, int i3, boolean z16, String str4);

    private static native int nativeGetVersion();

    private static native long nativeInitN(Context context, int i3, String str, AssetManager assetManager, String str2, boolean z16);

    private static native int nativeSetSerial(String str);

    public static void setLicensePath(String str) {
        licensePath = str;
    }

    public static int init(Context context, String str, String str2, int i3, String str3) {
        if (licensePath.isEmpty()) {
            licensePath = context.getFilesDir().getPath() + File.separator + LIC_FILE_NAME;
        } else if (context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            Log.e(TAG, "WRITE_EXTERNAL_STORAGE permission required.");
            return 2004;
        }
        boolean z16 = false;
        if (Build.VERSION.SDK_INT < 29 && context.checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0) {
            z16 = true;
        }
        int nativeGetLicense = (int) nativeGetLicense(context, str, str2, getLicensePath(), i3, z16, str3);
        if (nativeGetLicense != 0) {
            return nativeGetLicense;
        }
        long nativeInitN = nativeInitN(context, 2, getLicensePath(), context.getAssets(), getLicensePath(), z16);
        handle = nativeInitN;
        if (getCurrentAuthStatus(nativeInitN) != 0) {
            int nativeGetLicense2 = (int) nativeGetLicense(context, str, str2, getLicensePath(), 1, z16, str3);
            if (nativeGetLicense2 != 0) {
                return nativeGetLicense2;
            }
            long nativeInitN2 = nativeInitN(context, 2, getLicensePath(), context.getAssets(), getLicensePath(), z16);
            handle = nativeInitN2;
            return getCurrentAuthStatus(nativeInitN2);
        }
        return getCurrentAuthStatus(handle);
    }
}
