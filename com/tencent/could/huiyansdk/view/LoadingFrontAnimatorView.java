package com.tencent.could.huiyansdk.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LoadingFrontAnimatorView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public float f100342a;

    /* renamed from: b, reason: collision with root package name */
    public ValueAnimator f100343b;

    /* renamed from: c, reason: collision with root package name */
    public Point f100344c;

    /* renamed from: d, reason: collision with root package name */
    public int f100345d;

    /* renamed from: e, reason: collision with root package name */
    public int f100346e;

    /* renamed from: f, reason: collision with root package name */
    public int f100347f;

    /* renamed from: g, reason: collision with root package name */
    public int f100348g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f100349h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f100350i;

    /* renamed from: j, reason: collision with root package name */
    public Paint f100351j;

    /* renamed from: k, reason: collision with root package name */
    public Path f100352k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f100353l;

    public LoadingFrontAnimatorView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f100353l = true;
        setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f100343b = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.could.huiyansdk.view.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingFrontAnimatorView.this.a(valueAnimator);
            }
        });
        this.f100343b.setDuration(2000L);
        this.f100343b.setRepeatMode(1);
        this.f100343b.setRepeatCount(-1);
        this.f100343b.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (!this.f100353l) {
            canvas.drawPath(this.f100352k, this.f100351j);
            return;
        }
        canvas.save();
        float f16 = this.f100342a * 360.0f;
        Point point = this.f100344c;
        canvas.rotate(f16, point.x, point.y);
        for (int i3 = 0; i3 <= 360; i3++) {
            if (i3 < 270) {
                a16 = a(i3 / 270.0f, this.f100345d, this.f100347f);
            } else {
                a16 = a((i3 - 270) / 90.0f, this.f100347f, this.f100346e);
            }
            this.f100349h.setColor(a16);
            canvas.drawArc(this.f100350i, i3, 1.0f, false, this.f100349h);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        Point point = this.f100344c;
        int i17 = size >> 1;
        point.x = i17;
        int i18 = size2 >> 1;
        point.y = i18;
        if (i17 > i18) {
            i17 = i18;
        }
        setMeasuredDimension(size, size2);
        int dpToPx = i17 - CommonUtils.dpToPx(this, 1.9f);
        Point point2 = this.f100344c;
        int i19 = point2.x;
        int i26 = point2.y;
        this.f100350i = new RectF(i19 - dpToPx, i26 - dpToPx, i19 + dpToPx, i26 + dpToPx);
        this.f100352k.reset();
        Path path = this.f100352k;
        Point point3 = this.f100344c;
        path.addCircle(point3.x, point3.y, dpToPx, Path.Direction.CCW);
    }

    public LoadingFrontAnimatorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f100342a = 0.0f;
        this.f100353l = false;
        a();
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f100344c = new Point();
        this.f100345d = getResources().getColor(R.color.cwq);
        this.f100347f = getResources().getColor(R.color.cwp);
        this.f100346e = getResources().getColor(R.color.cwo);
        Paint paint = new Paint(1);
        this.f100349h = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f100349h.setColor(this.f100347f);
        this.f100349h.setStyle(Paint.Style.STROKE);
        this.f100349h.setStrokeWidth(CommonUtils.dpToPx(this, 3.5f));
        this.f100352k = new Path();
        this.f100351j = new Paint(1);
        int color = getResources().getColor(R.color.f158007cx1);
        this.f100348g = color;
        this.f100351j.setColor(color);
        this.f100351j.setStyle(Paint.Style.STROKE);
        this.f100351j.setStrokeWidth(CommonUtils.dpToPx(this, 3.5f));
    }

    public int a(float f16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        int alpha = Color.alpha(i3);
        int red = Color.red(i3);
        int blue = Color.blue(i3);
        return Color.argb((int) (alpha + ((Color.alpha(i16) - alpha) * f16)), (int) (red + ((Color.red(i16) - red) * f16)), (int) (Color.green(i3) + (f16 * (Color.green(i16) - r8))), (int) (blue + ((Color.blue(i16) - blue) * f16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue < 0.0f || floatValue > 1.0f) {
            return;
        }
        this.f100342a = floatValue;
        invalidate();
    }
}
