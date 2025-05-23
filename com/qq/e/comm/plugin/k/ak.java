package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.util.TypedValue;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ak {
    public static int a(Context context, int i3, int i16) {
        if (i3 != 0) {
            return Double.valueOf(((i16 * 1.0d) * b(context)) / i3).intValue();
        }
        return 0;
    }

    public static int b(Context context, int i3) {
        return (int) ((i3 / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int d(Context context, int i3) {
        return (int) Math.ceil((c(context) * i3) / 100000.0d);
    }

    public static int a(Context context, int i3) {
        return (int) TypedValue.applyDimension(1, i3, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int b(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int c(Context context, int i3) {
        return (int) Math.ceil((b(context) * i3) / 100000.0d);
    }

    public static int a(Context context) {
        try {
            return (context.getApplicationContext().getResources().getConfiguration().screenLayout & 15) >= 3 ? 2 : 1;
        } catch (Exception e16) {
            GDTLogger.d("Get device type encounter exception: " + e16.getMessage());
            return 0;
        }
    }

    public static int a(int i3, int i16) {
        try {
            return (int) Math.ceil((i3 * 100000.0d) / i16);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }
}
