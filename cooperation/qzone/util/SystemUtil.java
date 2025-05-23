package cooperation.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SystemUtil {
    private static final String ISMIUI = "1";
    public static final int OPPO_NOTCH_HEIGHT = 80;
    public static final int SHARP_NOTCH_HEIGHT = 121;
    public static final String TAG = "[PhotoAlbum]" + SystemUtil.class.getSimpleName();
    public static final int VIVO_NOTCH_HEIGHT = dp2px(27);
    public static int notchHeight = -1;

    public static int dp2px(int i3) {
        return (int) ((i3 * BaseApplication.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Rect getDisplayCutoutSafeInsets(View view) {
        Object callSpecifiedMethod;
        Rect rect = new Rect();
        String str = TAG;
        QZLog.d(str, 1, "Build.VERSION.SDK_INT:", Integer.valueOf(Build.VERSION.SDK_INT));
        try {
            Object callSpecifiedMethod2 = JarReflectUtil.callSpecifiedMethod(view, "getRootWindowInsets", false, null, null);
            QZLog.d(str, 1, "insets:", callSpecifiedMethod2);
            callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod2, "getDisplayCutout", false, null, null);
        } catch (Exception e16) {
            QZLog.e(TAG, 1, e16, new Object[0]);
        }
        if (callSpecifiedMethod == null) {
            QZLog.d(str, 1, "displayCutout == null");
            return rect;
        }
        Object callSpecifiedMethod3 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetTop", false, null, null);
        Object callSpecifiedMethod4 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetBottom", false, null, null);
        Object callSpecifiedMethod5 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetLeft", false, null, null);
        Object callSpecifiedMethod6 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetRight", false, null, null);
        QZLog.d(str, 1, "safeInsetTop:", callSpecifiedMethod3, " safeInsetBottom:", callSpecifiedMethod4, " safeInsetLeft:", callSpecifiedMethod5, " safeInsetRight:", callSpecifiedMethod6);
        if (callSpecifiedMethod5 instanceof Integer) {
            rect.left = ((Integer) callSpecifiedMethod5).intValue();
        }
        if (callSpecifiedMethod4 instanceof Integer) {
            rect.bottom = ((Integer) callSpecifiedMethod4).intValue();
        }
        if (callSpecifiedMethod6 instanceof Integer) {
            rect.right = ((Integer) callSpecifiedMethod6).intValue();
        }
        if (callSpecifiedMethod3 instanceof Integer) {
            rect.top = ((Integer) callSpecifiedMethod3).intValue();
            return rect;
        }
        return rect;
    }

    private static void getGoogleApi(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            notchHeight = getDisplayCutoutSafeInsets(activity.getWindow().getDecorView()).top;
        }
    }

    public static int getNotchHeight(Context context, Activity activity) {
        int i3 = notchHeight;
        if (i3 != -1) {
            QZLog.d(TAG, 1, "has notchHeight:", Integer.valueOf(i3));
            return notchHeight;
        }
        QZLog.d(TAG, 1, "Build.MODEL:", DeviceInfoMonitor.getModel());
        if (hasNotchInVivo(context)) {
            notchHeight = VIVO_NOTCH_HEIGHT;
        } else if (hasNotchInOppo(context)) {
            if (Build.VERSION.SDK_INT >= 28) {
                getGoogleApi(activity);
            }
            int i16 = notchHeight;
            if (i16 == 0 || i16 == -1) {
                notchHeight = 80;
            }
        } else if (hasNotchInHuaWei(context)) {
            notchHeight = getNotchSizeInHuaWei(context)[1];
        } else if (!hasNotchInXiaoMi(context) && !hasNotchInSmartisan(context) && !isSpecialDevices()) {
            if (isSharpS2()) {
                notchHeight = 121;
            } else if (isVivoSpecial()) {
                notchHeight = getNotchSizeInStatusBar(context) + dp2px(20);
            } else if (isSamsungSpecial()) {
                notchHeight = getNotchSizeInStatusBar(context) + dp2px(10);
            } else {
                getGoogleApi(activity);
            }
        } else {
            notchHeight = getNotchSizeInStatusBar(context);
        }
        return notchHeight;
    }

    public static int[] getNotchSizeInHuaWei(Context context) {
        int[] iArr = {0, 0};
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            } catch (ClassNotFoundException unused) {
                QZLog.e(TAG, "getNotchSize ClassNotFoundException");
                return iArr;
            } catch (NoSuchMethodException unused2) {
                QZLog.e(TAG, "getNotchSize NoSuchMethodException");
                return iArr;
            } catch (Exception unused3) {
                QZLog.e(TAG, "getNotchSize Exception");
                return iArr;
            }
        } catch (Throwable unused4) {
            return iArr;
        }
    }

    private static int getNotchSizeInStatusBar(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getReflectString(Context context, String str, String str2) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (String) loadClass.getMethod("get", String.class, String.class).invoke(loadClass, new String(str), new String(str2));
        } catch (IllegalArgumentException | Exception unused) {
            return str2;
        }
    }

    public static boolean hasNotchInHuaWei(Context context) {
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
                } catch (ClassNotFoundException unused) {
                    QZLog.e(TAG, "hasNotchInScreen ClassNotFoundException");
                    return false;
                } catch (NoSuchMethodException unused2) {
                    QZLog.e(TAG, "hasNotchInScreen NoSuchMethodException");
                    return false;
                }
            } catch (Exception unused3) {
                QZLog.e(TAG, "hasNotchInScreen Exception");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    public static boolean hasNotchInOppo(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInSmartisan(Context context) {
        try {
            Object callSpecifiedStaticMethod = JarReflectUtil.callSpecifiedStaticMethod("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", false, XMPCoreUtil.getInstance().getParamsClass(Integer.TYPE), 1);
            if (!(callSpecifiedStaticMethod instanceof Boolean)) {
                return false;
            }
            return ((Boolean) callSpecifiedStaticMethod).booleanValue();
        } catch (Exception e16) {
            QZLog.e(TAG, 2, e16, new Object[0]);
            return false;
        }
    }

    public static boolean hasNotchInVivo(Context context) {
        try {
            Object callSpecifiedStaticMethod = JarReflectUtil.callSpecifiedStaticMethod("android.util.FtFeature", "isFeatureSupport", false, XMPCoreUtil.getInstance().getParamsClass(Integer.TYPE), 32);
            if (!(callSpecifiedStaticMethod instanceof Boolean)) {
                return false;
            }
            return ((Boolean) callSpecifiedStaticMethod).booleanValue();
        } catch (Exception e16) {
            QZLog.e(TAG, 2, e16, new Object[0]);
            return false;
        }
    }

    public static boolean hasNotchInXiaoMi(Context context) {
        String reflectString = getReflectString(context, "ro.miui.notch", "0");
        if (reflectString != null) {
            return reflectString.equals("1");
        }
        return false;
    }

    private static boolean isLenovo() {
        return DeviceInfoMonitor.getModel().endsWith("L78011");
    }

    private static boolean isOnePlus() {
        return "GM1910".equals(DeviceInfoMonitor.getModel());
    }

    private static boolean isSMF9000() {
        return "SM-F9000".equals(DeviceInfoMonitor.getModel());
    }

    private static boolean isSamsungSpecial() {
        if (DeviceInfoMonitor.getModel() == null) {
            return false;
        }
        if (!DeviceInfoMonitor.getModel().equals("SM-G9750") && !DeviceInfoMonitor.getModel().equals("SM-G9810")) {
            return false;
        }
        return true;
    }

    private static boolean isSharpS2() {
        return "FS8010".equals(DeviceInfoMonitor.getModel());
    }

    private static boolean isSpecialDevices() {
        if (!isLenovo() && !isOnePlus() && !isSMF9000() && !"Pixel 3 XL".equals(DeviceInfoMonitor.getModel()) && !"NX606J".equals(DeviceInfoMonitor.getModel())) {
            return false;
        }
        return true;
    }

    private static boolean isVivoSpecial() {
        if (DeviceInfoMonitor.getModel() == null) {
            return false;
        }
        if (!DeviceInfoMonitor.getModel().equals("V1938CT") && !DeviceInfoMonitor.getModel().equals("V2001A")) {
            return false;
        }
        return true;
    }
}
