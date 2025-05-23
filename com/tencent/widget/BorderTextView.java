package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BorderTextView extends SimpleTextView {
    static IPatchRedirector $redirector_;
    private int mBorderWidth;
    private int mColor;
    private Paint mPaint;
    private float mRadius;

    public BorderTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mBorderWidth = 0;
        this.mRadius = 0.0f;
        this.mColor = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.SimpleTextView, android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        int i3 = this.mBorderWidth;
        RectF rectF = new RectF(i3, i3, getMeasuredWidth() - this.mBorderWidth, getMeasuredHeight() - this.mBorderWidth);
        float f16 = this.mRadius;
        canvas.drawRoundRect(rectF, f16, f16, this.mPaint);
    }

    public void setBorderColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mColor = i3;
        }
    }

    public void setBorderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mBorderWidth = i3;
            this.mRadius = i3;
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mRadius = f16;
        }
    }

    public BorderTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mBorderWidth = 0;
        this.mRadius = 0.0f;
        this.mColor = 0;
    }

    public BorderTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mBorderWidth = 0;
        this.mRadius = 0.0f;
        this.mColor = 0;
    }
}
