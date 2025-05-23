package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class GradientProgressView extends View {
    static IPatchRedirector $redirector_;
    RectF C;

    /* renamed from: d, reason: collision with root package name */
    int f302334d;

    /* renamed from: e, reason: collision with root package name */
    int f302335e;

    /* renamed from: f, reason: collision with root package name */
    SweepGradient f302336f;

    /* renamed from: h, reason: collision with root package name */
    int f302337h;

    /* renamed from: i, reason: collision with root package name */
    int f302338i;

    /* renamed from: m, reason: collision with root package name */
    Paint f302339m;

    public GradientProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302334d = 5;
        this.f302335e = 0;
        this.f302337h = 0;
        this.f302338i = -1;
        this.f302339m = new Paint();
    }

    private void a(int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            this.f302336f = new SweepGradient(i3 / 2, i16 / 2, new int[]{this.f302337h, this.f302338i}, new float[]{0.0f, 1.0f});
            int i17 = this.f302334d;
            this.C = new RectF(i17, i17, i3 - i17, i16 - i17);
            this.f302339m.setStrokeWidth(this.f302334d);
            this.f302339m.setAntiAlias(true);
            this.f302339m.setStyle(Paint.Style.STROKE);
            this.f302339m.setShader(this.f302336f);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f302336f == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i3 = this.f302335e + 3;
        this.f302335e = i3;
        if (i3 > 360) {
            this.f302335e = i3 - 360;
        }
        canvas.rotate(this.f302335e, width / 2, height / 2);
        canvas.drawArc(this.C, 0.0f, 360.0f, true, this.f302339m);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onSizeChanged(i3, i16, i17, i18);
            a(i3, i16);
        }
    }

    public void setEndColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f302338i = i3;
            a(getWidth(), getHeight());
        }
    }

    public void setStartColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f302337h = i3;
            a(getWidth(), getHeight());
        }
    }

    public GradientProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302334d = 5;
        this.f302335e = 0;
        this.f302337h = 0;
        this.f302338i = -1;
        this.f302339m = new Paint();
    }
}
