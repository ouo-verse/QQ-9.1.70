package com.tencent.component.appx.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IAppUI {
    int dip2px(float f16);

    int getCurrentNavigationBarHeight(Activity activity);

    int getNavigationBarHeight();

    float getScreenDensity();

    int getScreenDensityDpi();

    DisplayMetrics getScreenMetrics();

    int getStatusBarHeight();

    boolean isNavigationBarShow(Activity activity, boolean z16);

    boolean isScreenPortrait();

    int px2dip(float f16);
}
