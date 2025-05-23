package com.tencent.luggage.wxa.a;

import android.graphics.Canvas;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f120462a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f120463b;

    static {
        try {
            f120462a = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            f120463b = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable th5) {
            throw a(th5);
        }
    }

    public static void a(Canvas canvas, int i3) {
        try {
            f120463b.invoke(canvas, Integer.valueOf(i3));
        } catch (Throwable th5) {
            throw a(th5);
        }
    }

    public static RuntimeException a(Throwable th5) {
        if (th5 != null) {
            return (RuntimeException) b(th5);
        }
        throw new NullPointerException("t");
    }

    public static Throwable b(Throwable th5) {
        throw th5;
    }
}
