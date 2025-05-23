package com.tencent.mtt.supportui.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ViewCompatTool {
    public static final int FAKE_FRAME_TIME = 16;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static int sdkVersion = Build.VERSION.SDK_INT;

    @TargetApi(16)
    public static int getMinimumHeight(View view) {
        if (sdkVersion >= 16) {
            return view.getMinimumHeight();
        }
        return 0;
    }

    @TargetApi(16)
    public static int getMinimumWidth(View view) {
        if (sdkVersion >= 16) {
            return view.getMinimumWidth();
        }
        return 0;
    }

    @TargetApi(16)
    public static void postInvalidateOnAnimation(View view) {
        if (sdkVersion >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(16L);
        }
    }

    @TargetApi(16)
    public static void postOnAnimation(View view, Runnable runnable) {
        if (sdkVersion >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    public static void setDefaultLayotuDirection(View view) {
        setLayoutDirection(view, 0);
    }

    @TargetApi(17)
    public static void setLayoutDirection(View view, int i3) {
        if (sdkVersion >= 17) {
            view.setLayoutDirection(i3);
        }
    }
}
