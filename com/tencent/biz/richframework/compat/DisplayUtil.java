package com.tencent.biz.richframework.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DisplayUtil {
    private static float DP_TO_PX_INCREMENT = 0.5f;
    private static float SCREEN_DP_NEW = 3.0f;
    private static float SCREEN_DP_OLD = 2.7f;
    private static boolean mInPortrait = false;
    private static boolean mIsPortrait = false;
    private static int mhasNavBar = 0;
    private static float sDeviceDensity = -1.0f;
    private static int sDeviceDensityDpi = -1;
    public static int sInstantHeight;
    public static int sInstantWidth;
    private static String sNavBarOverride;
    public static int sTopStatusHeight;
    public static int sWindowHeight;
    public static int sWindowWidth;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class AdjustViewSizeParams {
        private int mDefaultHeight;
        private int mDefaultWidth;
        private boolean mEnableAdjustHeight = true;
        private int mFixWidth;
        private ViewGroup.LayoutParams mLayoutParams;
        private float mMaxCardWidthScale;
        private int mTargetWidth;
        private View mView;

        public int getTargetWidth() {
            return this.mTargetWidth;
        }

        public AdjustViewSizeParams setDefaultHeight(int i3) {
            this.mDefaultHeight = i3;
            return this;
        }

        public AdjustViewSizeParams setDefaultWidth(int i3) {
            this.mDefaultWidth = i3;
            return this;
        }

        public AdjustViewSizeParams setEnableAdjustHeight(boolean z16) {
            this.mEnableAdjustHeight = z16;
            return this;
        }

        public AdjustViewSizeParams setFixWidth(int i3) {
            this.mFixWidth = i3;
            return this;
        }

        public AdjustViewSizeParams setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            this.mLayoutParams = layoutParams;
            return this;
        }

        public AdjustViewSizeParams setMaxCardWidthScale(float f16) {
            this.mMaxCardWidthScale = f16;
            return this;
        }

        public AdjustViewSizeParams setTargetWidth(int i3) {
            this.mTargetWidth = i3;
            return this;
        }

        public AdjustViewSizeParams setView(View view) {
            this.mView = view;
            return this;
        }
    }

    static {
        try {
            Method declaredMethod = SystemProperties.class.getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            sNavBarOverride = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            sNavBarOverride = null;
        }
        mInPortrait = true;
        mhasNavBar = -1;
    }

    public static void adjustViewSize(AdjustViewSizeParams adjustViewSizeParams) {
        int instantScreenWidth;
        if (adjustViewSizeParams != null && adjustViewSizeParams.mView != null && adjustViewSizeParams.mDefaultWidth > 0 && adjustViewSizeParams.mDefaultHeight > 0) {
            if (adjustViewSizeParams.mLayoutParams == null) {
                adjustViewSizeParams.mLayoutParams = adjustViewSizeParams.mView.getLayoutParams();
            }
            if (adjustViewSizeParams.mLayoutParams == null) {
                adjustViewSizeParams.mLayoutParams = new ViewGroup.LayoutParams(adjustViewSizeParams.mDefaultWidth, adjustViewSizeParams.mDefaultHeight);
            }
            adjustViewSizeParams.mLayoutParams.width = adjustViewSizeParams.mDefaultWidth;
            adjustViewSizeParams.mLayoutParams.height = adjustViewSizeParams.mDefaultHeight;
            if (adjustViewSizeParams.getTargetWidth() != 0) {
                instantScreenWidth = adjustViewSizeParams.getTargetWidth();
            } else {
                instantScreenWidth = getInstantScreenWidth(adjustViewSizeParams.mView.getContext());
            }
            double d16 = ((instantScreenWidth - adjustViewSizeParams.mFixWidth) / (adjustViewSizeParams.mLayoutParams.width * 1.0d)) / adjustViewSizeParams.mMaxCardWidthScale;
            adjustViewSizeParams.mLayoutParams.width = (int) (adjustViewSizeParams.mLayoutParams.width * d16);
            if (adjustViewSizeParams.mEnableAdjustHeight) {
                adjustViewSizeParams.mLayoutParams.height = (int) (d16 * adjustViewSizeParams.mLayoutParams.height);
            }
            adjustViewSizeParams.mView.setLayoutParams(adjustViewSizeParams.mLayoutParams);
        }
    }

    public static boolean checkDeviceHasNavigationBar(Context context) {
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && (DeviceInfoMonitor.getModel().contains("MIX 2S") || DeviceInfoMonitor.getModel().contains("MI 8") || DeviceInfoMonitor.getModel().contains("MI 9") || DeviceInfoMonitor.getModel().contains("MIX 2") || DeviceInfoMonitor.getModel().contains("MIX 3") || DeviceInfoMonitor.getModel().contains("Redmi K20 Pro"))) {
            if (Settings.Global.getInt(RFWApplication.getApplication().getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
                return true;
            }
            return false;
        }
        if (getInstantScreenHeight(context) != getRealHeight(context)) {
            return true;
        }
        return false;
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

    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dp2pxScreenDensity3(Context context, float f16) {
        float f17 = context.getResources().getDisplayMetrics().density;
        if (f17 == SCREEN_DP_OLD) {
            f17 = SCREEN_DP_NEW;
        }
        return Math.round((f16 * f17) + DP_TO_PX_INCREMENT);
    }

    public static float getDensity() {
        if (sDeviceDensity < 0.0f) {
            sDeviceDensity = RFWApplication.getApplication().getResources().getDisplayMetrics().density;
        }
        return sDeviceDensity;
    }

    public static int getInstantScreenHeight(Context context) {
        if (sInstantHeight == 0) {
            init(context);
        }
        return sInstantHeight;
    }

    public static int getInstantScreenWidth(Context context) {
        if (sInstantWidth == 0) {
            init(context);
        }
        return sInstantWidth;
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
            str = "navigation_bar_height";
        } else {
            str = "navigation_bar_height_landscape";
        }
        return getInternalDimensionSize(resources, str);
    }

    public static int getRealHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (NoSuchMethodException e16) {
            RFWLog.e("DisplayUtil", RFWLog.CLR, e16.getMessage());
            return -1;
        }
    }

    public static int getScreenCommonAreaHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenHeight() {
        if (sWindowHeight <= 0) {
            init(RFWApplication.getApplication());
        }
        return sWindowHeight;
    }

    public static int getScreenWidth() {
        if (sWindowWidth <= 0) {
            init(RFWApplication.getApplication());
        }
        return sWindowWidth;
    }

    public static int getTopHeight(Context context) {
        int i3;
        int i16;
        int i17 = sTopStatusHeight;
        if (i17 != 0) {
            return i17;
        }
        if (context == null) {
            return 0;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 = ImmersiveUtils.getStatusBarHeight(context);
        } else {
            i3 = 0;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (RFLiuHaiUtils.enableNotch(activity)) {
                i16 = RFLiuHaiUtils.getNotchInScreenHeight(activity);
                RFWLog.d("DisplayUtil", RFWLog.USR, "getTopHeight" + i3 + "|" + i16);
                int max = Math.max(i3, i16);
                sTopStatusHeight = max;
                return max;
            }
        }
        i16 = 0;
        RFWLog.d("DisplayUtil", RFWLog.USR, "getTopHeight" + i3 + "|" + i16);
        int max2 = Math.max(i3, i16);
        sTopStatusHeight = max2;
        return max2;
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
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
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
        if (RFWLog.isColorLevel()) {
            RFWLog.d("XPanelContainer", RFWLog.CLR, "hasNavbar=" + z16);
        }
        if (z16) {
            mhasNavBar = 1;
        } else {
            mhasNavBar = 0;
        }
        return z16;
    }

    public static void init(@NonNull Context context) {
        if (context.getResources() != null && context.getResources().getConfiguration() != null) {
            init(context, context.getResources().getConfiguration());
        } else {
            RFWLog.e("DisplayUtil", RFWLog.USR, "[init] resource or configuration is null. ");
        }
    }

    public static boolean isNavigationBarExist(@NonNull Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                viewGroup.getChildAt(i3).getContext().getPackageName();
                if (viewGroup.getChildAt(i3).getId() != -1 && "navigationBarBackground".equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i3).getId()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void reset() {
        sInstantWidth = 0;
        sInstantHeight = 0;
        sWindowWidth = 0;
        sWindowHeight = 0;
        sDeviceDensityDpi = -1;
        sDeviceDensity = -1.0f;
        sTopStatusHeight = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        boolean z16 = false;
        boolean z17 = checkHasNavigationBar(activity) && isNavigationBarExist(activity);
        int i3 = displayMetrics.heightPixels;
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && (DeviceInfoMonitor.getModel().contains("MIX 2S") || DeviceInfoMonitor.getModel().contains("MI 8") || DeviceInfoMonitor.getModel().contains("MIX 2"))) {
            if (Settings.Global.getInt(RFWApplication.getApplication().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                i3 = getRealHeight(RFWApplication.getApplication());
                return !z16 ? i3 - getNavigationBarHeight(activity) : i3;
            }
        }
        z16 = z17;
        if (!z16) {
        }
    }

    public static void init(@NonNull Context context, @NonNull Configuration configuration) {
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        Rect bounds;
        int i3;
        int i16;
        Rect bounds2;
        int i17;
        int i18;
        WindowMetrics maximumWindowMetrics;
        Rect bounds3;
        WindowMetrics maximumWindowMetrics2;
        Rect bounds4;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            sDeviceDensity = context.getResources().getDisplayMetrics().density;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            mIsPortrait = configuration.orientation == 1;
            if (Build.VERSION.SDK_INT >= 30 && RFWConfig.getConfigValue("enable_use_new_api_get_display", false)) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                windowInsets = currentWindowMetrics.getWindowInsets();
                systemBars = WindowInsets.Type.systemBars();
                insets = windowInsets.getInsets(systemBars);
                bounds = currentWindowMetrics.getBounds();
                int height = bounds.height();
                i3 = insets.top;
                int i19 = height - i3;
                i16 = insets.bottom;
                int i26 = i19 - i16;
                bounds2 = currentWindowMetrics.getBounds();
                int width = bounds2.width();
                i17 = insets.left;
                i18 = insets.right;
                int i27 = (width - i17) - i18;
                maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                bounds3 = maximumWindowMetrics.getBounds();
                int height2 = bounds3.height();
                maximumWindowMetrics2 = windowManager.getMaximumWindowMetrics();
                bounds4 = maximumWindowMetrics2.getBounds();
                int width2 = bounds4.width();
                sWindowHeight = mIsPortrait ? Math.max(i26, i27) : Math.min(i26, i27);
                sWindowWidth = mIsPortrait ? Math.min(i26, i27) : Math.max(i26, i27);
                sInstantHeight = mIsPortrait ? Math.max(height2, width2) : Math.min(height2, width2);
                sInstantWidth = mIsPortrait ? Math.min(height2, width2) : Math.max(height2, width2);
            } else {
                Point point = new Point();
                windowManager.getDefaultDisplay().getRealSize(point);
                sInstantWidth = mIsPortrait ? Math.min(point.x, point.y) : Math.max(point.x, point.y);
                sInstantHeight = mIsPortrait ? Math.max(point.x, point.y) : Math.min(point.x, point.y);
                windowManager.getDefaultDisplay().getSize(point);
                sWindowWidth = mIsPortrait ? Math.min(point.x, point.y) : Math.max(point.x, point.y);
                sWindowHeight = mIsPortrait ? Math.max(point.x, point.y) : Math.min(point.x, point.y);
            }
            RFWLog.d("DisplayUtil", RFWLog.USR, "[init] isPortrait | " + mIsPortrait + ", screenW | " + sInstantWidth + ", screenH | " + sInstantHeight + ", windowW | " + sWindowWidth + ", windowH | " + sWindowHeight + ", density | " + sDeviceDensity + ", cost | " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e16) {
            RFWLog.e("DisplayUtil", RFWLog.USR, "[init] " + e16);
        }
    }
}
