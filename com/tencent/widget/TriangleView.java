package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TriangleView extends View {
    static IPatchRedirector $redirector_;
    boolean firstDraw;
    Paint mPaint;
    Path mPath;

    public TriangleView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static float convertDpToPixel(Context context, float f16) {
        return f16 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.firstDraw) {
            float width = getWidth();
            float f16 = 0.55f * width;
            float f17 = width / 2.0f;
            float f18 = f16 / 2.0f;
            float height = getHeight() / 2.0f;
            float f19 = f16 * 1.73205f;
            float f26 = height - (f19 / 6.0f);
            this.mPath.moveTo(f17 - f18, f26);
            this.mPath.lineTo(f18 + f17, f26);
            this.mPath.lineTo(f17, height + (f19 / 3.0f));
            this.mPath.close();
            this.firstDraw = false;
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mPaint.setColor(i3);
        }
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.firstDraw = true;
        this.mPaint.setColor(-1);
        this.mPaint.setPathEffect(new CornerPathEffect(convertDpToPixel(context, 2.0f)));
    }
}
