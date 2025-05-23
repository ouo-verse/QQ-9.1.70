package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BoxShadow extends FrameLayout {
    static IPatchRedirector $redirector_;
    private int C;

    /* renamed from: d, reason: collision with root package name */
    RectF f282394d;

    /* renamed from: e, reason: collision with root package name */
    Paint f282395e;

    /* renamed from: f, reason: collision with root package name */
    int f282396f;

    /* renamed from: h, reason: collision with root package name */
    int f282397h;

    /* renamed from: i, reason: collision with root package name */
    int f282398i;

    /* renamed from: m, reason: collision with root package name */
    private int f282399m;

    public BoxShadow(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f282395e = new Paint();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        RectF rectF = this.f282394d;
        if (rectF != null) {
            int i3 = this.f282397h;
            canvas.drawRoundRect(rectF, i3, i3, this.f282395e);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f282394d == null || this.f282399m != getMeasuredWidth() || this.C != getMeasuredHeight()) {
            float f16 = (int) (this.f282398i * 0.5f);
            this.f282394d = new RectF(f16, f16, getMeasuredWidth() - r5, getMeasuredHeight() - (1.15f * f16));
            this.f282399m = getMeasuredWidth();
            this.C = getMeasuredHeight();
        }
    }

    public void setShadowColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else if (this.f282396f != i3) {
            this.f282396f = i3;
            this.f282395e.setColor(i3);
        }
    }

    public BoxShadow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f282395e = new Paint();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public BoxShadow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f282395e = new Paint();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    public BoxShadow(Context context, int i3, int i16, int i17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Paint paint = new Paint();
        this.f282395e = paint;
        this.f282397h = i16;
        this.f282398i = i3;
        this.f282396f = i17;
        paint.setColor(i17);
        this.f282395e.setStyle(Paint.Style.FILL);
        this.f282395e.setMaskFilter(new BlurMaskFilter((int) (i3 * 0.5f), BlurMaskFilter.Blur.NORMAL));
        setLayerType(1, null);
    }
}
