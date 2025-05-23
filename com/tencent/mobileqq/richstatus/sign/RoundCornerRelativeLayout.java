package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RoundCornerRelativeLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Path f282404d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f282405e;

    /* renamed from: f, reason: collision with root package name */
    private float f282406f;

    /* renamed from: h, reason: collision with root package name */
    private PaintFlagsDrawFilter f282407h;

    /* renamed from: i, reason: collision with root package name */
    private int f282408i;

    /* renamed from: m, reason: collision with root package name */
    private int f282409m;

    public RoundCornerRelativeLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void a() {
        this.f282404d = new Path();
        this.f282405e = new RectF();
        this.f282407h = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        canvas.save();
        if (this.f282408i != getMeasuredWidth() || this.f282409m != getMeasuredHeight()) {
            this.f282408i = getMeasuredWidth();
            this.f282409m = getMeasuredHeight();
            this.f282404d.reset();
            this.f282405e.set(0.0f, 0.0f, this.f282408i, this.f282409m);
            Path path = this.f282404d;
            RectF rectF = this.f282405e;
            float f16 = this.f282406f;
            path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        }
        canvas.setDrawFilter(this.f282407h);
        canvas.clipPath(this.f282404d);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.f282406f = f16;
        }
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
