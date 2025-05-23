package com.tencent.mobileqq.olympic.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ARTipsCircleProgress extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f255110d;

    /* renamed from: e, reason: collision with root package name */
    private int f255111e;

    /* renamed from: f, reason: collision with root package name */
    private int f255112f;

    /* renamed from: h, reason: collision with root package name */
    private int f255113h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f255114i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f255115m;

    public ARTipsCircleProgress(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f255114i == null) {
            Paint paint = new Paint();
            this.f255114i = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f255114i.setStrokeWidth(this.f255111e);
            this.f255114i.setAntiAlias(true);
        }
        if (this.f255115m != null) {
            this.f255114i.setColor(this.f255113h);
            canvas.drawArc(this.f255115m, -90.0f, 360.0f, false, this.f255114i);
            this.f255114i.setColor(this.f255112f);
            canvas.drawArc(this.f255115m, -90.0f, (this.f255110d / 100.0f) * 360.0f, false, this.f255114i);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.f255115m == null) {
            this.f255115m = new RectF();
        }
        int width = getWidth();
        int height = getHeight();
        RectF rectF = this.f255115m;
        int i19 = this.f255111e;
        rectF.left = i19 / 2;
        rectF.top = i19 / 2;
        rectF.right = width - (i19 / 2);
        rectF.bottom = height - (i19 / 2);
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f255110d = i3;
        setText(this.f255110d + "%");
    }

    public ARTipsCircleProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ARTipsCircleProgress(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f255111e = 8;
        this.f255112f = getResources().getColor(R.color.f156828cl);
        this.f255113h = -1;
    }
}
