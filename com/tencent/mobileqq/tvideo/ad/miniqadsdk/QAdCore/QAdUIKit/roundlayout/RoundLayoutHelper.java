package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RoundLayoutHelper {

    /* renamed from: a, reason: collision with root package name */
    private int f303744a;

    /* renamed from: f, reason: collision with root package name */
    private Path f303749f;

    /* renamed from: g, reason: collision with root package name */
    private RectF f303750g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f303751h;

    /* renamed from: b, reason: collision with root package name */
    private int f303745b = 6;

    /* renamed from: c, reason: collision with root package name */
    private int f303746c = 6;

    /* renamed from: d, reason: collision with root package name */
    private int f303747d = 6;

    /* renamed from: e, reason: collision with root package name */
    private int f303748e = 6;

    /* renamed from: i, reason: collision with root package name */
    @RadiusMode
    private int f303752i = 1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface RadiusMode {
    }

    public RoundLayoutHelper(Context context, AttributeSet attributeSet) {
        d(context, attributeSet);
    }

    private boolean a() {
        if ((this.f303744a >= 0 && this.f303752i != 0) || (this.f303752i == 0 && this.f303745b >= 0 && this.f303746c >= 0 && this.f303748e >= 0 && this.f303747d >= 0)) {
            return true;
        }
        return false;
    }

    private void c(View view, Canvas canvas) {
        this.f303750g.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        this.f303749f.reset();
        int i3 = this.f303752i;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            Path path = this.f303749f;
                            RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                            int i16 = this.f303745b;
                            int i17 = this.f303746c;
                            int i18 = this.f303748e;
                            int i19 = this.f303747d;
                            path.addRoundRect(rectF, new float[]{i16, i16, i17, i17, i18, i18, i19, i19}, Path.Direction.CCW);
                        } else {
                            Path path2 = this.f303749f;
                            RectF rectF2 = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                            int i26 = this.f303744a;
                            path2.addRoundRect(rectF2, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i26, i26, i26, i26}, Path.Direction.CCW);
                        }
                    } else {
                        Path path3 = this.f303749f;
                        RectF rectF3 = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                        int i27 = this.f303744a;
                        path3.addRoundRect(rectF3, new float[]{0.0f, 0.0f, i27, i27, i27, i27, 0.0f, 0.0f}, Path.Direction.CCW);
                    }
                } else {
                    Path path4 = this.f303749f;
                    RectF rectF4 = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                    int i28 = this.f303744a;
                    path4.addRoundRect(rectF4, new float[]{i28, i28, i28, i28, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
                }
            } else {
                Path path5 = this.f303749f;
                RectF rectF5 = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                int i29 = this.f303744a;
                path5.addRoundRect(rectF5, new float[]{i29, i29, 0.0f, 0.0f, 0.0f, 0.0f, i29, i29}, Path.Direction.CCW);
            }
        } else {
            Path path6 = this.f303749f;
            RectF rectF6 = this.f303750g;
            int i36 = this.f303744a;
            path6.addRoundRect(rectF6, i36, i36, Path.Direction.CCW);
        }
        this.f303749f.close();
        canvas.clipPath(this.f303749f);
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.f303749f = new Path();
        this.f303750g = new RectF();
    }

    public void b(View view, Canvas canvas) {
        try {
            if (a() && view.getWidth() > 0 && view.getHeight() > 0) {
                c(view, canvas);
                Drawable drawable = this.f303751h;
                if (drawable != null) {
                    drawable.setBounds(0, 0, view.getWidth(), view.getHeight());
                    this.f303751h.draw(canvas);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void e(Drawable drawable) {
        this.f303751h = drawable;
    }

    public void f(int i3) {
        g(i3, 1);
    }

    public void g(int i3, @RadiusMode int i16) {
        this.f303744a = i3;
        this.f303752i = i16;
    }

    public void h(int i3, int i16, int i17, int i18) {
        this.f303745b = i3;
        this.f303746c = i16;
        this.f303747d = i17;
        this.f303748e = i18;
        this.f303752i = 0;
    }
}
