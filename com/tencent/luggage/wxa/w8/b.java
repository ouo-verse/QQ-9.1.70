package com.tencent.luggage.wxa.w8;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static float f144113a = -1.0f;

    public static float a(Context context) {
        if (f144113a < 0.0f) {
            f144113a = context.getResources().getDisplayMetrics().density;
        }
        return f144113a;
    }

    public static Point b(Context context) {
        Point c16 = c(context);
        c16.x = a(context, c16.x);
        c16.y = a(context, c16.y);
        return c16;
    }

    public static Point c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getRealSize(point);
            if (point.x != 0 && point.y != 0) {
                return point;
            }
        }
        point.x = context.getResources().getDisplayMetrics().widthPixels;
        point.y = context.getResources().getDisplayMetrics().heightPixels;
        return point;
    }

    public static int a(Context context, int i3) {
        return (int) Math.ceil(i3 / a(context));
    }
}
