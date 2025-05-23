package com.qq.e.tg.splash.image;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class PxUtil {
    public static int dpToPx(Context context, int i3) {
        return (int) TypedValue.applyDimension(1, i3, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int getCurrentNavigationBarHeight(Context context) {
        boolean z16;
        int identifier;
        View findViewById;
        int visibility;
        if ((context instanceof Activity) && (findViewById = ((Activity) context).findViewById(R.id.navigationBarBackground)) != null && (visibility = findViewById.getVisibility()) != 8 && visibility != 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static int getDeviceHeightInPixel(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDeviceType(Context context) {
        try {
            if ((context.getApplicationContext().getResources().getConfiguration().screenLayout & 15) >= 3) {
                return 2;
            }
            return 1;
        } catch (Exception e16) {
            GDTLogger.d("Get device type encounter exception: " + e16.getMessage());
            return 0;
        }
    }

    public static int getDeviceWidthInPixel(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getHeightByAspectRadio(int i3, int i16) {
        try {
            return (int) Math.ceil((i3 * 100000.0d) / i16);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    public static int getHeightByPecent(Context context, int i3) {
        return (int) Math.ceil((getDeviceHeightInPixel(context) * i3) / 100000.0d);
    }

    public static int getValueDependsOnScreenWidth(Context context, int i3, int i16) {
        if (i3 != 0) {
            return Double.valueOf(((i16 * 1.0d) * getDeviceWidthInPixel(context)) / i3).intValue();
        }
        return 0;
    }

    public static int getWidthByPecent(Context context, int i3) {
        return (int) Math.ceil((getDeviceWidthInPixel(context) * i3) / 100000.0d);
    }

    public static int pxToDp(Context context, int i3) {
        return (int) ((i3 / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
