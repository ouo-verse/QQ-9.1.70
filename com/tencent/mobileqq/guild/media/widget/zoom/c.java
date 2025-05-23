package com.tencent.mobileqq.guild.media.widget.zoom;

import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f230081a = new float[9];

    public static void a(float[] fArr, Rect rect) {
        fArr[0] = rect.left;
        fArr[1] = rect.top;
        fArr[2] = rect.right;
        fArr[3] = rect.bottom;
    }

    public static void b(float[] fArr, RectF rectF) {
        fArr[0] = rectF.left;
        fArr[1] = rectF.top;
        fArr[2] = rectF.right;
        fArr[3] = rectF.bottom;
    }

    public static void c(Rect rect, float f16, float f17, float f18, float f19) {
        rect.set(Math.round(f16), Math.round(f17), Math.round(f18), Math.round(f19));
    }

    public static void d(Rect rect, float[] fArr) {
        c(rect, fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    public static void e(RectF rectF, float f16, float f17, float f18, float f19) {
        rectF.set(Math.round(f16), Math.round(f17), Math.round(f18), Math.round(f19));
    }

    public static void f(RectF rectF, float[] fArr) {
        e(rectF, fArr[0], fArr[1], fArr[2], fArr[3]);
    }
}
