package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CallView extends View {
    static IPatchRedirector $redirector_;
    private long C;

    /* renamed from: d, reason: collision with root package name */
    private Paint f175047d;

    /* renamed from: e, reason: collision with root package name */
    private int f175048e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f175049f;

    /* renamed from: h, reason: collision with root package name */
    private int f175050h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f175051i;

    /* renamed from: m, reason: collision with root package name */
    private long f175052m;

    public CallView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f175047d = null;
        this.f175048e = 0;
        this.f175049f = null;
        this.f175050h = 4;
        this.f175051i = true;
        this.f175052m = 0L;
        this.C = 150L;
        this.f175049f = new RectF();
        Paint paint = new Paint();
        this.f175047d = paint;
        paint.setAntiAlias(true);
        this.f175047d.setStyle(Paint.Style.STROKE);
        this.f175047d.setStrokeWidth(this.f175050h);
        this.f175048e = SupportMenu.CATEGORY_MASK;
    }

    private void a(Canvas canvas) {
        float measuredWidth = getMeasuredWidth() - this.f175050h;
        float measuredHeight = getMeasuredHeight() - this.f175050h;
        RectF rectF = this.f175049f;
        rectF.left = (-measuredWidth) / 3.0f;
        rectF.top = (2.0f * measuredHeight) / 3.0f;
        rectF.right = measuredWidth / 3.0f;
        rectF.bottom = (measuredHeight * 4.0f) / 3.0f;
        this.f175047d.setColor(this.f175048e);
        canvas.drawArc(this.f175049f, -100.0f, 100.0f, false, this.f175047d);
    }

    private void b(Canvas canvas) {
        float measuredWidth = getMeasuredWidth() - this.f175050h;
        float measuredHeight = getMeasuredHeight() - this.f175050h;
        RectF rectF = this.f175049f;
        rectF.left = ((-measuredWidth) * 2.0f) / 3.0f;
        rectF.top = measuredHeight / 3.0f;
        rectF.right = (measuredWidth * 2.0f) / 3.0f;
        rectF.bottom = (measuredHeight * 5.0f) / 3.0f;
        this.f175047d.setColor(this.f175048e);
        canvas.drawArc(this.f175049f, -100.0f, 100.0f, false, this.f175047d);
    }

    private void c(Canvas canvas) {
        float measuredWidth = getMeasuredWidth() - this.f175050h;
        float measuredHeight = getMeasuredHeight();
        int i3 = this.f175050h;
        RectF rectF = this.f175049f;
        rectF.left = -measuredWidth;
        rectF.top = i3;
        rectF.right = measuredWidth;
        rectF.bottom = (measuredHeight - i3) * 2.0f;
        this.f175047d.setColor(this.f175048e);
        canvas.drawArc(this.f175049f, -100.0f, 100.0f, false, this.f175047d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f175051i) {
            if (SystemClock.uptimeMillis() - this.f175052m > this.C * 6) {
                this.f175052m = SystemClock.uptimeMillis();
            } else if (SystemClock.uptimeMillis() - this.f175052m > this.C * 5) {
                a(canvas);
            } else if (SystemClock.uptimeMillis() - this.f175052m > this.C * 4) {
                a(canvas);
                b(canvas);
            } else if (SystemClock.uptimeMillis() - this.f175052m > this.C * 3) {
                a(canvas);
                b(canvas);
                c(canvas);
            } else if (SystemClock.uptimeMillis() - this.f175052m > this.C * 2) {
                a(canvas);
                b(canvas);
            } else if (SystemClock.uptimeMillis() - this.f175052m > this.C) {
                a(canvas);
            }
            postInvalidateDelayed(150L);
        }
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f175048e = i3;
        }
    }
}
