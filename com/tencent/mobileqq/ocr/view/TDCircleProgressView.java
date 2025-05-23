package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class TDCircleProgressView extends View {
    static IPatchRedirector $redirector_;
    private int C;
    private float D;
    private Context E;

    /* renamed from: d, reason: collision with root package name */
    private int f254913d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f254914e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f254915f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f254916h;

    /* renamed from: i, reason: collision with root package name */
    private float f254917i;

    /* renamed from: m, reason: collision with root package name */
    private int f254918m;

    public TDCircleProgressView(Context context) {
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

    private void b(Context context, AttributeSet attributeSet) {
        this.E = context;
        this.C = 2;
        this.f254917i = a(context, 4.0f);
        Paint paint = new Paint();
        this.f254914e = paint;
        paint.setAntiAlias(true);
        this.f254914e.setStrokeWidth(this.f254917i);
        this.f254914e.setStyle(Paint.Style.STROKE);
        this.f254914e.setColor(Color.rgb(144, 144, 144));
        this.f254914e.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f254915f = paint2;
        paint2.setAntiAlias(true);
        this.f254915f.setStyle(Paint.Style.STROKE);
        this.f254915f.setStrokeWidth(this.f254917i);
        this.f254915f.setColor(this.f254918m);
        this.f254915f.setStrokeCap(Paint.Cap.ROUND);
        int i3 = this.C;
        if (i3 == 1) {
            this.D = -180.0f;
        } else if (i3 == 2) {
            this.D = -90.0f;
        } else if (i3 == 3) {
            this.D = 0.0f;
        } else if (i3 == 4) {
            this.D = 90.0f;
        }
        Paint paint3 = new Paint();
        this.f254916h = paint3;
        paint3.setTextSize(a(context, 11.0f));
        this.f254916h.setTextAlign(Paint.Align.CENTER);
        this.f254916h.setStyle(Paint.Style.FILL);
        this.f254916h.setColor(Color.rgb(144, 144, 144));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        float f16 = this.f254917i;
        RectF rectF = new RectF(f16 / 2.0f, f16 / 2.0f, getWidth() - (this.f254917i / 2.0f), getHeight() - (this.f254917i / 2.0f));
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f254914e);
        canvas.drawArc(rectF, this.D, (this.f254913d * 360) / 100, false, this.f254915f);
        canvas.drawText(this.f254913d + "%", getWidth() / 2, (getHeight() / 2) + a(this.E, 4.0f), this.f254916h);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (size >= size2) {
            size = size2;
        }
        setMeasuredDimension(size, size);
    }

    public void setCurrent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f254913d = i3;
            invalidate();
        }
    }

    public TDCircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TDCircleProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f254918m = Color.rgb(107, 203, 250);
            b(context, attributeSet);
        }
    }
}
