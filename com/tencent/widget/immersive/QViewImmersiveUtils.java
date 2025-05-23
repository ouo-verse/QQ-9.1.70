package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QViewImmersiveUtils {
    static IPatchRedirector $redirector_ = null;
    public static int FLAG_TRANSLUCENT_STATUS = 0;
    private static final String KEY_STATUS_BAR_HEIGHT = "status_bar_height";
    public static String TAG;
    private static float density;
    public static boolean enableStatusBarDarkModeForMIUI;
    public static int i_support_immersive;
    public static boolean isStatusNotChange;
    public static boolean m_needImmersive;
    private static int screenHeight;
    private static int screenWidth;
    public static int statusHeight;
    public static volatile boolean statusHeightCorrect;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ImmersiveType {
        public static final int support = 1;
        public static final int unInit = -1;
        public static final int unsupport = 0;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        if ("Success".equals(MobileQQ.sInjectResult)) {
            MobileQQ.sImmersiveUtilsEscapedMsg = "";
        } else {
            String str = "sInjectResult:" + MobileQQ.sInjectResult;
            try {
                throw new IllegalAccessError("ImmersiveUtils escapes!");
            } catch (Throwable th5) {
                MobileQQ.sImmersiveUtilsEscapedMsg = str + "\n" + QLog.getStackTraceString(th5);
                QLog.e("DexLoad", 1, "ImmersiveUtils escapes!");
            }
        }
        TAG = com.tencent.qqmini.sdk.utils.ImmersiveUtils.TAG;
        density = -1.0f;
        screenWidth = -1;
        screenHeight = -1;
        i_support_immersive = -1;
        m_needImmersive = true;
        FLAG_TRANSLUCENT_STATUS = 67108864;
        isStatusNotChange = false;
        statusHeight = -1;
        String str2 = Build.MANUFACTURER + "-" + DeviceInfoMonitor.getModel();
        if (str2.equalsIgnoreCase("smartisan-sm705")) {
            isStatusNotChange = true;
        }
        if (str2.equalsIgnoreCase("vivo-vivo Y35A")) {
            isStatusNotChange = true;
        }
        enableStatusBarDarkModeForMIUI = true;
    }

    public QViewImmersiveUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int PxToDp(float f16) {
        return Math.round(f16 / getDensity());
    }

    public static void adjustThemeStatusBar(Window window) {
        if (QQTheme.isCustomTheme(getCurrentUin(), true) && isSupporImmersive() != 0 && couldSetStatusTextColor()) {
            setStatusTextColor(!QQTheme.isColorDark(window.getDecorView().getResources().getColor(R.color.skin_color_title_immersive_bar)), window);
        }
    }

    private static void checkImmersiveStatusBar(Window window) {
        try {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public static void clearCoverForStatus(Window window, boolean z16) {
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            String str = Build.MANUFACTURER;
            sb5.append(str);
            sb5.append(DeviceInfoMonitor.getModel());
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "MANUFACTURER = " + str + ", MODEL = " + DeviceInfoMonitor.getModel());
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
            decorView.setSystemUiVisibility(9216);
        } else {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        }
    }

    private static boolean compatLowMIUI(Window window, boolean z16) {
        int i3;
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i16 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            if (z16) {
                i3 = i16;
            } else {
                i3 = 0;
            }
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i16);
            method.invoke(window, objArr);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean correctStatusBarHeight(Window window) {
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i3 = rect.top;
        if (i3 > 0 && i3 <= 200) {
            if (Math.abs(i3 - statusHeight) <= 1) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("systembar", 2, "correct status bar height: " + statusHeight + ", top = " + rect.top);
            }
            statusHeight = rect.top;
            BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("status_bar_height", statusHeight).apply();
            statusHeightCorrect = true;
            return true;
        }
        QLog.w(TAG, 2, "invalid status height: " + rect.top);
        return false;
    }

    public static boolean couldSetStatusTextColor() {
        OSUtils.isMIUI();
        OSUtils.isFlymeOS();
        return true;
    }

    public static int dpToPx(float f16) {
        return Math.round(f16 * getDensity());
    }

    private static String getCurrentUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return "";
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

    private static void init() {
        if (density == -1.0f) {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
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

    public static boolean isStatusTextUseDarkColor(Window window) {
        if (window == null || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
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

    public static boolean isVivoAndLOLLIPOP() {
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    private static boolean processMIUI(Window window, boolean z16) {
        compatHighMIUI(window, z16);
        return true;
    }

    @TargetApi(11)
    public static void setAlpha(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    public static void setRootView(Activity activity) {
        View childAt = ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        if (childAt instanceof ViewGroup) {
            childAt.setFitsSystemWindows(true);
            ((ViewGroup) childAt).setClipToPadding(true);
        }
    }

    public static boolean setStatusBarDarkMode(Window window, boolean z16) {
        if (!VersionUtils.isKITKAT()) {
            return false;
        }
        if (enableStatusBarDarkModeForMIUI && cu.g()) {
            return setStatusBarDarkModeForMIUI(window, z16);
        }
        if (!cu.f()) {
            return false;
        }
        return setStatusBarDarkModeForFlyme(window, z16);
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
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "setStatusBarDarkModeForFlyme: failed");
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

    private static boolean setStatusBarDarkModeForMIUI(Window window, boolean z16) {
        int i3;
        if (window == null || !enableStatusBarDarkModeForMIUI) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i16 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            if (z16) {
                i3 = i16;
            } else {
                i3 = 0;
            }
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i16);
            method.invoke(window, objArr);
            return true;
        } catch (Exception unused) {
            enableStatusBarDarkModeForMIUI = false;
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.e(TAG, 2, "setStatusBarDarkModeForMIUI: failed");
            return false;
        }
    }

    public static boolean setStatusTextColor(boolean z16, Window window) {
        if (OSUtils.isFlymeOS()) {
            return setStatusBarDarkModeForFlyme(window, z16);
        }
        if (OSUtils.isMIUI()) {
            return processMIUI(window, z16);
        }
        if (z16) {
            try {
                window.getDecorView().setSystemUiVisibility(9216);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "useDark setSystemUiVisibility failed" + e16.toString());
                return false;
            }
        } else {
            try {
                window.getDecorView().setSystemUiVisibility(1280);
            } catch (Exception e17) {
                QLog.e(TAG, 1, "useLight setSystemUiVisibility failed" + e17.toString());
                return false;
            }
        }
        return true;
    }

    public static void setTranslucentStatus(Window window) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
                declaredField.setAccessible(true);
                declaredField.setInt(window.getDecorView(), 0);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "\u53cd\u5c04\u4fee\u6539\u72b6\u6001\u680f\u989c\u8272\u5931\u8d25");
                }
            }
        }
    }

    public static boolean supportStatusBarDarkMode() {
        if (VersionUtils.isKITKAT() && ((enableStatusBarDarkModeForMIUI && cu.g()) || cu.f())) {
            return true;
        }
        return false;
    }

    public static void trySetImmersiveStatusBar(Window window) {
        if (VersionUtils.isLOLLIPOP()) {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            return;
        }
        if (VersionUtils.isKITKAT()) {
            window.addFlags(67108864);
        }
    }
}
