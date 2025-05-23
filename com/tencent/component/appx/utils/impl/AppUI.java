package com.tencent.component.appx.utils.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.SystemProperties;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.tencent.component.appx.utils.IAppUI;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AppUI implements IAppUI {
    Context context;
    int sStatusBarHeight = -1;

    public AppUI(Context context) {
        this.context = context;
    }

    private String getNavBarOverride() {
        try {
            Method declaredMethod = SystemProperties.class.getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z16 = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z16;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public int dip2px(float f16) {
        return (int) ((f16 * this.context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public int getCurrentNavigationBarHeight(Activity activity) {
        if (activity == null || !isNavigationBarShow(activity, hasNavBar(activity))) {
            return 0;
        }
        return getNavigationBarHeight();
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public int getNavigationBarHeight() {
        Resources resources;
        int identifier;
        if (hasNavBar(this.context) && (identifier = (resources = this.context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public float getScreenDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public int getScreenDensityDpi() {
        return this.context.getResources().getDisplayMetrics().densityDpi;
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public DisplayMetrics getScreenMetrics() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public int getStatusBarHeight() {
        int i3 = this.sStatusBarHeight;
        int i16 = -1;
        if (i3 != -1) {
            return i3;
        }
        Resources resources = this.context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i16 = resources.getDimensionPixelSize(identifier);
        }
        if (i16 <= 0) {
            i16 = dip2px(25.0f);
        }
        this.sStatusBarHeight = i16;
        return i16;
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public boolean isNavigationBarShow(Activity activity, boolean z16) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        int i3 = point.y;
        if (z16) {
            i3 += getStatusBarHeight();
        }
        if (point2.y != i3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public boolean isScreenPortrait() {
        if (this.context.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.component.appx.utils.IAppUI
    public int px2dip(float f16) {
        return (int) ((f16 / this.context.getResources().getDisplayMetrics().density) + 0.5d);
    }
}
