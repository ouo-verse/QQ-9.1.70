package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bv {
    public static int a(Context context) {
        if (context == null) {
            QLog.e("QQGuildDisplayHelper", 1, "getScreenHeight: context is null");
            return -1;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int b(Context context) {
        if (context == null) {
            QLog.e("QQGuildDisplayHelper", 1, "getScreenWidth: context is null");
            return -1;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static int c(Context context) {
        return ImmersiveUtils.getStatusBarHeight(context);
    }
}
