package com.tencent.mobileqq.trooponline.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RoundTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected int f303262d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f303263e;

    /* renamed from: f, reason: collision with root package name */
    protected RectF f303264f;

    public RoundTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f303262d = -1;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        if (this.f303263e == null) {
            Paint paint = new Paint();
            this.f303263e = paint;
            paint.setAntiAlias(true);
        }
        this.f303263e.setColor(this.f303262d);
        if (this.f303264f == null) {
            this.f303264f = new RectF();
        }
        this.f303264f.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRoundRect(this.f303264f, getMeasuredHeight() / 2, getMeasuredHeight() / 2, this.f303263e);
        super.onDraw(canvas);
    }

    public void setRoundBgColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f303262d = i3;
            invalidate();
        }
    }

    public RoundTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f303262d = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundTextView);
        this.f303262d = obtainStyledAttributes.getColor(R.styleable.RoundTextView_round_bg_color, R.color.f158017al3);
        obtainStyledAttributes.recycle();
    }
}
