package com.tencent.mobileqq.qqlive.anchor.beauty.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveLoadingView extends AppCompatTextView {
    static IPatchRedirector $redirector_;
    private final Paint C;
    private final RectF D;
    private float E;
    private float F;
    private int G;
    private int H;
    private int I;

    /* renamed from: h, reason: collision with root package name */
    private int f270557h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f270558i;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f270559m;

    public QQLiveLoadingView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f270557h = 0;
        this.f270558i = new Paint(1);
        this.f270559m = new Paint(1);
        this.C = new Paint(1);
        this.D = new RectF();
        this.E = -90.0f;
        this.F = 0.0f;
        this.G = 8;
        this.H = 0;
        this.I = 0;
        initView(context, null, 0);
    }

    private void initView(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, hi2.a.f405104r4, i3, 0);
        this.G = obtainStyledAttributes.getDimensionPixelSize(hi2.a.f405113s4, this.G);
        this.H = obtainStyledAttributes.getColor(hi2.a.f405122t4, getResources().getColor(R.color.chy));
        this.I = obtainStyledAttributes.getColor(hi2.a.f405131u4, getResources().getColor(R.color.chz));
        obtainStyledAttributes.recycle();
        this.f270558i.setColor(this.H);
        this.f270559m.setColor(this.I);
        this.f270559m.setStrokeWidth(this.G);
        this.f270559m.setStyle(Paint.Style.STROKE);
        this.C.setColor(-1);
        this.C.setStrokeWidth(this.G);
        this.C.setStyle(Paint.Style.STROKE);
        setProgress(0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        float f16 = min / 2.0f;
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f270558i);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, f16, this.f270559m);
        this.D.set((getWidth() / 2.0f) - f16, (getHeight() / 2.0f) - f16, (getWidth() / 2.0f) + f16, (getHeight() / 2.0f) + f16);
        float f17 = (this.f270557h * 360) / 100.0f;
        this.F = f17;
        canvas.drawArc(this.D, this.E, f17, false, this.C);
        super.onDraw(canvas);
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 > 100) {
            i3 = 100;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        this.f270557h = i3;
        setText(i3 + "%");
        requestLayout();
    }

    public void setProgressOnly(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 > 100) {
            i3 = 100;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        this.f270557h = i3;
        setText("");
        requestLayout();
    }

    public QQLiveLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f270557h = 0;
        this.f270558i = new Paint(1);
        this.f270559m = new Paint(1);
        this.C = new Paint(1);
        this.D = new RectF();
        this.E = -90.0f;
        this.F = 0.0f;
        this.G = 8;
        this.H = 0;
        this.I = 0;
        initView(context, attributeSet, 0);
    }

    public QQLiveLoadingView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f270557h = 0;
        this.f270558i = new Paint(1);
        this.f270559m = new Paint(1);
        this.C = new Paint(1);
        this.D = new RectF();
        this.E = -90.0f;
        this.F = 0.0f;
        this.G = 8;
        this.H = 0;
        this.I = 0;
        initView(context, attributeSet, i3);
    }
}
