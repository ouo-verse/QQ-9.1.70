package com.tencent.mobileqq.activity.richmedia;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f185846d = false;

    /* renamed from: e, reason: collision with root package name */
    private static int f185847e;

    /* renamed from: a, reason: collision with root package name */
    private Matrix f185848a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private Matrix f185849b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private int f185850c = 90;

    private static int b(int i3, int i16, int i17) {
        if (i3 > i17) {
            return i17;
        }
        if (i3 < i16) {
            return i16;
        }
        return i3;
    }

    private static int c() {
        int i3 = f185847e;
        if (i3 == 0) {
            int dimension = (int) BaseApplicationImpl.getApplication().getResources().getDimension(R.dimen.f159388b55);
            f185847e = dimension;
            return dimension;
        }
        return i3;
    }

    public Rect a(float f16, float f17, int i3, int i16, float f18) {
        int intValue = Float.valueOf(c() * f18).intValue();
        int i17 = intValue / 2;
        RectF rectF = new RectF(b(((int) f16) - i17, 0, i3 - intValue), b(((int) f17) - i17, 0, i16 - intValue), r3 + intValue, r4 + intValue);
        this.f185848a.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public void d(int i3, int i16, int i17, int i18) {
        Matrix matrix = new Matrix();
        this.f185849b = matrix;
        com.tencent.mobileqq.camera.utils.a.o(matrix, f185846d, this.f185850c, i17, i18, i3, i16);
        this.f185849b.invert(this.f185848a);
    }

    public void e(boolean z16) {
        f185846d = z16;
    }
}
