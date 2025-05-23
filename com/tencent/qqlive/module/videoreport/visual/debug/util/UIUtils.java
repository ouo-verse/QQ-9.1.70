package com.tencent.qqlive.module.videoreport.visual.debug.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class UIUtils {
    public static int getAppScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int getAppScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static Rect getViewRect(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        if (isStatusBarVisible()) {
            rect.top -= getStatusBarHeight();
        }
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        rect.top = Math.max(rect.top, 0);
        return rect;
    }

    public static Rect getViewVisibleRect(View view) {
        Rect rect = new Rect();
        try {
            view.getGlobalVisibleRect(rect);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (isStatusBarVisible()) {
            rect.top -= getStatusBarHeight();
        }
        rect.top = Math.max(rect.top, 0);
        return rect;
    }

    public static boolean isStatusBarVisible() {
        Activity topActivity = ActivityUtil.getTopActivity();
        return topActivity != null && isStatusBarVisible(topActivity);
    }

    public static boolean isStatusBarVisible(@NonNull Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 0;
    }
}
