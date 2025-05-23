package com.tencent.could.huiyansdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanReflectLayout extends ConstraintLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Paint f100339a;

    /* renamed from: b, reason: collision with root package name */
    public ColorMatrixColorFilter f100340b;

    /* renamed from: c, reason: collision with root package name */
    public Rect f100341c;

    public HuiYanReflectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            a();
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Paint paint = new Paint(1);
        this.f100339a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f100340b = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f100341c = new Rect();
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.f100339a.setColorFilter(this.f100340b);
        this.f100341c.set(0, 0, getWidth(), getHeight());
        canvas.drawRect(this.f100341c, this.f100339a);
    }
}
