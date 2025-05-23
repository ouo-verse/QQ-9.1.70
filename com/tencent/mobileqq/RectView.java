package com.tencent.mobileqq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RectView extends View {
    static IPatchRedirector $redirector_;
    private Paint mPaint;

    public RectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mPaint = new Paint(1);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.mPaint.setColor(Color.parseColor("#00a5e0"));
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(8.0f);
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        float f16 = 1;
        float f17 = 51;
        canvas.drawLine(f16, f16, f17, f16, this.mPaint);
        canvas.drawLine(f16, f16, f16, f17, this.mPaint);
        float f18 = height;
        float f19 = height - 50;
        canvas.drawLine(f16, f18, f16, f19, this.mPaint);
        canvas.drawLine(f16, f18, f17, f18, this.mPaint);
        float f26 = width;
        float f27 = width - 50;
        canvas.drawLine(f26, f16, f27, f16, this.mPaint);
        canvas.drawLine(f26, f16, f26, f17, this.mPaint);
        canvas.drawLine(f26, f18, f26, f19, this.mPaint);
        canvas.drawLine(f26, f18, f27, f18, this.mPaint);
    }
}
