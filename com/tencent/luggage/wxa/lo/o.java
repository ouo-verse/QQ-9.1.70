package com.tencent.luggage.wxa.lo;

import android.content.Context;
import android.util.SparseIntArray;
import android.util.TypedValue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static float f133749a = -1.0f;

    /* renamed from: b, reason: collision with root package name */
    public static float f133750b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    public static SparseIntArray f133751c = new SparseIntArray();

    public static int a(Context context, int i3) {
        return Math.round(a(context) * i3);
    }

    public static float b(Context context) {
        return f133750b;
    }

    public static int c(Context context, int i3) {
        if (context == null) {
            n.b("WeUIResHelper", "get dimension pixel size, resId %d, but context is null" + i3, new Object[0]);
            return 0;
        }
        int i16 = f133751c.get(i3, 0);
        if (i16 == 0) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i3);
            f133751c.put(i3, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i16;
    }

    public static float a(Context context) {
        if (context != null && f133749a < 0.0f) {
            f133749a = context.getResources().getDisplayMetrics().density;
        }
        return f133749a;
    }

    public static int b(Context context, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.data;
    }
}
