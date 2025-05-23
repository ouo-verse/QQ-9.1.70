package com.tencent.mobileqq.mini.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.SystemUtil;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DisplayUtil {
    private static final String NAVIGATION = "navigationBarBackground";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
    public static final String TAG = "DisplayUtil";
    private static float density;
    private static boolean mInPortrait;
    private static int mhasNavBar;
    private static String sNavBarOverride;

    static {
        if (VersionUtils.isKITKAT()) {
            try {
                Method declaredMethod = SystemProperties.class.getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                sNavBarOverride = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                sNavBarOverride = null;
            }
        }
        mInPortrait = true;
        mhasNavBar = -1;
    }

    DisplayUtil() {
    }

    @TargetApi(17)
    public static boolean checkHasNavigationBar(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        if (point.y != point2.y) {
            return true;
        }
        return false;
    }

    public static boolean checkNavigationBarShow(@NonNull Context context) {
        boolean z16;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
        boolean z17 = false;
        if (identifier > 0) {
            z16 = resources.getBoolean(identifier);
        } else {
            z16 = false;
        }
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "qemu.hw.mainkeys");
            int i3 = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
            if (!"1".equals(str) && 1 != i3) {
                z17 = "0".equals(str) ? true : z16;
            }
            return z17;
        } catch (Exception unused) {
            return z16;
        }
    }

    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean enableXiaoMiNotch(Activity activity) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 1792);
            if (QLog.isColorLevel()) {
                QLog.i("DisplayUtil", 1, "enableXiaoMiNotch true");
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DisplayUtil", 1, "enableXiaoMiNotch Exception", e16);
            }
            return false;
        }
    }

    public static float getDensity(Context context) {
        float f16 = density;
        if (f16 != 0.0f) {
            return f16;
        }
        if (context != null) {
            float f17 = context.getResources().getDisplayMetrics().density;
            density = f17;
            return f17;
        }
        throw new IllegalArgumentException("");
    }

    public static JSONObject getDisplayCutoutSafeArea(Activity activity) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        JSONObject jSONObject = new JSONObject();
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Rect displayCutoutSafeInsets = SystemUtil.getDisplayCutoutSafeInsets(activity.getWindow().getDecorView());
            displayCutoutSafeInsets.top = SystemUtil.getNotchHeight(activity, activity);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i3 = displayCutoutSafeInsets.left;
            i18 = displayCutoutSafeInsets.top;
            i19 = displayCutoutSafeInsets.right;
            i16 = displayCutoutSafeInsets.bottom;
            i26 = (displayMetrics.widthPixels - i3) - i19;
            i17 = (displayMetrics.heightPixels - i18) - i16;
        } else {
            QLog.w("DisplayUtil", 1, "getDisplayCutoutSafeArea use all zero values");
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            i26 = 0;
        }
        try {
            jSONObject.put("left", i3);
            jSONObject.put("top", i18);
            jSONObject.put("right", i19);
            jSONObject.put("bottom", i16);
            jSONObject.put("width", i26);
            jSONObject.put("height", i17);
        } catch (JSONException e16) {
            QLog.e("DisplayUtil", 1, "getDisplayCutoutSafeArea", e16);
        }
        return jSONObject;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    private static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNavigationBarHeight(Context context) {
        String str;
        Resources resources = context.getResources();
        if (mInPortrait) {
            str = NAV_BAR_HEIGHT_RES_NAME;
        } else {
            str = NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME;
        }
        return getInternalDimensionSize(resources, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[Catch: Exception -> 0x0084, TRY_LEAVE, TryCatch #0 {Exception -> 0x0084, blocks: (B:3:0x0003, B:5:0x001f, B:8:0x0028, B:10:0x0035, B:12:0x0042, B:14:0x004f, B:16:0x005c, B:20:0x0072, B:22:0x007e), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getScreenHeight(Activity activity) {
        boolean z16;
        boolean z17;
        int i3 = 1000;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            boolean z18 = false;
            if (checkHasNavigationBar(activity) && isNavigationBarExist(activity)) {
                z16 = true;
            } else {
                z16 = false;
            }
            i3 = displayMetrics.heightPixels;
            if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && (DeviceInfoMonitor.getModel().contains("MIX 2S") || DeviceInfoMonitor.getModel().contains("MI 8") || DeviceInfoMonitor.getModel().contains("MIX 2"))) {
                if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    i3 = ScreenUtil.getRealHeight(BaseApplication.getContext());
                    if (!z18) {
                        return i3 - getNavigationBarHeight(activity);
                    }
                    return i3;
                }
            }
            z18 = z16;
            if (!z18) {
            }
        } catch (Exception e16) {
            QLog.e("DisplayUtil", 1, "getScreenHeight exception: " + e16.getMessage());
            return i3;
        }
    }

    public static int getScreenRefreshRate(Context context) {
        Display[] displays = ((DisplayManager) context.getSystemService("display")).getDisplays();
        if (displays != null && displays.length > 0) {
            return (int) displays[0].getRefreshRate();
        }
        return 60;
    }

    public static int getStatusBarHeight(Context context) {
        return (int) ((ImmersiveUtils.getStatusBarHeight(context) / getDensity(context)) + 0.5f);
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return str2;
        }
    }

    public static boolean hasNavBar(Context context) {
        boolean z16;
        int i3 = mhasNavBar;
        if (i3 != -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
        if (identifier != 0) {
            z16 = resources.getBoolean(identifier);
            if ("1".equals(sNavBarOverride)) {
                z16 = false;
            } else if ("0".equals(sNavBarOverride)) {
                z16 = true;
            }
        } else {
            z16 = !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "hasNavbar=" + z16);
        }
        if (z16) {
            mhasNavBar = 1;
        } else {
            mhasNavBar = 0;
        }
        return z16;
    }

    public static boolean isFlymeOS7NavBarShow() {
        String systemProperty = getSystemProperty("ro.build.display.id", "");
        if ("Flyme 7.1.1.4A".equals(systemProperty) || "Flyme 7.3.0.0A".equals(systemProperty)) {
            if ("1".equals(getSystemProperty("persist.sys.mz_mback_nav", "0")) && "0".equals(getSystemProperty("persist.sys.mz_mainkeys", "0"))) {
                return true;
            }
            if ("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0")) && "0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isNavigationBarExist(@NonNull Activity activity) {
        boolean z16;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                viewGroup.getChildAt(i3).getContext().getPackageName();
                try {
                    z16 = NAVIGATION.equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i3).getId()));
                } catch (Resources.NotFoundException unused) {
                    QLog.w("DisplayUtil", 1, "isNavigationBarExist error");
                    z16 = false;
                }
                if (viewGroup.getChildAt(i3).getId() != -1 && z16) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNavigationBarShow(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        if (point2.y != point.y) {
            return true;
        }
        return false;
    }

    public static boolean isSimpleThemeAndStatusBarOfWhite(String str) {
        if (!"3063".equals(str) && !"3066".equals(str) && !"3065".equals(str) && !"3067".equals(str) && !"3491".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean isWhiteModeTheme() {
        return "2105".equals(ThemeUtil.getCurrentThemeId());
    }

    public static float mpx2px(double d16) {
        return (float) (d16 * density);
    }

    public static int mpx2pxInt(double d16) {
        return (int) ((d16 * density) + 0.5d);
    }

    public static int parseColor(String str) {
        try {
            if (str.length() == 4 && str.substring(0, 1).equals("#")) {
                String substring = str.substring(1, 2);
                String substring2 = str.substring(2, 3);
                String substring3 = str.substring(3, 4);
                str = "#" + substring + substring + substring2 + substring2 + substring3 + substring3;
            }
            return Color.parseColor(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2mpx(double d16) {
        return (float) (d16 / density);
    }

    public static void setActivityFullScreen(Activity activity) {
        Window window;
        if (activity != null && !activity.isFinishing() && (window = activity.getWindow()) != null) {
            window.getDecorView().setSystemUiVisibility(23075586);
        }
    }

    public static void setStatusBarTextColor(Activity activity) {
        if (ThemeUtil.isDefaultTheme()) {
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
            return;
        }
        if (ThemeUtil.isGoldenTheme()) {
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
            return;
        }
        if (isWhiteModeTheme()) {
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        } else if (isSimpleThemeAndStatusBarOfWhite(ThemeUtil.getCurrentThemeId())) {
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        } else {
            ImmersiveUtils.setStatusTextColor(ThemeUtil.isDartStatusBar(activity, R.color.qq_setting_me_nightmode_color_white), activity.getWindow());
        }
    }

    public static void setSystemUIVisible(BaseActivity baseActivity, boolean z16) {
        int i3;
        if (z16) {
            WindowManager.LayoutParams attributes = baseActivity.getWindow().getAttributes();
            attributes.flags &= -1025;
            baseActivity.getWindow().setAttributes(attributes);
            baseActivity.getWindow().clearFlags(512);
            return;
        }
        LiuHaiUtils.initLiuHaiProperty(baseActivity);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") && ((i3 = Build.VERSION.SDK_INT) == 26 || i3 == 27)) {
                enableXiaoMiNotch(baseActivity);
            } else {
                LiuHaiUtils.enableNotch(baseActivity);
            }
        }
        baseActivity.getWindow().setFlags(1024, 1024);
    }

    public static int sp2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void updatePortrait(Activity activity) {
        if (activity != null) {
            boolean z16 = true;
            if (activity.getWindow().getContext().getResources().getConfiguration().orientation != 1) {
                z16 = false;
            }
            mInPortrait = z16;
        }
    }
}
