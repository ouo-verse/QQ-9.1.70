package com.tencent.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AbiUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String ARM = "arm";
    public static final String ARM64_V8A = "arm64-v8a";
    public static final String ARMEABI = "armeabi";
    private static final String TAG = "AbiUtil";
    private static Boolean isArm64;
    private static Boolean isArmArch;
    private static String primaryAbi;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        isArmArch = null;
        isArm64 = null;
        primaryAbi = null;
    }

    public AbiUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @VisibleForTesting
    static void clearCache() {
        isArmArch = null;
        isArm64 = null;
        primaryAbi = null;
    }

    public static String getRuntimeCpuAbi(Context context) {
        String str;
        if (!TextUtils.isEmpty(primaryAbi)) {
            return primaryAbi;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            str = (String) declaredField.get(applicationInfo);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getPrimaryCpuAbi] error: ", th5);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.CPU_ABI;
        }
        primaryAbi = str;
        return str;
    }

    @VisibleForTesting
    static int getSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    @SuppressLint({"NewApi"})
    @VisibleForTesting
    static String[] getSupportedAbis() {
        return Build.SUPPORTED_ABIS;
    }

    public static boolean isArm() {
        Boolean bool = isArmArch;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (getSdkInt() >= 21) {
            try {
                String[] supportedAbis = getSupportedAbis();
                if (supportedAbis != null && supportedAbis.length > 0) {
                    for (String str : supportedAbis) {
                        if (str.contains(ARM)) {
                            isArmArch = Boolean.TRUE;
                            return true;
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[isArm] error: ", e16);
            }
        } else {
            try {
                String str2 = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI);
                if (!TextUtils.isEmpty(str2)) {
                    Boolean valueOf = Boolean.valueOf(str2.contains(ARM));
                    isArmArch = valueOf;
                    return valueOf.booleanValue();
                }
            } catch (Exception e17) {
                QLog.e(TAG, 1, "[isArm] error: ", e17);
            }
        }
        isArmArch = Boolean.FALSE;
        return false;
    }

    @SuppressLint({"NewApi"})
    public static boolean isArm64Runtime(Context context) {
        if (!isArm()) {
            return false;
        }
        Boolean bool = isArm64;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context != null) {
            String runtimeCpuAbi = getRuntimeCpuAbi(context);
            if (!TextUtils.isEmpty(runtimeCpuAbi)) {
                Boolean valueOf = Boolean.valueOf(runtimeCpuAbi.equals("arm64-v8a"));
                isArm64 = valueOf;
                return valueOf.booleanValue();
            }
        }
        if (getSdkInt() < 21) {
            isArm64 = Boolean.FALSE;
            return false;
        }
        if (getSdkInt() >= 23) {
            Boolean valueOf2 = Boolean.valueOf(Process.is64Bit());
            isArm64 = valueOf2;
            return valueOf2.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Object invoke = cls.getMethod("getRuntime", new Class[0]).invoke(null, null);
            Method declaredMethod = cls.getDeclaredMethod("is64Bit", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke2 = declaredMethod.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                Boolean bool2 = (Boolean) invoke2;
                isArm64 = bool2;
                return bool2.booleanValue();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[isArm64Runtime] error: ", th5);
        }
        Boolean valueOf3 = Boolean.valueOf("arm64-v8a".equals(Build.CPU_ABI));
        isArm64 = valueOf3;
        return valueOf3.booleanValue();
    }
}
