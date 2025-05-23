package com.tencent.relation.common.widget.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CircleIndicator extends BaseIndicator {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private int f364832h;

    /* renamed from: i, reason: collision with root package name */
    private int f364833i;

    /* renamed from: m, reason: collision with root package name */
    private int f364834m;

    public CircleIndicator(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int f16;
        int g16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int c16 = this.f364829d.c();
        if (c16 <= 1) {
            return;
        }
        float f17 = 0.0f;
        for (int i16 = 0; i16 < c16; i16++) {
            Paint paint = this.f364830e;
            if (this.f364829d.a() == i16) {
                f16 = this.f364829d.h();
            } else {
                f16 = this.f364829d.f();
            }
            paint.setColor(f16);
            if (this.f364829d.a() == i16) {
                g16 = this.f364829d.i();
            } else {
                g16 = this.f364829d.g();
            }
            if (this.f364829d.a() == i16) {
                i3 = this.f364833i;
            } else {
                i3 = this.f364832h;
            }
            float f18 = i3;
            canvas.drawCircle(f17 + f18, this.f364834m, f18, this.f364830e);
            f17 += g16 + this.f364829d.d();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int c16 = this.f364829d.c();
        if (c16 <= 1) {
            return;
        }
        this.f364832h = this.f364829d.g() / 2;
        int i17 = this.f364829d.i() / 2;
        this.f364833i = i17;
        this.f364834m = Math.max(i17, this.f364832h);
        int i18 = c16 - 1;
        setMeasuredDimension((this.f364829d.d() * i18) + this.f364829d.i() + (this.f364829d.g() * i18), Math.max(this.f364829d.g(), this.f364829d.i()));
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f364832h = this.f364829d.g() / 2;
            this.f364833i = this.f364829d.i() / 2;
        }
    }
}
