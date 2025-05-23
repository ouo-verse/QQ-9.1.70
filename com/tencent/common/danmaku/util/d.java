package com.tencent.common.danmaku.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextPaint;
import com.tencent.common.danmaku.inject.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Rect f99812a;

    /* renamed from: b, reason: collision with root package name */
    private static final TextPaint f99813b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Float, Float> f99814c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<Float, Float> f99815d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<Float, Float> f99816e;

    /* renamed from: f, reason: collision with root package name */
    public static Paint f99817f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10462);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f99812a = new Rect();
        f99813b = new TextPaint();
        f99814c = new HashMap();
        f99815d = new HashMap();
        f99816e = new HashMap();
        Paint paint = new Paint();
        f99817f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public static void a(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public static float b(m mVar) {
        return c(mVar.l()) + (com.tencent.common.danmaku.inject.b.p().f() * 2) + (mVar.a() * 2.0f) + (mVar.h() * 2.0f);
    }

    public static float c(float f16) {
        TextPaint textPaint = f99813b;
        textPaint.setTextSize(f16);
        Map<Float, Float> map = f99814c;
        Float f17 = map.get(Float.valueOf(f16));
        if (f17 == null) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            f17 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
            map.put(Float.valueOf(f16), f17);
        }
        return f17.floatValue();
    }

    public static float d(float f16, String str) {
        TextPaint textPaint = f99813b;
        textPaint.setTextSize(f16);
        return e(textPaint, str);
    }

    public static float e(Paint paint, String str) {
        return paint.measureText(str);
    }
}
