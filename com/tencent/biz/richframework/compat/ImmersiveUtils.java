package com.tencent.biz.richframework.compat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.reflect.Field;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public class ImmersiveUtils {
    public static String TAG = "ImmersiveUtils";
    private static float density = -1.0f;
    public static boolean enableStatusBarDarkModeForMIUI = false;
    public static int i_support_immersive = -1;
    public static boolean isStatusNotChange = false;
    private static int screenHeight = -1;
    private static int screenWidth = -1;
    public static int statusHeight = -1;

    static {
        String str = Build.MANUFACTURER + "-" + DeviceInfoMonitor.getModel();
        if (str.equalsIgnoreCase("smartisan-sm705")) {
            isStatusNotChange = true;
        }
        if (str.equalsIgnoreCase("vivo-vivo Y35A")) {
            isStatusNotChange = true;
        }
        enableStatusBarDarkModeForMIUI = true;
    }

    private static void checkImmersiveStatusBar(Window window) {
        try {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, e16);
        }
    }

    public static void clearCoverForStatus(Window window, boolean z16) {
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            String str = Build.MANUFACTURER;
            sb5.append(str);
            sb5.append(DeviceInfoMonitor.getModel());
            String sb6 = sb5.toString();
            if (RFWLog.isColorLevel()) {
                RFWLog.i(TAG, RFWLog.CLR, "MANUFACTURER = " + str + ", MODEL = " + DeviceInfoMonitor.getModel());
            }
            if (sb6 != null && (sb6.equals("MeizuPRO 7-S") || sb6.equalsIgnoreCase("MeizuM711C"))) {
                setTranslucentStatus(window);
            } else {
                checkImmersiveStatusBar(window);
            }
        }
    }

    @TargetApi(23)
    private static void compatHighMIUI(Window window, boolean z16) {
        View decorView = window.getDecorView();
        if (z16) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 8192);
        } else {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        }
    }

    public static int dpToPx(float f16) {
        return Math.round(f16 * getDensity());
    }

    public static float getDensity() {
        init();
        return density;
    }

    public static int getScreenHeight() {
        init();
        return screenHeight;
    }

    public static int getScreenWidth() {
        init();
        return screenWidth;
    }

    public static int getStatusBarHeight() {
        return getStatusBarHeight(RFWApplication.getApplication());
    }

    private static void init() {
        if (density == -1.0f) {
            DisplayMetrics displayMetrics = RFWApplication.getApplication().getResources().getDisplayMetrics();
            density = displayMetrics.density;
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            if (i3 < i16) {
                screenWidth = i3;
                screenHeight = i16;
            } else {
                screenHeight = i3;
                screenWidth = i16;
            }
        }
    }

    public static int isSupporImmersive() {
        int i3 = i_support_immersive;
        if (i3 != -1) {
            return i3;
        }
        String upperCase = Build.MANUFACTURER.toUpperCase();
        String str = upperCase + "-" + DeviceInfoMonitor.getModel();
        if (!upperCase.endsWith("BBK")) {
            upperCase.endsWith("VIVO");
        }
        if (str.equals("OPPO-3007")) {
            i_support_immersive = 0;
        } else {
            i_support_immersive = 1;
        }
        return i_support_immersive;
    }

    private static boolean processMIUI(Window window, boolean z16) {
        compatHighMIUI(window, z16);
        return true;
    }

    public static int pxToDp(float f16) {
        return Math.round(f16 / getDensity());
    }

    private static boolean setStatusBarDarkModeForFlyme(Window window, boolean z16) {
        int i3;
        int i16;
        boolean z17 = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i17 = declaredField.getInt(null);
                int i18 = declaredField2.getInt(attributes);
                if (z16) {
                    i16 = i17 | i18;
                } else {
                    i16 = (~i17) & i18;
                }
                declaredField2.setInt(attributes, i16);
                window.setAttributes(attributes);
                z17 = true;
            } catch (Exception unused) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.e(TAG, RFWLog.CLR, "setStatusBarDarkModeForFlyme: failed");
                }
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z16) {
                    i3 = systemUiVisibility | 8192;
                } else {
                    i3 = systemUiVisibility & (-8193);
                }
                if (i3 != systemUiVisibility) {
                    decorView.setSystemUiVisibility(i3);
                }
            }
        }
        return z17;
    }

    public static boolean setStatusTextColor(boolean z16, Window window) {
        if (RFWOSUtils.isFlymeOS()) {
            return setStatusBarDarkModeForFlyme(window, z16);
        }
        if (RFWOSUtils.isMIUI()) {
            return processMIUI(window, z16);
        }
        if (z16) {
            setSystemUiVisibilityUsedOr(window, 9216);
        } else {
            setSystemUiVisibilityUsedOr(window, 1280);
        }
        return true;
    }

    public static void setSystemUiVisibilityUsedOr(Window window, int i3) {
        int systemUiVisibility;
        int systemUiVisibility2;
        if (window != null && (systemUiVisibility2 = i3 | (systemUiVisibility = window.getDecorView().getSystemUiVisibility())) != systemUiVisibility) {
            window.getDecorView().setSystemUiVisibility(systemUiVisibility2);
        }
    }

    public static void setTranslucentStatus(Window window) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
                declaredField.setAccessible(true);
                declaredField.setInt(window.getDecorView(), 0);
            } catch (Exception unused) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i(TAG, RFWLog.CLR, "\u53cd\u5c04\u4fee\u6539\u72b6\u6001\u680f\u989c\u8272\u5931\u8d25");
                }
            }
        }
    }

    public static void trySetImmersiveStatusBar(Window window) {
        window.clearFlags(67108864);
        setSystemUiVisibilityUsedOr(window, 1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    @Deprecated
    public static int getStatusBarHeight(Context context) {
        int ceil;
        if (statusHeight == -1) {
            if (context == null || ((context instanceof ContextWrapper) && ((ContextWrapper) context).getBaseContext() == null)) {
                context = RFWApplication.getApplication();
            }
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
            float density2 = DisplayUtil.getDensity();
            if (RFWLog.isColorLevel()) {
                RFWLog.d("systembar", RFWLog.CLR, "getStatusBarHeight org=" + dimensionPixelSize + ", sys density=" + density2 + ", cur density=" + context.getResources().getDisplayMetrics().density);
            }
            float f16 = density2 / context.getResources().getDisplayMetrics().density;
            if (dimensionPixelSize <= 0) {
                if (f16 <= 0.0f) {
                    f16 = 1.0f;
                }
                ceil = dpToPx(f16 * 25.0f);
            } else {
                float f17 = dimensionPixelSize;
                if (f16 <= 0.0f) {
                    f16 = 1.0f;
                }
                ceil = (int) Math.ceil((f17 * f16) + 0.5f);
            }
            statusHeight = ceil;
            if (RFWLog.isColorLevel()) {
                RFWLog.i("systembar", RFWLog.CLR, "height=" + statusHeight);
            }
        }
        return statusHeight;
    }
}
