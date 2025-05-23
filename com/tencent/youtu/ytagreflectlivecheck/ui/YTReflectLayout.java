package com.tencent.youtu.ytagreflectlivecheck.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTReflectLayout extends RelativeLayout {
    static IPatchRedirector $redirector_ = null;
    private static String TAG = "YTReflectLayout";
    private ColorMatrixColorFilter mColorMatrixColorFilter;
    private Paint mPaint;
    private Rect mRect;

    public YTReflectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mRect = new Rect();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(Color.argb(200, 0, 0, 0));
        this.mColorMatrixColorFilter = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.mPaint.setColorFilter(this.mColorMatrixColorFilter);
        this.mRect.set(0, 0, getWidth(), getHeight());
        canvas.drawRect(this.mRect, this.mPaint);
    }

    public void setColorMatrixColorFilter(ColorMatrixColorFilter colorMatrixColorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) colorMatrixColorFilter);
        } else {
            this.mColorMatrixColorFilter = colorMatrixColorFilter;
            invalidate();
        }
    }
}
