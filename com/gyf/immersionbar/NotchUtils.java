package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_LENOVO = "config_screen_has_notch";
    private static final String NOTCH_MEIZU = "flyme.config.FlymeFeature";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";

    private static int dp2px(Context context, int i3) {
        return (int) TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    private static DisplayCutout getDisplayCutout(Activity activity) {
        return getDisplayCutout(activity.getWindow().getDecorView());
    }

    private static int[] getHuaWeiNotchSize(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return iArr;
        }
    }

    private static int getLenovoNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_h", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static int getMeizuNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("fringe_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (80 < r0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getNotchHeight(Activity activity) {
        int safeInsetLeft;
        int safeInsetLeft2;
        int safeInsetRight;
        int safeInsetTop;
        if (!hasNotchScreen(activity)) {
            return 0;
        }
        int B = ImmersionBar.B(activity);
        DisplayCutout displayCutout = getDisplayCutout(activity);
        if (Build.VERSION.SDK_INT >= 28 && displayCutout != null) {
            if (activity.getResources().getConfiguration().orientation == 1) {
                safeInsetTop = displayCutout.getSafeInsetTop();
                return safeInsetTop;
            }
            safeInsetLeft = displayCutout.getSafeInsetLeft();
            if (safeInsetLeft == 0) {
                safeInsetRight = displayCutout.getSafeInsetRight();
                return safeInsetRight;
            }
            safeInsetLeft2 = displayCutout.getSafeInsetLeft();
            return safeInsetLeft2;
        }
        int xiaoMiNotchHeight = hasNotchAtXiaoMi(activity) ? getXiaoMiNotchHeight(activity) : 0;
        if (hasNotchAtHuaWei(activity)) {
            xiaoMiNotchHeight = getHuaWeiNotchSize(activity)[1];
        }
        if (hasNotchAtVIVO(activity) && (xiaoMiNotchHeight = dp2px(activity, 32)) < B) {
            xiaoMiNotchHeight = B;
        }
        if (hasNotchAtOPPO(activity)) {
            xiaoMiNotchHeight = 80;
        }
        B = xiaoMiNotchHeight;
        if (hasNotchAtLenovo(activity)) {
            B = getLenovoNotchHeight(activity);
        }
        return hasNotchAtMeiZu() ? getMeizuNotchHeight(activity) : B;
    }

    private static int getXiaoMiNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean hasNotchAtAndroidP(View view) {
        return getDisplayCutout(view) != null;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasNotchAtHuaWei(Context context) {
        if (!OSUtils.isHuaWei()) {
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchAtLenovo(Context context) {
        int identifier;
        if (OSUtils.isLenovo() && (identifier = context.getResources().getIdentifier(NOTCH_LENOVO, "bool", "android")) > 0) {
            return context.getResources().getBoolean(identifier);
        }
        return false;
    }

    private static boolean hasNotchAtMeiZu() {
        if (OSUtils.isMeizu()) {
            try {
                return ((Boolean) Class.forName(NOTCH_MEIZU).getDeclaredField("IS_FRINGE_DEVICE").get(null)).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean hasNotchAtOPPO(Context context) {
        if (OSUtils.isOppo()) {
            try {
                return context.getPackageManager().hasSystemFeature(NOTCH_OPPO);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasNotchAtVIVO(Context context) {
        if (!OSUtils.isVivo()) {
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_VIVO);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"PrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean hasNotchAtXiaoMi(Context context) {
        Object invoke;
        int intValue;
        if (OSUtils.isXiaoMi()) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                invoke = loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, NOTCH_XIAO_MI, 0);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            if (invoke != null) {
                intValue = ((Integer) invoke).intValue();
                if (intValue != 1) {
                    return true;
                }
                return false;
            }
        }
        intValue = 0;
        if (intValue != 1) {
        }
    }

    public static boolean hasNotchScreen(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return hasNotchAtAndroidP(activity);
        }
        return hasNotchAtXiaoMi(activity) || hasNotchAtHuaWei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVIVO(activity) || hasNotchAtLenovo(activity) || hasNotchAtMeiZu();
    }

    private static DisplayCutout getDisplayCutout(View view) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28 || view == null || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return null;
        }
        displayCutout = rootWindowInsets.getDisplayCutout();
        return displayCutout;
    }

    private static boolean hasNotchAtAndroidP(Activity activity) {
        return getDisplayCutout(activity) != null;
    }

    public static boolean hasNotchScreen(View view) {
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return hasNotchAtAndroidP(view);
        }
        return hasNotchAtXiaoMi(view.getContext()) || hasNotchAtHuaWei(view.getContext()) || hasNotchAtOPPO(view.getContext()) || hasNotchAtVIVO(view.getContext());
    }

    public static void getNotchHeight(Activity activity, l lVar) {
        activity.getWindow().getDecorView().post(new Runnable(lVar, activity) { // from class: com.gyf.immersionbar.NotchUtils.1

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f36008d;

            {
                this.f36008d = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }
}
