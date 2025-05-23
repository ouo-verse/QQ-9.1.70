package com.tencent.mobileqq.ocr.view.gesture.utils;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.state.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Matrix f255088a;

    /* renamed from: b, reason: collision with root package name */
    private static final RectF f255089b;

    /* renamed from: c, reason: collision with root package name */
    private static final Rect f255090c;

    /* renamed from: d, reason: collision with root package name */
    private static final Rect f255091d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f255088a = new Matrix();
        f255089b = new RectF();
        f255090c = new Rect();
        f255091d = new Rect();
    }

    public static void a(Settings settings, Point point) {
        Rect rect = f255091d;
        d(settings, rect);
        int g16 = settings.g();
        Rect rect2 = f255090c;
        Gravity.apply(g16, 0, 0, rect, rect2);
        point.set(rect2.left, rect2.top);
    }

    public static void b(Matrix matrix, Settings settings, Rect rect) {
        RectF rectF = f255089b;
        rectF.set(0.0f, 0.0f, settings.i(), settings.h());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Rect rect2 = f255090c;
        rect2.set(0, 0, settings.r(), settings.q());
        Gravity.apply(settings.g(), round, round2, rect2, rect);
    }

    public static void c(c cVar, Settings settings, Rect rect) {
        Matrix matrix = f255088a;
        cVar.d(matrix);
        b(matrix, settings, rect);
    }

    public static void d(Settings settings, Rect rect) {
        Rect rect2 = f255090c;
        rect2.set(0, 0, settings.r(), settings.q());
        Gravity.apply(settings.g(), settings.m(), settings.l(), rect2, rect);
    }
}
