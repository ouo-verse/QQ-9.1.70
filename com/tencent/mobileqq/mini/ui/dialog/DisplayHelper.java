package com.tencent.mobileqq.mini.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DisplayHelper {
    private static final String TAG = "Devices";
    public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
    public static float sDensity = 0.0f;

    public static int dp2px(Context context, int i3) {
        return (int) ((getDensity(context) * i3) + 0.5d);
    }

    public static int dpToPx(int i3) {
        return (int) ((i3 * DENSITY) + 0.5f);
    }

    public static float getDensity(Context context) {
        if (sDensity == 0.0f) {
            sDensity = getDisplayMetrics(context).density;
        }
        return sDensity;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static boolean isFullScreen(Activity activity) {
        if ((activity.getWindow().getAttributes().flags & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public static boolean isPackageExist(Context context, String str) {
        if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0) == null) {
            return false;
        }
        return true;
    }

    public static int px2dp(Context context, int i3) {
        return (int) ((i3 / getDensity(context)) + 0.5d);
    }

    public static void setFullScreen(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().addFlags(512);
        }
    }
}
