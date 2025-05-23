package com.tencent.mobileqq.ocr.view.gesture.utils;

import android.graphics.Matrix;
import com.tencent.mobileqq.ocr.view.gesture.state.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Matrix f255092a;

    /* renamed from: b, reason: collision with root package name */
    private static final Matrix f255093b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21098);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f255092a = new Matrix();
            f255093b = new Matrix();
        }
    }

    public static void a(float[] fArr, c cVar, c cVar2) {
        Matrix matrix = f255092a;
        cVar.d(matrix);
        Matrix matrix2 = f255093b;
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        cVar2.d(matrix);
        matrix.mapPoints(fArr);
    }

    public static float b(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    public static void c(c cVar, c cVar2, float f16, float f17, c cVar3, float f18, float f19, float f26) {
        float b16;
        cVar.m(cVar2);
        if (!c.c(cVar2.i(), cVar3.i())) {
            cVar.r(b(cVar2.i(), cVar3.i(), f26), f16, f17);
        }
        float f27 = cVar2.f();
        float f28 = cVar3.f();
        if (Math.abs(f27 - f28) <= 180.0f) {
            if (!c.c(f27, f28)) {
                b16 = b(f27, f28, f26);
            }
            b16 = Float.NaN;
        } else {
            if (f27 < 0.0f) {
                f27 += 360.0f;
            }
            if (f28 < 0.0f) {
                f28 += 360.0f;
            }
            if (!c.c(f27, f28)) {
                b16 = b(f27, f28, f26);
            }
            b16 = Float.NaN;
        }
        if (!Float.isNaN(b16)) {
            cVar.k(b16, f16, f17);
        }
        cVar.n(b(0.0f, f18 - f16, f26), b(0.0f, f19 - f17, f26));
    }

    public static void d(c cVar, c cVar2, c cVar3, float f16) {
        c(cVar, cVar2, cVar2.g(), cVar2.h(), cVar3, cVar3.g(), cVar3.h(), f16);
    }

    public static float e(float f16, float f17, float f18) {
        return Math.max(f17, Math.min(f16, f18));
    }
}
