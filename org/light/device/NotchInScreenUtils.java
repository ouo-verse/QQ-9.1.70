package org.light.device;

import android.app.Activity;
import android.content.Context;
import android.os.SystemProperties;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.light.device.LightDeviceProperty;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NotchInScreenUtils {
    public static final int NOTCH_IN_SCREEN_VIVO = 32;
    public static final int ROUNDED_IN_SCREEN_VIVO = 8;

    public static int getNotchHeightHw(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            iArr = (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException e16) {
            LightLogUtil.e(e16);
        } catch (NoSuchMethodException e17) {
            LightLogUtil.e(e17);
        } catch (Exception e18) {
            LightLogUtil.e(e18);
        }
        return iArr[1];
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getSystemProperties(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, str);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return "";
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return "";
        } catch (IllegalArgumentException e18) {
            e18.printStackTrace();
            return "";
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
            return "";
        } catch (InvocationTargetException e26) {
            e26.printStackTrace();
            return "";
        }
    }

    public static boolean hasNotchInScreen(Context context) {
        boolean z16;
        boolean z17 = false;
        if (!hasNotchInScreenHw(context) && !hasNotchInScreenAtOppo(context) && !hasNotchInScreenAtVivo(context) && !hasNotchInScreenAtXM()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (LightDeviceProperty.VERSION.SDK_INT >= 28) {
            if (z16 || hasNotchInScreenForP(context)) {
                z17 = true;
            }
            return z17;
        }
        return z16;
    }

    public static boolean hasNotchInScreenAtOppo(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInScreenAtVivo(Context context) {
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.util.FtFeature");
                    return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
                } catch (ClassNotFoundException e16) {
                    LightLogUtil.e(e16);
                    return false;
                } catch (Exception e17) {
                    LightLogUtil.e(e17);
                    return false;
                }
            } catch (NoSuchMethodException e18) {
                LightLogUtil.e(e18);
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchInScreenAtXM() {
        return "1".equals(getSystemProperties("ro.miui.notch"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        r2 = r2.getDisplayCutout();
     */
    @RequiresApi(api = 28)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean hasNotchInScreenForP(Context context) {
        DisplayCutout displayCutout;
        List boundingRects;
        if ((context instanceof Activity) && (r2 = ((Activity) context).getWindow().getDecorView().getRootWindowInsets()) != null && displayCutout != null) {
            boundingRects = displayCutout.getBoundingRects();
            if (boundingRects == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean hasNotchInScreenHw(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e16) {
            LightLogUtil.e(e16);
            return false;
        } catch (NoSuchMethodException e17) {
            LightLogUtil.e(e17);
            return false;
        } catch (Exception e18) {
            LightLogUtil.e(e18);
            return false;
        }
    }

    public static void setSystemProperties(String str, String str2) {
        try {
            SystemProperties.class.getMethod("set", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (IllegalArgumentException e18) {
            e18.printStackTrace();
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
        } catch (InvocationTargetException e26) {
            e26.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r3 = r3.getDisplayCutout();
     */
    @RequiresApi(api = 28)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getNotchHeightForP(Window window) {
        DisplayCutout displayCutout;
        List boundingRects;
        int safeInsetTop;
        WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        if (rootWindowInsets != null && displayCutout != null) {
            boundingRects = displayCutout.getBoundingRects();
            if (boundingRects != null) {
                safeInsetTop = displayCutout.getSafeInsetTop();
                return safeInsetTop;
            }
        }
        return 0;
    }
}
