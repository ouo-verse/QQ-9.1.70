package com.tencent.luggage.wxa.kn;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static float f132671a = -1.0f;

    /* renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f132672b = new SparseIntArray();

    /* renamed from: c, reason: collision with root package name */
    public static float f132673c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f132674d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f132675e = true;

    public static float a(Context context) {
        if (context == null) {
            context = z.c();
        }
        float f16 = context.getResources().getDisplayMetrics().density;
        f132671a = f16;
        return f16;
    }

    public static int b(Context context, int i3) {
        if (context != null) {
            return context.getResources().getColor(i3);
        }
        w.b("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i3));
        return 0;
    }

    public static int c(Context context, int i3) {
        int i16;
        if (context == null) {
            w.b("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i3));
            return 0;
        }
        SparseIntArray sparseIntArray = f132672b;
        synchronized (sparseIntArray) {
            i16 = sparseIntArray.get(i3, 0);
        }
        if (i16 <= 0) {
            i16 = context.getResources().getDimensionPixelSize(i3);
            synchronized (sparseIntArray) {
                sparseIntArray.put(i3, i16);
            }
        }
        return i16;
    }

    public static int d(Context context, int i3) {
        float f16 = f(context);
        if (f16 > 1.4f) {
            f16 = 1.4f;
        }
        return (int) (c(context, i3) * f16);
    }

    public static Drawable e(Context context, int i3) {
        if (context != null) {
            return context.getResources().getDrawable(i3);
        }
        w.b("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i3));
        return null;
    }

    public static String f(Context context, int i3) {
        if (context != null) {
            return context.getResources().getString(i3);
        }
        w.b("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i3));
        return "";
    }

    public static float g(Context context) {
        if (c(context)) {
            return 1.12f;
        }
        return 1.25f;
    }

    public static boolean h(Context context) {
        float f16 = f(context);
        f132673c = f16;
        if (Float.compare(f16, g(context)) > 0) {
            return true;
        }
        return false;
    }

    public static int a(Context context, int i3) {
        return Math.round(a(context) * i3);
    }

    public static int b(Context context) {
        if (context == null) {
            w.b("MicroMsg.ResourceHelper", "get heightPixels but context is null");
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float d(Context context) {
        if (h(context)) {
            return c(context) ? 1.2f : 1.1f;
        }
        return 1.0f;
    }

    public static float e(Context context) {
        if (context == null) {
            return 1.0f;
        }
        if (f0.e(z.f()).contains("text_size_scale_key")) {
            return f0.e(z.f()).getFloat("text_size_scale_key", 1.0f);
        }
        return context.getSharedPreferences(z.f(), 0).getFloat("text_size_scale_key", 1.0f);
    }

    public static float f(Context context) {
        if (f132673c == 0.0f) {
            if (context == null) {
                f132673c = 1.0f;
            } else {
                f132673c = e(context);
            }
        }
        if (!f132674d) {
            f132675e = context.getSharedPreferences(z.f(), 0).getBoolean("screenResolution_isModifyDensity", true);
            f132674d = true;
        }
        if (f132675e && (a(f132673c, 1.1f) || a(f132673c, 0.8f))) {
            f132673c = 1.0f;
        }
        return f132673c;
    }

    public static boolean a(float f16, float f17) {
        return ((double) Math.abs(f16 - f17)) <= 1.0E-5d;
    }

    public static boolean c(Context context) {
        if (context != null && !f132674d) {
            f132675e = context.getSharedPreferences(z.f(), 0).getBoolean("screenResolution_isModifyDensity", true);
            f132674d = true;
        }
        return f132675e;
    }
}
