package com.tencent.mobileqq.search.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final View f285114a;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f285121h;

    /* renamed from: j, reason: collision with root package name */
    private float f285123j;

    /* renamed from: k, reason: collision with root package name */
    private float f285124k;

    /* renamed from: l, reason: collision with root package name */
    private float f285125l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f285126m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f285127n;

    /* renamed from: p, reason: collision with root package name */
    private boolean f285129p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f285130q;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f285115b = new Paint();

    /* renamed from: c, reason: collision with root package name */
    private final Rect f285116c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private String f285117d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f285118e = "";

    /* renamed from: f, reason: collision with root package name */
    private float f285119f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private float f285120g = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private int f285122i = 16;

    /* renamed from: o, reason: collision with root package name */
    private float f285128o = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.f285128o = valueAnimator.getAnimatedFraction();
            b.this.f285114a.invalidate();
        }
    }

    public b(View view) {
        this.f285114a = view;
        h();
    }

    private void c(boolean z16) {
        if (z16 || this.f285119f == 0.0f || this.f285120g == 0.0f) {
            Paint paint = this.f285115b;
            String str = this.f285117d;
            this.f285119f = paint.measureText(str, 0, str.length());
            Paint paint2 = this.f285115b;
            String str2 = this.f285118e;
            this.f285120g = paint2.measureText(str2, 0, str2.length());
        }
        int i3 = this.f285122i & 7;
        if (i3 != 1) {
            if (i3 != 5) {
                float f16 = this.f285116c.left;
                this.f285124k = f16;
                this.f285123j = f16;
            } else {
                int i16 = this.f285116c.right;
                this.f285123j = i16 - this.f285119f;
                this.f285124k = i16 - this.f285120g;
            }
        } else {
            this.f285123j = this.f285116c.centerX() - (this.f285119f / 2.0f);
            this.f285124k = this.f285116c.centerX() - (this.f285120g / 2.0f);
        }
        int i17 = this.f285122i & 112;
        if (i17 != 48) {
            if (i17 != 80) {
                this.f285125l = this.f285116c.centerY() + (((this.f285115b.descent() - this.f285115b.ascent()) / 2.0f) - this.f285115b.descent());
                return;
            } else {
                this.f285125l = this.f285116c.bottom;
                return;
            }
        }
        this.f285125l = this.f285116c.top - this.f285115b.ascent();
    }

    private void h() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f285127n = ofFloat;
        ofFloat.setDuration(500L);
        this.f285127n.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.7f, 1.0f));
        this.f285127n.addUpdateListener(new a());
    }

    private void i() {
        c(false);
        this.f285114a.invalidate();
    }

    public void d(Canvas canvas) {
        int colorForState;
        if (!this.f285129p) {
            return;
        }
        Paint paint = this.f285115b;
        int[] iArr = this.f285126m;
        if (iArr == null) {
            colorForState = this.f285121h.getDefaultColor();
        } else {
            colorForState = this.f285121h.getColorForState(iArr, 0);
        }
        paint.setColor(colorForState);
        Rect rect = this.f285116c;
        float f16 = rect.bottom - rect.top;
        float f17 = this.f285128o * f16;
        int alpha = this.f285115b.getAlpha();
        float f18 = this.f285128o;
        if (f18 < 0.5f) {
            float f19 = alpha;
            this.f285115b.setAlpha((int) ((1.0f - (f18 * 2.0f)) * f19));
            float f26 = this.f285123j;
            float f27 = this.f285125l - f17;
            if (this.f285130q != null) {
                Paint.FontMetrics fontMetrics = this.f285115b.getFontMetrics();
                float f28 = (fontMetrics.bottom - fontMetrics.top) + fontMetrics.leading;
                this.f285130q.setAlpha((int) (f19 * (1.0f - (this.f285128o * 2.0f))));
                e(f26, f27, f28, canvas);
                f26 += this.f285130q.getBounds().width() + ViewUtils.dpToPx(5.0f);
            }
            float f29 = f26;
            String str = this.f285117d;
            canvas.drawText(str, 0, str.length(), f29, f27, this.f285115b);
        } else {
            float f36 = alpha;
            this.f285115b.setAlpha((int) ((f18 - 0.5f) * f36 * 2.0f));
            float f37 = this.f285124k;
            float f38 = (f16 + this.f285125l) - f17;
            if (this.f285130q != null) {
                Paint.FontMetrics fontMetrics2 = this.f285115b.getFontMetrics();
                float f39 = (fontMetrics2.bottom - fontMetrics2.top) + fontMetrics2.leading;
                this.f285130q.setAlpha((int) (f36 * (this.f285128o - 0.5f) * 2.0f));
                e(f37, f38, f39, canvas);
                f37 += this.f285130q.getBounds().width() + ViewUtils.dpToPx(5.0f);
            }
            String str2 = this.f285118e;
            canvas.drawText(str2, 0, str2.length(), f37, f38, this.f285115b);
        }
        this.f285115b.setAlpha(alpha);
    }

    public void e(float f16, float f17, float f18, Canvas canvas) {
        int width = this.f285130q.getBounds().width();
        int height = this.f285130q.getBounds().height();
        int i3 = ((((int) f18) - height) / 2) + ((int) (this.f285115b.getFontMetrics().top + f17));
        if (QLog.isDebugVersion()) {
            QLog.d("AutoHintHelper", 4, "drawFrontDrawable     frontDrawableWidth=", Integer.valueOf(width), "    frontDrawableHeight=", Integer.valueOf(height), "    textHeight=", Float.valueOf(f18), "   drawTextY=", Float.valueOf(f17), "   frontDrawableY=", Integer.valueOf(i3));
        }
        int i16 = (int) f16;
        this.f285130q.setBounds(i16, i3, width + i16, height + i3);
        this.f285130q.draw(canvas);
    }

    public String f() {
        return this.f285118e;
    }

    public boolean g() {
        if (this.f285130q != null) {
            return true;
        }
        return false;
    }

    public void j(int i3) {
        this.f285127n.setDuration(i3);
    }

    public void k(TimeInterpolator timeInterpolator) {
        this.f285127n.setInterpolator(timeInterpolator);
    }

    public void l(int[] iArr) {
        this.f285126m = iArr;
    }

    public void m(Drawable drawable) {
        this.f285130q = drawable;
    }

    public void n(int i3) {
        this.f285122i = i3;
        c(false);
        this.f285114a.invalidate();
    }

    public void o(int i3, int i16, int i17, int i18) {
        Rect rect = this.f285116c;
        if (rect.left != i3 || rect.top != i16 || rect.right != i17 || rect.bottom != i18) {
            rect.set(i3, i16, i17, i18);
            i();
        }
    }

    public void p(String str, boolean z16) {
        this.f285117d = this.f285118e;
        this.f285118e = str;
        if (this.f285127n.isRunning()) {
            this.f285127n.cancel();
        }
        c(true);
        if (z16) {
            this.f285128o = 0.0f;
            this.f285127n.start();
        } else {
            this.f285128o = 1.0f;
            this.f285114a.invalidate();
        }
    }

    public void q(ColorStateList colorStateList) {
        this.f285121h = colorStateList;
    }

    public void r(float f16) {
        this.f285115b.setTextSize(f16);
        c(true);
    }

    public void s(boolean z16) {
        this.f285129p = z16;
        this.f285114a.invalidate();
    }

    public void t(Typeface typeface) {
        this.f285115b.setTypeface(typeface);
        c(true);
    }
}
