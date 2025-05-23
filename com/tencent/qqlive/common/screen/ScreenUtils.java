package com.tencent.qqlive.common.screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tav.core.ExportErrorStatus;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ScreenUtils {
    ScreenUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getAppScreenHeight() {
        WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int getAppScreenWidth() {
        WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int getLongWidthPx(Context context) {
        return Math.max(getScreenWidth(context), getScreenHeight(context));
    }

    public static float getScreenDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int getScreenDensityDpi() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    public static int getScreenHeight(Context context) {
        return ViewUtils.getScreenHeight();
    }

    public static int getScreenRotation(@NonNull Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }

    public static int getScreenWidth(Context context) {
        return ViewUtils.getScreenWidth();
    }

    public static int getShortWidthPx(Context context) {
        return Math.min(getScreenWidth(context), getScreenHeight(context));
    }

    public static int getSleepDuration() {
        try {
            return Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException e16) {
            e16.printStackTrace();
            return ExportErrorStatus.END_WRITE_VIDEO_SAMPLE;
        }
    }

    public static boolean isFullScreen(@NonNull Activity activity) {
        if ((activity.getWindow().getAttributes().flags & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public static boolean isLandscape() {
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static boolean isPortrait() {
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public static boolean isScreenLock() {
        KeyguardManager keyguardManager = (KeyguardManager) BaseApplication.getContext().getSystemService("keyguard");
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean maybePadInPortrait(Context context) {
        return a.h(context);
    }

    public static void setFullScreen(@NonNull Activity activity) {
        activity.getWindow().addFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void setLandscape(@NonNull Activity activity) {
        activity.setRequestedOrientation(0);
    }

    public static void setNonFullScreen(@NonNull Activity activity) {
        activity.getWindow().clearFlags(1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void setPortrait(@NonNull Activity activity) {
        activity.setRequestedOrientation(1);
    }

    public static void toggleFullScreen(@NonNull Activity activity) {
        boolean isFullScreen = isFullScreen(activity);
        Window window = activity.getWindow();
        if (isFullScreen) {
            window.clearFlags(1024);
        } else {
            window.addFlags(1024);
        }
    }
}
