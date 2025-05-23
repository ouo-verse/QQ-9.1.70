package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class CircleProgressView extends View {
    static IPatchRedirector $redirector_;
    private Paint C;

    /* renamed from: d, reason: collision with root package name */
    private int f236931d;

    /* renamed from: e, reason: collision with root package name */
    private int f236932e;

    /* renamed from: f, reason: collision with root package name */
    private int f236933f;

    /* renamed from: h, reason: collision with root package name */
    private int f236934h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f236935i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f236936m;

    public CircleProgressView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static int a(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void b() {
        setMeasureSize(a(getContext(), 50.0f), a(getContext(), 50.0f));
        setCircleWidth(a(getContext(), 2.0f));
    }

    private void c() {
        Paint paint = new Paint();
        this.f236935i = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f236935i.setAntiAlias(true);
        this.f236935i.setARGB(255, 18, 183, 245);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setAntiAlias(true);
        this.C.setARGB(89, 78, 76, 67);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        float width = getWidth() / 2;
        int i3 = this.f236933f;
        float f16 = width - i3;
        RectF rectF = this.f236936m;
        float f17 = width - f16;
        rectF.left = f17 - (i3 / 2);
        rectF.top = f17 - (i3 / 2);
        float f18 = f16 + width;
        rectF.right = (i3 / 2) + f18;
        rectF.bottom = f18 + (i3 / 2);
        this.f236935i.setStrokeWidth(i3);
        canvas.drawCircle(width, width, width, this.C);
        canvas.save();
        canvas.drawArc(this.f236936m, 270.0f, this.f236934h * 3.6f, false, this.f236935i);
        canvas.restore();
        postInvalidateDelayed(20L);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            setMeasuredDimension(this.f236931d, this.f236932e);
        }
    }

    public void setCircleWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f236933f = i3;
        }
    }

    public void setMeasureSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f236931d = i3;
            this.f236932e = i16;
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 < 0 || i3 > 100) {
            i3 = 0;
        }
        this.f236934h = i3;
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f236933f = 50;
        this.f236934h = 0;
        this.f236936m = new RectF();
        this.C = new Paint();
        c();
        b();
    }
}
