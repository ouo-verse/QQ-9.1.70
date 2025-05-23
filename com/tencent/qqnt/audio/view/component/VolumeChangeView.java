package com.tencent.qqnt.audio.view.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import px3.a;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VolumeChangeView extends View {
    static IPatchRedirector $redirector_;
    private int C;
    private Paint D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;

    /* renamed from: d, reason: collision with root package name */
    private boolean f352643d;

    /* renamed from: e, reason: collision with root package name */
    private int f352644e;

    /* renamed from: f, reason: collision with root package name */
    private int f352645f;

    /* renamed from: h, reason: collision with root package name */
    private int f352646h;

    /* renamed from: i, reason: collision with root package name */
    private int f352647i;

    /* renamed from: m, reason: collision with root package name */
    public int[] f352648m;

    public VolumeChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f352643d = true;
        this.f352644e = 0;
        this.f352645f = 0;
        this.f352646h = 0;
        this.f352647i = 0;
        this.C = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f427977p4);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void a(TypedArray typedArray) {
        boolean z16 = false;
        if (typedArray.getInt(a.f427983q4, 0) == 0) {
            z16 = true;
        }
        this.f352643d = z16;
        this.f352644e = typedArray.getInt(a.f427989r4, 5);
        this.f352645f = (int) typedArray.getDimension(a.f428001t4, 8.0f);
        this.f352646h = (int) typedArray.getDimension(a.f427995s4, 48.0f);
        this.I = (int) typedArray.getDimension(a.f428007u4, 0.0f);
        this.f352647i = getResources().getColor(R.color.b6j);
        this.G = getResources().getColor(R.color.b6i);
        this.H = getResources().getDimensionPixelOffset(R.dimen.b2d);
        this.f352648m = new int[this.f352644e];
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        int[] iArr = this.f352648m;
        if (iArr != null) {
            Arrays.fill(iArr, 0);
            this.C = 0;
        }
        invalidate();
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.F = i3;
        if (i3 < 1) {
            this.F = 1;
        }
        if (this.F > 10) {
            this.F = 10;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        for (int i16 = 0; i16 < this.f352644e; i16++) {
            float f16 = 0.0f;
            if (this.f352643d) {
                if (i16 < this.F) {
                    this.D.setColor(this.G);
                } else {
                    this.D.setColor(this.f352647i);
                }
                if (i16 != 0) {
                    i3 = (this.H + this.f352645f) * i16;
                    f16 = i3;
                    int i17 = this.E;
                    int i18 = this.f352646h;
                    RectF rectF = new RectF(f16, i17 - (i18 / 2.0f), this.f352645f + f16, i17 + (i18 / 2.0f));
                    float f17 = this.I;
                    canvas.drawRoundRect(rectF, f17, f17, this.D);
                } else {
                    int i172 = this.E;
                    int i182 = this.f352646h;
                    RectF rectF2 = new RectF(f16, i172 - (i182 / 2.0f), this.f352645f + f16, i172 + (i182 / 2.0f));
                    float f172 = this.I;
                    canvas.drawRoundRect(rectF2, f172, f172, this.D);
                }
            } else {
                if (i16 < this.F) {
                    this.D.setColor(this.G);
                } else {
                    this.D.setColor(this.f352647i);
                }
                int i19 = this.f352644e;
                if (i16 != i19 - 1) {
                    i3 = ((i19 - 1) - i16) * (this.H + this.f352645f);
                    f16 = i3;
                    int i1722 = this.E;
                    int i1822 = this.f352646h;
                    RectF rectF22 = new RectF(f16, i1722 - (i1822 / 2.0f), this.f352645f + f16, i1722 + (i1822 / 2.0f));
                    float f1722 = this.I;
                    canvas.drawRoundRect(rectF22, f1722, f1722, this.D);
                } else {
                    int i17222 = this.E;
                    int i18222 = this.f352646h;
                    RectF rectF222 = new RectF(f16, i17222 - (i18222 / 2.0f), this.f352645f + f16, i17222 + (i18222 / 2.0f));
                    float f17222 = this.I;
                    canvas.drawRoundRect(rectF222, f17222, f17222, this.D);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int i17 = this.f352644e;
        int i18 = this.f352645f;
        int i19 = this.H;
        setMeasuredDimension(((i17 * (i18 + i19)) - i19) + getPaddingLeft() + getPaddingRight(), this.f352646h + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        this.E = i16 / 2;
        if (this.D == null) {
            Paint paint = new Paint();
            this.D = paint;
            paint.setStyle(Paint.Style.FILL);
            this.D.setColor(this.f352647i);
        }
        invalidate();
    }

    public void setBgColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f352647i = i3;
        }
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.G = i3;
        Paint paint = this.D;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    public void setCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        this.f352644e = i3;
        this.f352648m = new int[i3];
        requestLayout();
    }
}
